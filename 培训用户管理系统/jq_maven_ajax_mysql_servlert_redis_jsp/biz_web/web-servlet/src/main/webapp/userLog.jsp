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

<h2>登录日志</h2>
<label style="color:red;">用户名:${ user_name }</label><br>
登录时间日志：<br>
<c:forEach items="${user_log}" var="lac"> 
${lac}<br><br>
</c:forEach>
</body>
</html>