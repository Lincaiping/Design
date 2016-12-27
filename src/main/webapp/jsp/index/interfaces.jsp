<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/header.jsp"%>
<script src="/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="/js/web/interfaces.js"></script>
<style type="text/css">
span {
	margin-bottom: 20px;
	margin-left: 15%;
	margin-right: 20%;
	display: block;
	font-size: 20px;
	color: black;
	text-indent: 2em;
}

h1 {
	color: black;
	margin-bottom: 20px;
	text-align: center;
}
</style>
<title>接口协议介绍！</title>
</head>
<body>
	<h1>接口协议</h1>
	<span>快捷安全登录，是一个向广大网站开放的接口。通过该接口，网站只要提供用户名，然后通过接口调用，后台判断是否合法，直接向网站发出登录通过的结果，省去密码发送的过程，从而达到
		保护用户密码安全的目的。对于不支持这种方式的网站，会采用直接发送用户名和密码的方式，但是会提醒用户，而且会加入一个安全位校对。 </span>
	<span>快捷安全注册，也是是一个向广大网站开放的接口。用户采用该方式时，只要输入相应的用户名，后台能自动生成安全性极好的密码；更重要的是，网站需要什么资料，比如身份证号码，手机号码和地址等等信息时，只要用户授权，直接向网站发送相应的信息。省去了身份证合法验证，手
		机号码验证等等繁杂的过程，极大的方便用户和网站。这两个开放性的接口，解决了用户密码不安全的问题。</span>
	<div id="buttonContainer">
		<a href="javascript:loginTest();" class="button big blue">快捷安全登录测试</a>
		<a href="javascript:registerTest();" class="button big green">快捷安全注册测试</a>
		<div id="register" style="display: none;">
		<input type="text" name="userName" id="userName" class="button medium gray"> 
		<input type="button" value="提交" onclick="submit()" class="button small blue">
		</div>
	</div>
</body>
<link rel="stylesheet" type="text/css" href="/css/button/page.css" />
<link rel="stylesheet" type="text/css" href="/css/button/buttons.css" />
</html>