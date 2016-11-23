/**
 * 
 */
	function check(){
		if(document.all.name.value==""){
			alert("请输入员工姓名!");
			a.action="empgrade.jsp";
			document.myform.name.focus();
		}
		else if(document.all.dept.value==""){
			alert("请输入所属部门!");
			a.action="empgrade.jsp";
			document.myform.dept.focus();
		}
		else if(document.all.grade.value==""){
			alert("请输入分数!");
			a.action="empgrade.jsp";
			document.myform.grade.focus();
		}
		else{
			alert("提交成功！");
			var a=document.myform;
			a.action="EmpGradeServlet";
			a.submit();
		}
	}