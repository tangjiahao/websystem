package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JButton;
import javax.swing.text.DefaultEditorKit.InsertBreakAction;

import org.apache.catalina.connector.Request;
import org.apache.jasper.tagplugins.jstl.core.If;
import org.apache.jasper.tagplugins.jstl.core.Out;

import com.alibaba.fastjson.asm.Type;
import com.oracle.jrockit.jfr.RequestableEvent;
import com.sun.corba.se.spi.ior.iiop.AlternateIIOPAddressComponent;
import com.sun.org.apache.bcel.internal.generic.Select;
import com.tedu.base.servlet.BusinessServlet;

import alljavabean.*;
import dao.Pageutil;
import dao.jdbcdao;

@WebServlet("/userformv")
public class userformv extends BusinessServlet {
	private static final long serialVersionUID = 1L;
        jdbcdao<user> dao=new jdbcdao<user>();
        
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userformv() {
        super();
        // TODO Auto-generated constructor stub
    }
    



    public String register(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
	              response.setContentType("text/html;charset=utf-8");
	              request.setCharacterEncoding("utf-8");
	              response.setHeader("content-type", "text/html;charset=UTF-8");
	              response.setCharacterEncoding("UTF-8");
	            
	              PrintWriter out=response.getWriter();
	             
	              out.print(request.getParameter("flag1"));
	              out.print(request.getParameter("flag2"));
	            
	          	
	          	if(request.getParameter("flag1").equalsIgnoreCase("true")&&request.getParameter("flag2").equals("true"))
	          	{
	          	   
	          	    String  userid=(String )request.getParameter("phone");
	          	    
	          	    String          username=(String )request.getParameter("username");
	          	    String          sex=(String )request.getParameter("sex");
	          	    String          age=(String )request.getParameter("age");
	          	    String    pwd=request.getParameter("pwd");
	          	  Date d = new Date();
	                  System.out.println("当前时间为:" + d);
	                  //创建日期格式化对象(把日期转成字符串)
	                  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:s");
	                  String time= sdf.format(d);
	          	    jdbcdao<user> ace=new jdbcdao<>();
	          	    
	          	    String sql0="insert into user  values(?,?,?,?,?,?,?)";
	          	  
	          	    
	          	    int flag=ace.alterObject(sql0,userid,username,sex,userid,age,time,pwd);
	          	    if (flag>0)
	          	        {
	          		 
	          		     request.setAttribute("tip", "用户注册成功,请登录");
	          		     out.print("用户注册成功");
	          		     out.print("<a href='login.jsp'>登录</a>");
	          		     return "forward:login.jsp";
	          		   
	          	            
	          	        }
	          	        else
	          	        {
	          	          request.setAttribute("tip", "用户注册失败，该用户已经被注册过");
	          	          out.print("用户注册失败，该用户已经被注册过");
	          	          return "forward:register.jsp";
	          	            
	          	        }
	          	    
	          	}
	          	else{
	          	    request.setAttribute("tip", "注册失败，请检查信息填写完整且正确");
	          	     
	          	    return "forward:register.jsp";
	          	}
//	          	return null;
	          	
	             
	           
    }
    public String login(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
	              response.setContentType("text/html;charset=utf-8");
	              request.setCharacterEncoding("utf-8");
	              response.setHeader("content-type", "text/html;charset=UTF-8");
	              response.setCharacterEncoding("UTF-8");
	            
	              PrintWriter out=response.getWriter();
	             
	              
	            
	          	//检查管理员登录
	          	if(request.getParameter("identy").equalsIgnoreCase("root"))
	          	{
	          	   
	          	    String  phone=(String )request.getParameter("phone");
	          	    
	          	    String   pwd=(String )request.getParameter("pwd");
	          	    
	          	    jdbcdao<root> ace=new jdbcdao<>();
	          	    
	          	    String sql0="select * from root where rootid=? and password=?";
	          	  
	          	    
	          	    root flag=ace.loadOneObject(sql0, root.class,phone,pwd);
	          	    if (flag!=null)
	          	        {
	          		 
	          		     request.setAttribute("tip", "尊敬的管理员:");
	          		   Date d = new Date();
	 	                   System.out.println("当前时间为:" + d);
	 	                  //创建日期格式化对象(把日期转成字符串)
	 	                   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:s");
	 	                   String time= sdf.format(d);
	 	                   flag.setRecentime(time);
	          		     request.getSession().setAttribute("identy", "root");
	          		     request.getSession().setAttribute("admin",flag);
	          		     request.getSession().setMaxInactiveInterval(60*60);
	          		     return "forward:rootmenu.jsp";
	          		   
	          	            
	          	        }
	          	        else
	          	        {
	          	          request.setAttribute("tip", "登录失败，请检查账号和密码是否正确");
	          	          
	          	          return "forward:login.jsp";
	          	            
	          	        }
	          	    
	          	}
	          	//检查用户登录
	          	if(request.getParameter("identy").equalsIgnoreCase("user"))
	          	{
	          	   
	          	    String  phone=(String )request.getParameter("phone");
	          	    
	          	    String   pwd=(String )request.getParameter("pwd");
	          	    
	          	    jdbcdao<user> ace=new jdbcdao<>();
	          	    
	          	    String sql0="select * from user where userid=? and password=?";
	          	  
	          	    
	          	    user flag=ace.loadOneObject(sql0,user.class,phone,pwd);
	          	    if (flag!=null)
	          	        {
	          		   Date d = new Date();
	 	                   System.out.println("当前时间为:" + d);
	 	                   //创建日期格式化对象(把日期转成字符串)
	 	                   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:s");
	 	                   String time= sdf.format(d);
	 	                   flag.setRecentime(time);
	          		     request.setAttribute("tip", "尊敬的用户:");
	          		     
	          		     request.getSession().setAttribute("identy", "user");
	          		     request.getSession().setAttribute("person",flag);
	          		     request.getSession().setMaxInactiveInterval(60*60);
	          		     return "forward:usermenu.jsp";
	          		   
	          	            
	          	        }
	          	        else
	          	        {
	          	          request.setAttribute("tip", "登录失败，请检查账号和密码是否正确");
	          	          
	          	          return "forward:login.jsp";
	          	            
	          	        }
	          	    
	          	}
	          	return null;
	          	
	             
	           
    }
    public String searchallmv(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
	              response.setContentType("text/html;charset=utf-8");
	              request.setCharacterEncoding("utf-8");
	              response.setHeader("content-type", "text/html;charset=UTF-8");
	              response.setCharacterEncoding("UTF-8");
	            
	              PrintWriter out=response.getWriter();
	              out.print("user");
	              

	              int pageindex=Integer.parseInt(request.getParameter("pageindex"));
		      int pagesize=Integer.parseInt(request.getParameter("pagesize"));
		      out.print(pageindex);
		     out.print(pagesize);
	              if(request.getParameter("moviename")==null || request.getParameter("moviename")=="")
	              {
	                
			  Pageutil<movie> pager=new Pageutil<>();

			 String sql="select * from movie limit ?,?";
			 pager.pageshow(sql,movie.class, (pageindex-1)*pagesize,pagesize);
			
			 if(pager.getPagedata() !=null)
			 {
//			     String tip="查询成功";
//			     request.setAttribute("tip", tip);
			     request.setAttribute("pager", pager);
			     System.out.println("just try");
//			     for (movie t:pager.getPagedata() )
//			     {
//				 out.print(t);
//			     }
			     
			     return "forward:usersearchallmv.jsp";
			 }
			 else{
			     String tip="查询失败";
			     request.setAttribute("tip", tip);
			    
			     return "forward:usersearchallmv.jsp";
			 }
	
                         }
	              else{
	        	  return null;
	        	  
	              }
		  
	           
    }
    
    
    public String searchallmv2(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
	              response.setContentType("text/html;charset=utf-8");
	              request.setCharacterEncoding("utf-8");
	              response.setHeader("content-type", "text/html;charset=UTF-8");
	             
	            
	              PrintWriter out=response.getWriter();
	              out.print("user");
	              

	              int pageindex=Integer.parseInt(request.getParameter("pageindex"));
		      int pagesize=Integer.parseInt(request.getParameter("pagesize"));
		      out.print(pageindex);
		     out.print(pagesize);
	              if(request.getParameter("moviename")==null || request.getParameter("moviename")=="")
	              {
	                
			  Pageutil<movie> pager=new Pageutil<>();

			 String sql="select * from movie limit ?,?";
			 pager.pageshow(sql,movie.class, (pageindex-1)*pagesize,pagesize);
			
			 if(pager.getPagedata() !=null)
			 {
//			     String tip="查询成功";
//			     request.setAttribute("tip", tip);
			     request.setAttribute("pager", pager);
			     System.out.println("just try");
//			     for (movie t:pager.getPagedata() )
//			     {
//				 out.print(t);
//			     }
			     
			     return "forward:moviecomment.jsp";
			 }
			 else{
			     String tip="查询失败";
			     request.setAttribute("tip", tip);
			    
			     return "forward:moviecomment.jsp";
			 }
	
                         }
	              else{
	        	  return null;
	        	  
	              }
		  
	           
    }
    
