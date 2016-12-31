$(function() {
	$("#displayswipe").show();
	$("#displayone").hide();
	if (1 == 1) {
		$("#displayswipe").hide();
		$("#displayone").show();
	}
	new Swipe(document.getElementById('banner_box'), {
		speed : 500,
		auto : 3000,
		callback : function() {
			var lis = $(this.element).next("ol").children();
			lis.removeClass("on").eq(this.index).addClass("on");
		}
	});
});