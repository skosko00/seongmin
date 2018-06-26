<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/View/main/layout/preventurl.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
	<!-- Global site tag (gtag.js) - Google Analytics -->
	<script async src="https://www.googletagmanager.com/gtag/js?id=UA-120156974-1"></script>
	<script src="//cdn.ckeditor.com/4.9.2/standard/ckeditor.js"></script>
	<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
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
#questionTitle {
	font-weight: 600;
	font-size: 18px;
}
</style>

<!-- 네아로 체크 -->
<c:set value="${sessionScope.member.mbAddress}" var="id"></c:set>
<c:if test="${id == '네이버회원'}">
<script type="text/javascript">
	$(document).ready(function() {
		$('#naverLogin').show();
		$('#myPage').hide();
		$('#pwdChange').hide();
		$('#withDraw').hide();
		$('#basicSpace').hide();
		$('#space').css('padding', '100px');
	});
</script>
</div>
</c:if>

<!-- 관리자 체크 -->
<c:set value="${requestScope.mypage.mbId}" var="id"></c:set>
<c:if test="${id == 'thepension'}">
<script type="text/javascript">
	$(document).ready(function() {
		$('#adminMessage').show();
		$('#withdrawMessage').html("<div class='ui medium header'>※ 관리자는 탈퇴가 불가능합니다</div>");
		$('#adminHide').hide();
	});
</script>
</div>
</c:if>

