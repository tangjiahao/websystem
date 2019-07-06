<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="alljavabean.bookinfo" %>
<%@ page import="alljavabean.Identity" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
  <title>图书管理员-图书查询</title>
  <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
  <link rel="stylesheet" type="text/css" href="./font-awesome/css/font-awesome.min.css">
  <link rel="stylesheet" type="text/css" href="./style/adMain.css">
   <link rel="stylesheet" type="text/css" href="./style/adCheckBook.css">
  <script type="text/javascript" src="./script/jquery-2.1.4.min.js"></script>
  <script type="text/javascript">
     $(document).ready(function() {
         var left_li= $(".left ul li:eq(6)");
          left_li.css("color","#FFF");
          left_li.css("background-color","#BBCAF1");
          $(".left ul").find('li:eq(6)').children(".trig").css('display', 'block');
          $(".table tbody tr:odd").css("backgroundColor","#FCF8E3");
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
		    String state="";
			if(request.getAttribute("searchnum")!=null)
				num=(int)request.getAttribute("searchnum");
			List<bookinfo> temp=null;
			//空的时候判断一下，给与空间
			if(request.getAttribute("searchbook")==null)
			{
				temp=new ArrayList<bookinfo>();
			}
			else
			{
				temp=(ArrayList<bookinfo>)request.getAttribute("searchbook");
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
        <form action="adsearchbook" method="post">
           <div class="search">
                    <input type="text" name="search" value="输入图书名或作者" onfocus="if(value=='输入图书名或作者') {value=''}" onblur="if (value=='') {value='输入图书名或作者'}" />
                    <button class="btn" type="submit">搜索</button>
           </div>
           </form>
           <div class="book_num">
       	 <div class="borred">共搜索到<span><%=num %></span>条信息</div>
       	
         </div>
                      <div class="table_div">
                       <%if(request.getAttribute("searchbook")!=null){%>
                     <table class="table">
                     <thead>
                        <tr>
                           <th class="tdOne">图书编号</th>
                           <th>图书名称</th>
                           <th class="tdTwo">作者</th>
                           <th class="tdTwo">译者</th>
                           <th class="tdTwo">价格</th>
                           <th>ISBN编码</th>
                           <th class="tdOne">出版日期</th>
                           <th>出版社</th>
                           <th class="tdTwo">入库者</th>
                           <th class="tdOne">入库时间</th>
                           <th class="tdOne">是否借出</th>
                        </tr>
                     </thead>
                     <tbody>
                         <% 
		              for(bookinfo t:temp){%>
		              <tr>
		              	<td><%=t.getBookid() %></td>
		                <td><%=t.getBookname() %></td>
		                <td><%=t.getAuthor() %></td>
		                <td><%=t.getTranslator() %></td>
		                 <td><%=t.getPrice() %></td>
		                <td><%=t.getIsbncode() %></td>
		                <td><%=t.getComeuptime() %></td>
		                <td><%=t.getPublishcompany() %></td>
		                <td><%=t.getEnteringmen() %></td>
		                <td><%=t.getEnteringdate() %></td>
		                <td><% if(t.getState()==0) state="借出";
		                if(t.getState()==1) state="在库";%><%=state %></td>
		                
		                
		              </tr>
		              <% }%>
                         
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