<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*,jsp.admin.model.vo.*"%>
<jsp:include page="/View/main/layout/preventurl.jsp"></jsp:include>
<%
LoginLogPageVo llpv = (LoginLogPageVo) request.getAttribute("allMemberLog");
	String searchData = request.getParameter("searchData");
	String searchOption = request.getParameter("searchOption");
%>
<!DOCTYPE html>
<html>

<head>

	<!-- Global site tag (gtag.js) - Google Analytics -->
	<script async
	src="https://www.googletagmanager.com/gtag/js?id=UA-120156974-1"></script>
	<script>
		window.dataLayer = window.dataLayer || [];
		function gtag() {
			dataLayer.push(arguments);
		}
		gtag('js', new Date());
		gtag('config', 'UA-120156974-1');
	</script>

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
			<h3 class="ui header">회원 로그 내역</h3>
		</div>
		<!-- 본문 내용 시작-->
		<div class="ui container">
			<!-- 테이블 시작 -->
			<div class="ui red message"><div class="ui small header">※ 회원들의 로그인 접속 기록 목록입니다<br>다운로드 버튼 클릭 시 엑셀 파일로 목록이 다운로드 됩니다</div></div>
			<h1>회원 로그인 내역</h1>

			<form  action="/adminMemberLog" method="post"
			style="display: inline;">
			<select class="ui dropdown" name="searchOption">
				<% if(searchOption==null||searchOption.equals("MB_LOG_ID")){ %>
				<option value="MB_LOG_ID" selected="selected">아이디</option>
				<option value="MB_LOG_IP" >주소</option>			
				<%}else{%>
				<option value="MB_LOG_ID" >아이디</option>
				<option value="MB_LOG_IP" selected="selected">주소</option>	
				<% } %>
			</select> 
			<div class="ui input">
				<input type="text" name="searchData" 
				<%if(searchData != null){ %>
				value=<%=searchData %>
				<% }%> >
			</div>
			<input type="submit" value="검색" style="margin-left: 10px;" class="ui blue button">
		</form>
		<form  method="post" action="/memberLogListDown" style="display:inline" >
			<input class="ui orange button" type="submit" value="다운로드">
		</form>
		<table class="ui celled table">
			<thead>
				<tr align="center">
					<th>회원 아아디</th>
					<th>로그인 시간</th>
					<th>접속 브라우저</th>
					<th>접속 아이피</th>
					<th>접속 지역</th>
				</tr>
			</thead>
			<!--  객실 관리   -->
			<!--  이 부분에 추가  -->
			<% if(llpv != null){
			ArrayList<MemberLoginLogVo> mlist = llpv.getList();
			 	String pageNavi = llpv.getPageNavi();	// navi 리스트 
			 	
			 	%>

			 	<tbody>
			 		<%if( mlist != null && !mlist.isEmpty()){ %>
			 		<%for(MemberLoginLogVo mllv : mlist){ %>
			 		<tr align="center">
			 			<td><div class="ui small header"><%= mllv.getMbLogId() %></div></td>
			 			<td><div class="ui small header"><%= mllv.getMbLogTime() %></div></td>
			 			<td><div class="ui small header"><%= mllv.getMbLogBrowser() %></div></td>
			 			<td><div class="ui small header"><%= mllv.getMbLogIp() %></div></td>
			 			<td><div class="ui small header"><%= mllv.getMbLogLocale() %></div></td>
			 			<!--  성별을 남여로  -->
			 		</tr>
			 		<%} %>

			 	</tbody>
			 	<tfoot>
			 		<tr>
			 			<th colspan="5">
			 				<div class="ui basic segment">
			 					<%= pageNavi %>
			 				</div>
			 			</th>
			 		</tr>
			 	</tfoot>
			 </table>

			 <% }else{ %>
			 <hr />
			 <h3>기록이 없습니다.</h3>
			 <hr />
			 <% } %>
			 <% } %>
			</div>
			<!-- 본문 내용 끝  -->
		</div>

		<script>
		</script>
		</html>