<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">	
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/style.css">
<title>Insert title here</title>
</head>
<body>
<div>
<%@ include file="/head.jsp"%>
<div id="title"></div>
</div>
<div id="center" >
	<div id="bg" style="margin-top:2%; height: 6%;">
	<div id="line" style="background: gray"></div>
	<div>
	<div style="width:97%;height:30px;padding-left: 3%;font-size: 20px;padding-top: 12px;float: left; background: #F1F1F1">用户注册</div>
	</div>
	</div>
	<div id="left">
	<%@  include file="registergide.jsp"%>
	</div>
	<div id="right" style="height: 85%">
	<%@  include file="mngreg.jsp"%>
	</div>
	</div>
<div id="bottom">
	<%@  include file="../bottom.jsp"%>
</div>	
</body>
</html>