

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

import alljavabean.bookinfo;
import alljavabean.borrowrecord;

/**
 * Servlet implementation class adsearchrecord
 */
@WebServlet("/adsearchrecord")
public class adsearchrecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adsearchrecord() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String search=request.getParameter("search");
	    String type=request.getParameter("searchtype");
        PrintWriter out = response.getWriter();
        out.print(search);
        out.print(type);
        Connection con=connectionace.getConection();
        
        
        if(type.equals("userid"))
        {
        	
        	ArrayList<borrowrecord> list=new ArrayList<borrowrecord>();
    		
    		
    		//开始将信息加入到对象数组中
    		try {
                
                String sql0="select * from borrowrecords where userid like ? and state=?";
               
                
            	PreparedStatement pst=con.prepareStatement(sql0);
                
                pst.setString(1, '%'+search+'%');
                pst.setInt(2,1);
                ResultSet resultSet=pst.executeQuery();
               
                while (resultSet.next()) {
                	String p1=resultSet.getString("userid");
                	String p2=resultSet.getString("bookname");
                	String p3=resultSet.getString("shouldtime");
                	String p4=resultSet.getString("returntime");
                	
                	
                	borrowrecord temp=new borrowrecord();
	               temp.setUserid(p1);
	               temp.setBookname(p2);
	               temp.setShouldtime(p3);
	               temp.setReturntime(p4);
	              
	               list.add(temp);
                   
                    
                }
               
                pst.close();
                resultSet.close();
                con.close();
                request.setAttribute( "searchrecord",list);
                
  			    request.getRequestDispatcher("adcheckbook.jsp").forward(request, response);
               
            }catch (SQLException e) {
                System.out.println(e);
            }
        }
    	if(type.equals("bookid") || type.equals("bookname"))
    	{
    		if(type.equals("bookid"))
    		{
    			ArrayList<borrowrecord> list=new ArrayList<borrowrecord>();
        		
        		
        		//开始将信息加入到对象数组中
        		try {
                    
                    String sql0="select * from borrowrecords where bookid like ? and state=?";
                   
                    
                	PreparedStatement pst=con.prepareStatement(sql0);
                    
                    pst.setString(1, '%'+search+'%');
                    pst.setInt(2,1);
                    ResultSet resultSet=pst.executeQuery();
                   
                    while (resultSet.next()) {
                    	String p1=resultSet.getString("userid");
                    	String p2=resultSet.getString("bookname");
                    	String p3=resultSet.getString("shouldtime");
                    	String p4=resultSet.getString("returntime");
                    	String p5=resultSet.getString("bookid");
                    	String p6=resultSet.getString("borrowtime");
                    	
                    	
                    	borrowrecord temp=new borrowrecord();
    	               temp.setUserid(p1);
    	               temp.setBookname(p2);
    	               temp.setShouldtime(p3);
    	               temp.setReturntime(p4);
    	               temp.setBorrowtime(p6);
    	               temp.setBookid(p5);
    	               list.add(temp);
                       
                        
                    }
                   
                    pst.close();
                    resultSet.close();
                    con.close();
                    request.setAttribute( "searchrecord2",list);
                    
      			    request.getRequestDispatcher("adcheckbook.jsp").forward(request, response);
                   
                }catch (SQLException e) {
                    System.out.println(e);
                }
    		}
    		if(type.equals("bookname"))
    		{
    			ArrayList<borrowrecord> list=new ArrayList<borrowrecord>();
        		
        		
        		//开始将信息加入到对象数组中
        		try {
                    
                    String sql0="select * from borrowrecords where bookname like ? and state=?";
                   
                    
                	PreparedStatement pst=con.prepareStatement(sql0);
                    
                    pst.setString(1, '%'+search+'%');
                    pst.setInt(2,1);
                    ResultSet resultSet=pst.executeQuery();
                   
                    while (resultSet.next()) {
                    	String p1=resultSet.getString("userid");
                    	String p2=resultSet.getString("bookname");
                    	String p3=resultSet.getString("shouldtime");
                    	String p4=resultSet.getString("returntime");
                    	String p5=resultSet.getString("bookid");
                    	String p6=resultSet.getString("borrowtime");
                    	
                    	
                    	borrowrecord temp=new borrowrecord();
    	               temp.setUserid(p1);
    	               temp.setBookname(p2);
    	               temp.setShouldtime(p3);
    	               temp.setReturntime(p4);
    	               temp.setBorrowtime(p6);
    	               temp.setBookid(p5);
    	               list.add(temp);
                       
                        
                    }
                   
                    pst.close();
                    resultSet.close();
                    con.close();
                    request.setAttribute( "searchrecord3",list);
                    
      			    request.getRequestDispatcher("adcheckbook.jsp").forward(request, response);
                   
                }catch (SQLException e) {
                    System.out.println(e);
                }
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
