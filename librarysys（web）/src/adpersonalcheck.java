

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
import alljavabean.bookadmin;
import alljavabean.systemadmin;

/**
 * Servlet implementation class adpersonalcheck
 */
@WebServlet("/adpersonalcheck")
public class adpersonalcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adpersonalcheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String p1=request.getParameter("pwd1");
		String p2=request.getParameter("pwd2");
		String p3=request.getParameter("pwd3");
		String p4=request.getParameter("adminname");
		String p5=request.getParameter("phone");
		String p6=request.getParameter("email");
		PrintWriter out = response.getWriter();
		bookadmin admin=new bookadmin();
		out.print(p1);
		String info="";
		int flag=0;
		Identity idt=new Identity();
		idt=(Identity)request.getSession().getAttribute("idt");
		String adminid=idt.getUserid();
        Connection con=connectionace.getConection();
		//判断是否有资格修改
        try {
            
        	String sql0="select * from bookadmin";
            
            PreparedStatement pst=con.prepareStatement(sql0);
            ResultSet result=pst.executeQuery();
            while(result.next())
            {
            	String t1=result.getString(1);
            	String t2=result.getString(3);
            	//存在该系统管理员且提交的密码正确，flag=1表明它有资格修改
            	if(t1.equals(adminid) && t2.equals(p1))
            	{
            		flag=1;
            		break;
            	}
            	
            }
            
            System.out.println(flag);
            pst.close();
           
            
           
        } catch (SQLException e) {
            System.out.println(e);
        }
        if(flag==1)
        {
        	flag=0;
        	out.print("有修改资格");
        	int temp=0;
        	if(p2=="" && p3=="")
        	{
        		//修改图书管理员表
	            try {
	                
	                String sql0="update bookadmin set adname=?,adpassword=?,adphone=?,ademail=? where adid=?";
	                
	                PreparedStatement pst=con.prepareStatement(sql0);
	                pst.setString(1, p4);
	                pst.setString(2, p1);
	                pst.setString(3, p5);
	                pst.setString(4, p6);
	                pst.setString(5, adminid);
	                
	                
	                temp=pst.executeUpdate();
	                out.print("temp");
	                out.print(temp);
	                if(temp==1)
	                {
	                	flag=1;
	                	info="系统管理员资料修改成功";
	                	out.print(info);
//	                	request.getSession().setAttribute("ufo", admin);
                        request.setAttribute("tip",info);
	        			request.getRequestDispatcher("adpersonal.jsp").forward(request, response);
	                			
	                }
	                else{
	                	info="系统管理员资料修改失败";
	                	out.print(info);
	                	
	                	
	                	request.setAttribute("tip",info);
	        			request.getRequestDispatcher("adpersonal.jsp").forward(request, response);
	                }
	                System.out.println(flag);
	                pst.close();
	                con.close();
	                
	               
	            } catch (SQLException e) {
	                System.out.println(e);
	            }
        		
        	}
        	else if(p2!="" &&p2.equals(p3))
        	{
	        	//修改图书管理员表
	            try {
	                
	                String sql0="update bookadmin set adname=?,adpassword=?,adphone=?,ademail=? where adid=?";
	                
	                PreparedStatement pst=con.prepareStatement(sql0);
	                pst.setString(1, p4);
	                pst.setString(2, p2);
	                pst.setString(3, p5);
	                pst.setString(4, p6);
	                pst.setString(5, adminid);
	                admin.setAdname(p4);
	                admin.setAdphone(p5);
	                admin.setAdemail(p6);
	                temp=pst.executeUpdate();
	                out.print("temp");
	                out.print(temp);
	                if(temp==1)
	                {
	                	flag=1;
	                	out.print("p2=");
	                	out.print(p2);
	                	info="图书管理员资料修改成功";
	                	out.print(info);
	                	
//	                	request.getSession().setAttribute("ufo", admin);
	                	request.setAttribute("tip",info);
	        			
	        			
	        			request.getRequestDispatcher("adpersonal.jsp").forward(request, response);
	                			
	                }
	                else{
	                	info="图书管理员资料修改失败";
	                	out.print(info);
                        request.setAttribute("tip",info);
	        			
	        			
	        			request.getRequestDispatcher("adpersonal.jsp").forward(request, response);
	                }
	                System.out.println(flag);
	                pst.close();
	                con.close();
	                
	               
	            } catch (SQLException e) {
	                System.out.println(e);
	            }
            }
        	else if(p2.equals(p3)==false)
        	{
        		info="修改的密码和确认密码不一致，两者必须相同或者不修改密码";
        		out.print(info);
        		request.setAttribute("tip",info);
    			request.getRequestDispatcher("adpersonal.jsp").forward(request, response);
        	}
    		
        }
        else{
        	out.print("管理员密码错误，请重新输入原始密码");
        	request.setAttribute("tip",info);
			request.getRequestDispatcher("adpersonal.jsp").forward(request, response);
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
