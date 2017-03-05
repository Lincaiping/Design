$(function(){
  pageInit();
});
function pageInit(){
  jQuery("#limit").jqGrid(
      {
        url : "/limit/getAllLimit.do",
        datatype : "json",
        colNames : [ 'id', 'userId', '限制时间','类型','操作'],
        colModel : [ 
                     {name : 'id',index : 'id',width : 55,editable:true}, 
                     {name : 'userId',index : 'userId',width : 90,editable:true},
                     {name : 'enableTime',index : 'enableTime',width : 100,editable:true},
                     {name : 'type',index : 'type',width : 80,editable:true},
                     {name : 'oprate',width : 80,editable:false},
                   ],
        rowNum : 10,
        rowList : [ 10, 20, 30 ],
        jsonReader:{
            root:"rows", 
            page: "page",     
            total: "total",  
            records: "records",  
            //id: "0",
            repeatitems : false,
        },
        autowidth:true,//自动宽
        height:"100%",
        pager : '#pager',
        sortname : 'id',
        viewrecords : true,
        sortorder : "desc",
        multiselect : true,
        editurl : "/limit/saveOrUpdate.do",
        caption : "错误次数限制"
      });
  jQuery("#m1").click(function() {
    var rowId;
    rowId = jQuery("#limit").jqGrid('getGridParam', 'selarrrow');
    var celldata = $("#user").jqGrid('getCell',rowId,'id');
    alert(celldata);
  });
  $("#edit").click(function() {
        var gr = jQuery("#limit").jqGrid('getGridParam', 'selrow');
        if (gr != null)
          jQuery("#limit").jqGrid('editGridRow', gr, {
            height : 300,
            reloadAfterSubmit : true,
          });
        else
          alert("请选择需要编辑的记录");
      });
  $("#add").click(function() {
        jQuery("#limit").jqGrid('editGridRow', "new", {
          height : 300,
          reloadAfterSubmit : false
        });
      });
  $("#delete").click(function() {
      var gr = jQuery("#limit").jqGrid('getGridParam', 'selrow');
      if (gr != null){
    	  $.ajax({
    			type : "POST",
    			url : "/limit/delLimit.do",
    			data : {
    				id:gr,
    			},
    			success : function(data) {
                    alert("删除成功，请刷新页面");
    			},
    			error : function() {
    				alert("获取连接异常");
    			}
    		});
      }
      else
        alert("请选择删除的记录");
    });
}