    public String searchallmv3(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
	              response.setContentType("text/html;charset=utf-8");
	              request.setCharacterEncoding("utf-8");
	              response.setHeader("content-type", "text/html;charset=UTF-8");
	              response.setCharacterEncoding("UTF-8");
	            
	              PrintWriter out=response.getWriter();
	              out.print("user");
	              

	              int pageindex=Integer.parseInt(request.getParameter("pageindex"));
		      int pagesize=Integer.parseInt(request.getParameter("pagesize"));
		      out.print(pageindex);
		     out.print(pagesize);
	              if(request.getParameter("moviename")==null || request.getParameter("moviename")=="")
	              {
	                
			  Pageutil<movie> pager=new Pageutil<>();

			 String sql="select * from movie limit ?,?";
			 pager.pageshow(sql,movie.class, (pageindex-1)*pagesize,pagesize);
			
			 if(pager.getPagedata() !=null)
			 {
//			     String tip="查询成功";
//			     request.setAttribute("tip", tip);
			     request.setAttribute("pager", pager);
			     System.out.println("just try");
//			     for (movie t:pager.getPagedata() )
//			     {
//				 out.print(t);
//			     }
			     
			     return "forward:usertopmv.jsp";
			 }
			 else{
			     String tip="查询失败";
			     request.setAttribute("tip", tip);
			    
			     return "forward:usertopmv.jsp";
			 }
	
                         }
	              else{
	        	  return null;
	        	  
	              }
		  
	           
    }
    public String searchplaylist(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
	              response.setContentType("text/html;charset=utf-8");
	              request.setCharacterEncoding("utf-8");
	              PrintWriter out=response.getWriter();
	              out.print("user");

	              int pageindex=Integer.parseInt(request.getParameter("pageindex"));
		      int pagesize=Integer.parseInt(request.getParameter("pagesize"));
		      out.print(pageindex);
		     out.print(pagesize);
		     //这里是查询没有具体日期的电影档期
	              if((request.getParameter("st1")==null || request.getParameter("st1")=="")&&request.getParameter("movieid")!=null)
	              {
	                
			  Pageutil<playlist> pager=new Pageutil<>();
                         String mvid=request.getParameter("movieid");
			 String sql="select * from playlist where movieid="+mvid+" limit ?,?";
			 String sqlx="select * from movie where movieid=?";
			 jdbcdao<movie> ace=new jdbcdao<>();
			 pager.pageshow(sql,playlist.class,(pageindex-1)*pagesize,pagesize);
			 movie mv=ace.loadOneObject(sqlx, movie.class, mvid);
			 if(pager.getPagedata() !=null&&mv!=null)
			 {

			     request.setAttribute("pager", pager);
			     request.setAttribute("movie", mv);
			     
			     

			     return "forward:useraddorder.jsp";
			 }
			 else{
			     String tip="该电影并没有目前还没有档期，请期待";
			     request.setAttribute("movie", mv);
			     request.setAttribute("tip", tip);
			     
			     return "forward:useraddorder.jsp";
			 }
	
                         }
	              //这里是查询具体日期的档期
	              if(request.getParameter("st1")!=null &&request.getParameter("movieid")!=null)
	              {
	        	         Pageutil<playlist> pager=new Pageutil<>();
	                         String mvid=request.getParameter("movieid");
	                         String st1=request.getParameter("st1");
	                         st1="%"+st1+"%";
	                         out.print("st1:"+st1);
				 String sql="select * from playlist where movieid="+mvid+" and showtime1 like '"+st1+"' limit ?,?";
				 out.print(sql);
				 String sqlx="select * from movie where movieid=?";
				 jdbcdao<movie> ace=new jdbcdao<>();
				 pager.pageshow(sql,playlist.class, (pageindex-1)*pagesize,pagesize);
				 movie mv=ace.loadOneObject(sqlx, movie.class, mvid);
				 if(pager.getPagedata() !=null&&mv!=null)
				 {

				     request.setAttribute("pager", pager);
				     request.setAttribute("movie", mv);
				     
				     

				     return "forward:useraddorder.jsp";
				 }
				 else{
				     String tip="该电影还没有输入时间段的档期，请重新输入";
				     request.setAttribute("tip", tip);
				     request.setAttribute("movie", mv);
//				     out.print("1");
//				     return null;
				     return "forward:useraddorder.jsp";
				     
				 }
		
	        	  
	              }
	              
	              else{
	        	  
	        	     String tip="该电影并没有目前还没有档期，请期待";
			     request.setAttribute("tip", tip);
//			     out.print("2");
//			     return null;
			     return "forward:usersearchallmv.jsp";
	              }
		  
	           
    }
    
