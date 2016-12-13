<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Insert title here</title>
<script type="text/javascript" src="javascript/regscript.js"></script>
 <script src="javascript/jquery-1.8.3.js"></script>    
<script type="text/javascript">
function check(){
	if(document.all.name.value==""){
		alert("请输入真实姓名!");
		document.form.name.focus();
		return;
	}
	else{
		var a=document.form;
		a.action="FindPwdServlet";
		a.submit();
	}
}
		/**$(function(){  
		    $("#getCode").removeAttr("disabled");  
		    //发送验证码  
		    $("#getCode").click(function(){   
		        $.ajax({  
		            url:"MessageServlet",  
		            data:{  
		                "phone":$("#phone").val()  
		            },  
		            type:"post",  
		            async:false,  
		            dataType:"text",  
		            success : function(data) {  
		                if(data=='true'){  
		                    alert("验证码发送成功，收到后请输入验证码");  
		                    time(this);  
		                } else {  
		                    alert("验证码发送失败");  
		                }  
		            },  
		            error : function() {  
		                alert("error");  
		            }  
		        });  
		    });  
		    //验证  
		    $("#next").click(function(){      
		        $.ajax({  
		            url:"CodeServlet",  
		            data:{  
		                "code":$("#code").val()  
		            },  
		            type:"post",  
		            async:false,  
		            dataType:"text",  
		            success : function(data) {  
		                if(data=='true'){  
		                    alert("恭喜您，验证成功");  
		                } else {  
		                    alert("验证失败");  
		                }  
		            },  
		            error : function() {  
		                alert("error");  
		            }  
		        });  
		    });  
		})  
		  
		//验证码倒计时  
		var wait = 60;  
		function time(obj) {  
		    if(wait==0) {  
		        $("#getCode").removeAttr("disabled");  
		        $("#getCode").val("免费获取验证码");  
		        wait = 60;  
		    }else {  
		        $("#getCode").attr("disabled","true");  
		        $("#getCode").val(wait+"秒后重试");  
		        wait--;  
		        setTimeout(function() {     //倒计时方法  
		            time(obj);  
		        },1000);    //间隔为1s  
		    }  
		} */ 

</script>
</head>
<body>
<div>
<%@ include file="head.jsp"%>
<div id="title"></div>
</div>
<div id="center" >
	<div id="bg" style="margin-top:2%; height: 6%;">
	<div id="line" style="background: gray"></div>
	<div>
	<div style="width:97%;height:30px;padding-left: 3%;font-size: 20px;padding-top: 12px;float: left; background: #F1F1F1">找回密码</div>
	</div>
	</div>
	<form action="" name="form"  method="post"  >
	<div style="width:100%;height: 85%">
	<div style="width: 80%;margin: auto;margin-top:30px;">
	<span  style="width:33.3%;margin-left: 10%">1.验证员工信息</span>
	<span style="width: 33.3%;text-align: center;margin-left: 20%;color: gray">2.输入新密码</span>
	<span style="width:33.4%;text-align: center;margin-left: 20%;color: gray">3.修改成功</span>
	</div>
	<div style="width: 80%;height: 15px;margin: auto;margin-top:10px;background: lightgray;border-radius:4px;">
	<div style="width: 33.3%;height: 15px;margin-top:10px;background: #1B539D;border-radius:4px"></div></div>
	<div style="width: 50%;height: auto;margin: auto;margin-top: 6%;margin-left: 10%">
	<span>姓&nbsp;&nbsp;&nbsp;&nbsp;名：&nbsp;&nbsp;</span><input type="text" name="name" id="uname" class="log" onblur="return check()"><br><br>
	<!-- <span>手机号码：&nbsp;&nbsp;</span><input type="text" name="phone" id="phone" class="log" onblur="return check()"><br><br>
	<span>手机验证码：</span><input type="text" name="code" id="code" >&nbsp;&nbsp;<input type="button" name="btncode" id="getCode" value="免费获取验证码" /><br><br> -->
	<input type="button" id="next"  value="下一步" class="butt" onclick="return check()" style="background:  #1B539D;border: none;color: white; border-radius:4px;margin-left: 10%;margin-top: 10px" />

	</div>
	</div>
	</form>
	</div>
<div id="bottom">
	<%@  include file="bottom.jsp"%>
</div>	
${requestScope.msg}	
</body>
</html>