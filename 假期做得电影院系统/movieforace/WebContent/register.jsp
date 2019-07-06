<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>register for ACE</title>

<!-- CSS -->

<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/form-elements.css">
<link rel="stylesheet" href="assets/css/style.css">



<!-- Favicon and touch icons -->
<link rel="shortcut icon" href="assets/ico/favicon.png">
<link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">

<script>
	//判断注册的手机号是否合法
	function checkphone(objx){
		    //alert("进入号码判定");
			var phone = objx.value;
			var regex_tel = /^1[345789]\d{9}$/
			if (!regex_tel.test(phone)){
				document.getElementById("phonetip").innerHTML = "非法手机号!";
				document.getElementById("phonetip").className = "errortip";
				document.getElementById("flag1").value ="false";
				
			}else{
				document.getElementById("phonetip").innerHTML = "√";
				document.getElementById("phonetip").className = "righttip";
				document.getElementById("flag1").value ="true";
			}
			
		}
	//判断两次密码是否相同
	function checkpwd()
{
//	alert("进入了密码");
	var pwd1=document.getElementsByName("pwd")[0].value;
	var pwd2=document.getElementsByName("pwd2")[0].value;
//	alert(pwd1);
//	alert(pwd2);
    if(pwd2==""||pwd1=="")
    {
    	 document.getElementById("pwdtip").innerHTML = "密码不能为空!";
		document.getElementById("pwdtip").className = "errortip";
		document.getElementById("flag2").value ="false";
	
    }
	if(pwd1!=pwd2)
	{
		document.getElementById("pwdtip").innerHTML = "两次密码不相同!";
		document.getElementById("pwdtip").className = "errortip";
		document.getElementById("flag2").value ="false";
		
		
	}
	     
	else{
		document.getElementById("pwdtip").innerHTML = "√";
		document.getElementById("pwdtip").className = "righttip";
		document.getElementById("flag2").value ="true";
	}
}
</script>
</head>

<body>
<%
           String tip="";
    
           if(request.getAttribute("tip")!=null)
               tip=(String)request.getAttribute("tip");
           
    %>
<!-- Content -->
<div class="top-content">
	<p style="color:red;font-size:25px;"><%=tip %></p>
	<div class="inner-bg">
		<div class="container">
			<div class="row">
				<div class="col-sm-8 col-sm-offset-2 text">
					<strong>Movie Register</strong>
					<h1><strong>ACE</strong> Personal Registration Form</h1>
					<div class="description">
						<p>
							This is the unique registration interface of ACE movie web. It is elegant and concise. 
							You are welcome to join our movie web, don't wait for it,let's go!
						</p>
					</div>
					<div class="top-big-link">
						<a class="btn btn-link-1 launch-modal" href="#" data-modal-id="modal-register">Launch check!</a>
						<a href="login.jsp"><button>login?</button></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</div>

<!-- MODAL -->
<div class="modal fade" id="modal-register" tabindex="-1" role="dialog" aria-labelledby="modal-register-label" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
				<h3 class="modal-title" id="modal-register-label">Sign up now</h3>
				<p>Fill in the form below to get instant access:</p>
			</div>
			
			<div class="modal-body">
				
				<form role="form" action="userformv?handle=register" method="post" class="registration-form">
					<div class="form-group">
						
						<input type="text" name="phone" placeholder="id(电话号码)..." class="form-first-name form-control" id="ace1" onblur="checkphone(this)">
						<font id="phonetip" size="3" >
					     
					</div>
					<div class="form-group">
						
						<input type="text" name="username" placeholder="（昵称）..." class="form-last-name form-control" id="ace2">
					</div>
					<div class="form-group">
						
						<input type="text" name="sex" placeholder="性别(如：男)..." class="form-email form-control" id="ace3">
					</div>
					<div class="form-group">
						
						<input type="text" name="age" placeholder="年龄(如：23)..." class="form-email form-control" id="ace3">
					</div>
					<div class="form-group">
						
						<input type="password" name="pwd" placeholder="密码..." class="form-email form-control" id="ace3">
					</div>
					<div class="form-group">
						
						<input type="password" name="pwd2" placeholder="确认密码..." class="form-email form-control" id="ace3" onblur="checkpwd()">
						 <font id="pwdtip" size="3" ></font>
						 <input id="flag1" name="flag1" style="display: none;" value="false"/>
						 <input id="flag2" name="flag2" style="display: none;" value="false"/>
					</div>
					<button type="submit" class="btn">Sign me up!</button>
				</form>
				
			</div>
			
		</div>
	</div>
</div>

<!-- Javascript -->
<script src="assets/js/jquery-1.11.1.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/jquery.backstretch.min.js"></script>
<script src="assets/js/scripts.js"></script>



</body>
</html>