<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>
<link href="css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
if(top.location != self.location){
top.location = self.location;//防止页面被框架包含
}
</script>

</head>
<body>
<%
           String tip="";
    
           if(request.getAttribute("tip")!=null)
               tip=(String)request.getAttribute("tip");
           /*  将之前的登录信息消除*/
           request.getSession().removeAttribute("person");
           request.getSession().removeAttribute("admin");
           
    %>
 <label style="color:red;font-size:20px;"><%=tip %></label>   
<div class="login">

    <div class="box png">
		<h1>ACE Login</h1>
		
		<div class="input">
		
			<form action="userformv?handle=login" method="post">
			<div class="log">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label></label>
				
				<label>登录身份：</label><select name="identy" >
<option value="user">用户</option>
<option value="root">管理员</option>

</select><br>
				<div class="name">
					<label>用户名</label><input type="text" class="text" id="value_1" placeholder="用户名" name="phone" tabindex="1">
				</div>
				<div class="pwd">
					<label>密　码</label><input type="password" class="text" id="value_2" placeholder="密码" name="pwd" tabindex="2">
					<label></label>
					<button  class="submit" tabindex="3" value="登录" type="submit"> 登录</button>
					<div class="check"></div>
				</div>
				<div class="tip"></div>
			</div>
			</form>
		</div>
	</div>
    <div class="air-balloon ab-1 png"></div>
	<div class="air-balloon ab-2 png"></div>
    <div class="footer"></div>
</div>

<script type="text/javascript" src="js/jQuery.js"></script>
<script type="text/javascript" src="js/fun.base.js"></script>
<script type="text/javascript" src="js/script.js"></script>

</body>
</html>