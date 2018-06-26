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
	<title>회원 정보 찾기</title>
</head>

<style>
#containerCenter {
	margin-top: 30px;
	margin-bottom: 30px;
}
</style>

<body>
	<!-- 헤더 시작  -->
	<jsp:include page="/View/main/layout/header.jsp"></jsp:include>
	<!-- 헤더 끝 -->

	<!-- 본문 시작 -->
	<!-- 여기에 본문 내용 작성하면 됨 -->
	<br>
	<div class="ui container" id="containerCenter">
		<div class="ui icon message">
			<i class="user icon"></i>
			<div class="content">
				<div class="header" style="text-align: center;">
					<h1>
						회원 정보 찾기
					</h1>
				</div>
			</div>
		</div>
		<br>
		<%-- 아이디 비밀번호 찾기 --%>
		<div class="ui pointing menu">
			<a class="item active" id="idFindBtn"> 아이디 찾기 </a>
			<a class="item" id="pwdFindBtn"> 비밀번호 찾기 </a>
		</div>
		<div class="ui center aligned segment" id="idFindView">
			<div class="ui blue message" style="color:black;">
				<h1>아이디 찾기</h1>
			</div>
			<div class="ui medium header">이름을 입력하세요</div>
			<div class="ui input">
				<input type="text" id="name" placeholder="이름 입력">
			</div>
			<div class="ui medium header">회원 가입 시 입력한 이메일을 입력하세요</div>
			<div class="ui input">
				<input type="text" id="email" placeholder="이메일 입력">
			</div><br><br>
			<button type="button" class="ui blue button" onclick="submit();">입력</button>
		</div>

		<div class="ui center aligned segment" id="pwdFindView" style="display: none;">
			<div class="ui blue message" style="color:black;">
				<h1>비밀번호 찾기</h1>
			</div>
			<div class="ui red message" style="width: 70%; margin: 0 auto;">
				<h5>※ 회원 가입한 기록이 있을경우 이메일로 임시 비밀번호가 전송됩니다</h5>
			</div>
			<div class="ui medium header">아이디를 입력하세요</div>
			<div class="ui input">
				<input type="text" id="id" placeholder="아이디 입력">
			</div>
			<div class="ui medium header">회원 가입 시 입력한 이메일을 입력하세요</div>
			<div class="ui input">
				<input type="text" id="email1" placeholder="이메일 입력">
			</div>
			<br>
			<br>
			<button type="button" class="ui blue button" id="pwdFindSubmit" onclick="pwdSubmit();">입력</button>
		</div>
		<%-- 아이디 비밀번호 찾기 --%>

	</div>
	<!-- 본문 끝 -->

	<!-- 푸터 시작  -->
	<jsp:include page="/View/main/layout/footer.jsp"></jsp:include>
	<!-- 푸터 끝 -->
</body>

<!-- 아이디 확인용 모달 -->
<div class="ui mini modal" id="myIdModal">
	<div class="header">아이디 찾기</div>
	<div class="content">
		<p id="myId"></p>
		<p id="myEntDate"></p>
	</div>
	<div class="actions">
		<div class="ui blue cancel button" id="termsModal">확인</div>
	</div>
</div>

<!-- 비밀번호 찾기 성공 모달 -->
<div class="ui mini modal" id="myPwdSuccessModal">
	<div class="header">비밀번호 찾기</div>
	<div class="content">
		이메일로 임시 비밀번호가 전송되었습니다<br>로그인 후 비밀번호를 변경해주세요
	</div>
	<div class="actions">
		<div class="ui blue cancel button" id="tempPwdConfirm">확인</div>
	</div>
</div>

<!-- 비밀번호 찾기 실패 모달 -->
<div class="ui mini modal" id="myPwdFailedModal">
	<div class="header">비밀번호 찾기</div>
	<div class="content">
		※ 해당 정보로 가입된 기록 없습니다
	</div>
	<div class="actions">
		<div class="ui blue cancel button" id="termsModal">확인</div>
	</div>
