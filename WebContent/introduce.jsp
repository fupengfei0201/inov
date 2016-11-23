<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
<script type="text/javascript" language="javascript">
 function reloadyemian()//最好不要用reload这个关键字,因为很容易和其它函数冲突 
{ 
	window.location.href="LoginServlet"; 
} 
 window.setTimeout("reloadyemian();",5000); 
</script>
</head>
<body>
<div style="width: 60%;height:40%;margin: auto;margin-top: 20px;background: lightblue">
	 		<div style="width: 90%;height: 85%;margin: auto;font-family: 楷体 ;font-weight:bold">
	 		<h2 align="center">员工评分系统说明</h2>
	 		<p style="line-height:1.5;">考评标准说明：<br>
	 		1.优秀最低分数线：90，优秀的人数不得高于总人数的30%。<br>
	 		1.良好最低分数线：80，良好的人数不得高于总人数的30%。<br>
	 		3.一般分数线:80分以下。占比为剩余的约40%。<br>
	 		请各位师傅、部门负责人按照以上总体原则为新员工打分，真正衡量和挑选出优秀的员工。<br><br>
	 		考评细则：<br>
	 		1.员工互评中，除师傅和部门经理以外的3名员工对其进行打分，要求评分人为2名老员工，1名新入司学员，评分标准同以上说明。最后3名员工的平均值为该新学员中员工互评的得分。<br>
	 		2.由于人数较多，工作量较大，请各新员工实习部门提前进行打分工作.
	 		</p><br></div>
</div>
</body>
</html>