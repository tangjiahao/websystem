<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="dao.*"%>
<%@ page import="alljavabean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<style type="text/css">
			#body{
				width:1260px;
				height: 900px;
			}
			#container{
				width:100%;
				height: 100%;
				float:left;
			}
			#top{
				width: 100%;
				height: 260px;
				background-color: pink;
				float:left;
				text-align: center;
			}
			#top h2{
			   margin-top: 120px;
			}
			#bottom{
				width: 100%;
				height: 200px;
				background-color: gray;
				float:left;
			}
			#bottom h3{
			   line-height: 100px;
			   text-align: center;
			}
			#middle{
				width:100%;
				height: 800px;
				float:left;
				
			}
			#left{
				height: 100%;
				width: 300px;
				background-color: red;
				
				float:left;
			}
			#main{
				height: 100%;
				width:1100px;
				background-color: white;
				float:left;
				
			}
			#div_nav{
				width: 270px;
				height: 300px;
			}
			#div_nav span{
				margin-left: 100px;
				font-size: 24px;
				color: blue;
				margin-top;20px;
			}
			#div_nav ul{
				list-style: none;
				
			}
			#div_nav ul>li{
				
				color:white;
				height: 60px;
				text-align: center;
				margin-bottom: 2px;
			    margin-top: 2px;
			    border: 3px groove white;
			    
			}
			li a {
				text-decoration: none;
				line-height: 60px;
				text-align: center;
			    
			}
			
		</style>
	</head>
	
	<body>
	<%
/* 越权访问的判断 */
root person=null;
if(request.getSession().getAttribute("admin")!=null)
    person=(root)request.getSession().getAttribute("admin");
else
{
    request.setAttribute("tip", "用户信息已过期或不存在,请重新登录");
    request.getRequestDispatcher("login.jsp").forward(request, response);
    }
String tip="";

if(request.getAttribute("tip")!=null)
    tip=(String)request.getAttribute("tip");
%>
	
	
	
		<div id="container">
			<div id="top">
				<h2>ACE 电影院管理员系统</h2>
			</div>
			<div id="middle">
				<div id="left">
					<div id="div_nav">
					<div class="photo" style="float:left;height:155px;">
					<img src="images/b.jpeg" style="width:120px;height:150px;border-radius:50%;float:left;">
					<p style="color:blue;font-size:16px; width:150px;height:150px;float:left;"><%=tip %><%=person.getRootname() %>
					<br><br><br><br>&nbsp;&nbsp;&nbsp;欢迎登录</p><br>
					</div>
						<span>功能导航</span>
					<ul>
						<li><a href="rootsearchmv.jsp" target="mainframe">电影信息一览</a></li>
						<li><a href="rootalterplaylist.jsp" target="mainframe">电影档期调整</a></li>
						<li><a href="rootordermenu.jsp" target="mainframe">订单信息一览</a></li>
						<li><a href="rootsearchuser.jsp" target="mainframe">用户信息一览</a></li>
						<li><a href="login.jsp" target="mainframe">退出登录</a></li>
						
					</ul>
					</div>
					
					
				</div>
				<div id="main">
					<iframe src="" width="100%" height="100%" name="mainframe"></iframe>
				</div>
			</div>
			<div id="bottom">
				<h3>All rights belongs to ace,phone:13111535258<br>Connection email:1413@163.com</h3>
				
			</div>
		</div>
	</body>
</html>
