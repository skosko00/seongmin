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
	<title>후기게시판 - 글수정</title>
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
		<div class="ui red message"><div class="ui small header">※ 이곳은 더 펜션 후기를 남기는 공간입니다.<br>기타 다른 글은 삼가 부탁드립니다.</div></div>
		<div class="ui center aligned segment">
			<form action="/reviewUpdate" method="post"  enctype="Multipart/form-data" style="display:inline;">
			<!--글번호 : <%=board.getBdNo()%><br>
			글쓴이 : <%=board.getBdWriter()%><br>
			작성일 : <%=board.getBdWriteDate()%><br> -->
			<div class="ui left aligned basic segment">
				<label><span class="ui small header">글제목(수정)</span></label>
				<div class="ui input">
					<input type="text" size=90 value=<%=board.getBdName()%> name="bdName"/><br>
				</div>
			</div>
			<input type="hidden" value="<%=board.getBdNo()%>" name="bdNo"/><br>
			<label><div class="ui small header">내용작성(수정)</div></label>
			<div class="ui form">
				<textarea rows="20" cols="100" style="resize:none;" name="bdContents"/><%=board.getBdContents()%></textarea>
			</div>
			<div class="ui left aligned basic segment">
					<input class="ui orange basic button" type="file" name="img" id="img" accept="image/*" multiple><br><br>
					<div id="image"></div>
				</div>
			<br>
			<input type="submit" class="ui blue button" value="수정하기"/>
			<button type="button" class="ui red button" onclick="history.back();">취소</button>
		</form>
	</div>
</div>
<!-- 본문 끝 -->

<!-- 푸터 시작  -->
<jsp:include page="/View/main/layout/footer.jsp"></jsp:include>
<!-- 푸터 끝 -->
</body>

<script>
	function back() {
		history.go(-1);
	}
	var uploadfile = document.getElementById('img');
	var fileslength = 0;
	uploadfile.onchange = function(e){
		var files = e.target.files;
		fileslength = files.length;
		for(var i=0; i<fileslength; i++){
			if(i===0)
			{
				document.getElementById('image').innerHTML = "";
			}
			var fileReader = new FileReader();
			fileReader.readAsDataURL(e.target.files[i]);
			fileReader.onload = function(e){
				var str = "<div style='display:inline;'> <img src='"+e.target.result+"'style='width:100px; height:100px;'> </div>";
				document.getElementById('image').innerHTML += str;
			}
		}
	}
</script>

</html>
