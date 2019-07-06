

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
 * Servlet implementation class outreaderadcheck
 */
@WebServlet("/outreaderadcheck")
public class outreaderadcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public outreaderadcheck() {
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
		String p1=request.getParameter("borrowid2");
		out.print("borrrowid:");
		out.print(p1);
		int flag=-1;
		
		Connection con=connectionace.getConection();
		
        try {
            
            String sql0="delete from bookadmin where adid=?";
            
            PreparedStatement pst=con.prepareStatement(sql0);
            pst.setString(1, p1);
           
           
            flag=pst.executeUpdate();
            out.print(flag);
            
            System.out.println(flag);
            pst.close();
            
           
        } catch (SQLException e) {
            System.out.println(e);
        }
		
		if(flag==1){
			out.print(flag);
			request.setAttribute("tip1", "管理员删除成功");
			request.getRequestDispatcher("adminoutad.jsp").forward(request, response);
		}
		else{
			out.print("删除失败");
			out.print(flag);
			request.setAttribute("tip1", "管理员删除失败");
			request.getRequestDispatcher("adminoutad.jsp").forward(request, response);
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
