<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/style.css">
<title>Insert title here</title>
<script type="text/javascript" src="javascript/script.js"></script>
</head>
<body>
${requestScope.m}
<div id="reg">
<form action="MnRsgServlet" method="post" name = "myform" onsubmit="return check()">
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