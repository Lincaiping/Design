window.onload = function () {
    var aInput = document.getElementsByTagName('input');
    var oUser = aInput[0];
    var oPwd = aInput[1]
    var aI = document.getElementsByTagName('i')[0];


    //用户名检测

    oUser.onfocus = function () {
        aI.innerHTML = '';
        oUser.removeAttribute("placeholder");
    }

    oUser.onkeyup = function () {

    }

    //密码检测
    oPwd.onfocus = function () {
        if (oUser.value == "") {
            aI.innerHTML = '账号不能为空';
        }
        oPwd.removeAttribute("placeholder");
    }

    oPwd.onblur = function () {
        if (this.value == "") {
            aI.innerHTML = '密码不可为空';
        }
        oPwd.style.placeholder = '请输入确认密码';
    }
}

function login() {
    $.ajax({
        type: "POST",
        dataType: "html",
        url: "/login/managerLogin.do",
        scriptCharset: 'utf-8',
        contentType: "application/x-www-form-urlencoded;charset=UTF-8",
        data: $('#faLogin').serialize(),
        success: function (data) {
            if ($.trim(data) == $.trim("success")) {
                window.location.href = "/managers/toManage.do";
            }
            else {
                alert(data)
            }
        },
        error: function (data) {
            alert("error:" + data);
        }
    });
}