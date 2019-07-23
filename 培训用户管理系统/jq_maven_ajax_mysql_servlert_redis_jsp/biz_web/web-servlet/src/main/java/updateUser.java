

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.service.ConnectJdbc;
import org.web.service.UserRepo;

/**
 * Servlet implementation class updateUser
 */
public class updateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateUser() {
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
       
        String user_name=request.getParameter("user_name");
        String user_pwd=request.getParameter("user_pwd");
        String user_mail=request.getParameter("user_mail");
        String user_area=request.getParameter("user_area");
        String user_hobby=request.getParameter("user_hobby");
        String user_job=request.getParameter("user_job");
        String user_creat_time=request.getParameter("user_creat_time");
		if(UserRepo.updateUserByName(user_name, user_pwd, user_mail, user_area, user_hobby, user_job, user_creat_time)==1) {
			request.setAttribute("tip", "更新成功");
			request.getRequestDispatcher("userMenu.jsp").forward(request,response);
			return;
		}
		request.setAttribute("tip", "更新失败");
		request.getRequestDispatcher("userMenu.jsp").forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
