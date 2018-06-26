<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page errorPage="/View/error/error.jsp"%>
<%@page import="jsp.member.model.vo.*"%>
<%@page import="jsp.reservation.model.vo.*"%>
<jsp:include page="/View/main/layout/preventurl.jsp"></jsp:include>
<% 
ReservationVo rv = (ReservationVo)request.getAttribute("reservationInfo");
MemberVo mv = (MemberVo)request.getAttribute("memberInfo");
%>

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
	<title>step3. 예약 정보 확인 및 결제</title>


	<!-- 결제 라이브러리 -->
	<!-- 	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script> -->
	<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.2.js"></script>
</head>

<body>
	<!-- 헤더 -->
	<jsp:include page="/View/main/layout/header.jsp"></jsp:include>
	<!-- 헤더 끝 -->
	
	
	<br>
	<div class="ui container">

		<div class="ui four top attached steps">
			<div class="disabled step">
				<i class="calendar alternate outline icon"></i>
				<div class="content">
					<div class="title">예약 날짜 선택</div>
					<div class="description"></div>
				</div>
			</div>
			<div class="disabled step">
				<i class="tasks icon"></i>
				<div class="content">
					<div class="title">예약 정보 선택</div>
					<div class="description"></div>
				</div>
			</div>
			<div class="active step">
				<i class="won sign icon"></i>
				<div class="content">
					<div class="title">예약 확인 및 결제</div>
					<div class="description"></div>
				</div>
			</div>
			<div class="disabled step">
				<i class="calendar check outline icon"></i>
				<div class="content">
					<div class="title">예약 완료</div>
					<div class="description"></div>
				</div>
			</div>
		</div>
		
		<div class="ui red message" style="margin-top: 30px;">
			<i class="close icon"></i>
			<div class="header">
				예약을 완료 하려면 결제 수단과 아래 항목 동의 후 결제하기 버튼을 클릭하세요.
			</div>
		</div>

		<!-- 소원 추가 시작 -->
		<div class="ui center aligned segment" style="margin-bottom: 20px; margin-top: 30px;">
			<table class="ui center aligned celled table" id="calendar" align="center" width="800" height="100%" style="margin-top: 50px;">
				<thead>
					<tr>
						<th>예약기간</th>
						<th>객실</th>
						<th>인원수 / 요금</th>
						<th>결제수단</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							<%=rv.getResInDate()%> 입실 <br>
							<%=rv.getResOutDate()%> 퇴실 <br>
							<%=rv.getResPeriod()%>박 <%=rv.getResPeriod()+1%>일
						</td>
						<td><%=rv.getResRoomName()%><br></td>
						<td>
							<%=rv.getResPersonnel()%>명 / <%=rv.getResPrice()%>원
						</td>
						<td><input type="radio" id="pay" value="신용카드" name="pay"> 신용카드</td>
					</tr>
				</tbody>
			</table>

			<!-- 결제 선택했을 경우 동의 페이지 뜨기 -->
			<div id="payTr" class="ui center aligned basic segment">          

				<div class="ui center aligned segment" style="padding-top: 30px; padding-bottom: 30px; background: #f9fafb;">
					<div class="ui small header">예약 기간 / 객실 / 숙박인원 / 요금을 확인하였으며, 예약에 동의하시겠습니까?</div>
					<input type="checkbox" id="agree1" name="agree" /> 동의합니다.
				</div>

				<div class="ui center aligned segment" style="padding-top: 30px; padding-bottom: 30px; background: #f9fafb;">
					<div class="ui small header">개인정보 취급 위탁 동의<br>
						(예약 처리를 위한 목적으로 제공됩니다.)
					</div>
					<input type="checkbox" id="agree2" name="agree" /> 동의합니다.<br><br>
					<div class="ui form">
						<textarea rows="8" style="resize:none;" readonly>
더 펜션은 고객님께서 예약하신 서비스 제공을 위해 최소한의 정보를 아래와 같이 위탁하고 있습니다.
고객님께서는 정보 제공에 대해 동의하지 않으실 수 있으며, 동의하지 않으시는 경우 예약 서비스 제공이 제한됩니다.

