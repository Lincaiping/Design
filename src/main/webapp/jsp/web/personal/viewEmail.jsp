<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/header.jsp"%>
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
            <li class="bg1"><a href="${ctx }/faWap/myFlow!index.action"><i class="house-icon"></i>首页</a></li>
            <li><img src="/images/personal/jt1.jpg" height="60" /> </li>
            <li class="bg2"><a href="${ctx}/faWap/personalCenter!account.action">我的账户</a> </li>
            <li><img src="/images/personal/jt2.jpg" height="60" /> </li>
            <li class="bg3"><a href="${ctx}/faWap/personalCenter!bandingPhone.action">绑定手机</a> </li>
            <li><img src="/images/personal/jt3.jpg" height="60" /> </li>
        </ul>
    </div>
    <!--导航 end-->  

    <div class="m-t-110"></div>

    <!--绑定手机 begin-->

    <div class="wrap100">
    	<div class="wrap80 ph1_zs">绑定手机后，可使用手机号登录 </div>
    </div>
    
    <div class="wrap100">
    	<div class="wrap90 mar20"><input name="serviceNum" id="serviceNum" class="input70" type="text" placeholder="手机号"></div>
    </div>
        
    <div class="down_button">
    	<a id="a_getMobileCode" href="javascript:getBandMobileCode('a_getMobileCode');" class="phone_back" >下&nbsp一&nbsp步</a>
       
    </div>
    <p class="ph1_wzbz">还想要绑定邮箱，链接地址：<a href="#">邮箱绑定</a></p>
    
</body>
</html>