<%@ page import="com.table.house.entity.House" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/header.jsp" %>
    <title>房源</title>
    <link href="/css/web/index.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<%@ include file="/jsp/web/toGo/toPersonal.jsp" %>
<form action="/webHouse/getSelectHouse.do" >
    <select name="location" class="select">
        <option value="">区域</option>
        <option value="1">泉州市</option>
        <option value="2">安溪县</option>
        <option value="3">城厢</option>
        <option value="4">凤城</option>
    </select>
    <select name="cost" class="select">
        <option value="">价格</option>
        <option value="1">500以下</option>
        <option value="2">500-1000</option>
        <option value="3">1000-2000</option>
        <option value="4">2000以上</option>
    </select>
    <select name="type" class="select">
        <option value="">房型</option>
        <option value="1">一室</option>
        <option value="2">两室</option>
        <option value="3">三室</option>
        <option value="4">四室</option>
    </select>
    <input type="submit" value="查询" class="button_confirm">
</form>
<table border="0" cellspacing="0" cellpadding="0" width="90%" class="table" style="align:center;">
    <%
        //循环显示数据
        List<House> houseList = (List<House>) request.getAttribute("houseList"); // 取request里面的对象队列
        if (null != houseList && houseList.size() != 0) {
            for (House aHouseList : houseList) {
                pageContext.setAttribute("house", aHouseList);
                //保存到页面pageContext里面方便下面进行EL表达式调用
    %>
    <tr onclick="toHouseDetail(${house.id})">
        <td hidden>${house.id}</td>
        <td rowspan="3"><img src="${house.image}" width="150px" height="100px" alt="房子图片"/></td>
        <td>${house.title}</td>
    </tr>
    <tr onclick="toHouseDetail(${house.id})">
        <td><span>所在地：</span>${house.location}</td>
    </tr>
    <tr onclick="toHouseDetail(${house.id})">
        <td><span>房租：</span>${house.cost}/元</td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="6">数据库中没有数据！</td>
    </tr>
    <%
        }
    %>
</table>
<form action="/webHouse/toHouseDetail.do" id="getHouseForm">
    <input name="houseId" hidden id="house_id">
</form>
</body>
<script src="/js/jquery-1.11.0.min.js"></script>
<script src="/js/web/index.js"></script>
</html>
