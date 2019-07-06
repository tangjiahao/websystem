

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
import alljavabean.Identity;
import alljavabean.userinfo;
/**
 * Servlet implementation class readalterdatasevlet
 */
@WebServlet("/readalterdatasevlet")
public class readalterdatasevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public readalterdatasevlet() {
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
		String t1=(String)request.getParameter("phone");
		String t2=(String)request.getParameter("email");
		Identity idt=(Identity)request.getSession().getAttribute("idt");
		userinfo k1=(userinfo)request.getSession().getAttribute("ufo");
        PrintWriter out = response.getWriter();
        Connection con=connectionace.getConection();
        String tip="";
        int flag=0;
        try {
            
        	String sql0="update userinfo set phone=?,email=? where userid=?";
            
            PreparedStatement pst=con.prepareStatement(sql0);
            pst.setString(1, t1);
            pst.setString(2, t2);
            pst.setString(3, idt.getUserid());
            flag=pst.executeUpdate();
            System.out.println(flag);
            
           
            
           
        } catch (SQLException e) {
            System.out.println(e);
        }
        if (flag==0){
        	tip="修改失败";
        	request.setAttribute("tip", tip);

      	    request.getRequestDispatcher("readeralterdata.jsp").forward(request, response);		
        }
        if (flag==1){
        	tip="修改成功";
        	k1.setPhone(t1);
        	k1.setEmail(t2);
        	request.setAttribute("tip", tip);
            request.getSession().setAttribute("ufo", k1);
       	    request.getRequestDispatcher("readeralterdata.jsp").forward(request, response);		
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
