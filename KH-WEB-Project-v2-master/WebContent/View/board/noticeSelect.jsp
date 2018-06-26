<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page errorPage="/View/error/error.jsp"%>
<%@ page import="jsp.board.model.vo.*" import="jsp.member.model.vo.*" import="java.util.*" import="jsp.admin.model.vo.*"%>
<%
BoardTotalInfoVo btlv = (BoardTotalInfoVo)request.getAttribute("board");
@SuppressWarnings("all")
ArrayList<Comment> list = (ArrayList<Comment>) request.getAttribute("comment");

%>
<%
Timestamp writeDay = btlv.getBv().getBdWriteDate();
Timestamp stamp = new Timestamp(Calendar.getInstance().getTimeInMillis());
Date date = new Date(writeDay.getTime());
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
	<title>공지사항 - <%=btlv.getBv().getBdName()%></title>
</head>

<style>
</style>

<body>

	<!-- 헤더 시작  -->
	<jsp:include page="/View/main/layout/header.jsp"></jsp:include>
	<!-- 헤더 끝 -->

	<!-- 본문 시작 -->
	<br>
	<div class="ui container">
		<!-- 여기에 본문 내용 작성하면 됨 -->

		<div class="ui center aligned segment">
			<!-- view에서 눌렀을때 나오는 내용들 -->
			<div class="ui left aligned basic segment" style="margin-bottom: 0px;">
				<span class="ui large header" style="display: inline-block; width: 70%; margin-bottom: 5px;"><i class="bullhorn icon"></i>[공지] <%=btlv.getBv().getBdName()%></span>
				<div class="ui divider"></div>
				<span class="ui small header" style="margin-right: 15px;"><i class="user icon"></i>작성자</span><span style="display: inline-block; width: 20%;"><%=btlv.getBv().getBdWriter()%></span><span class="ui small header" style="margin-right: 15px;"><i class="calendar icon"></i>작성일</span>
				<span style="display: inline-block; width: 20%;"><%=date%></span><span class="ui small header" style="margin-right: 15px;">
					<i class="eye icon"></i>조회수</span>
					<span style="display: inline-block; width: 20%;"><%=btlv.getBv().getBdViewCount() %></span>
					<div class="ui divider"></div>
				</div>
				<div class="ui medium header">공지내용</div>
				<div class="ui form">
					<textarea rows="20" readonly style="resize: none;"><%=btlv.getBv().getBdContents()%></textarea>
					<% for(int i = 0 ; i <btlv.getList().size(); i++){ %>
	    			<img class="ui image" src="<%= btlv.getList().get(i).getBdFilePath()%>" ><br>
	    			<% } %>
				</div>
				<br>
				<button class="ui orange button" onclick="back()">목록</button>
				<!-- 관리자 페이지 쪽으로 이동 & 공지에는 댓글 기능 필요없음 -->
			<!--<%if (session.getAttribute("member") != null) {%>
				<form action="/noticeUpdateReady" style="display:inline;">
					<input type="hidden" name="bdNo" value="<%=btlv.getBv().getBdNo()%>" />
					<input type="submit" value="수정">
				</form>
				<form action="/noticeDelete" method="post" style="display:inline;">
					<input type="hidden" name="bdNo" value="<%=btlv.getBv().getBdNo()%>" />
					<input type="submit" value="삭제">
				</form>
				<%}%>-->
			<!--<h1>댓글</h1>
				<form action="noticeComment" method="post" style="display: inline;" />
				<%if (((MemberVo) session.getAttribute("member")) == null) {%>
				<textarea rows="5" cols="100" name="CM_CONTENTS" readonly
				placeholder="로그인 한 사용자만 댓글 작성이 가능합니다." style="resize: none"
				onclick="login();"></textarea>
				<br>
				<%} else {%>
				<textarea rows="5" cols=100 " name="CM_CONTENTS" placeholder="댓글을 작성하세요" style="resize: none;"></textarea>
				<br> <input type="hidden" name="bdNo"
				value=<%=btlv.getBv().getBdNo()%> /> <input type="submit" value="댓글작성" />
				<%}%> -->
				<br>
				<br>
			</form>

			<%
			for (Comment c : list) {
			%>

			작성자:
			<%=c.getCmWriter()%>
			/ 작성일:
			<%=c.getCmWriteDate()%>
			/ <label id=<%=c.getCmNo()%>><%=c.getCmContents()%></label>
			<%
			if (((MemberVo) session.getAttribute("member")) != null
			&& ((MemberVo) session.getAttribute("member")).getMbId().equals(c.getCmWriter())) {
			%>
			<form action="commentUpdate" method="post" style="display: inline;">
				<input type="hidden" name="CM_CONTENTS" id="<%=c.getCmNo()%>_input" value="<%=c.getCmContents()%>" />
				<input type="hidden" name="CM_NO" value="<%=c.getCmNo()%>" />
				<input type="hidden" name="CM_BD_NO" value="<%=c.getCmBdNo()%>" />
				<button type="button" id="<%=c.getCmNo()%>_btn" onclick="modify(<%=c.getCmNo()%>);">수정</button>
				<input type="hidden" id="<%=c.getCmNo()%>_submit" value="수정">
				<button type="button" id="<%=c.getCmNo()%>_reBtn" style="display: none;" onClick="cancle(<%=c.getCmNo()%>);">취소</button>
			</form>

			<form action="commentDelete" style="display: inline">
				<input type="hidden" name="CM_NO" value="<%=c.getCmNo()%>" />
				<input type="hidden" name="CM_BD_NO" value="<%=c.getCmBdNo()%>" />
				<input type="submit" value="삭제" />
			</form>
			<%
		}
		%>
		<br>
		<%
	}
	%>
</div>
</div>
<!-- 본문 끝 -->

<!-- 푸터 시작  -->
<jsp:include page="/View/main/layout/footer.jsp"></jsp:include>
<!-- 푸터 끝 -->
</body>
<script>
	function modify(id){
		document.getElementById(id).style="display:none";
		document.getElementById(id+"_input").type="text";
		document.getElementById(id+"_btn").style="display:none";
		document.getElementById(id+"_submit").type="submit";
		document.getElementById(id+"_reBtn").style="display:inline";
	}
	function cancle(id){
		document.getElementById(id).style="display:inline";
		document.getElementById(id+"_input").type="hidden";
		document.getElementById(id+"_btn").style="display:inline";
		document.getElementById(id+"_submit").type="hidden";
		document.getElementById(id+"_reBtn").style="display:none";
	}

	function back(){
		location.href="/board";
	}
</script>

</html>
