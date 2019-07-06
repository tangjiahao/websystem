

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

import alljavabean.bookinfo;

/**
 * Servlet implementation class outbookcheck
 */
@WebServlet("/outbookcheck")
public class outbookcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public outbookcheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
        bookinfo bookmessage=new bookinfo();
        String bookid=request.getParameter("bookid");
	    String bookstate=request.getParameter("state");
		
		PrintWriter out = response.getWriter();
		if(bookstate.equals("已借出"))
		{
			String tip="本图书已借出，无法出库";
            request.setAttribute("tip",tip);
			
			
			request.getRequestDispatcher("adoutbook.jsp").forward(request, response);
			
		}
		if(bookstate.equals("在库"))
		{
			int flag=0;
			
			Connection con=connectionace.getConection();
			
		
			try {
	            
	        	String sql0="delete from bookinfo where bookid=?";
	        	
		           
	            PreparedStatement pst=con.prepareStatement(sql0);
	            pst.setString(1,bookid);

	            flag=pst.executeUpdate();
	            pst.close();
	           
	            con.close();
	          
	            
	           
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
		
			if(flag==1){
				
				out.print("图书出库成功");
				request.setAttribute("tip", "图书出库成功");
				
				request.setAttribute("bookmessage", bookmessage);
				request.getRequestDispatcher("adoutbook.jsp").forward(request, response);
			}
			else{
				out.print("图书出库失败");
				request.setAttribute("tip", "图书出库失败");
				request.getRequestDispatcher("adoutbook.jsp").forward(request, response);
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
