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
			<div class="active step">
				<i class="edit outline icon"></i>
				<div class="content">
					<div class="title">회원가입</div>
					<div class="description">가입 양식 작성 단계</div>
				</div>
			</div>
			<div class="disabled step">
				<i class="sign in alternate icon"></i>
				<div class="content">
					<div class="title">가입완료</div>
					<div class="description">회원 가입 성공</div>
				</div>
			</div>
		</div>
		<br>
		<form class="ui attached form centered" action="/signUp" method="POST" >
			<div class="ui centered aligned segment">
				<div class="ui centered aligned basic segment" style="width: 60%; margin: 0 auto">
					<div class="ui info message">
						<i class="close icon"></i>
						<div style="font-weight: 600">
							The Pension에 가입 하시려면 아래 모든 항목을 입력해주세요
						</div>
					</div>
					<br>
					<div class="field">
						<label>아이디</label>
						<div class="ui left icon input">
							<i class="user icon"></i>
							<input type="text" placeholder="아이디" id="idField" name="id" required maxlength="16">
						</div>
						<div class="ui pointing label" id="idMsg" style="display: none">6~16자의 영문 소문자, 숫자, 특수기호(_-)만 사용 가능 합니다</div>
						<div class="ui pointing label" id="idAlreadyUsed" style="display: none">이미 사용중인 아이디 입니다</div>
						<div class="ui pointing label" id="idCanUse" style="display: none">사용 가능한 아이디 입니다</div>
					</div>

					<div class="ui divider"></div>

					<div class="field">
						<label>비밀번호</label>
						<div class="ui left icon input">
							<i class="lock icon"></i>
							<input type="password" placeholder="비밀번호" id="pwdField" name="pwd" required maxlength="16">
						</div>
						<div class="ui pointing label" id="pwdMsg" style="display: none">영문 소문자 및 대문자, 숫자를 모두 포함한 6 ~ 16 자리를 입력해주세요</div>
					</div>

					<div class="field">
						<div class="ui left icon input">
							<i class="lock icon"></i>
							<input type="password" placeholder="비밀번호 재확인" id="pwdReField" required maxlength="16">
						</div>
						<div class="ui pointing label" id="pwdReMsgNotCorrect" style="display: none">비밀번호가 일치 하지 않습니다</div>
					</div>

					<div class="ui divider"></div>

					<div class="field">
						<label>이름</label>
						<div class="ui left icon input">
							<i class="address book outline icon"></i>
							<input type="text" placeholder="이름" id="nameField" name="name" required maxlength="5">
						</div>
						<div class="ui pointing label" id="nameMsg" style="display: none">한글 이름 2~5글자만 사용 가능 합니다</div>
					</div>

					<div class="field">
						<label>생년월일</label>
						<div class="ui left icon input">
							<i class="calendar icon"></i>
							<input type="text" placeholder="생년월일" id="birth" name="birth" required readonly>
						</div>
					</div>

					<br>
					<div class="ui centered grid">
						<div class="inline fields">
							<label>성별</label>
							<div class="field">
								<div class="ui radio checkbox">
									<input type="radio" value="M" name="gender" id="genderM" required="required">
									<label>남</label>
								</div>
							</div>
							<div class="field">
								<div class="ui radio checkbox">
									<input type="radio" value="F" name="gender" id="genderF">
									<label>여</label>
								</div>
							</div>
						</div>
					</div>

					<div class="field">
						<label>휴대폰번호</label>
						<div class="ui left icon input">
							<i class="phone icon"></i>
							<input type="text" placeholder="전화번호" id="phone" name="phone" required maxlength="13">
						</div>
						<div class="ui pointing label" id="PhoneMsg" style="display: none">- 를 포함한 휴대번호 입력하세요</div>
					</div>

					<div class="field">
						<label>주소</label>
						<div class="ui left icon input">
							<i class="home icon"></i>
							<input type="text" placeholder="주소" id="address" name="address" required readonly>
							<button type="button" class="ui blue button" style="margin-left: 15px;" id="findAddress">주소검색</button>
						</div>
					</div>

					<div class="field">
						<div class="ui left icon input">
							<i class="home icon"></i>
							<input type="text" placeholder="상세주소" id="addressDetails" name="addressDetails" maxlength="50">
						</div>
					</div>

					<div class="field">
						<label>이메일</label>
						<div class="ui left icon input">
							<i class="mail icon"></i>
							<input type="text" placeholder="메일주소" id="email" name="email" required maxlength="50">
							<button type="button" class="ui blue button" style="margin-left: 15px;" id="mailAuth">이메일인증</button>
						</div>
						<div class="ui pointing label" id="emailMsg" style="display: none">이메일 형식에 맞게 입력하세요</div>
						<div class="ui pointing label" id="emailAlreadyUsed" style="display: none">이미 사용중인 이메일 입니다</div>
					</div>

					<br>

					<div class="ui centered grid">
						<input type="submit" value="가입하기" class="ui teal button" id="signUpBtn" onclick="return chkField();">
					</div>
					<br>
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="/View/main/layout/footer.jsp"></jsp:include>
</body>

<!-- 이메일 인증 모달 -->
<div class="ui mini modal" id="modal1">
	<div class="header">인증번호입력</div>
	<div class="content">
		<p>이메일로 전송된 인증번호를 입력해주세요</p>
		<div class="ui input">
			<input type="text" maxlength="6" required id="inputAuthNum">
			<div class="ui blue button" id="mailAuthChk" style="margin-left: 10px">확인</div>
		</div>
		<br>
	</div>
</div>

<!-- 입력하지 않은 항목이 있을 경우 모달-->
<div class="ui mini modal" id="modal2">
	<div class="header">회원가입 실패</div>
	<div class="content">
		<p>모든 항목을 입력해주세요</p>
	</div>
	<div class="actions">
		<div class="ui blue cancel button" id="termsModal">확인</div>
	</div>
</div>

<!-- 이메일 인증을 안했을 경우 모달-->
<div class="ui mini modal" id="modal3">
	<div class="header">회원가입 실패</div>
	<div class="content">
		<p>이메일 인증을 해주세요</p>
	</div>
	<div class="actions">
		<div class="ui blue cancel button" id="termsModal">확인</div>
	</div>
</div>

<!-- 가입 형식이 맞지 않을경우 모달 -->
<div class="ui mini modal" id="modal4">
	<div class="header">회원가입 실패</div>
	<div class="content">
		<p>회원 가입 형식에 맞게 작성해주세요</p>
	</div>
	<div class="actions">
		<div class="ui blue cancel button" id="termsModal">확인</div>
	</div>
</div>

<!-- 아이디가 중복일 경우 모달-->
<div class="ui mini modal" id="modal5">
	<div class="header">회원가입 실패</div>
	<div class="content">
		<p>아이디 중복여부를 확인해주세요</p>
	</div>
	<div class="actions">
		<div class="ui blue cancel button" id="termsModal">확인</div>
	</div>
</div>

<script type="text/javascript" src="/JS/signUp.js"></script>

<script type="text/javascript">
	$('.message .close')
	.on('click', function() {
		$(this)
		.closest('.message')
		.transition('fade')
		;
	})
	;
</script>


</html>
