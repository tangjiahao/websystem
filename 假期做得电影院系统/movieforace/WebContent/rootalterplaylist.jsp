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
       height:60px; line-height:20px;
       width:200px;
     
       text-align:center;
       margin:0;
       cellspacing:0;
       
     
       
        }
         .table1 th{
        border:1px solid blue;
       height:80px;
       width:200px;
     
       text-align:center;
       margin:0;
       cellspacing:0;
       
     
       
        }
         
       .btm a{
            text-decoration: none;
       }
        </style>
        
        
 <script type="text/javascript">
function searchlist(){
	
	var tip=document.getElementById("mvname").value;
	var p1=document.getElementsByName("pageindex")[0].value;
	var p2=document.getElementsByName("pagesize")[0].value;
	
	/* alert(p1,p2); */
	
	window.location.href="rootformv?handle=searchplaylist&moviename="+encodeURI(encodeURI(tip))+"&pagesize="+p2+"&pageindex="+p1;
}
function turntoaddlist()
{
	window.location.href="addlist.jsp";
}

</script>       
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">



</head>
<body>

<div style=" background-repeat:no-repeat;"clear: both;>
<h2>ACE电影档期调整</h2>

</div>
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
           
           Pageutil<playlist> pager=new Pageutil<playlist>();
           if(request.getAttribute("pager")!=null)
               pager= (Pageutil<playlist>)request.getAttribute("pager");
    %>
    
    	<form action="rootformv?handle=searchplaylist" method="post">
    		
    		
        <p style="color:red;font-size:25px;"><%=tip %></p>
    	<input type="text" name="pageindex"  placeholder="请输入你想查看的页码"  value="1"  style="display:none"/><br />
    	<input type="text" name="pagesize"  placeholder="请输入一页展示的记录条数"  value="5"  style="display:none"/><br />
    	<input type="text" name="moviename"  placeholder="请输入电影名或几号厅"   id="mvname"/ onblur="searchlist()"><br />
    	<button type="submit">查询</button>
    	
    	 </form><br>
    	 <button type="button" onclick="turntoaddlist()">新增档期</button>
    	 	<%if(request.getAttribute("pager")!=null) {%>
                 
                     <table class="table1">
                       <thead>
                          <tr>
                             <th>电影id</th>
                             <th>电影名</th>
                             <th>具体日期</th>
                     
                             <th>具体时间</th>
                             <th>地点</th>
                             <th>剩余座位</th>
                             <th>价格</th>
                             <th>删除</th>
                             <th>修改</th>
                             
                          </tr>
                       </thead>
                       <tbody>
		               <% 
		              for(playlist t:pager.getPagedata()){ %>
		              <tr>
		                <td><%=t.getMovieid() %></td>
		              	<td><%=t.getMoviename()    %></td>
		              	<td><%=t.getShowtime1()    %></td>
		              	<td><%=t.getShowtime2()    %></td>
		              	<td><%=t.getPlace()    %>号厅</td>
		              	<td><%=t.getRemainder()    %></td>
		              	<td><%=t.getPrice()    %></td>
		              	<td><a href="rootformv?handle=deleteplay&movieid=<%=t.getMovieid() %>&showtime1=<%=t.getShowtime1()%>&showtime2=<%=t.getShowtime2() %>&place=<%=t.getPlace() %>">删除</a></td>
		              	<td><a href="rootformv?handle=altertoplay&movieid=<%=t.getMovieid() %>&showtime1=<%=t.getShowtime1()%>&showtime2=<%=t.getShowtime2() %>&place=<%=t.getPlace() %>">修改</a></td>
		              	
		                
		              </tr>
		              <% }%>
                           
                          </tbody>
                     </table>
                     
                     <div class="btm">当前页：<%=pager.getPageindex() %>/<%=pager.getTotalpages() %><br></div>
                     <table>
                     <tr>
                     
                       <td>
                     <form action="rootformv?handle=searchplaylist&pageindex=<%=pager.getFirstpage() %>&pagesize=<%=pager.getPagesize()%>" method="post">
                     <input name="moviename" value=<%=(String)request.getAttribute("info") %> type="text" style="display:none">
                       <button type="submit"> 首页</button>
                     </form>
                     </td>
                     
                     
                     <td>
                     <%if(pager.getPageindex()>pager.getFirstpage() ) {%>
                      <form action="rootformv?handle=searchplaylist&pageindex=<%=pager.getPrepage() %>&pagesize=<%=pager.getPagesize() %>" method="post">
                     <input name="moviename" value=<%=(String)request.getAttribute("info") %> type="text" style="display:none">
                    <button type="submit">上一页</button>
                    </form>
                     <%} %>
                     </td>
                     
                     <td>
                      <%if(pager.getPageindex()<pager.getTotalpages() ) {%>
                      <form action="rootformv?handle=searchplaylist&pageindex=<%=pager.getNextpage() %>&pagesize=<%=pager.getPagesize() %>" method="post">
                      <input name="moviename" value=<%=(String)request.getAttribute("info") %> type="text" style="display:none">
                     <button>下一页</button>
                     </form>
                      <%} %>
                      </td>
                      
                      
                      <td>
                      <form action="rootformv?handle=searchplaylist&pageindex=<%=pager.getLastpage() %>&pagesize=<%=pager.getPagesize() %>" method="post">
                      <input name="moviename" value=<%=(String)request.getAttribute("info") %> type="text" style="display:none">
                      <button>尾页</button>
                      </form>                        
                      </td>
                      
                     </tr>
                     </table>
        <form action="rootformv?handle=searchplaylist" method="post">
    		
    		
       
    	跳转到：<input type="text" name="pageindex"   style="width:25px"/>页
    	<input name="moviename" value=<%=(String)request.getAttribute("info") %> type="text" style="display:none">
    	<input type="text" name="pagesize"  placeholder="请输入一页展示的记录条数"  value="5"  style="display:none"/><br />
    	<button type="submit">跳转</button><br><br />
    	
    	 </form>
               <% }%>
 
    	

</body>
</html>