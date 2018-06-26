<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page errorPage="/View/error/error.jsp"%>
<jsp:include page="/View/main/layout/preventurl.jsp"></jsp:include>
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
	<title>Main 삭제</title>
</head>

<style>
</style>

<body>
	
	<jsp:include page="/View/admin/layout/sideMenu.jsp"></jsp:include>
	<!-- 이 부분이 본문 -->
	<div class="ui pusher">
		<!-- 헤더 부분  -->
		<div class="ui segment">
			<h3 class="ui header">Main 사진 삭제</h3>
		</div>
		<!-- 헤더 끝 -->

		<!-- 본문 시작 -->
		<br>
		<div class="ui container">
			<!-- 여기에 본문 내용 작성하면 됨 -->
			<div class="ui grid">
				<c:forEach begin="0" items="${requestScope.MainPicTb}" var="list" varStatus="i">
				<div class="four wide column">
					<form action="/adminMainDelete" method="post" style="display:inline;">
						<div id='image${i.count }'>
							<img src="${list.mainPicPath }" style="width:100%;">
						</div>
						<input type="hidden" name="image_path" value="${list.mainPicPath }">
						<br>
						<input type="hidden" id="deleteimage${i.count }_submit" value="삭제" class="ui red button">
						<button type="button" id="deleteimage${i.count }_btn" onclick="deleteimage('deleteimage${i.count }');" class="ui red button">삭제</button>
						<button type="button" id="deleteimage${i.count }_reBtn" style="display:none;" onclick="imageCancle('deleteimage${i.count }');" class="ui orange button">취소</button>
					</form>
				</div>
			</c:forEach>
		</div>
		<br><br>
		<button onclick="back()" class="ui blue button">뒤로가기</button>
	</div>
	<!-- 본문 끝 -->

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

<script>
	function back() {
		location.href="/adminTemplateManager";
	}
	function deleteimage(id){
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
