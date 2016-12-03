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
<script type="text/javascript">
var sum=0;
function check(){
	if(check2()){
		alert("请输入合理的分数!");
		//document.all.gra.focus();
	 }
	else{
		fn();
	}
}
function ch(){
	if(check2()){
		alert("请输入合理的分数!");
		//document.all.gra.focus();
	 }
	else{
		fn2();
		
	}
}

function check2(){
	var lh=document.getElementsByName("gra");
	for(var i=0;i<lh.length;i++){
		var score=document.getElementById("score"+i).value;
		sum=sum+parseInt(score);
		var ful=document.getElementById("ful"+i).innerHTML;
	if(score=="" ){
		document.getElementById("score"+i).focus();
		return true;
		break;
	}
	else if(score!="" && (parseInt(score)>parseInt(ful) || parseInt(score)<0)){
		document.getElementById("score"+i).focus();
		return true;
		break;
	}
}
}

function fn(){
	alert("进入啦！");
	alert(sum);
      if(confirm("该员工得分为："+sum+"分\n\n确认提交？")){
    	  var a=document.myform;
    	  a.action="EmpGradeServlet";
		  a.submit();	          
      }else{
    	  sum=0;
    	  a.action="empgrade.jsp";
    	
      }
}

function fn2(){
	alert("进入啦！");
	alert(sum);
      if(confirm("该员工得分为："+sum+"分\n\n确认提交？")){
    	  var a=document.myform2;
    	  a.action="EmpgradeServletTwo";
		  a.submit();	          
      }else{
    	  sum=0;
    	  a.action="empgrade.jsp";
    	
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
<% 
if(session.getAttribute("x").equals("0")){
%>
<form action="" method="post" name = "myform" >
<div id="select">

<table width="100%" height="30px" border="1" cellpadding="0" cellspacing="0" align="center" style="text-align: center;">
<tr>
<td width="100px">员工姓名</td>
<td width="100px">
<input type="text" name="name" value="<%=request.getAttribute("pname") %>" style="border:none;text-align: center" readonly>

</td>
<td width="100px">所属部门</td>
<td width="100px"><input type="text" name="dept" value="<%=request.getAttribute("dept") %>" style="border:none;text-align: center" readonly></td>
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
<td id="ful<%=i %>"><%=list.get(i).getMarks()%></td>
<td><input type="text" value="" id="score<%=i %>" name="grade<%=i%>" style="width: 100%;height: 100%;text-align: center"/><input type="hidden" name="gra" /></td>
</tr>
<%}%>
<tr>
<td colspan="6" height="50px">
<center>
<%--
String x=(String)request.getAttribute("msg");
--%>
<input type="button" value="提交" onclick="return check()">
</center>
</td>
</tr>
</table>
</div>
</form>
<%}
if(session.getAttribute("x").equals("1")){
%>
<form action="" method="post" name = "myform2">
<div id="select">

<table width="100%" height="30px" border="1" cellpadding="0" cellspacing="0" align="center" style="text-align: center;">
<tr>
<td width="100px">员工姓名</td>
<td width="100px">
<input type="text" name="name" value="<%=request.getAttribute("pname") %>" style="border:none;text-align: center" readonly/>

</td>
<td width="100px">所属部门</td>
<td width="100px"><input type="text" name="dept" value="<%=request.getAttribute("dept") %>" style="border:none;text-align: center" readonly/></td>
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
<td id="ful<%=i %>"><%=list.get(i).getMarks()%></td>
<td><input type="text" value="" id="score<%=i %>"  name="grade<%=i%>" style="width: 100%;height: 100%;text-align: center"/><input type="hidden" name="Tgrade" /></td>
</tr>
<%}%>
<tr>
<td colspan="6" height="50px">
<center>
<%--
String x=(String)request.getAttribute("msg");
--%>
<input type="submit" value="提交" onclick="return ch()">
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