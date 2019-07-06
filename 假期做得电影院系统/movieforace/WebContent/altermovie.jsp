<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*"%>
<%@ page import="alljavabean.*"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>电影调整</title>
<script type="text/javascript">
function searchone(){
	
	
	
	var tip=document.getElementsByName("moviename")[0].value;
	
	/* alert(tip);  */
	
	window.location.href="rootformv?handle=searchmvmessage&moviename="+encodeURI(encodeURI(tip)); 
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

<%
           
           movie mv=new movie();
           if(request.getAttribute("mv")!=null)
               mv=(movie)request.getAttribute("mv");
    %>
   <p style="color:red;font-size:25px;"><%=tip %></p>
电影名：<input name="moviename" type="text" value="<%=mv.getMoviename() %>" onblur="searchone()" placeholder="请输入想修改的电影名"><br><br><br><br>
 <form action="rootformv?handle=altermovie" method="post">
电影id：<input name="mvid" type="text" value="<%=mv.getMovieid()    %>" readonly="readonly" style="background-color:grey;"><br>
电影名：<input name="mvname" type="text" value="<%=mv.getMoviename() %>"  placeholder="请输入修改后的电影名"><br>

主演：<input name="actor" type="text" value="<%=mv.getActors()    %>"  style="width:400px;height:25px;"><br>
封面：<img alt="" src="<%=request.getContextPath()+"/images/"+mv.getCover() %>" style="width:140px;height:200px;">
<input name="cover" type="text" value="<%=mv.getCover()    %>" style="width:70px;display:none" ><br>

评分：<input name="score" type="text" value="<%=mv.getScore()    %>" ><br>
类型：<input name="type" type="text" value="<%=mv.getType()    %>" ><br>
简介：<br><textarea name="summary" style="width:300px;height:180px;"><%=mv.getSummary() %></textarea><br>
<button type="submit">修改</button>
</form>
</body>
</html>