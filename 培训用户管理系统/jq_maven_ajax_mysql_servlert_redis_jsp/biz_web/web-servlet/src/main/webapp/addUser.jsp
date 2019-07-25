<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<script src="./js/jquery-3.0.0.min.js"></script>
		<script>
        $(function(){
        	
        	 function check_name(){
         	    var reg=/^[\da-zA-Z]{1,}$/;
         		var a=true;
         		if(!reg.test($(".onlyNumAlpha").val()))
         		{
         			alert("用户名只能为数字或字母组合");
         			a=false;
         		}
         		return a;
         }
        
         
         	function check_pwd(){
         		var reg=/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/;
         		var b=true;
         		if(!reg.test($(".pwdcheck").val()))
         		{
         			alert("密码必须为数字和大小写字母组合,长度至少为8");
         			b=false;
         		}
         		return b;
         	}
         	function check_mail(){
         		var reg=/^\w+@[a-z0-9]+\.[a-z]{2,4}$/;
         		var c=true;
         		if(!reg.test($(".mailcheck").val()))
         		{
         			alert("邮箱格式错误");
         			c=false;
         		}
         		return c;
         	}
         	function check_area(){
         		var pro=$('.province').val();
         		var city=$('.city').val();
         		var e=true;
         		if(pro==null ||city==null){
         			e=false;
         			alert("地区省和市必选");
         		}
         		
         		return e;
         	}
         	function check_hobby(){
         		var opts=$('input[type=checkbox]:checked').length;
         		/* alert(opts); */
         		var d=true;
         		if(opts<2){
         			alert("请至少选择两个爱好");
         			d=false;
         			
         		}
         		return d;
         	}
         	$(".onlyNumAlpha").change(function(){
         		check_name();
         	})
         	$(".pwdcheck").change(function(){
         		check_pwd();
         	})
         	
         	$(".mailcheck").change(function(){
         		check_mail();
         	})
         	
         	
         		
         	
         	
         		$(".allcheck").click(function(){
         	    let a,b,c,d,e;
         	    a=check_name();
         	    b=check_pwd();
         	    c=check_mail();
         		d=check_hobby();
         		e=check_area();
         		if(a&&b&&c&&d&&e)
         		{
         			alert("信息输入正确");
         			$("form").submit();
         			
         		}
         		else{
         			alert("有信息输入错误，请检查信息正确后在提交");
         			window.location.href = "getArea";
         		}
         		
         		
         	})
        	/* 知道省获得区的下拉列表 */
        	$(".province").change(function(){
        		/* alert($(".province").val()); */
        		var temp=$(".province").val();
        		var s;
        		 $.ajax({
        	        	type:"post",
        	        	url:"getArea?province="+temp,
        	        	async:true,
        	        	success:function(data){
        	        		/* alert(data); */
        	        		/* 将返回的数据弄成json */
        	        		var data2= eval("("+data+")");
        	        		/* alert(data.type); */
        	        		$(".city").empty();
        	        		for(var i=0;i<data2.length;i++){
        	        			$(".city").append("<option value='"+data2[i]+"'>"+data2[i]+"</option>");
        	        		}
        	        		
        	        		
        	        	}
        	        });
        		 
        		
        	})
        
        });
       
        	
       
			
//      alert($);
		
		</script>
	</head>
	
	<body>
		<form  method="post" action="Register">
		用户名：<input type="text"  class="onlyNumAlpha" name="user_name" placeholder="只能为字母和数字组合"/><br />
		密码：<input type="password" class="pwdcheck" name="user_pwd" placeholder="必须包含大小写字母和数字"/><br />
		邮箱：<input type="text" class="mailcheck" name="user_mail" placeholder="如123@163.com"/><br />
		省：<select class="province" name="province">
		<c:forEach items="${prolist}" var="lac">
         <option  value="${lac}">${lac}</option>
         </c:forEach>
		</select>
		
		市：<select class="city" name="city">
		</select><br />
		爱好：
		<input name="hobby" type="checkbox" value="唱歌" class="1hobby"/>唱歌
		<input name="hobby" type="checkbox" value="跳舞" class="1hobby"/>跳舞 
		<input name="hobby" type="checkbox" value="打篮球" class="1hobby"/>打篮球 
		<input name="hobby" type="checkbox" value="看书" class="1hobby"/>看书 <br />
		<button type="button" class="allcheck">提交</button>
		</form>
	</body>
</html>
