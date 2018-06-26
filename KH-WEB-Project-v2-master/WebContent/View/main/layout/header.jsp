<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page errorPage="/View/error/error.jsp"%>

<style>
body {
	background: #eee;
	font-family: 맑은고딕;
	font-size: 14px;
	color: #000;
	margin: 0;
	padding: 0;
}

#btnMargin {
	margin-left: 7.5px;
}

#load {
	width: 100%;
	height: 100%;
	top: 0;
	left: 0;
	position: fixed;
	display: block;
	opacity: 1;
	background: rgb(235, 235, 235);
	z-index: 99;
	text-align: center;
}

#load>img {
	position: absolute;
	top: 50%;
	left: 50%;
	z-index: 100;
}

/* 스크롤 */
::-webkit-scrollbar {
	width: 10px;
}

::-webkit-scrollbar-track {
	background: #F9FEFF;
}

::-webkit-scrollbar-thumb {
	background: rgb(27, 28, 29);
}

::-webkit-scrollbar-thumb:hover {
	background: rgb(120, 120, 120);
}
</style>
<c:set value="${sessionScope.member.mbId}" var="id"></c:set>
<c:if test="${id eq 'thepension'}">
<div style="color: white; font-size: 14px; font-weight: 600">
	관리자 로그인 했습니다 <a href="/adminIndex" style="color: orange;">관리 페이지로 이동</a>
</div>
</c:if>

<!-- 로그인  -->
<c:set value="${sessionScope.member.mbId}" var="id"></c:set>
<c:if test="${not empty id}">
<script type="text/javascript">
	$(document).ready(function() {
		var $loginBtn = $('.loginBtn');
		$loginBtn.html('로그아웃').attr('href', '/logout');
		var $signupBtn = $('.signupBtn');
		$signupBtn.html('마이페이지').attr('href', '/mypagelogin');
	});
</script>
</c:if>

<div id="load">
	<img src="/Image/loading.gif" alt="loading">
</div>

<!-- pusher 시작 -->
<div class="pusher">
	<!-- 메인 타이틀 -->
	<div class="ui center aligned basic segment" style="background-color: rgb(240, 240, 240); margin: 0px;">
		<h1>
			<a href="/" style="color: black;"> <img src="/Image/mainLogo.png" width="250px;">
			</a>
		</h1>
	</div>
	<!-- 따라다니는 메뉴 -->
	<div class="ui inverted large top fixed hidden menu">
		<div class="ui container">
			<a class="item" href="/">홈</a>
			<!-- 예약 메뉴  -->
			<div class="ui dropdown item">
				예약 <i class="dropdown icon"></i>
				<div class="menu">
					<a class="item" href="/reservationGuide">예약 안내</a>
					<!-- 지은 : 예약안내 주소 추가 -->
					<a class="item" href="/reservationFirstStep">실시간 예약</a>
				</div>
			</div>
			<!-- 예약 메뉴 끝-->

			<!--<div class="ui dropdown item">
				고객센터 <i class="dropdown icon"></i>
				<div class="menu">
					<a class="item">공지사항</a>
					<a class="item">자주 묻는 질문</a>
					<a class="item">후기 게시판</a>
				</div>
			</div>-->

			<a class="item wholemenu">더보기</a>
			<div class="right menu">
				<div class="item" style="padding-left: 0px">
					<a class="ui inverted blue button loginBtn" href="/loginpage">로그인</a>
				</div>
				<div class="item" style="padding-right: 30px; padding-left: 0px">
					<a class="ui inverted red button signupBtn" href="/termsagreement">회원가입</a>
				</div>
			</div>
		</div>
	</div>
	<!-- 따라다니는 메뉴 끝-->

	<!-- 사이드 메뉴 -->
	<div class="ui vertical inverted sidebar menu">
		<a class="item" href="/">홈</a>
		<br>
		<a class="item" href="/psIntroduce">펜션소개</a> <a class="item" href="/roomIntroduce">객실 안내</a> <a class="item" href="/reservationGuide">예약 안내</a>
		<!-- 지은 : 예약안내 주소 추가 -->
		<a class="item" href="/reservationFirstStep">실시간 예약</a>
		<br>

		<a class="item" href="/board">공지사항</a>
		<a class="item" href="/faq">자주 묻는 질문</a>
		<a class="item" href="/review">후기 게시판</a>
		<a class="item" href="/questionmove">1:1 문의</a>

		<br>
		<a class="item" href="/location">오시는 길</a>
		<br>
		<a class="item loginBtn" href="/loginpage">로그인</a> <a class="item signupBtn" href="/termsagreement">회원가입</a>
	</div>
	<!-- 사이드 메뉴 끝 -->

	<!-- 메뉴 -->
	<div class="ui inverted vertical center aligned segment" style="padding-top: 3px; padding-bottom: 5px;">
		<div class="ui container">
			<div class="ui large secondary inverted pointing menu">
				<a class="toc item"> <i class="sidebar icon"></i>
				</a>
				<!--<a class="item wholemenu">전체 메뉴</a>-->
				<a class="item" href="/">홈</a> <a class="item" href="/psIntroduce">펜션소개</a> <a class="item" href="/roomIntroduce">객실 안내</a>

				<!-- 예약 메뉴  -->
				<div class="ui dropdown item">
					예약 <i class="dropdown icon"></i>
					<div class="menu">
						<a class="item" href="/reservationGuide">예약 안내</a>
						<!-- 지은 : 예약안내 주소 추가 -->
						<a class="item" href="/reservationFirstStep">실시간 예약</a>
					</div>
				</div>
				<!-- 예약 메뉴 끝-->

				<!-- 고객센터 메뉴  -->
				<div class="ui dropdown item">
					고객센터 <i class="dropdown icon"></i>
					<div class="menu">
						<a class="item" href="/board">공지사항</a>
						<a class="item" href="/faq">자주 묻는 질문</a>
						<a class="item" href="/questionmove">1:1 문의</a>
						<a class="item" href="/review">후기 게시판</a>
					</div>
				</div>
				<!-- 고객센터 메뉴 끝-->

				<a class="item" href="/location">오시는 길</a>
				<div class="right item">
					<a class="ui inverted blue button loginBtn" href="/loginpage">로그인</a> <a class="ui inverted red button signupBtn" href="/termsagreement" id="btnMargin">회원가입</a>
				</div>
			</div>
		</div>
	</div>
	<!-- 메뉴 끝 -->

	<!-- 마우스 우클릭 방지-->
	<script type="text/javascript">
		document.addEventListener('mousedown', function() {
			if ((event.button == 2) || (event.which == 3)) {
				alert('마우스 오른쪽 버튼은 사용 불가능 합니다');
			}
		});
	</script>
	<script type="text/javascript">
		window.onload = function() {
			$('#load').hide();
		}

		/* 드롭 다운 메뉴 */
		$('.ui.dropdown.item').dropdown();

		/* 메뉴 hover */
		$('.ui.menu a.item').on('mouseenter', function() {
			$(this).addClass('active');
		}).on('mouseleave', function() {
			$(this).removeClass('active');
		});

		$('.wholemenu').click(function() {
			$('.ui.sidebar').sidebar('toggle');
		});
	</script>