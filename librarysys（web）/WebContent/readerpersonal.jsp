<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="alljavabean.Identity" %>
<%@ page import="alljavabean.userinfo" %>
<html>
<head>
    
	<title>基本资料</title>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
	<link rel="stylesheet" type="text/css" href="./font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="./style/readerMain.css">
	<link rel="stylesheet" type="text/css" href="./style/readerPersonal.css">
	<script type="text/javascript" src="./script/jquery-2.1.4.min.js"></script>
	<script type="text/javascript">
	  $(function(){
	  	 var Lis=$(".menu ul li").eq(0);
	  	 Lis.css('border-bottom', '7px solid #419EDC');
	  	 Lis.css('margin-top', '-7px');
	  	 Lis.css('color', '#419EDC');
	  })
	</script>
</head>
<body>
<%
        Identity idt=(Identity)request.getSession().getAttribute("idt");
        
        String username=null;
        userinfo ufo=(userinfo)request.getSession().getAttribute("ufo");
        
        if(idt==null || ufo==null)
        {
    	   username="";
    	   String info="您必须登录才能访问图书馆管理系统，禁止越权访问";
       	   request.setAttribute("info", info);
    	   request.getRequestDispatcher("login.jsp").forward(request, response);
    	   idt=new Identity();
    	   ufo=new userinfo();
    	   
        }
        else{
        	username=idt.getUsername();
        }
      
        	
        
       
    
    %>
<div class="header">
	<div class="header">
		<div class="home_logo"><a  href="index.jsp"><i class="fa fa-home">首页</i></a></div>
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
	<div class="data"><label>借阅号</label><div><%=ufo.getUserid() %></div></div>
	<div class="data"><label>用户名</label><div><%=idt.getUsername() %></div></div>
    <div class="data"><label>学院</label><div><%=ufo.getDepartments() %></div></div>
    <div class="data"><label>专业</label><div><%=ufo.getMajor() %></div></div>
	<div class="data"><label>电话</label><div><%=ufo.getPhone() %></div></div>
    <div class="data"><label>邮箱</label><div><%=ufo.getEmail() %></div></div>
    <div class="data"><label>借阅上限</label><div><%=ufo.getMax() %></div></div>
    <div class="data"><label>借书期限</label><div><%=ufo.getTime() %>天</div></div>
    <div class="data"><label>已借数量</label><div><%=ufo.getLendednum() %></div></div>
</div>
<div class="footer">
	    <br/>   
		<p>@Copyright重庆理工大学中山图书馆</p>
	</div>
</body>
</html>