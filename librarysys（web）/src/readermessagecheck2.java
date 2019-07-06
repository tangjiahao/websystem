

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

import alljavabean.userinfo;

/**
 * Servlet implementation class readermessagecheck2
 */
@WebServlet("/readermessagecheck2")
public class readermessagecheck2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public readermessagecheck2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
        userinfo usermessage=new userinfo();
        String borrowid=request.getParameter("borrowid");
	   
		
		PrintWriter out = response.getWriter();
		
		int flag=0;
		
		Connection con=connectionace.getConection();
		
		
		try {
            
        	String sql0="select * from userinfo where userid=?";
        	
	           
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
            	String p6=result.getString(6);
            	int p7=result.getInt(7);
            	String p8=result.getString(8);
                int p9=result.getInt(9);
            	usermessage.setUserid(p1);
            	usermessage.setUsername(p2);
            	usermessage.setDepartments(p3);
            	usermessage.setMajor(p4);
            	usermessage.setPhone(p5);
            	usermessage.setEmail(p6);
            	usermessage.setMax(p7);
            	usermessage.setTime(p8);
            	usermessage.setLendednum(p9);
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
			request.getRequestDispatcher("adminalterreader.jsp").forward(request, response);
		}
		else{
			out.print("没有查询到该学生情况");
			request.setAttribute("tip1", "没有查询到该学生情况");
			request.getRequestDispatcher("adminalterreader.jsp").forward(request, response);
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
