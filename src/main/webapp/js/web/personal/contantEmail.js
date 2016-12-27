function getCode(){
	var email = $("#email").val();
	$.ajax({
		type : "POST",
		url : "/index/getCode.do",
		data : {
			"email":email,
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
	var email = $("#email").val();
	var code = $("#code").val();
	$.ajax({
		type : "POST",
		url : "/personal/setEmail.do",
		data : {
			"email":email,
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