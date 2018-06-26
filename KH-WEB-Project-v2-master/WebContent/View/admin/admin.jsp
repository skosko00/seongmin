<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import = "jsp.admin.model.vo.*,jsp.board.model.vo.*,jsp.member.model.vo.*,java.util.*" %>
<jsp:include page="/View/main/layout/preventurl.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/View/main/layout/cssjs.jsp"></jsp:include>
	<title>관리자</title>
</head>
<body>
<!--  a 태그들은 나중에 서블릿을 만들어야 한다. -->
<!-- <div class="ui bottom attached segment pushable container"> -->
<!-- 
	해야 할 일
	1. 공지사항 최신 5개 출력	(more) 버튼을 누르면 게시판 쪽으로 이동
	2. 1:1 문의 내용 최신 5개 출력 (more) 버튼을 누르면 1:1문의 쪽으로 이동 
	3. 오늘의 현황 처리
	4. 모든 관리자 페이지에서 반응형 처리 필요. 
 -->
 <%
	
	AdminIndexVo aiv = (AdminIndexVo)request.getAttribute("adminInfo");
	
 	int countReserve = 0;
	int countQuestion = 0;
	int countNewMember = 0;
	
	ArrayList<BoardVo> boardList = null;
	ArrayList<QuestionVo> questionList = null;
	%>
	
	<% if(aiv != null){
		countReserve = aiv.getCountReserve();
		countQuestion = aiv.getCountQuestion();
		countNewMember = aiv.getCountNewMember();
		boardList = aiv.getBoardList();
		questionList = aiv.getQuestionList();
	%>
	
  
 
  <jsp:include page="/View/admin/layout/sideMenu.jsp"></jsp:include>
  <!-- 이 부분이 본문 -->
  <div class="ui pusher">
  <!-- 헤더 부분  -->
    <div class="ui segment">
      <h3 class="ui header">Home</h3>
    </div>
    <!-- 콘텐츠  -->
    
    <div class="ui container">
    
    	<!-- 오늘의 현황 시작 -->
    	<!-- 이 부분의 데이터를 넣을 ajax 필요 -->
    	<!--  vo를 따로 하나 만들어서 관리를 하자. -->
    	
      	<div class="ui left align segment">
      		<h3 class="ui header">펜션 현황</h3>
      		<!-- <div class="ui six column relaxed grid list"> -->
      		<div class="ui three column relaxed grid list">
	      		<div class="ui column">
					<i class="calendar alternate icon"></i>
				    <div class="ui content">
				      <a class="header" href="/adminReserveManager">이달의 예약 수</a>
				      <div class="ui description" id="countReserve"><%=countReserve %></div>
				    </div>
	      		</div>
	      		
	      		<!-- <div class="column">
					<i class="map marker icon"></i>
				    <div class="content">
				      <a class="header">오늘의 매출</a>
				      <div class="description">0</div>
				    </div>
	      		</div> -->
	      		
	      		<!-- <div class="column">
					<i class="map marker icon"></i>
				    <div class="content">
				      <a class="header">무통장 입금</a>
				      <div class="description">0</div>
				    </div>
	      		</div> -->
	      		<div class="column">
					<i class="question circle icon"></i>
				    <div class="content">
				      <a class="header" href="/adminQuestionList">미 답변 질문 </a>
				      <div class="description" id="countQuestion"><%=countQuestion %></div>
				    </div>
	      		</div>
	      		
	      		<div class="column">
					<i class="user icon"></i>
				    <div class="content">
				      <a class="header" href="/adminMemberList">이달의 신규 회원</a>
				      <div class="description" id="countMember"><%=countNewMember %></div>
				    </div>
	      		</div>
	      		
      		</div>
      		
   		 </div>
   		<!-- 오늘의 현황 끝 --> 
   		
   		<!-- 공지사항  시작--> 
    	<div class="ui right align fluid segment">
    			<h3 class="ui header" style="display: inline;"> 공지사항 </h3>
    			<!-- 관리자가 공지사항을 등록하는 페이지로 이동  -->
      			<a href="/adminBoardList">more</a>
      			
    			<table class="ui selectable inverted table">
				  <thead>
				    <tr>
				      <th>글 번호</th>
				      <th>제목</th>
				      <th>날짜</th>
				    </tr>
				  </thead>
				  <!-- 이 부분에 따로 글 추가 (최근 5개 정도 )  -->
				  <tbody>
				   <!--  <tr>
				      <td>John</td>
				      <td>Approved</td>
				      <td>None</td>
				    </tr> -->
				    <% if(boardList != null && !boardList.isEmpty()){ %>
					    <%for(BoardVo bv : boardList){ %>
					    <tr>
					    <td><%=bv.getBdNo() %></td>
					     <td><%=bv.getBdName() %></td>
					      <td><%=bv.getBdWriteDate() %></td>
					    </tr>
					    <%}%>
				    <% }else{ %>
				    	<tr>
				    	<td colspan="3">공지사항이 없습니다.</td>
				    	</tr>
				     <%} %>
				  </tbody>
				</table>
    	</div>
    	<!-- 공지사항  끝--> 
    	
    	<!-- 1:1 START -->
    	<!-- 최신 QnA 5개만 불러오자.  -->
    	
    	<div class="ui center align segment">
    		
      			<h3 class="ui header" style="display: inline;"> 1 : 1 질문 </h3>
      			<a href="/adminQuestionList">more</a>
    			<table class="ui selectable inverted table">
				  <thead>
				    <tr>
				      <th>작성자</th>
				      <th>제목</th>
				      <th>날짜</th>
				    </tr>
				  </thead>
				  <!-- 이 부분에 따로 글 추가 (최근 5개 정도 )  -->
				  <tbody>
				    <% if(questionList != null && !questionList.isEmpty()){ %>
					    <%for(QuestionVo qv : questionList){ %>
					    <tr>
					    <td><%=qv.getqWriter() %></td>
					     <td><%=qv.getqName() %></td>
					      <td><%=qv.getqWriteDate() %></td>
					    </tr>
					    <%}%>
				    <% }else{ %>
				    	<tr>
				    	<td colspan="3">공지사항이 없습니다.</td>
				    	</tr>
				     <%} %>
				  </tbody>
				</table>
    	</div>
    	<!--  1:1 END -->
     </div>
  </div>
  <% } %>
<!-- </div> -->

<script>
$(document).ready(function(){
	$('.visible.example .ui.sidebar')
	  .sidebar({
	    context: '.visible.example .bottom.segment'
	  })
	  .sidebar('hide')
	;
});
</script>
</body>
</html>
