<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="alljavabean.mixinfo" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
    
<!DOCTYPE html>
<html>
<head>
	<title>搜索结果</title>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
	<link rel="stylesheet" type="text/css" href="./style/searchResult.css">
	<link rel="stylesheet" type="text/css" href="./font-awesome/css/font-awesome.min.css">
	<script type="text/javascript" src="./script/jquery-2.1.4.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
        	$(".login").click(function() {
        		window.open("login.jsp");
        	});
        	
        	$(".bor_btn").click(function() {
        		var num=$(this).find("span").html();
        		if (num<=0) {
        			alert("该书被借光了~~");
        		}
        		else{
        			alert("请到图书管理员处借阅~~");
        		}
        	});
        	var btns=$(".bor_btn");
        	for (var i = 0; i < btns.length; i++) {
        		var num=$(btns[i]).find("span").html();
        		if (num==0) {
                    $(".bor_btn").eq(i).css('backgroundColor', '#BCBCBC');
        		}
        		else{
        			$(".bor_btn").eq(i).css('backgroundColor', '#28B138');
        		}
        	};
        });
    </script>
</head>
<body>
<%
   String search="";
   if(request.getAttribute("search")!=null)
	   search=(String)request.getAttribute("search");
   List<mixinfo> temp=null;
	//空的时候判断一下，给与空间
	if(request.getAttribute("result")==null)
	{
		temp=new ArrayList<mixinfo>();
	}
	else
	{
		temp=(ArrayList<mixinfo>)request.getAttribute("result");
	}
%>

<div class="search_page">
	<div class="header">
		<div class="home"><a href="index.jsp"><i class="fa fa-home"></i>首页</a></div>
		<a class="login" href="login.jsp">登录</a>
		<div class="clear"></div>
	</div>
	<div class="content">
	<form action="searchresultcheck" method="post">
		<div class="search">
		    <input  name="search" value="<%=search %>"/>
			<button class="sch_btn" type="submit">搜索</button>
		</div>
	</form>
	<%for(mixinfo t:temp){ %>
		<div class="result">
			<div class="book_result">
				<div class="bk_name"><%=t.getBookname() %></div>
				<ul>
					<li>作者：<%=t.getAuthor() %></li>
					<li>出版社：<%=t.getPublishcompany() %></li>
				</ul>
				
				<div class="bor_btn">
					<div class="btn_name">借阅</div>
					<div class="bk_num">在库数量：<span><%=t.getInstate() %></span>本</div>
				</div>
				<div class="clear"></div>
			</div>
			
			
			</div>
			<%} %>
		</div>

	</div>
</div>
</body>
</html>