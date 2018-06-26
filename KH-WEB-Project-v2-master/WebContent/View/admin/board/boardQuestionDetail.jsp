<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="jsp.member.model.vo.*,jsp.admin.model.vo.*" %>
<jsp:include page="/View/main/layout/preventurl.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/View/main/layout/cssjs.jsp"></jsp:include>
	<title>관리자</title>
</head>
<body>
	<!--  a 태그들은 나중에 서블릿을 만들어야 한다. -->
<!-- 
	1. 1:1 문의 
	2. 답변을 어떻게 할지 정해야 한다.
-->
<!-- 메뉴 바 -->
<jsp:include page="/View/admin/layout/sideMenu.jsp"></jsp:include>
<!-- 이 부분이 본문 -->
<div class="ui pusher">
	<!-- 헤더 부분  -->
	<div class="ui segment">
		<h3 class="ui header">1 : 1 문의 내용</h3>
		
	</div>
	<%
	@SuppressWarnings("all")
	QnAVo qnav = (QnAVo) request.getAttribute("qnaVo");
	if(qnav != null && qnav.getQv()!=null ){
	QuestionVo qv = qnav.getQv();	
	
	%>
	<!-- 본문 내용 시작-->
	<div class="ui container">
		<div class="ui red message"><div class="ui small header">※ 1:1문의에 대한 내용 확인 후 답변을 할 수 있습니다</div></div>
		<!-- 테이블 시작 -->
		<div class="ui segment">
			<h1>1 : 1 문의 내용</h1>
			
			<div class="ui form">
				<div class="five fields">
					<div class="field">
						<span class="ui small header">문의번호</span>
						<input readonly="readonly" type="text" value="<%=qv.getqNo()%>" />
					</div>
					<div class="field">
						<span class="ui small header">문의제목</span>
						<input readonly="readonly" type="text" value="<%=qv.getqName() %>">
					</div>
					<div class="field">
						<span class="ui small header">작성자</span>
						<input readonly="readonly" type="text" value="<%=qv.getqWriter()%>">
					</div>
					<div class="field">
						<span class="ui small header">질문날짜</span>
						<input readonly="readonly" type="text" value="<%=qv.getqWriteDate()%>">
					</div>
					<div class="field">
						<span class="ui small header">답변여부</span>
						<input readonly="readonly" type="text" value="<%=qv.getqAnswerCheck()%>" >
					</div>
				</div>
				<div class="field">
					<span class="ui small header">문의내용</span>
					<textarea readonly="readonly" style="resize: none"><%= qv.getqContents() %></textarea>
				</div>
			</div>
			
			<button class="ui orange button" onclick="goBack();" style="margin-top: 15px;">목록으로</button>
			<!--  답변 작성 -->
			<% if(qnav.getAsv()==null ){ %>
			<button class="ui blue button" onclick="onCommnet();" >답변 작성 </button>
			<%}else{ 
			AnswerVo asv = qnav.getAsv();%>
			<!--  답변이 완료되었을 경우  -->
			
		</div>
		<!-- 답변이 되었다면 답변 내용도 불러오도록 하자... -->

		<div class="ui segment">
			<span class="ui small header">답변내용</span>
			<div class="ui form">
				<textarea  readonly="readonly" style="resize: none"><%= asv.getaContents() %></textarea>
			</div>
		</div>		
		<%} %>
		<!-- -->
		<div id="answer" class="ui basic segment" style="display: none">
			<form  action="/adminInsertAnswer" method="post" class="ui form" >
				<input type="hidden" name="qNo" value="<%=qv.getqNo()%>">
				<div class="ui form">
					<textarea style="resize: none" name="aContents" required="required" placeholder="답변 내용을 작성하세요"></textarea>
				</div>
				<input type="submit" class="ui blue button" value="답변 등록" style="margin-top: 10px;">
				<input type="reset" class="ui green button" value="초기화">
			</form>
		</div>
		
		<% } %>
		
	</div>
	<!-- 본문 내용 끝  -->
</div>

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

<script>
	function goBack(){
		location.href="/adminQuestionList";
	}

	function onCommnet(){
		$('#answer').css("display","");
	}
</script>

</html>