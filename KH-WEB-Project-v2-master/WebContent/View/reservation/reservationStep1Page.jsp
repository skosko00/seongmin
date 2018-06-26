<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page errorPage="/View/error/error.jsp"%>

<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jsp.reservation.model.vo.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jsp.member.model.vo.*"%>

<%
@SuppressWarnings("all")
ArrayList<ReservationVo> rvList = (ArrayList<ReservationVo>) request.getAttribute("reservationList");
@SuppressWarnings("all")
ArrayList<PensionVo> pvList = (ArrayList<PensionVo>) request.getAttribute("pensionList");
MemberVo m = (MemberVo)session.getAttribute("member");
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
	<script src='https://www.google.com/recaptcha/api.js'></script>
	<jsp:include page="/View/main/layout/cssjs.jsp"></jsp:include>
	<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
	<title>step1. 예약 날짜 선택</title>
</head>

<style>
table {
	border-collapse: collapse;
}
</style>

<!-- 로그인 여부  -->
<c:set value="${sessionScope.member.mbId}" var="id"></c:set>
<c:choose>
<c:when test="${empty id}">
<script type="text/javascript">
  $(document).ready(function() {
    $('#loginCheck').show();
  });
</script>
</c:when>
<c:otherwise>
<script type="text/javascript">
  $(document).ready(function() {
    $('#loginCheck').html("<i class='close icon'></i><div class='ui small header'>※ 예약 전 꼭 <a href='/reservationGuide'>예약안내</a>를 읽어보시기 바랍니다.</div>");
    $('#loginCheck').show();
  });
</script>
</c:otherwise>
</c:choose> 


<body>
	<!-- 헤더 -->
	<jsp:include page="/View/main/layout/header.jsp"></jsp:include>
	<!-- 헤더 끝 -->

	<br>
	<div class="ui container">

		<div class="ui four top attached steps">
			<div class="active step">
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

		<div class="ui green message">
			<i class="close icon"></i>
			<div class="ui small header">※ 예약하시려면 아래에서 예약할 방을 선택해주세요.<br>예약은 <span style="color: red;">내일</span> 부터 <span style="color: red;">6개월</span>까지만 가능합니다<span style="color: red;">(당일 예약은 불가능합니다.)</span><br>
        객실에 대한 자세한 정보는 <a href="/roomIntroduce">객실안내</a>를 참고해주세요. 
        <div style="margin-top: 15px;">
         <button class="ui blue basic button" style="padding-top: 20px;"></button><span style="color : black"> = 예약가능한방 </span>
         <button class="ui red basic button" style="padding-top: 20px; margin-left: 15px;"></button><span style="color : black"> = 예약중인방</span>
       </div>
     </div></div>

     <div class="ui red message" id="loginCheck" style="display: none">
      <i class="close icon"></i>
      <div class="ui small header">※ 예약하려면 로그인이 필요합니다.</div>
    </div>

    <div class="ui center aligned basic segment">
      <table class="ui orange table" id="calendar" border="1" align="center">
       <thead>
        <tr align="center">
         <td>
          <button class="ui inverted orange button" onclick="prevCalendar()">
           <i class="angle left icon" style="margin: 0;"></i>
         </button>
       </td>
       <td colspan="5" id="calendarYM"></td>
       <td>
        <button class="ui inverted orange button" onclick="nextCalendar()">
         <i class="angle right icon" style="margin: 0;"></i>
       </button>
     </td>
   </tr>
   <tr align="center">
     <th style="border-top: 0px;">일</th>
     <th style="border-top: 0px;">월</th>
     <th style="border-top: 0px;">화</th>
     <th style="border-top: 0px;">수</th>
     <th style="border-top: 0px;">목</th>
     <th style="border-top: 0px;">금</th>
     <th style="border-top: 0px;">토</th>
   </tr>
 </thead>


</table>
</div>

</div>


<!-- 푸터 -->
<jsp:include page="/View/main/layout/footer.jsp"></jsp:include>
<!-- 푸터 끝 -->
</body>


