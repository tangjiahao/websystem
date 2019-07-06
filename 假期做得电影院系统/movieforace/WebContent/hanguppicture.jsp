<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <style type="text/css">
 #qt{
 width:100px;
 height:150px;
 
 }
 </style>
 
 <script>
    /* function changeace(){
    	var obj = document.getElementById('fileupload') ; 
    	obj.outerHTML=obj.outerHTML; 
    } */
 </script>
</head>
<body>

<%
       String path="";
       if(request.getAttribute("picture")!=null)
       {
	   path=(String)request.getAttribute("picture");
       }
%>
<img  src="<%=request.getContextPath()+"/images/"+path %>" id="qt">

<form action="ace" method="post">
<input type="file" name="picture" value=""  onchange="changeace()" id="fileupload">
<button type="submit">提交图片</button>
</form>
</body>
</html>