<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page errorPage="/View/error/error.jsp"%>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="java.security.SecureRandom"%>
<%@ page import="java.math.BigInteger"%>

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
	<script src='https://www.google.com/recaptcha/api.js'></script>
	<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
	<title>로그인</title>
</head>

<style>
#containerCenter {
	margin-top: 30px;
	margin-bottom: 30px;
}

#loginTitle {
	margin-bottom: 40px;
}

#naverLoginBtn {
	margin-top: 30px;
}
</style>

<body>
	<!-- 헤더 시작  -->
	<jsp:include page="/View/main/layout/header.jsp"></jsp:include>
	<!-- 헤더 끝 -->

	<!-- 본문 시작 -->
	<br>

	<div class="ui container" id="containerCenter">
		<div class="ui icon message">
			<i class="lock icon"></i>
			<div class="content">
				<div class="header" style="text-align: center;">
					<h1>
						로그인
					</h1>
				</div>
			</div>
		</div>
		<form action="/login" method="post">
			<table class="ui table centered grid" style="padding-top: 30px; padding-bottom: 30px;">
				<tr>
					<td >아이디</td>
					<td>
						<div class="ui input">
							<input type="text" name="id" id="id" placeholder="아이디 입력" maxlength="16">
						</div>
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>
						<div class="ui input">
							<input type="password" name="pwd" id="pwd" placeholder="비밀번호 입력" maxlength="16">
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div class="ui centered grid" style="margin-bottom: 10px;">
							<div id="recap" class="g-recaptcha" data-sitekey="6Lfrr18UAAAAAGd424fRQMeX4GYy6FjS7Af1V8tJ"></div>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						아이디 저장
						<input type="checkbox" id="idSave" name="idSave">
					</td>
				</tr>
				<tr class="ui centered grid" style="margin-bottom: 5px; margin-top: 5px;">
					<td>
						<a href="/View/member/findIdPwd.jsp">아이디(비밀번호) 찾기</a>
					</td>
				</tr>
			</table>
			<br>		
			<div class="ui centered grid">
				<input id="loginBtn" type="submit" class="ui blue button" value="로그인" onclick="return loginRequest();" style="margin-right: 8px;">
				<button type="button" class="ui orange button" id="signUpBtn" style="margin-left: 8px">회원가입</button>
			</div>
			<div class="ui centered grid" id="naverLoginBtn">
				<div id="naver_id_login"></div>
			</div>
		</form>
	</div>

	<!-- 본문 끝 -->

	<!-- 푸터 시작  -->
	<jsp:include page="/View/main/layout/footer.jsp"></jsp:include>
	<!-- 푸터 끝 -->
</body>

<!-- 아이디 || 비밀번호 공백 일 경우 -->
<div class="ui mini modal" id="blankModal">
	<div class="header">로그인 실패</div>
	<div class="content">
		<p>아이디와 비밀번호를 모두 입력해주세요</p>
	</div>
	<div class="actions">
		<div class="ui blue cancel button" id="termsModal">확인</div>
	</div>
</div>

<!-- 아이디 저장 여부 체크 -->
<div class="ui mini modal" id="idSaveDo">
	<div class="header">아이디 저장</div>
	<div class="content">
		<p>아이디를 저장하시겠습니까?<br>
		※ 공용 PC 사용할 경우, 아이디 저장을 하지마세요</p>
	</div>
	<div class="actions">
		<div class="ui blue cancel button" id="idSaveConfirm">저장</div>
		<div class="ui blue cancel button" id="idSaveCancel">저장안함</div>
	</div>
</div>

<!-- recapcha 확인용-->
<div class="ui mini modal" id="robot">
	<div class="header">로그인 실패</div>
	<div class="content">
		<p>로봇이 아님을 인증하세요</p>
	</div>
	<div class="actions">
		<div class="ui blue cancel button">확인</div>
	</div>
</div>

<script>
	/* 회원가입 버튼 */
	$(document).ready(function() {
		$('#signUpBtn').click(function() {
			window.location.href = "/View/member/termsAgreement.jsp";
		});

		// 쿠키 값 체크 및 (userId) 불러옴
		var userId= $.cookie('userId');
		if(userId != undefined){
			$("input[name=idSave]:checkbox").prop("checked" , true);   
			$("#id").val(userId);
			$("#pwd").focus();  
		} else {
			$("input[name=idSave]:checkbox").prop("checked" , false);   
		}
	});

	/* 네아로 */
	var naver_id_login = new naver_id_login("PyoIesHAhe6a3F1GDj9P", "http://192.168.10.32/View/member/naverLoginCallBack.jsp");
	var state = naver_id_login.getUniqState();
	naver_id_login.setButton("green", 3, 40);
	naver_id_login.setDomain("http://192.168.10.32/View/member/naverLogin.jsp");
	naver_id_login.setState(state);
	naver_id_login.setPopup(); /* 팝업 로그인 창*/
	naver_id_login.init_naver_id_login();

	/* 아이디 패스워드 공백일 경우 */
	function loginRequest() {
		if ($('#id').val() == "" || $('#pwd').val() == "") {
			$('#blankModal')
			.modal('show');
			return false;
		} else {
			// 로그인 버튼이 눌렸을 때 쿠키 3일간 생성
			if($('input:checkbox:checked').val()=="on"){
				$.cookie('userId', $('#id').val(), { expires: 3 });
			} else {
				$.removeCookie('userId');
			}
			// 인증
			var auth = grecaptcha.getResponse();
			if(auth.length == 0){
				$('#robot').modal('show');
				return false;
			}
			else {
				return true;
			}
		}
	}

	$('#idSave').click(function() {
		$('#idSaveDo')
		.modal('show');
	});

	$('#idSaveConfirm').click(function() {
		$("input[name=idSave]:checkbox").prop("checked" , true); 
	});

	$('#idSaveCancel').click(function() {
		$("input[name=idSave]:checkbox").prop("checked" , false);   
	});

</script>

</html>