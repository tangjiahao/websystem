<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="alljavabean.Identity" %>
<%@ page import="alljavabean.userinfo" %>
<html>
<head>
	<title>修改资料</title>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
	<link rel="stylesheet" type="text/css" href="./font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="./style/readerMain.css">
	<link rel="stylesheet" type="text/css" href="./style/readerAlterData.css">
	<script type="text/javascript" src="./script/jquery-2.1.4.min.js"></script>
	<script type="text/javascript">
	  $(function(){
	  	 var Lis=$(".menu ul li").eq(1);
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
        userinfo ufo=(userinfo)request.getSession().getAttribute("ufo");
       
        String tip=(String)request.getAttribute("tip");
        if(tip==null)
        {
    	   tip="";
        }
    
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
<form action="readalterdatasevlet" method="post">
<div class="content">
    
	<div class="data"><label>电话</label><input value="<%=ufo.getPhone() %>" name="phone"/></div>
    <div class="data"><label>邮箱</label><input value="<%=ufo.getEmail() %>" name="email"/></div>
    <button type="submit" class="add_btn">确认修改 <p style="color:red;font-size:16px;"><%=tip%></p></button>
   
</div>
</form>
<div class="footer">
	    <br/>   
		<p>@Copyright重庆理工大学中山图书馆</p>
	</div>
</body>
</html>