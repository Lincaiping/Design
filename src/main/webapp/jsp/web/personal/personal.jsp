<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/header.jsp"%>
<link rel="stylesheet" href="/css/web/personal/box.css">
<link rel="stylesheet" href="/css/web/personal/font-awesome.css">
<link rel="stylesheet" href="/css/web/personal/loadingFloat.css">
<link rel="stylesheet" href="/css/web/personal/personal_center.css">
<link rel="stylesheet" href="/css/web/personal/public.css">
<title>个人主页！</title>
</head>
<body class="body_color">
	<!--状态栏 begin-->
	<div class="wrap100 wap_header"></div>
	<!--状态栏 over-->

	<!--导航 begin-->
	<div class="wrap100 topNav">
		<ul>
			<li class="bg1"><a href="/login/toLogin.do"><i
					class="house-icon"></i>首页</a></li>
			<li><img src="/images/personal/jt1.jpg" height="60" /></li>
			<li class="bg2"><a
				href="#">我的账户</a></li>
			<li><img src="/images/personal/jt2_2.png" height="60" /></li>
		</ul>
	</div>
	<!--导航 end-->

	<div class="m-t-110"></div>

	<!--我的账户 begin-->

	<div class="wrap100 mar10 fl mus_skt">
		<div class="wrap100 fl">
			<div style="text-align: center;">
				<p style="font-size: 28px; margin-top: 0px; color: #ffffff;">个人中心</p>
			</div>

			<div class="mus_tou"
				onclick="window.location.href='/personal/uploadImg.do'"
				style="margin-left: 100px; width: 90px; float: left;">
				<img class="ger_tou" src="${image }"
					style="border: 0px; background: none; width: 116px; height: 120px; margin-bottom: 17px;">
			</div>
			<br /><br /><br /><br /><br /><br /><br /><br />
			<div>
				<a href="javascript:showFlowDetails()"
					style="cursor: pointer; color: #ffffff; font-size: 20px; text-decoration: underline; float: right; margin-right: 40px;">查看快捷登录记录</a>
			</div>
		</div>
	</div>

	<div class="wrap100 fl mar30">
		<div class="mus_cai">
			<ul>
				<li><a
					href="/personal/codeManage.do">
						<img src="/images/personal/mus_cai_icon01.png"> <span
						class="fl">密码管理</span> <i></i>
				</a></li>
				<li><a href="/personal/realName.do">
						<img src="/images/personal/mus_cai_icon03.png"> <span
						class="fl">实名认证</span> <i></i> 
						<c:if test='${!empty idNum}'>
							<span class="fr">已认证</span>
						</c:if> 
						<c:if test='${empty idNum}'>
							<span class="fr">未认证</span>
						</c:if> 
				</a></li><li><a href="/personal/realName.do">
						<img src="/images/personal/mus_cai_icon03.png"> <span
						class="fl">实名认证</span> <i></i> 
						<c:if test='${!empty idNum}'>
							<span class="fr">已认证</span>
						</c:if> 
						<c:if test='${empty idNum}'>
							<span class="fr">未认证</span>
						</c:if> 
				</a></li>
				
				<li><a href="/personal/viewPhone.do">
						<img src="/images/personal/mus_cai_icon04.png"> 
						<span class="fl">手机绑定</span> <i></i>
						 <c:if test='${!empty tel}'>
							<span class="fr">${tel }</span>
						</c:if> 
						 <c:if test='${empty tel}'>
							<span class="fr">未绑定手机</span>
						</c:if>
				</a></li>
				<li><a href="/personal/viewEmail.do">
						<img src="/images/personal/mus_cai_icon05.png"> <span
						class="fl">邮箱绑定</span> <i></i> 
						<c:if test='${!empty email}'>
							<span class="fr">${email}</span>
						</c:if> 
						<c:if test='${empty email}'>
							<span class="fr">未绑定邮箱</span>
						</c:if>
				</a></li>
				<li><a href="/login/toReset.do">
						<img src="/images/personal//mus_cai_icon06.png"> <span
						class="fl">登录密码管理</span> <i></i>
				</a></li>
				<li><a href="/index/advise.do">
						<img src="/images/personal/mus_cai_icon08.png"> <span
						class="fl">意见反馈</span> <i></i>
				</a></li>
				<li><a href="/personal/deleteAccount.do"> <img
						src="/images/personal/mus_cai_icon09.png"> <span class="fl">删除账号</span>
						<i></i>
				</a></li>
			</ul>
			<div class="clear"></div>
		</div>
	</div>

	<div class="down_button">
		<button onclick="window.location.href='/login/userOut.do'">退出登录</button>
	</div>
</body>
</html>