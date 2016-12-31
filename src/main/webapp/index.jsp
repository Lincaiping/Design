<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>账号安全中心</title>
<!-- 移动设备支持 -->
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
<%@ include file="/header.jsp"%>
<link href="/css/index/reset.css" rel="stylesheet" type="text/css">
<link href="/css/index/mod40.css" rel="stylesheet" type="text/css">
<link href="/css/index/index.css" rel="stylesheet" type="text/css">
<script src="/js/jquery-1.11.0.min.js"></script>
<script>
	$(function() {
		$('.blankwhite').css('height', '0px');
	});
</script>
</head>
<body>
	<div id="wrap" class="clr">
		<div id="imageswzi">
			<script src="/js/index/swipe2.js" type="text/javascript"></script>
			<div id="displayone">
				<img src="/images/head01.jpg" alt=" " id="onebannerimg">
			</div>
			<script src="/js/index/index_01.js" type="text/javascript"></script>
		</div>
		<div class="cont-box clr">
			<ul class="contbg">
				<li class="icon01 li_back" id="li_02">
					<a href="/login/toRegister.do" onclick="tongji(650722,0);">
						<p>新用户注册</p> <img
						src="/images/index/icon01.png"
						style='visibility: hidden;'>
				</a>
				</li>
				<li class="icon02 li_back" id="li_03">
					<a href="login/toLogin.do" onclick="tongji(650723,0);">
						<p>账号登录</p> <img
						src="/images/index/icon02.png"
						style='visibility: hidden;'>
				</a>
				</li>
				<li class="icon03 li_back" id="li_04">
					<a href="index/interfaces.do" onclick="tongji(650724,0);">
						<p>安全接口</p> <img
						src="/images/index/icon03.png"
						style='visibility: hidden;'>
				</a>
				</li>
				<li class="icon04 li_back" id="li_05">
					<a href="index/advise.do" onclick="tongji(650725,0);">
						<p>提交建议</p> <img
						src="/images/index/icon04.png"
						style='visibility: hidden;'>
				</a>
				</li>
				<%--<div style="display: block;margin: 20px;"></div>--%>
				<li class="icon07 li_back" id="li_08">
					<a href="index/goManager.do" onclick="tongji(650728,0);">
						<p>后台管理</p> <img
						src="/images/index/icon07.png"
						style='visibility: hidden;'>
				</a>
				</li>
				<li class="icon08 li_back" id="li_09">
					<a href="index/safeKnow.do" onclick="tongji(650729,0);">
						<p>安全天地</p> <img
						src="/images/index/icon08.png"
						style='visibility: hidden;'>
				</a>
				</li>
			</ul>
		</div>
	</div>
	<a href="tel:18060476885">
		<div class="telphone">
			<img src="/images/index/tel.png">
		</div>
	</a>
	<script type="text/javascript" src="/js/index/index_02.js"></script>
	<a href="index/toUpload.do"> <footer>
			同城租赁提供服务 </footer>
	</a>
	<div class="blankwhite" style="height: 30px;"></div>
	<script src="/js/index/index_03.js"></script>
	<div id="div_fx_describe" style="display: none;"></div>
</body>
</html>


