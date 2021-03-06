<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/header.jsp" %>
    <link rel="stylesheet" href="/css/web/login/global.css">
    <link rel="stylesheet" href="/css/web/login/login.css">
    <title>账号登录</title>
</head>
<body>
<div class="login">
    <div class="login-return"><a href="http://127.0.0.1:8080/" target="_parent" style="font-size: 23px;
             color: white;">返回首页</a></div>
    <div class="login-title"><p>家家乐登录</p>
        <i></i>
    </div>
    <form id="loginForm">
        <div class="login-bar">
            <ul>
                <li><img src="/css/web/images/login_user.png">
                    <input type="text" class="text" id="userName" name="userName" placeholder="请输入用户名"
                           required="required"/>
                </li>
                <li><img src="/css/web/images/login_pwd.png">
                    <input type="password" class="psd" id="password" name="password" placeholder="请输入密码"
                           required="required"/>
                </li>
            </ul>
        </div>
        <div class="login-btn">
            <input class="submit" type="button" value="登录" onclick="login()"/>
            <a href="/login/toRegister.do">
                <div class="login-reg"><p>莫有账号，先注册</p></div>
            </a>
            <a href="/login/toReset.do">
                <div class="login-reg"><p>密码找回通道</p></div>
            </a>
        </div>
    </form>
</div>
<div style="text-align:center;">
    <div class="bottom">欢迎使用家家乐 <a href="#" style="color: #555555">系统登录</a></div>
</div>
</body>
<script src="/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="/js/web/login/login.js"></script>
</html>