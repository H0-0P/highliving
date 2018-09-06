<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>high-living管理系统用户登录</title>
<link href="css/login.css" rel="stylesheet" rev="stylesheet"
	type="text/css" media="all" />

<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/jQuery1.7.js"></script>
<script type="text/javascript" src="js/jquery1.42.min.js"></script>
<script type="text/javascript" src="js/jquery.SuperSlide.js"></script>
<script type="text/javascript" src="js/Validform_v5.3.2_min.js"></script>
<script type="text/javascript">

/*$(document).ready(function(){
	var $tab_li = $('#tab ul li');
	$tab_li.hover(function(){
		$(this).addClass('selected').siblings().removeClass('selected');
		var index = $tab_li.index(this);
		$('div.tab_box > div').eq(index).show().siblings().hide();
	});	
});*/
</script>
<script type="text/javascript">
	/*$(function(){
		$("#sec_username_hide").focus(function(){
 			var username = $(this).val();
 			if(username=='输入教务号'){
 				$(this).val('');
 			}
		});
		$("#sec_username_hide").focusout(function(){
		 var username = $(this).val();
 		 if(username==''){
 			$(this).val('输入教务号');
 		 }
		});
	$("#sec_password_hide").focus(function(){
 		var username = $(this).val();
 		if(username=='输入密码'){
 			$(this).val('');
 		}
	});
	$("#sec_password_hide").focusout(function(){
 		var username = $(this).val();
 		if(username==''){
 			$(this).val('输入密码');
 		}
	});
	$("#sec_code_hide").focus(function(){
 		var username = $(this).val();
 			if(username=='输入验证码'){
 		$(this).val('');
 	}
	});
	$("#sec_code_hide").focusout(function(){
 		var username = $(this).val();
 		if(username==''){
 		$(this).val('输入验证码');
 }
	});
	$(".sec_login_error").Validform({
		tiptype:function(msg,o,cssctl){
		var objtip=$(".sec_error_box");
		cssctl(objtip,o.type);
		objtip.text(msg);
	},
	ajaxPost:true
});
});*/
</script>
<script type="text/javascript">
$(function(){
	$(".screenbg ul li").each(function(){
		$(this).css("opacity","0");
	});
	$(".screenbg ul li:first").css("opacity","1");
	var index = 0;
	var t;
	var li = $(".screenbg ul li");	
	var number = li.size();
	function change(index){
		li.css("visibility","visible");
		li.eq(index).siblings().animate({opacity:0},3000);
		li.eq(index).animate({opacity:1},3000);
	}
	function show(){
		index = index + 1;
		if(index<=number-1){
			change(index);
		}else{
			index = 0;
			change(index);
		}
	}
	t = setInterval(show,8000);
	//根据窗口宽度生成图片宽度
	var width = $(window).width();
	$(".screenbg ul img").css("width",width+"px");
});
</script>
<script type="text/javascript">
	//登录验证
	$(function(){
		//验证用户名
		var $username = $("input[name='loginName']");
		$username.blur(function(){
			var username = $username.val();
			if(username == null || username==""){
				$username.css("border-color", "red");
			}
		});
		//验证密码
		var $password = $("input[name='password']");
		$password.blur(function(){
			var password = $password .val();
			if(password == null || password==""){
				$password.css("border-color", "red");
			}
		});
		//验证 验证码
		var $checkCode = $("input[name='checkCode']");
		$checkCode.blur(function(){
			var checkCodeVal = $checkCode.val();
			if(checkCodeVal == null || checkCodeVal == ""){
				//flag3 = false;
				$checkCode.css("border-color", "red");
			} else{
				//判定输入是否正确
				$.ajax({
					url:"http://192.168.8.2:8080/highliving/checkCode",
					data:{"code":checkCodeVal},
					dataType:"json",
					success:function(result){
						if(result.status == 1){//验证成功
							//flag3 = true;
							$checkCode.css("border-color", "green");
						} else{//验证失败
							//flag3 = false;
							$checkCode.css("border-color", "red");
						}
					}
				});
			}
		});
		
	});
	function changeCode(){
		//得到验证码的标签
		var img = document.getElementById("verifyCode");
		img.src = "http://192.168.8.2:8080/highliving/getVerifycode?" + new Date();
	};
</script>

</head>

<body>
	<div id="tab">
		<!--  <ul class="tab_menu">
    <li>管理员登录</li>
  </ul>-->
		<div class="tab_box">

			<!-- 教务登录开始-->
			<!--  <div class="hide">
    <div class="sec_error_box"></div>-->
			<form action="http://192.168.8.2:8080/highliving/index" method="post" id="loginForm"
				class="sec_login_error">
				<div id="username">
					<label>账号：</label> <input type="text" id="sec_username_hide"
						name="loginName" placeholder="输入账号" nullmsg="用户账号不能为空！" datatype="s6-18"
						errormsg="教务号范围在6~18个字符之间！" sucmsg="教务号验证通过！" />
					<!--ajaxurl="demo/valid.jsp"-->
				</div>
				<div id="password">
					<label>密&nbsp;&nbsp;&nbsp;码：</label> <input type="password"
						id="sec_password_hide" name="password" placeholder="输入密码"
						nullmsg="密码不能为空！" datatype="*6-16" errormsg="密码范围在6~16位之间！"
						sucmsg="密码验证通过！" />
				</div>
				 <div id="code">
					<label>验证码：</label> <input type="text" id="sec_code_hide" name="checkCode"
						name="code" placeholder="输入验证码" nullmsg="验证码不能为空！" datatype="*4-4"
						errormsg="验证码有4位数！" sucmsg="验证码验证通过！" />
					<!--  <img src="css/captcha.jpg" title="点击更换" alt="验证码占位图" />-->
					<a onclick="changeCode()"><img id="verifyCode" src="http://192.168.8.2:8080/highliving/getVerifycode" alt="验证码" /></a>
				</div>
				<div id="login">
					<button type="submit" id="loginBtn">登录</button>
				</div>
			</form>
			<!--  </div>
     
  </div>-->
		</div>
		<div class="bottom">
			©2018 HighLiving <a
				href="http://192.168.8.2:8080/highlivingweb/Index.html"
				target="_blank">关于</a> <span>High-Living</span>
		</div>
		<div class="screenbg">
			<ul>
				<li><a href="javascript:;"><img src="css/0.jpg"></a></li>
				<li><a href="javascript:;"><img src="css/1.jpg"></a></li>
				<li><a href="javascript:;"><img src="css/2.jpg"></a></li>
			</ul>
		</div>
</body>
</html>
