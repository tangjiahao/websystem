package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.apache.jasper.tagplugins.jstl.core.Out;

import com.alibaba.fastjson.asm.Type;
import com.sun.corba.se.spi.ior.iiop.AlternateIIOPAddressComponent;
import com.sun.org.apache.bcel.internal.generic.Select;
import com.tedu.base.servlet.BusinessServlet;

import alljavabean.*;
import dao.Pageutil;
import dao.jdbcdao;
import java.net.*;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/rootformv")
public class rootformv extends BusinessServlet {
	private static final long serialVersionUID = 1L;
        jdbcdao<movie> dao=new jdbcdao<movie>();
        
    /**
     * @see HttpServlet#HttpServlet()
     */
    public rootformv() {
        super();
        // TODO Auto-generated constructor stub
    }
    



    public String searchmovie(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
	              response.setContentType("text/html;charset=utf-8");
	              request.setCharacterEncoding("utf-8");
	              response.setHeader("content-type", "text/html;charset=UTF-8");
	              response.setCharacterEncoding("UTF-8");
	            
	              PrintWriter out=response.getWriter();
	              out.print("user");
	              
//	              out.print(URLDecoder.decode(request.getParameter("moviename"),"UTF-8"));//这里是通过js失去焦点传递过来的参数处理
//	              out.print(request.getParameter("moviename").getClass().toString());
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
//			     for (movie t:pager.getPagedata() )
//			     {
//				 out.print(t);
//			     }
			     
			     return "forward:rootsearchmv.jsp";
			 }
			 else{
			     String tip="查询失败";
			     request.setAttribute("tip", tip);
			    
			     return "forward:rootsearchmv.jsp";
			 }
	
                         }
	              else{
	        	  String moviename=URLDecoder.decode(request.getParameter("moviename"),"UTF-8");
	        	  Pageutil<movie> pager=new Pageutil<>();
                                 String option="'%"+moviename+"%'";
				 String sql="select * from  movie where moviename like"+option+"or type like "+option+" limit ?,?";
				 if(moviename.equals("null"))
				     sql="select * from movie limit ?,?";
				 pager.pageshow(sql, movie.class,(pageindex-1)*pagesize,pagesize);
				
				 if(pager.getPagedata() !=null)
				 {
//				     String tip="查询成功";
//				     request.setAttribute("tip", tip);
				     request.setAttribute("pager", pager);
				     request.setAttribute("info",moviename );
				     for (movie t:pager.getPagedata() )
				     {
					 out.print(t);
				     }
				     
				     return "forward:rootsearchmv.jsp";
				 }
				 else{
				     String tip="查询失败";
				     request.setAttribute("tip", tip);
				     request.setAttribute("info",moviename );
				     return "forward:rootsearchmv.jsp";
				 }
	        	  
	        	  
	              }
		  
	           
    }
    
    public String searchplaylist(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
	              response.setContentType("text/html;charset=utf-8");
	              request.setCharacterEncoding("utf-8");
	              PrintWriter out=response.getWriter();
	              out.print("user");
	              out.print(request.getParameter("moviename"));
	              int pageindex=Integer.parseInt(request.getParameter("pageindex"));
		      int pagesize=Integer.parseInt(request.getParameter("pagesize"));
		      out.print(pageindex);
		     out.print(pagesize);
	              if(request.getParameter("moviename")==null || request.getParameter("moviename")=="")
	              {
	                
			  Pageutil<playlist> pager=new Pageutil<>();

			 String sql="select * from playlist limit ?,?";
			 pager.pageshow(sql,playlist.class, (pageindex-1)*pagesize,pagesize);
			
			 if(pager.getPagedata() !=null)
			 {

			     request.setAttribute("pager", pager);
			     
			     

			     return "forward:rootalterplaylist.jsp";
			 }
			 else{
			     String tip="查询失败";
			     request.setAttribute("tip", tip);
			     
			     return "forward:rootalterplaylist.jsp";
			 }
	
                         }
	              else{
	        	  String moviename=URLDecoder.decode(request.getParameter("moviename"),"UTF-8");//中文url的传参处理
	        	  Pageutil<playlist> pager=new Pageutil<>();
                                 String option="'%"+moviename+"%'";
				 String sql="select * from  playlist where moviename like"+option+"or place like "+option+" limit ?,?";
				 if(moviename.equals("null"))
				     sql="select * from playlist limit ?,?";
				 pager.pageshow(sql, playlist.class,(pageindex-1)*pagesize,pagesize);
				
				 if(pager.getPagedata() !=null)
				 {

				     request.setAttribute("pager", pager);
				     request.setAttribute("info",moviename );
				     out.print(moviename);
				     
				     return "forward:rootalterplaylist.jsp";
				 }
				 else{
				     String tip="查询失败";
				     request.setAttribute("tip", tip);
				     request.setAttribute("info",moviename );
				     out.print(moviename);
				     
				     return "forward:rootalterplaylist.jsp";
				 }
	        	  
	        	  
	              }
		  
	           
    }
    
    public String searchuser(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
	              response.setContentType("text/html;charset=utf-8");
	              request.setCharacterEncoding("utf-8");
	              PrintWriter out=response.getWriter();
	              
	              int pageindex=Integer.parseInt(request.getParameter("pageindex"));
		      int pagesize=Integer.parseInt(request.getParameter("pagesize"));
		      out.print(pageindex);
		     out.print(pagesize);
	              if(request.getParameter("username")==null || request.getParameter("username")=="")
	              {
	                
			  Pageutil<user> pager=new Pageutil<>();

			 String sql="select * from user limit ?,?";
			 pager.pageshow(sql,user.class, (pageindex-1)*pagesize,pagesize);
			
			 if(pager.getPagedata() !=null)
			 {

			     request.setAttribute("pager", pager);
			     
			     

			     return "forward:rootsearchuser.jsp";
			 }
			 else{
			     String tip="查询失败";
			     request.setAttribute("tip", tip);
			     
			     return "forward:rootsearchuser.jsp";
			 }
	
                         }
	              else{
	        	  String moviename=request.getParameter("username");//中文url的传参处理
	        	  Pageutil<user> pager=new Pageutil<>();
                                 String option="'%"+moviename+"%'";
				 String sql="select * from  user where username like"+option+"or userid like "+option+" limit ?,?";
				 
				 pager.pageshow(sql, user.class,(pageindex-1)*pagesize,pagesize);
				
				 if(pager.getPagedata() !=null)
				 {

				     request.setAttribute("pager", pager);
				     request.setAttribute("info",moviename );
				     out.print(moviename);
				     
				     return "forward:rootsearchuser.jsp";
				 }
				 else{
				     String tip="查询失败";
				     request.setAttribute("tip", tip);
				     request.setAttribute("info",moviename );
				     out.print(moviename);
				     
				     return "forward:rootsearchuser.jsp";
				 }
	        	  
	        	  
	              }
		  
	           
    }
    public void uploadcover(HttpServletRequest request,HttpServletResponse response) throws IOException {
	response.setContentType("text/html;charset=utf-8");
	request.setCharacterEncoding("utf-8");
	
	PrintWriter out=response.getWriter();
	
	    if(request.getParameter("cover")!="" && request.getParameter("cover")!=null)
	    {
	    String p1=(String )(request.getParameter("cover"));
	    String p2=(String )request.getParameter("movieid");
	    
	    String sql0="update movie set cover=? where movieid=?";
	    jdbcdao<movie> ace=new jdbcdao<movie>();
	    int flag=ace.alterObject(sql0,p1,p2);
	   
	    if (flag>0)
	        {
	            out.print("封面上传成功.......<br>");
	            out.print("<a href='rootformv?handle=searchmovie&pageindex=1&pagesize=5'>返回电影查询界面</a>");
	        }
	        else
	        {
	            out.print("封面上传失败.......<br>");
	            out.print("<a href='rootformv?handle=searchmovie&pageindex=1&pagesize=5'>返回电影查询界面</a>");
	        }
	    
	    }
	    else{
	    out.print("封面资源不存在，上传失败.......<br>");
	    out.print("<a href='rootformv?handle=searchmovie&pageindex=1&pagesize=5'>返回电影查询界面</a>");
	    }
    
    }
    public String turntocover(HttpServletRequest request,HttpServletResponse response) throws IOException {
	response.setContentType("text/html;charset=utf-8");
	request.setCharacterEncoding("utf-8");
	
	PrintWriter out=response.getWriter();
	
	    if(request.getParameter("movieid")!="" && request.getParameter("movieid")!=null)
	    {
	    String movieid=(String )(request.getParameter("movieid"));
	   jdbcdao<movie> ace=new jdbcdao<movie>();
	  
	    
	    String sql0="select * from movie where movieid=?";
	    movie result=ace.loadOneObject(sql0, movie.class, movieid);
	   
	   
	   
	    if (result!=null)
	        {
		    request.setAttribute("movie", result);
		    
		     return "forward:uploadcover.jsp";
	            
	        }
	        else
	        {
	            out.print("电影信息获取失败.......<br>");
	            out.print("<a href='rootformv?handle=searchmovie&pageindex=1&pagesize=5'>返回电影查询界面</a>");
	            return null;
	        }
	    
	    }
	    else{
	    out.print("错误访问.......<br>");
	    out.print("<a href='rootformv?handle=searchmovie&pageindex=1&pagesize=5'>返回电影查询界面</a>");
	    return null;
	    }
	    
    
    }
    public String deleteplay(HttpServletRequest request,HttpServletResponse response) throws IOException
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
	        
               jdbcdao<playlist> ace=new jdbcdao<playlist>();
		
	        String sql0="delete from playlist where movieid=? and showtime1=? and showtime2=? and place=?";
