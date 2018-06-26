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
	<div class="ui pusher">
		<!-- 헤더 부분  -->
		<div class="ui segment">
			<h3 class="ui header">예약 관리</h3>
		</div>
		<!-- 본문 내용 시작-->
		<div class="ui container">
			<div class="ui red message"><div class="ui small header">※ 펜션을 현재 예약한 회원들의 정보입니다<br>예약 취소 버튼 클릭 시 해당 예약이 취소 됩니다.<br>다운로드 버튼 클릭 시 엑셀 파일로 목록이 다운로드 됩니다</div></div>
			<!-- 테이블 시작 -->
			<h1>예약 목록</h1>
			<%
			ReservePageVo rpv = (ReservePageVo)request.getAttribute("ReservePage");
			String searchData = request.getParameter("searchData");
			String searchOption = request.getParameter("searchOption");
			%> 	
			
			<form action="/adminReserveManager" method="post" style="display: inline;">
				<select class="ui dropdown" name="searchOption">
					<% if(searchOption==null||searchOption.equals("RES_ROOM_NAME")){ %>
					<option value="RES_ROOM_NAME" selected="selected">객실이름</option>
					<option value="RES_ID">아이디</option>
					<%}else{%>
					<option value="RES_ROOM_NAME">객실이름</option>
					<option value="RES_ID" selected="selected">아이디</option>
					<%} %>
				</select>
				<div class="ui input">	
					<input type="text" name="searchData" <% if(searchData != null){ %> value=<%=searchData %> <% }%>>
				</div>
				<input type="submit" class="ui blue button" value="검색" style="margin-left: 10px;">
				
			</form>
			<form  method="post" action="/reservationListDown" style="display:inline" >
				<input class="ui orange button" type="submit" value="다운로드">
			</form>
			<table class="ui celled table">
				<thead>
					<tr align="center">
						<th>예약번호</th>
						<th>객실이름</th>
						<th>아이디</th>
						<th>예약인원</th>
						<th>입실일</th>
						<th>퇴실일</th>
						<th>요금(단위 원)</th>
						<th>예약 취소</th>
						<!-- 상세보기를 넣을까? -->
						<!-- <th>블랙 리스트 선정</th> -->
					</tr>
				</thead>
				<!--  객실 관리   -->
				<!--  이 부분에 추가  -->
				
				<tbody>
					<%
					if(rpv != null){
					ArrayList<ReservationVo> rlist = rpv.getList();
		 	String pageNavi = rpv.getPageNavi();	// navi 리스트 
		 	if(rlist != null && !rlist.isEmpty()){ %>
		 	<%for(ReservationVo r : rlist){ %>
		 	<tr align="center">
		 		<td><div class="ui small header"><%= r.getResNo() %></div></td>
		 		<td><div class="ui small header"><%= r.getResRoomName() %></div></td>
		 		<td><div class="ui small header"><%= r.getResId() %></div></td>
		 		<td><div class="ui small header"><%= r.getResPersonnel() %></div></td>
		 		<td><div class="ui small header"><%= r.getResInDate()%></div></td>
		 		<td><div class="ui small header"><%= r.getResOutDate() %></div></td>
		 		<td><div class="ui small header"><%= r.getResPrice() %></div></td>
		 		<td><button class="ui red button" value="<%=r.getResNo()%>">예약취소</button></td>
		 	</tr>
		 	<%} %>
		 	<%} %>
		 </tbody>
		 <!--  페이지 처리를 하는 부분. -->

		 <tfoot>
		 	<tr>
		 		<th colspan="8">
		 			<div class="ui basic segment">
		 				<%= pageNavi %>
		 			</div>
		 		</th>
		 	</tr>
		 </tfoot>
		</table>

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
	})

	$('td>button').click(function() {
		
		var resNo = $(this).attr('value');
		
		$.ajax({
			url : '/reservationCancelCall',
			data : { res_no : resNo },
			type : 'get',
			success : function() {
				alert("예약 취소가 접수되었습니다.");
				window.location.reload();
			},
			error : function() {
				console.log("cancelCall:실패");
			}
		});
	})
</script>
</body>
</html>
