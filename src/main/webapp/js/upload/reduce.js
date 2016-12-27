var photo = $('#photo');
function isCanvasSupported() {
	var elem = document.createElement('canvas');
	return !!(elem.getContext && elem.getContext('2d'));
}
var g_event = null;
$('#photo').on('change', function(event) {
	$("#cutArea").show();
	$("#loading").show();
	$("#bo").hide();
	if (!isCanvasSupported) {
		return;
	}
	g_event = event;
	compress(g_event, 1, function(base64Img) {
		$('#idPicUrl').attr('value', base64Img);
		$("#loading").hide();
		startCut();
	});
});

$("#needTurn").on('change', function() {
	var state = $("#needTurn").val();
	// alert(state);
	if (g_event) {
		compress(g_event, state, function(base64Img) {
			$('#idPicUrl').attr('value', base64Img);
			$("#loading").hide();
			startCut();
		});
	}

});

// 图片压缩并黑白化
function compress(event, status, callback) {
	var file = event.currentTarget.files[0];
	var reader = new FileReader();
	reader.onload = function(e) {
		var image = $('<img/>');
		image.on('load', function() {
			var square = 700;
			var canvas = document.createElement('canvas');
			canvas.width = square;
			canvas.height = square;
			var context = canvas.getContext('2d');
			context.clearRect(0, 0, square, square);
			var imageWidth;
			var imageHeight;
			var offsetX = 0;
			var offsetY = 0;
			if (this.width > this.height) {
				imageWidth = Math.round(square * this.width / this.height);
				imageHeight = square;
				offsetX = -Math.round((imageWidth - square) / 2);
			} else {
				imageHeight = Math.round(square * this.height / this.width);
				imageWidth = square;
				offsetY = -Math.round((imageHeight - square) / 2);
			}
			if (status == 2) {
				context.translate(0, imageHeight);
				context.rotate(-90 * Math.PI / 180);
				context.drawImage(this, offsetX, offsetY, imageWidth,
						imageHeight);
				// ctx.drawImage(img, 0, 0, imageWidth, imageWidth);
			} else if (status == 3) {
				context.translate(imageHeight, 00);
				context.rotate(90 * Math.PI / 180);
				context.drawImage(this, offsetX, offsetY, imageWidth,
						imageHeight);
			} else {
				context.drawImage(this, offsetX, offsetY, imageWidth,
						imageHeight);
			}
			var imgdate = context.getImageData(0, 0, imageWidth, imageHeight);
			context.putImageData(imgdate, 0, 0);
			var data = canvas.toDataURL('image/png');
			callback(data);
		});

		image.attr('src', e.target.result);
	};

	reader.readAsDataURL(file);
}
function cutImg() {
	var x = document.getElementById('dragDiv').offsetLeft;
	var y = document.getElementById('dragDiv').offsetTop;
	var width = document.getElementById('dragDiv').offsetWidth;
	var height = document.getElementById('dragDiv').offsetHeight;
	alert(x + "," + y + "," + width + "," + height);
	var c = document.createElement('canvas'); 
	c.id = "CursorLayer"; 
	c.width = 269; 
	c.height = 595; 
	var cxt = c.getContext("2d");
	var img = document.getElementById("back");
	cxt.drawImage(img, 0, 0);
	var userphoto = document.getElementById("userphoto");
	cxt.drawImage(userphoto, 20, 40);
	var logo = new Image();
	logo.src = "image/logo.png";
	cxt.drawImage(logo, 160, 400, 82, 168);
	var data = c.toDataURL('image/png');
	changeCut(data);
}
function changeCut(url) {
	$.ajax({
		url : "/file/uploadImg.do", // 请求的url地址
		dataType : "json", // 返回格式为json
		async : true, // 请求是否异步，默认为异步，这也是ajax重要特性
		data : {
			image : url,
		}, // 参数值
		type : "post", // 请求方式
		success : function(data) {
			$("#cutArea").hide();
			$("#bo").show();
			alert("上传成功，请返回！");
			history.go(-1);
		},
		error : function() {
			// 请求出错处理
			alert("处理失败");
		}
	});
}