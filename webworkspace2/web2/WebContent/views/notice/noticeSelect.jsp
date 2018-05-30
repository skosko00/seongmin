<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="notice.model.vo.*" import="member.model.vo.*" import="java.util.*"%>
<%
Notice n = (Notice)request.getAttribute("notice");
ArrayList<Comment> list = (ArrayList<Comment>)request.getAttribute("comment");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 내용</title>
</head>
<body>
글번호 : <%=n.getNoticeNo() %><br>
글쓴이 : <%=n.getUserId() %><br>
작성일 : <%=n.getRegDate() %><br>
글제목 : <%=n.getSubject() %><br>
<textarea rows="20" cols="100" readonly style="resize: none;"><%=n.getContents() %></textarea>
<br>

<button onclick="back()">목록</button>

<%if(session.getAttribute("user")!=null && ((Member)session.getAttribute("user")).getUserId().equals("admin")) {%>
<form action="/noticeUpdateReady" style="display: inline;">
<input type="hidden" name="noticeNo" value="<%=n.getNoticeNo()%>">
<input type="submit" value="수정">
</form>
<!-- 게시물 수정 -->
<form action="/noticeDelete" style="display: inline;" method="get">
<input type="hidden" name="noticeNo" value="<%=n.getNoticeNo()%>">
<input type="submit" value="삭제" onclick="return check();">
</form>
<!-- 게시물 삭제 -->
<form action="/views/notice/noticeWriteReady.jsp" style="display: inline;">
<input type="submit" value="글쓰기">
</form>
<!-- 글쓰기 -->
<%} %>
<h1>댓글</h1>
<%for(Comment c : list){ %>
작성자 : <%=c.getUserId() %> / 작성일 : <%= c.getRegDate() %>
<label id=<%=c.getCommentNo()%>><%=c.getContent()%></label>
	<%if(((Member)session.getAttribute("user"))!=null &&
			((Member)session.getAttribute("user")).getUserId().equals(c.getUserId())
			){
		%>
	<form action="/updateComment" method="get" style="display:inline;">
	<input type="hidden" name="comment" id="<%=c.getCommentNo()%>_input" value="<%=c.getContent()%>"/>
	<input type="hidden" name="commentNo" value="<%=c.getCommentNo()%>"/>
	<input type="hidden" name="noticeNo" value="<%=n.getNoticeNo()%>">
	<button type="button" id="<%=c.getCommentNo()%>_btn" onclick="modify(<%=c.getCommentNo()%>);">수정</button>
	<input type="hidden" id="<%=c.getCommentNo()%>_submit" value="수정">
	<button type="button" id="<%=c.getCommentNo()%>_reBtn" style="display:none;" onclick="cancle(<%=c.getCommentNo()%>);">취소</button>
</form>
<!-- 댓글 수정 -->
<%}%>
<%if(((Member)session.getAttribute("user")).getUserId().equals(c.getUserId())){ %>
<form action="/deleteComment" method="get" style="display: inline;">
<input type="hidden" name="commentNo" value="<%=c.getCommentNo()%>">
<input type="hidden" name="userId" value="<%=((Member)session.getAttribute("user")).getUserId()%>">
<input type="hidden" name="noticeNo" value="<%=n.getNoticeNo()%>">
<input type="submit" value="삭제" onclick="return check();">
</form>
<!-- 댓글 삭제 -->
<%} %>
<%} %>

<%if(((Member)session.getAttribute("user"))==null){ %>
<textarea rows="5" cols="100" placeholder="로그인 이후 이용가능" style="resize:none;" readonly="readonly" onclick="login();"></textarea><br>
<%}else{ %>
<form action="/insertComment" method="get">
<textarea rows="5" cols="100" placeholder="댓글을 작성하세요" style="resize:none;" name="comment"></textarea><br>
<input type="submit" value="댓글작성">
<input type="hidden" name="noticeNo" value="<%=n.getNoticeNo()%>">
<input type="hidden" name="userId" value="<%=((Member)session.getAttribute("user")).getUserId()%>">
<%} %>
</form>

<script type="text/javascript">
function back() {
	location.href="/notice";
}
function check() {
	var nd = confirm("정말 삭제하시겠습니까?");
	if(nd==true)
		{
		return true;
		}
	else
		{
		return false;
		}
}
function login() {
	alert("로그인을 먼저 진행해주세요");
	window.open("/views/member/login_popup.html","_blank","width=300px,height=200px");
}
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
</script>
</body>
</html>