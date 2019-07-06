

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

import com.alibaba.fastjson.JSON;

import alljavabean.Identity;
import alljavabean.loginstate;
import alljavabean.userinfo;

/**
 * Servlet implementation class phonefixmessage
 */
@WebServlet("/phonefixmessage")
public class phonefixmessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public phonefixmessage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String t1=(String)request.getParameter("phone");
		String t2=(String)request.getParameter("email");
		String t3=(String)request.getParameter("userid");
		loginstate state=new loginstate();
        PrintWriter out = response.getWriter();
        Connection con=connectionace.getConection();
        String tip="";
        int flag=0;
        try {
            
        	String sql0="update userinfo set phone=?,email=? where userid=?";
            
            PreparedStatement pst=con.prepareStatement(sql0);
            pst.setString(1, t1);
            pst.setString(2, t2);
            pst.setString(3, t3);
            flag=pst.executeUpdate();
            System.out.println(flag);
            
           
            
           
        } catch (SQLException e) {
            System.out.println(e);
        }
        if (flag==0){
        	tip="修改失败";
        	
        	state.setState("false");
        	String newsListJsonStr = JSON.toJSONString(state);
            response.getWriter().println(newsListJsonStr);
        }
        if (flag==1){
        	tip="修改成功";
        	state.setState("true");
        	String newsListJsonStr = JSON.toJSONString(state);
            response.getWriter().println(newsListJsonStr);
        	
        	
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
