<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/css/style.css" rel="stylesheet" type="text/css" />
<script src="/js/jquery-1.11.0.min.js"></script>

</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a >首页</a></li>
    </ul>
    </div>
    
    <div class="mainindex">
    
    
    <div class="welinfo">
    <span><img src="/images/manage/sun.png" alt="天气" /></span>
    <b>${managerName}，你好，欢迎使用后台管理系统</b>
    <a href="#">帐号设置</a>
    </div>
    
    <div class="welinfo">
    <span><img src="/images/manage/time.png" alt="时间" /></span>
    <i>您上次登录的时间：${lastPassTime}</i> （不是您登录的？<a href="/managers/disableThis.do">请点这里</a>）
    </div>
    
    <div class="xline"></div>
    
    <ul class="iconlist">
    
    <li><img src="/images/manage/ico01.png" /><p><a href="#">管理信息</a></p></li>
    <li><img src="/images/manage/ico02.png" /><p><a href="#">其他管理</a></p></li>
    <li><img src="/images/manage/ico03.png" /><p><a href="#">常用工具</a></p></li>
    <li><img src="/images/manage/ico04.png" /><p><a href="#">文件上传</a></p></li>
    <li><img src="/images/manage/ico05.png" /><p><a href="#">目录管理</a></p></li>
    <li><img src="/images/manage/ico06.png" /><p><a href="#">退出</a></p></li> 
            
    </ul>
    
    <div class="ibox"><a class="ibtn"><img src="/images/manage/iadd.png" />添加新的快捷功能</a></div>
    
    <div class="xline"></div>
    <div class="box"></div>
    
    <div class="welinfo">
    <span><img src="/images/manage/dp.png" alt="提醒" /></span>
    <b>后台系统使用指南</b>
    </div>
    
    <ul class="infolist">
    <li><span>您可以快速进行各种信息管理操作</span><a class="ibtn">管理信息</a></li>
    <li><span>您可以进行其他管理</span><a class="ibtn">测试中心</a></li>
    <li><span>您可以进行密码修改、账户设置等操作</span><a class="ibtn">账户管理</a></li>
    </ul>
    
    <div class="xline"></div>
    
    <div class="uimakerinfo"><b>查看网站使用指南，您可以了解更多系统信息</b>(<a href="#" target="_blank">介绍</a>)</div>
    
    <ul class="umlist">
    <li><a href="#">后台用户设置(权限)</a></li>
    <li><a href="#">系统设置</a></li>
    </ul>    
    </div>
</body>
</html>