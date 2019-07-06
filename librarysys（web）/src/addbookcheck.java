

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addbookcheck
 */
@WebServlet("/addbookcheck")
public class addbookcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addbookcheck() {
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
		
       
      
		String p1=request.getParameter("k1");
		String p2=request.getParameter("k2");
		String p3=request.getParameter("k3");
		String p4=request.getParameter("k4");
		String p5=request.getParameter("k5");
		String p6=request.getParameter("k6");
		String p7=request.getParameter("k7");
		String p8=request.getParameter("k8");
		String p10=request.getParameter("k9");
		
		PrintWriter out = response.getWriter();
		
		
		SimpleDateFormat time0=new  SimpleDateFormat("yyyy-MM-dd");
		String nowtime=time0.format(new Date());
		out.print(nowtime);
		String p11=nowtime;
		int p9=1;
		
		out.print(p1);
		out.print(p2);
		out.print(p3);
		out.print(p4);
		out.print(p5);
		
		out.print(p6);
		out.print(p7);
		out.print(p8);
		out.print(p9);
		out.print(p10);
		out.print(p11);
		int flag=0;
		Connection con=connectionace.getConection();
		
        try {
            
        	String sql0="insert into bookinfo values(?,?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement pst=con.prepareStatement(sql0);
           
            pst.setString(1, p1);
            pst.setString(2, p2);
            pst.setString(3,p3);
            pst.setString(4,p4);
            pst.setString(5,p5);
            pst.setString(6, p6);
            pst.setString(7, p7);
            pst.setString(8,p8);
            pst.setInt(9,p9);
            pst.setString(10,p10);
            pst.setString(11,p11);
            flag=pst.executeUpdate();
            
            System.out.println(flag);
            pst.close();
           
            
           
        } catch (SQLException e) {
            System.out.println(e);
        }
		
		if(flag==1){
			
			out.print("添加成功");
			request.setAttribute("tip", "图书添加成功");
			request.getRequestDispatcher("adaddbook.jsp").forward(request, response);
		}
		else{
			int maxnum=-1;
			 try {
		            
		            String sql0="select * from bookinfo ";
		            
		            PreparedStatement pst=con.prepareStatement(sql0);
		           
		            ResultSet result=pst.executeQuery();
		            
		            while (result.next()) {
		            	
		            	int temp=result.getInt("bookid");
		            	if(temp>=maxnum)
		            		maxnum=temp;
		            	
		 	
		            }
		            System.out.println(flag);
		            pst.close();
		            
		           
		        } catch (SQLException e) {
		            System.out.println(e);
		        }
			String s="图书编号请从"+Integer.toString(maxnum+1)+"开始设置";
			out.print("添加失败");
			request.setAttribute("tip", "图书编号重复，添加失败,"+s);
			request.getRequestDispatcher("adaddbook.jsp").forward(request, response);
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
