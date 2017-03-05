<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/header.jsp" %>
    <title>房源图片上传</title>
</head>
<body>
<a href="/personal/toPersonal.do">个人中心</a>
<h1>图片上传</h1>
<form name="userForm1" action="/webHouse/rentHouse.do" method="post">
    <div id="newUpload1">
        <input type="file" id="file" name="file">
    </div>

    <p>你可以再次点击，上传多张图片，但是每次只能上传一张哦</p>

    <form name="userForm1" action="/webHouse/rentHouse.do" method="post">
        <input type="text" value="${house.id}" id="house_id" name="houseId">
        <input type="text" class="input-style" id="images" hidden name="images">
        <input type="text" value="${house.title}" class="input-style"  id="title" name="title" placeholder="标题">
        <input type="text" value="${house.describle}"class="input-style"  id="describle" name="describle" placeholder="描述">
        <input type="number" value="${house.cost}" class="input-style" id="cost" name="cost" placeholder="房租">
        <input type="text" value="${house.type}"  class="input-style" id="type" name="type" placeholder="户型">
        <input type="text" value="${house.location}" class="input-style"  id="location" name="location" placeholder="位置">
        <input type="number" value="${house.area}"class="input-style" id="area" name="area" placeholder="面积">
        <input type="text" value="${house.floor}" class="input-style"  id="floor" name="floor" placeholder="楼层">
        <input type="submit"  class="input-style"  value="确定">
    </form>

</form>
</body>
<script src="/js/jquery-1.11.0.min.js"></script>
<script src="/js/upload/ajaxfileupload.js"></script>
<script src="/js/web/rent/rent_edit.js"></script>
</html>
