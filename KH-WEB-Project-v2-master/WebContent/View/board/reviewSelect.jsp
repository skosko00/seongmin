<%@page import="java.util.regex.Matcher"%>
<%@page import="java.util.regex.Pattern"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="jsp.board.model.vo.*" import="jsp.member.model.vo.*" import="java.util.*" import="jsp.admin.model.vo.*"%>
<%
MemberVo m = (MemberVo) session.getAttribute("member");
BoardTotalInfoVo btlv = (BoardTotalInfoVo) request.getAttribute("review");
int rmConfirm = (int) request.getAttribute("rmConfirm");
System.out.println(rmConfirm);

@SuppressWarnings("all")
ArrayList<Comment> list = (ArrayList<Comment>) request.getAttribute("comment");
int index = 0;
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
	<title>후기게시판 - <%=btlv.getBv().getBdName()%></title>
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

		<div class="ui center aligned segment" style="padding-bottom: 0px;">
			<!-- view에서 눌렀을때 나오는 내용들 -->
			<div class="ui left aligned basic segment" style="margin-bottom: 0px;">
				<span class="ui large header" style="display: inline-block; margin-bottom: 5px;"><i class="comment icon"></i>[후기] <%=btlv.getBv().getBdName()%></span>
				<!-- 추천 버튼 위치 옮김 -->
				<%
				if (m != null) {
				if (rmConfirm == 0) {
				%>
				<form id="rmBd" method="get" style="display: inline;">
					<!-- 추천수 중복되는 걸 막기위해서 아이디 당 한번씩밖에 안되도록 설정 -->
					<input type="hidden" name="bdNo" value="<%=btlv.getBv().getBdNo()%>" />
					<!-- <input type="button" id="submitRmBd" class="ui icon button" value="추천" /> -->
					<button type="button" class="ui icon red tiny button" id="submitRmBd">
						<i id="emptyHeart" class="ui heart outline icon"></i>
					</button>
				</form>
				<%
			} else {
			%>
			<button type="button" class="ui icon red tiny button">
				<i class="ui heart icon"></i>
			</button>
			<%
		}
	}
	%>
	<div class="ui divider"></div>
	<%
	if (btlv.getBv().getBdWriter() != null) {
	Pattern p = Pattern.compile("(^[0-9]*$)");
	Matcher reg = p.matcher(btlv.getBv().getBdWriter());
	if (reg.find()) {
	%>
	<span class="ui small header" style="margin-right: 15px;"><i class="user icon"></i>작성자</span><span style="display: inline-block; width: 15%;">네이버 회원</span>
	<%
} else {
%>

<span class="ui small header" style="margin-right: 15px;"><i class="user icon"></i>작성자</span><span style="display: inline-block; width: 15%;"><%=btlv.getBv().getBdWriter()%></span>
<%
}
%>
<%
} else {
%>
<span class="ui small header" style="margin-right: 15px;"><i class="user icon"></i>작성자</span><span style="display: inline-block; width: 15%;">탈퇴한 회원</span>
<%
}
%>
<span class="ui small header" style="margin-right: 15px;"><i class="calendar icon"></i>작성일</span><span style="display: inline-block; width: 15%;"><%=date%></span> <span class="ui small header"
style="margin-right: 15px;"
><i class="eye icon"></i>조회수</span><span style="display: inline-block; width: 15%;"><%=btlv.getBv().getBdViewCount()%></span> <span class="ui small header" style="margin-right: 15px;"><i
	class="thumbs up outline icon"
	></i>추천수</span><span id="spanRmBd" style="display: inline-block; width: 15%;"><%=btlv.getBv().getBdRecommendCount()%></span>
	<div class="ui divider"></div>
</div>

