<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/header.jsp" %>
    <title>房源</title>
</head>
<body>
<a href="/personal/toPersonal.do">个人中心</a>
<h1>图片上传</h1>
<form name="userForm1" action="/webHouse/rentHouse.do" method="post">
    <div id="newUpload1">
        <input type="file" id="file" name="file">
    </div>
    <input type="button" id="btn_add1" value="增加一行">
    <input type="text" id="images" hidden name="images">
    <input type="text" id="title" name="title" placeholder="标题">
    <input type="text" id="describle" name="describle" placeholder="描述">
    <input type="number" id="cost" name="cost" placeholder="房租">
    <input type="text" id="type" name="type" placeholder="户型">
    <input type="text" id="location" name="location" placeholder="位置">
    <input type="number" id="area" name="area" placeholder="面积">
    <input type="text" id="floor" name="floor" placeholder="楼层">
    <input type="submit" value="确定">
</form>
</body>
<script src="/js/jquery-1.11.0.min.js"></script>
<script src="/js/web/rent/rent_out.js"></script>

</html>
