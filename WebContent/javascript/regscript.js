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
	