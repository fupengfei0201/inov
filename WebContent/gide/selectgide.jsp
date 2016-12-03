<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Insert title here</title>
</head>
<body>
	<div id="gide">
			<input type="submit" value="评&nbsp;分&nbsp;查&nbsp;询" class="page" name="sel" style="color: white" onClick="window.location.href='LoginServlet'">
			<div style="width: 100%; height: 1px; background: grey"></div>
			<input type="submit" value="未评分查询" class="page" name="sel" style="color: white" onClick="window.location.href='grade/hrselgrade.jsp'">
			<div style="width: 100%; height: 1px; background: grey"></div>
			<form action="LogoutServlet" method="post">
			<input type="submit" value="退&nbsp;出&nbsp;系&nbsp;统" class="page" name="sel" style="color: white"></form>
			<div style="width: 100%; height: 1px; background: grey"></div>
		</div>

</body>
</html>