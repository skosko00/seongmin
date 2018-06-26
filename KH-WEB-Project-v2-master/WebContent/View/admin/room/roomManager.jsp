<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*,jsp.reservation.model.vo.*"%>
<jsp:include page="/View/main/layout/preventurl.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<!-- 2018-06-14 -->
<!-- 1. 일단은 디비를 바꾸기 전  -->
<!--  -->
<%
@SuppressWarnings("all")
ArrayList<PensionVo> list = (ArrayList<PensionVo>) request.getAttribute("roomlist");
%>
<head>
	<jsp:include page="/View/main/layout/cssjs.jsp"></jsp:include>
	<title>관리자</title>
</head>
<body>
	<!--  a 태그들은 나중에 서블릿을 만들어야 한다. -->
	<!-- 
	1. 객실 리스트 불러오기
	2. 페이징 처리 (x) -> 호텔이 아닌 이상에는 방이 많지는 않을 것
	3. 어떤 기능을 
-->
<!-- 메뉴 바 -->
<jsp:include page="/View/admin/layout/sideMenu.jsp"></jsp:include>
<!-- 이 부분이 본문 -->
<div class="ui pusher">
	<!-- 헤더 부분  -->
	<div class="ui segment">
		<h3 class="ui header">객실 관리</h3>
	</div>
	<!-- 헤더 끝  -->
	<!-- 본문 내용 시작-->
	<div class="ui container">
		<!-- 테이블 시작 -->
		<!-- 일단은 이 부분에서 데이터를 가져오도록 해보자.-->
		<!-- 객실 리스트를 가져오자. -->
		<h1>객실 리스트</h1>
		<div class="ui red message"><div class="ui small header">※ 객실 정보를 보려면 해당 객실에 해당 하는 상세보기 버튼을 클릭하고<br>객실을 추가하려면 아래 객실 추가 버튼을 클릭하세요</div></div>
		<table class="ui celled table">
			<thead>
				<tr align="center">
					<th>객실명</th>
					<th>기준인원</th>
					<th>최대인원</th>
					<th>주말요금(단위 원)</th>
					<th>주중요금(단위 원)</th>
					<th>추가요금(단위 원)</th>
					<th>상세보기</th>
				</tr>
			</thead>
			<!--  객실 관리   -->
			<!--  이 부분에 추가  -->

			<tbody>
					<!--  
		    <tr>
		      <td>Cell</td>
		      <td>Cell</td>
		      <td>Cell</td>
		      <td>Cell</td>
		      <td>Cell</td>
		      <td>Cell</td>
		      <td>Cell</td>
		      <td><button>상세보기</button></td>
		    </tr>
		-->
		<!--  TODO : 이부분을 나중에는 JSTL로 고쳐야 한다. -->
		<%
		if (list != null && !list.isEmpty()) {
		%>
		<%
		for (PensionVo p : list) {
		%>
		<tr align="center">
			<!-- 객실 정보 -->

			<td><div class="ui small header"><%=p.getPsName()%></div></td>
			<td><div class="ui small header"><%=p.getPsPersonnel()%></div></td>
			<td><div class="ui small header"><%=p.getPsMaxPersonnel()%></div></td>
			<!-- 요금 정보 -->
			<td><div class="ui small header"><%=p.getPsWeekend()%></div></td>
			<td><div class="ui small header"><%=p.getPsWeekday()%></div></td>
			<td><div class="ui small header"><%=p.getPsAddtionalPrice()%></div></td>
			<!-- 상세보기 버튼 -->
			<!--  이 부분은 나중에... -->
						<%-- <td>
							<button class="ui button" onclick="detailView('<%=p.getPsName()%>');">상세보기</button>
						</td> --%>
						<td>
							<form method="post" action="/adminRoomDetail">
								<input type="hidden" name="psName" value="<%= p.getPsName()%>">
								<input type="submit" class="ui orange button " value="상세보기" >
							</form>
						</td>
					</tr>
					<%
				}
				%>
				<%
			} else {
			%>
			<%
		}
		%>
	</tbody>
	<!--  페이지 처리를 하는 부분. -->

				<!-- <tfoot>
		    <tr>
		    <th colspan="3">
		      <div class="ui right floated pagination menu">
		        <a class="icon item">
		          <i class="left chevron icon"></i>
		        </a>
		        <a class="item">1</a>
		        <a class="item">2</a>
		        <a class="item">3</a>
		        <a class="item">4</a>
		        <a class="icon item">
		          <i class="right chevron icon"></i>
		        </a>
		      </div>
		    </th>
		  </tr>
		</tfoot> -->
	</table>

	<div class="ui blue button">
		<a style="color:white;" href="/View/admin/room/roomResist.jsp">객실 추가</a>
	</div>

	<!--  테이블 끝 -->
</div>
<!-- 본문 내용 끝  -->
</div>

<script>
	$(document).ready(function() {
		$('.visible.example .ui.sidebar').sidebar({
			context : '.visible.example .bottom.segment'
		}).sidebar('hide');
	});
</script>
</body>
</html>
