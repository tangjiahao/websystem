<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="alljavabean.userinfo" %>
 <%@ page import="alljavabean.Identity" %>
<!DOCTYPE html>
<html>
<head>
  <title>系统管理员-修改读者信息</title>
  <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
  <link rel="stylesheet" type="text/css" href="./font-awesome/css/font-awesome.min.css">
  <link rel="stylesheet" type="text/css" href="./style/adminMain.css">
  <link rel="stylesheet" type="text/css" href="./style/adminReader.css">
  <script type="text/javascript" src="./script/jquery-2.1.4.min.js"></script>
  <script type="text/javascript">
     $(document).ready(function() {
          $(".left ul li:eq(2)").css("color","#FFF");
          $(".left ul li:eq(2)").css("background-color","#B78DE7");
          $(".left ul").find('li:eq(2)').children(".trig").css('display', 'block');
         
         
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
     String tip1=(String)request.getAttribute("tip1");
     if(tip1==null)
    	 tip1="";
     userinfo temp=new userinfo();
     String t1="";
     String t2="";
     if(request.getAttribute("usermessage")!=null)
     {
    	
    	 temp=(userinfo)request.getAttribute("usermessage");
    	 t1=Integer.toString(temp.getMax());
    	 t2=Integer.toString(temp.getLendednum());
     }
     
%>
   <div class="ad_page">
    <div class="header">
      <img src="./images/logo.png">
      <div class="state">
        <div class="ad_name"><div class="fa_i"><i class="fa fa-user"></i></div><a href="">系统管理员：<%=username %></a></div>
        <div class="out"><a href="dealloginout">退出</a></div>
      </div>
      <div class="clear"></div>
    </div>
    <div class="content">
      <div class="left">
        <ul>
         <a href="adminaddreader.jsp"><li>录入新读者<div class="trig"></div></li></a>
          <a href="adminoutreader.jsp"><li>删除读者<div class="trig"></div></li></a>
          <a href="adminalterreader.jsp"><li>修改读者信息<div class="trig"></div></li></a>
          <a href="adminaddad.jsp"><li>录入图书管理员<div class="trig"></div></li></a>
          <a href="adminoutad.jsp"><li>删除图书管理员<div class="trig"></div></li></a>
          <a href="adminalterad.jsp"><li>修改管理员信息<div class="trig"></div></li></a>
          <a href="adminsearchreader.jsp"><li>查看读者信息<div class="trig"></div></li></a>
          <a href="adminsearchad.jsp"><li>查看管理员信息<div class="trig"></div></li></a>
          <a href="adminpersonal.jsp"><li>管理员中心<div class="trig"></div></li></a>
        </ul>
      </div>
      <div class="right">
      <!-- class="ad_data"的div中是系统管理员系统的切换部分 -->
        <div class="ad_data">
          <form action="readermessagecheck2" method="post">
   			    <p style="color:red;font-size:16px;"><%=tip1%></p>
          <div class="data"><label>借阅号</label><input  name="borrowid" value="输入借阅号" onfocus="if(value=='输入借阅号') {value=''}" onblur="if (value=='') {value='输入借阅号'}"/></div>
          
                <button class="add_btn" type=submit>核查信息</button>
           </form>
                <form action="alterreadercheck" method="post">
   				<div class="data"><label>借阅号</label><input  value='<%=temp.getUserid() %>'  name="borrowid2" readonly="readonly"/></div>
                <div class="data"><label>用户名</label><input value='<%=temp.getUsername() %>' name='k2'/></div>
                <div class="data"><label>学院</label><input value='<%=temp.getDepartments() %>' name='k3'/></div>
                <div class="data"><label>专业</label><input value='<%=temp.getMajor() %>' name='k4'/></div>
                <div class="data"><label>电话</label><input value='<%=temp.getPhone() %>' name='k5'/></div>
                <div class="data"><label>邮箱</label><input value='<%=temp.getEmail() %>' name='k6'/></div>
                <div class="data"><label>借阅上限</label><input value='<%=t1%>' name='k7'/></div>
                <div class="data"><label>借阅期限</label><input value='<%=temp.getTime() %>' name='k8'/></div>
              
                <button class="add_btn" type='submit'>确认修改</button>
                </form>
               
        </div>
      </div>
      <div class="clear"></div>
    </div>
   </div>
</body>
</html>