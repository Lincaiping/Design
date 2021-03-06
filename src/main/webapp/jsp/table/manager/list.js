$(function(){
  pageInit();
});
function pageInit(){
  jQuery("#managers").jqGrid(
      {
        url : "/managers/getAllManager.do",
        datatype : "json",
        colNames : [ 'id', '用户名','管理员类型', '密码','电话','邮箱','最后登录时间','登录次数','是否可用',"操作"],
        colModel : [ 
                     {name : 'id',index : 'id',width : 55,editable:true}, 
                     {name : 'username',index : 'username',width : 90,editable:true},
                     {name : 'type',index : 'type',width : 100,editable:true},
                     {name : 'password',index : 'password',width : 100,editable:true},
                     {name : 'tel',index : 'tel',width : 100,editable:true},
                     {name : 'email',index : 'email',width : 100,editable:true},
                     {name : 'lastPassTime',index : 'lastPassTime',width : 80,editable:true},
                     {name : 'passCount',width : 80,editable:true},
                     {name : 'enable',width : 80,editable:true},
                     {name : 'oprate',width : 80,editable:false}
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
        caption : "管理员权限管理"
      });
  jQuery("#m1").click(function() {
    var rowId;
    rowId = jQuery("#managers").jqGrid('getGridParam', 'selarrrow');
    var celldata = $("#managers").jqGrid('getCell',rowId,'id');
    alert(celldata);
  });
  $("#edit").click(function() {
        var gr = jQuery("#managers").jqGrid('getGridParam', 'selrow');
        if (gr != null)
          jQuery("#managers").jqGrid('editGridRow', gr, {
            height : 500,
            reloadAfterSubmit : true,
          });
        else
          alert("请选择需要编辑的记录");
      });
  $("#add").click(function() {
        jQuery("#managers").jqGrid('editGridRow', "new", {
          height : 500,
          reloadAfterSubmit : false
        });
      });
  $("#delete").click(function() {
      var gr = jQuery("#managers").jqGrid('getGridParam', 'selrow');
      if (gr != null){
    	  $.ajax({
    			type : "POST",
    			url : "/managers/delManager.do",
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
