var tongjitype = $.trim();
		var uid = $.trim(87740);
		function tongji(id, type) {
			$.ajax({
				url : "/87740/phonewebsite/tongji",
				type : "post",
				async : false,
				data : {
					'id' : id,
					'type' : type,
					'tongjitype' : tongjitype,
					'uid' : uid
				}
			})
		}
		var fx_describefenxiang = "";
		wx_share_out('新罗新闻', '', fx_describefenxiang);