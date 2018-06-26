<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page errorPage="/View/error/error.jsp"%>

<%@page import="jsp.reservation.model.vo.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jsp.member.model.vo.*"%>
<%@page import="jsp.main.model.vo.*"%>


<%
@SuppressWarnings("all")
ArrayList<PensionVo> pvList = (ArrayList<PensionVo>)request.getAttribute("pensionInfoList");
DescriptionTb desList = (DescriptionTb)request.getAttribute("descriptionInfo");
@SuppressWarnings("all")
ArrayList<PensionPicTb> picList = (ArrayList<PensionPicTb>)request.getAttribute("pensionRoomPic");
%>


<!DOCTYPE html>
<html>

<head>
	<!-- Global site tag (gtag.js) - Google Analytics -->
	<script async src="https://www.googletagmanager.com/gtag/js?id=UA-120156974-1"></script>
	<script>
		window.dataLayer = window.dataLayer || [];
		function gtag() {
			dataLayer.push(arguments);
		}
		gtag('js', new Date());
		gtag('config', 'UA-120156974-1');
	</script>
	<jsp:include page="/View/main/layout/cssjs.jsp"></jsp:include>
	<title>예약 안내</title>
</head>

<style>
</style>

<body>
	
	<!-- 헤더 시작  -->
	<jsp:include page="/View/main/layout/header.jsp"></jsp:include>
	<!-- 헤더 끝 -->

	<!-- 본문 시작 -->
	<br>
	<div class="ui container">


		<div class="ui icon message">
			<i class="info icon"></i>
			<div class="content">
				<div class="header" style="text-align: center;">
					<h1>
						예약 안내
					</h1>
				</div>
			</div>
		</div>

		<!-- 이부분 추가했습니당 : 지은  -->

		<div class="ui one column grid">
			<div class="column">
				<div class="ui basic segment" align="center">
					<table class="ui celled table" id="calendar" border="0" align="center">
						<thead>
							<tr align="center">
								<th colspan="2" style="color:red;"><div class="ui medium header" style="color:red;">예약 전 꼭 확인 부탁드립니다.</div></th>
							</tr>
						</thead>
						<tbody>
							<tr align="center">
								<td width="20%"><div class="ui small header">예약 시 주의사항</div></td>
								<td><%=desList.getDesAttention()%></td>
							</tr>
							<tr align="center">
								<td width="20%"><div class="ui small header">예약 취소 시 주의사항</div></td>
								<td><%=desList.getDesRefund()%></td>
							</tr>
							<tr align="center">
								<td width="20%"><div class="ui small header">환불 관련 주의사항</div></td>
								<td><%=desList.getDesAccount()%></td>
							</tr>
							<tr align="center">
								<td width="20%"><div class="ui small header">기타 안내사항</div></td>
								<td><%=desList.getDesEtc()%></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>



		<div class="ui two column grid">

			<% for(PensionPicTb pic : picList) {%>
			<div class="column">
				<div class="ui segment" align="center">

					<img src=<%=pic.getPsPicPath()%> height="100%" width="100%"/>
					<br>

					<table class="ui table" id="calendar" border="0" align="center">
						<thead>
							<tr align="center">
								<th colspan="4"><%=pic.getpsPicName()%></th>
							</tr>
						</thead>
					<% for(PensionVo pv : pvList) { // 같은 방 정보만 가져오기
					if(pv.getPsName().equals(pic.getpsPicName())) { %>
					<tbody>
						<tr align="center">
							<td>기준인원</td>
							<td><%=pv.getPsPersonnel()%></td>
							<td>최대인원</td>
							<td><%=pv.getPsMaxPersonnel()%></td>
						</tr>
					</tbody>
				</table>
				
				<table class="ui table" id="calendar" border="0" align="center">
					<thead>
						<tr align="center">
							<th colspan="4">요금안내</th>
						</tr>
					</thead>
					<tbody>
						<tr align="center">
							<td colspan="2">평일요금(1박)</td>
							<td colspan="2"><%=pv.getPsWeekday()%>원</td>
						</tr>
						<tr align="center">
							<td colspan="2">주말요금(1박)</td>
							<td colspan="2"><%=pv.getPsWeekend()%>원</td>
						</tr>
						<tr align="center">
							<td colspan="2">추가요금(1인)</td>
							<td colspan="2"><%=pv.getPsAddtionalPrice()%>원</td>
						</tr>
						<tr align="center">
							<td colspan="4">
								기준인원을 초과하는 1인마다 추가요금이 부가됩니다.<br>
								각 방의 최대인원을 초과하는 인원이 숙박할 수는 없습니다.
							</td>
						</tr>
					</tbody>
				</table>


				<button class="ui blue button" onclick="location.href='/reservationFirstStep'">예약하기</button>

				<% }  } %>
			</div>
		</div>
		<% } %>

	</div>
</div>
<!-- 본문 끝 -->

<!-- 푸터 시작  -->
<jsp:include page="/View/main/layout/footer.jsp"></jsp:include>
<!-- 푸터 끝 -->
</body>

<script>
	
</script>

</html>