<body>
	<!-- 헤더 시작  -->
	<jsp:include page="/View/main/layout/header.jsp"></jsp:include>
	<!-- 헤더 끝 -->
	<!-- 본문 시작 -->
	<div class="ui container">
		<!-- 여기에 본문 내용 작성하면 됨 -->
		<div class="ui red message" id="naverLogin" style="display: none; margin-top: 15px;"><div class="ui small header">※ 네이버 아이디로 로그인했습니다(회원 정보 수정 및 탈퇴는 네이버에서 해주세요.)</div></div>
		<div class="ui red message" id="adminMessage" style="display: none;"><div class="ui small header">※ 관리자 계정입니다.</div></div>
		<div class="ui icon message">
			<i id="myPageTitleIcon" class="user icon"></i>
			<div class="content">
				<div class="header" style="text-align: center;">
					<h1 id="myPageTitle">
						마이페이지
					</h1>
				</div>
			</div>
		</div>
		<div class="ui grid">
			<div class="four wide column">
				<div class="ui vertical fluid tabular menu">
					<a class="item" id="myPage"> 회원 정보 수정 </a> <a class="item" id="pwdChange"> 비밀번호 변경 </a> <a class="item" id="reservationInfo"> 예약 조회 및 취소 </a> <a class="item" id="reservationHistory"> 지난 예약 정보
					</a> <a class="item" id="question"> 1:1 문의 </a> </a> <a class="item" id="withDraw"> 회원 탈퇴 </a>
					<div id="space"></div>
					<div id="basicSpace" style="padding: 50px;"></div>
				</div>
			</div>
			<div class="twelve wide stretched column">
				<%-- 마이페이지 기본 --%>
				<div class="ui segment" id="default">
					<h1>
						<div class="ui secondary basic segment">
							<div class="ui small header" style="text-align: center">더 펜션 마이페이지입니다.</div>
						</div>
						<img src="Image/myPage.jpg" width="100%" style="opacity: 0.8">
					</h1>  
				</div>
				<%-- 회원 정보 수정 메뉴 --%>
				<div class="ui orange segment" id="myPageView" style="display: none">
					<div class="ui red message">
						<h4>* 표시된 항목만 변경가능 합니다</h4>
					</div>
					<h5>
						회원 아이디
						<div class="ui input">
							<input type="text" id="changeId" value="<c:out value='${requestScope.mypage.mbId}'></c:out>" readonly>
						</div>
					</h5>
					<h5>
						이메일
						<div class="ui input">
							<input type="text" value="<c:out value='${requestScope.mypage.mbEmail}'></c:out>" readonly size="60">
						</div>
					</h5>
					<h5>
						* 전화번호
						<div class="ui input">
							<input type="text" id="changePhone" value="<c:out value='${requestScope.mypage.mbPhone}'></c:out>">
						</div>
					</h5>
					<h5>
						회원 이름
						<div class="ui input">
							<input type="text" value="<c:out value='${requestScope.mypage.mbName}'></c:out>" readonly>
						</div>
					</h5>
					<h5>
						* 주소
						<div class="ui input">
							<input id='findAddress' type="text" value="<c:out value='${requestScope.mypage.mbAddress}'></c:out>" size="70" readonly="readonly">
						</div>
					</h5>
					<h5>
						<div id="detailAddress" style="display: none">
							* 상세주소
							<div class="ui input">
								<input id="detailFocus" type="text" value="<c:out value=''></c:out>" size="50" placeholder="상세 주소를 입력해주세요">
							</div>
						</div>
					</h5>
					<h5>
						생년월일
						<div class="ui input">
							<input type="text" value="<c:out value='${requestScope.mypage.mbBirth}'></c:out>" readonly>
						</div>
					</h5>
					<h5>
						가입일
						<div class="ui input">
							<input type="text" value="<c:out value='${requestScope.mypage.mbEntDate}'></c:out>" readonly>
						</div>
					</h5>
				</div>
				<%-- 비밀번호 변경 --%>
				<div class="ui orange segment" id="pwdChangeView" style="display: none">
					<div class="ui center aligned basic segment">
						<div class="ui red message">
							<h4>비밀번호를 변경하려면 아래 항목을 모두 입력해주세요</h4>
						</div>
						<div class="ui small header">변경 전 비밀번호</div>
						<div class="ui input">
							<input type="password" id="pwdBefore" placeholder="변경 전 비밀번호" maxlength="16">
						</div>
						<br>
						<div class="ui small header">변경 할 비밀번호 입력</div>
						<div class="ui input">
							<input type="password" id="pwdAfter" placeholder="변경 할 비밀번호" maxlength="16">
						</div>
						<div class="ui pointing label" id="pwdChangeMsg" style="display: none;">변경 할 비밀번호는 영문 소문자 및 대문자, 숫자를 모두 포함한 6 ~ 16 자리를 입력해주세요</div>
						<br>
						<div class="ui small header" id="hSpace">변경 할 비밀번호 재입력</div>
						<div class="ui input">
							<input type="password" id="pwdAfterRe" placeholder="변경 할 비밀번호 재입력" maxlength="16">
						</div>
						<div class="ui pointing label" id="pwdReMsgNotCorrect" style="display: none">비밀번호가 일치 하지 않습니다</div>
						<br>
					</div>
				</div>
				<%-- 예약 조회 / 취소  --%> <%-- 지은 작성 노력 중 --%>
				<div class="ui orange segment" id="reservationInfoView" style="display: none">
					<div class="ui basic segment">
						
						<h3>예약 정보</h3>
						
						<table class="ui table">
							<thead> 
								<tr align="center">
									<th>객실명</th>
									<th>입실일</th>
									<th>퇴실일</th>
									<th>예약인원</th>
									<th>요금</th>
									<th>결제일</th>
									<th>취소요청</th>
								</tr>
							</thead>
							<tbody id="resListInfo">
							</tbody>
						</table>
						
					</div>
					<div class="ui basic segment">
						
						<h3>취소된 예약 정보</h3>
						
						<table class="ui table">
							<thead> 
								<tr align="center">
									<th>객실명</th>
									<th>입실일</th>
									<th>퇴실일</th>
									<th>예약인원</th>
									<th>요금</th>
									<th>결제일</th>
									<th>취소여부</th>
									<th>환불여부</th>
								</tr>
							</thead>
							<tbody id="ccListInfo">
							</tbody>
						</table>
						
					</div>
				</div>
				<%-- 지난 예약 정보 --%> <%-- 지은2 작성 노력 중2 --%>
				<div class="ui orange segment" id="reservationHistoryView" style="display: none">
					<div class="ui basic segment">
						<h3>지난 예약 정보</h3>
						<table class="ui table">
							<thead> 
								<tr align="center">
									<th>입실일</th>
									<th>퇴실일</th>
									<th>객실명</th>
									<th>예약인원</th>
									<th>요금</th>
								</tr>
							</thead>
							<tbody id="resHistoryListInfo">
							</tbody>
						</table>
					</div>
				</div>
				<%-- 1:1 문의 리스트 --%>
				<div class="ui basic segment" id="questionListView" style="display: none; margin-top: 0px; padding: 0;">
					<div class="ui orange segment">
						<div class="ui right aligned basic segment" style="padding-top:5px; padding-bottom: 0px;">
							<button class="ui basic button" id="questionWrite">
								<i class="question circle icon"></i>
								문의하기
							</button>
						</div>
						<table class="ui table" id="questionTbl">
							<thead> 
								<tr align="center">
									<th>문의번호</th>
									<th style="width: 300px;">제목</th>
									<th>작성날짜</th>
									<th>답변여부</th>
								</tr>
							</thead>
							<tbody id="tTest">
							</tbody>
						</table>
						<div id="moreSpace"></div>
					</div>
				</div>

				<%-- 회원 탈퇴  --%>
				<div class="ui orange segment" id="withDrawView" style="display: none;">
					<br>
					<br>
					<div class="ui red message" style="width : 60%; margin: 0 auto;" id="withdrawMessage">
						<h5>탈퇴 시 The Pension 이용권한 및 관련기록이 모두 삭제 됩니다.<br>
							또한 가입 시 입력한 개인정보 또한 일괄 삭제되어 복구될 수 없으므로<br>
							탈퇴 시 이점 유의 해주시기 바랍니다.<br>
						※ 작성한 게시글 및 댓글은 자동으로 삭제되지 않습니다.</h5>
						<div class="ui center aligned basic segment" style="color : black; padding-top: 0px; padding-bottom: 0px;">
							탈퇴 내용에 동의합니다
							<input type="checkbox" id="agreementChk">
						</div>
					</div>
					<br>
					<br>
					<div id="adminHide">
						<div class="ui centered grid">
							<h4>
								탈퇴하시려면 비밀번호를 입력해주세요
								<br>
								<br>
								<div class="ui input">
									<input type="password" id="pwdChk" name="pwd" placeholder="비밀번호 입력" maxlength="16" onkeypress="myFunction();">
								</div>
								<div id="pwdChkBtn" class="ui blue button" style="margin-left: 5px;">탈퇴하기</div>
							</h4>
						</div>
					</div>
					<br>
					<br>
					<br>
					<br>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
	<div class="ui centered grid">
		<button class="ui blue button" id="myPageBtn" style="display: none">회원 정보 수정</button>
		<button class="ui blue button" id="pwdChangeBtn" style="display: none">비밀번호 변경</button>
		<button class="ui blue button" id="questionSubmit" style="display: none">문의 하기</button>
		<button class="ui blue button" id="withDrawSubmit" style="display: none">탈퇴 하기</button>
		<button class="ui red button" id="back">메인으로 돌아가기</button>
	</div>
	<!-- 본문 끝 -->
	<!-- 푸터 시작 -->
	<jsp:include page="/View/main/layout/footer.jsp"></jsp:include>
	<!-- 푸터 끝 -->
