function getCode(){
	var tel = $("#tel").val();
	$.ajax({
		type : "POST",
		url : "/index/getCode.do",
		data : {
			"tel":tel,
		},
		success : function(data) {
			alert("请查看验证码！");
		},
		error : function() {
			alert("获取连接异常！");
		}
	});
}


function submitTel(){
	var tel = $("#tel").val();
	var code = $("#code").val();
	$.ajax({
		type : "POST",
		url : "/personal/setTel.do",
		data : {
			"tel":tel,
			"code":code,
		},
		success : function(data) {
			alert("设置成功！");
		},
		error : function() {
			alert("获取连接异常！");
		}
	});	
}