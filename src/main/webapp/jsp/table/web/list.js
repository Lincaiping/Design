$(function(){
  pageInit();
});
function pageInit(){
  jQuery("#user").jqGrid(
      {
        url : "/web/getAllWeb.do",
        datatype : "json",
        colNames : [ 'id', '网站名称', '描述','链接地址','得分（10为满分）','成员数目'],
        colModel : [ 
                     {name : 'id',index : 'id',width : 55,editable:true}, 
                     {name : 'title',index : 'userName',width : 90,editable:true}, 
                     {name : 'describle',index : 'password',width : 100,editable:true},
                     {name : 'link',index : 'age',width : 80,editable:true},
                     {name : 'score',width : 80,editable:true},
                     {name : 'member',width : 80,editable:true},
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
        editurl : "/web/saveOrUpdate.do",
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
    			url : "/web/delWeb.do",
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
