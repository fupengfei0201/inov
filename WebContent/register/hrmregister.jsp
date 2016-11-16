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
<div id="center">
	<div id="bg" style="margin-top: 2%;height: 6%">
	<div id="line" style="background: gray"></div>
	<div style=" width: 100%; height:15%;background: #F5F5F5;margin: auto;">
	<div style="padding-left: 3%;font-size: 20px;padding-top: 12px;float: left;">用户注册</div>
	</div>
	</div>
	<div id="left">
	<%@  include file="registergide.jsp"%>
	</div>
	<div id="right"  style="height: 85%">
  	<%@  include file="hrmreg.jsp"%>
	</div>
	</div>
<div id="bottom">
	<%@  include file="/bottom.jsp"%>
</div>	
</body>
</html>