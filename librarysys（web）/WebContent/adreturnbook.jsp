<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="alljavabean.Identity" %>    
<!DOCTYPE html>
<html>
<head>
	<title>图书管理员-读者还书</title>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
	<link rel="stylesheet" type="text/css" href="./font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="./style/adMain.css">
   <link rel="stylesheet" type="text/css" href="./style/adReturnBook.css">
	<script type="text/javascript" src="./script/jquery-2.1.4.min.js"></script>
	<script type="text/javascript">
	   $(document).ready(function() {
	   	 $(".left ul li:eq(1)").css("color","#FFF");
          $(".left ul li:eq(1)").css("background-color","#BBCAF1");
          $(".left ul").find('li:eq(1)').children(".trig").css('display', 'block');
          $('input[type=text]:first').focus();//默认光标位置在input
	   });
	</script>
</head>
<body>
<%
String username=null;		
Identity idt=(Identity)request.getSession().getAttribute("idt");		
	
if(idt==null )
{
   username="";
   String info="您必须登录才能访问图书馆管理系统，禁止越权访问";
	   request.setAttribute("info", info);
   request.getRequestDispatcher("login.jsp").forward(request, response);
   
   
}
else{
	username=idt.getUsername();
}
String tip="";
if(request.getAttribute("tip")!=null)
  tip=(String)request.getAttribute("tip");
%>
   <div class="ad_page">
   	<div class="header">
   		<img src="./images/logo.png">
   		<div class="state">
   			<div class="ad_name"><div class="fa_i"><i class="fa fa-user"></i></div><a href="">管理员:<%=username %></a></div>
            <div class="out"><a href="dealloginout">退出</a></div>
   		</div>
   		<div class="clear"></div>
   	</div>
   	<div class="content">
   		<div class="left">
   			<ul>
   				<a href="adborrowbook.jsp"><li>读者借书<div class="trig"></div></li></a>
               <a href="adreturnbook.jsp"><li>读者还书<div class="trig"></div></li></a>
               <a href="adaddbook.jsp"><li>新书入库<div class="trig"></div></li></a>
               <a href="adoutbook.jsp"><li>图书出库<div class="trig"></div></li></a>
               <a href="adalterbook.jsp"><li>修改图书信息<div class="trig"></div></li></a>
               <a href="adcheckbook.jsp"><li>查阅借阅记录<div class="trig"></div></li></a>
               <a href="adsearchbook.jsp"><li>查阅图书信息<div class="trig"></div></li></a>
               <a href="adpersonal.jsp"><li>管理员中心<div class="trig"></div></li></a>
   			</ul>
   		</div>
   		<div class="right">
         <!-- class="ad_data"的div中是图书管理员系统的切换部分 -->
         <form action="adreturnbook" method="post">
   			<div class="ad_data">
               <div class="data"><label>图书编号</label><input type="text" name="bookid"/></div>
               <button class="add_btn" type="submit">确认归还</button>
                <div class="data data_1"><label style="color:red"><%=tip %></label></div>
   			</div>
   			</form>
   		</div>
   		<div class="clear"></div>
   	</div>
   </div>
</body>
</html>