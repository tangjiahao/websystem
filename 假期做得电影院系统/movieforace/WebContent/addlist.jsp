<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String tip="";
if(request.getAttribute("tip")!=null)
	  tip=(String)request.getAttribute("tip"); %>
<p style="color:red;font-size:25px;"><%=tip %></p>
<form action="rootformv?handle=addlist" method="post">
电影id：<input type="text" name="mvid"  ><br>
电影名：<input type="text" name="mvname" ><br>
具体日期：<input type="text" name="st1" >
具体时间:
<select name="st2" readonly="readonly" >
<option value="9:00">9:00</option>
<option value="11:00">11:00</option>
<option value="13:00">13:00</option>
<option value="15:00">15:00</option>
<option value="17:00">17:00</option>
<option value="19:00">19:00</option>

</select><br>
地点：
<select name="place" readonly="readonly" >
<option value="1">1号厅</option>
<option value="2">2号厅</option>
<option value="3">3号厅</option>
<option value="4">4号厅</option>

</select>
剩余座位：<input type="text" name="rd" ><br>
价格：<input type="text" name="price">RMB<br>
<button type="submit">提交档期</button>
</form>
</body>
</html>