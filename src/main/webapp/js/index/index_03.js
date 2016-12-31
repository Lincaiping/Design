$(function() {
			if (typeof WeixinJSBridge == "undefined") {
				if (document.addEventListener) {
					document.addEventListener('WeixinJSBridgeReady',
							onBridgeReady, false);
				} else if (document.attachEvent) {
					document.attachEvent('WeixinJSBridgeReady', onBridgeReady);
					document
							.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
				}
			} else {
				onBridgeReady();
			}
			var shareTitle = '新罗新闻';
			var imgUrl = "http://pic.dodoca.com/org/6/64/ac0/9842/63edb7c1ac28d76b4f1d21.jpg";
			var descContent = $("#div_fx_describe").text();
			var urllink = "www.dodoca.com/87740/phonewebsite/website?id=133870#mp.weixin.qq.com";
			wx_share_out('87740', shareTitle, imgUrl, descContent, urllink);
		})
		function onBridgeReady() {
			WeixinJSBridge.call('showOptionMenu');
		}