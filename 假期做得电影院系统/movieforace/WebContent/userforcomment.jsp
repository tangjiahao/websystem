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
        .allet{
        width:1000px;
        height:1200px;
       /*  border:1px solid red; */
       background-image:url(images/y.jpg);
      
      
   } 
   .eth{
   width:1000px;
   height:100px;
   border:1px solid rgb(132,133,135);
   text-align:center;
   background:red;
   
   }
   .ete{
   width:1000px;
   height:190px;
   border:1px solid rgb(132,133,135);
   margin-top:5px;
   }
   .newet{
   width:1000px;
   height:190px;
   margin-top:15px;
   }
       
        </style>
  
        
 <script type="text/javascript">

function turntoaddlist()
{
	window.location.href="addlist.jsp";
}

	function judgenumber(obj)
	{
		/* alert("进入判断"); */
		var data=obj.value;
		/* alert(obj.value); */
		if(parseFloat(data).toString()=="NaN")
			{
			/* alert("进入函数"); */
			 alert("请输入数字");
			 return false;
			}
		else{
			
			return true;
		}
	}
</script>       
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">



</head>
<body>

<div style=" background-repeat:no-repeat;"clear: both;>
<h2>电影影评一览</h2>

</div>
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
String tip2="";

if(request.getAttribute("tip2")!=null)
    tip2=(String)request.getAttribute("tip2");
%>
<%
           
           Pageutil<evaluate> pager=new Pageutil<evaluate>();
           if(request.getAttribute("pager")!=null)
               pager= (Pageutil<evaluate>)request.getAttribute("pager");
           movie temp=(movie)request.getAttribute("movie");
    %>
    <%if(request.getAttribute("movie")!=null) {%>
    <div id="top">
    <img  src="<%=request.getContextPath()+"/images/"+temp.getCover() %>" id="qt">
    <div class="dywz">
    <label>电影名：<%=temp.getMoviename()   %></label><br>
    <label>评分：<%=temp.getScore() %></label><br>
    <label>类型          <%=temp.getType()   %></label><br>
    <label>演员          <%=temp.getActors()   %></label><br>
    <label>简介：<br><textarea name="summary" style="width:300px;height:180px;"><%=temp.getSummary()   %></textarea></label>
    </div>
    </div>
    
    
    
    <%} %>
    
    
      
    	
    	   <div class="allet">
            <p style="color:blue;font-size:20px;"><%=tip %></p>
            <div class="eth"><h3>评论区:</h3></div>
    	 	<%if(request.getAttribute("pager")!=null) {%>
    	 	
    	 	
    	 
                 
                     
		               <% 
		              for(evaluate t:pager.getPagedata()){ %>
		              <div class="ete">
		              
		              <label>用户:</label><%=t.getUserid() %>&nbsp;&nbsp;&nbsp;
		              <label>时间:</label><%=t.getTime() %>&nbsp;&nbsp;&nbsp;
		              <label>评分：</label><%=t.getScore() %><br><br>
		             <label>影评：</label><br><br><%=t.getComment() %>
		              
		              
		              
		              </div>
		              
		              
		              
		              <% }%>
                           
                          </tbody>
                     </table>
                     
                     <div class="btm">当前页：<%=pager.getPageindex() %>/<%=pager.getTotalpages() %><br></div>
                     <table>
                     <tr>
                     
                       <td>
                     <form action="userformv?handle=searchcomment&movieid=<%=temp.getMovieid() %>&pageindex=<%=pager.getFirstpage() %>&pagesize=<%=pager.getPagesize()%>" method="post">
              
                       <button type="submit"> 首页</button>
                     </form>
                     </td>
                     
                     
                     <td>
                     <%if(pager.getPageindex()>pager.getFirstpage() ) {%>
                      <form action="userformv?handle=searchcomment&movieid=<%=temp.getMovieid() %>pageindex=<%=pager.getPrepage() %>&pagesize=<%=pager.getPagesize() %>" method="post">
                    
                    <button type="submit">上一页</button>
                    </form>
                     <%} %>
                     </td>
                     
                     <td>
                      <%if(pager.getPageindex()<pager.getTotalpages() ) {%>
                      <form action="userformv?handle=searchcomment&movieid=<%=temp.getMovieid() %>&pageindex=<%=pager.getNextpage() %>&pagesize=<%=pager.getPagesize() %>" method="post">
                  
                     <button>下一页</button>
                     </form>
                      <%} %>
                      </td>
                      
                      
                      <td>
                      <form action="userformv?handle=searchcomment&movieid=<%=temp.getMovieid() %>&pageindex=<%=pager.getLastpage() %>&pagesize=<%=pager.getPagesize() %>" method="post">
                 
                      <button>尾页</button>
                      </form>                        
                      </td>
                      
                     </tr>
                     </table>
        <form action="userformv?handle=searchcomment&movieid=<%=temp.getMovieid() %>" method="post">
    		
    		
       
    	跳转到：<input type="text" name="pageindex"   style="width:25px"/>页
    	
    	<input type="text" name="pagesize"  placeholder="请输入一页展示的记录条数"  value="6"  style="display:none"/><br />
    	<button type="submit">跳转</button><br><br />
    	
    	 </form>
               <% }%>
               
   <div class="newet">
   <form action="userformv?handle=addcomment&userid=<%=person.getUserid() %>&movieid=<%=temp.getMovieid() %>" method="post">
   <p style="color:red;font-size:20px;"><%=tip2 %></p>
   <input name="moviename" type="text" style="display:none" value="<%=temp.getMoviename() %>">
   <label>评分：</label><input name="score" type="text" placeholder="满分为10分,如(9.5)" onblur="judgenumber(this)"><br>
   <textarea name="comment" style="width:700px;height:150px;"></textarea>
 <button>发表影评</button>
 </form>
 </div>
 </div>
 
    	

</body>
</html>