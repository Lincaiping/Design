<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html style="font-size:70%">
<head>
<%@ include file="/header.jsp"%>
<link rel="stylesheet" href="/css/web/personal/box.css">
<link rel="stylesheet" href="/css/web/personal/loadingFloat.css">
<link rel="stylesheet" href="/css/web/personal/public.css">
<link rel="stylesheet" href="/css/web/personal/font-awesome.css">
<link rel="stylesheet" href="/css/web/personal/personal_center.css">
<link rel="stylesheet" href="/css/web/personal/band.css">
<link rel="stylesheet" href="/css/web/personal/realName.css">
<title>实名认证！</title>
</head>
<body class="body_color">
	<!--状态栏 begin-->
	<div class="wap_header"></div>
    <!--状态栏 over-->
    <!--实名认证1 begin-->
    <div class="name1_top">
    	<div class="name1_jz">
        	<a href="/login/login.do"><img src="/images/personal/name1_icon01.png"></a>
            <p>实名认证</p>
        </div>
    </div>


    <div class="name_wzc">
    	<div class="name_jzk">
            <div class="name_srkh">
            	<span>姓名：</span>
            	<c:if test='${!empty realName}'>
            		<input id="userName" name="userName" type="text" value="${realName}" disabled="disabled">
            	</c:if>
            	<c:if test='${empty realName}'>
            		<input id="userName" name="userName" type="text" placeholder="请输入真实的姓名"/>
            	</c:if>
            </div>
            <div class="name_srkh">
               	<span>身份证：</span>
            	<c:if test='${!empty idNum}'>
            		<input id="certNum" name="certNum" type="text" value="${idNum}" disabled="disabled">
            	</c:if>
            	<c:if test='${empty idNum}'>	
            		<input id="certNum" name="certNum" type="text" placeholder="请输入真实的身份证号">
            	</c:if>
            </div>
        </div>
    </div>
    <c:if test='${empty idNum}'>	
    	<div class="phone_button" style="height:70px">
	          <a href="javascript:realNameValid();" class="phone_back">实名认证</a>
	    </div>
    </c:if>
</body>
<script src="/js/jquery-1.11.0.min.js"></script>
<script src="/js/web/personal/realName.js"></script>
</html>