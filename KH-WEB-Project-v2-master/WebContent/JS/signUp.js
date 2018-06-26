/* 회원가입 변수 설정 */
var $idField = $('#idField'),
$idMsg = $('#idMsg'),
$pwdField = $('#pwdField'),
$pwdMsg = $('#pwdMsg'),
$pwdReField = $('#pwdReField'),
$pwdReMsgNotCorrect = $('#pwdReMsgNotCorrect'),
$nameField = $('#nameField'),
$nameMsg = $('#nameMsg'),
$phone = $('#phone'),
$phoneMsg = $('#PhoneMsg'),
$email = $('#email'),
$emailMsg = $('#emailMsg'),
$address = $('#address'),
$addressDetails = $('#addressDetails'),
$idAlreadyUsed = $('#idAlreadyUsed'),
$idCanUse = $('#idCanUse'),
$emailAlreadyUsed = $('#emailAlreadyUsed');

/* 정규식 */
var idRegExp = /^[a-z][a-z0-9-_]{5,15}$/;
var pwdRegExp = /^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\S+$).{6,16}$/;
var pwdReRegExp = /^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\S+$).{6,16}$/;
var nameRegExp = /^[가-힣]{2,5}$/;
var phoneRegExp = /^01([0|1|6|7|8|9]{1})-([0-9]{3,4})-([0-9]{4})$/;
var emailRegExp = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;


/* 이메일 인증 여부를 확인하기 위한 변수 */
var emailAuthDo = false;
/* 아이디 중복 확인을 확인하기 위한 변수 */
var idDuplicate = false;

