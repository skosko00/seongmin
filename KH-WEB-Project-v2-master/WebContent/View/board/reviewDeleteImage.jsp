<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page errorPage="/View/error/error.jsp"%>
<%@ page import="jsp.board.model.vo.*" import="jsp.member.model.vo.*" import="java.util.*" import="jsp.admin.model.vo.*"%>
<jsp:include page="/View/main/layout/preventurl.jsp"></jsp:include>
<%
BoardTotalInfoVo btlv = (BoardTotalInfoVo)request.getAttribute("review");
BoardVo bv = null;
ArrayList<DataFile> list = null;
if (btlv != null) {
bv = btlv.getBv();
list = btlv.getList();
}
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
	<title>후기게시판 - 사진삭제</title>
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
		<div class="ui red message"><div class="ui small header">※ 사진을 삭제하려면 삭제 버튼을 누르고 삭제할 이미지 아래의 삭제 버튼을 누르세요</div></div>
		<div class="ui grid">
			<% for(int i = 0 ; i < list.size() ; i++){ %>
			<div class="four wide column">
				<form action="/reviewImageDelete" method="post" style="display: inline;">
					<input type="hidden" value="<%=bv.getBdNo()%>" name="bdNo"/>
					<div id='image<%= i %>'>
						<div class="ui medium image">
							<img src="<%=list.get(i).getBdFilePath()%>">
						</div>
					</div>
					<input type="hidden" name="image_path" value="<%=list.get(i).getBdFilePath()%>">
					<br>
					<input type="hidden" id="update<%= i %>_submit" value="삭제" class="ui small red button">
					<button type="button" id="update<%= i %>_reBtn" style="display: none;" onclick="imageCancle('update<%= i %>');" class="ui small blue button">취소</button>
					<button type="button" id="update<%= i %>_btn" onclick="update('update<%= i %>');" class="ui small red button">삭제</button>
				</form>
			</div>
			<%} %>
		</div>
		<br><br><br><br>
		<button onclick="back()" class="ui tiny small teal button">뒤로가기</button>
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
	function update(id){
		document.getElementById(id+"_btn").style="display:none";
		document.getElementById(id+"_submit").type="submit";
		document.getElementById(id+"_reBtn").style="display:inline";
	}
	function imageCancle(id) {
		document.getElementById(id+"_btn").style="display:inline";
		document.getElementById(id+"_submit").type="hidden";
		document.getElementById(id+"_reBtn").style="display:none";
	}
</script>

</html>
