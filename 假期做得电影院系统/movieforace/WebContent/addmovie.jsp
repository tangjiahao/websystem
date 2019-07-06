<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*"%>
<%@ page import="alljavabean.*"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增电影</title>
<script type="text/javascript">
function searchone(){
	
	
	
	/* var tip=document.getElementsByName("moviename")[0].value;
	
	alert(tip); 
	
	window.location.href="rootformv?handle=searchmvmessage&moviename="+encodeURI(encodeURI(tip));  */
} 

</script>
</head>
<body>
<%
/* 越权访问的判断 */
root person=null;
if(request.getSession().getAttribute("admin")!=null)
    person=(root)request.getSession().getAttribute("admin");
else
{
    request.setAttribute("tip", "用户信息已过期或不存在,请重新登录");
    request.getRequestDispatcher("login.jsp").forward(request, response);
    }
String tip="";

if(request.getAttribute("tip")!=null)
    tip=(String)request.getAttribute("tip");
%>

   <p style="color:red;font-size:25px;"><%=tip %></p>

 <form action="rootformv?handle=addmovie" method="post">

电影名：<input name="mvname" type="text"   placeholder="请输入电影名">(必填)<br>

主演：<input name="actor" type="text" >(必填)<br>
封面：<input name="cover" type="file" ><br>

评分：<input name="score" type="text" >(必填)<br>
类型：<input name="type" type="text"  >(必填)<br>
简介(必填)：<br><textarea name="summary" style="width:300px;height:180px;"></textarea><br>
<button type="submit">增加</button>
</form>
</body>
</html>