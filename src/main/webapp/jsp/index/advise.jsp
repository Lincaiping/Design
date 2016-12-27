<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/header.jsp"%>
<link rel="stylesheet" href="/css/web/personal/box.css">
<link rel="stylesheet" href="/css/web/personal/font-awesome.css">
<link rel="stylesheet" href="/css/web/personal/loadingFloat.css">
<link rel="stylesheet" href="/css/web/personal/advise.css">
<link rel="stylesheet" href="/css/web/personal/public.css">
<script src="/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="/jsp/index/advise.js"></script>
<title>建议提交！</title>
</head>
<style type="text/css">
	.hide{
		display:none;
	}
</style>


<body class="body_color">
<!--状态栏 begin-->
<div class="wrap100 wap_header">

</div>
<!--状态栏 over--> 
    <!--导航 begin-->
    <div class="wrap100 topNav">
        <ul>
            <li class="bg1"><a href="http://127.0.0.1:8080/"><i class="house-icon"></i>首页</a></li>
            <li><img src="/images/personal/jt1.jpg" height="60" /> </li>
            <li class="bg2"><a href="${ctx}/faWap/personalCenter!account.action">我的账户</a> </li>
            <li><img src="/images/personal/jt2.jpg" height="60" /> </li>
            <li class="bg3"><a href="javascript:problem()">意见反馈</a> </li>
            <li><img src="/images/personal/jt3.jpg" height="60" /> </li>
        </ul>
    </div>
    <!--导航 end-->
<div class="m-t-110"></div>
<div class="mar10"></div>

<div class="waiceng">
	<textarea id="view" class="textarea" rows="5" name="content" placeholder="请填写您在使用过程中遇到的问题和建议，感谢您的支持，谢谢。" ></textarea>
	账&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp户:&nbsp&nbsp&nbsp&nbsp${userName }<br/>
	联系姓名：<input id="realName" name="userName" class="input" value="${realName }" type="text" /><br/>
	联系电话：<input id="serviceNum" name="tel" class="input" value="${serviceNum }" type="text" /><br/>
	邮&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp箱：<input id="email" name="eamil" class="input" value="${email }" type="text" /><br/>
	<button id="submit" class="button" type="submit" onclick="submit()">提&nbsp&nbsp&nbsp&nbsp交</button>
</div>

<div class="delf-wrap" id="div_mod" style="display: none;">
    <div action="" class="ui-form" style="text-align: center;font-size:23px;color:#767676;">
		<img src="/images/personal/sucess.png" width="70" style="margin-top: 20px;"><br />
		<div style="padding: 10px;">已成功提交，您的建议将是我们努力<br />的方向！谢谢</div>
        <div class="btn-wrap">
            <button id="submit" class="button" type="submit" onclick="confirm()" style="width: 90%;margin-bottom: 20px;">确&nbsp&nbsp&nbsp&nbsp认</button>
            <br/>
        </div>
    </div>
</div> 

<!--我的账户 over--> 
</body>
</html>
