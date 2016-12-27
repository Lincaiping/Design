<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="/css/style.css" rel="stylesheet" type="text/css" />
<%@ include file="/header.jsp"%>
<script src="/js/jquery-1.11.0.min.js"></script>

<script language="javascript">
	$(function(){
    $('.error').css({'position':'absolute','left':($(window).width()-490)/2});
	$(window).resize(function(){  
    $('.error').css({'position':'absolute','left':($(window).width()-490)/2});
    })  
});  
</script> 


</head>


<body style="background:#edf6fa;">

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">400错误提示</a></li>
    </ul>
    </div>
    
    <div class="error">
    
    <h2>为了保证你的账号安全！</h2>
    <p>系统设置错误次数限制，请半小时后尝试!</p>
    <div class="reindex"><a href="main.html" target="_parent">返回首页</a></div>
    
    </div>


</body>

</html>