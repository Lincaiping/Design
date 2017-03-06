$(function () {
    pageInit();
});
function pageInit() {
    jQuery("#house").jqGrid(
        {
            url: "/house/getAllHouse.do",
            datatype: "json",
            colNames: ['id','图片', '房东', '位置','面积','楼层', '房租', '类型','详细信息','操作'],
            colModel: [
                {name: 'id', index: 'id', width: 55, editable: true},
                {name: 'image', index: 'image', width: 55, editable: true},
                {name: 'owner', index: 'owner', width: 100, editable: true},
                {name: 'location', index: 'location', width: 80, editable: true},
                {name: 'area', index: 'area', width: 90, editable: true},
                {name: 'floor', index: 'floor', width: 90, editable: true},
                {name: 'cost', index: 'cost', width: 90, editable: true},
                {name: 'type', index: 'type', width: 90, editable: true},
                {name: 'describle', index: 'describle', width: 90, editable: true},
                {name: 'oprate', width: 80, editable: false},
            ],
            rowNum: 10,
            rowList: [10, 20, 30],
            jsonReader: {
                root: "rows",
                page: "page",
                total: "total",
                records: "records",
                //id: "0",
                repeatitems: false,
            },
            autowidth: true,//自动宽
            height: "100%",
            pager: '#pager',
            sortname: 'id',
            viewrecords: true,
            sortorder: "desc",
            multiselect: true,
            editurl: "/house/saveOrUpdate.do",
            caption: "房屋管理"
        });
    jQuery("#m1").click(function () {
        var rowId;
        rowId = jQuery("#house").jqGrid('getGridParam', 'selarrrow');
        var celldata = $("#house").jqGrid('getCell', rowId, 'id');
        alert(celldata);
    });
    $("#edit").click(function () {
        var gr = jQuery("#house").jqGrid('getGridParam', 'selrow');
        if (gr != null)
            jQuery("#house").jqGrid('editGridRow', gr, {
                height: 500,
                reloadAfterSubmit: true,
            });
        else
            alert("请选择需要编辑的记录");
    });
    $("#add").click(function () {
        jQuery("#house").jqGrid('editGridRow', "new", {
            height: 500,
            reloadAfterSubmit: false
        });
    });
    $("#delete").click(function () {
        var gr = jQuery("#house").jqGrid('getGridParam', 'selrow');
        if (gr != null) {
            $.ajax({
                type: "POST",
                url: "/house/delHouse.do",
                data: {
                    id: gr,
                },
                success: function (data) {
                    alert("删除成功，请刷新页面");
                },
                error: function () {
                    alert("获取连接异常");
                }
            });
        }
        else
            alert("请选择删除的记录");
    });
}
