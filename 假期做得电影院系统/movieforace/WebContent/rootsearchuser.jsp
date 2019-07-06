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



</script>       
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">



</head>
<body>

<div style=" background-repeat:no-repeat;"clear: both;>
<h2>管理员用户查询</h2>

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
           
           Pageutil<user> pager=new Pageutil<user>();
           if(request.getAttribute("pager")!=null)
               pager= (Pageutil<user>)request.getAttribute("pager");
    %>
    
    	<form action="rootformv?handle=searchuser" method="post">
    		
    		
        <p style="color:red;font-size:20px;"><%=tip %></p>
    	<input type="text" name="pageindex"  placeholder="请输入你想查看的页码"  value="1"  style="display:none"/><br />
    	<input type="text" name="pagesize"  placeholder="请输入一页展示的记录条数"  value="5"  style="display:none"/><br />
    	<input type="text" name="username"  placeholder="请输入用户名或账号"   id="username"><br />
    	<button type="submit">查询</button>
    	
    	 </form><br>
    	
    	 	<%if(request.getAttribute("pager")!=null) {%>
                 
                     <table class="table1">
                       <thead>
                          <tr>
                             <th>用户id</th>
                             <th>用户名</th>
                             <th>性别</th>
                     
                             <th>电话</th>
                             <th>年龄</th>
                             <th>最近登录时间</th>
                             <th>密码</th>
                             
                             
                          </tr>
                       </thead>
                       <tbody>
		               <% 
		              for(user t:pager.getPagedata()){ %>
		              <tr>
		                <td><%=t.getUserid() %></td>
		              	<td><%=t.getUsername()    %></td>
		              	<td><%=t.getSex()    %></td>
		              	<td><%=t.getPhone()    %></td>
		              	<td><%=t.getAge()    %></td>
		              	<td><%=t.getRecentime()    %></td>
		              	<td><%=t.getPassword()    %></td>
		              	
		              	
		                
		              </tr>
		              <% }%>
                           
                          </tbody>
                     </table>
                     
                     <div class="btm">当前页：<%=pager.getPageindex() %>/<%=pager.getTotalpages() %><br></div>
                     <table>
                     <tr>
                     
                       <td>
                     <form action="rootformv?handle=searchuser&pageindex=<%=pager.getFirstpage() %>&pagesize=<%=pager.getPagesize()%>" method="post">
                  
                       <button type="submit"> 首页</button>
                     </form>
                     </td>
                     
                     
                     <td>
                     <%if(pager.getPageindex()>pager.getFirstpage() ) {%>
                      <form action="rootformv?handle=searchuser&pageindex=<%=pager.getPrepage() %>&pagesize=<%=pager.getPagesize() %>" method="post">
                 
                    <button type="submit">上一页</button>
                    </form>
                     <%} %>
                     </td>
                     
                     <td>
                      <%if(pager.getPageindex()<pager.getTotalpages() ) {%>
                      <form action="rootformv?handle=searchuser&pageindex=<%=pager.getNextpage() %>&pagesize=<%=pager.getPagesize() %>" method="post">
           
                     <button>下一页</button>
                     </form>
                      <%} %>
                      </td>
                      
                      
                      <td>
                      <form action="rootformv?handle=searchuser&pageindex=<%=pager.getLastpage() %>&pagesize=<%=pager.getPagesize() %>" method="post">
                   
                      <button>尾页</button>
                      </form>                        
                      </td>
                      
                     </tr>
                     </table>
        <form action="rootformv?handle=searchuser" method="post">
    		
    		
       
    	跳转到：<input type="text" name="pageindex"   style="width:25px"/>页
    	
    	<input type="text" name="pagesize"  placeholder="请输入一页展示的记录条数"  value="5"  style="display:none"/><br />
    	<button type="submit">跳转</button><br><br />
    	
    	 </form>
               <% }%>
 
    	

</body>
</html>