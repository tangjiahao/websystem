<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.job_box{
	width: 300px;
	text-align: center;
	
}
.job_box td{
	width:auto;
	height: 30px;
}
.addbt{
	margin-left: 150px;
}
</style>
</head>

</head>  
<body> 
   
    <h2>管理职位</h2>
    <div class="content" >
    <input type="button"  value="载入" class="loadbt">
     <input type="button"  value="添加" class="addbt">
   <input class="acename" value="${user_name}" style="display:none;">
    <div  class="job_box" style="position:absolute;z-index:-1;">
       <table class="job_table"  border="1px" bordercolor="black" 
            bgcolor="white" cellspacing="0px" width="250px">
       	
       
       </table>
     </div>
     
     <div class="job_box2"  style="display:none;background-color:lightgrey;border: 1px solid black;
     	opacity:0.9;width:100px ;height: 70px;text-align: center;margin-left: 80px;">
       <form method="post" action="manageJob?handle=add">
       职称：<input type="text" class="jobname" name="jobname" style="height: 20px;width: 80px;"/><br />
       <button type="button" class="confirm">确认</button><button type="button" class="cancel">退出</button>
       </form>
     </div>
    
    </div>
     
     
	</body>
</body>
</html>
<script src="./js/jquery-3.0.0.min.js"></script>
<script> 
	$(function(){
		/* 加载职位的函数 */
		function watch_job(){
			var username=$('.acename').val();
			 $.ajax({
    	        	type:"post",
    	        	url:"manageJob?handle=watch&&user_name="+username,
    	        	async:true,
    	        	
    	        	success:function(data){
    	        		
    	        		/* alert(data); */
    	        		/* 将返回的数据弄成json */
    	        		
    	        		var data2= eval("("+data+")");
    	        		/* alert(data.type); */
    	        		var table="";
    	        		$(".job_table").empty();
    	        		$(".job_table").append("<tr><th>id</th><th>昵称</th><th>操作</th></tr>");
    	        		for(var i=0;i<data2.length;i++){
    	        		
    	     table="<tr><td>"+data2[i].job_id+"</td>"+"<td>"+data2[i].job_name+"</td>"+"<td>"+'<button class="deletejob">'+"删除"+"</button></tr>";
    	  $(".job_table").append(table);
    	        		}
    	        		/* 动态添加的元素他的绑定事件一定要放在函数里 */
    	        		 $(".deletejob").click(function(){
    	    		    	 /* alert(123); */
    	    		    	 var id= $(this).parents("tr").find("td").eq(0).html();
    	    		    	/*  alert(id); */
    	    		    	
    	    		    	$.ajax({
    	    			        	type:"post",
    	    			        	url:"manageJob?handle=delete&&job_id="+id,
    	    			        	async:true,
    	    			        	
    	    			        	success:function(data){
    	    			        		watch_job();
    	    			        		
    	    			        		
    	    			        	}
    	    			        });
    	    		     });
	        	        		
	        	        	             }
			
	        	        });
		}
		watch_job();
		
		 $(".loadbt").click(function(e) {
			 watch_job();
			 window.location.reload();
	
     });
	
		 /* 点增加按钮弹出输入框 */
     $(".addbt").click(function(e) {
         $(".job_box2").toggle();
     });
		 /* 点确认增加按钮关闭输入框 */
     $(".confirm").click(function() {
    	 var name=$(".jobname").val();
    	 var username=$('.acename').val();
    	 /* alert(name);
    	 alert(username); */
    	 if(name==""){
    		 alert("职称名不能为空");
    		 return false;
    	 }
    	 $.ajax({
	        	type:"post",
	        	url:"manageJob?handle=add",
	        	async:true,
	        	data: { jobname:name, user_name:username},
	        	
	        	success:function(data){
	        		watch_job();
	        		
	        		
	        	}
	        });
    	 
        
     });
     $(".cancel").click(function() {
    	 
    	 
         $(".job_box2").toggle();
     });
     
     
     
    
     
     
	})
	
    
     </script>  