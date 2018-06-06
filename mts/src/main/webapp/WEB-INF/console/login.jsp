<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>异清轩博客管理系统</title>
<link rel="stylesheet" type="text/css" href="/res/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/res/css/login.css">
<link rel="stylesheet" type="text/css" href="/res/css/style.css">
<link rel="apple-touch-icon-precomposed" href="/res/images/icon/icon.png">
<link rel="shortcut icon" href="/res/images/icon/favicon.ico">
<script src="/res/js/jquery-2.1.4.min.js"></script>
</head>
<script>
$(document).ready(function(){
$('#signinSubmit').click(function(){
	if($('#userName').val() === ''){
		$('#signinSubmit').text('登陆');
	}else if($('#userPwd').val() === ''){
		$('#signinSubmit').text('登陆');
	}else{
		$('#signinSubmit').text('请稍后...');
	}
});

});
</script>
<body class="user-select">
<div class="container">
  <div class="siteIcon"><img src="/res/images/icon/icon.png" alt="" data-toggle="tooltip" data-placement="top" title="欢迎使用异清轩博客管理系统" draggable="false" /></div>
  <form action="/adminlogin" method="post" autocomplete="off" class="form-signin">
    <h2 class="form-signin-heading">管理员登录</h2>
    <label for="userName" class="sr-only">用户名</label>
    <input type="text" id="userName" name="username" class="form-control" placeholder="请输入用户名" required autofocus autocomplete="off" maxlength="10">
    <label for="userPwd" class="sr-only">密码</label>
    <input type="password" id="userPwd" name="userpwd" class="form-control" placeholder="请输入密码" required autocomplete="off" maxlength="18">
    <button class="btn btn-lg btn-primary btn-block" type="submit" id="signinSubmit">${msg }</button>
  </form>
 
</div> 

</body>
</html>