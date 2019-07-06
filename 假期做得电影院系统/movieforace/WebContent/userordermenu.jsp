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
/*  判断是否退订的函数*/
function deleteorder(obj)
{
	/* alert(obj); */
	if(confirm("确认退订么？"))
		{
		location.href="userformv?handle=userdeleteorder&orderid="+obj;
		}
	else{
		
		location.href="userformv?handle=userordermenu&pageindex=1&pagesize=5";
	}
}
</script>       
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">



</head>
<body>

<div style=" background-repeat:no-repeat;"clear: both;>
<h2>用户订单一览</h2>

</div>
<%
         
    
           
           Pageutil<movieorder> pager=new Pageutil<movieorder>();
           if(request.getAttribute("pager")!=null)
               pager= (Pageutil<movieorder>)request.getAttribute("pager");
          
    %>



<%
/* 越权访问的判断 */
user person=null;
if(request.getSession().getAttribute("person")!=null)
    person=(user)request.getSession().getAttribute("person");
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
                             <td>退订</td>
                             
                             
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
		              	<td><button onclick="deleteorder(<%=t.getOrderid() %>)">退订</button></td>
		              	
		              	
		                
		              </tr>
		              <% }%>
                           
                          </tbody>
                     </table>
                     
                     <div class="btm">当前页：<%=pager.getPageindex() %>/<%=pager.getTotalpages() %><br></div>
                     <table>
                     <tr>
                     
                       <td>
                     <form action="userformv?handle=userordermenu&pageindex=<%=pager.getFirstpage() %>&pagesize=<%=pager.getPagesize()%>" method="post">
              
                       <button type="submit"> 首页</button>
                     </form>
                     </td>
                     
                     
                     <td>
                     <%if(pager.getPageindex()>pager.getFirstpage() ) {%>
                      <form action="userformv?handle=userordermenu&pageindex=<%=pager.getPrepage() %>&pagesize=<%=pager.getPagesize() %>" method="post">
                    
                    <button type="submit">上一页</button>
                    </form>
                     <%} %>
                     </td>
                     
                     <td>
                      <%if(pager.getPageindex()<pager.getTotalpages() ) {%>
                      <form action="userformv?handle=userordermenu&pageindex=<%=pager.getNextpage() %>&pagesize=<%=pager.getPagesize() %>" method="post">
                  
                     <button>下一页</button>
                     </form>
                      <%} %>
                      </td>
                      
                      
                      <td>
                      <form action="userformv?handle=userordermenu&pageindex=<%=pager.getLastpage() %>&pagesize=<%=pager.getPagesize() %>" method="post">
                 
                      <button>尾页</button>
                      </form>                        
                      </td>
                      
                     </tr>
                     </table>
        <form action="userformv?handle=userordermenu" method="post">
    		
    		
       
    	跳转到：<input type="text" name="pageindex"   style="width:25px"/>页
    	
    	<input type="text" name="pagesize"  placeholder="请输入一页展示的记录条数"  value="5"  style="display:none"/><br />
    	<button type="submit">跳转</button><br><br />
    	
    	 </form>
               <% }%>
 
    	

</body>
</html>