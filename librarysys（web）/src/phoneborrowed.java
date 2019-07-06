

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import alljavabean.borrowrecord;

/**
 * Servlet implementation class phoneborrowed
 */
@WebServlet("/phoneborrowed")
public class phoneborrowed extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public phoneborrowed() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String userid=(String)request.getParameter("userid");
	    
        PrintWriter out = response.getWriter();
        Connection con=connectionace.getConection();
       
//        List<borrowrecord> a=null;
//        ArrayList<borrowrecord> a=null;
          
       
        	ArrayList<borrowrecord> list=new ArrayList<borrowrecord>();
    		
    		
    		//开始将信息加入到对象数组中
    		try {
                
                String sql0="select * from borrowrecords where userid=? and state=?";
               
                
            	PreparedStatement pst=con.prepareStatement(sql0);
                
                pst.setString(1, userid);
                pst.setInt(2, 1);
                ResultSet resultSet=pst.executeQuery();
               
                while (resultSet.next()) {
                	
                	String p1=resultSet.getString(1);
                	String p2=resultSet.getString(2);
                	String p3=resultSet.getString(3);
                	String p4=resultSet.getString(4);
                	String p5=resultSet.getString(5);
                	String p6=resultSet.getString(6);
                	String p7=resultSet.getString(7);
                	int p8=resultSet.getInt(8);
                	borrowrecord temp=new borrowrecord();
	                temp.setBorrowid(p1);
	                temp.setUserid(p2);
	                temp.setBookid(p3);
	                temp.setBookname(p4);
	                temp.setBorrowtime(p5);
	                temp.setShouldtime(p6);
	                temp.setReturntime(p7);
	                temp.setState(p8);
	               
	                list.add(temp);
                   
                    
                }
               
                pst.close();
                resultSet.close();
               
                
            	String newsListJsonStr = JSON.toJSONString(list);
                response.getWriter().println(newsListJsonStr);
               
            }catch (SQLException e) {
                System.out.println(e);
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
