$(function () {
    pageInit();
});

function pageInit() {
    jQuery("#contract").jqGrid(
        {
            url: "/contract/getAllContract.do",
            datatype: "json",
            colNames: ['id', '房东', '用户', '房屋', '房租','创建时间','可用时间', '操作'],
            colModel: [
                {name: 'id', index: 'id', width: 55, editable: true},
                {name: 'ownerId', index: 'ownerId', width: 55, editable: true},
                {name: 'userId', index: 'userId', width: 100, editable: true},
                {name: 'houseId', index: 'houseId', width: 80, editable: true},
                {name: 'cost', index: 'cost', width: 80, editable: true},
                {name: 'createTime', index: 'createTime', width: 80, editable: true},
                {name: 'enableTime', index: 'enableTime', width: 80, editable: true},
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
            editurl: "/contract/saveOrUpdate.do",
            caption: "合同管理"
        });

    jQuery("#m1").click(function () {
        var rowId;
        rowId = jQuery("#contract").jqGrid('getGridParam', 'selarrrow');
        var celldata = $("#contract").jqGrid('getCell', rowId, 'id');
        alert(celldata);
    });

    $("#edit").click(function () {
        var gr = jQuery("#contract").jqGrid('getGridParam', 'selrow');
        if (gr != null)
            jQuery("#contract").jqGrid('editGridRow', gr, {
                height: 400,
                reloadAfterSubmit: true,
            });
        else
            alert("请选择需要编辑的记录");
    });

    $("#add").click(function () {
        jQuery("#contract").jqGrid('editGridRow', "new", {
            height: 400,
            reloadAfterSubmit: false
        });
    });

    $("#delete").click(function () {
        var gr = jQuery("#contract").jqGrid('getGridParam', 'selrow');
        if (gr != null) {
            $.ajax({
                type: "POST",
                url: "/contract/delContract.do",
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
