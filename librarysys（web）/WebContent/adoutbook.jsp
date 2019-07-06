<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="alljavabean.bookinfo" %>
 <%@ page import="alljavabean.Identity" %>
<!DOCTYPE html>
<html>
<head>
	<title>图书管理员-图书出库</title>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
	<link rel="stylesheet" type="text/css" href="./font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="./style/adMain.css">
  <link rel="stylesheet" type="text/css" href="./style/adBook.css">
	<script type="text/javascript" src="./script/jquery-2.1.4.min.js"></script>
	<script type="text/javascript">
	   $(document).ready(function() {
	   	 $(".left ul li:eq(3)").css("color","#FFF");
          $(".left ul li:eq(3)").css("background-color","#BBCAF1");
          $(".left ul").find('li:eq(3)').children(".trig").css('display', 'block');
          
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
	String tip1=(String)request.getAttribute("tip");
	if(tip1==null)
		 tip1="";
	bookinfo temp=new bookinfo();
	String state="";
	if(request.getAttribute("bookmessage")!=null)
	{
		
		 temp=(bookinfo)request.getAttribute("bookmessage");
		 int t=temp.getState();
		 if(t==1)
			 state="在库";
		 if(t==0)
			 state="已借出";
		
		 
	}
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
   			<div class="ad_data">
   				<form action="bookmessagecheck" method="post">
   				<p style="color:red;font-size:16px;"><%=tip1%></p>
   				<div class="data data_1"><label>图书编号</label><input  name="bookid" value="输入图书编号" onfocus="if(value=='输入图书编号') {value=''}" onblur="if (value=='') {value='输入图书编号'}"/></div>
               <button class="add_btn" type=submit>核查信息</button>
               </form>
               <form action="outbookcheck" method="post">
               <div class="data data_1"><label>图书编号</label><input  readonly="readonly" name="bookid" value="<%=temp.getBookid()  %>"/></div>
               <div class="data"><label>图书名称</label><input readonly="readonly" value="<%=temp.getBookname()  %>"/></div>
               <div class="data"><label>作者</label><input readonly="readonly" value="<%=temp.getAuthor()  %>"/></div>
               <div class="data"><label>译者</label><input readonly="readonly" value="<%=temp.getTranslator()  %>"/></div>
               <div class="data"><label>价格</label><input readonly="readonly" value="<%=temp.getPrice()  %>"/></div>
               <div class="data"><label>ISBN编码</label><input readonly="readonly" value="<%=temp.getIsbncode()  %>"/></div>
                <div class="data"><label>出版日期</label><input readonly="readonly" value="<%=temp.getComeuptime()  %>"/></div>
               <div class="data"><label>出版社</label><input readonly="readonly" value="<%=temp.getPublishcompany()  %>"/></div>
              
               <div class="data"><label>借阅状态</label><input name="state" readonly="readonly" value="<%=state  %>"/></div>
               <div class="data"><label>入库者</label><input readonly="readonly" value="<%=temp.getEnteringmen()  %>"/></div>
               <button class="add_btn" type=submit>确认出库</button>
               </form>
   			</div>
   		</div>
   		<div class="clear"></div>
   	</div>
   </div>
</body>
</html>