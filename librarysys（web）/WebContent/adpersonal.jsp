<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="alljavabean.Identity" %>
<%@ page import="alljavabean.bookadmin" %>
<html>
<head>
	<title>图书管理员-管理管中心</title>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
	<link rel="stylesheet" type="text/css" href="./font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="./style/adMain.css">
  <link rel="stylesheet" type="text/css" href="./style/adBook.css">
	<script type="text/javascript" src="./script/jquery-2.1.4.min.js"></script>
   <script type="text/javascript" src="./layer-v2.0/layer/layer.js"></script>
   <script type="text/javascript" src="./layer-v2.0/layer/extend/layer.ext.js"></script>
	<script type="text/javascript">
	   $(document).ready(function() {
          $(".left ul li:eq(7)").css("color","#FFF");
          $(".left ul li:eq(7)").css("background-color","#BBCAF1");
          $(".left ul").find('li:eq(7)').children(".trig").css('display', 'block');
          $(".data input").attr('disabled', 'true');
         
          $(".inputBtn").click(function() {
             $(".data input").removeAttr('disabled');
          });
          $(".noadd_btn").click(function() {
            $(".data input").attr('disabled', 'true');
          });
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
	String tip="原密码必填。不修改密码时，新密码、确认密码留空";
	if(request.getAttribute("tip")!=null)
		tip=(String)request.getAttribute("tip");
	bookadmin ufo=(bookadmin)request.getSession().getAttribute("ufo");
	
	
	if(ufo==null)
	{
	   
	   String info="您必须登录才能访问图书馆管理系统，禁止越权访问";
	   request.setAttribute("info", info);
	   request.getRequestDispatcher("login.jsp").forward(request, response);
	  
	   ufo=new bookadmin();
   
}
		
%>
   <div class="ad_page">
   	<div class="header">
   		<img src="./images/logo.png">
   		<div class="state">
   			<div class="ad_name"><div class="fa_i"><i class="fa fa-user"></i></div><a href="">管理员：<%=idt.getUsername() %></a></div>
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
   			 <div class="ad_data">
                 <form action="adpersonalcheck" method="post">
                <input class="inputBtn" style="width:100px;height:34px;margin:0px 0px 20px 150px;font-size:16px"
                type="button" value="修改资料" />
               <div class="data data_1"><label style="color:red"><%=tip %></label></div>
               <div class="data"><label>原密码</label><input type="password" name="pwd1"/></div>
               <div class="data"><label>新密码</label><input type="password" name="pwd2"/></div>
               <div class="data"><label>确认新密码</label><input type="password" name="pwd3"/></div>
               <div class="data"><label>用户名</label><input value="<%=ufo.getAdname() %>" name="adminname"/></div>
               <div class="data"><label>电话</label><input value="<%=ufo.getAdphone() %>" name="phone"/></div>
               <div class="data"><label>邮箱</label><input type="email" name='email' value="<%=ufo.getAdemail() %>"/></div>
               <button class="add_btn" type="submit">提交修改</button>
             
               </form>
        </div>
   		</div>
   		<div class="clear"></div>
   	</div>
   </div>
</body>
</html>