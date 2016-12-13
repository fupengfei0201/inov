<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Insert title here</title>
<script type="text/javascript" src="javascript/regscript.js"></script>
<script type="text/javascript">

function check(){
	if(document.all.pwd.value==""){
		alert("请输入新密码!");
		document.form.newpwd.focus();
		return;
	}
	else if(!checkpwd(document.all.pwd.value)){
		alert("您输入的密码不合法，请重新输入！");
		document.form.pwd.focus();
		return;
	}
	if(document.all.newpwd2.value==""){
		alert("请输入确认密码!");
		document.form.newpwd2.focus();
		return;
	}
	else if(document.all.newpwd2.value!=document.all.pwd.value){
		alert("您两次输入的密码不一致，请重新输入!");
		document.form.pwd.focus();
		return;
	}
	else{
		var a=document.form;
		a.action="NewPwdServlet";
		a.submit();
	}
}
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
	<span style="width: 33.3%;text-align: center;margin-left: 20%">2.输入新密码</span>
	<span style="width:33.4%;text-align: center;margin-left: 20%;color: gray">3.修改成功</span>
	</div>
	<div style="width: 80%;height: 15px;margin: auto;margin-top:10px;background: lightgray;border-radius:4px">
	<div style="width: 33.3%;height: 15px;background: #4593EC;border-radius:4px;float: left"></div>
	<div style="width: 33.3%;height: 15px;background: #1B539D;border-radius:4px;float: left"></div></div>
	<div style="width: 50%;height: auto;margin: auto;margin-top: 6%;margin-left: 10%">
	<span>&nbsp;&nbsp;输入新密码：</span><input type="password" name="pwd" id="uname" class="log"><br><br><span style="font-size: 12px;margin-left: 20%">密码由5~20个字母、数字、“_”或“.”组成（以字母开头）</span><br><br>
	<span>&nbsp;&nbsp;确认新密码：</span><input type="password" name="newpwd2" id="uname" class="log"><br><br>
	<input type="button" value="下一步" class="butt" onclick="return check()" style="margin-left:10%;background:  #1B539D;border: none;color: white; border-radius:4px;margin-left: 10%;margin-top: 10px"/>
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