<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="alljavabean.Identity" %>
<%@ page import="alljavabean.borrowrecord" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
	<title>在借图书</title>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
	<link rel="stylesheet" type="text/css" href="./font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="./style/readerMain.css">
	<link rel="stylesheet" type="text/css" href="./style/readerBorrowing.css">
	<script type="text/javascript" src="../script/jquery-2.1.4.min.js"></script>
	<script type="text/javascript">
	  $(function(){
	  	 var Lis=$(".menu ul li").eq(3);
	  	 Lis.css('border-bottom', '7px solid #419EDC');
	  	 Lis.css('margin-top', '-7px');
	  	 Lis.css('color', '#419EDC');
	  	 $(".table tbody tr:odd").css("backgroundColor","#E3F2F5");
	  })
	</script>
</head>
<body>
<%
        String username=null;		
		Identity idt=(Identity)request.getSession().getAttribute("idt");		
			
		if(idt==null )
		{
		   username="";
		   String info="您必须登录才能访问图书馆管理系统，禁止越权访问";
       	   request.setAttribute("info", info);
    	   request.getRequestDispatcher("login.jsp").forward(request, response);
		   
		   
		}
		else{
			username=idt.getUsername();
		}
        List<borrowrecord> temp=null;
        //空的时候判断一下，给与空间
        if(request.getAttribute("borrowing")==null)
        {
        	temp=new ArrayList<borrowrecord>();
        }
        else
        {
        	temp=(ArrayList<borrowrecord>)request.getAttribute("borrowing");
        }
        int num=(int)request.getAttribute("haveborrowed");
    
    %>
<div class="header">
	<div class="header">
		<div class="home_logo"><a href="index.jsp"><i class="fa fa-home">首页</i></a></div>
		<div class="page_title">个人中心</div>
		<div class="out_page"><a  href="dealloginout" ><font color="white">退出</font></a></div>
	</div>
</div>
<div class="book_logo">
	<img src="./images/booklogo.png">
</div>
<div class="reader_name"><%=username %></div>
<div class="menu">
	<ul>
		<a href="readerpersonal.jsp"><li class="first_li">基本资料</li></a>
		<a href="readeralterdata.jsp"><li class="other_li">修改资料</li></a>
		<a href="readeralterpaswd.jsp"><li class="other_li">修改密码</li></a>
		<a href="readerborrowingcheck"><li class="other_li">在借图书</li></a>
		<a href="readerborrowedcheck"><li class="last_li">借阅记录</li></a>
	</ul>
	<div class="clear"></div>
</div>
<!-- class="content"的div中是个人中心的切换部分 -->
<div class="content">
       <div class="book_num">
       	 <div class="borred">已借: <span><%=num %></span>本</div>
       	 <div class="borred">剩余可借: <span><%=10-num %></span>本</div>
       </div>
	    <div class="table_div">
          <table class="table">
            <thead>
              <th>序号</th>
              <th>借阅记录号</th>
              <th>图书名</th>
              <th>应还日期</th>
            </thead>
            <tbody>
            <% int k=1;
              for(borrowrecord t:temp){%>
              <tr>
              	<td><%=k%></td>
                <td><%=t.getBorrowid()%></td>
                <td><%=t.getBookname()%></td>
                <td><%=t.getShouldtime()%></td>
              </tr>
              <% k++;}%>
            </tbody>
           </table>
        </div>
</div>
<div class="footer">
	    <br/>   
		<p>@Copyright重庆理工大学中山图书馆</p>
	</div>
</body>
</html>