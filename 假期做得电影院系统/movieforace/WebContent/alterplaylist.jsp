<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page import="dao.*"%>
<%@ page import="alljavabean.*"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload=function()//用window的onload事件，窗体加载完毕的时候
{
	//do something
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
      playlist ace=null;
      if(request.getAttribute("play1")!=null)
	  ace=(playlist)request.getAttribute("play1");
     

%>
<p style="color:red;font-size:25px;"><%=tip %></p>

<%if(request.getAttribute("play1")!=null ){ %>
<form action="rootformv?handle=alterplay" method="post">
电影id：<input type="text" name="mvid"  value=<%=ace.getMovieid()%> readonly="readonly" style="background-color:grey;"><br>
电影名：<input type="text" name="mvname" value=<%=ace.getMoviename()%> readonly="readonly" style="background-color:grey;"><br>
具体日期：<input type="text" name="st1" value=<%=ace.getShowtime1()%> readonly="readonly" style="background-color:grey;">
具体时间:<input type="text" name="st2" value=<%=ace.getShowtime2()%> readonly="readonly" style="background-color:grey;">
<%-- <select name="st2" readonly="readonly" style="background-color:grey;">
<option value="9:00">9:00</option>
<option value="11:00">11:00</option>
<option value="13:00">13:00</option>
<option value="15:00">15:00</option>
<option value="17:00">17:00</option>
<option value="19:00">19:00</option>
<option value="<%=ace.getShowtime2()%>" selected="selected"><%=ace.getShowtime2() %></option>
</select> --%><br>
地点：<input type="text" name="place" value="<%=ace.getPlace()%>" readonly="readonly" style="background-color:grey;width:100px;">号厅
<%-- <select name="place" readonly="readonly" style="background-color:grey;">
<option value="1">1号厅</option>
<option value="2">2号厅</option>
<option value="3">3号厅</option>
<option value="4">4号厅</option>
<option value="<%=ace.getPlace() %>" selected="selected"><%=ace.getPlace() %>号厅</option>
</select> --%>
剩余座位：<input type="text" name="rd" value=<%=ace.getRemainder()%> readonly="readonly" style="background-color:grey;"><br>
价格：<input type="text" name="price" value=<%=ace.getPrice()%>>RMB<br>
<button type="submit">修改</button>
</form>
<%} %>
</body>
</html>