<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page errorPage="/View/error/error.jsp"%>
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
	<title>마이페이지</title>
</head>

<style>
#containerCenter {
	margin-top: 80px;
	margin-bottom: 80px;
}
</style>

<body>
	<!-- 헤더 시작  -->
	<jsp:include page="/View/main/layout/header.jsp"></jsp:include>
	<!-- 헤더 끝 -->

	<div class="ui container" id="containerCenter">
		<div class="ui icon message">
			<i class="address book outline icon"></i>
			<div class="content">
				<div class="header" style="text-align: center">
					<h1>
						마이페이지
					</h1>
				</div>
			</div>
		</div>
		<br>
		<form action="/myPage" method="post">
			<table class="ui table centered grid" style="padding-top: 50px; padding-bottom: 50px;">
				<tr>
					<td>
						<div class="ui icon red message">
							<i class="lock icon"></i>
							<div class="content">
								<div class="header">
									※ 개인정보 보호를 위해 비밀번호를 입력해주세요<br>
									<br>(네이버로 로그인한 회원은 생일을 입력해주세요<br>
									ex. 생년월일이 900101일 경우 0101 입력)
								</div>
							</div>
						</div>
					</tr>
					<tr>
						<td>
							<br>
							<div class="ui input">
								<input type="password" name="pwd" id="pwd" placeholder="비밀번호 입력" maxlength="16">
								<input type="hidden" name="idTest" value="${sessionScope.member.mbId}" >
							</div>
						</td>
					</tr>
				</table>
				<div class="ui centered grid">
					<input type="submit" class="ui blue button" value="입력완료" onclick="return myPageRequest();" style="margin-right: 5px;">
					<button type="button" class="ui orange button" id="back" style="margin-left: 5px;">뒤로가기</button>
				</div>
			</form>

		</div>
		<!-- 본문 끝 -->

		<!-- 푸터 시작  -->
		<jsp:include page="/View/main/layout/footer.jsp"></jsp:include>
		<!-- 푸터 끝 -->
	</body>

	<!-- 비밀번호 공백 일 경우 -->
	<div class="ui mini modal" id="blankPwdModal">
		<div class="header">비밀번호 입력</div>
		<div class="content">
			<p>비밀번호를 입력해주세요</p>
		</div>
		<div class="actions">
			<div class="ui blue cancel button" id="termsModal">확인</div>
		</div>
	</div>

	<script>
		$(document).ready(function() {
			$('#back').click(function() {
				history.back(-1);
			})
		});

		function myPageRequest() {
			if ($('#pwd').val() == "") {
				$('#blankPwdModal').modal('show');
				return false;
			}
		}
	</script>

	</html>
