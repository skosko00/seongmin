<!-- step2. 상세사항(예약 정보) 선택 : detailSelect.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<%@page import="jsp.reservation.model.vo.*"%>
<%@page import="jsp.member.model.vo.*"%>
<jsp:include page="/View/main/layout/preventurl.jsp"></jsp:include>
<% 
String loginId = ((MemberVo)session.getAttribute("member")).getMbId();
%>


<% 
PensionVo pv = (PensionVo)request.getAttribute("pensionInfo");
@SuppressWarnings("all")
ArrayList<ReservationVo> list = (ArrayList<ReservationVo>)request.getAttribute("reservationDateList");
%>


<!DOCTYPE html>
<html>

<head>

	<!-- Global site tag (gtag.js) - Google Analytics -->
	<script async
	src="https://www.googletagmanager.com/gtag/js?id=UA-120156974-1"></script>
	<script>
		window.dataLayer = window.dataLayer || [];
		function gtag() {
			dataLayer.push(arguments);
		}
		gtag('js', new Date());
		gtag('config', 'UA-120156974-1');
	</script>

	<jsp:include page="/View/main/layout/cssjs.jsp"></jsp:include>

	<title>step2. 예약 정보 선택</title>
</head>

<style>
table {
	border-collapse: collapse;
}
</style>

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
			<div class="active step">
				<i class="tasks icon"></i>
				<div class="content">
					<div class="title">예약 정보 선택</div>
					<div class="description"></div>
				</div>
			</div>
			<div class="disabled step">
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

		<div class="ui red message">
			<i class="close icon"></i>
			<div class="header">
				예약을 계속 하려면 예약기간과 인원을 선택 후 예약하기 버튼을 클릭하세요.
			</div>
		</div>
		<div class="ui center aligned segment">
			<%
			String yearStr = request.getParameter("year");
			String monthStr = request.getParameter("month");
			String dayStr = request.getParameter("day");

			String dateStr = yearStr+"-"+monthStr+"-"+dayStr;
			
			
			String room = request.getParameter("roomName");
			//String dateStrtt = (String)request.getAttribute("dateStr");
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
			Date date = sdf.parse(dateStr);

			Calendar c = Calendar.getInstance();
			c.setTime(date);
			
			%>

			<table class="ui table" id="calendar" border="1"  width="800" height="400">

				<tr>
					<td class="center aligned" style="background: #f9fafb;"><div class="ui small header";">예약기간 선택</div></td>
					<td>
						<span class="ui form">
							<span class="ui tiny header" style='padding-left: 8px;'><%=dateStr%> 부터</span>
							<select name="period" id="period" onchange="chargeSum();" style="width: 120px;">
								<%

						long diffDays = 6; //수정

						for(ReservationVo r : list) {
						if(room.equals(r.getResRoomName())) {
						Date resInDate = new Date(r.getResInDate().getTime());
						long diff = resInDate.getTime() - date.getTime();
						diffDays = diff / (24 * 60 * 60 * 1000);
						if(diffDays > 0) {
						break;
					} else {
									diffDays=6; // 추가
								}
							}
						}

						//System.out.println(diffDays);


						for(int i=1; i<=diffDays; i++) {
						if(i>6) {
						break;
					}
					%>
					<option value=<%=i%>><%=i%>박 <%=i+1%>일</option>
					<% } %>				
				</select>
			</span>
		</td>
	</tr>
	<tr>
		<td class="center aligned" style="background: #f9fafb;"><div class="ui small header">객실 선택</div></td>
		<td>
			<table class="ui celled table" id="calendar" >
				<thead>
					<tr class="center aligned">
						<th>객실명</th>
						<th>기준인원</th>
						<th>최대인원</th>
						<th>인원선택</th>
					</tr>
				</thead>
				<tbody>
					<tr class="center aligned">
						<td><%=pv.getPsName()%></td>
						<td><%=pv.getPsPersonnel()%></td>
						<td><%=pv.getPsMaxPersonnel()%></td>
						<td>
							<div class="ui centered grid" style="margin-top: 5px; margin-bottom: 5px;">
								<span class="ui form">
									<select name="personnel" id="personnel" onchange="chargeSum();" style="width: 80px;">
										<option value=0 selected>선택</option>
										<% for(int i=1; i<=pv.getPsMaxPersonnel(); i++) { %>
										<option value=<%=i%>><%=i%>명</option>
										<% } %>
									</select>
								</span>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="5">
							* 아동 및 유아도 개월 수 상관없이 인원에 포함됩니다. <br>
							* 예약 시 등록한 인원과 실제 이용인원이 다르면 강제 퇴실 조치 되오니 꼭 지켜주세요.<br>
							* 기준인원 초과 시 인원당 추가 요금이 있습니다.
						</td>
					</tr>
				</tbody>
			</table>
		</td>
	</tr>
	<tr>
		<td class="center aligned" style="height: 200px; background: #f9fafb;"><div class="ui small header">객실 요금</div></td>
		<td>

			<div class="ui orange message" id="chkMessage"><div class="ui small header">예약기간 및 인원을 선택해주세요</div></div>

			<table class="ui center aligned celled table" id="charge" style="display:none;" >
				<thead>
					<tr>
						<th>객실명</th>
						<th>입실</th>
						<th>퇴실</th>
						<th>기간</th>
						<th>요금</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><%=pv.getPsName()%></td>
						<td><%=dateStr%> 14:00 이후</td>
						<td id="printOutDate"></td>
						<td id="printPeriod"></td>
						<td id="printTotalMoney"></td>
					</tr>
					<tr id="chargeInfo" style="display:none;">
						<td colspan="5">
							추가 인원 1인 당 <%=pv.getPsAddtionalPrice()%>원
						</td>
					</tr>
				</tbody>

			</table>
		</td>
	</tr>

