<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/header.jsp" %>
    <link rel="stylesheet" href="/css/web/personal/box.css">
    <link rel="stylesheet" href="/css/web/personal/loadingFloat.css">
    <link rel="stylesheet" href="/css/web/personal/public.css">
    <link rel="stylesheet" href="/css/web/personal/font-awesome.css">
    <link rel="stylesheet" href="/css/web/personal/personal_center.css">
    <link rel="stylesheet" href="/css/web/personal/band.css">
    <title>联系方式详情</title>
</head>
<body class="body_color">
<!--状态栏 begin-->
<div class="wrap100 wap_header"></div>
<!--状态栏 over-->

<!--导航 begin-->
<div class="wrap100 topNav">
    <ul>
        <li class="bg1"><a href="${ctx }/faWap/myFlow!index.action"><i class="house-icon"></i>首页</a>
        </li>
        <li><img src="/images/personal/jt1.jpg" height="60"/></li>
        <li class="bg2"><a href="${ctx}/faWap/personalCenter!account.action">我的账户</a></li>
        <li><img src="/images/personal/jt2.jpg" height="60"/></li>
        <li class="bg3"><a href="${ctx}/faWap/personalCenter!bandingPhone.action">绑定邮箱</a></li>
        <li><img src="/images/personal/jt3.jpg" height="60"/></li>
    </ul>
</div>
<!--导航 end-->

<div class="m-t-110"></div>

<!--绑定手机 begin-->

<div class="wrap100">
    <div class="wrap80 ph1_zs">绑定邮箱后，可使用邮箱登录</div>
</div>
<div class="wrap100">
    <div class="wrap90 mar20"><input name="email" id="email" class="input70" type="text"
                                     placeholder="手机号"></div>
</div>

<div class="down_button">
    <a id="a_getMobileCode" href="javascript:javascript:getCode();" class="phone_back">获取验证码</a>
</div>
<div class="wrap100">
    <div class="wrap90 mar20"><input name="code" id="code" class="input70" type="text"
                                     placeholder="验证码"></div>
</div>
<div class="down_button">
    <a id="a_getEmailCode" href="javascript:submitEmail();" class="phone_back">确定</a>
    <p class="ph1_wzbz">还想要绑定手机，链接地址：<a href="#">手机绑定</a></p>
</div>

</body>
<script src="/js/jquery-1.11.0.min.js"></script>
<script src="/js/web/personal/contantEmail.js"></script>
</html>