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
<h2>登录日志</h2>
<label style="color:red;">用户名:${ user_name }</label><br>
登录时间日志：<br>
<c:forEach items="${user_log}" var="lac"> 
${lac}<br><br>
</c:forEach>
</body>
</html>