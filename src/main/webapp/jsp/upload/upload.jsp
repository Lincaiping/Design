<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="upload.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
</head>
<body>

    <h1>springMVC字节流输入上传文件</h1>
    <form name="userForm1" action="upload"
        enctype="multipart/form-data" method="post">
        <div id="newUpload1">
            <input type="file" name="file">
        </div>

        <input type="button" id="btn_add1" value="增加一行"> <input
            type="submit" value="上传">
    </form>
    <br>
    <br>
    <hr align="left" width="60%" color="#FF0000" size="3">
    <br>
    <br>
    <h1>springMVC包装类上传文件</h1>
    <form name="userForm2" action="upload2"
        enctype="multipart/form-data" method="post">
        <div id="newUpload2">
            <input type="file" name="file">
        </div>
        <input type="button" id="btn_add2" value="增加一行"> <input
            type="submit" value="上传">
    </form>
</body>
</html>