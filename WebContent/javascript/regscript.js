/**
 * 
 */
function checkname(name){
		var str=name;
		var Expression=/^[\u4e00-\u9fa5]{2,5}$/;//真实姓名由汉字组成
		var objExp= new RegExp(Expression);//创建正则表达式对象
		if(objExp.test(str)==true){
			return true;
		}
		return false;	
	}
	/*function checkuname(uname){
		var str=uname;
		var Expression=/^(\w){4,20}$/;//用户名由4~20位字母。数字、下划线组成
		var objExp= new RegExp(Expression);
		if(objExp.test(str)==true){
			return true;
		}
		return false;
	}*/
	function checkpwd(pwd){  
		var str=pwd;
		var Expression=/^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){4,19}$/;//只能输入5-20个以字母开头、可带数字、“_”、“.”的字串
		var objExp= new RegExp(Expression);
		if(objExp.test(str)==true){
			return true;
		}
		return false;
	}
	
	function check(){
		if(document.all.name.value==""){
			alert("请输入真实姓名!");
			document.myform.name.focus();
			return;
		}
		else if(!checkname(document.all.name.value)){
			alert("您输入的姓名不合法，请重新输入！");
			document.myform.name.focus();
			return;
		}
		/*else if(document.all.uname.value==""){
			alert("请输入用户名！");
			document.myform.uname.focus();
		}
		else if(!checkuname(document.all.uname.value)){
			alert("您输入的用户名不合法，请重新输入！");
			document.myform.uname.focus();
		}*/
		else if(document.all.pwd.value==""){
			alert("请输入密码!");
			document.myform.pwd.focus();
			return;
		}
		else if(!checkpwd(document.all.pwd.value)){
			alert("您输入的密码不合法，请重新输入！");
			document.myform.pwd.focus();
			return;
		}
		else if(document.all.pwd1.value==""){
			alert("请输入确认密码!");
			document.myform.pwd1.focus();
			return;
		}
		else if(document.all.pwd1.value!=document.all.pwd.value){
			alert("您两次输入的密码不一致，请重新输入!");
			document.myform.pwd.focus();
			return;
		}
		else if(document.all.dept.value==""){
			alert("请输入部门!");
			document.myform.dept.focus();
			return;
		}
		else if(document.myform.edu.value==""){
			alert("请输入学历!");
			document.myform.edu.focus();
			return;
		}	
	}