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
		document.myform.name.focus();
		return;
	}
	else if(!checkname(document.all.name.value)){
		alert("您输入的姓名不合法，请重新输入！");
		document.myform.name.focus();
		return;
	}
	else if(document.all.pwd.value==""){
		alert("请输入密码!");
		document.myform.pwd.focus();
		return;
	}
	else if(!checkpwd(document.all.pwd.value)){
		alert("您输入的密码不合法，请重新输入！");
		document.myform.pwd.focus();
		return;
	}
	else if(document.all.pwd1.value==""){
		alert("请输入确认密码!");
		document.myform.pwd1.focus();
		return;
	}
	else if(document.all.pwd1.value!=document.all.pwd.value){
		alert("您两次输入的密码不一致，请重新输入!");
		document.myform.pwd.focus();
		return;
	}
	else if(document.all.dept.value==""){
		alert("请输入部门!");
		document.myform.dept.focus();
		return;
	}
	else if(document.myform.edu.value==""){
		alert("请输入学历!");
		document.myform.edu.focus();
		return;
	}
	else if(document.myform.time.value==""){
		alert("请输入入职时间!");
		document.myform.time.focus();
		return;
	}
	else if(document.myform.dname.value==""){
		alert("请输入工段!");
		document.myform.dname.focus();
		return;
	}
	else if(document.myform.tea.value==""){
		alert("请输入师傅姓名!");
		document.myform.tea.focus();
		return;
	}
	else{
		var a=document.myform;
		a.action="EmpRegServlet";
		a.submit();
	}
}
</script>
</head>
<body>
${requestScope.msg}
<div id="reg">
<form action="" method="post" name = "myform" >
<div style="width: 80%;height:80%;margin: auto;">
<h3 align="center">员工注册</h3>
真实姓名：<input type="text" name="name" value="" class="register" ><br><br>
&nbsp;&nbsp;&nbsp;&nbsp;密码：<input type="password" name="pwd" value="" class="register" ><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="font-size: 12px">密码由5~20个字母、数字、“_”或“.”组成（以字母开头）</span><br><br>
确认密码：<input type="password" name="pwd1" value="" class="register"><br><br>
&nbsp;&nbsp;&nbsp;&nbsp;部门：<input type="text" name="dept" value="" class="register"><br><br>
&nbsp;&nbsp;&nbsp;&nbsp;学历：<select id="a" name="edu" class="register">
<option value="">请选择</option>
<option value="博士">博士</option>
<option value="硕士">硕士</option>
<option value="本科">本科</option>
<option value="专科">专科</option>
<option value="专科以下">专科以下</option>
</select>
<br><br>
入职时间：<input type="date" name="time"  value="" class="register"><br><br>
&nbsp;&nbsp;&nbsp;&nbsp;工段：<input type="text" name="dname" value="" class="register" ><br><br>
&nbsp;&nbsp;&nbsp;&nbsp;师傅：<input type="text" name="tea" value="" class="register" ><br><br>
<input type="button" value="注册" class="regbtn" onclick="return check()">
<input type="reset" value="重置" class="regbtn">
</div></form>
</div>
</body>
</html>