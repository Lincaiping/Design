<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/header.jsp"%>
<link rel="stylesheet" href="/css/web/login/global.css">
<link rel="stylesheet" href="/css/web/login/success.css">
<title>欢迎新用户</title>
</head>
<body>
	<div class="success">
		<img src="/css/web/images/success.png" />
		<p>恭喜您注册成功！</p>
		<div class="s_msg">
			<div class="s_title">
				您的用户名：<span class="s_red">${userName }</span>
			</div>
			<div class="s_title">进行个人中心，开始家家乐之旅吧：</div>
			<span class="s_redlink">
			<a href="/login/toLogin.do" target="_blank">请先登录</a>
			</span>
		</div>
	</div>
	<div class="bottom">欢迎使用账户中心 <a href="#" style="color: #555555">系统登陆</a></div>
</body>
</html>