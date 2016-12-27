function submit() {
	var content = $("#view").val();
	var userName = $("#realName").val();
	var email = $("#email").val();
	var tel = $("#serviceNum").val();
//	if(tel!="" && !validSvcNum(tel)){
//		alert("请输入正确的手机号码！");
//    	return;
//    } 
//	if(email!="" && !validEmail($("#email"))){
//		alert("请输入正确的邮箱！");
//		return;
//	};
//	if(content.length > 2990){
//		alert("输入的内容过长！意见内容长度不能超过3000字");
//		return;
//	}
	$.ajax({
		type : "POST",
		url : "/index/addAdvise.do",
		data : {
			"userName" : userName,
			"content" : content,
			"email" : email,
			"tel" : tel
		},
		success : function(data) {
			alert("谢谢你的建议！");
			window.location="http://127.0.0.1:8080/";
		},
		error : function() {
			alert("获取连接异常！登录失败！");
		}
	});
}
//验证手机格式
function validSvcNum(inputObj,tipObj){
	var result = true;
	var re = /^1\d{10}$/
	if(!re.test(inputObj.val())){
		result = false;
	}
	return result;	
}

//验证邮箱格式
function validEmail(inputObj){
	var result = true;
	var re = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	if(!re.test(inputObj.val())){
		result = false;
	}
	return result;	
}
