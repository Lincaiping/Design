<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="/js/upload/upload.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
</head>
<body>

	<h1>普通文件上传</h1>
	<form name="userForm1" action="/file/upload.do" enctype="multipart/form-data" method="post">
		<div id="newUpload1">
			<input type="file" name="file">
		</div>
		<input type="button" id="btn_add1" value="增加一行"> 
		<input type="submit" value="上传">
	</form>
	<br>
	<br>
	<hr align="left" width="60%" color="#FF0000" size="3">
	<br>
	<br>
	<h1>图片在线剪切上传</h1>
	<a href="/file/toImage.do">进入图片上传测试中心！</a>
</body>
</html>