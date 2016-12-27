<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/header.jsp"%>
<link rel="stylesheet" href="/css/web/login/global.css">
<link rel="stylesheet" href="/css/web/login/login.css">
<script type="text/javascript" src="/js/web/login/login.js"></script>
<title>账号登录</title>
</head>
<body>
<body>
	<div class="login">
            <div class="login-title"><p>账号安全中心登录</p>
                <i></i>
            </div>
            <form method="post" action="/login/login.do">
            <div class="login-bar">
                <ul>
                    <li><img src="/css/web/images/login_user.png"><input type="text" class="text" name="userName" placeholder="请输入用户名" required="required"/></li>
                    <li><img src="/css/web/images/login_pwd.png"><input type="password" class="psd"  name="password" placeholder="请输入密码" /></li>
                </ul>
            </div>
            <div class="login-btn">
                <button class="submit" type="submit">登陆</button>
                <a href="/login/toRegister.do"><div class="login-reg"><p>莫有账号，先注册</p></div></a>
                <a href="/login/toReset.do"><div class="login-reg"><p>密码找回通道</p></div></a>
            </div>
            </form>
        </div>
		<div style="text-align:center;">
<div class="bottom">欢迎使用账户中心 <a href="#" style="color: #555555">系统登陆</a></div>
</div>
</body>
</html>