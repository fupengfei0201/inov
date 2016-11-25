/**
 * 
 */
	function check(){
		if(check2()){
			alert("请输入分数!");
			document.all.Tgrade.focus();
		 }
		else{
			var a=document.myform;
			var b=document.myform2;
			if(session.getAttribute("x").equals("0")){
			a.action="EmpGradeServlet";
			a.submit();
			}
			else if(session.getAttribute("x").equals("1")){
				b.action="EmpgradeServletTwo";
				b.submit();
			}
		}
	}
	
	function check2(){
		var lh=document.getElementsByName("Tgrade");
		for(var i=0;i<lh.length;i++){
		if(document.getElementById("score"+i).value==""){
			return true;
			break;
		}
	}
	}