    //跳转到订单界面
    public String turntoorder(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
	response.setContentType("text/html;charset=utf-8");
	request.setCharacterEncoding("utf-8");
	       PrintWriter out=response.getWriter();
		if(request.getParameter("movieid")!=null&&request.getParameter("showtime1")!=null&&request.getParameter("showtime2")!=null
			&&request.getParameter("place")!=null)
		{
        		String showtime1=(String )request.getParameter("showtime1");
        		String showtime2=(String )request.getParameter("showtime2");
        		String place=(String )request.getParameter("place");
        	        int movieid=Integer.parseInt(request.getParameter("movieid"));
        	        
                       jdbcdao<movie> ace=new jdbcdao<movie>();
        	      jdbcdao<playlist> ace2=new jdbcdao<>();
        	        String sql0="select * from movie where movieid=?";
        	        String  sqlx="select * from playlist where movieid=? and showtime1=? and showtime2=? and place=?";
        //	        out.print("你是不是傻？");
        	        movie flag=ace.loadObjectById(sql0, movie.class,movieid);
        	        playlist temp=ace2.loadOneObject(sqlx, playlist.class, movieid,showtime1,showtime2,place);
        	        if (flag!=null && temp!=null)
        	        {
        	            
        	            request.setAttribute("movie", flag);
        	            request.setAttribute("play", temp);
        	            return "forward:orderchoose.jsp";
        	        }
        	        else
        	        {
        	            request.setAttribute("tip", "订票时相关信息查询失败");
        	            return "forward:orderchoose.jsp";
        	        }
		}
		 else
		        {
		     request.setAttribute("tip", "加载失败");
		     return "forward:orderchoose.jsp";
		        }
	
    }
    
    
    //确认购票
    public String orderchoose(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
	response.setContentType("text/html;charset=utf-8");
	request.setCharacterEncoding("utf-8");
	PrintWriter out=response.getWriter();
	
	
//	out.print(request.getParameter("amount"));
//	out.print(request.getParameter("no2"));
	if(request.getSession().getAttribute("person")!=null)
	{
	    user temp=(user)request.getSession().getAttribute("person");
	    int amount=Integer.parseInt(request.getParameter("amount"));
	    String moviename=request.getParameter("moviename");
	    String st1=request.getParameter("date1");
	    String st2=request.getParameter("date2");
	    String place=request.getParameter("place");
	    
	    String price=request.getParameter("price");
	    System.out.println(moviename+st1+st2+place);
	    if(amount>=1)
	    {
		int i;
		movieorder flag=null;
		int result=1;
		jdbcdao<movieorder> ace=new jdbcdao<>();
		
		String sql="insert into movieorder(userid,username,moviename,watchtime,place,seat,price) values(?,?,?,?,?,?,?)";
		String sqlx="select * from movieorder where  moviename=? and watchtime=? and place=? and seat=?";
		String sqly="select * from playlist where  moviename=? and showtime1=? and showtime2=? and place=?";
		jdbcdao<playlist> ace2=new jdbcdao<>();
		
	        playlist pt=new playlist();
	        if(ace2.loadOneObject(sqly, playlist.class, moviename,st1,st2,place)!=null)
	                   pt=ace2.loadOneObject(sqly, playlist.class, moviename,st1,st2,place);
	        //如果剩余座位小于所需座位数，说明无法购买，告知购票者
	        System.out.println("剩余"+pt.getRemainder());
	        if(pt.getRemainder()<amount)
	        {
	            String tip="该次电影剩余座位数为"+pt.getRemainder()+",因座位不足购票失败，请选择其他时间";
	            request.setAttribute("tip", tip);
		    return "forward:usersearchallmv.jsp";
	        }
		for(i=0;i<amount;i++)
		{
		    
		    String seat=request.getParameter("no"+(i+1));
//		    System.out.println(seat);
//		    System.out.println(temp.getUsername());
		    flag=ace.loadOneObject(sqlx, movieorder.class,moviename,st1+st2,place,seat);
		    //只要有一个座位是已经存在的，就说明已经被预定了，无法再次预定
		    if(flag!=null)
		    {
			result=0;
			break;
		    }
		}
		if(result==1)
		{
		    //说明这几张票都没被预定且座位充足，可以被预定
		    String sql0="update playlist set remainder=? where moviename=? and showtime1=? and showtime2=? and place=? ";
		    for(i=0;i<amount;i++)
			{
			    
			    String seat=request.getParameter("no"+(i+1));
                            //插入购票记录
			    ace.alterObject(sql,temp.getUserid(),temp.getUsername(),moviename,st1+" "+st2,place,seat,price );
			   
			   
			}
		    //插入购票记录后，将当期中的剩余票数减去这次卖出的票数
		    ace2.alterObject(sql0, pt.getRemainder()-amount,moviename,st1,st2,place);
		    request.setAttribute("tip", "购票成功");
		    return "forward:usersearchallmv.jsp";
		}
		if(result==0)
		{
		    request.setAttribute("tip", "购票失败,所购的座位已被预订");
		    return "forward:usersearchallmv.jsp";
		}
	    }
	    else{
		    request.setAttribute("tip", "购票座位数量至少为1,购票失败");
		    return "forward:usersearchallmv.jsp";
	    }
	    
	   
	}
	else{
	    out.print("用户信息获取失败,请重新登录");
	    request.setAttribute("tip", "用户信息获取失败,请重新登录");
	    return "forward:login.jsp";
	}
	return null;
    }
    //用户订单查询
    public String userordermenu(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
	              response.setContentType("text/html;charset=utf-8");
	              request.setCharacterEncoding("utf-8");
	              response.setHeader("content-type", "text/html;charset=UTF-8");
	              response.setCharacterEncoding("UTF-8");
	            
	              PrintWriter out=response.getWriter();
	              out.print("user");
	              

	              int pageindex=Integer.parseInt(request.getParameter("pageindex"));
		      int pagesize=Integer.parseInt(request.getParameter("pagesize"));
		      out.print(pageindex);
		     out.print(pagesize);
		     if(request.getSession().getAttribute("person")!=null)
			{
			    user temp=(user)request.getSession().getAttribute("person");
	              
			  Pageutil<movieorder> pager=new Pageutil<>();

			 String sql="select * from movieorder where userid="+temp.getUserid()+" limit ?,?";
			 pager.pageshow(sql,movieorder.class, (pageindex-1)*pagesize,pagesize);
			
			 if(pager.getPagedata() !=null)
			 {

			     request.setAttribute("pager", pager);

			     
			     return "forward:userordermenu.jsp";
			 }
			 else{
			     String tip="用户订单为空";
			     request.setAttribute("tip", tip);
			    
			     return "forward:userordermenu.jsp";
			 }
	
                         }
	              else{
	        	  out.print("用户信息已过期或不存在,请重新登录");
        	      	    request.setAttribute("tip", "用户信息获取失败,请重新登录");
        	      	    return "forward:login.jsp";
	        	  
	              }
		  
	           
    }
    
    
  //用户退订
    public String userdeleteorder(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
	              response.setContentType("text/html;charset=utf-8");
	              request.setCharacterEncoding("utf-8");
	              response.setHeader("content-type", "text/html;charset=UTF-8");
	              response.setCharacterEncoding("UTF-8");
	            
	              PrintWriter out=response.getWriter();
	              out.print("user");
	              

	             
		     if(request.getSession().getAttribute("person")!=null)
			{
			   
	                   jdbcdao<movieorder> ace=new jdbcdao<>();
			  
                         String id=request.getParameter("orderid");
			 String sql="delete from movieorder where orderid=?";
			 String sql2="select * from movieorder where orderid=?";
			 movieorder mvdr=ace.loadObjectById(sql2, movieorder.class, id);
			 int flag=ace.alterObject(sql, id);
			 int result=0;
			 if(flag>0)
			 {
			     result=1;
			 }
			 else{
			     result=0;
			 }
			
			
			 if(result>0)
			 {
			        
				 String time1=mvdr.getWatchtime();
				 System.out.println(time1);
				 String sql3="update playlist set remainder=remainder+1 where moviename=? and showtime1=? and showtime2=? and place=? ";
				  jdbcdao<playlist> ace2=new jdbcdao<>(); 
				  String st1=time1.substring(0, time1.indexOf(" "));
				  String st2=time1.substring(time1.indexOf(" ")+1,time1.length());
//				  System.out.println(st1);
//				  System.out.println(st2);
				  ace2.alterObject(sql3,mvdr.getMoviename(),st1,st2,mvdr.getPlace());
			     request.setAttribute("tip", "退订成功");
                            
			     
			     return "forward:userformv?handle=userordermenu&pageindex=1&pagesize=5";
			 }
			 else{
			     
			     request.setAttribute("tip", "退订失败");
			    
			     return "forward:userformv?handle=userordermenu&pageindex=1&pagesize=5";
			 }
	
                         }
	              else{
	        	  out.print("用户信息已过期或不存在,请重新登录");
        	      	    request.setAttribute("tip", "用户信息获取失败,请重新登录");
        	      	    return "forward:login.jsp";
	        	  
	              }
		  
	           
    }
    
    
    //用户修改信息
    public String userchangemessage(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
	              response.setContentType("text/html;charset=utf-8");
	              request.setCharacterEncoding("utf-8");
	              response.setHeader("content-type", "text/html;charset=UTF-8");
	              
	            
	              PrintWriter out=response.getWriter();
	              out.print("user");
	              

	             
		     if(request.getSession().getAttribute("person")!=null)
			{
			   String userid=request.getParameter("userid");
			   String username=request.getParameter("username");
			   String sex=request.getParameter("sex");
			   String age=request.getParameter("age");
			   String recentime=request.getParameter("recentime");
			   String phone=request.getParameter("phone");
			   String pwd=request.getParameter("pwd");
			   jdbcdao<user> ace=new jdbcdao<>();
			   String sql="update user set username=?,sex=?,age=?,password=? where userid=?";
			   user pn=new user();
			   pn.setUserid(userid);
			   pn.setPassword(pwd);
			   pn.setAge(age);
			   pn.setPhone(phone);
			   pn.setSex(sex);
			   pn.setUsername(username);
			   pn.setRecentime(recentime);
			   int flag=ace.alterObject(sql, username,sex,age,pwd,userid);
			   if(flag>0)
			   {
			            request.setAttribute("tip", "用户信息修改成功");
			            request.getSession().setAttribute("person",pn);
	        	      	    return "forward:usermessage.jsp";
			   }
			   else{
			            request.setAttribute("tip", "用户信息修改失败");
			            
	        	      	    return "forward:usermessage.jsp";
			   }
	
                         }
	              else{
	        	  out.print("用户信息已过期或不存在,请重新登录");
        	      	    request.setAttribute("tip", "用户信息获取失败,请重新登录");
        	      	    return "forward:login.jsp";
	        	  
	              }
		  
	           
    }
    
