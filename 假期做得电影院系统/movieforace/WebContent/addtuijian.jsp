<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="dao.*"%>
<%@ page import="alljavabean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
      
String tip="";

if(request.getAttribute("tip")!=null)
    tip=(String)request.getAttribute("tip");
String id="";
if(request.getParameter("movieid")!=null)
id=request.getParameter("movieid");
%>
<form action="rootformv?handle=addrecommend" method="post">
<input name="movieid" value="<%=id %>">
<button type="submit">确认推荐</button>
</form>
</body>
</html>