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
/* 越权访问的判断 */
user person=null;
if(request.getSession().getAttribute("person")!=null)
    person=(user)request.getSession().getAttribute("person");
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
<%if(person!=null) {%>
<form action="userformv?handle=userchangemessage" method="post">
<label>账号：</label><input type="text" value="<%=person.getUserid()    %>"  name="userid"  readonly="readonly" style="background-color:rgb(132,133,135);"><br>
<label>昵称：</label><input type="text" value="<%=person.getUsername()    %>"  name="username"><br>
<label>性别：</label><input type="text" value="<%=person.getSex()    %>"  name="sex"><br>
<label>电话：</label><input type="text" value="<%=person.getPhone()    %>"  name="phone" readonly="readonly" style="background-color:rgb(132,133,135);"><br>
<label>年龄：</label><input type="text" value="<%=person.getAge()    %>"  name="age"><br>
<label>密码：</label><input type="text" value="<%=person.getPassword()    %>"  name="pwd"><br>
<label>最近登录时间：</label><input type="text" value="<%=person.getRecentime()   %>"  name="recentime" readonly="readonly" style="background-color:rgb(132,133,135);"><br>
<button type="submit">修改信息</button>
</form>
<%} %>
</body>
</html>