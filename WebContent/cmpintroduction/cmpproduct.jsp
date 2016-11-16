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
<style type="text/css">
li{
list-style-type:none; 
}
</style>
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
	 		当前位置：<a href="main.jsp">首页&nbsp;</a>&gt;&gt;<a href="cmpintroduction/cmpproduct.jsp">产品经营&nbsp;</a></div>
	 		<div style="width: 100%;height: 85%;margin: auto;background: white; font-family: 楷体 ;font-weight:bold;overflow: auto;">
	 		<div id="content" style="height: 100%;">
<div id="msgleft" style="height: 100%">
<div>
<div id="line"></div>
<div id="bg">
<div style="padding-left: 10%;font-size: 20px;padding-top: 12px;float: left;">TPU</div>
</div></div>
<div style="margin-top: 30%">
<div id="line"></div>
<div id="bg">
<div style="padding-left: 10%;font-size: 20px;padding-top: 12px;float: left;">聚酯</div>
</div>
</div>
<div style="margin-top: 30%">
<div id="line"></div>
<div id="bg">
<div style="padding-left: 10%;font-size: 20px;padding-top: 12px;float: left;">铺装材料</div>
</div>
<div id="componymsg" >
<table width="100%" height="100%" border="0.5px dashed" cellpadding="0px" cellspacing="0px" bordercolor="lightgray"  rules="rows">
<tr>
	<td>
	<div style="float: left;">球场面料</div></td>
</tr>
<tr>
	<td>
	<div style="float: left;">跑道用面喷色浆</div>
	</td>
</tr>
<tr>
	<td>
	<div style="float: left;">人造草坪背胶</div>
	</td>
</tr>
<tr>
	<td>
	<div style="float: left;">特殊高温粘合剂</div>
	</td>
</tr>
<tr>
	<td>
	<div style="float: left;">浆料系列</div>
	</td>
</tr>
<tr>
	<td>
	<div style="float: left;">硅PU材料</div>
	</td>
</tr>
<tr>
	<td>
	<div style="float: left;">常温粘合剂</div>
	</td>
</tr>
<tr>
	<td>
	<div style="float: left;">软木胶</div>
	</td>
</tr>
</table>
</div>
</div>

<div style="margin-top: 30%;">
<div id="line"></div>
<div id="bg">
<div style="padding-left: 10%;font-size: 20px;padding-top: 12px;float: left;">高回弹</div>
</div>
<div id="componymsg" style="height: auto;">
<table width="100%" height="100%" border="0.5px dashed" cellpadding="0px" cellspacing="0px" bordercolor="lightgray"  rules="rows">
<tr>
	<td>
	<div style="float: left;">室内软包料</div></td>
</tr>
<tr>
	<td>
	<div style="float: left;">高回弹汽车座椅</div></td>
</tr>
<tr>
	<td>
	<div style="float: left;">隔音垫类组合料</div></td>
</tr>
<tr>
	<td>
	<div style="float: left;">发泡轮胎料</div></td>
</tr>
<tr>
	<td>
	<div style="float: left;">自结皮组合料</div></td>
</tr>
</table>
</div>
</div>
</div>
<div id="msgright" style="height: 100%">
<div>
<div id="line"></div>
<div id="bg">
<div style="padding-left: 10%;font-size: 20px;padding-top: 12px;float: left;">预聚体</div>
</div>
<div id="componymsg" style="height: 40%;">
<table width="100%" height="100%" border="0.5px dashed" cellpadding="0px" cellspacing="0px" bordercolor="lightgray"  rules="rows">
<tr>
	<td>
	<div style="float: left;">聚酯型聚氨酯预聚体</div></td>
</tr>
<tr>
	<td>
	<div style="float: left;">聚酯多元醇/TDI系列</div>
	</td>
</tr>
<tr>
	<td>
	<div style="float: left;">聚醚/TDI系列</div>
	</td>
</tr>
</table>
</div>
</div>
<div style="margin-top: 30%">
<div id="line"></div>
<div id="bg">
<div style="padding-left: 10%;font-size: 20px;padding-top: 12px;float: left;">改性产品</div>
</div>
</div>

<div style="margin-top: 30%;">
<div id="line"></div>
<div id="bg">
<div style="padding-left: 10%;font-size: 20px;padding-top: 12px;float: left;">微孔弹性体</div>
</div>
<div id="componymsg" style="height: auto;">
<table width="100%" height="100%" border="0.5px dashed" cellpadding="0px" cellspacing="0px" bordercolor="lightgray"  rules="rows">
<tr>
	<td>
	<div style="float: left;">轮胎</div></td>
</tr>
</table>
</div>
</div>
</div>

	 		</div>
	 		 
		</div>
	</div>
</div>
</div>
<div id="bottom">
	<%@  include file="/bottom.jsp"%>
</div>	
</body>
</html>