</div>

<!-- 아이디 찾기 이름 입력 안했을 경우 모달 -->
<div class="ui mini modal" id="noId">
	<div class="header">아이디 찾기</div>
	<div class="content">
		※ 이름을 입력해주세요
	</div>
	<div class="actions">
		<div class="ui blue cancel button" id="termsModal">확인</div>
	</div>
</div>

<!-- 아이디 찾기 이메일 입력 안했을 경우 모달 -->
<div class="ui mini modal" id="noEmail">
	<div class="header">비밀번호 찾기</div>
	<div class="content">
		※ 이메일을 입력해주세요
	</div>
	<div class="actions">
		<div class="ui blue cancel button" id="termsModal">확인</div>
	</div>
</div>

<!-- 비밀번호 찾기 아이디 입력 안했을 경우 모달 -->
<div class="ui mini modal" id="noId1">
	<div class="header">비밀번호 찾기</div>
	<div class="content">
		※ 아이디를 입력해주세요
	</div>
	<div class="actions">
		<div class="ui blue cancel button" id="termsModal">확인</div>
	</div>
</div>

<!-- 비밀번호 찾기 이메일 입력 안했을 경우 모달 -->
<div class="ui mini modal" id="noEmail1">
	<div class="header">비밀번호 찾기</div>
	<div class="content">
		※ 이메일을 입력해주세요
	</div>
	<div class="actions">
		<div class="ui blue cancel button" id="termsModal">확인</div>
	</div>
</div>

<script>
	function submit() {
		var $email = $('#email').val();
		var $name = $('#name').val();

		if ($name == "") {
			$('#noId').modal('show');
		} else if($email == ""){
			$('#noEmail').modal('show');
		} else {
			$.ajax({
				url : '/findId',
				type : 'POST',
				data : {
					email : $email,
					name : $name
				},
				success : function(data) {
					if (data == "없음") {
						$('#myEntDate').html('');
						$('#myId').html('※ 해당 정보로 가입한 아이디가 없습니다');
						$('#myIdModal').modal('show');
					} else {
						$('#myId').html('가입한 아이디 : ' + data.id);
						var ymd = (data.entDate).split(',')
						$('#myEntDate').html('가입한 날짜 : ' + ymd[1] + '년 ' + ymd[0] + '일');
						$('#myIdModal').modal('show');
					}
				},
				error : function() {
				}
			});
		}
	}

	function pwdSubmit() {
		var $email = $('#email1').val();
		var $id = $('#id').val();
		var $pwdFindSubmit = $('#pwdFindSubmit');

		if($id == ""){
			$('#noId1').modal('show');
		} else if(email == ""){
			$('#noEmail1').modal('show');
		}else {
			$.ajax({
				url : '/pwdFind',
				type : 'POST',
				data : {
					id : $id,
					email : $email
				},
				beforeSend : function() {
					$pwdFindSubmit.attr('class', 'ui primary loading button');
					$pwdFindSubmit.html('Loading');
				},
				complete : function() {
					$pwdFindSubmit.attr('class', 'ui blue button');
					$pwdFindSubmit.html('입력');
				},
				success : function(data) {
					if (Number(data) == 1) {
						$('#myPwdSuccessModal').modal('show');
					} else {
						$('#myPwdFailedModal').modal('show');
					}
				},
				error : function() {}
			});
		}
	}

	$('#tempPwdConfirm').click(function(){
		location.href = "/";
	});

	$(document).ready(function() {
		$('#idFindBtn').click(function() {
			$('#pwdFindView').css('display', 'none');
			$('#idFindView').css('display', 'block');
			$('#pwdFindBtn').removeClass("active");
			$('#idFindBtn').addClass("active");
		});

		$('#pwdFindBtn').click(function() {
			$('#idFindView').css('display', 'none');
			$('#pwdFindView').css('display', 'block');
			$('#idFindBtn').removeClass("active");
			$('#pwdFindBtn').addClass("active");
		});
	});
</script>

</html>
