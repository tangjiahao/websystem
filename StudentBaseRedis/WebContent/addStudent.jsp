<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="TestRedis?handle=add&&${pageStu.pageindex}" method="post">
id：<input type="text" name="stuid"/><br>
姓名：<input type="text" name="stuname"/><br>
出生日期：<input type="text" name="stubirth" placeholder="格式如：1995-02-01"/><br>
描述：<input type="text" name="studes"/><br>
平均分：<input type="text" name="stuavg"/><br>
<button type="submit">新增</button>
</form>
</body>
</html>