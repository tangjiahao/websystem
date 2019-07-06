<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="alljavabean.bookadmin" %>
<%@ page import="alljavabean.Identity" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
  <title>系统管理员-查看管理员信息</title>
  <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
  <link rel="stylesheet" type="text/css" href="./font-awesome/css/font-awesome.min.css">
  <link rel="stylesheet" type="text/css" href="./style/adminMain.css">
  <link rel="stylesheet" type="text/css" href="./style/searchTable.css">
  <script type="text/javascript" src="./script/jquery-2.1.4.min.js"></script>
  <script type="text/javascript">
     $(document).ready(function() {
          $(".left ul li:eq(7)").css("color","#FFF");
          $(".left ul li:eq(7)").css("background-color","#B78DE7");
          $(".left ul").find('li:eq(7)').children(".trig").css('display', 'block');
          $(".table tbody tr:odd").css("backgroundColor","#DFF0D8");
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
	int num=0;
	if(request.getAttribute("searchnum")!=null)
		num=(int)request.getAttribute("searchnum");
	List<bookadmin> temp=null;
	//空的时候判断一下，给与空间
	if(request.getAttribute("searchad")==null)
	{
		temp=new ArrayList<bookadmin>();
	}
	else
	{
		temp=(ArrayList<bookadmin>)request.getAttribute("searchad");
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
        <form action="adminsearchadcheck" method="post">
         <div class="search">
              <input type="text"  name="search" value="输入搜索信息，如11503" onfocus="if(value=='输入搜索信息，如11503') {value=''}" onblur="if (value=='') {value='输入搜索信息，如11503'}" />
              <button class="btn" type="submit">搜索</button>
         </form>
          <div class="book_num">
       	 <div class="borred">共搜索到<span><%=num %></span>条信息</div>
       	
         </div>
          <div>
                 <% if(request.getAttribute("searchad")!=null){%>
                 <div class="table_div">
                     <table class="table">
                       <thead>
                          <tr>
                             <th>编号</th>
                             <th>用户名</th>
                             <th>电话</th>
                             <th>邮箱</th>
                          </tr>
                       </thead>
                       <tbody>
                           <% 
		              for(bookadmin t:temp){%>
		              <tr>
		              	<td><%=t.getAdid() %></td>
		                <td><%=t.getAdname() %></td>
		               
		                <td><%=t.getAdphone() %></td>
		                <td><%=t.getAdemail()  %></td>
		                
		              </tr>
		              <% }%>
                          
                          </tbody>
                     </table>
                  </div>
                 <%} %> 
        </div>
      </div>
      <div class="clear"></div>
    </div>
   </div>
</body>
</html>