<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Insert title here</title>
<script type="text/javascript"> 
  window.onload = function () { 
   flag = 0; 
   obj1 = document.getElementById("slider"); 
   obj2 = document.getElementsByTagName("li"); 
   obj2[0].style.backgroundColor = "#666666";
   //默认被选中颜色 
   time = setInterval("turn();", 5000); 
   obj1.onmouseover = function () { 
    clearInterval(time); 
   } 
   obj1.onmouseout = function () { 
    time = setInterval("turn();", 6000); 
   } 
  
   for (var num = 0; num < obj2.length; num++) { 
    obj2[num].onmouseover = function () { 
     turn(this.innerHTML); 
     clearInterval(time); 
    } 
    obj2[num].onmouseout = function () { 
     time = setInterval("turn();", 6000); 
    } 
   } 
   //延迟加载图片，演示的时候，使用本地图片
   //上线后请改为二级域名提供的图片地址 
   document.getElementById("second").src = "pic/a2.png";
   //使用图片宽800，高300
   document.getElementById("third").src = "pic/a4.png"; 
   document.getElementById("four").src = "pic/a5.png"; 
  } 
  function turn(value) { 
   if (value != null) { 
    flag = value - 2; 
   } 
   if (flag < obj2.length - 1) 
    flag++; 
   else
    flag = 0; 
   obj1.style.top = flag * (-300) + "px"; 
   for (var j = 0; j < obj2.length; j++) { 
    obj2[j].style.backgroundColor = "#ffffff"; 
   } 
   obj2[flag].style.backgroundColor = "#666666"; 
  } 
 </script> 
 <style type="text/css">
 .more{
 width:100%;
 height:100%;
 background: none;
 border: none;
 }

 </style>
</head>
<body>
<div id="carousel">
<div id="wrap"> 
  <div id="slider"> 
   <a target="_blank" href="#"><img src="pic/a1.jpg" /></a> 
   <a target="_blank" href="#"><img id="second" /></a> 
   <a target="_blank" href="#"><img id="third" /></a> 
   <a target="_blank" href="#"><img id="four" /></a> 
  </div> 
  <ul> 
   <li>1</li> 
   <li>2</li> 
   <li>3</li> 
   <li>4</li> 
  </ul> 
 </div>
</div>
<div id="content">
<div id="msgleft">
<div id="line"></div>
<div id="bg">
<div style="padding-left: 10%;font-size: 20px;padding-top: 12px;float: left;">公司介绍</div>
</div>
<div id="componymsg">
<table width="100%" height="100%" border="0.5px dashed" cellpadding="0px" cellspacing="0px" bordercolor="lightgray"  rules="rows">
<tr>
	<td>
	<div style="float: left;">公司简介</div>
	<div style="padding-left: 60%;float: left;"><a href="cmpintroduction/cmpmsg.jsp" target="_blank">更多&gt;&gt;</a>
	</div></td>
</tr>
<tr>
	<td>
	<div style="float: left;">企业文化</div>
	<div style="padding-left: 60%;float: left;"><a href="cmpintroduction/cmpcultrue.jsp" target="_blank">更多&gt;&gt;</a>
	</div></td>
</tr>
<tr>
	<td>
	<div style="float: left;">产品经营</div>
	<div style="padding-left: 60%;float: left;"><a href="cmpintroduction/cmpproduct.jsp" target="_blank">更多&gt;&gt;</a>
	</div>
	</td>
</tr>
<tr>
	<td>
	<div style="float: left;">人才培养</div>
	<div style="padding-left: 60%;float: left;"><a href="cmpintroduction/cmptcultivate.jsp" target="_blank">更多&gt;&gt;</a>
	</div>
	</td>
</tr>
</table>
</div>
</div>
<div id="msgright">
<div id="line"></div>
<div id="bg">
<div style="padding-left: 10%;font-size: 20px;padding-top: 12px;float: left;">信息公告</div>
<!-- <form action="CheckServlet6" method="post"><div style="padding-left: 45%;padding-top: 5%;float: left;">
<input type="submit" value="更多&gt;&gt;" style="color:#1B539D" class="more" ></div></form> -->
</div>
<div id="componymsg">
<table width="100%" height="100%" border="0.5px dashed" cellpadding="0px" cellspacing="0px" bordercolor="lightgray"  rules="rows">
<tr>
	<td><div style="float: left;"><a href="information/news.jsp" target="_blank">艰苦奋斗 勇争第一一诺威股..</a></div>
	<div style="float: right;padding-right: 5%">2014-10-24</div></td>
</tr>
<tr>
	<td>&nbsp;</td>
</tr>
<tr>
	<td>&nbsp;</td>
</tr>
<tr>
	<td>&nbsp;</td>
</tr>
</table>
</div>
</div>
</div>
</body>
</html>