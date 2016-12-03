<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">	
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Insert title here</title>
</head>
<body>
	<div id="gide">
			<input type="submit" value="评&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;分" class="page" name="sel" style="color: white" onClick="window.location.href='LoginServlet'">
			<div style="width: 100%; height: 1px; background: grey"></div>
			<form action="LogoutServlet" method="post">
			<input type="submit" value="退&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;出" class="page" name="sel" style="color: white;"></form>
			<div style="width: 100%; height: 1px; background: grey"></div>
		</div>

</body>
</html>