위탁받는자 : 더 펜션
위탁 업무 : 예약 신청 서비스
위탁 항목 : 이름, 연락처 등등
보유 및 이용기간 : 서비스 완료 1개월 후 삭제 등
						</textarea>
					</div>
				</div>


				<div style="margin-top: 30px;">
					<input type="button" id="payBtn" class="ui blue button" value="결제하기" />
					<input type="button" id="step3Reset" class="ui orange button" value="처음으로" onclick="back();"/>
				</div>
			</div>


		</div>
	</div>
	<!-- 본문 끝 -->

	<!-- 푸터 시작  -->
	<jsp:include page="/View/main/layout/footer.jsp"></jsp:include>
	<!-- 푸터 끝 -->
</body>


<script>
	$(document).ready(function() {
               // 신용카드를 선택한 경우
               $('#pay').click(function() {
               	jQuery('#payTr').show();                  
               });
               
               $('#payBtn').click(function() {

               	var amount = '<%=rv.getResPrice()%>';
               	var roomName = '<%=rv.getResRoomName()%>';
               	var email = '<%=mv.getMbEmail()%>';
               	var name = '<%=mv.getMbName()%>';
               	var inDate = '<%=rv.getResInDate()%>';
               	var outDate = '<%=rv.getResOutDate()%>';


               	if($('#pay').is(":checked")==true) {
               		if($('#agree1').is(":checked") == true && $('#agree2').is(":checked") == true) {
                  		// !결제 선언!
                  		var IMP = window.IMP;
                    	IMP.init('imp04852335');  //가맹점 식별 코드 : 지금은 지은 계정
                    	IMP.request_pay({
                			pg : 'inicis', // 결제방식 : 이니시스(웹표준)
                			pay_method : 'card',	// 결제수단 : 카드
                			merchant_uid : 'merchant_' + new Date().getTime(),
                			name : '더펜션예약:<%=rv.getResRoomName()%>',
                			amount : '<%=rv.getResPrice()%>',	//////////////////////////////////////////////////////////////////////// 결제 금액 (실제 금액으로 수정함)
                			buyer_email : '<%=mv.getMbEmail()%>', // 고객 이메일
                			buyer_name :  '<%=mv.getMbName()%>(<%=mv.getMbId()%>)',
                			buyer_tel :  '<%=mv.getMbPhone()%>'
                		}, function(rsp) {
                			if ( rsp.success ) { // 성공시
                				var msg = '결제가 완료되었습니다.';
                				msg += '고유ID : ' + rsp.imp_uid;
                				msg += '상점 거래ID : ' + rsp.merchant_uid;
                				msg += '결제 금액 : ' + rsp.paid_amount;
                				msg += '카드 승인번호 : ' + rsp.apply_num;

                				$.ajax({
                					url : '/addReservationInfo',
                					data : { res_room_name:"<%=rv.getResRoomName()%>", 
                					res_id:"<%=mv.getMbId()%>",
                					res_personnel:"<%=rv.getResPersonnel()%>",
                					res_in_date:"<%=rv.getResInDate()%>",
                					res_out_date:"<%=rv.getResOutDate()%>",
                					res_period:"<%=rv.getResPeriod()%>",
                					res_price:"<%=rv.getResPrice()%>"
                				},
                				type : 'post',
                				success : function(){

                					$.ajax({
                						url : '/emailReservationSend',
                						type : 'POST',
                						data : {amount : amount, roomName : roomName, email : email, name : name, inDate : inDate, outDate : outDate}
                					})

                					alert('결제완료.\n더 펜션 예약이 완료되었습니다.');
                					/*	console.log("결제 성공");*/
                					location.href="/reservationsuccess";
                				},
                				error : function() {
                					alert('서버오류(잠시 후 다시 시도 해주세요');
                					/*			console.log("결제 실패");*/
                				}
                			});

                			} else { // 실패시
                				var msg = '결제에 실패하였습니다.';
                				msg += '에러내용 : ' + rsp.error_msg;
                			}
                		});
                    	
                    } else {
                    	alert("모두 동의 해주세요.");
                    	return false;
                    }

                }
                else {
                	alert("결제 수단을 선택해주세요.");
                	$('#pay').attr('checked', false);
                	return false;
                }
            });
           });

	function back() {
		location.href="/reservationFirstStep";
	}

	$('.message .close')
	.on('click', function() {
		$(this)
		.closest('.message')
		.transition('fade')
		;
	})
	;

</script>


<!-- 소원 추가 끝 -->
</html>
