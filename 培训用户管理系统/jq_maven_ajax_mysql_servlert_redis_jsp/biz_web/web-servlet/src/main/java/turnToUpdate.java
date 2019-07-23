

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.service.User;
import org.web.service.UserRepo;

/**
 * Servlet implementation class turnToUpdate
 */
public class turnToUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public turnToUpdate() {
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
        String name=request.getParameter("name");
    
        if(name!=null&&name!="") {
        	System.out.println(name);
        	List<User> userlist=UserRepo.serchUserByName(name);
        	System.out.println(userlist.size());
        	if(userlist.size()>0) {
        		User user=new User();
        		userlist.forEach(s->{
        			user.setUser_id(s.getUser_id());
        			user.setUser_area(s.getUser_area());
        			user.setUser_creat_time(s.getUser_creat_time());
        			user.setUser_hobby(s.getUser_hobby());
        			user.setUser_job(s.getUser_job());
        			user.setUser_mail(s.getUser_mail());
        			user.setUser_name(s.getUser_name());
        			user.setUser_pwd(s.getUser_pwd());
        			
        		});
        		System.out.println(user.toString());
        		request.setAttribute("user",user);
        		request.getRequestDispatcher("updateUser.jsp").forward(request,response);
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
