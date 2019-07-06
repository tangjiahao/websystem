

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import alljavabean.userinfo;

/**
 * Servlet implementation class phonesearchreader
 */
@WebServlet("/phonesearchreader")
public class phonesearchreader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public phonesearchreader() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String search=request.getParameter("value");
	   
        PrintWriter out = response.getWriter();
//        out.print(search);
        Connection con=connectionace.getConection();
       

       
        int count=0;
        //这里统计有多少条返回的信息记录
        try {
            
            String sql0="select * from userinfo where userid like ? ";
           
            
        	PreparedStatement pst=con.prepareStatement(sql0);
            
        	pst.setString(1,"%"+search+"%");
            ResultSet resultSet=pst.executeQuery();
            
            while (resultSet.next()) {
            	
            	   count+=1;
               
                
            }
            pst.close();
            resultSet.close();
               
            	
           
        }catch (SQLException e) {
            System.out.println(e);
        }
        
        
         //假设有借阅信息
//        out.print(count);
        if(count>0)
        {
        	
        	ArrayList<userinfo> list=new ArrayList<userinfo>();
    		
    		
    		//开始将信息加入到对象数组中
    		try {
                
                String sql0="select * from userinfo where userid like ? ";
               
                
            	PreparedStatement pst=con.prepareStatement(sql0);
                
                pst.setString(1, '%'+search+'%');
               
                ResultSet resultSet=pst.executeQuery();
                int num=0;
                while (resultSet.next()) {
                	String p1=resultSet.getString(1);
                	String p2=resultSet.getString(2);
                	String p3=resultSet.getString(3);
                	String p4=resultSet.getString(4);
                	String p5=resultSet.getString(5);
                	String p6=resultSet.getString(6);
                	String p8=resultSet.getString(8);
                	int p7=resultSet.getInt(7);
                	int p9=resultSet.getInt(9);
                	userinfo temp=new userinfo();
	                temp.setUserid(p1);
	                temp.setUsername(p2);
	                temp.setDepartments(p3);
	                temp.setMajor(p4);
	                temp.setPhone(p5);
	                temp.setEmail(p6);
	                temp.setMax(p7);
	                temp.setTime(p8);
	                temp.setLendednum(p9);
	                num+=1;
	                list.add(temp);
                   
                    
                }
               
                pst.close();
                resultSet.close();
                //打印了下读者信息
//                for(userinfo s:list)
//                {
//                	out.print(s.getUserid());
//                	out.print(s.getUsername());
//                }
                String newsListJsonStr = JSON.toJSONString(list);
                response.getWriter().println(newsListJsonStr);

               
            }catch (SQLException e) {
                System.out.println(e);
            }
    		
        }
        else
        {
        	 out.print("没找到");

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
