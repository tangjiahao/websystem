<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="dao.*"%>
<%@ page import="alljavabean.*"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>电影影评</title>





<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style type="text/css">
        
			*{
				margin: 0;
				padding: 0;
				/*text-align: center;*/
			}
			
			
			
			
       
 .allmvbk{
 height:1600px;
 width:1100px;
 /* border:1px solid rgb(132,133,135); */
 
 
 }
 .mvbk{
 height:390px;
 width:270px;
 border:1px solid rgb(132,133,135);
 float:left;
 text-align:center;
 }
   #qt{
 width:250px;
 height:340px;
 margin-top:5px;

 
 }
 
 .mvname{
 background-color:rgb(110,110,110);
 height:35px;
 width:250px;
 margin-left:10px;
 }
       
        </style>
</head>
<body>
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
<%
           
           Pageutil<movie> pager=new Pageutil<movie>();
           if(request.getAttribute("pager")!=null)
               pager= (Pageutil<movie>)request.getAttribute("pager");
    %>
    
    
    <form action="userformv?handle=searchallmv2" method="post">
    		
    		
        <p style="color:red;font-size:25px;"><%=tip %></p>
    	<input type="text" name="pageindex"  placeholder="请输入你想查看的页码"  value="1"  style="display:none"/><br />
    	<input type="text" name="pagesize"  placeholder="请输入一页展示的记录条数"  value="15"  style="display:none"/><br />
    
    	<button type="submit">allmovie</button>
    	
    	 </form>
    	 	<%if(request.getAttribute("pager")!=null) {%>
                 <h2>点击任意电影获取影评相关</h2>
                    <div class="allmvbk">
		               <% 
		              for(movie t:pager.getPagedata()){ %>
		                 <div class="mvbk">
		                 <a href="userformv?handle=searchcomment&movieid=<%=t.getMovieid() %>&pageindex=1&pagesize=5">
		              	<img  src="<%=request.getContextPath()+"/images/"+t.getCover() %>" id="qt">
		              	</a>
		              	<div class="mvname">《<%=t.getMoviename() %>》</div>
                         </div>




		              <% }%>
                    </div>   
                         
               <% }%>


</body>
</html>
</body>
</html>