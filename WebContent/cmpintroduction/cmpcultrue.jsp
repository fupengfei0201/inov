<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
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
		<%@  include file="/gide/bgide.jsp"%>
	</div>
	<div id="right">
		<div  style="width:90%;height: 95%; margin: auto;margin-top: 2%;" >
	 		<div style="width: 40%;height: 5%;margin-left: 60%; padding-top: 2%;color: #1B539D;float: right">
	 		当前位置：<a href="main.jsp">首页&nbsp;</a>&gt;&gt;<a href="cmpintroduction/cmpcultrue.jsp">企业文化&nbsp;</a></div>
	 		<div style="width: 100%;height: 85%;margin: auto;background: white; font-family: 楷体 ;font-weight:bold;overflow: auto;">
	 		<ul>
	 		<li style="list-style-type:none;" title="聚氨酯竞争力目标：">聚氨酯竞争力目标：</li>
	 		<li style="list-style-type: circle; margin-left: 3%">产品人均销售收入300万元/人.年</li>
	 		<li style="list-style-type: circle;margin-left: 3%">人均利润10万元/人.年</li>
	 		<li style="list-style-type: circle;margin-left: 3%">高科技、环保，行业竞争力前三名</li>
	 		</ul>
	 		<ul>
	 		<li title="企业的核心文化：">企业的核心文化：</li>
	 		<li>企业精神：务实创新  追求卓越</li>
	 		<li>工作作风：迅速反应  马上行动</li>
	 		<li>十大文化：诚信文化  务实文化  结果文化  执行文化  速度文化  激情文化  团队文化  制度文化  桌面文化  员工升迁</li>
	 		</ul>
	 		<ul>
	 		<li title="聚氨酯的愿景:">聚氨酯的愿景：</li>
	 		<li>做对员工负责任的企业</li>
	 		<li>做对社会负责任的企业</li>
	 		<li>做全球领先的聚氨酯企业</li>
	 		</ul>
	 		</div>
	 		 
		</div>
	</div>
</div>
<div id="bottom">
	<%@  include file="/bottom.jsp"%>
</div>	
</body>
</html>