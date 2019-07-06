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
       
       #top{
       width:800px;
       height:360px;
       }
       #qt{
       width:280px;
       height:350px;
       float:left;
       }
       .dywz{
       width:400px;
       height:350px;
       float:left;
       margin-left:100px;
       }
        </style>
        
        
 <script type="text/javascript">

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
<h2>订单一览</h2>

</div>
<%
         
    
           
           Pageutil<movieorder> pager=new Pageutil<movieorder>();
           if(request.getAttribute("pager")!=null)
               pager= (Pageutil<movieorder>)request.getAttribute("pager");
          
    %>



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
<%-- <input type="text" id="username" style="display:none;" value="<%=person.getUserid() %>"> --%>
<p style="color:red;font-size:25px;"><%=tip %></p>
<form action="rootformv?handle=rootordermenu&pageindex=1&pagesize=5" method="post">
<input type="text" name="allorder" placeorder="请输入查询的用户名">
<button type="submit">查询</button>
</form>
    
    
      
    	
    	 
    
    	 	<%if(request.getAttribute("pager")!=null) {%>
    	 	
    	 	
    	 
                 
                     <table class="table1">
                       <thead>
                          <tr>
                             <th>订单号</th>
                             <th>订单人</th>
                             <th>电影名</th>
                             
                     
                             <th>日期</th>
                             <th>地点</th>
                             <th>座位</th>
                             <th>价格</th>
                             
                             
                             
                          </tr>
                       </thead>
                       <tbody>
		               <% 
		              for(movieorder t:pager.getPagedata()){ %>
		              <tr>
		              
		              	<td><%=t.getOrderid()    %></td>
		              	<td><%=t.getUsername() %></td>
		              	<td>《<%=t.getMoviename()    %>》</td>
		              	<td><%=t.getWatchtime()    %></td>
		              	<td><%=t.getPlace()    %></td>
		              	<td><%=t.getSeat()    %></td>
		              	<td><%=t.getPrice()    %></td>
		              	
		              	
		              	
		                
		              </tr>
		              <% }%>
                           
                          </tbody>
                     </table>
                     
                     <div class="btm">当前页：<%=pager.getPageindex() %>/<%=pager.getTotalpages() %><br></div>
                     <table>
                     <tr>
                     
                       <td>
                     <form action="rootformv?handle=rootordermenu&pageindex=<%=pager.getFirstpage() %>&pagesize=<%=pager.getPagesize()%>" method="post">
              
                       <button type="submit"> 首页</button>
                     </form>
                     </td>
                     
                     
                     <td>
                     <%if(pager.getPageindex()>pager.getFirstpage() ) {%>
                      <form action="rootformv?handle=rootordermenu&pageindex=<%=pager.getPrepage() %>&pagesize=<%=pager.getPagesize() %>" method="post">
                    
                    <button type="submit">上一页</button>
                    </form>
                     <%} %>
                     </td>
                     
                     <td>
                      <%if(pager.getPageindex()<pager.getTotalpages() ) {%>
                      <form action="rootformv?handle=rootordermenu&pageindex=<%=pager.getNextpage() %>&pagesize=<%=pager.getPagesize() %>" method="post">
                  
                     <button>下一页</button>
                     </form>
                      <%} %>
                      </td>
                      
                      
                      <td>
                      <form action="rootformv?handle=rootordermenu&pageindex=<%=pager.getLastpage() %>&pagesize=<%=pager.getPagesize() %>" method="post">
                 
                      <button>尾页</button>
                      </form>                        
                      </td>
                      
                     </tr>
                     </table>
        <form action="rootformv?handle=rootordermenu" method="post">
    		
    		
       
    	跳转到：<input type="text" name="pageindex"   style="width:25px"/>页
    	
    	<input type="text" name="pagesize"  placeholder="请输入一页展示的记录条数"  value="5"  style="display:none"/><br />
    	<button type="submit">跳转</button><br><br />
    	
    	 </form>
               <% }%>
 
    	

</body>
</html>