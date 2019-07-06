

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

import alljavabean.Identity;
import alljavabean.borrowrecord;

/**
 * Servlet implementation class readerborrowedcheck
 */
@WebServlet("/readerborrowedcheck")
public class readerborrowedcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public readerborrowedcheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		Identity idt=(Identity)request.getSession().getAttribute("idt");
	    
        PrintWriter out = response.getWriter();
        Connection con=connectionace.getConection();
        String tip="";
//        List<borrowrecord> a=null;
//        ArrayList<borrowrecord> a=null;
        int flag=0;
        int count=0;
        //这里统计有多少条已借借阅信息记录
        try {
            
            String sql0="select * from borrowrecords where userid=? ";
           
            
        	PreparedStatement pst=con.prepareStatement(sql0);
            
        	pst.setString(1,idt.getUserid());
            ResultSet resultSet=pst.executeQuery();
            
            while (resultSet.next()) {
            	int s=resultSet.getInt(8);
            	if (s==0)
            	   count+=1;
               
                
            }
            pst.close();
            resultSet.close();
               
            	
           
        }catch (SQLException e) {
            System.out.println(e);
        }
        
        
         //假设有借阅信息
        if(count>0)
        {
        	
        	ArrayList<borrowrecord> list=new ArrayList<borrowrecord>();
    		
    		
    		//开始将信息加入到对象数组中
    		try {
                
                String sql0="select * from borrowrecords where userid=? and state=?";
               
                
            	PreparedStatement pst=con.prepareStatement(sql0);
                
                pst.setString(1, idt.getUserid());
                pst.setInt(2, 1);
                ResultSet resultSet=pst.executeQuery();
                int num=0;
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
	                num+=1;
	                list.add(temp);
                   
                    
                }
               
                pst.close();
                resultSet.close();
                //打印了下在借图书
                for(borrowrecord s:list)
                {
                	out.print(s.getBookname());
                	out.print(s.getState());
                }
                request.setAttribute( "borrowing",list);
               
  			    request.getRequestDispatcher("readerborrowed.jsp").forward(request, response);
               
            }catch (SQLException e) {
                System.out.println(e);
            }
    		
        }
        else
        {
        	
        	 request.getRequestDispatcher("readerborrowed.jsp").forward(request, response);
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
