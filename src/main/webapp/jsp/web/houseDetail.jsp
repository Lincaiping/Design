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
<div id="imageswzi">
    <script src="/js/index/swipe2.js" type="text/javascript"></script>
    <div class="addWrap">
        <div class="swipe" id="mySwipe">
            <div class="swipe-wrap">
                <%
                    //循环显示数据
                    List<String> imageList = (List<String>) request.getAttribute("imageList"); // 取request里面的对象队列
                    if (null != imageList && imageList.size() != 0) {
                        for (String aHouseList : imageList) {
                            pageContext.setAttribute("imageList", aHouseList);
                            //保存到页面pageContext里面方便下面进行EL表达式调用
                %>
                <div><a href="javascript:;">
                    <img class="img-responsive"
                         src="${aHouseList}"/></a></div>
            </div>
        </div>
        <%
            }
        %>
        <%
            }
        %>
        <ul id="position">
            <li class="cur"></li>
            <li class=""></li>
            <li class=""></li>
        </ul>
    </div>
    <div>${house.title}</div>
    <div>${house.location}</div>
    <div>${house.cost}</div>
    <div>${house.floor}</div>
</div>
<form action="/webHouse/toEditHouse.do" method="post">
    <input type="text" hidden id="houseId" name="houseId" value="${house.id}">
    <input type="submit" class="input-style" value="编辑">
</form>
</body>
<script src="/js/jquery-1.11.0.min.js"></script>
<script src="/js/web/rent/houseDetail.js"></script>
</html>
