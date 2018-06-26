<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*,jsp.admin.model.vo.*,jsp.member.model.vo.*" %>
<jsp:include page="/View/main/layout/preventurl.jsp"></jsp:include>
<%
MemberPageVo mpv = (MemberPageVo) request.getAttribute("MemberPage");
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

	<!-- 메뉴 바 -->
	<jsp:include page="/View/admin/layout/sideMenu.jsp"></jsp:include>
	<!-- 이 부분이 본문 -->
	<div class="ui pusher">
		<!-- 헤더 부분  -->
		<div class="ui segment">
			<h3 class="ui header">회원 관리</h3>
		</div>
		<!-- 본문 내용 시작-->
		<div class="ui container">
			<!-- 테이블 시작 -->
			<div class="ui red message"><div class="ui small header">※ 현재 가입중인 회원 목록입니다<br>네이버로 로그인한 회원은 주소에 네이버회원으로 표시됩니다<br>다운로드 버튼 클릭 시 엑셀 파일로 목록이 다운로드 됩니다</div></div>
			<h1>회원 리스트</h1>
			
			<form action="/adminMemberList" method="post" style="display: inline;">
				<select class="ui dropdown" name="searchOption">
					<% if(searchOption==null||searchOption.equals("MB_ID")){ %>
					<option value="MB_ID" selected="selected">아이디</option>
					<option value="MB_ADDRESS">주소</option>
					<option value="MB_NAME">이름</option>
					<%}else if(searchOption.equals("MB_ADDRESS")){%>
					<option value="MB_ID" >아이디</option>
					<option value="MB_ADDRESS" selected="selected">주소</option>
					<option value="MB_NAME">이름</option>
					<%}else{%>
					<option value="MB_ID" selected="selected">아이디</option>
					<option value="MB_ADDRESS">주소</option>
					<option value="MB_NAME" selected="selected">이름</option>
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
			<form  method="post" action="/memberListDown" style="display:inline" >
				<input class="ui orange button" type="submit" value="다운로드">
			</form>
			<table class="ui celled table">
				<thead>
					<tr align="center">
						<th>아이디</th>
						<th>이름</th>
						<th>생년월일</th>
						<th>이메일</th>
						<th>휴대폰 번호</th>
						<th>성별</th>
						<th>가입일</th>
						<th>주소</th>
						<!-- 상세보기를 넣을까? -->
						<!-- <th>블랙 리스트 선정</th> -->
					</tr>
				</thead>
				<!--  객실 관리   -->
				<!--  이 부분에 추가  -->

				<% 
				if(mpv != null){
				ArrayList<MemberVo> mlist = mpv.getList();
			 	String pageNavi = mpv.getPageNavi();	// navi 리스트 
			 	
			 	%> 	
			 	<tbody>
			 		<%if(mlist != null && !mlist.isEmpty()){ %>
			 		<%for(MemberVo m : mlist){ %>
			 		<tr align="center">
			 			<td><div class="ui small header"><%= m.getMbId() %></div></td>
			 			<td><div class="ui small header"><%= m.getMbName() %></div></td>
			 			<td><div class="ui small header"><%= m.getMbBirth() %></div></td>
			 			<td><div class="ui small header"><%= m.getMbEmail() %></div></td>
			 			<td><div class="ui small header"><%= m.getMbPhone() %></div></td>
			 			<!--  성별을 남여로  -->
			 			<td><div class="ui small header"><%= m.getMbGender() %></div></td>
			 			<td><div class="ui small header"><%= m.getMbEntDate() %></div></td>
			 			<td style="text-align: left"><div class="ui small header"><%= m.getMbAddress() %></div></td>
			 		</tr>
			 		<%} %>
			 		<%} %>
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
			 	<% }%>
			 	
			 	
			 	
			 	
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
