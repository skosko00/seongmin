<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page errorPage="/View/error/error.jsp"%>
<br>
<br>
<div class="ui black inverted vertical footer segment">
	<div class="ui center aligned container">
		<h5>
			상호 : 더 펜션 / 대표자 성명 : 안형조
			<br>
			개인정보 보호책임자 : 안형조
			<br>
			문의 : 010-3787-5606
			<br>
			입금 계좌 : 우리 010-3787-5606 (예금주 : 안형조)
			<br>
			주소 : 서울 영등포구 선유동2로 57 (이레빌딩)
			<br>
			통신판매업 : 제 2018-서울영등포-0000호
			<br>
			Copyrights © 2018 All Rights Reserved by 더 펜션.
		</h5>
		<div class="ui inverted section divider"></div>
		<a href="/">
			<img src="/Image/footerLogo.png" class="ui centered mini image" style="width: 200px;">
		</a>
		<div class="ui horizontal inverted small divided link list">
			<a class="item" href="/"><h4>더 펜션</h4></a>
		</div>
	</div>
</div>
<!-- pusher 끝 -->
</div>

<script>
// 예약 기록 넘기기 위한 ajax 부르는 함수
$(document).ready(function() { 
	
	var today = new Date().getFullYear() +"/"+ (new Date().getMonth()+1) +"/"+ new Date().getDate();
	 
	$.ajax ({
		
		url : '/moveReservationHistory',
		data : {today:today},
		type : 'post',
		success : function() {
			/* 성공 테스트 */
		},
		error : function() {
			/* 실패 테스트 */
		}
		
	});
	
});
</script>