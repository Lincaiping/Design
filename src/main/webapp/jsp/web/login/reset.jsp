<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/header.jsp" %>
    <link rel="stylesheet" href="/css/web/login/global.css">
    <link rel="stylesheet" href="/css/web/login/register.css">
    <script src="/js/jquery-1.11.0.min.js"></script>
    <script type="text/javascript" src="/js/web/login/resetTel.js"></script>
    <title>忘记密码了</title>
</head>
<body>
<div id="layout">
    <span>密码重置</span>
    <form method="post">
        <ul>
            <p id="err_msg"></p>
            <li><i class="un"><img src="/css/web/images/user_name.png"></i>
                <input id="serviceNum" class="username" type="text" placeholder="请输入手机号码"/></li>
            <li><i class="yz"><img src="/css/web/images/msg.png"></i>
                <input class="yzm" id="code" type="text" placeholder="请输入手机验证码"/>
                <input type="button" id="send" value="获取验证码"/></li>
            <li><i class="pw"><img src="/css/web/images/pwd.png"></i>
                <input class="pwd" type="password" id="password" placeholder="请输入密码"/></li>
            <li><i class="pw2"><img src="/css/web/images/pwd.png"></i>
                <input class="pwd2" type="password" placeholder="请输入确认密码"/></li>
        </ul>
        <div class="reg_btn">
            <input type="button" class="submit" type="submit" onclick="submitTel()" value="确认重置">
            <a href="/login/toResetEmail.do">
                <div class="reg-login"><p>邮箱重置</p></div>
            </a>
        </div>
    </form>
</div>
<div class="bottom">欢迎使用账户中心 <a href="#" style="color: #555555">系统登陆</a></div>
</body>
</html>