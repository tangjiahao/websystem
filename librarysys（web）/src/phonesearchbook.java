

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

import alljavabean.bookinfo;
import alljavabean.mixinfo;

/**
 * Servlet implementation class phonesearchbook
 */
@WebServlet("/phonesearchbook")
public class phonesearchbook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public phonesearchbook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String search=request.getParameter("value");
	    
        PrintWriter out = response.getWriter();
//        out.print("search");
//        out.print(search);
        Connection con=connectionace.getConection();
       

       
       
      
        	
        	ArrayList<mixinfo> list=new ArrayList<mixinfo>();
        	ArrayList<bookinfo> list1=new ArrayList<bookinfo>();
        	
    		
    		try {
                
                String sql0="select bookname,author,publishcompany,count(*) as num from bookinfo where bookname like ? group by bookname";
                PreparedStatement pst=con.prepareStatement(sql0);
                
                pst.setString(1, '%'+search+'%');
                
                ResultSet res=pst.executeQuery();
               
                while (res.next()) {
                	
                	mixinfo temp=new mixinfo();
	                temp.setBookname(res.getString("bookname"));
	                temp.setAuthor(res.getString("author"));
	                temp.setPublishcompany(res.getString("publishcompany"));
	                temp.setInstate(res.getInt("num"));
	                list.add(temp);
                   
                    
                }
               
                pst.close();
                res.close();
                
               
               
            }catch (SQLException e) {
                System.out.println(e);
            }
           
    		
    		try {
                
                String sql0="select * from bookinfo where bookname like ? and state=?";
               
                
            	PreparedStatement pst=con.prepareStatement(sql0);
                
                pst.setString(1, '%'+search+'%');
                pst.setInt(2,0);
                ResultSet resultSet=pst.executeQuery();
               
                while (resultSet.next()) {
                	int p1=resultSet.getInt("state");
                	String p2=resultSet.getString("bookname");
                	
                	
                	bookinfo temp=new bookinfo();
	               temp.setState(p1);
	               temp.setBookname(p2);
	               
	               list1.add(temp);
                   
                    
                }
               
                pst.close();
                resultSet.close();
                con.close();
                
               
            }catch (SQLException e) {
                System.out.println(e);
            }
    		
    		
    		
    		
//            out.print("bookinfo:");
            //将总库存减去借出的，就是在库的
            for(mixinfo t1:list)
            {
            	for(bookinfo t2:list1)
            	{
            		if(t1.getBookname().equals(t2.getBookname()) &&t2.getState()==0)
            			t1.setInstate(t1.getInstate()-1);
            	}
             
            }
//            for(mixinfo t1:list)
//            {
//            	out.print(t1.getBookname());
//            	out.print(t1.getInstate());
//            }
//            request.setAttribute( "search",search);
//            out.print(search);
            String newsListJsonStr = JSON.toJSONString(list);
            response.getWriter().println(newsListJsonStr);
//            request.setAttribute( "result",list);
//			request.getRequestDispatcher("searchresult.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
