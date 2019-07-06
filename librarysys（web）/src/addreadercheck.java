

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
 * Servlet implementation class addreadercheck
 */
@WebServlet("/addreadercheck")
public class addreadercheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addreadercheck() {
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
		String p6=request.getParameter("k6");
		String p7=request.getParameter("k7");
		String p8=request.getParameter("k8");
	
		String result=null;
		PrintWriter out = response.getWriter();
		out.print(p1);
		out.print(p2);
		out.print(p3);
		out.print(p4);
		out.print(p5);
		out.print(p6);
		out.print(p7);
		out.print(p8);
		int flag=0;
		int temp=0;
		Connection con=connectionace.getConection();
		//先添加读者的user表，这和这个表存在外码有关
        try {
            
        	String sql0="insert into user values(?,?,?)";
            
            PreparedStatement pst=con.prepareStatement(sql0);
           
            pst.setString(1, p1);
            pst.setString(2, p2);
            //初始密码统一设置为自己的借阅号
            pst.setString(3,p1);
            
            temp=pst.executeUpdate();
            if(temp==1)
            	flag=1;
            System.out.println(flag);
            pst.close();
           
            
           
        } catch (SQLException e) {
            System.out.println(e);
        }
		temp=0;
		//if表user添加成功，添加userinfo表
		if (flag==1)
		{
			try {
	            
	        	String sql0="insert into userinfo values(?,?,?,?,?,?,?,?,?)";
	            
	            PreparedStatement pst=con.prepareStatement(sql0);
	           
	            pst.setString(1, p1);
	            pst.setString(2, p2);
	            pst.setString(3, p3);
	            pst.setString(4,p4);
	            pst.setString(5, p5);
	            pst.setString(6, p6);
	            pst.setInt(7,Integer.parseInt(p7));
	            pst.setString(8, p8);
	            pst.setInt(9, 0);
	           
	            temp=pst.executeUpdate();
	            if(temp==1)
	            	flag=2;
	            System.out.println(flag);
	            pst.close();
	            con.close();
	            
	           
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
		}
		if(flag==2){
			
			out.print("添加成功");
			request.setAttribute("tip", "读者添加成功");
			request.getRequestDispatcher("adminaddreader.jsp").forward(request, response);
		}
		else{
			out.print("添加失败");
			request.setAttribute("tip", "读者已存在，无法重复录入");
			request.getRequestDispatcher("adminaddreader.jsp").forward(request, response);
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
