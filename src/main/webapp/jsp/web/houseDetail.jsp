<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/header.jsp" %>
    <title>房屋详情</title>
</head>
<body>
<a href="/personal/toPersonal.do">个人中心</a>
<div>
    <div id="imageswzi">
        <script src="/js/index/swipe2.js" type="text/javascript"></script>
        <div class="addWrap">
            <div class="swipe" id="mySwipe">
                <div class="swipe-wrap">
                    <c:forEach items="${imageList}" var="user" varStatus="vs">
                    <s:property value="#vs.index+1"/>
                    <div><a href="javascript:;"><img class="img-responsive"
                                                     src="${user}"/></a></div>
                </div>
                </c:forEach>
            </div>
        </div>
        <script src="/js/index/index_01.js" type="text/javascript"></script>
    </div>
    <div>${house.title}</div>
    位置：<div>${house.location}</div>
    房租：<div>${house.cost}</div>
    楼层：<div>${house.floor}</div>
</div>
<form action="/webHouse/toEditHouse.do" method="post">
    <input type="text" hidden id="houseId" name="houseId" value="${house.id}">
    <input type="submit" class="input-style" value="编辑">
</form>
</body>
<script src="/js/jquery-1.11.0.min.js"></script>
<script src="/js/web/rent/houseDetail.js"></script>
</html>
