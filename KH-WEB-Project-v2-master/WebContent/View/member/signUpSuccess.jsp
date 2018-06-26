<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page errorPage="/View/error/error.jsp"%>
<jsp:include page="/View/main/layout/preventurl.jsp"></jsp:include>
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
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
	<!-- 달력 추가 -->
	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
	<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
	<title>회원가입</title>
</head>

<style>
#box {
	background: rgb(235, 235, 235);
}

h5 {
	padding-left: 30px;
	padding-right: 30px;
}
</style>

<body>
	<jsp:include page="/View/main/layout/header.jsp"></jsp:include>

	<br>
	<div class="ui container">
		<div class="ui three top attached steps">
			<div class="disabled step">
				<i class="info icon"></i>
				<div class="content">
					<div class="title">약관동의</div>
					<div class="description">약관 동의 단계</div>
				</div>
			</div>
			<div class="disabled step">
				<i class="edit outline icon"></i>
				<div class="content">
					<div class="title">회원가입</div>
					<div class="description">가입 양식 작성 단계</div>
				</div>
			</div>
			<div class="active step">
				<i class="sign in alternate icon"></i>
				<div class="content">
					<div class="title">가입완료</div>
					<div class="description">회원 가입 성공</div>
				</div>
			</div>
		</div>
		<br>
		<div class="ui attached form centered">
			<div class="ui center aligned segment">
				<br><br><br>
				<div class="ui icon message" style="width: 80%; margin: 0 auto;">
					<i class="bullhorn icon"></i>
					<div class="content">
						<div class="header">
							<h1>
								회원가입 성공
							</h1>
						</div>
					</div>
				</div>
				<br>
				<div class="ui large message" style="width: 80%; margin: 0 auto;">
					<br>
					<h2>회원가입이 완료되었습니다.</h2>
					<h4>The Pension의 회원이 되신 것을 축하드립니다.<br>
					회원 정보 변경은 마이페이지에서 하실 수 있습니다.</h4>
					<br>
				</div>
				<button type="button" class="ui blue button" style="margin-top: 60px;" id="loginPage">로그인 페이지로</button>
				<br>
				<br><br><br><br>
			</div>
		</div>
	</div>
	<jsp:include page="/View/main/layout/footer.jsp"></jsp:include>
</body>

<script type="text/javascript">
	$('#loginPage').click(function(){
		location.href="/loginpage";
	});
</script>

</html>
