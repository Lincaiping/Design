<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/header.jsp" %>
    <link rel="stylesheet" href="/css/web/login/global.css">
    <link rel="stylesheet" href="/css/web/login/register.css">
    <script src="/js/jquery-1.11.0.min.js"></script>
    <script type="text/javascript" src="/js/web/login/register.js"></script>
    <title>账号注册</title>
</head>
<body>
<div id="layout">
    <span>注册账号安全管家</span>
    <form method="post" action="/login/register.do">
        <ul>
            <p id="err_msg"></p>
            <li><i class="un"><img src="/css/web/images/user_name.png"></i>
                <input class="username" name="userName" id="userName" type="text"
                       placeholder="请输入用户名"/></li>
            <li><i class="un"><img src="/css/web/images/user_name.png"></i>
                <input class="username" name="tel" id="serviceNum" type="number"
                       placeholder="请输入手机号"/></li>
            <li><i class="yz"><img src="/css/web/images/msg.png"></i>
                <input class="yzm" type="number" name="code" placeholder="请输入手机验证码"/>
                <input type="button" id="send" value="获取验证码"/></li>
            <li><i class="pw"><img src="/css/web/images/pwd.png"></i>
                <input class="pwd" type="password" name="password" placeholder="请输入密码"/></li>
            <li><i class="pw2"><img src="/css/web/images/pwd.png"></i><input class="pwd2"
                                                                             type="password"
                                                                             placeholder="请输入确认密码"/>
            </li>
            <div class="queren"><input class="fx" type="checkbox" checked="checked"/>
                <p>我已阅读并同意《用户协议》</p></div>
        </ul>
        <div class="reg_btn">
            <button class="submit" type="submit">注册</button>
            <a href="/login/toLogin.do">
                <div class="reg-login"><p>已有帐号，立即登陆</p></div>
            </a>
        </div>
    </form>
</div>
<div class="bottom">欢迎使用账户中心 <a href="#" style="color: #555555">系统登陆</a></div>
</body>
</html>