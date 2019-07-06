

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
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;

import alljavabean.Identity;
import alljavabean.bookadmin;
import alljavabean.loginstate;
import alljavabean.systemadmin;
import alljavabean.userinfo;

/**
 * Servlet implementation class phonelogin
 */
@WebServlet("/phonelogin")
public class phonelogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public phonelogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String userid=request.getParameter("userid");
		String pwd=request.getParameter("pwd");
		
		
        PrintWriter out = response.getWriter();
        Connection con=connectionace.getConection();
        loginstate state=new loginstate();
        
//        out.print(shenfen.getClass());
        //这个对象用来存用户的身份信息，存到session
       
        
        
        int flag=0;
       
        try {
            
            String sql0="select * from user ";
            
           
            	
            	PreparedStatement pst=con.prepareStatement(sql0);
                
                
                ResultSet resultSet=pst.executeQuery();
                
                while (resultSet.next()) {
                	String pwd1= resultSet.getString("password");
                	String username= resultSet.getString("username");
                    String  id1= resultSet.getString("userid");
                    if(id1.equals(userid) && pwd1.equals(pwd)){
     	        	   System.out.println("正确");
     	        	   flag=1;
     	        	   state.getIdt().setUsername(username);
     	        	   state.getIdt().setUserpwd(pwd);
     	        	   state.getIdt().setUserid(userid);
     	        	  
     	        	   break;
                    }
                   
                    
                }
                pst.close();
                resultSet.close();
               
            	
        }catch (SQLException e) {
            System.out.println(e);
        }
        if(flag==1)
        {
        	state.setState("true");
        	String newsListJsonStr = JSON.toJSONString(state);
            response.getWriter().println(newsListJsonStr);
            
        }
        else
        {
        	state.setState("false");
        	String newsListJsonStr = JSON.toJSONString(state);
            response.getWriter().println(newsListJsonStr);
            
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
