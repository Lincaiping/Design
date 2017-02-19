$(function () {
    $("#file").change(function () {
        $.ajaxFileUpload({
            url: '/upload/upload.do',
            secureuri: false,
            fileElementId: 'file',//file标签的id
            dataType: 'json',//返回数据的类型
            data: {},//一同上传的数据
            success: function (data, status) {
                debugger;
                $("#images").attr("value", data.result);
            },
            error: function (data, status, e) {
                alert(e);
            }
        });


    })
})