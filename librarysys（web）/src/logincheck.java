

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import alljavabean.Identity;
import alljavabean.bookadmin;
import alljavabean.systemadmin;
import alljavabean.userinfo;
/**
 * Servlet implementation class logincheck
 */
@WebServlet("/logincheck")
public class logincheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logincheck() {
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
		String username=request.getParameter("username");
		String pwd=request.getParameter("password");
		String shenfen=request.getParameter("shenfen");
		
        PrintWriter out = response.getWriter();
        Connection con=connectionace.getConection();
        HttpSession session=request.getSession(true);   
        session.setMaxInactiveInterval(3600);//一个小时内一直存在
        out.print(shenfen);
//        out.print(shenfen.getClass());
        //这个对象用来存用户的身份信息，存到session
        Identity idt=new Identity();
        
        if (shenfen.equals("read"))
        {
        	out.print("为读者");
        }
        String info="";
        int flag=0;
       
        try {
            
            String sql0="select * from user ";
            String sql1="select * from  bookadmin";
            String sql2="select * from systemadmin ";
            if (shenfen.equals("read"))
            {
            	
            	PreparedStatement pst=con.prepareStatement(sql0);
                
                
                ResultSet resultSet=pst.executeQuery();
                
                while (resultSet.next()) {
                	String pwd1= resultSet.getString(3);
                	String realname=resultSet.getString(2);
                    String  name1= resultSet.getString(1);
                    if(name1.equals(username) && pwd1.equals(pwd)){
     	        	   System.out.println("正确");
     	        	   idt.setUserid(username);
     	        	   idt.setUsername(realname);
     	        	   idt.setUserpwd(pwd);
     	        	   idt.setUsershenfen("read");
     	        	   flag=1;
     	        	   break;
                    }
                   
                    
                }
                pst.close();
                resultSet.close();
               
            	
            }
            else if (shenfen.equals("manage"))
            {
            	PreparedStatement pst=con.prepareStatement(sql1);
                
                
                ResultSet resultSet=pst.executeQuery();
                
                while (resultSet.next()) {
                	String pwd1= resultSet.getString(3);
                	String realname=resultSet.getString(2);
                    String  name1= resultSet.getString(1);
                    if(name1.equals(username) && pwd1.equals(pwd)){
     	        	   System.out.println("正确");
     	        	   idt.setUserid(username);
     	        	   idt.setUsername(realname);
    	        	   idt.setUserpwd(pwd);
    	        	   idt.setUsershenfen("manage");
     	        	   flag=2;
     	        	   break;
                    }
                   
                    
                }
                pst.close();
                resultSet.close();
               
            	
            }
            else if (shenfen.equals("root"))
            {
            	PreparedStatement pst=con.prepareStatement(sql2);
                
                
                ResultSet resultSet=pst.executeQuery();
                
                while (resultSet.next()) {
                	String pwd1= resultSet.getString(3);
                	String realname=resultSet.getString(2);
                    String  name1= resultSet.getString(1);
                    if(name1.equals(username) && pwd1.equals(pwd)){
     	        	   System.out.println("正确");
     	        	   idt.setUserid(username);
     	        	   idt.setUsername(realname);
    	        	   idt.setUserpwd(pwd);
    	        	   idt.setUsershenfen("root");
     	        	   flag=3;
     	        	   break;
                    }
                   
                    
                }
                pst.close();
                resultSet.close();
                
            	
            }
            
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        if(flag==0)
		{
        	
        	info="您这个身份的通行证号或密码错误或者该身份已被注销";
        	request.setAttribute("info", info);

       	    request.getRequestDispatcher("login.jsp").forward(request, response);
        	
			
			
			
		}
		else if(flag==1){
			    userinfo k1=new userinfo();
                try {
               
	            String sql0="select * from userinfo ";
	            
	            if (shenfen.equals("read"))
	            {
	            	
	            	PreparedStatement pst=con.prepareStatement(sql0);
	                
	                
	                ResultSet resultSet=pst.executeQuery();
	                
	                while (resultSet.next()) {
	                	String t1=resultSet.getString(1);
//	                	out.print(t1);
	                	String t2=resultSet.getString(3);
	                	String t3=resultSet.getString(4);
	                	String t4=resultSet.getString(5);
	                	String t5=resultSet.getString(6);
	                	int t6=resultSet.getInt(7);
	                	String t7=resultSet.getString(8);
	                	int t8=resultSet.getInt(9);
	                    if(username.equals(t1) ){
	     	        	   System.out.println("正确");
	     	        	   k1.setUserid(t1);
	     	        	   k1.setDepartments(t2);
	     	        	   k1.setMajor(t3);
	     	        	   k1.setPhone(t4);
	     	        	   k1.setEmail(t5);
	     	        	   k1.setMax(t6);
	     	        	   k1.setTime(t7);
	     	        	   k1.setLendednum(t8);
	     	        	   break;
	                    }
	                   
	                    
	                }
	                pst.close();
	                resultSet.close();
	                con.close();
	            	
	            }
			}catch (SQLException e) {
	            System.out.println(e);
	        }
			request.getSession().setAttribute("idt", idt);
			request.getSession().setAttribute("ufo", k1);
			out.print(k1.getDepartments());
			request.getRequestDispatcher("readerpersonal.jsp").forward(request, response);
//			out.print("读者");
			
			
		}
		else if(flag==2)
		{
			bookadmin k1=new bookadmin();
            try {
           
            String sql0="select * from bookadmin where adid=?";
            
            if (shenfen.equals("manage"))
            {
            	
            	PreparedStatement pst=con.prepareStatement(sql0);
                pst.setString(1,username);
                
                ResultSet resultSet=pst.executeQuery();
                
                while (resultSet.next()) {
                	
                	String s1=resultSet.getString(4);
                	String s2=resultSet.getString(5);
                	String s3=resultSet.getString("adname");
                	k1.setAdname(s3);
                	k1.setAdphone(s1);
                	k1.setAdemail(s2);
                    
                }
                pst.close();
                resultSet.close();
                con.close();
            	
            }
			}catch (SQLException e) {
	            System.out.println(e);
	        }
			
			request.getSession().setAttribute("idt", idt);
			request.getSession().setAttribute("ufo", k1);
			request.getRequestDispatcher("adpersonal.jsp").forward(request, response);
			out.print("图书管理员");
		}
		else if(flag==3)
		{
			systemadmin k1=new systemadmin();
            try {
           
            String sql0="select * from systemadmin where adminid=?";
            
            if (shenfen.equals("root"))
            {
            	
            	PreparedStatement pst=con.prepareStatement(sql0);
                pst.setString(1,username);
                
                ResultSet resultSet=pst.executeQuery();
                
                while (resultSet.next()) {
                	String s1=resultSet.getString(4);
                	String s2=resultSet.getString(5);
                	String s3=resultSet.getString(2);
                	k1.setAdminname(s3);
                    k1.setAdminphone(s1);
                    k1.setAdminemail(s2);
                    
                }
                pst.close();
                resultSet.close();
                con.close();
            	
            }
			}catch (SQLException e) {
	            System.out.println(e);
	        }
			
			request.getSession().setAttribute("idt", idt);
			request.getSession().setAttribute("ufo", k1);
			request.getRequestDispatcher("adminpersonal.jsp").forward(request, response);
			out.print("系统管理员");
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
