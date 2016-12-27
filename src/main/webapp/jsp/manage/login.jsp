<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<title>登录</title>
<%@ include file="/header.jsp"%>
<link rel="stylesheet" href="/css/web/personal/box.css">
<link rel="stylesheet" href="/css/web/personal/font-awesome.css">
<link rel="stylesheet" href="/css/web/personal/loadingFloat.css">
<link rel="stylesheet" href="/css/web/personal/public.css">
<link rel="stylesheet" href="/css/web/personal/login.css">
</head>

<body class="body_color">
	<!--状态栏 begin-->
	<div class="wrap100 wap_header"></div>
	<!--状态栏 over-->
	<div class="p-t-120"></div>

	<!--登录头部 begin-->
	<div class="ui-header">
		<a href="http://127.0.0.1:8080/" class="return fn-left">
			<i class="icon icon-ret"></i> </a> <span class="title">
			登&nbsp;&nbsp;录 </span>
	</div>
	<!--登录头部 end-->


	<div class="cont-wrap">
		<form action="/managers/login.do" class="ui-form-login" id="faLogin"
			method="post">
			<div class="form-item" style="margin-bottom: 50px;">
				<input id="loginUserName" name="loginName" type="text"
					placeholder="账户" class="input70 inputbg input-per" />
			</div>
			<div class="form-item">
				<input id="pwd" value="" name="password" placeholder="密码" type="password"
					class="input70 inputbg input-key1" />
			</div>

			<div class="btn-wrap" style="margin-top:30px;">
				<input type="submit" id="btnLogin" class="btn btn-orange"
					value="马上登录">
			</div>
			<p class="msgt" style="text-align: right;">

				<a href="javascript:goReset();">忘记密码？</a>
			</p>
		</form>
	</div>
</body>
</html>