</body>

<!-- 1:1문의 하기 -->
<div class="ui special modal" id="questionStart">
	<div class="header">1:1 문의</div>
	<div class="content" style="padding-bottom: : 7px;padding-top: 15px;padding-bottom: 0px;padding-right: 15px;padding-left: 15px;">
		<label style="font-weight: 600;">문의제목</label>
		<div class="ui input">
			<input type="text" id="questionName" placeholder="문의 제목 입력" size="70" maxlength="50">
		</div> 
		<div class="ui form" style="margin-top: 15px;">
			<label style="font-weight: 600;">문의내용</label>
			<textarea id="questionContent" placeholder="문의 내용 입력" style="margin-top: 10px; resize: none;" maxlength="1000"></textarea>
		</div>
		<div class="ui right aligned basic segment" style="margin-top: 0px;">
			<div class="actions">
				<div class="ui blue cancel button" id="questionSend">완료</div>
				<div class="ui orange cancel button" id="questionCancel">취소</div>
			</div>
		</div>
	</div>
</div>

<!-- 1:1문의 하기 내 글보기-->
<div class="ui special modal" id="myModal">
	<div class="header">1:1 문의</div>
	<div class="content" style="padding-bottom: : 7px;padding-top: 15px;padding-bottom: 0px;padding-right: 15px;padding-left: 15px;">
		<label style="font-weight: 600;">문의제목</label>

		<div class="ui input">
			<input type="text" id="questionMyName" size="70" maxlength="50" readonly>
		</div> 

		<div class="ui form" style="margin-top: 15px;">
			<label style="font-weight: 600;">문의내용</label>
			<textarea id="myQuestionContent" readonly style="resize: none;">
			</textarea>
		</div>

		<div class="ui form" style="margin-top: 15px;">
			<label style="font-weight: 600;">답변내용</label>
			<textarea id="myQuestionAnswer" readonly style="resize: none;">
			</textarea>
		</div>

		<div class="ui right aligned basic segment" style="margin-top: 0px;">
			<div class="actions">
				<div class="ui red cancel button">닫기</div>
			</div>
		</div>

	</div>
