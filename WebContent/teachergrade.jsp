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
		if(check2()){
			alert("请输入合理的分数!");
			//document.all.Tgrade.focus();
		 }
		else if(document.all.comm.value==""){
			alert("请输入综合评语!");
			document.all.comm.focus();
		}
		else {
			a=document.myform;
			a.action="TeacherServlet";
			a.submit();
		}
	}
	function check2(){
		var lh=document.getElementsByName("Tgrade");
		for(var i=0;i<lh.length;i++){
			var score=document.getElementById("score"+i).value;
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
</script>
</head>
<body>
<div onload="document.body.scrollTop=document.body.scrollHeight" 
	style="width: 100%;height:95%; overflow: auto;">
<div id="timetext">
<%@ include file="time.jsp"%>
</div>
${requestScope.l}
<form action="" method="post" name = "myform" >
<div id="select">
<table width="100%" height="30px" border="1" cellpadding="0" cellspacing="0" align="center" style="text-align: center;">
<tr>
<td width="100px">被考评人</td>
<td width="100px"><input type="text" name="name" value="<%=request.getAttribute("pname") %>" style="border:none;text-align: center" readonly/></td>
<td width="100px">指导老师</td>
<td width="100px"><input type="text" name="detp" value="<%=session.getAttribute("name") %>" style="border:none;text-align: center" readonly/></td>
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
<td id="ful<%=i %>"><%=list.get(i).getMarks() %></td>
<td><input type="text" value="" id="score<%=i %>" name="grade<%=i %>" style="width: 100%;height: 100%;text-align: center"><input type="hidden" name="Tgrade" /></td>

</tr>
<%} %>
<tr rowspan="3" height="50px">
<td >综合评语</td>
<td colspan="5"><input type="text" value="" name="comm" style="width: 100%;height: 100%"></td>
</tr>
<tr height="50px">
<td colspan="6"  >

<input type="button" value="提交" onclick="return check()"/></form></td>
</tr>
</table>

</div>
</form>
</div>
${requestScope.msg}
${requestScope.m}
</body>
</html>