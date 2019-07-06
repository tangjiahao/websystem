<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="dao.*"%>
<%@ page import="alljavabean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>电影封面图片上传</title>
</head>
<body>
<%
     movie ace=null;
     if(request.getAttribute("movie")!=null)
     {
	      ace=(movie)request.getAttribute("movie");
     }
     
%>
<div style="text-align:center;">

<%
       if(ace!=null){
%>
<p>电影名：<%=ace.getMoviename() %></p><br>
<p>类型：<%=ace.getType() %></p><br>
<p>评分：<%=ace.getScore() %></p><br>
<form action="rootformv?handle=uploadcover&movieid=<%=ace.getMovieid() %>&ace='123' " method="post">
<input type="file" name="cover">
<button type="submit">提交封面</button>
</form>
<%} %>
</div>
</body>
</html>