$(function(){
  pageInit();
});
function pageInit(){
  jQuery("#advise").jqGrid(
      {
        url : "/advise/getAllAdvise.do",
        datatype : "json",
        colNames : [ 'id', '描述', '手机号码','邮箱','操作'],
        colModel : [ 
                     {name : 'id',index : 'id',width : 55,editable:true}, 
                     {name : 'describle',index : 'describle',width : 90,editable:true},
                     {name : 'tel',index : 'tel',width : 100,editable:true},
                     {name : 'email',index : 'email',width : 80,editable:true},
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
        editurl : "/advise/saveOrUpdate.do",
        caption : "用户建议管理"
      });
  jQuery("#m1").click(function() {
    var rowId;
    rowId = jQuery("#advise").jqGrid('getGridParam', 'selarrrow');
    var celldata = $("#advise").jqGrid('getCell',rowId,'id');
    alert(celldata);
  });
  $("#edit").click(function() {
        var gr = jQuery("#advise").jqGrid('getGridParam', 'selrow');
        if (gr != null)
          jQuery("#advise").jqGrid('editGridRow', gr, {
            height : 300,
            reloadAfterSubmit : true,
          });
        else
          alert("请选择需要编辑的记录");
      });
  $("#add").click(function() {
        jQuery("#advise").jqGrid('editGridRow', "new", {
          height : 300,
          reloadAfterSubmit : false
        });
      });
  $("#delete").click(function() {
      var gr = jQuery("#advise").jqGrid('getGridParam', 'selrow');
      if (gr != null){
    	  $.ajax({
    			type : "POST",
    			url : "/advise/delAdvise.do",
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
