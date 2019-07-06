

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
 * Servlet implementation class alterreadercheck
 */
@WebServlet("/alterreadercheck")
public class alterreadercheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public alterreadercheck() {
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
		String p6=request.getParameter("k6");
		String p7=request.getParameter("k7");
		String p8=request.getParameter("k8");
		
		out.print("borrrowid:");
		out.print(p1);
		int flag=0;
		int temp=0;
		Connection con=connectionace.getConection();
		//先修改读者的user表，这和这个表存在外码有关
        try {
            
            String sql0="update user set username=? where userid=?";
            
            PreparedStatement pst=con.prepareStatement(sql0);
            pst.setString(1, p2);
            pst.setString(2, p1);
           
            temp=pst.executeUpdate();
            if(temp==1)
            	flag=1;
            
            System.out.println(flag);
            pst.close();
            
           
        } catch (SQLException e) {
            System.out.println(e);
        }
		temp=0;
		//if表user修改成功，修改userinfo表
		if (flag==1)
		{
			out.print(flag);
			try {
	            
				String sql0="update userinfo set username=?,departments=?,major=?,phone=?,email=?,max=?,time=? where userid=?";
	            
	            PreparedStatement pst=con.prepareStatement(sql0);
	            pst.setString(1, p2);
	            pst.setString(2, p3);
	            pst.setString(3, p4);
	            pst.setString(4, p5);
	            pst.setString(5, p6);
	            pst.setString(6, p7);
	            pst.setString(7, p8);
	            pst.setString(8, p1);
	            temp=pst.executeUpdate();
	           
	            out.print("temp");
	            out.print(temp);
	            if(temp==1)
	            	flag=2;
	            out.print(flag);
	            System.out.println(flag);
	            pst.close();
	            con.close();
	            
	           
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
		}
		if(flag==2){
			out.print(flag);
			request.setAttribute("tip1", "读者修改成功");
			request.getRequestDispatcher("adminalterreader.jsp").forward(request, response);
		}
		else{
			out.print("删除失败");
			out.print(flag);
			request.setAttribute("tip1", "读者修改失败");
			request.getRequestDispatcher("adminalterreader.jsp").forward(request, response);
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
