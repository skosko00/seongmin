<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="jsp.board.model.vo.*" %>
<%@ page errorPage="/View/error/error.jsp"%>
<jsp:include page="/View/main/layout/preventurl.jsp"></jsp:include>
<% BoardVo board = (BoardVo)request.getAttribute("board"); %>

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
<title>공지사항 - 글수정</title>
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
		<form action="/noticeUpdate" method="post">
		글번호 : <%=board.getBdNo()%><br>
		글쓴이 : <%=board.getBdWriter()%><br>
		작성일 : <%=board.getBdWriteDate()%><br>
		글제목 : <input type="text" size=90 value=<%=board.getBdName()%> name="bdName"/><br>
		<input type="hidden" value="<%=board.getBdNo()%>" name="bdNo"/><br>
		<textarea rows="20" cols="100" style="resize:none;" name="bdContents"/><%=board.getBdContents()%></textarea>
		<br>
		<input type="submit" value="수정하기"/>
		</form>
		
	</div>
	<!-- 본문 끝 -->

	<!-- 푸터 시작  -->
	<jsp:include page="/View/main/layout/footer.jsp"></jsp:include>
	<!-- 푸터 끝 -->
</body>

<script>
	
</script>

</html>
