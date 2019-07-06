

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
 * Servlet implementation class alterreaderadcheck
 */
@WebServlet("/alterreaderadcheck")
public class alterreaderadcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public alterreaderadcheck() {
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
		String p2=request.getParameter("k2");
		String p3=request.getParameter("k3");
		String p4=request.getParameter("k4");
		String p5=request.getParameter("k5");
		
		
		out.print("borrrowid:");
		out.print(p1);
		int flag=0;
		int temp=0;
		Connection con=connectionace.getConection();
		//修改图书管理员表
        try {
            
            String sql0="update bookadmin set adname=?,adpassword=?,adphone=?,ademail=? where adid=?";
            
            PreparedStatement pst=con.prepareStatement(sql0);
            pst.setString(1, p2);
            pst.setString(2, p3);
            pst.setString(3, p4);
            pst.setString(4, p5);
            pst.setString(5, p1);
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
			request.setAttribute("tip1", "管理员修改成功");
			request.getRequestDispatcher("adminalterad.jsp").forward(request, response);
		}
		else{
			out.print("删除失败");
			out.print(flag);
			request.setAttribute("tip1", "管理员修改失败");
			request.getRequestDispatcher("adminalterad.jsp").forward(request, response);
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
