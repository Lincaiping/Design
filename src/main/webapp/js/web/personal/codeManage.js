function getPassWord(id){
	$.ajax({
		type : "POST",
		url : "/records/getPassword.do",
		data : {
			"id" : id,
		},
		success : function(data) {
			alert(data);
		},
		error : function() {
			alert("获取连接异常！");
		}
	});
}