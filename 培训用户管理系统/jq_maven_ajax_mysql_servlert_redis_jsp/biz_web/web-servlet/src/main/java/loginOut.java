

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginOut
 */
public class loginOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginOut() {
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
       
     // 下面是删除自动登录的cookie
        Cookie cookie = new Cookie("autologin", null);
		cookie.setMaxAge(0);// 删除
		response.addCookie(cookie);
		request.getSession().removeAttribute("user_name");
	   
	
//		if(null != request.getCookies()){
//		    Cookie[] cookie1 = request.getCookies();
//		    for(int i = 0; i < cookie1.length; i++)
//		    {
//		        if(cookie1[i].getName().equals("autologin"))
//		        {
//		           System.out.println("cookie没清除");
//		           break;
//		        }
//		    }
//		}
        response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
