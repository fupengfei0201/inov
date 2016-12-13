<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Insert title here</title>
<script type="text/javascript">

</script>
</head>
<body>
<div>
<%@ include file="head.jsp"%>
<div id="title"></div>
</div>
<div id="center" >
	<div id="bg" style="margin-top:2%; height: 6%;">
	<div id="line" style="background: gray"></div>
	<div>
	<div style="width:97%;height:30px;padding-left: 3%;font-size: 20px;padding-top: 12px;float: left; background: #F1F1F1">找回密码</div>
	</div>
	</div>
	<form action="" name="form"  method="post"  >
	<div style="width:100%;height: 85%">
	<div style="width: 80%;margin: auto;margin-top:30px;">
	<span  style="width:33.3%;margin-left: 10%;">1.验证员工信息</span>
	<span style="width: 33.3%;text-align: center;margin-left: 20%;">2.输入新密码</span>
	<span style="width:33.4%;text-align: center;margin-left: 20%;">3.修改成功</span>
	</div>
	<div style="width: 80%;height: 15px;margin: auto;margin-top:10px;background: lightgray;border-radius:4px">
	<div style="width: 33.3%;height: 15px;background: #4593EC;border-radius:4px;float: left"></div>
	<div style="width: 33.3%;height: 15px;background: #4593EC;border-radius:4px;float: left"></div>
	<div style="width: 33.3%;height: 15px;background: #1B539D;border-radius:4px;float: left"></div></div>
	<div style="width: 50%;height: auto;margin: auto;margin-top: 6%;margin-left: 10%">
	<br><br>
		<p  style="width: 80%;height: 30px;margin:auto;margin-top:30px%;font-size: 18px;font-family: 楷体 ; " >
				<b> 修改密码成功！</b><br><br><br>
   				<b id="second" >8</b>秒后自动返回主页面...&nbsp;&nbsp;&nbsp;&nbsp;
   				<a href="javascript:goBack();">确定</a> &nbsp;&nbsp;&nbsp;&nbsp; 
 			
   		</p>
   		<script type="text/javascript"> 
  		var sec = document.getElementById("second");
  		var i = 8;
  		var timer = setInterval(function(){
   		i--;
    	sec.innerHTML = i;
    	if(i==1){
      		window.location.href = "main.jsp";
   	 		}
  		},1000);
    
 		function goBack(){ 
 		 	window.location.href = "main.jsp";
		 } 
 		
 	</script> 
	<!--  <span>验证码：</span><input type="text" id="yzm" name="yzm" onchange="yanzheng()" class="log"><span id="xianshi"></span><img src="ImageServlet"><br><br>
	<input type="button" value="下一步" onclick="yanzheng()"> -->
	</div>
	</div>
	</form>
	</div>
<div id="bottom">
	<%@  include file="bottom.jsp"%>
</div>	
</body>
</html>