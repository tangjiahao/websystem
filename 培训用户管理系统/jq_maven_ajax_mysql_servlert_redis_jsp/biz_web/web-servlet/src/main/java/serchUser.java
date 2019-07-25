

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.lang.jstl.AndOperator;
import org.web.service.User;
import org.web.service.UserRepo;
import org.web.service.pageUtil;



/**
 * Servlet implementation class serchUser
 */
public class serchUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public serchUser() {
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
        PrintWriter out = response.getWriter();
        if(request.getParameter("pageindex")==null||request.getParameter("pagesize")==null||request.getParameter("pagenum")==null) {
			request.setAttribute("tip","错误访问查询");
		  	request.getRequestDispatcher("userMenu.jsp").forward(request,response);
		  	return;
		}
        int pageidx=Integer.parseInt(request.getParameter("pageindex"));
		int pagesize=Integer.parseInt(request.getParameter("pagesize"));
		int pagenum=Integer.parseInt(request.getParameter("pagenum"));
		List<User> userList=new ArrayList<User>();
		pageUtil page=new pageUtil();
		
		//如果传了搜索的名字，进行简单模糊查询
		if(request.getParameter("user_name")!=null && request.getParameter("user_name")!="") {
			//防止分页越界
			if(pageidx<=0) {
				pageidx=1;
			}
			if(pageidx>pagenum)
			{
				pageidx=pagenum;
			}
			String name=request.getParameter("user_name");
			String sql="select * from User where user_name like "+"'%"+name+"%'";
			//如果有指定名字的用户，把他记录到pageutil对象里，方便分页
			if(UserRepo.getPageOfUsers(sql, pageidx, pagesize).size()>0) {
				userList=UserRepo.getPageOfUsers(sql, pageidx, pagesize);
				
				page.setOption(name);
				page.setIndex(pageidx);
				page.setPagesize(pagesize);
				String sql1="select count(*) from User where user_name like "+"'%"+name+"%'";
				int amount=UserRepo.getUserAmount(sql1);
				
				page.setPagenum((int)Math.ceil((double)amount/pagesize));
				request.setAttribute("userlist", userList);
				request.setAttribute("page", page);
				request.setAttribute("tip","查询成功");
			  	request.getRequestDispatcher("userMenu.jsp").forward(request,response);
			  	return;
			}
			else {
				request.setAttribute("tip","没有查到该用户名的数据");
			  	request.getRequestDispatcher("userMenu.jsp").forward(request,response);
			}
			
		}
		else{
			String sql="select * from User";
			//防止分页越界
			if(pageidx<=0) {
				pageidx=1;
			}
			if(pageidx>pagenum)
			{
				pageidx=pagenum;
			}
			
			userList=UserRepo.getPageOfUsers(sql,pageidx,pagesize);
//			userList.forEach(s->System.out.println(s.toString()));
//			System.out.println(userList.size());
			if(userList.size()>0) {
				
				
				page.setOption("");
				page.setIndex(pageidx);
				page.setPagesize(pagesize);
				String sql1="select count(*) from User";
				int amount=UserRepo.getUserAmount(sql1);
//				System.out.println(amount+""+(int)Math.ceil((double)amount/pagesize));
				page.setPagenum((int)Math.ceil((double)amount/pagesize));
				request.setAttribute("userlist", userList);
				request.setAttribute("page", page);
				request.setAttribute("tip","查询成功");
			  	request.getRequestDispatcher("userMenu.jsp").forward(request,response);
			  	return;
			}
			else {
				request.setAttribute("tip","用户数据表为空");
			  	request.getRequestDispatcher("userMenu.jsp").forward(request,response);
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
