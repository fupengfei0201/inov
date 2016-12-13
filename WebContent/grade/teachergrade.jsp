<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*,inov.fpf.model.vo.TCheckPoints" %>
      <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">	
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" >
var sum=0;
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
			fn();
		}
	}
	
	
	function check2(){
		var lh=document.getElementsByName("Tgrade");
		for(var i=0;i<lh.length;i++){
			var score=document.getElementById("score"+i).value;
			sum=sum+parseInt(score);
			//alert(sum);
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
		//alert(sum);
		
}
	

	function fn(){
		//alert("进入啦！");
		//alert(sum);
	      if(confirm("该员工得分为："+sum+"分\n\n确认提交？")){
	    	  var a=document.myform;
	    	  a.action="TeacherServlet";
			  a.submit();	          
	      }else{
	    	  sum=0;
	    	  a.action="teachergrade.jsp";
	    	
	      }
	}
</script>
</head>
<body>
<div onload="document.body.scrollTop=document.body.scrollHeight" 
	style="width: 100%;height:95%; overflow: auto;">
<div id="timetext">
<%@ include file="/time.jsp"%>
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

<input type="button" value="提交" onclick="return check()"/></td>
</tr>
</table>

</div>
</form>
</div>
${requestScope.msg}
${requestScope.m}
</body>
</html>