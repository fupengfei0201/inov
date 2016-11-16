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
	<div id="left">
		<%@ include file="/login.jsp"%>
		<%@  include file="/bgide.jsp"%>
	</div>
	<div id="right">
		<div  style="width:90%;height: 95%; margin: auto;margin-top: 2%;" >
	 		<div style="width: 40%;height: 5%;margin-left: 60%; padding-top: 2%;color: #1B539D;float: right">
	 		当前位置：<a href="main.jsp">首页&nbsp;</a>&gt;&gt;<a href="cmpintroduction/cmptcultivate.jsp">人才培养&nbsp;</a></div>
	 		<div style="width: 100%;height:auto;margin: auto;background: white; font-family: 楷体 ;font-weight:bold;overflow: auto;">
	 		<p style="line-height:1.5;">&nbsp;&nbsp;&nbsp;&nbsp;通过各种形式的培训，包括企业文化培训、应知应会培训、执行力培训、专业技能培训以及各种户外拓展项目，全面培养员工，让员工快速融入一诺威，加快成长。<br>
	 		&nbsp;&nbsp;&nbsp;&nbsp;秉承“创建一流团队，培养一流人才”的理念，在人才培养的同时加强团队建设，成功打造了一支思想一致、目标一致、行动高度一致的高素质精英团队正朝着中国领先、世界一流的目标全速前进。
	 		</p><br></div>
	 		 
		</div>
	</div>
</div>
<div id="bottom">
	<%@  include file="/bottom.jsp"%>
</div>	
</body>
</html>