<div class="ui medium header" style="margin-top: 14px;">내용</div>
<div class="ui form">
	<%
	if (btlv.getBv().getBdContents() != null) {
	%>
	<textarea rows="20" readonly style="resize: none;"><%=btlv.getBv().getBdContents()%></textarea>
	<%
}
%>
<%
for (int i = 0; i < btlv.getList().size(); i++) {
%>
<div class="ui center aligned basic segment" style="padding: 0px;">
	<div class="ui medium images" style="float: left; margin-right: 25px;">
		<img class="ui image" src="<%=btlv.getList().get(i).getBdFilePath()%>">
	</div>
</div>
<%
}
%>
</div>
<br>

<h3 class="ui dividing header" style="margin-top: 10px; clear: both;">댓글</h3>
<%
if (list.isEmpty()) {
%>
댓글이 없습니다.
<%
}
%>

<div class="ui comments">

	<%
	for (Comment c : list) {
	%>
	<div class="comment">
		<div class="ui left aligned basic segment" style="padding-top: 3px; padding-bottom: 3px;">
			<div class="content">
				<a class="avatar" style="padding-right: 5px;"> <img src="/Image/user.JPG">
				</a>
				<%
				if (c.getCmWriter() != null) {
				Pattern p = Pattern.compile("(^[0-9]*$)");
				Matcher reg = p.matcher(c.getCmWriter());
				if (reg.find()) {%>
				<a class="author">네이버 회원</a>
				<%}else{%>
				<a class="author"><%=c.getCmWriter()%></a>
				<%} %>
				<%
			} else {
			%>
			<a class="author">탈퇴한 회원</a>
			<script>
				$('.prevent').hide();
			</script>
			<%
		}
		%>
		<div class="metadata">
			<div class="date"><%=c.getCmWriteDate()%></div>
			<div class="rating">
				<i class="star icon"></i>
				<p id="cmRmCount<%=index%>" style="display: inline; margin-right: 5px;"><%=c.getCmRecCount()%></p>
			</div>
		</div>


		<%
		if (m != null) {
		if(m.getMbId().equals(c.getCmWriter())) {
		%>
		<form action="/commentUpdate" method="post" style="display: inline;">
			<div class="ui input">
				<input type="hidden" name="CM_CONTENTS" id="<%=c.getCmNo()%>_input" value="<%=c.getCmContents()%>" />
			</div>
			<input type="hidden" name="CM_NO" value="<%=c.getCmNo()%>" />
			<input type="hidden" name="CM_BD_NO" value="<%=c.getCmBdNo()%>" />
			<button type="button" class="tiny ui button prevent" id="<%=c.getCmNo()%>_btn" onclick="modify(<%=c.getCmNo()%>);">수정</button>
			<input type="hidden" class="tiny ui button" id="<%=c.getCmNo()%>_submit" value="수정">
			<button type="button" class="tiny ui button prevent" id="<%=c.getCmNo()%>_reBtn" style="display: none;" onClick="cancle(<%=c.getCmNo()%>);">취소</button>
		</form>
		<form action="/commentDelete" style="display: inline">
			<input type="hidden" name="CM_NO" value="<%=c.getCmNo()%>" />
			<input type="hidden" name="CM_BD_NO" value="<%=c.getCmBdNo()%>" />
			<input type="submit" class="tiny ui button prevent" value="삭제" />
		</form>


		<%
	}
	%>
	<%-- 댓글 추천 --%>
	<form action="/recommendComment" id="rmCm<%=index%>" method="get" style="display: inline;">
		<!-- 추천수 중복되는 걸 막기위해서 아이디 당 한번씩밖에 안되도록 설정 -->
		<input type="hidden" name="cmNo" value="<%=c.getCmNo()%>" />

		<button type="button" class="ui icon red tiny button prevent" id="submitCmBd<%=index%>"> 
			<i class="ui heart icon"></i>
		</button>
		<!-- <input type="button" id="submitCmBd<%=index%>" class="mini ui red button" value="추천" /> -->
	</form>
	<br>        
	<%
	index++;
}
%>
<div id="<%=c.getCmNo()%>_input_show" class="text" style="margin-top: 8px; margin-bottom: 0px;"><%=c.getCmContents()%></div>
<br>


</div>

</div>
</div>


<%
}
%>
</div>


