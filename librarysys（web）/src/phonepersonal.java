

import java.io.IOException;
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

import alljavabean.userinfo;

/**
 * Servlet implementation class phonepersonal
 */
@WebServlet("/phonepersonal")
public class phonepersonal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public phonepersonal() {
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
		userinfo k1=new userinfo();
		Connection con=connectionace.getConection();
		int flag=0;
        try {
       
        String sql0="select * from userinfo ";
    
  
    	
    	PreparedStatement pst=con.prepareStatement(sql0);
        
        
        ResultSet resultSet=pst.executeQuery();
        
        while (resultSet.next()) {
        	String t1=resultSet.getString(1);
//            	out.print(t1);
        	String t12=resultSet.getString(2);
        	String t2=resultSet.getString(3);
        	String t3=resultSet.getString(4);
        	String t4=resultSet.getString(5);
        	String t5=resultSet.getString(6);
        	int t6=resultSet.getInt(7);
        	String t7=resultSet.getString(8);
        	int t8=resultSet.getInt(9);
            if(userid.equals(t1) ){
            	
               flag=1;
        	   System.out.println("正确");
        	   k1.setUserid(t1);
        	   k1.setDepartments(t2);
        	   k1.setMajor(t3);
        	   k1.setPhone(t4);
        	   k1.setEmail(t5);
        	   k1.setMax(t6);
        	   k1.setTime(t7);
        	   k1.setLendednum(t8);
        	   k1.setUsername(t12);
        	   break;
            }
           
            
        }
        pst.close();
        resultSet.close();
        con.close();
    	
        }
	catch (SQLException e) {
        System.out.println(e);
    }
        if(flag==1)
        {
        	
        	String newsListJsonStr = JSON.toJSONString(k1);
            response.getWriter().println(newsListJsonStr);
            
        }
        else
        {
        	
        	String newsListJsonStr = JSON.toJSONString(null);
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
