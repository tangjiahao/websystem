

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alljavabean.bookadmin;
import alljavabean.userinfo;

/**
 * Servlet implementation class admessagecheck
 */
@WebServlet("/admessagecheck")
public class admessagecheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admessagecheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
        bookadmin usermessage=new bookadmin();
        String borrowid=request.getParameter("borrowid");
	   
		
		PrintWriter out = response.getWriter();
		
		int flag=0;
		
		Connection con=connectionace.getConection();
		
	
		try {
            
        	String sql0="select * from bookadmin where adid=?";
        	
	           
            PreparedStatement pst=con.prepareStatement(sql0);
            pst.setString(1, borrowid);
            ResultSet result=pst.executeQuery();
            
            while (result.next()) {
            	flag=1;
            	String p1=result.getString(1);
            	String p2=result.getString(2);
            	String p3=result.getString(3);
            	String p4=result.getString(4);
            	String p5=result.getString(5);
            	
            	usermessage.setAdid(p1);
            	usermessage.setAdname(p2);
            	usermessage.setAdpassword(p3);
            	usermessage.setAdphone(p4);
            	usermessage.setAdemail(p5);
            	
            	
                break;
                
               
                
            }
            pst.close();
            result.close();
            con.close();
          
            
           
        } catch (SQLException e) {
            System.out.println(e);
        }
	
		if(flag==1){
			
			out.print("查询成功");
			request.setAttribute("tip1", " ");
			
			request.setAttribute("usermessage", usermessage);
			request.getRequestDispatcher("adminoutad.jsp").forward(request, response);
		}
		else{
			out.print("没有查询到该管理员的情况");
			request.setAttribute("tip1", "没有查询到该管理员的情况");
			request.getRequestDispatcher("adminoutad.jsp").forward(request, response);
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