<% if(m!=null) { %>
<form action="/noticeComment" class="ui reply form" method="get">
	<div class="field">
		<textarea name="CM_CONTENTS" id="cmContents" style="resize: none;" placeholder="댓글 내용을 입력하세요"></textarea>
	</div>
	<input type="hidden" name="bdNo" value=<%=btlv.getBv().getBdNo()%> />
	<input type="submit" value="댓글 작성" onclick="return commentCheck();" class="ui blue button" />
</form>
<br><br>
<%} %>

<%
if (m != null && m.getMbId().equals(btlv.getBv().getBdWriter())) {
%>
<form action="/reviewUpdateReady" style="display:inline;">
	<input type="hidden" name="bdNo" value="<%=btlv.getBv().getBdNo()%>" />
	<input type="submit" class="ui tiny brown button prevent" value="글 수정">
</form>

<% if(!btlv.getList().isEmpty()){ %>
<form action="/reviewUpdateImageReady" style="display:inline;">
	<input type="hidden" name="bdNo" value="<%=btlv.getBv().getBdNo()%>" />
	<input type="submit" class="ui tiny orange button prevent" value="사진 수정">
</form>

<form action="/reviewDeleteImageReady" style="display:inline;">
	<input type="hidden" name="bdNo" value="<%=btlv.getBv().getBdNo()%>" />
	<input type="submit" class="ui tiny orange button prevent" value="사진 삭제">
</form>
<%} %>

<form action="/reviewDelete" method="post" style="display:inline;">
	<input type="hidden" name="bdNo" value="<%=btlv.getBv().getBdNo()%>" />
	<input type="submit" class="ui tiny red button prevent" value="글 삭제">
</form>
<%
}
%>

<button class="ui tiny orange button" onclick="back()" style="display: inline;">목록</button>


<br>
<br>
<br>
</div>
</div>
<!-- 본문 끝 -->

<!-- 푸터 시작  -->
<jsp:include page="/View/main/layout/footer.jsp"></jsp:include>
<!-- 푸터 끝 -->
</body>
<script>
	function modify(id){
		document.getElementById(id+"_input_show").style="display:none";
		document.getElementById(id+"_input").type="text";
		document.getElementById(id+"_btn").style="display:none";
		document.getElementById(id+"_submit").type="submit";
		document.getElementById(id+"_reBtn").style="display:inline";
	}
	function cancle(id){
		document.getElementById(id+"_input_show").style="display:inline";
		document.getElementById(id+"_input").type="hidden";
		document.getElementById(id+"_btn").style="display:inline";
		document.getElementById(id+"_submit").type="hidden";
		document.getElementById(id+"_reBtn").style="display:none";
	}

	function back(){
		location.href="/review";
	}

	function commentCheck() {
		if(document.getElementById("cmContents").value == "") {
			alert("댓글 내용을 입력해주세요.");
			return false;
		}
		else return true;

	}
</script>

<script>
   // 게시글에 대한 추천버튼
   $('#submitRmBd').click(function() {
   	var formData = $("#rmBd").serialize();

   	console.log(formData);

   	$.ajax({
   		type : "GET",
   		url : "/recommendBoard",
   		data : formData,
   		success : function(data) {
   			$('#spanRmBd').text(data);
   			$('#emptyHeart').attr('class', 'ui heart icon');
   		}
   	});
   });
   
   
   
   // 댓글에 대한 추천 버튼
   var listSize = <%=list.size()%>;
   
   for(let i=0; i<listSize; i++) {

   	$('#submitCmBd'+i).click(function() {

   		var formData = $('#rmCm'+i).serialize();

   		$.ajax({
   			type : "GET",
   			url : "/recommendComment",
   			data : formData,
   			success : function(data) {
   				$('#cmRmCount'+i).text(data);
   			}
   		});
   	});
   }

</script>

</html>