<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="dao.*"%>
<%@ page import="alljavabean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购票选择</title>
<script type="text/javascript">
//动态给出座位输入框
        function chooseamount() {
            var obj = document.getElementById("amount");
            s = "<table border=\"1\" cellpadding=\"5\"><tr align=\"center\"><td>号数</td><td>几排几座</td></tr>";
            for (i = 0; i < obj.value; i++) {
                s += "<tr align=\"center\"><td>" + (i + 1) +"号</td><td><input type='text' name='no" + (i + 1) + "'></td> </tr>";
            }
            s += "</table>";
            document.getElementById("d2").innerHTML = s;
        }
      //计算总价
		function changeprice(at){
            /* alert("进入js"); */
			var amount=at.value;
			
			var price=document.getElementById("price").value;
			var subprice=amount*price;
			/* alert(subprice); */

			var sum=document.getElementById("sumprice");
			sum.value=subprice;
			
			
		}
	
</script>
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

%>

<%
String tip="";

if(request.getAttribute("tip")!=null)
    tip=(String)request.getAttribute("tip");
movie mv=null;
if(request.getAttribute("movie")!=null)
    mv= (movie)request.getAttribute("movie");
playlist pt=null;
if(request.getAttribute("play")!=null)
    pt= (playlist)request.getAttribute("play");

%>




<p style="color:red;font-size:25px;"><%=tip %></p>
<%if(request.getAttribute("movie")!=null&&request.getAttribute("play")!=null){ %>
<form action="userformv?handle=orderchoose" method="post">
<label>订票人：</label><input name="username"  value="<%=person.getUsername() %>"  readonly="readonly" type="text" "><br>
<label>电影名：</label><input name="moviename"  value="<%=mv.getMoviename() %>"  readonly="readonly" type="text"><br>
<label>票价：</label><input name="price"  id="price" value="<%=pt.getPrice() %>"  readonly="readonly" type="text"><br>
<label>日期：</label><input name="date1"  value="<%=pt.getShowtime1() %>"  readonly="readonly" type="text">
<label>时间：</label><input name="date2"  value="<%=pt.getShowtime2() %>"  readonly="readonly" type="text"><br>
<label>几号厅：</label><input name="place"  value="<%=pt.getPlace() %>"  readonly="readonly" type="text"><br>
<div>
<label>选购票数：</label>
<select name="amount" id="amount" onchange="chooseamount();changeprice(this);" >
<option value="0">0</option>
   <option value="1">1</option>
   <option value="2">2</option>
   <option value="3">3</option>
   <option value="4">4</option>
   <option value="5">5</option>
    <option value="6">6</option>
    <option value="7">7</option>
    <option value="8">8</option>
    <option value="9">9</option>
    <option value="10">10</option>
    
   </select>
<br />
<div id="d2"></div>
</div>
<label>总价：</label><input id="sumprice"  value=""  readonly="readonly" type="text"><br>
<button type="submit">确认购票</button>


</form>
<%} %>
</body>
</html>