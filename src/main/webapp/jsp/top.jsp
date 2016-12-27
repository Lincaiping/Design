<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/css/style.css" rel="stylesheet" type="text/css" />
<script src="/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		//顶部导航切换
		$(".nav li a").click(function() {
			$(".nav li a.selected").removeClass("selected")
			$(this).addClass("selected");
		})
	})
</script>
</head>
<body style="background: url(/images/manage/topbg.gif) repeat-x;">

	<div class="topleft">
		<a href="main.html" target="_parent"><img
			src="/images/manage/logo.png" title="系统首页" /></a>
	</div>

	<ul class="nav">
		<li><a href="/jsp/index2.html" target="rightFrame"
			class="selected"><img src="/images/manage/icon01.png" title="工作台" />
			<h2>工作台</h2></a></li>
		<!-- <li><a href="/jsp/manage/computer.html" target="rightFrame"><img
				src="/images/manage/icon05.png" title="文件管理" />
			<h2>文件管理</h2></a></li> -->
		<li><a href="/jsp/manage/tab.html" target="rightFrame"><img
				src="/images/manage/icon06.png" title="系统设置" />
			<h2>系统设置</h2></a></li>
	</ul>

	<div class="topright">
		<ul>
			<li><span><img src="/images/manage/help.png" title="帮助"
					class="helpimg" /></span><a href="#">帮助</a></li>
			<li><a href="#">关于</a></li>
			<li><a href="/index/loginOut_manager.do" target="_parent">退出</a></li>
		</ul>

		<div class="user">
			<span>${managerName}</span>
		</div>
	</div>
</body>
</html>