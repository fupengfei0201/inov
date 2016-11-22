<%@page import="oracle.net.aso.l"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List,inov.fpf.model.vo.Login"%>
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

<div>
<div style="float: left;margin-left: 10%;margin-top: 30px;">
【<%=request.getAttribute("mk") %>】对以下员工的第【<%=request.getAttribute("q") %>】次打分
</div>
<div id="select">

<table width="100%" height="100%" border="1" cellpadding="0" cellspacing="0" align="center" style="text-align: center;margin-top: 15px">
<tr style="height: 30px">
	<th width="200px">员工姓名</th>
	<th width="200px">所属部门</th>
	<th width="200px">打分</th>
	</tr>
	<%
	if(session.getAttribute("title").equals("manag")){
	%>
	<%
	ArrayList<Login>list=(ArrayList)request.getAttribute("ll"); 
	for(int i=0;i<list.size();i++){%>
	<form action="GradeServlet" method="post">
	<tr>
	<td><input type="text" name="name" value="<%=list.get(i).getName()%>"/></td>
	<td><input type="text" name="dept" value="<%=list.get(i).getDept() %>"/></td>
	<td>
	<input type="submit" value="打分">
	</td>
	</tr>
	</form>
	<%}
	}
	%>
		<%
	if(session.getAttribute("title").equals("tea")){
	%>
	<%
	ArrayList<Login>list=(ArrayList)request.getAttribute("ll"); 
	for(int i=0;i<list.size();i++){%>
	<form action="GradeServlet" method="post">
	<tr>
	<td><input type="text" name="name" value="<%=list.get(i).getName() %>"/></td>
	<td><input type="text" name="dept" value="<%=list.get(i).getDept() %>"/></td>
	<td>
	<input type="submit" value="打分">
	</td>
	</tr>
	<%}%>
	</form>
	<%
	}
	%>
	
		<%
	if(session.getAttribute("title").equals("emp")){
	%>
	<%
 
	if(!request.getAttribute("ll").equals("1")){
		ArrayList<Login>list=(ArrayList)request.getAttribute("ll");
	for(int i=0;i<list.size();i++){%>
	<form action="GradeServlet" method="post">
	<tr>
	<td><td><input type="text" name="name" value="<%=list.get(i).getName()%>"/></td></td>
	<td><input type="text" name="dept" value="<%=list.get(i).getDept() %>"/></td>
	<td>
	<input type="submit" value="打分">
	</td>
	</tr>
	</form>
	<%
	}}%>
	<%

	if(!request.getAttribute("lw").equals("1")){
		ArrayList<Login>l=(ArrayList)request.getAttribute("lw");
	for(int j=0;j<l.size();j++){%>
	<form action="GradeTwoServlet" method="post">
	<tr>
	<td><td><input type="text" name="name" value="<%=l.get(j).getName()%>"/></td></td>
	<td><input type="text" name="dept" value="<%=l.get(j).getDept() %>"/></td>
	<td>
	<input type="submit" value="打分">
	</td>
	</tr>
	</form>

<%}
	}
	}
	%>
</table>

</div>

</div>

</body>
</html>