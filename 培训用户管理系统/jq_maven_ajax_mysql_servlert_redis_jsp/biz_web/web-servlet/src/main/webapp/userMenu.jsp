<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page isELIgnored="false"%>
<%@page import="org.web.service.User"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="./js/jquery-3.0.0.min.js"></script>
<script >
$(function(){
$(".addbt").click(function(){
	
	window.location.href = "getArea";
})
})
</script>
<style type="text/css">
a{text-decoration:none;}
.td{
width:120px;
height:40px;
overflow:auto;
text-align:letf;
}
</style>
</head>
<body>

<c:forEach items="${listace}" var="lac">
${lac}<br>
</c:forEach>
<h2>用户管理界面</h2><label margin-right="50px;"><a href="loginOut">注销</a></label>
<form action="serchUser?pageindex=1&&pagesize=5&&pagenum=1" method="post">
用户名：<input type="text" name="user_name" style="width:50px;height:14px;"> 
<button type="submit" style="margin-left:280px">搜索</button>
<br><br>
</form>
<p style="color:red;">${tip}</p>
<button class="addbt">添加</button><br>
<c:if test="${!empty userlist }">
<table id="stutable" border="1px" bordercolor="black" 
            bgcolor="white" cellspacing="0px">

<tr><th class="td">id</th><th class="td">用户名</th><th class="td">邮箱</th><th class="td">地区</th>
<th class="td">创建时间</th><th class="td">操作</th> </tr>

<c:forEach items="${userlist}" var="lac">
<tr ><td class="td">${lac.user_id}</td><td class="td">${lac.user_name}</td><td class="td">${lac.user_mail}</td>
<td>${lac.user_area}</td><td>${lac.user_creat_time}</td>
<td>
<a href="turnToUpdate?name=${lac.user_name}">更新</a>
<a href="deleteUser?name=${lac.user_name}">删除</a>
<a href="turnToJob?user_name=${lac.user_name}">管理职位</a>
<a href="watchLog?user_name=${lac.user_name}">登录日志</a>
</td>
</tr>

</c:forEach>
</table>
<a href="serchUser?pageindex=1&&pagesize=5&&user_name=${page.option}&&pagenum=${page.pagenum}">首页</a>
<a href="serchUser?pageindex=${page.index-1}&&pagesize=5&&user_name=${page.option}&&pagenum=${page.pagenum}">上一页</a>
${page.index}/${page.pagenum}
<a href="serchUser?pageindex=${page.index+1}&&pagesize=5&&user_name=${page.option}&&pagenum=${page.pagenum}">下一页</a>
<a href="serchUser?pageindex=${page.pagenum}&&pagesize=5&&user_name=${page.option}&&pagenum=${page.pagenum}">尾页</a>
<br>

</c:if>

</body>
</html>