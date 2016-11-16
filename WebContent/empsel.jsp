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
<%@ include file="head.jsp"%>
<div id="title"><form action="LogoutServlet" method="post">
	<input type="submit" value="退出系统" class="exit">
	</form></div>
</div>
<div id="center">
<div id="left">
	<%@ include file="welcome.jsp"%>
	<%
	if(session.getAttribute("title").equals("hrm")){
	%>
	<%@  include file="selectgide.jsp"%><%} %>
	<%
	if(!session.getAttribute("title").equals("hrm")){
	%>
	<%@  include file="agide.jsp"%><%} %>
	</div>
	<div id="right">
  	<%@  include file="sel.jsp"%>
	</div>
	</div>
<div id="bottom">
	<%@  include file="bottom.jsp"%>
</div>	
</body>
</html>