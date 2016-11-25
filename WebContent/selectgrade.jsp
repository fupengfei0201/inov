<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page import="java.util.*,inov.fpf.model.vo.HRGrade" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Insert title here</title>
<script type="text/javascript">  
    function show(){  
         var y = document.getElementByIdx_x_x("years");  
         var m = document.getElementByIdx_x_x("months");  
         var d = new Date();  
        // alert(d.getFullYear());  
        // alert(d.getMonth());  
        $("#years").attr("value", d.getFullYear());  
        $("#months").attr("value", d.getMonth() + 1);  
    }
    
    function check(){
    	a=document.myform;
    	a.action="HRMServlet";
		a.submit();
    	
    }
  </script>  
</head>
<body>
<div id="right">
<form action="HRMServlet" method="post" name="myform">
<div style="width: 80%;height:90%;margin: auto;margin-top: 20px">
<table style="width:100%;height:100%;text-align: center" border="1" cellpadding="0" cellspacing="0">
<tr>
<td colspan="12" height="30px">一诺威聚氨酯员工考评结果查询</td>
</tr>
<tr>
<td colspan="5"  height="30px">选择日期：</td>
<td colspan="5" >
${requestScope.x}
<select id="years" name="years" style="width: 35%;text-align: center">  
           <c:forEach var="year" begin="2000" end="2032" step="1" >  
            <option value="${year}" selected="2016" >${year}</option>  
           </c:forEach>    
          </select> 
          <select id="months" name="months" style="width: 35%;text-align: center">  
           <c:forEach var="month" begin="1" end="12" step="1" >  
            <option value="${month}">${month}</option>  
           </c:forEach>  
          </select> 
         
</td>
<td colspan="2"><input type="button" value="查询" onclick="return check()"></td>
</tr>
</table>
<table style="width:100%;height:100%;text-align: center;margin-top: 20px" border="1" cellpadding="0" cellspacing="0">
<tr style="height: 30px">
<td height="20px" width="40px">序号</td>
<td width="70px">姓名</td>
<td width="70px">部门负责人</td>
<td width="40px">得分</td>
<td width="70px">指导老师（师傅）</td>
<td width="40px">得分</td>
<td>员工互评得分1</td>
<td>员工互评得分2</td>
<td>员工互评得分3</td>
<td>员工互评平均得分</td>
<td width="40px">总分</td>
<td>部门负责人评语</td>
</tr>

<%
if(!request.getAttribute("list").equals("0")){
List<HRGrade>list=(ArrayList)request.getAttribute("list");
for(int i=0;i<list.size();i++){%>
	<tr>
	<td><%=list.get(i).getCod() %></td>
	<td><%=list.get(i).getName() %></td>
	<td><%=list.get(i).getDeptname() %></td>
	<td><%=list.get(i).getDeptgrade() %></td>
	<td><%=list.get(i).getTeachername() %></td>
	<td><%=list.get(i).getTeachergrade() %></td>
	<td><%=list.get(i).getOnegrade() %></td>
	<td><%=list.get(i).getTwograde() %></td>
	<td><%=list.get(i).getThreegrade() %></td>
	<td><%=list.get(i).getEmpavg() %></td>
	<td><%=list.get(i).getSum() %></td>
	<td><%=list.get(i).getComment()%></td>
	
	</tr>
<% }}
%>
</table>
</div>
</form>
</div>
</body>
</html>