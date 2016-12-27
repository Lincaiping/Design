function loginTest(){
	$.ajax({
		type : "POST",
		url : "/test/testLogin.do",
		data : {
		},
		success : function(data) {
			alert(data);
		},
		error : function() {
			alert("获取连接异常！");
		}
	});
}

function submit(){
	var userName = $("#userName").val();
	$.ajax({
		type : "POST",
		url : "/test/testRegister.do",
		data : {
			"userName":userName,
		},
		success : function(data) {
			alert(data);
		},
		error : function() {
			alert("获取连接异常！");
		}
	});
}
function registerTest(){
	$("#register").show();
}