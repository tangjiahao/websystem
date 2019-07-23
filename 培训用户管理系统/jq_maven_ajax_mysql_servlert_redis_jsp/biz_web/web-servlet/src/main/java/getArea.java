

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.service.AreaRepo;
import org.web.service.City;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class getArea
 */
public class getArea extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getArea() {
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
        PrintWriter out=response.getWriter();
        String province=request.getParameter("province");
        //如果没有请求区和县的数据
        if(province==null||province=="") {
        	List<String> proList=AreaRepo.getAllProvince();
        	request.setAttribute("prolist",proList);
        	
        	request.getRequestDispatcher("addUser.jsp").forward(request,response);
        	
        }
        //请求了区数据
        else {
        	//lista存储所有的区的名字
        	List<String> lista=AreaRepo.getCityByProvince(province);
//        	List<City> listb=new ArrayList<City>();
//        	lista.forEach(s->{
//        		City temp=new City();
//        		temp.setName(s);
//        		listb.add(temp);
//        	});
        	String ace= JSONArray.fromObject(lista).toString();
        	response.getWriter().write(ace);
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
