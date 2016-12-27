$(function(){
  pageInit();
});
function pageInit(){
  jQuery("#user").jqGrid(
      {
        url : "/managers/getAllManager.do",
        datatype : "json",
        colNames : [ 'id', '用户名','管理员类型', '密码','最后登录时间','登录次数'],
        colModel : [ 
                     {name : 'id',index : 'id',width : 55,editable:true}, 
                     {name : 'name',index : 'name',width : 90,editable:true}, 
                     {name : 'type',index : 'type',width : 100,editable:true},
                     {name : 'password',index : 'password',width : 100,editable:true},
                     {name : 'lastPassTime',index : 'lastPassTime',width : 80,editable:true},
                     {name : 'passCount',width : 80,editable:false},
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
        editurl : "/managers/saveOrUpdate.do",
        caption : "用户信息管理"
      });
  jQuery("#m1").click(function() {
    var rowId;
    rowId = jQuery("#user").jqGrid('getGridParam', 'selarrrow');
    var celldata = $("#user").jqGrid('getCell',rowId,'id');
    alert(celldata);
  });
  $("#edit").click(function() {
        var gr = jQuery("#user").jqGrid('getGridParam', 'selrow');
        if (gr != null)
          jQuery("#user").jqGrid('editGridRow', gr, {
            height : 300,
            reloadAfterSubmit : true,
          });
        else
          alert("请选择需要编辑的记录");
      });
  $("#add").click(function() {
        jQuery("#user").jqGrid('editGridRow', "new", {
          height : 300,
          reloadAfterSubmit : false
        });
      });
  $("#delete").click(function() {
      var gr = jQuery("#user").jqGrid('getGridParam', 'selrow');
      if (gr != null){
    	  $.ajax({
    			type : "POST",
    			url : "/manager/delUser.do",
    			data : {
    				id:gr,
    			},
    			success : function(data) {
    				
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