<!-- 로그인 안했을 경우-->
<div class="ui mini modal" id="needLogin">
  <div class="header">로그인</div>
  <div class="content">
   <label style="margin-left: 4px;">아이디</label>
   <div class="ui input" style="margin-left: 10px;">
    <input type="text" id="id" placeholder="아이디" maxlength="16">
  </div>
  <br><br>
  <label>비밀번호</label>
  <div class="ui input">
    <input type="password" id="pwd" placeholder="비밀번호" maxlength="16">
  </div>
  <br><br>
  <div class="ui centered grid">
    <div id="recap" class="g-recaptcha" data-sitekey="6Lfrr18UAAAAAGd424fRQMeX4GYy6FjS7Af1V8tJ"></div>
  </div>
  <div class="ui centered grid" id="naverLoginBtn">
    <div id="naver_id_login" style="margin-top: 10px;"></div>
  </div>
</div>
<div class="actions">
 <div class="ui blue cancel button" id="confirm">로그인</div>
 <div class="ui orange cancel button">취소</div>
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


<script type="text/javascript">

  <%
      Calendar cal = Calendar.getInstance(); // 이전 달과 다음 달을 비교하기 위해 생성함
      %>

   var today = new Date(<%=cal.get(Calendar.YEAR)%>, <%=cal.get(Calendar.MONTH) %>, <%= cal.get(Calendar.DATE)%>); // 달력이 넘어갈 때의 현재 시간
   var standardTime = new Date(<%=cal.get(Calendar.YEAR)%>, <%=cal.get(Calendar.MONTH) %>, <%= cal.get(Calendar.DATE)%>); // 실제 현재 시간

   function prevCalendar() { // 이전 달력
   	today = new Date(today.getFullYear(), today.getMonth() - 1, today.getDate());
   	if(standardTime.getTime() <= today.getTime()) {
          //console.log("현재 기준 : " + test.getFullYear()+"-"+(test.getMonth()+1)+"-"+test.getDate());
          //console.log("해당 월 변수 : " + today.getFullYear()+"-"+(today.getMonth()+1)+"-"+today.getDate());
          buildCalendar();
        } else {
        	today = new Date(today.getFullYear(), today.getMonth()+1, today.getDate());
        }
      }

   function nextCalendar() { // 다음 달력
   	today = new Date(today.getFullYear(), today.getMonth() + 1, today.getDate());
       //console.log("현재 기준 : " + test.getFullYear()+"-"+(test.getMonth()+1)+"-"+test.getDate());
       //console.log("해당 월 변수 : " + today.getFullYear()+"-"+(today.getMonth()+1)+"-"+today.getDate());

       // 현재 월의 6개월 후까지만 보여짐

       // 6개월 차이나는 계산식
       var diffMonth = Math.round((today.getTime()-standardTime.getTime())/(1000*60*60*24*365/12));

       if(diffMonth <= 6) {
       	buildCalendar();
       }
     }


     function buildCalendar() {


      var psNameArr = new Array(<%=pvList.size()%>); // 이름들만 담는 배열 선언
      var index=0;
      <%
      for(PensionVo pv : pvList) {
      	%>
      	psNameArr[index++] = "<%=pv.getPsName()%>";

      	<% } %>

      //console.log(psNameArr);
      
      var nMonth = new Date(today.getFullYear(), today.getMonth(), 1); // 이번달의 첫번째날
      var lastDate = new Date(today.getFullYear(), today.getMonth() + 1, 0); // 이번달의 마지막날
      
      var tblCalendar = document.getElementById("calendar"); // 테이블 달력을 만드는 테이블
      var tblCalendarYM = document.getElementById("calendarYM"); /// XXXX년도XX월 출력
      
      tblCalendarYM.innerHTML = "<h2 align='center'>" + today.getFullYear() + "년 " + (today.getMonth() + 1) + "월 </h2>";
      // 사용자가 선택할 수 있게 변경 -> 할 수 있다면...!

      // 기존에 테이블에 있던 달력 내용 삭제
      while (tblCalendar.rows.length > 2) {
      	tblCalendar.deleteRow(tblCalendar.rows.length - 1);
      }

      var row = null;
      row = tblCalendar.insertRow();
      var cnt = 0;
      // 1일이 시작되는 칸을 맞추어줌

      
      // 달력 출력
      // form method -> post로 변경하기??
      // 지금은 j값으로 방 이름을 하지만 DB에 등록된 방 이름이 나와야할 것 같고ㅜㅡㅜ 템플릿적인 요소도 생각해야함...ㅠㅜ 
      
      for (i = 0; i < nMonth.getDay(); i++) {
      	cell = row.insertCell();
      	cnt = cnt + 1;
      }



      // 예약된 날짜를 알기 위한 배열 생성
      var arr = new Array();
      for(var i=0; i<lastDate.getDate(); i++) {
           arr[i] = new Array(<%=pvList.size()%>); // 방 개수 일단 6개 -> 수정완료
           for(var j=0; j<<%=pvList.size()%>; j++) {
           	arr[i][j] = 0;
           }
         }

         for (var i = 1; i <= lastDate.getDate(); i++) {

           for(var j=0; j<<%=pvList.size()%>; j++) { // 객실 정보 테이블의 총 객실 수 만큼 반복(지금은 일단 6개로 지정) -> 수정 완료

           	<%
               for(ReservationVo r : rvList) { // 모든 체크인 날짜와 체크아웃 날짜를 알기 위해 모든 예약 정보를 불러옴
                    Calendar calIn = Calendar.getInstance(); // 체크인 날짜
                    calIn.setTime(r.getResInDate());

                    Calendar calOut = Calendar.getInstance(); // 체크아웃 날짜
                    calOut.setTime(r.getResOutDate());

                    //System.out.println("intime: "+calIn.getTime());
                    //System.out.println("outtime: "+calOut.getTime());
                    //System.out.println("-----------------------------");
                    %>

               // 각 해당 날짜의 방과 체크인 날짜가 겹치는 경우
               if(<%=calIn.get(Calendar.YEAR)%> == today.getFullYear() && <%=(calIn.get(Calendar.MONTH)+1)%> == (today.getMonth()+1) 
               	&& <%=calIn.get(Calendar.DATE)%> == i && "<%=r.getResRoomName()%>" == psNameArr[j]) {

                    // 예약된 날짜가 월말 ~ 다음달 월초를 걸치지 않는 경우
                    if(lastDate.getDate()-i >= 6) { // 최대 예약 날짜가 6박 7일이기 때문에 마지막날과 해당날짜의 차이가 6이상이어야 함 
                    	for(var p=i; p < i+<%=r.getResPeriod()%>; p++) {
                    		arr[p-1][j] = 1;
                    	}
                    } else { // 예약된 날짜가 월말 ~ 다음달 월초를 걸치는 경우
                       for(var p=i; p <= lastDate.getDate(); p++) { // 1. 월말
                    	   	   //console.log("월말: "+p);
                    	   	   arr[p-1][j] = 1;
                    	   	   if(p==(<%=calOut.get(Calendar.DATE)%>-1)) {
                            	   //console.log("스탑");
                            	   break;
                            	 }
                            	}
                            }
                    continue; // 다음 예약 정보로 넘어가기
                  }

                 // 예약된 날짜가 월말 ~ 다음달 월초를 걸치는 경우
                 if(<%=calOut.get(Calendar.YEAR)%> == today.getFullYear() && <%=(calOut.get(Calendar.MONTH)+1)%> == (today.getMonth()+1) 
                 	&& <%=calOut.get(Calendar.DATE)%> == i && "<%=r.getResRoomName()%>" == psNameArr[j]) {
                    // 2. 월초
                    if(<%=calIn.get(Calendar.MONTH)+1%> != <%=calOut.get(Calendar.MONTH)+1%>) { // 예약된 정보 중의 체크인 날짜와 체크아웃 날짜의 월이 다른 경우
                       for(var p=1; p<=<%=calOut.get(Calendar.DATE)-1%>; p++) { // 1일 부터 체크아웃날짜까지
                       	/*   	console.log("월초: "+p);*/
                       	arr[p-1][j] = 1;
                    	   continue; // 다음 예약 정보로 넘어가기
                    	 }
                    	}
                    }
                    <% } %>
                  }
                }
       // 지난 날짜인 경우
       for (var i = 1; i <= lastDate.getDate(); i++) {
       	for(var j=0; j<<%=pvList.size()%>; j++) {
           if(standardTime.getTime() >= new Date(today.getFullYear(), today.getMonth(), i)) { // 지은 수정(당일예약막기)
           	arr[i-1][j] = 2;
           }
         }
       }
       //console.log(arr);

       // 출력
       for (i = 1; i <= lastDate.getDate(); i++) {

       	cell = row.insertCell();

       	var str = "";

          for(var j=0; j<<%=pvList.size()%>; j++) { // 객실 정보 테이블의 총 객실 수 만큼 반복(지금은 일단 6개로 지정) -> 수정

          	if(arr[i-1][j] == 2) {
          		str += "<button class='mini ui red basic button' style='margin-bottom:3px; width:100%; font-size:12px; opacity: 0; cursor: default; data-content='"+psNameArr[j]+"' id='testBtn"+[j]+"'>"+psNameArr[j]+"</button><br>";
          	} else if(arr[i-1][j] == 1) {
          		str += "<button class='mini ui red basic button' style='margin-bottom:3px; width:100%; font-size:12px; data-content='"+psNameArr[j]+"' id='testBtn"+[j]+"'>"+psNameArr[j]+"</button><br>";
          	} else {
            	   <% if(m==null) { %> // 로그인 안됐을경우
            	   	str += "<button class='mini ui blue basic button' style='margin-bottom:3px; width:100%; font-size:12px;' onclick='loginPlease();' data-content='"+psNameArr[j]+"' id='testBtn"+[j]+"'>"+psNameArr[j]+"</button><br>";
            	   	<% } else { %>
            	   		str += "<form action='/reservationSecondStep' method='post'>"
            	   		+ "<input type='hidden' name='year' value="+ today.getFullYear() +">"
            	   		+ "<input type='hidden' name='month' value="+ (today.getMonth()+1) +">"
            	   		+ "<input type='hidden' name='day' value="+ i +">"
            	   		+ "<input type='hidden' name='roomName' value="+psNameArr[j]+">"
            	   		+ "<input type='submit' class='mini ui blue basic button' value='"+psNameArr[j]+" O' style='margin-bottom:3px; width:100%; font-size:12px;'>"
            	   		+ "</form>";
            	   		<% } %>
            	   	}
            	   	$('#testBtn'+[j]).popup();
            	   }

            	   cell.innerHTML = "<h4>"+i+"</h4>"+str;

            	   cnt = cnt + 1;
           if (cnt % 7 == 0) // 1주 = 7일
           	row = calendar.insertRow();
         }

       }

       function loginPlease() {
       	$('#needLogin').modal('show');
       }


       $('#confirm').click(function(){

       	var id = $('#id').val();
       	var pwd = $('#pwd').val();

       	if (id == "" || pwd == "") {
       		$('#blankModal')
       		.modal('show');
       		return false;
       	} else {
       		var auth = grecaptcha.getResponse();
       		if(auth.length == 0){
       			$('#robot').modal('show');
       			return false;
       		} else {
       			$.ajax({
       				url : '/loginImmediate',
       				type : 'POST',
       				data : {id : id, pwd : pwd},
       				success: function(data){
       					if(data == "1"){
       						location.reload();
       					} else {
       						alert('아이디 또는 비밀번호를 확인해주세요')
       					}
       				}, 
       				error : function(){
       					alert('서버 오류 (잠시 후 다시 시도 해주세요');
       				}
       			});

       		}
       	}
       });

       // 메세지 닫기
       $('.message .close')
       .on('click', function() {
       	$(this)
       	.closest('.message')
       	.transition('fade')
       	;
       })
       ;

       // 달력추가
       buildCalendar();

       /* 네아로 */
       var naver_id_login = new naver_id_login("PyoIesHAhe6a3F1GDj9P", "http://localhost/View/member/naverLoginCallBackNowPage.jsp");
       var state = naver_id_login.getUniqState();
       naver_id_login.setButton("green", 3, 35);
       naver_id_login.setDomain("http://localhost/View/member/naverLogin.jsp");
       naver_id_login.setState(state);
       naver_id_login.setPopup(); /* 팝업 로그인 창*/
       naver_id_login.init_naver_id_login();

     </script>
     </html>