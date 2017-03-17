<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/header.jsp" %>
    <link href="/css/web/house/house_detail.css" rel="stylesheet" type="text/css"/>
    <title>房屋详情</title>
</head>
<body>
<%@ include file="/jsp/web/toGo/toPersonal.jsp" %>
<div class="detailTitle"><span >房屋详情</span></div>
<div>
    <div id="imageswzi">
        <script src="/js/index/swipe2.js" type="text/javascript"></script>
        <div class="addWrap">
            <div class="swipe" id="mySwipe">
                <div class="swipe-wrap">
                    <c:forEach items="${imageList}" var="user" varStatus="vs">
                    <s:property value="#vs.index+1"/>
                    <div><a href="javascript:;"><img id="houseImg" class="img-responsive"
                                                     src="${user}"/></a></div>
                </div>
                </c:forEach>
            </div>
        </div>
        <script src="/js/jquery-1.11.0.min.js"></script>
        <script src="/js/index/index_01.js" type="text/javascript"></script>
    </div>
    <div class="houseInfo" style="display: block;width: 90%;text-align: center"><span class="houseTitle">${house.title}</span></div>
    <div class="houseInfo">${house.describle}</div>
    <div class="houseInfo"><span>位置：</span>${house.location}</div>
    <div class="houseInfo"><span>房租：</span> ${house.cost} <span style="margin-left: 30%">楼层：</span>${house.floor}</div>
</div>
<form action="/webHouse/toEditHouse.do" method="post">
    <input type="text" hidden id="houseId" name="houseId" value="${house.id}">
    <input type="submit" class="button_confirm" value="编辑">
</form>
</body>
<script src="/js/jquery-1.11.0.min.js"></script>
<script src="/js/web/rent/houseDetail.js"></script>
</html>
