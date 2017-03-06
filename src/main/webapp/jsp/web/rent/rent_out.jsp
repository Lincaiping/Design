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
<a href="/personal/toPersonal.do">个人中心</a>
<form name="userForm1" action="/webHouse/rentHouse.do" method="post">
    <input type="text" class="input-style" id="images" hidden name="images"><br/>
    标题：<input type="text" class="input-style"  id="title" name="title" placeholder="标题"><br/>
    描述：<input type="text" class="input-style"  id="describle" name="describle" placeholder="描述"><br/>
    房租：<input type="number"  class="input-style" id="cost" name="cost" placeholder="房租"><br/>
    户型：<input type="text"  class="input-style" id="type" name="type" placeholder="户型"><br/>
    位置：<input type="text" class="input-style"  id="location" name="location" placeholder="位置"><br/>
    面积：<input type="number"  class="input-style" id="area" name="area" placeholder="面积"><br/>
    楼层：<input type="text" class="input-style"  id="floor" name="floor" placeholder="楼层"><br/><br/>
    <input type="submit"  class="input-style"  value="确定"><br/>
</form>
</body>
<script src="/js/jquery-1.11.0.min.js"></script>
<script src="/js/web/rent/rent_out.js"></script>

</html>
