

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

import com.alibaba.fastjson.JSON;

import alljavabean.Identity;
import alljavabean.loginstate;

/**
 * Servlet implementation class phonefixpassword
 */
@WebServlet("/phonefixpassword")
public class phonefixpassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public phonefixpassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String t1=(String)request.getParameter("pwd1");
		String t2=(String)request.getParameter("pwd2");
		String t3=(String)request.getParameter("pwd3");
		String userid=(String)request.getParameter("userid");
		loginstate state=new loginstate();
        PrintWriter out = response.getWriter();
        Connection con=connectionace.getConection();
        String tip="";
        int flag=0;
        try {
            
            String sql0="select * from user ";
            
           
            	
            	PreparedStatement pst=con.prepareStatement(sql0);
                
                
                ResultSet resultSet=pst.executeQuery();
                
                while (resultSet.next()) {
                	String pwd1= resultSet.getString("password");
                	String username= resultSet.getString("username");
                    String  id1= resultSet.getString("userid");
                    if(id1.equals(userid) && pwd1.equals(t1)){
     	        	   System.out.println("正确");
     	        	   flag=1;
     	        	   
     	        	  
     	        	   break;
                    }
                   
                    
                }
                pst.close();
                resultSet.close();
               
            	
        }catch (SQLException e) {
            System.out.println(e);
        }
        if (flag==0)
        {
        	tip="原始密码不正确";
        	state.setState("false");
        	String newsListJsonStr = JSON.toJSONString(state);
            response.getWriter().println(newsListJsonStr);
            return;
        		
        }
        if(t2.equals(t3)==false)
        {
        	tip="两次密码必须相同";
        	
        	state.setState("false");
        	String newsListJsonStr = JSON.toJSONString(state);
            response.getWriter().println(newsListJsonStr);
            return;
        }
        if(flag==1)
        {
        	flag=0;
        	try {
                
            	String sql0="update user set password=? where userid=?";
                
                PreparedStatement pst=con.prepareStatement(sql0);
                pst.setString(1, t2);
                pst.setString(2, userid);
                flag=pst.executeUpdate();
                System.out.println(flag);
                
               
                
               
            } catch (SQLException e) {
                System.out.println(e);
            }
        	
        	if(flag==1)
        	{
        		tip="修改成功";
        		state.setState("true");
            	String newsListJsonStr = JSON.toJSONString(state);
                response.getWriter().println(newsListJsonStr);
                return;
        	}
        	else if(flag==0)
        	{
        		state.setState("false");
            	String newsListJsonStr = JSON.toJSONString(state);
                response.getWriter().println(newsListJsonStr);
                return;
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
