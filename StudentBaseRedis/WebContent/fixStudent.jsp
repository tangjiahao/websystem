<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="TestRedis?handle=fix" method="post">
id：<input type="text" name="id" readonly="readonly" value=<%=request.getParameter("id") %>><br>
姓名：<input type="text" name="stuname"/><br>
出生日期：<input type="text" name="stubirth" /><br>
描述：<input type="text" name="studes"/><br>
平均分：<input type="text" name="stuavg"/><br>
<button type="submit">修改</button>
</form>
</body>
</html>