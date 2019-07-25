

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.service.UserJob;
import org.web.service.UserJobRepo;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class manageJob
 */
public class manageJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public manageJob() {
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
        String handle=request.getParameter("handle");
//        System.out.println(handle);
        if(handle==null) {
        	request.setAttribute("tip", "错误访问职位管理");
    		request.getRequestDispatcher("userMenu.jsp").forward(request,response);
        }
        if("watch".equals(handle)) {
        	String user_name=request.getParameter("user_name");
        	List<UserJob> listJobs=UserJobRepo.getAllJob(user_name);
        	String ace= JSONArray.fromObject(listJobs).toString();
        	response.getWriter().write(ace);
        	
        }
        if("add".equals(handle)) {
        	String name=request.getParameter("jobname");
        	String user_name=request.getParameter("user_name");
        	System.out.println(name);
        	int flag=UserJobRepo.insertUser(name,user_name);
        	if(flag==1) {
        		System.out.println("职称插入成功");
        	}
        	else {
        		System.out.println("插入失败");
        	}
        }
        if("delete".equals(handle)) {
        	int job_id=Integer.parseInt(request.getParameter("job_id"));
        	System.out.println(job_id);
        	int flag=UserJobRepo.deleteJobById(job_id);
        	if(flag==1) {
        		System.out.println("职称删除成功");
        		
        	}
        	else {
        		System.out.println("插入失败");
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
