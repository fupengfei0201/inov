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
<%@ include file="/head.jsp"%>
<div id="title"><form action="LogoutServlet" method="post">
	<input type="submit" value="退出系统" class="exit" style="color: white;">
	</form></div>
</div>
<div id="center">
<div id="left">
	<%@ include file="/welcome.jsp"%>
	<%
	if(session.getAttribute("title").equals("hrm")){
	%>
	<%@  include file="/gide/selectgide.jsp"%><%} %>
	<%
	if(session.getAttribute("title").equals("manag")){
	%>
	<%@  include file="/gide/mnggide.jsp"%><%} %>
	<%
	if(!session.getAttribute("title").equals("hrm") &&(!session.getAttribute("title").equals("manag") )){
	%>
	<%@  include file="/gide/agide.jsp"%><%} %>
	</div>
	<div id="right">
	<%
	if(session.getAttribute("title").equals("emp")){
	%>
	<%@  include file="empgrade.jsp"%><%} %>
	<%
	if(session.getAttribute("title").equals("tea")){
	%>
	<%@  include file="teachergrade.jsp"%><%} %>
	<%
	if(session.getAttribute("title").equals("manag")){
	%>
	<%@  include file="mngrade.jsp"%><%} %>
	<%
	if(session.getAttribute("title").equals("cheif")){
	%>
	<%@  include file="cheifgrade.jsp"%><%} %>
	<%
	if(session.getAttribute("title").equals("leader")){
	%>
	<%@  include file="leadergrade.jsp"%><%} %>
	<%
	if(session.getAttribute("title").equals("hrm")){
	%>
  	<%@  include file="selectgrade.jsp"%><%} %>
	</div>
	</div>
<div id="bottom">
	<%@  include file="/bottom.jsp"%>
</div>	
</body>
</html>