<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>
<body>
<div>
<%@ include file="head.jsp"%>
<div id="title">
<form action="LogoutServlet" method="post">
	<input type="submit" value="退出系统" class="exit">
	</form></div>
</div>
<div id="center" style="background :#F5F5F5;">
	<div style="width: 60%;height:auto;margin: auto;font-family: 楷体 ;font-weight:bold;padding-top: 3%">
	 		<h2 align="center">员工评分系统说明</h2>
	 		<div style="width: 100%;height: 3px;background:lightgrey;"></div>
	 		<p style="line-height:1.5;">考评标准说明：<br>
	 		1.优秀最低分数线：90，优秀的人数不得高于总人数的30%。<br>
	 		1.良好最低分数线：80，良好的人数不得高于总人数的30%。<br>
	 		3.一般分数线:80分以下。占比为剩余的约40%。<br>
	 		请各位师傅、部门负责人按照以上总体原则为新员工打分，真正衡量和挑选出优秀的员工。<br><br>
	 		考评细则：<br>
	 		1.员工互评中，除师傅和部门经理以外的3名员工对其进行打分，要求评分人为2名老员工，1名新入司学员，评分标准同以上说明。最后3名员工的平均值为该新学员中员工互评的得分。<br>
	 		2.由于人数较多，工作量较大，请各新员工实习部门提前进行打分工作.
	 		</p><br><br>
	 		<p  style="width: 100%;height: 30px;font-size: 18px;font-family: 楷体 ;margin: auto;color: " >
   				<b id="second" >8</b>秒后自动跳转。。 <a href="javascript:goBack();">确定</a> 
 			</p>
	</div>	
	
	<script type="text/javascript"> 
  		var sec = document.getElementById("second");
  		var i = 8;
  		var timer = setInterval(function(){
   		i--;
    	sec.innerHTML = i;
    	if(i==1){
      		window.location.href = "LoginServlet";
   	 		}
  		},1000);
    
 		function goBack(){ 
 		 	window.history.go(1);
		 } 
 	</script> 
</div>
<div id="bottom">
	<%@  include file="bottom.jsp"%>
</div>	

</body>
</html>