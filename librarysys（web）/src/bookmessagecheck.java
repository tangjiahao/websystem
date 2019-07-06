

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

import alljavabean.bookadmin;
import alljavabean.bookinfo;

/**
 * Servlet implementation class bookmessagecheck
 */
@WebServlet("/bookmessagecheck")
public class bookmessagecheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookmessagecheck() {
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
		
        bookinfo bookmessage=new bookinfo();
        String bookid=request.getParameter("bookid");
	   
		
		PrintWriter out = response.getWriter();
		
		int flag=0;
		
		Connection con=connectionace.getConection();
		
	
		try {
            
        	String sql0="select * from bookinfo where bookid=?";
        	
	           
            PreparedStatement pst=con.prepareStatement(sql0);
            pst.setString(1,bookid);
            ResultSet result=pst.executeQuery();
            
            while (result.next()) {
            	flag=1;
            	String p1=result.getString(1);
            	String p2=result.getString(2);
            	String p3=result.getString(3);
            	String p4=result.getString(4);
            	String p5=result.getString(5);
            	String p6=result.getString(6);
            	String p7=result.getString(7);
            	String p8=result.getString(8);
            	int p9=result.getInt(9);
            	String p10=result.getString(10);
            	String p11=result.getString(11);
            	bookmessage.setBookid(p1);
            	bookmessage.setBookname(p2);
            	bookmessage.setAuthor(p3);
            	bookmessage.setTranslator(p4);
            	bookmessage.setPrice(p5);
            	bookmessage.setIsbncode(p6);
            	bookmessage.setComeuptime(p7);
            	bookmessage.setPublishcompany(p8);
            	bookmessage.setState(p9);
            	bookmessage.setEnteringmen(p10);
            	bookmessage.setEnteringdate(p11);
            	
            	
            	
                break;
                
               
                
            }
            pst.close();
            result.close();
            con.close();
          
            
           
        } catch (SQLException e) {
            System.out.println(e);
        }
	
		if(flag==1){
			
			out.print("查询成功");
			request.setAttribute("tip", " ");
			
			request.setAttribute("bookmessage", bookmessage);
			request.getRequestDispatcher("adoutbook.jsp").forward(request, response);
		}
		else{
			out.print("没有查询到这本图书的情况");
			request.setAttribute("tip", "没有查询到这本图书的情况");
			request.getRequestDispatcher("adoutbook.jsp").forward(request, response);
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
