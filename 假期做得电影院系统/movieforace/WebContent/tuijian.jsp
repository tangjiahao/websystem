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
       height:90px; line-height:20px;
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
    
    
		
<h2>ACE电影推荐情况
</h2>


    	<p style="color:red;font-size:25px;"><%=tip %></p>
    	 	<%if(request.getAttribute("pager")!=null) {%>
                 
                     <table class="table1">
                       <thead>
                          <tr>
                             
                             <th>电影相关</th>
                     
                            
                             <th>是否推荐?</th>
                          </tr>
                       </thead>
                       <tbody>
		               <% 
		              for(movie t:pager.getPagedata()){ %>
		              <tr>
		              	





		              	
		              	<td>电影id：<%=t.getMovieid()%><br>电影名：《<%=t.getMoviename()%>》<br>评分：<%=t.getScore() %><br>类型：<%=t.getType() %><br>
		              	演员：<br><%=t.getActors() %>
		              	</td>
		              	
		              	
		              	<td><%if(t.getRecommend().equalsIgnoreCase("no")) {%>尚未推荐<a href="rootformv?handle=addrecommend&movieid=<%=t.getMovieid() %>">新增推荐</a><%} %>
		              	<%if(t.getRecommend().equalsIgnoreCase("yes")) {%>已被推荐<a href="rootformv?handle=deleterecommend&movieid=<%=t.getMovieid() %>">取消推荐</a><%} %>
		              	</td>
		              	
		              </tr>
		              <% }%>
                           
                          </tbody>
                     </table>
                     </table>
                     
                     
    	
    	 
               <% }%>
 
    	

</body>
</html>