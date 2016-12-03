<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>	
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/style.css">
<title>Insert title here</title>
<script type="text/javascript">
var oldColor = 'transparent';
function changeNew(){
  var id = window.event.srcElement.id;
  var obj = document.getElementById(id);
  if(obj.style.background)
    oldColor = obj.style.background;
  else
    oldColor = '#F5F5F5';
  obj.style.background = 'lightgrey';
}
function changeOld(){
  var id = window.event.srcElement.id;
  var obj = document.getElementById(id);
  obj.style.background = oldColor;
//  obj.style.background = 'transparent';
}
</script>
<style type="text/css">
#registergide{
width: 100%;
height: 94%;
box-shadow:2px 2px 5px #909090;
}
.pg{
		width: 100%;
		height: 50px; 
		text-align: center;
	}
	
.pg:hover{
background: lightgrey;
}
</style>
</head>
<body>
	<div id="registergide">
		<form action="" method="post">
		<table width="100%" height="94%" border="1" cellpadding="-2" cellspacing="-2" bordercolor="lightgrey" bordercolordark="lightgrey" bordercolorlight="#F5F5F5" bgcolor="white" style="filter:wave(add=false,freq=1,lightstrength=50,phase=50,strngth=10)">
			<tr>
			<td valign="bottom"><input type="button" id="btn1" value="经&nbsp;&nbsp;理&nbsp;&nbsp;注&nbsp;&nbsp;册" class="pg" onClick="window.location.href='register/mngregister.jsp'" ></td>
			</tr>
			<tr>
			<td valign="bottom"><input type="button" id="btn2" value="指导老师注册" class="pg" onClick="window.location.href='register/tearegister.jsp'"></td>
			</tr>
			<tr>
			<td valign="bottom"><input type="button" id="btn3" value="员&nbsp;&nbsp;工&nbsp;&nbsp;注&nbsp;&nbsp;册" class="pg" onClick="window.location.href='register/empregister.jsp'" ></td>
			</tr>
			<tr>
			<td valign="bottom"><input type="button" id="btn4" value="人力资源注册" class="pg" onClick="window.location.href='register/hrmregister.jsp'"></td>
			</tr>
			<tr>
			<td valign="bottom"><input type="button" id="btn6" value="工&nbsp;段&nbsp;长&nbsp;注&nbsp;册" class="pg" onClick="window.location.href='register/workregister.jsp'" ></td>
			</tr>
			<tr>
			<td valign="bottom"><input type="button" id="btn7" value="班&nbsp;组&nbsp;长&nbsp;注&nbsp;册" class="pg" onClick="window.location.href='register/tleaderregister.jsp'" ></td>
			</tr>
			<tr>
			<td valign="bottom"><input type="button" id="btn5" value="退&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;出" class="pg" onClick="window.location.href='main.jsp'" ></td>
			</tr>
			</table>
			</form>
		</div>
</body>
</html>