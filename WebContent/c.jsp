<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title></title>
</head>
<body>
<div>
<%@ include file="/head.jsp"%>
<div id="title"></div>
</div>
<div id="center" >
	<div id="bg" style="margin-top:2%; height: 6%;">
	<div id="line" style="background: gray"></div>
	<div>
	 <div style="width:97%;height:30px;padding-left: 3%;font-size: 20px;padding-top: 12px;float: left; background: #F1F1F1">用户注册</div>
	</div>
	</div>
	<div id="left">
	<%@  include file="register/registergide.jsp"%>
	</div>
	<div id="right" style="height: 85%">
		<br><br>
		<p  style="width: 80%;height: 30px;margin:auto;margin-top:5%;font-size: 18px;font-family: 楷体 ; " >
				<b> 注册成功！</b><br><br><br>
   				<b id="second" >5</b>秒后自动返回主页面...&nbsp;&nbsp;&nbsp;&nbsp;
   				<a href="javascript:goBack();">确定</a> &nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:goNow();">取消</a> 
 			</div>
   		</p>
   			
 		
 	<script type="text/javascript"> 
  		var sec = document.getElementById("second");
  		var i = 5;
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
 		function goNow(){ 
 		 	window.location.href = "register/mngregister.jsp";
		 } 
 	</script> 
	</div>
	</div>
<div id="bottom">
	<%@  include file="../bottom.jsp"%>
</div>	
</body>
</html>