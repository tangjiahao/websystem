<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="dao.*"%>
<%@ page import="alljavabean.*"%>

<html lang="en" >
<head>
     
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">
        
			*{
				margin: 0;
				padding: 0;
				/*text-align: center;*/
			}
			
			img{
				display: block;
			}
			
			.yoyo{
				background-color: lightblue;
				list-style: none;
				height: 50px;
				width:800px;
				color: red;
				/*float:left;*/
				text-align: center;
				margin-left: 200px;
				
			}
			.yoyo li{
				height: 50px;
				width: 200px;
				/*float:left;*/
				display: inline;
				color: red;
				margin-left: 100px;
				
				line-height: 50px;
				
			}
			li a{
				text-decoration: none;
				color:white;
			
			}
			li a:hover{
				background: white;
			}
			li a:visited{
				color:gray;
			}
			
		
        body{
        background-repeat:no-repeat;
        width:1080px;
        
        }
       .table1{
	width:90%;
	height:auto;
	margin:5px auto;
	border:blue;
	cellspacing:0;
	
	
}
        .table1 td{
        border:1px solid blue;
       height:400px; line-height:20px;
       width:320px;
     
       text-align:center;
       margin:0;
       cellspacing:0;
       
     
       
        }
         .table1 th{
        border:1px solid blue;
       height:100px;
       width:320px;
     
       text-align:center;
       margin:0;
       cellspacing:0;
       
     
       
        }
         #qt{
 width:270px;
 height:360px;
 margin:20px;
 
 }
       .btm a{
            text-decoration: none;
       }
        </style>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript">
function searchmv(){
	
	var tip=document.getElementById("mvname").value;
	var p1=document.getElementsByName("pageindex")[0].value;
	var p2=document.getElementsByName("pagesize")[0].value;
	
	/* alert(p1,p2); */
	
	window.location.href="rootformv?handle=searchmovie&moviename="+encodeURI(encodeURI(tip))+"&pagesize="+p2+"&pageindex="+p1;
}

</script>


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



<%
           
           Pageutil<movie> pager=new Pageutil<movie>();
           if(request.getAttribute("pager")!=null)
               pager= (Pageutil<movie>)request.getAttribute("pager");
    %>
    
    <div id="div1">
			<ul class="yoyo">
				<li><a href="addmovie.jsp">新增电影</a></li>
				<li><a href="deletemovie.jsp">电影删除</a></li>
				<li><a href="altermovie.jsp">电影修改</a></li>
				<li><a href="rootformv?handle=searchrecommend">本周推荐</a></li>
			</ul>
		</div>
		<div style=" background-repeat:no-repeat;text-align:center"clear: both;>
<h2>ACE电影调整
</h2>

</div>
    	<form action="rootformv?handle=searchmovie" method="post">
    		
    		
        <p style="color:red;font-size:25px;"><%=tip %></p>
    	<input type="text" name="pageindex"  placeholder="请输入你想查看的页码"  value="1"  style="display:none"/><br />
    	<input type="text" name="pagesize"  placeholder="请输入一页展示的记录条数"  value="5"  style="display:none"/><br />
    	<input type="text" name="moviename"  placeholder="请输入想查看的电影名或电影类型"   id="mvname"  onblur="searchmv()"/><br />
    	<button type="submit">查询</button>
    	
    	 </form>
    	 	<%if(request.getAttribute("pager")!=null) {%>
                 
                     <table class="table1">
                       <thead>
                          <tr>
                             <th>封面</th>
                             <th>电影相关</th>
                     
                             <th>简介</th>
                             
                          </tr>
                       </thead>
                       <tbody>
		               <% 
		              for(movie t:pager.getPagedata()){ %>
		              <tr>
		              	<td><img  src="<%=request.getContextPath()+"/images/"+t.getCover() %>" id="qt">




<a href="rootformv?handle=turntocover&movieid=<%=t.getMovieid() %>" style="color:red;width:">上传封面</a>
		              	</td>
		              	<td>电影id：<%=t.getMovieid()%><br><br>电影名：《<%=t.getMoviename()%>》<br><br>评分：<%=t.getScore() %><br><br>类型：<%=t.getType() %><br><br>
		              	演员：<br><%=t.getActors() %>
		              	</td>
		              	
		              	<td style="color:red;font-size:18px;text-align:left;text-indent:2em;"><%=t.getSummary() %></td>
		              	
		              </tr>
		              <% }%>
                           
                          </tbody>
                     </table>
                   
                     
                     <div class="btm">当前页：<%=pager.getPageindex() %>/<%=pager.getTotalpages() %><br></div>
                     <table>
                     <tr>
                     
                       <td>
                     <form action="rootformv?handle=searchmovie&pageindex=<%=pager.getFirstpage() %>&pagesize=<%=pager.getPagesize()%>" method="post">
                     <input name="moviename" value=<%=(String)request.getAttribute("info") %> type="text" style="display:none">
                       <button type="submit"> 首页</button>
                     </form>
                     </td>
                     
                     
                     <td>
                     <%if(pager.getPageindex()>pager.getFirstpage() ) {%>
                      <form action="rootformv?handle=searchmovie&pageindex=<%=pager.getPrepage() %>&pagesize=<%=pager.getPagesize() %>" method="post">
                     <input name="moviename" value=<%=(String)request.getAttribute("info") %> type="text" style="display:none">
                    <button type="submit">上一页</button>
                    </form>
                     <%} %>
                     </td>
                     
                     <td>
                      <%if(pager.getPageindex()<pager.getTotalpages() ) {%>
                      <form action="rootformv?handle=searchmovie&pageindex=<%=pager.getNextpage() %>&pagesize=<%=pager.getPagesize() %>" method="post">
                      <input name="moviename" value=<%=(String)request.getAttribute("info") %> type="text" style="display:none">
                     <button>下一页</button>
                     </form>
                      <%} %>
                      </td>
                      
                      
                      <td>
                      <form action="rootformv?handle=searchmovie&pageindex=<%=pager.getLastpage() %>&pagesize=<%=pager.getPagesize() %>" method="post">
                      <input name="moviename" value=<%=(String)request.getAttribute("info") %> type="text" style="display:none">
                      <button>尾页</button>
                      </form>                        
                      </td>
                      
                     </tr>
                     </table>
    	<form action="rootformv?handle=searchmovie" method="post">
    		
    		
       
    	跳转到：<input type="text" name="pageindex"   style="width:25px"/>页
    	<input name="moviename" value=<%=(String)request.getAttribute("info") %> type="text" style="display:none">
    	<input type="text" name="pagesize"  placeholder="请输入一页展示的记录条数"  value="5"  style="display:none"/><br />
    	<button type="submit">跳转</button><br><br />
    	
    	 </form>
    	 
               <% }%>
 
    	

</body>
</html>