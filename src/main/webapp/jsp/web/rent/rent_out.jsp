<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/header.jsp" %>
    <title>房源</title>
</head>
<link href="/css/web/house/rent_out.css" rel="stylesheet" type="text/css"/>
<body>
<%@ include file="/jsp/web/toGo/toPersonal.jsp" %>
<form name="userForm1" action="/webHouse/rentHouse.do" method="post">
    <div class="userForm">
        <div><input type="text" class="input-style" id="images" hidden name="images">
        </div>
        <div>标题：<input type="text" class="input-style" id="title" name="title" placeholder="标题">
        </div>
        <div>描述：<input type="text" class="input-style" id="describle" name="describle"
                       placeholder="描述">
        </div>
        <div> 房租：<input type="number" class="input-style" id="cost" name="cost" placeholder="房租">
        </div>
        <div>户型：<input type="text" class="input-style" id="type" name="type" placeholder="户型">
        </div>
        <div>位置：<input type="text" class="input-style" id="location" name="location"
                       placeholder="位置">
        </div>
        <div>面积：<input type="number" class="input-style" id="area" name="area" placeholder="面积">
        </div>
        <div> 楼层：<input type="text" class="input-style" id="floor" name="floor" placeholder="楼层">
        </div>
        <input type="submit" class="button_confirm" value="确定">
    </div>
</form>
</body>
<script src="/js/jquery-1.11.0.min.js"></script>
<script src="/js/web/rent/rent_out.js"></script>

</html>
