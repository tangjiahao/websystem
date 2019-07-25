

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.service.AreaRepo;
import org.web.service.User;
import org.web.service.UserRepo;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
//        System.out.println(user_pwd);
        String user_mail=request.getParameter("user_mail");
        String user_area1=request.getParameter("province");
        String user_area2=request.getParameter("city");
       
        String[] values = request.getParameterValues("hobby") ;
        if(user_name==null||user_pwd==null||user_area1==null||user_area2==null||values==null||user_mail==null) {
        	request.setAttribute("tip", "错误访问注册处理");
    		request.getRequestDispatcher("userMenu.jsp").forward(request,response);
    		return;
        }
        String user_area=user_area1+"/"+user_area2;
       //获取爱好
       
        String hobbyString="";
        if(values!=null&&values.length>0) {
        for(int i= 0 ;i<values.length;i++) {
             hobbyString+="/"+values[i];
            
        }
        }
        
//        System.out.println(hobbyString);
        Date date = new Date();
      
		DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm"); // HH表示24小时制；
		String time = dFormat.format(date);
		int flag=UserRepo.insertUser(user_name, user_pwd, user_mail, user_area, hobbyString, "", time);
		if(flag==1) {
			request.setAttribute("tip", "添加成功");
			request.getRequestDispatcher("userMenu.jsp").forward(request,response);
			return;
		}
		request.setAttribute("tip", "添加失败,用户名已存在");
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