//	        out.print("你是不是傻？");
	        int flag=ace.alterObject(sql0, movieid,showtime1,showtime2,place);
	        if (flag>0)
	        {
	            out.print("删除成功");
	            out.print("<a href='rootalterplaylist.jsp'>返回查询界面</a>");
	        }
	        else
	        {
	            out.print("删除失败");
	            out.print("<a href='rootalterplaylist.jsp'>返回查询界面</a>");
	        }
		}
		 else
		        {
		            out.print("没有获得完整 的电影档期信息");
		            out.print("<a href='rootalterplaylist.jsp'>返回查询界面</a>");
		        }
	return null;
    }
    public String altertoplay(HttpServletRequest request,HttpServletResponse response) throws IOException
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
	        
               jdbcdao<playlist> ace=new jdbcdao<playlist>();
		
	        String sql0="select * from playlist where movieid=? and showtime1=? and showtime2=? and place=?";
//	        out.print("你是不是傻？");
	        playlist play1=ace.loadOneObject(sql0, playlist.class, movieid,showtime1,showtime2,place);
	        if (play1!=null)
	        {
	            out.print("档期信息获取成功");
	            request.setAttribute("play1", play1);
		    request.setAttribute("tip", "success!");
		    out.print(play1);
		    return "forward:alterplaylist.jsp";
	        }
	        else
	        {
	            out.print("档期信息获取失败");
	            out.print("<a href='rootalterplaylist.jsp'>返回查询界面</a>");
	        }
		}
		 else
		        {
		            out.print("没有获得完整 的电影档期信息");
		            out.print("<a href='rootalterplaylist.jsp'>返回查询界面</a>");
		        }
	return null;
    }
    public String alterplay(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
	response.setContentType("text/html;charset=utf-8");
	response.setCharacterEncoding("utf-8");
	PrintWriter out=response.getWriter();
	out.print("x");
	out.print(request.getParameter("price"));
	if(request.getParameter("mvid")!=null)
	{
	    int mvid=Integer.parseInt((String) request.getParameter("mvid"));
	    String  mvname=(String )request.getParameter("mvname");
	    String          st1=(String )request.getParameter("st1");
	    String          st2=(String )request.getParameter("st2");
	    String          place=(String )request.getParameter("place");
	    int rd=Integer.parseInt( request.getParameter("rd"));
	    double price=Double.parseDouble(request.getParameter("price"));
	    System.out.println(mvid+st1+st2+place);
	    jdbcdao<playlist> ace=new jdbcdao<>();
	    String sql0="update  playlist set price=? where movieid=? and showtime1=? and showtime2=? and place=?";
	    int flag=ace.alterObject(sql0, price,mvid,st1,st2,place);
	    if (flag>0)
	        {
		 
		     request.setAttribute("tip", "档期信息修改成功");
		     
		     return "forward:rootalterplaylist.jsp";
	            
	        }
	        else
	        {
	            request.setAttribute("tip", "档期信息修改失败");
		     
		     return "forward:rootalterplaylist.jsp";
	            
	        }
	    
	}
	else{
	    request.setAttribute("tip", "档期信息获取失败,请重试");
	     
	     return "forward:rootalterplaylist.jsp";
	}
//	return null;
	
    }
    
    public String addlist(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
	response.setContentType("text/html;charset=utf-8");
	response.setCharacterEncoding("utf-8");
	PrintWriter out=response.getWriter();
	out.print("x");
	out.print(request.getParameter("price"));
	if(request.getParameter("mvid")!=null)
	{
	    int mvid=Integer.parseInt((String) request.getParameter("mvid"));
	    String  mvname=(String )request.getParameter("mvname");
	    String          st1=(String )request.getParameter("st1");
	    String          st2=(String )request.getParameter("st2");
	    String          place=(String )request.getParameter("place");
	    int rd=Integer.parseInt( request.getParameter("rd"));
	    double price=Double.parseDouble(request.getParameter("price"));
	    System.out.println(mvid+st1+st2+place);
	    jdbcdao<playlist> ace=new jdbcdao<>();
	   
	    String sql0="select * from  playlist  where showtime1=? and showtime2=? and place=?";
	   playlist p1=ace.loadOneObject(sql0,playlist.class,st1,st2,place);
	   
	    if (p1!=null)
	        {
		    //存在，说明这个时候这个点的这个厅是已经被使用的，无法增加档期
		     request.setAttribute("tip", "该段时间该电影厅已经被排挡，无法增加，请重新选择");
		     
		     return "forward:addlist.jsp";
	            
	        }
	        else
	        {
	            //不存在，说明这个时间点是可以增加档期的
	            
	            String sqlx="insert into playlist values(?,?,?,?,?,?,?)";
	            int flag=ace.alterObject(sqlx, mvname,st1,st2,place,rd,mvid,price);
		    if(flag>0)
		    {
			request.setAttribute("tip", "档期增加成功");
			     
			return "forward:addlist.jsp";
		    }
		    else{
			request.setAttribute("tip", "增加失败，该档期中的电影并不存在，请添加电影信息之后再增加其档期");
			     
			return "forward:addlist.jsp";
		    }
	            
	        }
	    
	}
	else{
	    request.setAttribute("tip", "档期信息获取失败,请重试");
	     
	     return "forward:rootalterplaylist.jsp";
	}
//	return null;
	
    }
    //修改用的电影查询
    public String searchmvmessage(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
	response.setContentType("text/html;charset=utf-8");
	response.setCharacterEncoding("utf-8");
	PrintWriter out=response.getWriter();
	
	out.print(URLDecoder.decode(request.getParameter("moviename"),"UTF-8"));
	if(request.getParameter("moviename")!=null)
	{
	    
	    String  mvname=URLDecoder.decode(request.getParameter("moviename"),"UTF-8");//中文url的传参处理
	    System.out.println("mv:"+mvname);
	    jdbcdao<movie> ace=new jdbcdao<movie>();
	    
	    String sql0="select *  from  movie  where moviename=?";
	   movie mv=ace.loadOneObject(sql0,movie.class,mvname);
	   
	    if (mv!=null)
	        {
		  
		     request.setAttribute("mv", mv);
		     System.out.println(mv);
		    return "forward:altermovie.jsp"; 
	            
	        }
	        else
	        {
	            
	            
	            
			request.setAttribute("tip", "电影信息获取失败，请检查电影名是否输入正确再重试");
			     
		    return "forward:altermovie.jsp"; 
		    
	            
	        }
	    
	}
	else{
	    request.setAttribute("tip", "电影名获取失败");
	     
	    return "forward:altermovie.jsp"; 
	}
//	return null;
	
    }
    //删除用的电影查询
    public String searchmvmessage2(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
	response.setContentType("text/html;charset=utf-8");
	response.setCharacterEncoding("utf-8");
	PrintWriter out=response.getWriter();
	
	out.print(URLDecoder.decode(request.getParameter("moviename"),"UTF-8"));
	if(request.getParameter("moviename")!=null)
	{
	    
	    String  mvname=URLDecoder.decode(request.getParameter("moviename"),"UTF-8");//中文url的传参处理
	    System.out.println("mv:"+mvname);
	    jdbcdao<movie> ace=new jdbcdao<movie>();
	    
	    String sql0="select *  from  movie  where moviename=?";
	   movie mv=ace.loadOneObject(sql0,movie.class,mvname);
	   
	    if (mv!=null)
	        {
		  
		     request.setAttribute("mv", mv);
		     System.out.println(mv);
		    return "forward:deletemovie.jsp"; 
	            
	        }
	        else
	        {
	            
	            
	            
			request.setAttribute("tip", "电影信息获取失败，请检查电影名是否输入正确再重试");
			     
			    return "forward:deletemovie.jsp"; 
		    
	            
	        }
	    
	}
	else{
	    request.setAttribute("tip", "电影名获取失败");
	     
	    return "forward:deletemovie.jsp"; 
	}
//	return null;
	
    }
    
    public String altermovie(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
	response.setContentType("text/html;charset=utf-8");
	response.setCharacterEncoding("utf-8");
	PrintWriter out=response.getWriter();
	
	out.print(request.getParameter("mvname"));
	if(request.getParameter("mvid")!=null)
	{
	    int mvid=Integer.parseInt((String) request.getParameter("mvid"));
	    String  mvname=(String )request.getParameter("mvname");
	    String          actor=(String )request.getParameter("actor");
	    String          cover=(String )request.getParameter("cover");
	    String          score=(String )request.getParameter("score");
	    String          type=(String )request.getParameter("type");
	    String          summary=(String )request.getParameter("summary");
	    
	    System.out.println(mvname+actor);
	    jdbcdao<movie> ace=new jdbcdao<>();
	    String sql0="update  movie set moviename=?,actors=?,cover=?,score=?,type=?,summary=? where movieid=?";
	    int flag=ace.alterObject(sql0, mvname,actor,cover,score,type,summary,mvid);
	    if (flag>0)
	        {
		 
		     request.setAttribute("tip", "电影信息修改成功");
		     
		     return "forward:altermovie.jsp";
	            
	        }
	        else
	        {
	            request.setAttribute("tip", "电影信息修改失败");
		     
	            return "forward:altermovie.jsp";
	            
	        }
	    
	}
	else{
	    request.setAttribute("tip", "电影信息获取失败,请重试");
	     
	    return "forward:altermovie.jsp";
	}
//	return null;
	
    }
    
    public String addmovie(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
	response.setContentType("text/html;charset=utf-8");
	response.setCharacterEncoding("utf-8");
	PrintWriter out=response.getWriter();
	
//	out.print(request.getParameter("mvname"));
	if(request.getParameter("mvname")!=""&&request.getParameter("actor")!=""&&request.getParameter("score")!=""
		&&request.getParameter("type")!=""&&request.getParameter("summary")!="")
	{
	   
	    String  mvname=(String )request.getParameter("mvname");
	    
	    String          actor=(String )request.getParameter("actor");
	    String          score=(String )request.getParameter("score");
	    String          type=(String )request.getParameter("type");
	    String          summary=(String )request.getParameter("summary");
	    String  cover="0.jpg";
	    if(request.getParameter("cover")!="")
		cover=(String )request.getParameter("cover");
	    System.out.println(mvname+actor);
	    jdbcdao<movie> ace=new jdbcdao<>();
	    
	    String sql0="insert into movie(moviename,actors,cover,score,type,summary,recommend) values(?,?,?,?,?,?,?)";
	    String sqlx="select * from movie where moviename=?";
	    movie mv1=ace.loadOneObject(sqlx, movie.class, mvname);
	    if(mv1!=null)//看一下加入的电影是否已经存在，如果存在，直接返回，不进行后续操作
	    {
		     request.setAttribute("tip", "电影添加失败，该电影已经存在，无法重复添加");
		     
		     return "forward:addmovie.jsp";
	    }
	    
	    int flag=ace.alterObject(sql0,mvname,actor,cover,score,type,summary,"no" );
	    if (flag>0)
	        {
		 
		     request.setAttribute("tip", "电影添加成功");
		     
		     return "forward:addmovie.jsp";
	            
	        }
	        else
	        {
	            request.setAttribute("tip", "电影添加失败,请重试");
		     
	            return "forward:addmovie.jsp";
	            
	        }
	    
	}
	else{
	    request.setAttribute("tip", "添加失败，请确认必填项不为空");
	     
	    return "forward:addmovie.jsp";
	}
//	return null;
	
    }
    
    public String deletemovie(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
	response.setContentType("text/html;charset=utf-8");
	response.setCharacterEncoding("utf-8");
	PrintWriter out=response.getWriter();
	
	out.print(request.getParameter("mvid"));
	if(request.getParameter("mvid")!=null)
	{
	    int mvid=Integer.parseInt((String) request.getParameter("mvid"));
	   
	    jdbcdao<movie> ace=new jdbcdao<>();
	    String sql0="delete from movie where movieid=?";
	    int flag=ace.alterObject(sql0, mvid);
	    if (flag>0)
	        {
		 
		     request.setAttribute("tip", "电影删除成功");
		     
		     return "forward:deletemovie.jsp";
	            
	        }
	        else
	        {
	            request.setAttribute("tip", "电影删除失败");
		     
	            return "forward:deletemovie.jsp";
	            
	        }
	    
	}
	else{
	    request.setAttribute("tip", "电影信息获取失败,请重试");
	     
	    return "forward:deletemovie.jsp";
	}
//	return null;
	
    }
    public String searchrecommend(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
	response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setHeader("content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
      
        PrintWriter out=response.getWriter();
        out.print("user");
        

       
          
		  Pageutil<movie> pager=new Pageutil<>();

		 String sql="select * from movie limit ?,?";
		 pager.pageshow(sql,movie.class, 0,25);
		
		 if(pager.getPagedata() !=null)
		 {
		     request.setAttribute("tip", "");
		     request.setAttribute("pager", pager);
		     return "forward:tuijian.jsp";
		 }
		 else{
		     String tip="查询失败";
		     request.setAttribute("tip", tip);
		    
		     return "forward:tuijian.jsp";
		 }

       
        
	
    }
    public String addrecommend(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
	response.setContentType("text/html;charset=utf-8");
	response.setCharacterEncoding("utf-8");
	PrintWriter out=response.getWriter();
	
//	out.print(request.getParameter("mvname"));
	if(request.getParameter("movieid")!="")
	{
	    int movieid=Integer.parseInt(request.getParameter("movieid"));
	    
	    
	   
	    jdbcdao<movie> ace=new jdbcdao<>();
	    String sql0="update  movie set recommend=? where movieid=?";
	    int flag=ace.alterObject(sql0, "yes",movieid);
	    if (flag>0)
	        {
		 
		     request.setAttribute("tip", "电影推荐成功");
		     System.out.println("推荐成功");
		     return "forward:rootformv?handle=searchrecommend";
	            
	        }
	        else
	        {
	            request.setAttribute("tip", "电影推荐失败");
		     
	            return "forward:rootformv?handle=searchrecommend";
	            
	        }
	    
	}
	else{
	    request.setAttribute("tip", "电影id获取失败,请重试");
	     
	    return "forward:rootformv?handle=searchrecommend";
	}
//	return null;
	
    }
    public String deleterecommend(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
	response.setContentType("text/html;charset=utf-8");
	response.setCharacterEncoding("utf-8");
	PrintWriter out=response.getWriter();
	
//	out.print(request.getParameter("mvname"));
	if(request.getParameter("movieid")!="")
	{
	    int movieid=Integer.parseInt(request.getParameter("movieid"));
	    
	    
	   
	    jdbcdao<movie> ace=new jdbcdao<>();
	    String sql0="update  movie set recommend=? where movieid=?";
	    int flag=ace.alterObject(sql0, "no",movieid);
	    if (flag>0)
	        {
		 
		     request.setAttribute("tip", "取消推荐成功");
		     System.out.println("推荐成功");
		     return "forward:rootformv?handle=searchrecommend";
	            
	        }
	        else
	        {
	            request.setAttribute("tip", "取消推荐失败");
		     
	            return "forward:rootformv?handle=searchrecommend";
	            
	        }
	    
	}
	else{
	    request.setAttribute("tip", "电影id获取失败,请重试");
	     
	    return "forward:rootformv?handle=searchrecommend";
	}
//	return null;
    }
    
    
  //用户订单查询
    public String rootordermenu(HttpServletRequest request,HttpServletResponse response) throws IOException
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
		     
		     if(request.getSession().getAttribute("admin")!=null &&(request.getParameter("allorder")=="" || request.getParameter("allorder")==null))
			{
//			    user temp=(user)request.getSession().getAttribute("person");
	                  
			  Pageutil<movieorder> pager=new Pageutil<>();

			 String sql="select * from movieorder limit ?,?";
			 out.print(sql);
			 pager.pageshow(sql,movieorder.class, (pageindex-1)*pagesize,pagesize);
			
			 if(pager.getPagedata() !=null)
			 {

			     request.setAttribute("pager", pager);
//                             return null;
			    
			     return "forward:rootordermenu.jsp";
			 }
			 else{
			     String tip="订单查询失败";
			     request.setAttribute("tip", tip);
//			     return null;
			     return "forward:rootordermenu.jsp";
			 }
	
                         }
		     
		     if(request.getSession().getAttribute("admin")!=null &&request.getParameter("allorder")!="")
			{
			 
			 
			    String username=request.getParameter("allorder");
	                    username="%"+username+"%";
			  Pageutil<movieorder> pager=new Pageutil<>();
			  
			  
			 String sql="select * from movieorder where username like '"+username+"' limit ?,?";
			 out.print(sql);
			 System.out.println(sql);
			 pager.pageshow(sql,movieorder.class, (pageindex-1)*pagesize,pagesize);
			
			 if(pager.getPagedata() !=null)
			 {

			     request.setAttribute("pager", pager);

//                           return null;
				    
			     return "forward:rootordermenu.jsp";
			 }
			 else{
			     String tip="该用户订单为空";
			     request.setAttribute("tip", tip);
//                           return null;
				    
			     return "forward:rootordermenu.jsp";
			 }
	
                      }
		     
		     
	              else{
	        	  out.print("用户信息已过期或不存在,请重新登录");
        	      	    request.setAttribute("tip", "用户信息获取失败,请重新登录");
        	      	    return "forward:login.jsp";
	        	  
	              }
		  
	           
    }
    
}
