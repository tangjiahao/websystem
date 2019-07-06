<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="alljavabean.Identity" %>
<html>
<head>
	<title>修改密码</title>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
	<link rel="stylesheet" type="text/css" href="./font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="./style/readerMain.css">
	<link rel="stylesheet" type="text/css" href="./style/readerAlterPaswd.css">
	<script type="text/javascript" src="./script/jquery-2.1.4.min.js"></script>
	<script type="text/javascript">
	  $(function(){
	  	 var Lis=$(".menu ul li").eq(2);
	  	 Lis.css('border-bottom', '7px solid #419EDC');
	  	 Lis.css('margin-top', '-7px');
	  	 Lis.css('color', '#419EDC');
	  	 $('input[type=password]:first').focus();//默认光标位置在input
	  })
	</script>
</head>
<body>
<%
		Identity idt=(Identity)request.getSession().getAttribute("idt");		
		String username=null;			
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
        String tip=(String)request.getAttribute("tip");
        if(tip==null)
        	tip="";
        
        		
    
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
<form action="readeralterpaswdcheck" method="post">
<div class="content">1
	<div class="data"><label>原密码</label><input type="password"  name="pwd1"/></div>
    <div class="data"><label>新密码</label><input   type="password"  name="pwd2"/></div>
    <div class="data"><label>确认新密码</label><input  type="password" name="pwd3"/></div>
    <button class="add_btn" type="submit">确认修改<p style="color:red;font-size:16px;"><%=tip%></button>
</div>
</form>
<div class="footer">
	    <br/>   
		<p>@Copyright重庆理工大学中山图书馆</p>
	</div>
</body>
</html>