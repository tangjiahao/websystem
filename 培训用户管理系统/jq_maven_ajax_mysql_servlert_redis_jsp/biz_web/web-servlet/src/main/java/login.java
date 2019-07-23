
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.service.User;
import org.web.service.UserRepo;

/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		List<User> userlist = UserRepo.serchUserByName("admin");
		// 下面是删除自动登录的cookie
//		Cookie cookie = new Cookie("autologin", null);
//		cookie.setMaxAge(0);// 删除
//		response.addCookie(cookie);

		// admin用户有则跳过，无则创建
		if (userlist.size() > 0) {
			System.out.println("admin用户已存在");
			request.getRequestDispatcher("login.jsp").forward(request, response);

		} else {
			String name = "admin";
			String pwd = "admin";
			Date date = new Date();
			DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm"); // HH表示24小时制；
			String time = dFormat.format(date);
//			System.out.println(time);
			String job = "admin";
			if (UserRepo.insertUser(name, pwd, "无", "无", "无", job, time) > 0) {
				System.out.println("admin用户不存在，自动创建成功");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else {
				System.out.println("admin用户自动创建失败");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
