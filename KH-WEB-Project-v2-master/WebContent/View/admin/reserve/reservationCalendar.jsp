<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*,jsp.admin.model.vo.*,jsp.reservation.model.vo.*,jsp.member.model.vo.*" %>
<jsp:include page="/View/main/layout/preventurl.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/View/main/layout/cssjs.jsp"></jsp:include>
	<style>
	table {
		border-collapse: collapse;
	}
</style>
<title>관리자</title>
</head>
<body>
  <%
  @SuppressWarnings("all")
  ArrayList<ReservationVo> rvList = (ArrayList<ReservationVo>) request.getAttribute("reservationList");
  @SuppressWarnings("all")
  ArrayList<PensionVo> pvList = (ArrayList<PensionVo>) request.getAttribute("pensionList");
  /*  MemberVo m = (MemberVo)session.getAttribute("member"); */
  %>
<!--  
	1. 달력 추가
	2. 클릭 시 상세 페이지 출력하도록 하자
-->
<!-- 메뉴 바 -->
<jsp:include page="/View/admin/layout/sideMenu.jsp"></jsp:include>
<!-- 메뉴 끝  -->
<!-- 본문 내용 시작 -->
<div class="ui pusher">

  <!-- 헤더 부분  -->
  <div class="ui segment">
    <h3 class="ui header">예약 관리</h3>
  </div>
  <!-- 본문 내용 시작-->
  <div class="ui container" style="margin-bottom: 50px;">
    <div class="ui red message"><div class="ui small header">※ 현재 예약 중인 정보를 달력형식으로 확인합니다</div></div>
    <div class="ui icon message">
      <i class="calendar outline icon"></i>
      <div class="content">
        <div class="header" style="text-align: center;">
          <h1>
            현재 예약 목록
          </h1>
        </div>
      </div>
    </div>


    <div class="ui center aligned segment">
     <table class="ui table" id="calendar" border="1" align="center" width="800" height="500">
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
   <th>일</th>
   <th>월</th>
   <th>화</th>
   <th>수</th>
   <th>목</th>
   <th>금</th>
   <th>토</th>
 </tr>
</table>
</div>

</div>
<!-- 본문 내용 끝  -->
</div>

<script>
  $(document).ready(function(){
   $('.visible.example .ui.sidebar')
   .sidebar({
     context: '.visible.example .bottom.segment'
   })
   .sidebar('hide');
 });
</script>
<script type="text/javascript">

 <%
      Calendar cal = Calendar.getInstance(); // 이전 달과 다음 달을 비교하기 위해 생성함
      %>

   var today = new Date(<%=cal.get(Calendar.YEAR)%>, <%=cal.get(Calendar.MONTH) %>, <%= cal.get(Calendar.DATE)%>); // 달력이 넘어갈 때의 현재 시간
   var standardTime = new Date(<%=cal.get(Calendar.YEAR)%>, <%=cal.get(Calendar.MONTH) %>, <%= cal.get(Calendar.DATE)%>); // 실제 현재 시간

   function prevCalendar() { // 이전 달력
    today = new Date(today.getFullYear(), today.getMonth() - 1, today.getDate());
    if(standardTime.getTime() <= today.getTime()) {
      buildCalendar();
    } else {
      today = new Date(today.getFullYear(), today.getMonth()+1, today.getDate());
    }
  }

   function nextCalendar() { // 다음 달력
     today = new Date(today.getFullYear(), today.getMonth() + 1, today.getDate());
     
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
                        console.log("월초: "+p);
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
           if(standardTime.getTime() > new Date(today.getFullYear(), today.getMonth(), i)) {
            arr[i-1][j] = 2;
          }
        }
      }
      
       // 출력
       for (i = 1; i <= lastDate.getDate(); i++) {

        cell = row.insertCell();
        
        var str = "";
        
        
          for(var j=0; j<<%=pvList.size()%>; j++) { // 객실 정보 테이블의 총 객실 수 만큼 반복(지금은 일단 6개로 지정) -> 수정

           if(arr[i-1][j] == 2) {
             str += "<button class='ui black basic button' style='margin-bottom:3px; width:100%;opacity:0;cursor:default;'>기간만료</button><br>";
            	 // 이 부분을 클릭하면 예약한 정보를 보는 페이지로 넘어가게 하자. (detail 페이지로...)
                /* str += "<form action='/adminReservationDetail' method='post' >"
	                  + "<input type='hidden' name='year' value="+ today.getFullYear() +">"
	                  + "<input type='hidden' name='month' value="+ (today.getMonth()+1) +">"
	                  + "<input type='hidden' name='day' value="+ i +">"
	                  + "<input type='hidden' name='roomName' value="+psNameArr[j]+">"
	                  + "<input type='submit' class='ui black basic button' value='"+psNameArr[j]+" O' style='margin-bottom:3px; width:100%;'>"
                   + "</form>";  */
                 } else if(arr[i-1][j] == 1) {
                  /* str += "<button class='ui black basic button' style='margin-bottom:3px; width:100%;'>기간만료</button><br>"; */
              	 // 이 부분을 클릭하면 예약한 정보를 보는 페이지로 넘어가게 하자. (detail 페이지로...)
                str += "<form action='/adminReservationDetail' method='post'>"
                + "<input type='hidden' name='year' value="+ today.getFullYear() +">"
                + "<input type='hidden' name='month' value="+ (today.getMonth()+1) +">"
                + "<input type='hidden' name='day' value="+ i +">"
                + "<input type='hidden' name='roomName' value="+psNameArr[j]+">"
                + "<input type='submit' class='ui red basic button' value='"+psNameArr[j]+" O' style='margin-bottom:3px; width:100%;'>"
                + "</form>";

              } else {

            	  /*  str += "<form action='/adminReservationDetail' method='post'>"
                       + "<input type='hidden' name='year' value="+ today.getFullYear() +">"
                       + "<input type='hidden' name='month' value="+ (today.getMonth()+1) +">"
                       + "<input type='hidden' name='day' value="+ i +">"
                       + "<input type='hidden' name='roomName' value="+psNameArr[j]+">"
                       + "<input type='submit' class='ui blue basic button' value='"+psNameArr[j]+" O' style='margin-bottom:3px; width:100%;'>"
                       + "</form>"; */
                       str += "<button class='ui blue basic button' style='margin-bottom:3px; width:100%;'>"+psNameArr[j]+"</button><br>";

                     }
                     
                   }
                   
                   cell.innerHTML = "<h4>"+i+"</h4>"+str;
                   
                   cnt = cnt + 1;
           if (cnt % 7 == 0) // 1주 = 7일
            row = calendar.insertRow();
        }
        
      }
      
   /* function loginPlease() {
	   alert("로그인 후 이용해주세요.");
	   location.href="/View/member/login.jsp";
   } */


 </script>

 <script type="text/javascript">

   buildCalendar();

 </script>
</body>
</html>
