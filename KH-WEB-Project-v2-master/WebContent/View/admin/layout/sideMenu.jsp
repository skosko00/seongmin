<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/View/main/layout/preventurl.jsp"></jsp:include>
<!-- 나중에 이 부분에서 몇가지는  -->
<div class="ui visible inverted left vertical thin sidebar menu">
	<!-- 1. 홈 메뉴 바  -->
	<!--  이 부분이 약간은 복잡 -->
	<a class="item" href="/adminIndex">
		관리자 메인
		<i class="home icon"></i>
	</a>
	<!-- TODO: 메인 탬플릿 관리...  -->
	<div class="item">메인 
		<i class="home iternate icon"></i>
		<div class="menu dropdown">
			<!--  -->
			<a class="item" href="/adminTemplateManager">탬플릿 관리</a>
		</div>
	</div>
	<!-- 2. 객실 관리 메뉴바  -->
	<div class="item">객실
		<i class="building iternate icon"></i>
		<div class="menu dropdown">

			<a class="item" href="/adminRoomManager">객실관리</a>
			<a class="item" href="/View/admin/room/roomResist.jsp">객실 등록</a>
			<!-- <a class="item" href="">서비스 등록</a> -->
		</div>
	</div>
	<!-- 3. 예약 관리 메뉴바  -->
	<!-- 무통장 입금등을 관리를 해야한다. -->
	<!--  일단은 보류  -->
	<div class="item">예약
		<i class="calendar iternate icon"></i>
		<div class="menu dropdown">
			<a class="ui simple item" href="/adminReserveManager">예약 관리</a>
			<a class="ui simple item" href="/adminReserveCalendar">달력으로 보기</a>
			<a class="ui simple item" href="/adminReserveCancel">예약 취소 요청</a> <!-- 지은 추가 -->
			<a class="ui simple item" href="/adminReserveHistory">지난 예약 보기</a> <!-- 지은 추가 -->
		</div>
	</div>
	<!-- 4. 회원 관리 메뉴바  -->
	<!--  일단은  -->
	<div class="item">회원
		<i class="user iternate icon"></i>
		<div class="menu dropdown">
			<a class="ui simple item" href="/adminMemberList">회원 관리</a>
			<a class="ui simple item" href="/adminMemberLog">회원 로그 내역 </a>
		</div>
	</div>
	<!-- 5. -->
	<div class="item">게시판
		<i class="clipboard iternate icon"></i>
		<div class="menu dropdown">
			<a class="ui simple item" href="/adminBoardList">공지사항 관리</a>
			<a class="ui simple item" href="/adminQuestionList"> 1 : 1 문의</a>
		</div>
	</div>
	<!-- 6.  -->
<!-- 	<div class="item">매출
		<i class="chart bar icon"></i>
		<div class="menu dropdown">
			<a class="ui simple item" href="/adminSalesManager">매출 현황</a>

		</div>
	</div> -->
	<a class="item" href="/">
		메인으로
		<i class="sign out iternate icon"></i>
	</a>

</div>