<%@page import="java.util.ArrayList"%>
<%@page import="Bean.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
a{text-decoration:none;}
.td{
width:150px;
height:40px;
overflow:auto;
text-align:center;
}
</style>
<script type="text/javascript">
function addone(){
	location.href="addStudent.jsp";
}
function turnpage(object){
	var s=object.value;
	location.href="TestRedis?handle=watch&&pageindex="+s;
}

</script>
</head>
<body>
<h1>学生数据库管理系统（redis版本）</h1>
<form action="TestRedis?handle=watch&&pageindex=1" method="post">
<button type="submit">查询信息</button>
</form>


<input type="button" name="addbutton" value="新增" onclick="addone()"/><br>
<c:if test="${!empty stulist}">
学生所有信息:
<table id="stutable" border="1px" bordercolor="black" style='text-align:left'
            bgcolor="white" cellspacing="0px">

<tr><th class="td">id</th><th class="td">姓名</th><th class="td">出生日期</th><th class="td">描述</th>
<th class="td">平均分</th><th class="td">修改</th><th class="td">删除</th></tr>

<c:forEach items="${stulist}" var="lac">
<tr ><td class="td">${lac.id}</td><td class="td">${lac.name}</td><td class="td">${lac.birthday}</td>
<td class="td">${lac.description}</td><td class="td">${lac.avgscore}</td>
<td class="td"><a href="TestRedis?handle=delete&&id=${lac.id}">删除</a></td>
<td class="td"><a href="fixStudent.jsp?id=${lac.id}">修改</a></td></tr>

</c:forEach>
</table>
<a href="TestRedis?handle=watch&&pageindex=${pageStu.pageindex-1}">上一页</a>
<a href="TestRedis?handle=watch&&pageindex=${pageStu.pageindex+1}">下一页</a>
当前页：${pageStu.pageindex}/${pageStu.pagemax}&nbsp;&nbsp;共${pageStu.datacount}条数据<br>
跳转到：<input type="text" onblur="turnpage(this)">
</c:if>

</body>
</html>