<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    
	<title>登录</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <link rel="stylesheet" type="text/css" href="./style/login.css">
    <link rel="stylesheet" type="text/css" href="./font-awesome/css/font-awesome.min.css">
    <script type="text/javascript" src="./script/jquery-2.1.4.min.js"></script>
    <script type="text/javascript">
    	
    	
        function password_f(){
            alert("亲，请到教务系统修改密码！");
        }
    </script>
</head>
<body>
 <%
    String info=(String)request.getAttribute("info");
    if(info==null)
 	   info="";
    
    %>
<div class="login_page">
    
    <form action="logincheck" method="post">
	<div class="page_top"></div>
	<div class="header"> 
	    <div class="home_logo"><a  href="index.jsp"><i class="fa fa-home">首页</i></a></div>
		<img src="./images/logo.png">
		<div class="hello_word">中山图书馆欢迎您</div>
		
		<div class="clear"></div>
	</div>
	<div class="login">
		<div class="login_part" >
		     
			<select class="role"  name="shenfen">
				<option value="read">读者</option>
				<option value="manage">图书管理员</option>
				<option value="root">系统管理员</option>
			</select>
			<hr class="lion" />
            <div class="login_input">
                <p style="color:red;font-size:16px;"><%=info %></p>
            	<div class="user"><i class="fa fa-user"></i></div>
            	<input type="text" name="username" value="请输入通行证号"onfocus="if (value =='请输入通行证号'){value=''}" onblur="if (value=='') {value='请输入通行证号'}"/>&nbsp;<span class="text_red">*</span>
            	<div class="user"><i class="fa fa-lock"></i></div>
            	<input type="password" name="password"/>&nbsp;<span class="text_red">*</span>
            </div>
            <button class="login_btn" type="submit">登录</button>
            <div class="password_f" onclick="password_f()">忘记密码 ？</div>
		</div>
		<div class="clear"></div>
		<div class="from">@Copyright重庆理工大学中山图书馆</div>
	</div>
	
</div>
</form>
</body>
</html>