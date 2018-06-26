<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<title>에러페이지</title>
</head>

<style>
</style>

<body>
	<!-- 헤더 시작  -->
	<jsp:include page="/View/main/layout/header.jsp"></jsp:include>
	<!-- 헤더 끝 -->

	<!-- 본문 시작 -->
	<div class="ui container">
		
		
		
		<br><br>
		<div class="ui attached form centered">
			<div class="ui center aligned segment">
				<br><br><br>
				<div class="ui icon message" style="width: 80%; margin: 0 auto;">
					<i class="frown icon"></i>
					<div class="content">
						<div class="header">
							<h1>
								죄송합니다.
							</h1>
						</div>
					</div>
				</div>
				<br>
				<div class="ui large message" style="width: 80%; margin: 0 auto;">
					<br>
					<h2>정상처리되지 못한 페이지입니다.</h2>
					<h4>메인화면에서 다시 이용 부탁드립니다.</h4>
					<br>
				</div>
				<button type="button" class="ui blue button" style="margin-top: 60px;" id="mainPageGo">메인화면으로</button>
				<br>
				<br><br><br><br>
			</div>
		</div>
	</div>
	<!-- 본문 끝 -->

	<!-- 푸터 시작  -->
	<jsp:include page="/View/main/layout/footer.jsp"></jsp:include>
	<jsp:include page="/View/main/layout/preventurl.jsp"></jsp:include>
	<!-- 푸터 끝 -->
</body>

<script type="text/javascript">
	$('#mainPageGo').click(function(){
		location.href="/index.jsp";
	});
</script>

</html>
