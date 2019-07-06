

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
 * Servlet implementation class outreadercheck
 */
@WebServlet("/outreadercheck")
public class outreadercheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public outreadercheck() {
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
		
       
		PrintWriter out = response.getWriter();
		String p1=request.getParameter("borrowid2");
		out.print("borrrowid:");
		out.print(p1);
		int flag=0;
		int temp=0;
		Connection con=connectionace.getConection();
		//先删除读者的user表，这和这个表存在外码有关
        try {
            
            String sql0="delete from user where userid=?";
            
            PreparedStatement pst=con.prepareStatement(sql0);
            pst.setString(1, p1);
           
           
            temp=pst.executeUpdate();
            if(temp==1)
            	flag=1;
            
            System.out.println(flag);
            pst.close();
            
           
        } catch (SQLException e) {
            System.out.println(e);
        }
		temp=0;
		//if表user删除成功，删除userinfo表
		if (flag==1)
		{
			out.print(flag);
			try {
	            
				String sql0="delete from userinfo where userid=?";
	            
	            PreparedStatement pst=con.prepareStatement(sql0);
	            pst.setString(1, p1);
	           
	           
	            temp=pst.executeUpdate();
	           
	            out.print("temp");
	            out.print(temp);
	            if(temp==0)
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
			request.setAttribute("tip1", "读者删除成功");
			request.getRequestDispatcher("adminoutreader.jsp").forward(request, response);
		}
		else{
			out.print("删除失败");
			out.print(flag);
			request.setAttribute("tip1", "读者删除失败");
			request.getRequestDispatcher("adminoutreader.jsp").forward(request, response);
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
