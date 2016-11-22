<%@page import="java.util.ArrayList"%>
<%@page import="inov.fpf.model.vo.Empcontent"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="inov.fpf.model.dao.JDBCContent" %>
   
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Insert title here</title>
<script type="text/javascript" src="javascript/gradescript.js">
</script>
</head>
<body>
<div onload="document.body.scrollTop=document.body.scrollHeight" 
	style="width: 100%;height:95%; overflow: auto;">
<div id="timetext">
<%@ include file="time.jsp"%>
</div>
<% 
if(session.getAttribute("x").equals("0")){
%>
<form action="EmpGradeServlet" method="post" name = "myform" onsubmit="return check()">
<div id="select">

<table width="100%" height="30px" border="1" cellpadding="0" cellspacing="0" align="center" style="text-align: center;">
<tr>
<td width="100px">员工姓名</td>
<td width="100px">
<input type="text" name="name" value="<%=request.getAttribute("pname") %>">

</td>
<td width="100px">所属部门</td>
<td width="100px"><input type="text" name="dept" value="<%=request.getAttribute("dept") %>"></td>
<td width="100px">考核期限</td>
<td width="100px"><input type="text" value="" name="date" id="date" class="txt"></td>
</tr>
</table>
${requestScope.l}
</div>
<div id="grade">
<table width="100%" height="100%" border="1" cellpadding="0" cellspacing="0" align="center" style="text-align: center; ">
<tr style="height: 60px">
	<th width="100px">考核项目</th>
	<th width="100px" colspan="3">考核内容</th>
	<th width="100px">满分</th>
	<th width="100px">评分</th>
	<%
	List<Empcontent>list=(ArrayList)request.getAttribute("list");
	for(int i=0;i<list.size();i++){
	%>
<tr style="height: 60px">
<td><%=list.get(i).getAssessment() %></td>
<td colspan="3"><%=list.get(i).getEmpcontent() %></td>
<td><%=list.get(i).getMarks()%></td>
<td><input type="text" value="" name="grade<%=i%>" style="width: 100%;height: 100%"/></td>
</tr>
<%}%>
<tr>
<td colspan="6" height="50px">
<center>
<%--
String x=(String)request.getAttribute("msg");
--%>
<input type="submit" value="提交">
</center>
</td>
</tr>
</table>
</div>
</form>
<%}
if(session.getAttribute("x").equals("1")){
%>
<form action="EmpgradeServletTwo" method="post" name = "myform" onsubmit="return check()">
<div id="select">

<table width="100%" height="30px" border="1" cellpadding="0" cellspacing="0" align="center" style="text-align: center;">
<tr>
<td width="100px">员工姓名</td>
<td width="100px">
<input type="text" name="name" value="<%=request.getAttribute("pname") %>">

</td>
<td width="100px">所属部门</td>
<td width="100px"><input type="text" name="dept" value="<%=request.getAttribute("dept") %>"></td>
<td width="100px">考核期限</td>
<td width="100px"><input type="text" value="" name="date" id="date" class="txt"></td>
</tr>
</table>
${requestScope.l}
</div>
<div id="grade">
<table width="100%" height="100%" border="1" cellpadding="0" cellspacing="0" align="center" style="text-align: center; ">
<tr style="height: 60px">
	<th width="100px">考核项目</th>
	<th width="100px" colspan="3">考核内容</th>
	<th width="100px">满分</th>
	<th width="100px">评分</th>
	<%
	List<Empcontent>list=(ArrayList)request.getAttribute("list");
	for(int i=0;i<list.size();i++){
	%>
<tr style="height: 60px">
<td><%=list.get(i).getAssessment() %></td>
<td colspan="3"><%=list.get(i).getEmpcontent() %></td>
<td><%=list.get(i).getMarks()%></td>
<td><input type="text" value="" name="grade<%=i%>" style="width: 100%;height: 100%"/></td>
</tr>
<%}%>
<tr>
<td colspan="6" height="50px">
<center>
<%--
String x=(String)request.getAttribute("msg");
--%>
<input type="submit" value="提交">
</center>
</td>
</tr>
</table>
</div>
</form>
<%} %>
${requestScope.msg}
<script type="text/javascript" src="javascript/script.js">
    
</script>
</div>
</body>
</html>