    public String searchcomment(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
	              response.setContentType("text/html;charset=utf-8");
	              request.setCharacterEncoding("utf-8");
	              PrintWriter out=response.getWriter();
	              out.print("user");

	              int pageindex=Integer.parseInt(request.getParameter("pageindex"));
		      int pagesize=Integer.parseInt(request.getParameter("pagesize"));
		      out.print(pageindex);
		     out.print(pagesize);
		     //这里是查询电影影评
	              if((request.getParameter("st1")==null || request.getParameter("st1")=="")&&request.getParameter("movieid")!=null)
	              {
	                
			  Pageutil<evaluate> pager=new Pageutil<>();
                         String mvid=request.getParameter("movieid");
                         //这里
			 String sql="select * from evaluate where moviename="+"(select moviename from movie where movieid="+mvid+") limit ?,?";
			 String sqlx="select * from movie where movieid=?";
			 jdbcdao<movie> ace=new jdbcdao<>();
			 pager.pageshow(sql,evaluate.class,(pageindex-1)*pagesize,pagesize);
			 movie mv=ace.loadOneObject(sqlx, movie.class, mvid);
			 if(pager.getPagedata() !=null&&mv!=null)
			 {

			     request.setAttribute("pager", pager);
			     request.setAttribute("movie", mv);
			     
			     

			     return "forward:userforcomment.jsp";
			 }
			 else{
			     String tip="该电影尚无影评";
			     request.setAttribute("movie", mv);
			     request.setAttribute("tip", tip);
			     
			     return "forward:userforcomment.jsp";
			 }
	
                         }
	              return null;
		  
	           
    }
    
