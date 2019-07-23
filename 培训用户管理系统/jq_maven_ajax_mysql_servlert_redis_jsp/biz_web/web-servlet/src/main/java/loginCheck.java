

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.service.User;
import org.web.service.UserRedis;
import org.web.service.UserRepo;

/**
 * Servlet implementation class loginCheck
 */
public class loginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginCheck() {
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
        PrintWriter out=response.getWriter();
        String name=request.getParameter("user_name");
        String pwd=request.getParameter("user_pwd");
        String autologin=request.getParameter("autologin");
        System.out.println(name);
        System.out.println(pwd);
//        System.out.println(autologin);
        
        
        List<User> userlist=UserRepo.serchUserByName(name);
        int flag=0;
        //比对密码是否相等
        if(userlist.size()>0) {
        	for (User user : userlist) {
				if(user.getUser_pwd().equals(pwd)) {
					flag=1;
					break;
				}
			}
        }
        System.out.println(flag);
        //如果密码和用户名核对正确
        if(flag==1)
        {
        	 request.getSession().setAttribute("user_name",name);
        	 //正常情况设置一小时的session
             request.getSession().setMaxInactiveInterval(60*60);
        	//30天自动登录框被选中，进行处理, 增加一个30天的cookie，session也设置为30天
            if(autologin!=null) {
            	System.out.println("选中");
            	 request.getSession().setAttribute("autologin","true");
                 request.getSession().setMaxInactiveInterval(60*60*24*30);
            }

            //记录登录时间到日志
            UserRedis.insertUserlog(name);
            request.setAttribute("tip","登录成功,欢迎："+name);
        	request.getRequestDispatcher("userMenu.jsp").forward(request, response);
        	return;
        }

        request.setAttribute("tip","登录失败，输入信息错误");
        request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
