<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="alljavabean.borrowrecord" %>
<%@ page import="alljavabean.Identity" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
	<title>图书管理员-借阅查询</title>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
	<link rel="stylesheet" type="text/css" href="./font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="./style/adMain.css">
   <link rel="stylesheet" type="text/css" href="./style/adCheckBook.css">
   <link rel="stylesheet" type="text/css" href="./style/login.css">
    <link rel="stylesheet" type="text/css" href="./font-awesome/css/font-awesome.min.css">
    <script type="text/javascript" src="./script/jquery-2.1.4.min.js"></script>
	
	<script type="text/javascript">
	   $(document).ready(function() {
         var left_li= $(".left ul li:eq(5)");
	   	    left_li.css("color","#FFF");
          left_li.css("background-color","#BBCAF1");
          $(".left ul").find('li:eq(5)').children(".trig").css('display', 'block');
          $(".table tbody tr:odd").css("backgroundColor","#E3F2F5");
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
			List<borrowrecord> temp=null;
			//空的时候判断一下，给与空间
			if(request.getAttribute("searchrecord")==null)
			{
				temp=new ArrayList<borrowrecord>();
				
			}
			else
			{
				temp=(ArrayList<borrowrecord>)request.getAttribute("searchrecord");
				
			}
			List<borrowrecord> temp1=null;
			//空的时候判断一下，给与空间
			if(request.getAttribute("searchrecord2")==null)
			{
				temp1=new ArrayList<borrowrecord>();
				
			}
			else
			{
				temp1=(ArrayList<borrowrecord>)request.getAttribute("searchrecord2");
				
			}
			List<borrowrecord> temp2=null;
			//空的时候判断一下，给与空间
			if(request.getAttribute("searchrecord3")==null)
			{
				temp2=new ArrayList<borrowrecord>();
				
			}
			else
			{
				temp2=(ArrayList<borrowrecord>)request.getAttribute("searchrecord3");
				
			}
			
		%>
   <div class="ad_page">
   	<div class="header">
   		<img src="./images/logo.png">
   		<div class="state">
   			<div class="ad_name"><div class="fa_i"><i class="fa fa-user"></i></div><a href="../html/adPersonal.html">管理员:<%=username %></a></div>
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
   			<form action="adsearchrecord" method="post">
   				 <div class="search">
   				    <select class="role"  name="searchtype">
				<option value="userid">借阅号</option>
				<option value="bookid">图书编号</option>
				<option value="bookname">图书名</option>
			      </select><br>
                    <input type="text" name="search" value="选择搜索种类，输入搜索信息" onfocus="if(value=='选择搜索种类，输入搜索信息') {value=''}" onblur="if (value=='') {value='选择搜索种类，输入搜索信息'}" />
                    <button class="btn" type="submit">搜索</button>
                </div>
                </form><br>
                      <%if(request.getAttribute("searchrecord2")!=null) {%>
                      <div class="table_div">
                     <table class="table">
                     <thead>
                        
                        <tr>
                           <th class="tdOne">图书编号</th>
                           <th>图书名称</th>
                           
                           
                           <th class="tdOne">借阅号</th>
                          
                           <th class="tdOne">应还日期</th>
                           <th class="tdOne">实还日期</th>
                        </tr>
                     </thead>
                     <tbody>
                     <%for(borrowrecord t:temp1) {%>
                         <tr>
                           <td><%=t.getBookid() %></td>
                           <td><%=t.getBookname() %></td>
                           <td><%=t.getUserid() %></td>
                         
                           <td><%=t.getShouldtime() %></td>
                           <td><%=t.getReturntime() %></td>
                           
                        </tr>
                        <%} %> 
                        </tbody>
                     </table>
                     <%} %>
                     
                     <%if(request.getAttribute("searchrecord3")!=null) {%>
                      <div class="table_div">
                     <table class="table">
                     <thead>
                        
                        <tr>
                          
                           <th>图书名称</th>
                            <th class="tdOne">图书编号</th>
                           
                           <th class="tdOne">借阅号</th>
                          
                           <th class="tdOne">应还日期</th>
                           <th class="tdOne">实还日期</th>
                        </tr>
                     </thead>
                     <tbody>
                     <%for(borrowrecord t:temp2) {%>
                         <tr>
                           
                           <td><%=t.getBookname() %></td>
                           <td><%=t.getBookid() %></td>
                           <td><%=t.getUserid() %></td>
                          
                           <td><%=t.getShouldtime() %></td>
                           <td><%=t.getReturntime() %></td>
                           
                        </tr>
                        <%} %> 
                        </tbody>
                     </table>
                     <%} %>
                     
                     
                     <%if(request.getAttribute("searchrecord")!=null){%>
                     <table class="table">
                        <thead>
                          <th>借阅号</th>
                          <th>图书名</th>
                          <th>应还日期</th>
                          <th>实还日期</th>
                        </thead>
                        <tbody>
                        <%for(borrowrecord t:temp) {%>
                          <tr>
                            <td><%=t.getUserid() %></td>
                            <td><%=t.getBookname() %></td>
                            <td><%=t.getShouldtime() %></td>
                            <td><%=t.getReturntime() %></td>
                          </tr>
                          
                         <%} %>
                        </tbody>
                     </table>
                     <%} %>
                  </div>
                 
   			</div>
   		</div>
   		<div class="clear"></div>
   	</div>
   </div>
</body>
</html>