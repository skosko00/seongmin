<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*,jsp.admin.model.vo.*,jsp.reservation.model.vo.*" %>
<jsp:include page="/View/main/layout/preventurl.jsp"></jsp:include>
<%
SalesPageVo spv = (SalesPageVo)request.getAttribute("SalesPage");
String searchData = request.getParameter("searchData"); 
String searchOption = request.getParameter("searchOption");
%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/View/main/layout/cssjs.jsp"></jsp:include>
	<title>관리자</title>
</head>
<body>
	<!--  a 태그들은 나중에 서블릿을 만들어야 한다. -->
<!--  
	1. 매출 통계 어떻게 보여줄것인가?
		- 일단은 테이블로 나타내자.
		- 예약 번호, 객실코드, 아이디, 예약인원,요금... -> 모든 것을 나타낸느 것이 나은가?
	2. 통계를 낼때 어느것을 기준으로 값을 매겨야 하나?
	3. 엑셀 기능 추가
	
-->
<!-- 메뉴 바 -->
<jsp:include page="/View/admin/layout/sideMenu.jsp"></jsp:include>
<!-- 이 부분이 본문 -->
<div class="ui pusher">
	<!-- 헤더 부분  -->
	<div class="ui segment">
		<h3 class="ui header">매출 현황</h3>
	</div>
	<!-- 본문 내용 시작-->
	<div class="ui container">
		<!-- 테이블 시작 -->
		<div class="ui red message"><div class="ui small header">※ 펜션 매출을 확인 할 수 있습니다<br>다운로드 버튼 클릭 시 엑셀 파일로 목록이 다운로드 됩니다</div></div>
		<h1>매출 현황</h1>
		<form  action="/adminSalesManager" method="post" style="display: inline;">
			<select class="ui dropdown" name="searchOption">
				<% if(searchOption==null||searchOption.equals("SALES_ID")){ %>
				<option value="SALES_ID" selected="selected">아이디</option>
				<option value="SALES_RESERVATION_NO">에약번호</option>
				<%}else{%>
				<option value="SALES_ID" >아이디</option>
				<option value="SALES_RESERVATION_NO" selected="selected">에약번호</option>
				<% } %>
			</select>
			<div class="ui input">
				<input type="text" name="searchData" 
				<%if(searchData != null){ %>
				value=<%=searchData %>
				<% }%>
				>
			</div>
			<input type="submit" value="검색" class="ui blue button" style="margin-left: 10px;">
		</form>
		<form  method="post" action="/salesListDown" style="display:inline" >
			<input class="ui orange button" type="submit" value="다운로드">
		</form>
		<table class="ui celled table">
			<thead>
				<tr align="center">
					<th>매출번호</th>
					<th>아이디</th>
					<th>입금금액</th>
					<th>예약번호</th>

				</tr>
			</thead>
			<!--  객실 관리   -->
			<!--  이 부분에 추가  -->
			<%if(spv != null){
			ArrayList<SalesVo> slist = spv.getList();
			 	String pageNavi = spv.getPageNavi();	// navi 리스트 
			 	%> 
			 	<tbody>

			 		<%if(slist != null && !slist.isEmpty()){ %>
			 		<%for(SalesVo s : slist){ %>
			 		<tr align="center">
			 			<td><div class="ui small header"><%= s.getSalesNo() %></div></td>
			 			<td><div class="ui small header"><%= s.getSalesId() %></div></td>
			 			<td><div class="ui small header"><%= s.getSalesPaymentPrice() %></div></td>
			 			<td><div class="ui small header"><%= s.getSalesReservationNo() %></div></td>

			 		</tr>
			 		<%} %>
			 		<%} %>
			 	</tbody>
			 	<tfoot>
			 		<tr>
			 			<th colspan="4">
			 				<div class="ui segment">
			 					<%= pageNavi %>
			 				</div>
			 			</th>
			 		</tr>
			 	</tfoot>
			 </table>
			 <%} %>
			</div>
			<!-- 본문 내용 끝  -->
		</div>

		<script>
			$(document).ready(function(){
				$('.visible.example .ui.sidebar')
				.sidebar({
					context: '.visible.example .bottom.segment'
				})
				.sidebar('hide')
				;
			});
		</script>
	</body>
	</html>
