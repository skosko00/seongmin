$(document).ready(function() {

	// 따라다니는 메뉴바(스와이퍼 이미지 높이 이상 스크롤 내렸을 때)
	$('.swiper-container').visibility({
		once : false,
		onBottomPassed : function() {
			$('.fixed.menu').transition('fade in');
		},
		onBottomPassedReverse : function() {
			$('.fixed.menu').transition('fade out');
		}
	});

	// 사이드 메뉴바 이벤트
	$('.ui.sidebar').sidebar('attach events', '.toc.item');
});
