<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>一诺威聚氨酯打分系统</title>
<style type="text/css">
</style>
</head>
<body>
<div id="welc">
		<div id="wel">
      <form action="SelServlet" method="post">
<span style="font-weight:bold">用户名：</span><input type="text" name="uname" id="uname" class="log" style="border-color:lightblue;"><br><br>
<span style="font-weight:bold">密&nbsp;&nbsp;码：</span><input type="password" name="upassw" id="upassw" class="log" style="border-color:lightblue;"><br><br>
<span style="color: #1B539D;margin-left: 50%"><a href="findpwd.jsp">忘记密码？</a></span><br><br>
&nbsp;&nbsp;<input type="submit" value="登录" class="butt" style="background:  #1B539D;border: none;color: white; border-radius:4px;">&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" value="注册" class="butt" style="background:  #1B539D;border: none;color: white; border-radius:4px;" onClick="window.location.href='register/mngregister.jsp'">
</form>
</div><br><br> 
</div>
	${requestScope.msg}	
</body>
</html>