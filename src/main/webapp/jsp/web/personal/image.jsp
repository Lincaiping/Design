<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width,user-scalable=no" />
<script type="text/javascript" src="/js/upload/cutBefore.js"></script>
<script type="text/javascript" src="/js/upload/drag.js"></script>
<script type="text/javascript" src="/js/upload/resize.js"></script>
<script type="text/javascript" src="/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="/js/upload/html2canvas.js"></script>
<link rel="stylesheet" type="text/css" href="/css/upload/imgCut.css">
<link rel="stylesheet" type="text/css" href="/css/upload/reduce.css">
<link rel="stylesheet" type="text/css" href="/css/upload/Beself.css" >
<title>图片压缩上传</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<div id="photosUp">
<p id="header"><div class="box">1</div>请上传您的背景照片</p>
<div class="free-upload-photo" ><span id="photo_img"></span> 
<input type="file" id="photo" class="postFile"/>
<span>图片旋转</span>
<select id="needTurn">
  <option value ="1">无</option>
  <option value ="2">向左</option>
  <option value ="3">向右</option>
</select>
</div>
<img alt="" id="createImg" src="">
<p id="photo_loading" hidden>正在上传...</p>
</br>
<center>
<div id="cutArea" hidden>
<table width="320" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="300">
      <div id="bgDiv">
      </div>
    </td>
  </tr>
</table>
<br />
<input id="cutImg" type="button" class="button" value="完成剪切" onclick="cutImg();" />
<br/>
<div id="viewDiv"> </div><br />
<input id="idPicUrl" type="hidden" value="" />
<img src="" hidden id="createImg">
<img src="" id="can_img" alt="" style="height:0">
</div>
</center>
<script type="text/javascript">

function startCut(rotate_img){
  var imgSource=$("#idPicUrl").val();

  Preview(imgSource);

}

function Preview(imgSource) {

  var html = '<div id="dragDiv">\
            <div id="rRightDown"> </div>\
            <div id="rLeftDown"> </div>\
            <div id="rRightUp"> </div>\
            <div id="rLeftUp"> </div>\
            <div id="rRight"> </div>\
            <div id="rLeft"> </div>\
            <div id="rUp"> </div>\
            <div id="rDown"></div>\
          </div>';
    $("#bgDiv").html('').append(html);      

    var ic = new ImgCropper("bgDiv", "dragDiv", imgSource, {
      Width: 300, Height: 400, Color: "#000",
      Resize: true,
      Scale:true,
      Right: "rRight", Left: "rLeft", Up: "rUp", Down: "rDown",
      RightDown: "rRightDown", LeftDown: "rLeftDown", RightUp: "rRightUp", LeftUp: "rLeftUp",
      Preview: "viewDiv", viewWidth: 300, viewHeight: 400
    });
}

</script>
</div>
  <div id="cut" hidden>
    <img id="bwImage"src="">
  </div>
</body>
</html>
<script src="/js/upload/reduce.js"></script>
