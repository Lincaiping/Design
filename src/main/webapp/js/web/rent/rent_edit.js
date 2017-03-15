$(function () {
    $("#file").change(function () {
        var houseId = $("#house_id").val();
        $.ajaxFileUpload({
            url: '/upload/upload.do',
            secureuri: false,
            fileElementId: 'file',//file标签的id
            dataType: 'json',//返回数据的类型
            data: {houseId: houseId},//一同上传的数据
            success: function (data, status) {
            },
            error: function (data, status, e) {
            }
        });


    })
})