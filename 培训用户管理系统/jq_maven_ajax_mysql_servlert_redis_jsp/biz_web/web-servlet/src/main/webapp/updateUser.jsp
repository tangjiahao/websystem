<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% String username=(String)request.getSession().getAttribute("user_name");
	   if(username==null||username=="")
	   {
		   request.setAttribute("tip","还没有登录,无权使用本系统,请先登录");
		   request.getRequestDispatcher("login.jsp").forward(request, response);
	   }
	%>
<form method="post" action="updateUser">
id:<input type="text" readonly="readonly" name="user_id" value="${user.user_id}"><br>
用户名:<input type="text" readonly="readonly" name="user_name" value="${user.user_name}"><br>
密码:<input type="text" name="user_pwd" value="${user.user_pwd} "><br>
邮箱:<input type="text" name="user_mail" value="${user.user_mail} "><br>
地区:<input type="text" name="user_area" value="${user.user_area} "><br>
爱好:<input type="text" name="user_hobby" value="${user.user_hobby} "><br>
职位:<input type="text" name="user_job" value="${user.user_job} "><br>
创建时间:<input type="text" name="user_creat_time" value="${user.user_creat_time} "><br>
<button type="submit">提交修改</button>
</form>
</body>
</html>