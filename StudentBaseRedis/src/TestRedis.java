

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import Bean.SerializeUtil;
import Bean.Student;
import redis.clients.jedis.Jedis;
/**
 * Servlet implementation class TestRedis
 */
@WebServlet("/TestRedis")
public class TestRedis extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestRedis() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    protected static Jedis jedis = new Jedis("127.0.0.1", 6379);
    //清空数据库
    public void DeleteAll() {
    	jedis.flushDB();
    }
    public Date StrToDate(String time) throws ParseException{
    	 DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
         return df.parse(time);
    }
   
    public void InsertOne(String id,String name,String birthday,String des,int avg) {
    	Student stu=new Student(id, name, birthday, des, avg);
    	jedis.lpush("StudentBase".getBytes(), SerializeUtil.serialize(stu));
    	
    	
    }
    public pageStu getPageStu(int pageindex) {
    	Long len=jedis.llen("StudentBase".getBytes());
    	pageStu pStu=new pageStu();
    	pStu.setPageindex(pageindex);
    	pStu.setPagemax((int)Math.ceil(len/10.0));
    	//如果请求的页面超出最后一页
    	if(pStu.getPagemax()<=pageindex) {
    		pStu.setPageindex(pStu.getPagemax());
    	}
    	if(pageindex<=0)
    	{
    		pStu.setPageindex(1);
    	}
    	int l=new Long(len).intValue();
    	pStu.setDatacount(l);
    	return pStu;
    	
    	
    }
    public List<Student> getStudents(int index,int pagemax) {
    	if(index<=0){
    		index=1;
    	}
    	if(index>=pagemax) {
    		index=pagemax;
    	}
    	List<Student> list0=new ArrayList<Student>();
		 //获取studentbase列表里的所有元素
		 List<byte[]> list1= jedis.lrange("StudentBase".getBytes(),0,-1);
		 list1.forEach(s->{
		 Student student=(Student)SerializeUtil.unserialize(s);
		 list0.add(student);
		 
		 });
		 if(list0.size()!=0) {
	//		 list0.forEach(s->System.out.println(s));
			 Collections.sort(list0);
			 int start=(index-1)*10;
			 int end=index*10;
			 //下面是防止数组越界的避免
			 if(end>=list0.size()) {
				 end=list0.size();
			 }
			 if(start>end) {
				 start=0;
			 }
			 return list0.subList(start,end);
		 }
		 System.out.println("redis为空，无法访问展示");
		 return null;
		 
		 
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		 PrintWriter out = response.getWriter();

		 String handle=null;

		 //传过来的处理请求没有指明方式或者指明查询，就默认跳转到学生的信息界面
		 if(request.getParameter("handle")==null ||request.getParameter("handle")==""
				 ||request.getParameter("handle").equals("watch")){
			 int pageidx=Integer.parseInt(request.getParameter("pageindex"));
			 
			 pageStu paStu=getPageStu(pageidx);
			 
			 List<Student> list0=getStudents(pageidx, paStu.getPagemax());
			
//			 out.print(jedis.keys("*"));
			 request.setAttribute("pageStu",paStu);
			 request.setAttribute("stulist",list0);
		  	 request.getRequestDispatcher("stusys.jsp").forward(request,response);
		  	 return;
			 
		 }
         handle=request.getParameter("handle");
         //处理请求为增
         if(handle.equals("add")) {
//        	 out.print("增加");
        	 List<Student> list0=new ArrayList<Student>();
        	 int flag=1;
			 //获取studentbase列表里的元素
			 List<byte[]> list1= jedis.lrange("StudentBase".getBytes(), 0, -1);
			 String id=request.getParameter("stuid");
			 for (byte[] s : list1) {
				 Student student=(Student)SerializeUtil.unserialize(s);
				 if(student.getId().equals(id)){
					
					 flag=0;
					 break;
					 
				 }
			}
			if(flag==0) {
				out.print("无法新增，该学生id已存在，请删除该学生在重新新增");
				return;
			}
			 
        	 
        	 String name=request.getParameter("stuname");
        	 String birthday  =request.getParameter("stubirth");
        	 String des=request.getParameter("studes");
        	 int avg=Integer.parseInt(request.getParameter("stuavg"));
        	 InsertOne(id, name, birthday, des, avg);
        	 request.getRequestDispatcher("TestRedis?handle=watch&&pageindex=1").forward(request,response);
         }
       //处理请求删除
         if(handle.equals("delete")) {
        	 out.print("删除");
        	 out.print(request.getParameter("id"));
        	 String stuid=request.getParameter("id");
        	 List<byte[]> list1= jedis.lrange("StudentBase".getBytes(),0,-1);
        	 //清除studentbase
        	 jedis.del("StudentBase".getBytes());
        	 list1.forEach(s->{
        		 Student stu=(Student)SerializeUtil.unserialize(s);
        		 //如果不是要删除的元素，就把元素重新装入列表
        		 if(!stu.getId().equals(stuid)) {
        			jedis.lpush("StudentBase".getBytes(),SerializeUtil.serialize(stu));
        		}
        	 });
        	 request.getRequestDispatcher("TestRedis?handle=watch&&pageindex=1").forward(request,response);
         }
       //处理请求修改
         if(handle.equals("fix")) {
        	 out.print("修改");
        	 out.print(request.getParameter("id"));
        	 String stuid=request.getParameter("id");
        	 List<byte[]> list1= jedis.lrange("StudentBase".getBytes(),0,-1);
        	 //清除studentbase
        	 jedis.del("StudentBase".getBytes());
        	 list1.forEach(s->{
        		 Student stu=(Student)SerializeUtil.unserialize(s);
        		 //如果不是要修改的元素，就把元素重新装入列表
        		 if(!stu.getId().equals(stuid)) {
        			jedis.lpush("StudentBase".getBytes(),SerializeUtil.serialize(stu));
        		}
        	 });
        	 String name=request.getParameter("stuname");
        	 String birthday  =request.getParameter("stubirth");
        	 String des=request.getParameter("studes");
        	 int avg=Integer.parseInt(request.getParameter("stuavg"));
        	
        	 InsertOne(stuid, name, birthday, des, avg);
        	 request.getRequestDispatcher("TestRedis?handle=watch&&pageindex=1").forward(request,response);
         }
//         DeleteAll();
		
//		 InsertOne("1001", "ace", "1995-1-15", "没什么好说的",62);
//		 InsertOne("1002", "mike", "1996-1-15", "没什么好说的",68);
//		 InsertOne("1003", "apple", "1997-11-15", "没什么好说的",64);
		
		 
		
//		 out.print(jedis.keys("*"));
//	  	 for (Student bs : list0) {
//			System.out.println(bs.getName());
//		}

         
         
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
