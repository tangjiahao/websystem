

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class alterbookcheck
 */
@WebServlet("/alterbookcheck")
public class alterbookcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public alterbookcheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
       
		PrintWriter out = response.getWriter();
		String p1=request.getParameter("bookid");
		String p2=request.getParameter("k2");
		String p3=request.getParameter("k3");
		String p4=request.getParameter("k4");
		String p5=request.getParameter("k5");
		String p6=request.getParameter("k6");
		String p7=request.getParameter("k7");
		String p8=request.getParameter("k8");
		String p10=request.getParameter("k10");
		
		out.print("borrrowid:");
		out.print(p1);
		int flag=0;
		int temp=0;
		Connection con=connectionace.getConection();
		//修改图书表
        try {
            
            String sql0="update bookinfo set bookname=?,author=?,translator=?,price=?,isbncode=?,comeuptime=?,publishcompany=?,enteringmen=? where bookid=?";
            
            PreparedStatement pst=con.prepareStatement(sql0);
            pst.setString(1, p2);
            pst.setString(2, p3);
            pst.setString(3, p4);
            pst.setString(4, p5);
            pst.setString(5, p6);
            pst.setString(6, p7);
            pst.setString(7, p8);
            pst.setString(8, p10);
            pst.setString(9, p1);
            temp=pst.executeUpdate();
            if(temp==1)
            	flag=1;
            
            System.out.println(flag);
            pst.close();
            
           
        } catch (SQLException e) {
            System.out.println(e);
        }
		
		
		
		if(flag==1){
			out.print(flag);
			request.setAttribute("tip", "图书信息修改成功");
			request.getRequestDispatcher("adalterbook.jsp").forward(request, response);
		}
		else{
			out.print("修改失败");
			out.print(flag);
			request.setAttribute("tip", "图书信息修改失败");
			request.getRequestDispatcher("adalterbook.jsp").forward(request, response);
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
