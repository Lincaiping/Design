function getCode(){
	var serviceNum = $("#serviceNum").val();
	$.ajax({
		type : "POST",
		url : "/index/getCode.do",
		data : {
			"serviceNum":serviceNum,
		},
		success : function(data) {
			alert("请查看验证码！");
		},
		error : function() {
			alert("获取连接异常！");
		}
	});
}
function submitEmail(){
	var serviceNum = $("#serviceNum").val();
	var code = $("#code").val();
	$.ajax({
		type : "POST",
		url : "/personal/setTel.do",
		data : {
			"serviceNum":serviceNum,
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