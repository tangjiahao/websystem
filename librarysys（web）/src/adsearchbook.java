

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

import alljavabean.bookadmin;
import alljavabean.bookinfo;

/**
 * Servlet implementation class adsearchbook
 */
@WebServlet("/adsearchbook")
public class adsearchbook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adsearchbook() {
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
	   
        PrintWriter out = response.getWriter();
        out.print(search);
        Connection con=connectionace.getConection();
       

       
        int count=0;
        //这里统计有多少条返回的信息记录
        try {
            
            String sql0="select * from bookinfo where bookname like ?  or author like ?";
           
            
        	PreparedStatement pst=con.prepareStatement(sql0);
            
        	pst.setString(1,"%"+search+"%");
        	pst.setString(2,"%"+search+"%");
            ResultSet resultSet=pst.executeQuery();
            
            while (resultSet.next()) {
            	
            	   count+=1;
               
                
            }
            pst.close();
            resultSet.close();
               
            	
           
        }catch (SQLException e) {
            System.out.println(e);
        }
        
        
         //假设有借阅信息
        out.print(count);
        if(count>0)
        {
        	
        	ArrayList<bookinfo> list=new ArrayList<bookinfo>();
    		
    		
    		//开始将信息加入到对象数组中
    		try {
                
                String sql0="select * from bookinfo where bookname like ? or author like ?";
               
                
            	PreparedStatement pst=con.prepareStatement(sql0);
                
                pst.setString(1, '%'+search+'%');
                pst.setString(2,"%"+search+"%");
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
                	String p8=resultSet.getString(8);
                	int p9=resultSet.getInt(9);
                	String p10=resultSet.getString(10);
                	String p11=resultSet.getString(11);
                	bookinfo temp=new bookinfo();
	                temp.setBookid(p1);
	                temp.setBookname(p2);
	                temp.setAuthor(p3);
	                temp.setTranslator(p4);
	                temp.setPrice(p5);
	                temp.setIsbncode(p6);
	                temp.setComeuptime(p7);
	                temp.setPublishcompany(p8);
	                temp.setState(p9);
	                temp.setEnteringmen(p10);
	                temp.setEnteringdate(p11);
	                num+=1;
	                list.add(temp);
                   
                    
                }
               
                pst.close();
                resultSet.close();
                out.print(num);
                //打印了下图书信息
                for(bookinfo s:list)
                {
                	out.print(s.getBookname());
                	out.print(s.getAuthor());
                }
                request.setAttribute( "searchbook",list);
                request.setAttribute("searchnum", num);
  			    request.getRequestDispatcher("adsearchbook.jsp").forward(request, response);
               
            }catch (SQLException e) {
                System.out.println(e);
            }
    		
        }
        else
        {
        	 out.print("没找到");
        	 request.setAttribute("searchnum", 0);
			 request.getRequestDispatcher("adsearchbook.jsp").forward(request, response);
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
