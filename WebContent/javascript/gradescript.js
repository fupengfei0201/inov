/**
 * 
 */
	function check(){
		
		if(document.all.name.value==""){
			alert("请输入员工姓名!");
			document.myform.name.focus();
		}
		else if(document.all.dept.value==""){
			alert("请输入所属部门!");
			document.myform.dept.focus();
		}
		else if(document.all.date.value==""){
			alert("请输入考核期限!");
			document.myform.date.focus();
		}
		else if(document.all.jobs.value==""){
			alert("请输入岗位!");
			document.myform.jobs.focus();
		}
		else if(document.all.mag.value==""){
			alert("请输入部门经理!");
			document.myform.mag.focus();
		}
		else if(document.all.station.value==""){
			alert("请输入员工岗位职责描述!");
			document.myform.station.focus();
		}
		else if(document.all.tea.value==""){
			alert("请输入指导老师!");
			document.myform.tea.focus();
		}
		else if(document.all.grade.value==""){
			alert("请输入分数!");
			document.myform.grade.focus();
		}
		else if(document.all.comm.value==""){
			alert("请输入综合评与！!");
			document.myform.comm.focus();
		}
	}