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
用户名：<input type="text" name="uname" id="uname" class="log"><br><br>
密&nbsp;&nbsp;码：<input type="text" name="upassw" id="upassw" class="log"><br><br>
<label></label><input type="radio" checked="checked" name="title" value="emp"/>员工&nbsp;&nbsp;
<label></label><input type="radio" name="title" value="tea"/>师傅<br>
<label></label><input type="radio" name="title" value="manag"/>经理&nbsp;&nbsp;
<input type="radio" name="title" value="hrm"/><label>人力资源</label><br><br>
<input type="submit" value="登录" class="butt">&nbsp;&nbsp;&nbsp;&nbsp; 
<input type="button" value="注册" class="butt" onClick="window.location.href='register/mngregister.jsp'">
</form>
</div><br><br> 
</div>
	${requestScope.msg}	
</body>
</html>