</table>
<form action="/reservationThirdStep" method="POST" style="display:inline;"> <!-- 나중에 post로 바꾸기 지금은 확인해야댕 -->
	<!-- res_no -->
	<input type="hidden" name="loginId" value="<%=loginId%>" />
	<input type="hidden" name="res_room_name" value="<%=pv.getPsName()%>" />
	<input type="hidden" name="res_personnel" id="res_personnel" value="" />
	<!-- res_reservation_date -->
	<input type="hidden" name="res_in_date" id="res_in_date" value=""/>
	<input type="hidden" name="res_out_date" id="res_out_date" value=""/>
	<input type="hidden" name="res_period" id="res_period" value=""/>
	<input type="hidden" name="res_price" id="res_price" value=""/>
	<input type="submit" id="step3Submit" class="ui blue button" value="예약하기" onclick="return submitForm();" style="display:inline;"/>		
</form>
<input type="button" id="step3Reset" class="ui orange button" value="처음으로" onclick="back();" style="display:inline;"/>
</div>
</div>

<!-- 푸터 -->
<jsp:include page="/View/main/layout/footer.jsp"></jsp:include>
<!-- 푸터 끝 -->

</body>

<script>

	function chargeSum() {
		
		//console.log("chargeSum()실행");
		
		var period = document.getElementById("period");
		var periodValue = period.options[period.selectedIndex].value;
		
		//console.log("periodValue: "+periodValue); // 숙박 수는 잘되구..
		
		var year = <%=yearStr%>;
		var month = <%=monthStr%>-1;
		var inDay = <%=dayStr%>;
		var outDay = <%=dayStr%>+(Number(periodValue)-1);
		
		//console.log("indate: "+year+"/"+month+"/"+inDay);
		//console.log("outdate: "+year+"/"+month+"/"+outDay);
		
		var inDate = new Date(year, month, inDay); // 입실일
	    var outDate = new Date(year, month, outDay); // 3박 4일이면 3박-1 값이 더해져야함..!!
	    var count = 0; // 평일, 주말 체크할 카운트변수
	    
	    //console.log(inDate);
	    //console.log(outDate);
	    
	    
	    while(true) {  
	    	var tempDate = inDate;
	    	if(tempDate.getTime() > outDate.getTime()) {
	            //console.log("count : " + count); // 평일
	            break;
	        } else {
	        	var tmp = tempDate.getDay();
	        	if(!(tmp == 0 || tmp == 6)) {
	            	count++; // 평일
	            }
	            tempDate.setDate(inDate.getDate() + 1); 
	        }
	    }
	    
	    var weekdayCnt = count; // 평일
	    var weekendCnt = periodValue - weekdayCnt; // 주말
	    
	    var money = weekdayCnt*<%=pv.getPsWeekday()%> + weekendCnt*<%=pv.getPsWeekend()%>;

	    // 선택값이 기준 값보다 크면 추가요금 진행
	    var personnel = document.getElementById("personnel");
		var personnelValue = personnel.options[personnel.selectedIndex].value; // 인원수
		// alert(personnelValue);
		
		
		
		var addperson = 0;
		if(personnelValue > <%=pv.getPsPersonnel()%>) { // 기준인원보다 크면
			addperson = personnelValue - <%=pv.getPsPersonnel()%>;
		}
		
		var totalMoney = money + addperson*<%=pv.getPsAddtionalPrice()%>;

		
		var outDateStr = outDate.getFullYear()+"-"+(outDate.getMonth()+1)+"-"+outDate.getDate();
		// 퇴실일 포함한 날
		
		if(personnelValue==0) { // 인원수 선택이 0(선택)일 때는 요금표를 다시 숨김
			$('#chkMessage').show();
			document.getElementById("charge").style="display:none";
			document.getElementById("chargeInfo").style="display:none";


		} else {

			document.getElementById("printOutDate").innerHTML = outDateStr+" 11:00 이전";
			document.getElementById("printPeriod").innerHTML = periodValue+"박 "+(Number(periodValue)+1)+"일";
			document.getElementById("printTotalMoney").innerHTML = totalMoney+"원";
			$('#chkMessage').hide();
			document.getElementById("charge").style="display:visible";

			
			if(personnelValue > <%=pv.getPsPersonnel()%>) { // 추가인원 1인당 금액 나오게하기
				document.getElementById("chargeInfo").style="display:visible";
				
			} else {
				document.getElementById("chargeInfo").style="display:none";
			}

		}
		
		document.getElementById("res_personnel").value = personnelValue;
		document.getElementById("res_in_date").value = <%=yearStr%>+"-"+<%=monthStr%>+"-"+<%=dayStr%>;
		document.getElementById("res_out_date").value = outDateStr;
		document.getElementById("res_period").value = periodValue;
		document.getElementById("res_price").value = totalMoney;
		
		
		
	}
	
	function submitForm() {
		

		var personnel = document.getElementById("personnel");
		var personnelValue = personnel.options[personnel.selectedIndex].value;
		
		var emptyRP = document.getElementById("res_personnel").value;
		var emptyRID = document.getElementById("res_in_date").value;
		var emptyROD = document.getElementById("res_out_date").value;
		var emptyRPer = document.getElementById("res_period").value;
		var emptyRPri = document.getElementById("res_price").value;

		
		if(personnelValue==0 || personnelValue==null) {
			alert("인원을 선택해주세요.");
			return false;
		} else if(emptyRP==""||emptyRID==""||emptyROD==""||emptyRPer==""||emptyRPri=="" || personnelValue=="") {
			alert("객실 요금 확인 후 예약을 진행해주세요.\n기간 및 인원을 재선택해주세요.");
			return false;
		}
		
	}
	
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

</html>
