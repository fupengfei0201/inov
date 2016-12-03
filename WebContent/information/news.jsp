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
#time{
width: 30%;
height: 3%;
float: right;
margin-right: 5%;
text-align: right;
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
	 		当前位置：<a href="main.jsp">首页&nbsp;</a>&gt;&gt;<a href="information/news.jsp">信息公告&nbsp;</a></div>
	 		<h3 align="center" style="color:#1B539D; ">艰苦奋斗 勇争第——诺威股份公司召开成立十三周年座谈会</h3>
	 		<div id="time">日期：2016-10-24</div>
	 		<div onload="document.body.scrollTop=document.body.scrollHeight" style="width: 100%;height: 85%;margin: auto;background: white; font-family: 楷体 ;font-weight:bold;overflow: auto;" >
	 		<p style="line-height:1.5;">&nbsp;&nbsp;&nbsp;&nbsp;2016年10月22日下午13:30分，一诺威股份在厂区1号楼2楼会议室召开了以“艰苦奋斗 勇争第一”为主题的公司成立13周年座谈会，总经理李健等30余名部门干部职工参加座谈。<br>
	 		&nbsp;&nbsp;&nbsp;&nbsp;一诺威股份成立于2003年10月22日，147厂区奠基于2010年10月22日，13年的发展在精彩的视频中逐一展现，从中看到了一诺威从创业园-鲁泰大道-147区的历史变迁，在座的每一位员工都深深的感受到一诺威的过去对自己的震撼，对一诺威的未来充满坚定与信心。大家齐唱《生日快乐歌》，共同祝愿一诺威的明天更加美好！
	 		<br>&nbsp;&nbsp;&nbsp;&nbsp;参加座谈会的员工来自于各个岗位、各个年龄阶层，有入厂十几年的刘强、张芳、翟海燕等、也有入厂一年左右的杜长青、戚静静等，每个人都用自己的历史讲述一诺威，用一诺威的未来塑造座谈会上，李总首先带领大家学习了2016年第9期的 《一诺威人》中党委书记、董事长徐军在2016年1-8月份总结会上主题为“艰苦奋斗 勇争第一”的讲话。要求各部门详细传阅、共同学习，将指导思想传播到每位员工的心中。<br>
	 		&nbsp;&nbsp;&nbsp;&nbsp;公司始终秉承“务实创新、追求卓越”的发展理念，立志于“让所有使用一诺威聚氨酯产品的人生活更美好”的使命，以“十大企业文化”为一切创新的灵魂和企业持续发展的原动力，引入“现场5S管理”、“六西格玛精益管理”、“ERP信息管理系统”等先进的管理方法，以“创建一流企业，培养一流人才”为办企方针，把人才作为企业发展的创业之本、竞争之本、发展之本，实行“绩效工资制”、“岗位竞聘”等，为员工搭建公平的发展平台。<br>
	 		&nbsp;&nbsp;&nbsp;&nbsp;根据座谈会的内容，李总做了以下部署：<br>
1、市场竞争激烈，不同的心理造就不同的涨跌需求，在市场主导的价格面前，我们要做到与狼共舞。在特殊时期面前，我们需要做到以下两个方面。<br>
（1）抢订单、增销量、看长线效应和趋势、特殊时期特殊办法；<br>
（2）生产、财务、管理、物流等部门全方位做好服务；<br>
2、对工作提出以下要求<br>
（1）一如既往的抓好安全工作，安全管理最重要的是自我管理；<br>
（2）带团队。这是每一位老员工的职责，与员工做好沟通是对员工和企业最好的负责。带领团队要有目标、有进度、有要求；<br>
（3）学习。不学则退，只有扩大知识面才能解决问题，要做到干什么会什么、干什么懂什么；<br>
3、工作理念要塑造<br>
（1）公司的利益高于一切；<br>
（2）把事情做到前面；<br>
（3）响应。任何事情都是及时响应，响应是一种礼貌和素养；<br>
（4）规范。要梳理、规范企业流程，流程比制度更重要；<br>
（5）主动。主动就是高效；<br>
（6）简单。不能把任何事情都想象的过于复杂影响工作进度；<br>
（7）要做到目标、计划、进度三要素，工作中要考虑成本；<br>
（8）沟通。要做到有效沟通，沟通是为效果服务；<br>
（9）结果文化。结果用数据说话、情况不明不下决策；<br>
（10）创新。创新来自于实践，昨天的成功会成为未来的绊脚石，要勇于突破。<br>
座谈会在铿锵有力的“团结就是力量”的歌声中结束。百年一诺威不是梦，一诺威股份全体成员会继续用团结的力量、勤奋的汗水打造一诺威的未来。共同祝愿一诺威让明天更加美好！</p><br></div>
	 		 
		</div>
	</div>
</div>
<div id="bottom">
	<%@  include file="/bottom.jsp"%>
</div>	
</body>
</html>