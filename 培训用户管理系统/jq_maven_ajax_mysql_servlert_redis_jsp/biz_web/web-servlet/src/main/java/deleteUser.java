

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.service.UserRedis;
import org.web.service.UserRepo;

/**
 * Servlet implementation class deleteUser
 */
public class deleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteUser() {
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
       
        String user_name=request.getParameter("name");
        if(user_name==null)
        {
        	request.setAttribute("tip", "删除失败，用户名不能为空");
			request.getRequestDispatcher("userMenu.jsp").forward(request,response);
			return;
        }
        if(UserRepo.deleteUserByName(user_name)>=1) {
        	//删除日志文件
        	UserRedis.deleteUserLog(user_name);
        	request.setAttribute("tip", "删除成功");
			request.getRequestDispatcher("userMenu.jsp").forward(request,response);
			return;
        }
        request.setAttribute("tip", "删除失败");
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
