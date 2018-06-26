<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/View/main/layout/preventurl.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/View/main/layout/cssjs.jsp"></jsp:include>
	<title>관리자</title>
</head>
<body>
<!--
	// 일단은 이 부분은 나중에 작성.. 일단은 회원 정보를 불러오는 정도로만.
	 해야 할 일
	1. 목록 불러오기
	2. 페이징 처리
	3. 블랙 리스트 처리...
	4. 회원 상세 보기 -> 회원 정보를 상세하게 보기...// 다른 페이지 가 필요한가?
	// 아니면 팝업으로...
	5. 엑셀로 출력...
	
-->

<!-- 메뉴 바 -->
<jsp:include page="/View/admin/layout/sideMenu.jsp"></jsp:include>
<!-- 이 부분이 본문 -->
<div class="ui pusher">
	<!-- 헤더 부분  -->
	<div class="ui segment">
		<h3 class="ui header">블랙리스트 관리</h3>
	</div>
	<!-- 본문 내용 시작-->
	<div class="ui container">
		<!-- 테이블 시작 -->
		<h1>블랙리스트</h1>
		<table class="ui celled table">
			
			<thead>
				<tr>
					<th>아이디</th>
					<th>생년월일</th>
					<th>이메일</th>
					<th>휴대폰 번호</th>
					<th>성별</th>
					<th>이름</th>
					<th>가입일</th>
					<th>주소</th>
					<!-- <th>블랙 리스트 선정</th> -->
				</tr>
			</thead>
			<!--  객실 관리   -->
			<!--  이 부분에 추가  -->
			
			<tbody>
				<tr>
					<td>Cell</td>
					<td>Cell</td>
					<td>Cell</td>
					<td>Cell</td>
					<td>Cell</td>
					<td>Cell</td>
					<td>Cell</td>
					<td>Cell</td>
				</tr>
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
	
	
	<!--  테이블 끝 -->
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
