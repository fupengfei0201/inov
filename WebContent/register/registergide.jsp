<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>	
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/style.css">
<title>Insert title here</title>
<style type="text/css">
#registergide{
width: 100%;
height: 94%;
background: #F5F5F5;
box-shadow:2px 2px 5px #909090;
}
.pg{
		width: 100%;
		height: 50px; 
		text-align: center;
		background: none;
		border: none;
	}
	
	#bt{
	width: 100%;
	 height: 1px; 
	 background: lightgrey;
	}
.pg:hover{
background: lightgrey;
}
</style>
</head>
<body>
	<div id="registergide">
		<form action="" method="post">
			<input type="button" value="经&nbsp;&nbsp;理&nbsp;&nbsp;注&nbsp;&nbsp;册" class="pg" onClick="window.location.href='register/mngregister.jsp'">
			<div id="bt"></div>
			<input type="button" value="指导老师注册" class="pg" onClick="window.location.href='register/tearegister.jsp'">
			<div id="bt"></div>
			<input type="button" value="员&nbsp;&nbsp;工&nbsp;&nbsp;注&nbsp;&nbsp;册" class="pg" onClick="window.location.href='register/empregister.jsp'">
			<div id="bt"></div>
			<input type="button" value="人力资源注册" class="pg" onClick="window.location.href='register/hrmregister.jsp'">
			<div id="bt"></div>
			<input type="button" value="退&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;出" class="pg" onClick="window.location.href='main.jsp'">
			<div id="bt"></div>
			</form>
		</div>
</body>
</html>