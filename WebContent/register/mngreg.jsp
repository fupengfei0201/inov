<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/style.css">
<title>Insert title here</title>
<script type="text/javascript" src="javascript/regscript.js"></script>
<script type="text/javascript">
function check(){
	if(document.all.name.value==""){
		alert("请输入真实姓名!");
		a.action="mngreg.jsp";
		document.myform.name.focus();
		return;
	}
	else if(!checkname(document.all.name.value)){
		alert("您输入的姓名不合法，请重新输入！");
		a.action="mngreg.jsp";
		document.myform.name.focus();
		return;
	}
	else if(document.all.pwd.value==""){
		alert("请输入密码!");
		a.action="mngreg.jsp";
		document.myform.pwd.focus();
		return;
	}
	else if(!checkpwd(document.all.pwd.value)){
		alert("您输入的密码不合法，请重新输入！");
		a.action="mngreg.jsp";
		document.myform.pwd.focus();
		return;
	}
	else if(document.all.pwd1.value==""){
		alert("请输入确认密码!");
		a.action="mngreg.jsp";
		document.myform.pwd1.focus();
		return;
	}
	else if(document.all.pwd1.value!=document.all.pwd.value){
		alert("您两次输入的密码不一致，请重新输入!");
		a.action="mngreg.jsp";
		document.myform.pwd.focus();
		return;
	}
	else{
		alert("注册成功！");
		var a=document.myform;
		a.action="MnRsgServlet";
		a.submit();
	}
}
</script>
</head>
<body>
${requestScope.m}
<div id="reg">
<form action="" method="post" name = "myform" onsubmit="return check()">
<div style="width: 80%;height:100%;margin: auto;">
<h3 align="center">经理注册</h3>
真实姓名：<input type="text" name="name" class="register" value="" ><br><br>
&nbsp;&nbsp;&nbsp;&nbsp;密码：<input type="password" name="pwd" class="register" value="">
<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="font-size: 12px">密码由5~20个字母、数字、“_”或“.”组成（以字母开头）</span><br><br>
确认密码：<input type="password" name="pwd1" class="register" value=""><br><br>
<input type="submit" value="注册" class="regbtn" >
<input type="reset" value="重置" class="regbtn">
</div></form>
</div>
</body>
</html>
