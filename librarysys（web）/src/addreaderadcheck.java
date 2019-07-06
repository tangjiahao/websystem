

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
 * Servlet implementation class addreaderadcheck
 */
@WebServlet("/addreaderadcheck")
public class addreaderadcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addreaderadcheck() {
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
		
       
      
		String p1=request.getParameter("k1");
		String p2=request.getParameter("k2");
		String p3=request.getParameter("k3");
		String p4=request.getParameter("k4");
		String p5=request.getParameter("k5");
		
		
		PrintWriter out = response.getWriter();
		out.print(p1);
		out.print(p2);
		out.print(p3);
		out.print(p4);
		out.print(p5);
		
		int flag=0;
		
		Connection con=connectionace.getConection();
		
        try {
            
        	String sql0="insert into bookadmin values(?,?,?,?,?)";
            
            PreparedStatement pst=con.prepareStatement(sql0);
           
            pst.setString(1, p1);
            pst.setString(2, p2);
           
            pst.setString(3,p3);
            pst.setString(4,p4);
            pst.setString(5,p5);
            flag=pst.executeUpdate();
            
            System.out.println(flag);
            pst.close();
           
            
           
        } catch (SQLException e) {
            System.out.println(e);
        }
		
		if(flag==1){
			
			out.print("添加成功");
			request.setAttribute("tip", "管理员添加成功");
			request.getRequestDispatcher("adminaddad.jsp").forward(request, response);
		}
		else{
			out.print("添加失败");
			request.setAttribute("tip", "管理员已存在，无法重复录入");
			request.getRequestDispatcher("adminaddad.jsp").forward(request, response);
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