</div>
<script>
	$(document).ready(function() {
		/* 회원 정보 수정 */
		$('#myPage').click(function() {
			$.ajax({
				url : '/myPage',
				data : {
					id : '${requestScope.mypage.mbId}',
					pwd : '${requestScope.mypage.mbPwd}'
				},
				success : function() {
					removeMenu();
					removeContent();
					revmoveBtn();
					$('#myPage').addClass('active');
					$('#myPageTitleIcon').removeClass();
					$('#myPageTitleIcon').addClass('edit icon');
					$('#myPageTitle').html('회원 정보 수정');
					$('#myPageView').show();
					$('#myPageBtn').show();
				}
			})
		});
		/* 비밀번호 변경 */
		$('#pwdChange').click(function() {
			removeMenu();
			removeContent();
			revmoveBtn();
			$('#pwdChange').addClass('active');
			$('#myPageTitleIcon').removeClass();
			$('#myPageTitleIcon').addClass('lock icon');
			$('#myPageTitle').html('비밀번호 변경');
			$('#pwdChangeView').show();
			$('#pwdChangeBtn').show();
		});
		
		
		/* Ajax 중복 호출 방지 용*/
		var ajaxLoadRes = 0;
		var ajaxLoadNowRes = ajaxLoadRes;
		var ajaxLoadCc = 0;
		var ajaxLoadNowCc = ajaxLoadCc;
		
		
		/* 예약 조회 / 취소 */ //////// 지은 작업 노력 중
		$('#reservationInfo').click(function() {
			
			removeMenu();
			removeContent();
			revmoveBtn();
			$('#reservationInfo').addClass('active');
			$('#myPageTitleIcon').removeClass();
			$('#myPageTitleIcon').addClass('calendar alternate outline icon');
			$('#myPageTitle').html('예약 조회 및 취소');
			$('#reservationInfoView').show();

			// 예약 중인 정보 출력
			$.ajax({
				url : '/reservationCheckList',
				data : {
					loginId : '${requestScope.mypage.mbId}'
				},
				type : 'post',
				beforeSend:function(resList){ 
					ajaxLoadRes = ajaxLoadRes + 1;
				},
				success : function(resList) {
					
					// console.log("reservationInfo:ajax성공");

					if(ajaxLoadNowRes != ajaxLoadRes - 1){ 
						console.log("중복출력방지");
					} else {

						for(var i=0; i<resList.length; i++) {

							var tr = $("<tr align='center'>");

							var roomNameTd = $("<td>").text(resList[i].resRoomName); // 방이름
							var tempDate = (resList[i].resInDate).split(',');
							var temp = tempDate[0].split('월 ');
							var inDateTd = $("<td>").text(tempDate[1]+'-'+temp[0]+'-'+temp[1]); // 입실일
							tempDate = (resList[i].resOutDate).split(',');
							temp = tempDate[0].split('월 ');
							var outDateTd = $("<td>").text(tempDate[1]+'-'+temp[0]+'-'+temp[1]); // 퇴실일
							var personnelTd = $("<td>").text(resList[i].resPersonnel); // 예약인원
							var priceTd = $("<td>").text(resList[i].resPrice+'원'); // 요금
							tempDate = (resList[i].resPaymentDate).split(' ');
							var paymentDateTd = $("<td>");
							var paymentOneLabel = $("<label>").text(tempDate[0]+' '+tempDate[1]+' '+tempDate[2]);
							var paymentTwoLabel = $("<label>").text(tempDate[3]+' '+tempDate[4]);

							var buttonTd = $("<td>");
							var buttonTag = $("<button class='ui inverted red button' id='cancelCall"+i+"' value='"+resList[i].resNo
								+"' onclick='return reallyCancel();'>").text('예약취소');



							tr.append(roomNameTd);
							tr.append(inDateTd);
							tr.append(outDateTd);
							tr.append(personnelTd);
							tr.append(priceTd);
							tr.append(paymentDateTd);
							paymentDateTd.append(paymentOneLabel);
							paymentDateTd.append($("<br>"));
							paymentDateTd.append(paymentTwoLabel);

							tr.append(buttonTd);
							buttonTd.append(buttonTag);

							$("#resListInfo").append(tr);


							$('#cancelCall'+i).click(function() {

								var resNo = $(this).attr('value');

								$.ajax({
									url : '/reservationCancelCall',
									data : { res_no : resNo },
									type : 'get',
									success : function() {
										alert("예약 취소가 접수되었습니다.");
										window.location.reload();
									},
									error : function() {
										console.log("cancelCall:실패");
									}
								});
							});
						} // for문 종료
					} // else문 종료
				},
				error : function() {
					console.log("reservationInfo:실패");
					// alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				}
			}); // 예약 중인 정보 출력 ajax 종료
			
			
			// 취소된 예약 정보 출력 ajax
			$.ajax({
				url : '/reservationCancelList',
				data : {
					loginId : '${requestScope.mypage.mbId}'
				},
				type : 'post',
				beforeSend:function(ccList){ 
					ajaxLoadCc = ajaxLoadCc + 1;
				},
				success : function(ccList) {
					if(ajaxLoadNowCc != ajaxLoadCc - 1){ 
						console.log("중복출력방지");
					} else {
						//<th>객실명</th>
						//<th>입실일</th>
						//<th>퇴실일</th>
						//<th>예약인원</th>
						//<th>요금</th>
						//<th>결제일</th>
						//<th>환불여부</th>
						//<th>취소여부</th>
						for(var i=0; i<ccList.length; i++) {
							
							var tr = $("<tr align='center'>");
							
							var rcRoomNameTd = $("<td>").text(ccList[i].rcResRoomName); // 방이름
							var tempDate = (ccList[i].rcResInDate).split(',');
							var temp = tempDate[0].split('월 ');
							var rcInDateTd = $("<td>").text(tempDate[1]+'-'+temp[0]+'-'+temp[1]); // 입실일
							tempDate = (ccList[i].rcResOutDate).split(',');
							temp = tempDate[0].split('월 ');
							var rcOutDateTd = $("<td>").text(tempDate[1]+'-'+temp[0]+'-'+temp[1]); // 퇴실일
							var rcPersonnelTd = $("<td>").text(ccList[i].rcResPersonnel); // 예약인원
							var rcPriceTd = $("<td>").text(ccList[i].rcResPrice+'원'); // 요금
							tempDate = (ccList[i].rcResPaymentDate).split(' ');
							var rcPaymentDateTd = $("<td>");
							var rcPaymentOneLabel = $("<label>").text(tempDate[0]+' '+tempDate[1]+' '+tempDate[2]);
							var rcPaymentTwoLabel = $("<label>").text(tempDate[3]+' '+tempDate[4]);
							var refundLabelTd = $("<td>");
							var cancelLabelTd = $("<td>");
							if(ccList[i].rcRefundCheck=='N') {
								var refundLabel = $("<label>").text("처리중");
							} else {
								var refundLabel = $("<label>").text("완료");
							}
							
							if(ccList[i].rcCancelCheck=='N') {
								var cancelLabel = $("<label>").text("처리중");
							} else {
								var cancelLabel = $("<label>").text("완료");
							}
							
							tr.append(rcRoomNameTd);
							tr.append(rcInDateTd);
							tr.append(rcOutDateTd);
							tr.append(rcPersonnelTd);
							tr.append(rcPriceTd);
							tr.append(rcPaymentDateTd);
							rcPaymentDateTd.append(rcPaymentOneLabel);
							rcPaymentDateTd.append($("<br>"));
							rcPaymentDateTd.append(rcPaymentTwoLabel);

							tr.append(refundLabelTd);
							refundLabelTd.append(refundLabel);
							tr.append(cancelLabelTd);
							cancelLabelTd.append(cancelLabel);
							

							$("#ccListInfo").append(tr);
							
						} // for문 종료
					}	
				},
				error : function() {
					console.log("취소정보 ajax실패");
				}
			}); // 취소된 예약 정보 출력 ajax 종료

		});


/* Ajax 중복 호출 방지 용*/
var ajaxLoadHis = 0;
var ajaxLoadNowHis = ajaxLoadHis;



		/* 지난 예약 정보 */ /////////////// 지은2 작업 노력 중2
		$('#reservationHistory').click(function() {
			removeMenu();
			removeContent();
			revmoveBtn();
			$('#reservationHistory').addClass('active');
			$('#myPageTitleIcon').removeClass();
			$('#myPageTitleIcon').addClass('calendar alternate icon');
			$('#myPageTitle').html('지난 예약 정보');
			$('#reservationHistoryView').show();
			
			
			$.ajax ({
				
				url : '/reservationHistoryList',
				data : {
					loginId : '${requestScope.mypage.mbId}'
				},
				type : 'post',
				beforeSend:function(hisList){ 
					ajaxLoadHis = ajaxLoadHis + 1;
				},
				success : function(hisList) {
				  /*<th>입실일</th>
					<th>퇴실일</th>
					<th>객실명</th>
					<th>예약인원</th>
					<th>요금</th> */
					if(ajaxLoadNowHis != ajaxLoadHis - 1){ 
						console.log("중복출력방지");
					} else {

						for(var i=0; i<hisList.length; i++) {


							var tr = $("<tr align='center'>");

							var tempDate = (hisList[i].resHisInDate).split(',');
							var temp = tempDate[0].split('월 ');
							var inDateTd = $("<td>").text(tempDate[1]+'-'+temp[0]+'-'+temp[1]); // 입실일

							tempDate = (hisList[i].resHisOutDate).split(',');
							temp = tempDate[0].split('월 ');
							var outDateTd = $("<td>").text(tempDate[1]+'-'+temp[0]+'-'+temp[1]); // 퇴실일

							var roomNameTd = $("<td>").text(hisList[i].resHisRoomName); // 방이름

							var personnelTd = $("<td>").text(hisList[i].resHisPersonnel); // 예약인원

							var priceTd = $("<td>").text(hisList[i].resHisPrice+'원'); // 요금

							tr.append(inDateTd);
							tr.append(outDateTd);
							tr.append(roomNameTd);
							tr.append(personnelTd);
							tr.append(priceTd);

							$("#resHistoryListInfo").append(tr);

						} // for문 종료

					} // else문 종료
				},
				error : function() {
					console.log("지난정보 ajax실패");
				}
				
			});
			
		});

		/* Ajax 중복 호출 방지 용*/
		var ajaxLoad = 0;
		var ajaxLoadNow = ajaxLoad; 

		/* 1:1 문의 */
		$('#question').click(function() {
			removeMenu();
			removeContent();
			revmoveBtn();
			$('#question').addClass('active');
			$('#myPageTitleIcon').removeClass();
			$('#myPageTitleIcon').addClass('question icon');
			$('#myPageTitle').html('1:1 문의');
			$('#questionListView').show();

			$.ajax({
				url : '/question',
				data : {id : '${requestScope.mypage.mbId}'},
				type : 'GET', 
				beforeSend:function(data){ 
					ajaxLoad = ajaxLoad + 1;
				},
				success : function(data){
					items = 5; // 증가 글 번호 변수 선언

					if(ajaxLoadNow == ajaxLoad - 1){ 
						if(data == null){
							alert('문의정보가 없습니다');
						} else {
							for (i = 0; i < items; i++) { 
								var tr = $("<tr align='center'>");
								var qNo = $("<td name='count'>").text(data[i].qNo);
								var qName = $('<td>').html("<a href='#' id='test" + (i + 1)+ "'>" + data[i].qName + "</a>");
								var qWriteDate = $('<td>').text(data[i].qWriteDate);
								if(data[i].qAnswerCheck == 'Y'){
									var qAnswerCheck = $('<td>').text('답변완료');
								} else {
									var qAnswerCheck = $('<td>').text('답변대기중');
								}
								tr.append(qNo);
								tr.append(qName);
								tr.append(qWriteDate);
								tr.append(qAnswerCheck);
								$('#questionTbl').append(tr);

								$('#test'+(i+1)).on('click', function(){
									var $test = $(this);
									var loadNo = $test.parent().siblings('td').first().html();

									$.ajax({
										url : '/myQuestion',
										type : 'POST',
										data : {loadNo : loadNo},
										success : function(data){
											$('#questionMyName').val(data.qv.qName);
											$('#myQuestionContent').html(data.qv.qContents);
											$('#myQuestionAnswer').html(data.asv.aContents);
											$('#myModal').modal('show').modal('setting', 'closable', false);
										}
									});
								});
							}
							var listAdd = "<div class='ui centered grid'><button class='ui primary button' id='more' style='margin-top: 10px; margin-bottom: 10px;'>문의 글 더보기</button></div>";
							$('#moreSpace').append(listAdd);
						}
					} 

					// 5개 미만일때 더보기 버튼
					count = document.getElementsByName('count').length;
					test = parseInt(count / 5);
					if (count < 5) {
						$('#more').hide();
					}

					startVal = 5; // 시작 글 번호
					$('#more').on('click', function(e) {
						items += 5; // 증가 글 번호
						var test ;
						console.log(data.length);

						if(items>data.length){
							test = data.length;
						}else{
							test = items;
						}

						for (i = startVal; i < test; i++) { //i = startVal; i < items; i++

							var tr = $("<tr align='center'>");
							var qNo = $("<td name='count'>").text(data[i].qNo);
							var qName = $('<td>').html("<a href='#' id='test" + (i + 1)+ "'>" + data[i].qName + "</a>");
							var qWriteDate = $('<td>').text(data[i].qWriteDate);
							if(data[i].qAnswerCheck == 'Y'){
								var qAnswerCheck = $('<td>').text('답변완료');
							} else {
								var qAnswerCheck = $('<td>').text('답변대기중');
							}
							tr.append(qNo);
							tr.append(qName);
							tr.append(qWriteDate);
							tr.append(qAnswerCheck);
							$('#questionTbl').append(tr);

							$('#test'+(i+1)).on('click', function(){
								var $test = $(this);
								var loadNo = $test.parent().siblings('td').first().html();


								$.ajax({
									url : '/myQuestion',
									type : 'POST',
									data : {loadNo : loadNo},
									success : function(data){
										$('#questionMyName').val(data.qv.qName);
										$('#myQuestionContent').html(data.qv.qContents);
										$('#myQuestionAnswer').html(data.asv.aContents);
										$('#myModal').modal('show').modal('setting', 'closable', false);
									}
								});
							});

							startVal++; // 시작 글 증가
							if(items > data.length){	//items
								$('#more').hide(); // 데이터 길이보다 출력할 목록이 커지면 버튼 제거
								$('#questionTbl').css('margin-bottom', '50px');
							}
						}
					});
				},
				error : function(){
					alert('조회 할 내용이 없습니다');
				}
			});
		});

		$('#withDraw').click(function() {
			removeMenu();
			removeContent();
			revmoveBtn();
			$('#withDraw').addClass('active');
			$('#myPageTitleIcon').removeClass();
			$('#myPageTitleIcon').addClass('sign out alternate icon');
			$('#myPageTitle').html('회원 탈퇴');
			$('#withDrawView').show();
		});
		/* 회원 탈퇴- 비밀번호 확인 후 삭제 (버튼) */
		$('#pwdChkBtn').click(function() {
			var pwd = $('#pwdChk').val();
			var $checkVal = $('#agreementChk').is(':checked');

			if($checkVal == true){
				$.ajax({
					url : '/withdraw',
					type : 'POST',
					data : {
						id : '${requestScope.mypage.mbId}',
						pwd : pwd
					},
					success : function(data) {
						if (data == "비밀번호를 잘못 입력했습니다") {
							alert(data);
						} else {
							alert(data);
							location.href='/';
						}
					}
				});
			} else {
				alert('탈퇴 내용에 동의해주세요');
			}
		});

		/* 회원 탈퇴- 비밀번호 확인 후 삭제 (엔터키) */
		$('#pwdChk').keydown(function(key) {
			if (key.keyCode == 13) {
				var pwd = $('#pwdChk').val();
				var $checkVal = $('#agreementChk').is(':checked');

				if($checkVal == true){
					$.ajax({
						url : '/withdraw',
						type : 'POST',
						data : {
							id : '${requestScope.mypage.mbId}',
							pwd : pwd
						},
						success : function(data) {
							if (data == "비밀번호를 잘못 입력했습니다") {
								alert(data);
							} else {
								alert(data);
								location.href='/';
							}
						}
					});
				} else {
					alert('탈퇴 내용에 동의해주세요');
				}
			}
		});
	});
$('#back').click(function() {
	location.href = "/";
})
// 메뉴 remove
function removeMenu() {
	$('#pwdChange').removeClass('active');
	$('#myPage').removeClass('active');
	$('#reservationInfo').removeClass('active');
	$('#reservationHistory').removeClass('active');
	$('#question').removeClass('active');
	$('#withDraw').removeClass('active');
}
// 내용 remove
function removeContent() {
	$('#default').hide();
	$('#pwdChangeView').hide();
	$('#myPageView').hide();
	$('#reservationInfoView').hide();
	$('#reservationHistoryView').hide();
	$('#questionView').hide();
	$('#withDrawView').hide();
	$('#questionListView').hide();
}
// 버튼 remove
function revmoveBtn() {
	$('#myPageBtn').hide();
	$('#pwdChangeBtn').hide();
	$('#questionSubmit').hide();
}

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
			$findAddress.val(fullAddr);
			$('#detailAddress').show();
			$('#detailFocus').focus();
		}
	}).open();
});
// 비밀번호 변경
$('#pwdChangeBtn').click(function() {
	var $pwdBefore = $('#pwdBefore').val();
	var $pwdAfter = $('#pwdAfter').val();
	var $pwdAfterRe = $('#pwdAfterRe').val();
	var $requestId = '${requestScope.mypage.mbId}';
	$.ajax({
		url : '/pwdChange',
		data : {
			pwdBefore : $pwdBefore,
			id : $requestId
		},
		type : 'POST',
		success : function(data) {
			if (data == '1') {
				if ($pwdAfter != $pwdAfterRe) {
					alert('변경할 비밀번호 확인이 일치하지 않습니다');
				} else {
					if (pwdRechk == false || pwdCheck == false) {
						alert('비밀번호 형식이 잘못됐습니다');
					} else {
						$.ajax({
							url : '/pwdChangeUpdate',
							data : {
								pwdAfter : $pwdAfter,
								id : $requestId
							},
							type : 'POST',
							success : function(data) {
								if (data == '1') {
									alert('비밀번호가 변경 되었습니다');
									location.href = "/";
								} else {
									alert('비밀번호 변경에 실패했습니다');
								}
							}
						});
					}
				} 
			} else {
				alert('현재 비밀번호가 일치하지 않습니다')
			}
		},
		error : function() {
			alert('AJAX 오류');
		}
	});
});
	// 변경 할 비밀번호 정규식
	var pwdRegExp = /^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\S+$).{6,16}$/;
	var pwdReRegExp = /^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\S+$).{6,16}$/;
	// 변경 할 비밀번호
	$('#pwdAfter').focus(function() {
		$('#pwdAfter').keyup(function() {
			pwdCheck = pwdRegExp.test($('#pwdAfter').val());
			if ($('#pwdAfterRe').val() == $('#pwdAfter').val()) {
				$('#pwdReMsgNotCorrect').css('display', 'none');
			} else {
				$('#pwdReMsgNotCorrect').css('display', 'block');
				$('#hSpace').css('margin-top', '5px');
			}
			if (pwdCheck == true) {
				$('#pwdChangeMsg').css('display', 'none');
			} else {
				$('#pwdChangeMsg').css('display', 'block');
			}
			if ($('#pwdAfter').val() != $('#pwdAfterRe').val()) {
				pwdRechk = false;
				pwdCheck = false;
			}
		});
	});
	// 변경 할 비밀번호 확인
	$('#pwdAfterRe')
	.focus(
		function() {
			$('#pwdAfterRe')
			.keyup(
				function() {
					pwdRechk = pwdReRegExp.test($(
						'#pwdAfterRe').val());
					pwdCheck = pwdReRegExp.test($(
						'#pwdAfter').val());
					if (pwdCheck == true) {
						$('#pwdReMsgNotCorrect').css(
							'display', 'none');
					} else {
						$('#pwdReMsgNotCorrect').css(
							'display', 'block');
					}
					if ($('#pwdAfter').val() == $(
						'#pwdAfterRe').val()
						&& pwdRechk == true) {
						$('#pwdReMsgNotCorrect').css(
							'display', 'none');
				} else {
					$('#pwdReMsgNotCorrect').css(
						'display', 'block');
				}
				if ($('#pwdAfter').val() != $(
					'#pwdAfterRe').val()) {
					pwdRechk = false;
			}
		});
		});
	//  회원 정보 변경
	$('#myPageBtn').click(function(){
		var address = $('#findAddress').val();
		var addressDetail = $('#detailFocus').val();
		var phone = $('#changePhone').val();
		var id = $('#changeId').val();

		$.ajax({
			url : '/memberUpdate',
			type : 'POST',
			data : {address : address,  addressDetail : addressDetail, phone : phone, id : id},
			success : function(data){
				var check = Number(data);
				if(check == '1'){
					alert('회원 정보 변경 완료');
					window.location.reload();
				} else {
					alert('회원 정보 변경 실패');
				}
			},
			error : function(){
			}
		});
	});

	/* 문의하기 버튼 */
	$('#questionWrite').click(function(){
		$('#questionStart')
		.modal({
			centered: false
		}).modal('show').modal('setting', 'closable', false);
	});

	/* 1:1 문의하기 완료 버튼*/
	$('#questionSend').click(function(){
		var questionName = $('#questionName').val();
		var questionContent = $('#questionContent').val();
		var id = '${requestScope.mypage.mbId}';

		if(questionName == "" || questionContent == ""){
			alert('내용을 작성해주세요');
			return false;
		} else {
			$.ajax({
				url : '/questionSend',
				type : 'POST',
				data : {questionName : questionName, questionContent : questionContent, id : id},
				success : function(data){
					if(data == '1'){
						alert('문의 내용 작성 완료');
						location.reload();
					} else {
						alert('문의 내용 작성 실패');
						location.reload();
					}
				},
				error : function(){
					alert('서버 오류(잠시 후 다시 시도 해주세요)');
				}
			});
		}
	});

	
	// 지은 함수
	function reallyCancel() {
		if(window.confirm("정말로 취소하시겠습니까?\n취소 및 환불 처리에 3-4일 정도 소요될 수 있습니다.")) {
			return true;
		} else {
			return false;
		}
		
	}
	
</script>
</html>