    public String addcomment(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
	              response.setContentType("text/html;charset=utf-8");
	              request.setCharacterEncoding("utf-8");
	              PrintWriter out=response.getWriter();
	              out.print("user");
	              String movieid=request.getParameter("movieid");
	              if(request.getParameter("userid")!=null)
	              {
	        	  String userid=request.getParameter("userid");
	        	  if(request.getParameter("comment")!="")
	        	  {
	        	      String moviename=request.getParameter("moviename");
	        	      String score=request.getParameter("score");
	        	      String comment=request.getParameter("comment");
	        	      
	        	      Date d = new Date();
	 	                   System.out.println("当前时间为:" + d);
	 	                  //创建日期格式化对象(把日期转成字符串)
	 	                   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:s");
	 	                   String time= sdf.format(d);
	 	                   String sql="insert into evaluate values(?,?,?,?,?)";
	 	                   jdbcdao<evaluate> ace=new jdbcdao<>();
	 	                   int flag=ace.alterObject(sql, userid,moviename,time,score,comment);
	 	                   if(flag>0)
	 	                   {
	 	                      request.setAttribute("tip2", "评价发表成功");
					     
	 			     return "forward:userformv?handle=searchcomment&movieid="+movieid+"&pageindex=1&pagesize=5";
	 	                   }
	 	                   else{
	 	                     request.setAttribute("tip2", "评价发表失败");
				     
				     return "forward:userformv?handle=searchcomment&movieid="+movieid+"&pageindex=1&pagesize=5";
	 	                   }
	        	  }
	        	  else{
	        	      
	        	      request.setAttribute("tip2", "发表的评价不能为空");
				     
			     return "forward:userformv?handle=searchcomment&movieid="+movieid+"&pageindex=1&pagesize=5";
	        	  }
	              }
	              else{
	        	     request.setAttribute("tip2", "评论发表失败");
			     
			     return "forward:userformv?handle=searchcomment&movieid="+movieid+"&pageindex=1&pagesize=5";
	              }
	              
    }
    
}
    