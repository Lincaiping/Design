<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/header.jsp" %>
    <title>房源图片上传</title>
    <link href="/css/web/house/rent_edit.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<%@ include file="/jsp/web/toGo/toPersonal.jsp" %>
<b>当前账户：&nbsp&nbsp&nbsp&nbsp${userName }</b>
<h1>图片上传</h1>
<form name="userForm1" action="/webHouse/rentHouse.do" method="post">
    <div id="newUpload1" class="file">选择文件
        <input type="file" id="file"  name="file">
    </div>

    <p class="tips">你可以再次点击，上传多张图片，但是每次只能上传一张哦！</p>

    <hr style="height:3px;border:none;border-top:3px double red;"/>

    <form name="userForm1" action="/webHouse/rentHouse.do" method="post">
        <div class="userForm">
            <div>id号：<input type="text" value="${house.id}" id="house_id" name="houseId">
            </div>
            <div><input type="text" class="input-style" id="images" hidden name="images">
            </div>
            <div>标题：<input type="text" value="${house.title}" class="input-style" id="title"
                           name="title" placeholder="标题">
            </div>
            <div>描述：<input type="text" value="${house.describle}" class="input-style" id="describle"
                           name="describle" placeholder="描述">
            </div>
            <div>房租：<input type="number" value="${house.cost}" class="input-style" id="cost"
                           name="cost" placeholder="房租">
            </div>
            <div>户型：<input type="text" value="${house.type}" class="input-style" id="type"
                           name="type" placeholder="户型">
            </div>
            <div> 位置：<input type="text" value="${house.location}" class="input-style" id="location"
                            name="location" placeholder="位置">
            </div>
            <div>面积：<input type="number" value="${house.area}" class="input-style" id="area"
                           name="area" placeholder="面积">
            </div>
            <div>楼层：<input type="text" value="${house.floor}" class="input-style" id="floor"
                           name="floor" placeholder="楼层">
            </div>
            <div><input type="submit" class="button_confirm" value="确定"><br/>
            </div>
        </div>
    </form>
</form>
</body>
<script src="/js/jquery-1.11.0.min.js"></script>
<script src="/js/upload/ajaxfileupload.js"></script>
<script src="/js/web/rent/rent_edit.js"></script>
</html>
