<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*,inov.fpf.model.vo.MsgCheckContent"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Insert title here</title>
<script type="text/javascript">
function check(){
    if(document.all.station.value==""){
		alert("请输入员工岗位职责描述!");
		document.all.station.focus();
	}
	else if(check2()){
		alert("请输入合理的分数!");
		//document.all.gra.focus();
	 }
	else if(document.all.comm.value==""){
		alert("请输入综合评语！!");
		document.myform.comm.focus();
	}
	else {
		var a=document.myform;
		a.action="MsgServlet";
		a.submit();
	}
}
function check2(){
	var lh=document.getElementsByName("aa");
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
		<form action="" method="post" name = "myform" >
		${requestScope.l}
		${requestScope.msg}
		${requestScope.m}
			<div id="select">
				<table width="100%" height="100%" border="1" cellpadding="0"
					cellspacing="0" align="center" style="text-align: center;">
					<tr style="width: 80px; height: 30px">
						<td width=80px>被考评人</td>
						<td width=80px><input type="text" name="name" value="<%=request.getAttribute("pname") %>" style="width:80px;border:none;text-align: center" readonly/></td>
						<td width=80px>岗位</td>
						<td width=80px><input type="text" name="dept" value="<%=request.getAttribute("dept") %>" style="width:80px;border:none;text-align: center" readonly/></td>
						<td width=80px>部门经理</td>
						<td width=80px><input type="text" name="mag" value="<%=session.getAttribute("name") %>" style="width:80px;border:none;text-align: center" readonly/></td>
						<td width=80px>考核期限</td>
						<td width=80px><input type="text" value="" name="date" id="date"
							class="txt"></td>
					</tr>
					<tr style="height: 30px">
						<td width=80px>该员工岗位职责描述</td>
						<td colspan="7"><input type="text" value="" name="station" id="date" class="txt" ></td>
					</tr>
				</table>
			</div>
			<div id="grade">
				<table width="100%" height="100%" border="1" cellpadding="0"
					cellspacing="0" align="center" style="text-align: center">
					<tr style="width: 80px; height: 30px">
						<th width="60px">考核项目</th>
						<th width="60px">考核要素</th>
						<th colspan="2" width="60px">考核要素定义</th>
						<th colspan="2"width="60px">考评要点</th>
						<th width="60px">满分</th>
						<th width="60px">评分</th>
					</tr>
					<%
						List<MsgCheckContent> list = (ArrayList) request.getAttribute("list");
						for (int i = 0; i < list.size(); i++) {
					%>
					<tr style="width: 80px; height: 80px">
						<td width="80px"><%=list.get(i).getItme()%></td>
						<td width="80px"><%=list.get(i).getElements()%></td>
						<td colspan="2" width="160px"><%=list.get(i).getDefinition()%></td>
						<td colspan="2" width="160px"><%=list.get(i).getPoints()%></td>
						<td  id="ful<%=i %>" width="80px"><%=list.get(i).getMarks()%></td>
						<td><input type="text" value="" id="score<%=i %>"  name="grade<%=i %>" style="width: 80px;height: 100%;text-align: center"><input type="hidden" name="aa" /></td>
					</tr>
					<%
						}
					%>
					<tr>
						<td>综合评语</td>
						<td colspan="7" height="50px"><input type="text" value="" name="comm" id="ping" size="100"
							value="(不要超过一百字)" style="width: 100%;height: 100%;overflow: auto;"></td>
					</tr>
					<tr>
					
						<td colspan="8" height="30px"><input type="button" value="提交" onclick="return check()"></td>
					</tr>
				</table>
			</div>
		</form>
	</div>
</body>
</html>