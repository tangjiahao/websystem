<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="./js/jquery-3.0.0.min.js"></script>
<style>
	.checkNum{
		width:150px;
		height: 60px;
		background-color: lightgrey;
		margin-left: 10px;
		opacity: 0.5;
	}
</style>
</head>
<body >
<%
   if(request.getSession().getAttribute("autologin")!=null)
   {
	   request.getRequestDispatcher("userMenu.jsp").forward(request, response);
   }
%>
<p style="color:red;">${tip}</p>
<form method="post" action="loginCheck" onsubmit="return checkinfo();">
用户名：<input type="text" name="user_name"/><br>
密码：<input type="password" name="user_pwd"/><br>
验证码:<input type="text" name="user_checknum" class="checkNum2" style="width:50px;height:14px;"/>
<label class="checkNum">3456</label>
<button type="button" class="refreshNum">刷新</button><br>
<button type="submit" >登录</button> <input type="checkbox" name="autologin"/>30天内自动登录<br>
</form>

</body>
<script>
	$(function(){
		//随机生成指定范围的数
		function random(min, max) {
              return Math.floor(Math.random() * (max - min)) + min;
          }

		function getrandomchar(){
			let str="";
			arr = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
      'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
      'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
      'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
      'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z']
			
           var len=arr.length,range=0;
		//随机生成4位验证码
		for(var i=0;i<4;i++)
		{
			range=random(0,len);
			str+=arr[range];
		}
		return str;
		}
		$(".refreshNum").click(function(){
			var s=getrandomchar();
//			alert(s);
			$(".checkNum").html(s);
		})
		$(document).ready(function(){  
     var s=getrandomchar();
//			alert(s);
			$(".checkNum").html(s);
       });  
       
		
	})
	//检查验证码是否正确
       function checkinfo(){

       	if($(".checkNum2").val()==$(".checkNum").html()){
//     		alert("验证码输入正确");
       		return true;
       	}
       	alert("验证码输入错误");
       	return false;
       }
	
	
</script>
</html>