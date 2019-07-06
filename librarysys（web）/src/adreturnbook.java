

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class adreturnbook
 */
@WebServlet("/adreturnbook")
public class adreturnbook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adreturnbook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
       
      
		String p1=request.getParameter("bookid");
        PrintWriter out = response.getWriter();
		
		
		SimpleDateFormat time0=new  SimpleDateFormat("yyyy-MM-dd");
		String nowtime=time0.format(new Date());
		out.print(nowtime);
		Connection con=connectionace.getConection();
		int flag=-1;//0表示这本书没被借出，无法归还,1表示被借出，可以归还，-1表示这本书不在图书馆，不用归还
		//查询这本书是否被借出
        try {
            
            String sql0="select * from bookinfo  where bookid=?";
            
            PreparedStatement pst=con.prepareStatement(sql0);
            pst.setString(1, p1);
            ResultSet result=pst.executeQuery();
            
            while (result.next()) {
            	
            	int state=result.getInt("state");
            	if (state==1)
            	{
            		flag=0;
            	}
            	if(state==0)
            		flag=1;
 	
            }
            System.out.println(flag);
            pst.close();
            
           
        } catch (SQLException e) {
            System.out.println(e);
        }
        if(flag==0)
        {
        	request.setAttribute("tip","这本书并没有被借出，无法归还，请确认图书编号");
			
			request.getRequestDispatcher("adreturnbook.jsp").forward(request, response);
        }
        if(flag==-1)
        {
        	request.setAttribute("tip","这本书不属于本图书馆，不用归还，请确认图书编号");
			
			request.getRequestDispatcher("adreturnbook.jsp").forward(request, response);
        }
        //尝试归还
        if(flag==1)
        {
        	flag=0;
        	//修改bookinfo表
	        try {
	            
	        	String sql0="update bookinfo set state=? where bookid=?";
	            
	            PreparedStatement pst=con.prepareStatement(sql0);
	           
	            
	            pst.setInt(1, 1);
	            pst.setString(2,p1);
	           
	            flag=pst.executeUpdate();
	            
	            System.out.println(flag);
	            pst.close();
	           
	            
	           
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
			
			
			if(flag==1){
				//bookinfo修改成功，开始修改borrowrecords表中的书的借阅状态和userinfo中读者的已借数量
				flag=0;
				int lendnum=-1;
				//查询是谁借阅了这本书
				String userid="空";
				
                   try {
		            
		            String sql0="select * from borrowrecords  where bookid=? and state=?";
		            
		            PreparedStatement pst=con.prepareStatement(sql0);
		            pst.setString(1, p1);
		            pst.setInt(2, 0);
		            ResultSet result=pst.executeQuery();
		            
		            while (result.next()) {
		            	
		            	String temp=result.getString("userid");
		            	userid=temp;
		            	break;
		 	
		            }
		            System.out.println(flag);
		            pst.close();
		            
		           
		        } catch (SQLException e) {
		            System.out.println(e);
		        }
				
				
				if(userid.equals("空"))
				{
					request.setAttribute("tip","归还失败1");
					
					request.getRequestDispatcher("adreturnbook.jsp").forward(request, response);
					
				}
				
				else{
					//查询已经借阅了多少书
			        try {
			            
			            String sql0="select * from userinfo  where userid=?";
			            
			            PreparedStatement pst=con.prepareStatement(sql0);
			            pst.setString(1, userid);
			            ResultSet result=pst.executeQuery();
			            
			            while (result.next()) {
			            	
			            	int temp=result.getInt("lendednum");
			            	lendnum=temp;
			            	break;
			 	
			            }
			            System.out.println(flag);
			            pst.close();
			            
			           
			        } catch (SQLException e) {
			            System.out.println(e);
			        }
			        //修改书的借阅信息表和人的借阅总数
			        try {
			            
			            String sql0="update userinfo set lendednum=? where userid=?";
			            
			            PreparedStatement pst=con.prepareStatement(sql0);
			            pst.setInt(1, lendnum-1);
			            pst.setString(2, userid);
			           
			            pst.executeUpdate();
			            
			            
			            System.out.println(flag);
			            pst.close();
			            
			           
			        } catch (SQLException e) {
			            System.out.println(e);
			        }
                    try {
			            
			            String sql0="update borrowrecords set state=?,returntime=? where bookid=? and state=?";
			            
			            PreparedStatement pst=con.prepareStatement(sql0);
			            pst.setInt(1, 1);
			            pst.setString(2, nowtime);
			            pst.setString(3, p1);
			            pst.setInt(4, 0);
			            flag=pst.executeUpdate();
			            out.print("flag");
			            out.print(flag);
			            
			            System.out.println(flag);
			            pst.close();
			            
			           
			        } catch (SQLException e) {
			            System.out.println(e);
			        }
					if(flag==1)
					{
						out.print("归还成功");
						request.setAttribute("tip", "图书归还成功");
						request.getRequestDispatcher("adreturnbook.jsp").forward(request, response);
					}
					else
					{
						out.print("归还失败");
						request.setAttribute("tip", "图书归还失败2");
						request.getRequestDispatcher("adreturnbook.jsp").forward(request, response);
						
					}
			    }
			}
			else{
				out.print("归还失败");
				request.setAttribute("tip", "图书归还失败3");
				request.getRequestDispatcher("adreturnbook.jsp").forward(request, response);
			}
		
        	
        	
        	
        }
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
