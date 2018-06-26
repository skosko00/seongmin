<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*,jsp.admin.model.vo.*,jsp.reservation.model.vo.*" %>
<jsp:include page="/View/main/layout/preventurl.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/View/main/layout/cssjs.jsp"></jsp:include>
	<title>관리자</title>
</head>
<body>

	<jsp:include page="/View/admin/layout/sideMenu.jsp"></jsp:include>
	<!-- 메뉴 끝  -->
	<!-- 본문 내용 시작 -->
	<div class="ui pusher">

		<!-- 헤더 부분  -->
		<div class="ui segment">
			<h3 class="ui header">예약 관리</h3>
		</div>
		<!-- 본문 내용 시작-->
		<div class="ui container">
			<!-- 테이블 시작 -->
			<h1>예약 정보</h1>
			<%
			ReservationVo rpv = (ReservationVo)request.getAttribute("reservationInfo");
			
			%> 	
			<table class="ui celled table">
				<thead>
					<tr>
						<th>예약번호</th>
						<th>객실이름</th>
						<th>아이디</th>
						<th>예약인원</th>
						<th>입실일</th>
						<th>퇴실일</th>
						<th>요금</th>
						
						<!-- 상세보기를 넣을까? -->
						<!-- <th>블랙 리스트 선정</th> -->
					</tr>
				</thead>
				<!--  객실 관리   -->
				<!--  이 부분에 추가  -->
				
				<tbody>
					<%	if(rpv != null){	 %>
					<tr>
						<td><%= rpv.getResNo() %></td>
						<td><%= rpv.getResRoomName() %></td>
						<td><%= rpv.getResId() %></td>
						<td><%= rpv.getResPersonnel() %></td>
						<td><%= rpv.getResInDate()%></td>
						<td><%= rpv.getResOutDate() %></td>
						<td><%= rpv.getResPrice() %></td>
					</tr>
				</tbody>
				
			</table>

			<% }else{ %>
			<hr/>
			<h3>예약 정보가 없습니다.</h3>
			<hr/>
			<% } %>
		</div>
		<!-- 본문 내용 끝  -->
	</div>

	<script>
		$(document).ready(function(){
			$('.visible.example .ui.sidebar')
			.sidebar({
				context: '.visible.example .bottom.segment'
			})
			.sidebar('hide');
		});
	</script>
</body>
</html>