/* 포커스 메세지 */
$(document).ready(function() {

	// 아이디
	$idField.focus(function() {

		$idField.keyup(function() {
			idCheck = idRegExp.test($idField.val());

			if (idCheck == true) {
				$idMsg.css('display', 'none');
				var id = $('#idField').val();
				$.ajax({
					url : '/idCheck',
					data : {
						id ,
						id
					},
					method : 'POST',
					success : function(data) {
						if (data == 1) {
							idDuplicate = true;
							$idCanUse.css('display', 'none');
							$idAlreadyUsed.css('display', 'block');
						} else {
							idDuplicate = false;
							$idAlreadyUsed.css('display', 'none');
							$idCanUse.css('display', 'block');
						}
					},
					error : function() {}
				});

			} else {
				$idMsg.css('display', 'block');
				$idAlreadyUsed.css('display', 'none');
				$idCanUse.css('display', 'none');
			}
		});
	});

	// 비밀번호
	$pwdField.focus(function() {

		$pwdField.keyup(function() {

			pwdCheck = pwdRegExp.test($pwdField.val());

			if ($pwdReField.val() == $pwdField.val()) {
				$pwdReMsgNotCorrect.css('display', 'none');
			} else {
				$pwdReMsgNotCorrect.css('display', 'block');
			}

			if (pwdCheck == true) {
				$pwdMsg.css('display', 'none');
			} else {
				$pwdMsg.css('display', 'block');
			}
			
			if($pwdField.val() != $pwdReField.val()){
				pwdRechk = false;
				pwdCheck = false;
			}
		});

	});

	// 비밀번호 확인
	$pwdReField.focus(function() {

		$pwdReField.keyup(function() {

			pwdRechk = pwdReRegExp.test($pwdReField.val());
			pwdCheck = pwdReRegExp.test($pwdField.val());

			if (pwdCheck == true) {
				$pwdMsg.css('display', 'none');
			} else {
				$pwdMsg.css('display', 'block');
			}

			if ($pwdField.val() == $pwdReField.val() && pwdRechk == true) {
				$pwdReMsgNotCorrect.css('display', 'none');
			} else {
				$pwdReMsgNotCorrect.css('display', 'block');
			}
			
			if($pwdField.val() != $pwdReField.val()){
				pwdRechk = false;
				pwdCheck = false;
			}
		});
	});

	// 이름
	$nameField.focus(function() {

		$nameField.keyup(function() {

			nameChk = nameRegExp.test($nameField.val());

			if (nameChk == true) {
				$nameMsg.css('display', 'none');
			} else {
				$nameMsg.css('display', 'block');
			}
		});
	});

	// 휴대폰 번호
	$phone.focus(function() {

		$phone.keyup(function() {

			phoneChk = phoneRegExp.test($phone.val());

			if (phoneChk == true) {
				$phoneMsg.css('display', 'none');
			} else {
				$phoneMsg.css('display', 'block');
			}
		});
	});

	// 이메일 인증 버튼 활성화
	var isEmailAuth = false;

	// 이메일 주소
	$email.focus(function() {

		$email.keyup(function() {
			emailChk = emailRegExp.test($email.val());
			if (emailChk == true) {
				$emailMsg.css('display', 'none');
				var email = $('#email').val();

				$.ajax({
					url : '/emailCheck',
					data : {
						email ,
						email
					},
					method : 'POST',
					success : function(data) {
						if (data == 1) {
							isEmailAuth = false;
							$emailAlreadyUsed.css('display', 'block');
						} else {
							isEmailAuth = true;
							$emailAlreadyUsed.css('display', 'none');
						}
					},
					error : function() {}
				});
				isEmailAuth = true;
			} else {
				$emailMsg.css('display', 'block');
				$emailAlreadyUsed.css('display', 'none');
				isEmailAuth = false;
			}
		});
	});

	/* 생년월일 달력 */
	$.datepicker.setDefaults({
		dateFormat : 'yy-mm-dd',
		prevText : '이전 달',
		nextText : '다음 달',
		monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월' ],
		monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월' ],
		dayNames : [ '일', '월', '화', '수', '목', '금', '토' ],
		dayNamesShort : [ '일', '월', '화', '수', '목', '금', '토' ],
		dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
		showMonthAfterYear : true,
		yearSuffix : '년',
		changeMonth : true,
		changeYear : true,
		yearRange : '1920:2000',
		defaultDate : new Date(1990, 0, 1)
	});


	$(function() {
		$("#birth").datepicker();
	});

	/* 주소 검색 API */
	var $findAddress = $('#findAddress');

	$findAddress.click(function() {
		new daum.Postcode({
			oncomplete : function(data) {

				var fullAddr = '';

				if (data.userSelectedType === 'R') {
					fullAddr = data.roadAddress;
				} else {
					fullAddr = data.jibunAddress;
				}

				$address.val(fullAddr);
				$addressDetails.focus();
			}
		}).open();
	});

	$address.click(function() {
		new daum.Postcode({
			oncomplete : function(data) {

				var fullAddr = '';

				if (data.userSelectedType === 'R') {
					fullAddr = data.roadAddress;
				} else {
					fullAddr = data.jibunAddress;
				}

				$address.val(fullAddr);
				$addressDetails.focus();
			}
		}).open();
	});


	/* 이메일 인증 */
	var $mailAuth = $('#mailAuth');

	$('#mailAuth').click(function() {
		if (isEmailAuth == true) {
			$emailMsg.css('display', 'none');
			var email = $('#email').val();

			$.ajax({
				url : "/emailAuth",
				method : "POST",
				data : {
					email : email
				},
				beforeSend : function() {
					$mailAuth.attr('class', 'ui primary loading button');
					$mailAuth.html('Loading');
				},
				complete : function() {
					$mailAuth.attr('class', 'ui blue button');
					$mailAuth.html('이메일인증');
				},
				success : function(authNum) {
					$('#modal1')
					.modal('show').modal('setting', 'closable', false);
					$('#mailAuthChk').click(function() {
						console.log($('#inputAuthNum').val());
						if (Number(authNum) == $('#inputAuthNum').val()) {
							alert('인증 되었습니다');
							$('#modal1')
							.modal('hide');
							emailAuthDo = true;
							$email.attr('readonly', 'true');
							$email.off();
							$mailAuth.off();
							$mailAuth.html('인증완료');
						} else {
							alert('인증번호가 일치하지 않습니다');
						}
					});
				},
				error : function() {
					alert('이메일 인증 오류');
				}
			});
		}
		if ($email.val() == "") {
			$emailMsg.css('display', 'block');
		}
	});
});


function chkField() {
	if ($idField.val() == "" || $pwdField.val() == "" || $pwdReField.val() == "" || $nameField.val() == "" || $phone.val() ==
		"" || $email.val() == "" || $address.val() == "" || ($('#genderM').is(":checked") == false && $('#genderF').is(
			":checked") == false)) {
		$('#modal2')
	.modal('show');
	return false;
} else if (emailAuthDo == false) {
	$('#modal3')
	.modal('show');
	return false;
} else if (idCheck == false || pwdCheck == false || pwdRechk == false || nameChk == false || phoneChk == false || emailChk == false) {
	$('#modal4')
	.modal('show');
	return false;
} else if (idDuplicate == true) {
	$('#modal5')
	.modal('show');
	return false;
} else {
	return true;
}
}
