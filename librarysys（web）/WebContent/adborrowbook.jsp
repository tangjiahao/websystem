<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="alljavabean.borrowrecord" %>
<%@ page import="alljavabean.Identity" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
	<title>图书管理员-读者借书</title>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
	<link rel="stylesheet" type="text/css" href="./font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="./style/adMain.css">
   <link rel="stylesheet" type="text/css" href="./style/adBorrowBook.css">
	<script type="text/javascript" src="./script/jquery-2.1.4.min.js"></script>
   <script type="text/javascript" src="./layer-v2.0/layer/layer.js"></script>
	<script type="text/javascript">
	   $(document).ready(function() {
	   	 $(".left ul li:eq(0)").css("color","#FFF");
          $(".left ul li:eq(0)").css("background-color","#BBCAF1");
          $(".left ul").find('li:eq(0)').children(".trig").css('display', 'block');
          $(".A_btn").click(function() {
                var index = layer.load(1, {
                shade: [0.1,'#fff'] //0.1透明度的白色背景
                 // layer.close(index);   //关闭验证
            });
          });
          $(".B_btn").click(function() {
            $(".data input").val("");
          });
          $('input[type=text]:first').focus();//默认光标位置在input
          $(".table tbody tr:odd").css("backgroundColor","#FCF8E3");//表格奇数行背景
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
	String b0="空";
	String b1="空";
	if(request.getAttribute("borrowid2")!=null)
	  b0=(String)request.getAttribute("borrowid2");
	if(request.getAttribute("bookid2")!=null)
		  b1=(String)request.getAttribute("bookid2");
	String tip="";
	if(request.getAttribute("tip")!=null)
	  tip=(String)request.getAttribute("tip");
	String bookname="";
	if(request.getAttribute("bookname")!=null)
	  bookname=(String)request.getAttribute("bookname");
	List<borrowrecord> temp=null;
	//空的时候判断一下，给与空间
	if(request.getAttribute("records")==null)
	{
		temp=new ArrayList<borrowrecord>();
	}
	else
	{
		temp=(ArrayList<borrowrecord>)request.getAttribute("records");
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
   			<form action="adborrowbook" method="post">
   				     <div class="data data_1"><label>借阅号</label><input type="text" name="borrowid"/></div>
               <div class="data"><label>图书编号</label><input type="text" name="bookid"/></div>
               <button class="btn A_btn" type="submit">验证</button>
                <div class="data data_1"><label style="color:red"><%=tip %></label></div>
               </form>
               <div class="table_div">
                  <table class="table">
                        <thead>
                          <th>借阅号</th>
                          <th>图书名</th>
                          <th>应还日期</th>
                        </thead>
                        <tbody>
                         <% 
		              for(borrowrecord t:temp){%>
		              <tr>
		              	<td><%=t.getUserid() %></td>
		                <td><%=t.getBookname() %></td>
		               
		                <td><%=t.getShouldtime() %></td>
		              
		                
		              </tr>
		              <% }%>
                         
                        </tbody>
                     </table>
                     <form action="adborrowbook" method="post">
                     <input type="hidden" value="<%=b0 %>" name="borrowid2">
                     <input type="hidden"name="bookid2" value="<%=b1 %>">
                     <input type="hidden"name="bookname" value="<%=bookname %>">
                     <button class="add_btn" type="submit">确认借阅</button>
                     <div class="clear"></div>
                     </form>
               </div>
   			</div>
   		</div>
   		<div class="clear"></div>
   	</div>
   </div>
</body>
</html>