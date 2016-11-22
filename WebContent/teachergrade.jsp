<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*,inov.fpf.model.vo.TCheckPoints" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" >
function check(){
	
	if(document.all.name.value==""){
		alert("请输入员工姓名!");
		document.myform.name.focus();
	}
	else if(document.all.dept.value==""){
		alert("请输入指导老师!");
		document.myform.dept.focus();
	}
	else if(document.all.grade.value==""){
		alert("请输入分数!");
		document.myform.grade.focus();
	}
	else if(document.all.comm.value==""){
		alert("请输入综合评语!");
		document.myform.comm.focus();
	}
	else {
		var a=document.myform;
		a.action="TeacherServlet";
		a.submit();
	}
}
</script>
</head>
<body>
<div onload="document.body.scrollTop=document.body.scrollHeight" 
	style="width: 100%;height:95%; overflow: auto;">
<div id="timetext">
<%@ include file="time.jsp"%>
</div>
${requestScope.l}
<form action="TeacherServlet" method="post" name = "myform" onsubmit="return check()">
<div id="select">
<table width="100%" height="30px" border="1" cellpadding="0" cellspacing="0" align="center" style="text-align: center;">
<tr>
<td width="100px">被考评人</td>
<td width="100px"><input type="text" name="name" value="<%=request.getAttribute("pname") %>"/></td>
<td width="100px">指导老师</td>
<td width="100px"><input type="text" name="detp" value="<%=session.getAttribute("name") %>"/></td>
<td width="100px">考核期限</td>
<td width="100px"><input type="text" value="" name="date" id="date" class="txt"></td>
</tr>
</table>
</div>
<div id="grade" onload="document.body.scrollTop=document.body.scrollHeight" >
<table width="100%" height="100%" border="1" cellpadding="0" cellspacing="0" align="center" style="text-align: center;">
<tr height="60px">
	<th width="100px">考核项目</th>
	<th width="100px">考核要素</th>
	<th width="100px" colspan="2">考核要点</th>
	<th width="100px">满分</th>
	<th width="100px">评分</th>
</tr>
<%
List<TCheckPoints> list=(ArrayList)request.getAttribute("ls");
for(int i=0;i<list.size();i++){
%>
<tr height="60px">
<td><%=list.get(i).getItem() %></td>
<td><%=list.get(i).getElements() %></td>
<td colspan="2"><%=list.get(i).getPoints() %></td>
<td><%=list.get(i).getMarks() %></td>
<td><input type="text" value="" name="grade<%=i%>" style="width: 100%;height: 100%"></td>
</tr>
<%} %>
<tr rowspan="3" height="50px">
<td >综合评语</td>
<td colspan="5"><input type="text" value="" name="comm" style="width: 100%;height: 100%"></td>
</tr>
<tr height="50px">
<td colspan="6"  >

<input type="submit" value="提交"/></form></td>
</tr>
</table>

</div>
</form>
</div>
${requestScope.msg}
${requestScope.m}
</body>
</html>