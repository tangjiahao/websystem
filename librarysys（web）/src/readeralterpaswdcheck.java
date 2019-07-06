

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alljavabean.Identity;
import alljavabean.userinfo;

/**
 * Servlet implementation class readeralterpaswdcheck
 */
@WebServlet("/readeralterpaswdcheck")
public class readeralterpaswdcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public readeralterpaswdcheck() {
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
		String t1=(String)request.getParameter("pwd1");
		String t2=(String)request.getParameter("pwd2");
		String t3=(String)request.getParameter("pwd3");
		Identity idt=(Identity)request.getSession().getAttribute("idt");
		
        PrintWriter out = response.getWriter();
        Connection con=connectionace.getConection();
        String tip="";
        int flag=1;
        if (t1.equals(idt.getUserpwd())==false)
        {
        	tip="原始密码不正确";
        	flag=0;
        	request.setAttribute("tip", tip);

      	    request.getRequestDispatcher("readeralterpaswd.jsp").forward(request, response);	
        }
        if(t2.equals(t3)==false)
        {
        	tip="两次密码必须相同";
        	flag=0;
        	request.setAttribute("tip", tip);

      	    request.getRequestDispatcher("readeralterpaswd.jsp").forward(request, response);	
        }
        if(flag==1)
        {
        	flag=0;
        	try {
                
            	String sql0="update user set password=? where userid=?";
                
                PreparedStatement pst=con.prepareStatement(sql0);
                pst.setString(1, t2);
                pst.setString(2, idt.getUserid());
                flag=pst.executeUpdate();
                System.out.println(flag);
                
               
                
               
            } catch (SQLException e) {
                System.out.println(e);
            }
        	
        	if(flag==1)
        	{
        		tip="修改成功";
            	idt.setUserpwd(t2);
   
            	request.setAttribute("tip", tip);
                request.getSession().setAttribute("idt", idt);
           	    request.getRequestDispatcher("readeralterpaswd.jsp").forward(request, response);		
        	}
        	else if(flag==0)
        	{
        		tip="修改失败";
           	    request.getRequestDispatcher("readeralterpaswd.jsp").forward(request, response);		
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
