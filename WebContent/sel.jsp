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
<form action="GradeServlet" method="post">
<table width="100%" height="100%" border="1" cellpadding="0" cellspacing="0" align="center" style="text-align: center;margin-top: 15px">
<tr style="height: 30px">
	<th width="200px">员工姓名</th>
	<th width="200px">所属部门</th>
	<th width="200px">打分</th>
	<%
	if(session.getAttribute("title").equals("manag")){
	%>
	<%
	List<Login>list=(List)request.getAttribute("ll"); 
	for(int i=0;i<list.size();i++){%>
	<tr>
	<td><a><%=list.get(i).getName() %></a></td>
	<td><%=list.get(i).getDept() %></td>
	<td>
	<input type="submit" value="打分">
	</td>
	</tr>
	<%}
	}
	%>
		<%
	if(session.getAttribute("title").equals("tea")){
	%>
	<%
	List<Login>list=(List)request.getAttribute("ll"); 
	for(int i=0;i<list.size();i++){%>
	<tr>
	<td><a href="d.jsp"><%=list.get(i).getName() %></a></td>
	<td><%=list.get(i).getDept() %></td>
	<td>
	<input type="submit" value="打分">
	</td>
	</tr>
	<%}
	}
	%>
		<%
	if(session.getAttribute("title").equals("emp")){
	%>
	<%
	List<Login>list=(List)request.getAttribute("ll"); 
	for(int i=0;i<list.size();i++){%>
	<tr>
	<td><a href="d.jsp"><%=list.get(i).getName() %></a></td>
	<td><%=list.get(i).getDept() %></td>
	<td>
	<input type="submit" value="打分">
	</td>
	</tr>
	<%
	}
	}
	%>
</table>
</form>
</div>
</div>
</body>
</html>