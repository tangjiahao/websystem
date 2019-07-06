

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alljavabean.bookadmin;
import alljavabean.borrowrecord;

/**
 * Servlet implementation class adborrowbook
 */
@WebServlet("/adborrowbook")
public class adborrowbook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adborrowbook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
       
      
		String p1=request.getParameter("borrowid");
		String p2=request.getParameter("bookid");
		String p3=request.getParameter("borrowid2");
		String p4=request.getParameter("bookid2");
		String p5=request.getParameter("bookname");
		
		PrintWriter out = response.getWriter();
		
		
		SimpleDateFormat time0=new  SimpleDateFormat("yyyy-MM-dd");
		String nowtime=time0.format(new Date());
		out.print(nowtime);
		
		
//		out.print(p1);
//		out.print(p2);
//		out.print(p3);
//		out.print(p4);
		
		int flag=0;
		Connection con=connectionace.getConection();
		//处理验证里的表单信息
		if(p3==null&&p4==null&&p5==null)
		{
			int max=-1,lendnum=-1,state=-1;
	        try {
	            
	        	String sql0="select * from userinfo where userid=?";
	            
	            PreparedStatement pst=con.prepareStatement(sql0);
	           
	            pst.setString(1, p1);
	            
	           
	            ResultSet result=pst.executeQuery();
	            
	            while (result.next()) {
	            	flag=1;
	            	max=result.getInt("max");
	            	lendnum=result.getInt("lendednum");
	            }
	            
	            System.out.println(flag);
	            pst.close();
	           
	            
	           
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
			
            try {
	            
	        	String sql0="select * from bookinfo where bookid=?";
	            
	            PreparedStatement pst=con.prepareStatement(sql0);
	           
	            pst.setString(1, p2);
	            
	           
	            ResultSet result=pst.executeQuery();
	            
	            while (result.next()) {
	            	p5=result.getString("bookname");
	            	state=result.getInt("state");
	            	
	            }
	            
	            System.out.println(flag);
	            pst.close();
	           
	            
	           
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	        
	        
			if(flag==1){
				//读者可借且图书存在且在库
				if(max>lendnum && state==1)
				{
					String tip="该读者可借阅:"+Integer.toString(max)+",已经借阅:"+Integer.toString(lendnum)+",可以继续借阅本图书";
					out.print(tip);
					ArrayList<borrowrecord> list=new ArrayList<borrowrecord>();
					try {
			            
			        	String sql0="select * from borrowrecords where userid=? and state=?";
			            
			            PreparedStatement pst=con.prepareStatement(sql0);
			            pst.setInt(2,0);
			            pst.setString(1, p1);
			             
			           
			            ResultSet result=pst.executeQuery();
			            
			            while (result.next()) {
			            	flag=2;
			            	String userid=result.getString("userid");
			            	String bookname=result.getString("bookname");
			            	String time=result.getString("shouldtime");
			            	borrowrecord temp=new borrowrecord();
			            	temp.setBookname(bookname);
			            	temp.setUserid(userid);
			            	temp.setShouldtime(time);
			            	list.add(temp);
			            	
			            	
			            }
			            
			            System.out.println(flag);
			            pst.close();
			           
			            
			           
			        } catch (SQLException e) {
			            System.out.println(e);
			        }
					if(flag==2)
					{
						out.print("借阅信息查找成功");
						for(borrowrecord s:list)
		                {
		                	out.print(s.getUserid());
		                	out.print(s.getBookname());
		                }
					}
					else{
						out.print("借阅信息查找失败");
					}
					
					
					request.setAttribute("borrowid2",p1);
					request.setAttribute("bookid2",p2);
					request.setAttribute("bookname",p5);
					request.setAttribute("tip",tip);
					request.setAttribute("records",list);
					request.getRequestDispatcher("adborrowbook.jsp").forward(request, response);
				}
				if(max>lendnum && state==0)
				{
					String tip="该读者可借阅:"+Integer.toString(max)+",已经借阅:"+Integer.toString(lendnum)+",但是本图书已借出，无法借阅";
					out.print(tip);
					ArrayList<borrowrecord> list=new ArrayList<borrowrecord>();
					try {
			            
			        	String sql0="select * from borrowrecords where userid=? and state=?";
			            
			            PreparedStatement pst=con.prepareStatement(sql0);
			            pst.setInt(2,0);
			            pst.setString(1, p1);
			            
			           
			            ResultSet result=pst.executeQuery();
			            
			            while (result.next()) {
			            	flag=2;
			            	String userid=result.getString("userid");
			            	String bookname=result.getString("bookname");
			            	String time=result.getString("shouldtime");
			            	borrowrecord temp=new borrowrecord();
			            	temp.setBookname(bookname);
			            	temp.setUserid(userid);
			            	temp.setShouldtime(time);
			            	list.add(temp);
			            	
			            	
			            }
			            
			            System.out.println(flag);
			            pst.close();
			           
			            
			           
			        } catch (SQLException e) {
			            System.out.println(e);
			        }
					if(flag==2)
					{
						out.print("借阅信息查找成功");
						
						for(borrowrecord s:list)
		                {
		                	out.print(s.getUserid());
		                	out.print(s.getBookname());
		                }
					}
					else{
						out.print("借阅信息查找失败");
					}
					
					request.setAttribute("borrowid2",p1);
					request.setAttribute("bookid2",p2);
					request.setAttribute("tip",tip);
					request.setAttribute("bookname",p5);
					request.setAttribute("records",list);
					request.getRequestDispatcher("adborrowbook.jsp").forward(request, response);
					
				}
				if(max>lendnum &&state==-1)
				{
					String tip="该读者可借阅:"+Integer.toString(max)+",已经借阅:"+Integer.toString(lendnum)+",但是本图书不存在，无法借阅";
					out.print(tip);
					
					ArrayList<borrowrecord> list=new ArrayList<borrowrecord>();
					try {
			            
			        	String sql0="select * from borrowrecords where userid=? and state=?";
			            
			            PreparedStatement pst=con.prepareStatement(sql0);
			           
			            pst.setString(1, p1);
			            pst.setInt(2,0);
			           
			            ResultSet result=pst.executeQuery();
			            
			            while (result.next()) {
			            	flag=2;
			            	String userid=result.getString("userid");
			            	String bookname=result.getString("bookname");
			            	String time=result.getString("shouldtime");
			            	borrowrecord temp=new borrowrecord();
			            	temp.setBookname(bookname);
			            	temp.setUserid(userid);
			            	temp.setShouldtime(time);
			            	list.add(temp);
			            	
			            	
			            }
			            
			            System.out.println(flag);
			            pst.close();
			           
			            
			           
			        } catch (SQLException e) {
			            System.out.println(e);
			        }
					if(flag==2)
					{
						out.print("借阅信息查找成功");
						for(borrowrecord s:list)
		                {
		                	out.print(s.getUserid());
		                	out.print(s.getBookname());
		                }
					}
					else{
						out.print("借阅信息查找失败");
					}
					request.setAttribute("borrowid2",p1);
					request.setAttribute("bookid2",p2);
					request.setAttribute("bookname",p5);
					request.setAttribute("tip",tip);
					request.setAttribute("records",list);
					request.getRequestDispatcher("adborrowbook.jsp").forward(request, response);
					
				}
				if(max<=lendnum)
				{
					String tip="该读者可借阅:"+Integer.toString(max)+",已经借阅:"+Integer.toString(lendnum)+",超出借阅上限，无法借阅";
					out.print(tip);
					
					ArrayList<borrowrecord> list=new ArrayList<borrowrecord>();
					try {
			            
			        	String sql0="select * from borrowrecords where userid=? and state=?";
			            
			            PreparedStatement pst=con.prepareStatement(sql0);
			           
			            pst.setString(1, p1);
			            pst.setInt(2,0);
			           
			            ResultSet result=pst.executeQuery();
			            
			            while (result.next()) {
			            	flag=2;
			            	String userid=result.getString("userid");
			            	String bookname=result.getString("bookname");
			            	String time=result.getString("shouldtime");
			            	borrowrecord temp=new borrowrecord();
			            	temp.setBookname(bookname);
			            	temp.setUserid(userid);
			            	temp.setShouldtime(time);
			            	list.add(temp);
			            	
			            	
			            }
			            
			            System.out.println(flag);
			            pst.close();
			           
			            
			           
			        } catch (SQLException e) {
			            System.out.println(e);
			        }
					if(flag==2)
					{
						out.print("借阅信息查找成功");
						for(borrowrecord s:list)
		                {
		                	out.print(s.getUserid());
		                	out.print(s.getBookname());
		                }
					}
					else{
						out.print("借阅信息查找失败");
					}
					request.setAttribute("borrowid2",p1);
					request.setAttribute("bookid2",p2);
					request.setAttribute("bookname",p5);
					request.setAttribute("tip",tip);
					request.setAttribute("records",list);
					request.getRequestDispatcher("adborrowbook.jsp").forward(request, response);
					
				}
				
			}
			else{
				out.print("读者查询失败，请输入正确的借阅号");
				request.setAttribute("tip","读者查询失败，请输入正确的借阅号");
				
				request.getRequestDispatcher("adborrowbook.jsp").forward(request, response);
			}
		}
		//处理确认借阅里的表单信息
		
		else{
			out.print(p3);
			out.print(p4);
			out.print(p5);
			flag=0;
			int flag1=0;
			//看一下要借的书是否已经借出
			
	        try {
	            
	            String sql0="select * from bookinfo  where bookid=?";
	            
	            PreparedStatement pst=con.prepareStatement(sql0);
	            pst.setString(1, p4);
	            ResultSet result=pst.executeQuery();
	            
	            while (result.next()) {
	            	
	            	int state=result.getInt("state");
	            	if(state==0)
	            	{
	            		flag1=1;
	            	}
	            	break;
	 	
	            }
	            System.out.println(flag);
	            pst.close();
	            
	           
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
			if(flag1==1)
			{
                request.setAttribute("tip","书籍已经借出，无法借阅");
				
				request.getRequestDispatcher("adborrowbook.jsp").forward(request, response);
				return;
				
			}
			
			
			//插入借阅表
	        try {
	            
	        	String sql0="insert into borrowrecords(userid,bookid,bookname,borrowtime,shouldtime,state) values(?,?,?,?,?,?)";
	            
	            PreparedStatement pst=con.prepareStatement(sql0);
	           
	            
	            pst.setString(1, p3);
	            pst.setString(2,p4);
	            pst.setString(3,p5);
	            pst.setString(4,nowtime);
	            
	            Calendar    rightNow    =    Calendar.getInstance();     
	            /*用Calendar的get(int field)方法返回给定日历字段的值。 
	            */  
	            Integer year = rightNow.get(Calendar.YEAR);   
	            Integer month = rightNow.get(Calendar.MONTH)+2; //第一个月从0开始，所以得到月份＋1，归还日期再加一  
	            Integer day = rightNow.get(rightNow.DAY_OF_MONTH);  
	            
	           
	            
	            String p6 = year+"-"+month+"-"+day;  
	           
	            pst.setString(5, p6);
	            pst.setInt(6,0);
	            
	           
	            flag=pst.executeUpdate();
	            
	            System.out.println(flag);
	            pst.close();
	           
	            
	           
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
			
			
			if(flag==1){
				//信息插入成功，开始修改bookinfo表中的书的借阅状态和userinfo中读者的已借数量
				flag=0;
				int lendnum=-1;
				//查询已经借阅了多少书
		        try {
		            
		            String sql0="select * from userinfo  where userid=?";
		            
		            PreparedStatement pst=con.prepareStatement(sql0);
		            pst.setString(1, p3);
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
		        //修改书的借阅状态和人的借阅总数
		        try {
		            
		            String sql0="update userinfo set lendednum=? where userid=?";
		            
		            PreparedStatement pst=con.prepareStatement(sql0);
		            pst.setInt(1, lendnum+1);
		            pst.setString(2, p3);
		           
		            pst.executeUpdate();
		            
		            
		            System.out.println(flag);
		            pst.close();
		            
		           
		        } catch (SQLException e) {
		            System.out.println(e);
		        }
                try {
		            
		            String sql0="update bookinfo set state=? where bookid=?";
		            
		            PreparedStatement pst=con.prepareStatement(sql0);
		            pst.setInt(1,0);
		            pst.setString(2, p4);
		           
		            flag=pst.executeUpdate();
		            
		            
		            System.out.println(flag);
		            pst.close();
		            
		           
		        } catch (SQLException e) {
		            System.out.println(e);
		        }
				if(flag==1)
				{
					out.print("添加成功");
					request.setAttribute("tip", "图书借阅成功");
					request.getRequestDispatcher("adborrowbook.jsp").forward(request, response);
				}
				else
				{
					request.setAttribute("tip", "图书借阅失败");
					request.getRequestDispatcher("adborrowbook.jsp").forward(request, response);
					
				}
			}
			else{
				out.print("添加失败");
				request.setAttribute("tip", "图书借阅失败");
				request.getRequestDispatcher("adborrowbook.jsp").forward(request, response);
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
