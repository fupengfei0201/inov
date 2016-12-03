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
		<%@  include file="/gide/bgide.jsp"%>
	</div>
	<div id="right">
		<div style="width:90%;height: 95%; margin: auto;margin-top: 2%;" >
	 		<div style="width: 40%;height: 5%;margin-left: 60%; padding-top: 2%;color: #1B539D;float: right">
	 		当前位置：<a href="main.jsp">首页&nbsp;</a>&gt;&gt;<a href="cmpintroduction/cmpmsg.jsp">公司简介&nbsp;</a></div>
	 		<div style="width: 100%;height: 85%;margin: auto;background: white; font-family: 楷体 ;font-weight:bold;overflow: auto;">
	 		<p style="line-height:1.5;">&nbsp;&nbsp;&nbsp;&nbsp;山东一诺威聚氨酯股份有限公司成立于2003年10月，是专业的聚氨酯原料PO、EO下游衍生物生产制造商。下设4个子公司：山东一诺威新材料有限公司、上海东大聚氨酯有限公司、上海东大化学有限公司、山东一诺威化学贸易有限公司（以上公司统称：一诺威聚氨酯）。<br>
	 		&nbsp;&nbsp;&nbsp;&nbsp;公司是国家火炬计划重点高新技术企业，《国际田径协会联合会田径场地设施标准手册》编委委员，中国聚氨酯工业协会副理事长单位、铺装材料专业委员会主任单位、中国田径协会场地器材专业委员会理事，体育场地专业承包壹级资质企业，全国田径大奖赛（淄博站）顶级合作伙伴，山东省专利明星企业，山东名牌企业，山东省博士后创新实践基地，淄博市聚氨酯工程技术研究中心，淄博市首届市长质量奖获奖单位。
	 		<br>&nbsp;&nbsp;&nbsp;&nbsp;公司主要经营产品有：聚氨酯弹性体（预聚体）系列、高回弹组合料系列、塑胶跑道浆料及粘合剂系列等，同时经营 PPG、MDI、TDI等聚氨酯原料，并承接塑胶跑道工程施工，市场占有率稳居国内同行业第一，并远销东南亚、欧洲、美洲、大洋洲等50多个国家与地区。<br>
	 		&nbsp;&nbsp;&nbsp;&nbsp;公司拥有一流的营销团队，专业、专注服务于全球客户的高品质、个性化需求。企业通过ISO9001-2008国际质量体系认证，符合国际安全、环保要求，产品质量得到客户广泛认可。<br>
	 		&nbsp;&nbsp;&nbsp;&nbsp;公司始终秉承“务实创新、追求卓越”的发展理念，立志于“让所有使用一诺威聚氨酯产品的人生活更美好”的使命，以“十大企业文化”为一切创新的灵魂和企业持续发展的原动力，引入“现场5S管理”、“六西格玛精益管理”、“ERP信息管理系统”等先进的管理方法，以“创建一流企业，培养一流人才”为办企方针，把人才作为企业发展的创业之本、竞争之本、发展之本，实行“绩效工资制”、“岗位竞聘”等，为员工搭建公平的发展平台。<br>
	 		&nbsp;&nbsp;&nbsp;&nbsp;一诺威人将充分发挥规模优势、产业链优势、人才优势，为您提供最可信赖的产品，与您共同携手创造美好的明天！</p><br></div>
	 		 
		</div>
	</div>
</div>
<div id="bottom">
	<%@  include file="/bottom.jsp"%>
</div>	
</body>
</html>