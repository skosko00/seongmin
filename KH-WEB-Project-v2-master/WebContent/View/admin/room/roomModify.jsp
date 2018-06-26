<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page
import="java.util.*,jsp.admin.model.vo.*,jsp.main.model.vo.*,jsp.reservation.model.vo.*"%>
<jsp:include page="/View/main/layout/preventurl.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
	<!-- Global site tag (gtag.js) - Google Analytics -->
	<script async
	src="https://www.googletagmanager.com/gtag/js?id=UA-120156974-1"></script>
	<script>
		window.dataLayer = window.dataLayer || [];
		function gtag() {
			dataLayer.push(arguments);
		}
		gtag('js', new Date());
		gtag('config', 'UA-120156974-1');
	</script>
	<jsp:include page="/View/main/layout/cssjs.jsp"></jsp:include>
	<title>관리자</title>
</head>

<style>
</style>

<body>

	<jsp:include page="/View/admin/layout/sideMenu.jsp"></jsp:include>
	<%
	RoomTotalInfoVo rtiv = (RoomTotalInfoVo) request.getAttribute("roomInfo");

	if (rtiv != null) {
	PensionVo pv = rtiv.getPv();
	ArrayList<PensionPicTb> list = rtiv.getList();
		%>
		<!-- 이 부분이 본문 -->
		<div class="ui pusher">
			<!-- 헤더 부분  -->
			<div class="ui segment">
				<h3 class="ui header">사진수정</h3>
			</div>
			<!-- 헤더 끝 -->

			<!-- 본문 시작 -->
			<br>
			<div class="ui container">
				<!-- 여기에 본문 내용 작성하면 됨 -->
				<div class="ui grid">
					<% for(int i = 0 ; i < list.size() ; i++){ %>
					<div class="four wide column">
						<form action="/roomPicUpdate" method="post"
						enctype="Multipart/form-data" style="display: inline;">
						<div id='image<%= i %>'>
							<img src="<%=list.get(i).getPsPicPath()%>" style="width: 100%;">
						</div>
						<input type="hidden" name="image_path"
						value="<%=list.get(i).getPsPicPath()%>">

						<input type="hidden" name="img" id="update<%= i %>"
						accept="image/*" required /><br> <br> <input
						type="hidden" id="update<%= i %>_submit" value="수정"
						class="ui orange button">
						<button type="button" id="update<%= i %>_btn"
							onclick="update('update<%= i %>');" class="ui orange button">수정</button>
							<button type="button" id="update<%= i %>_reBtn"
								style="display: none;"
								onclick="imageCancle('update<%= i %>');" class="ui red button">취소</button>
							</form>
						</div>
						<%} %>
					</div>
					<br>
					<br>
					<button onclick="back()" class="ui blue button">뒤로가기</button>
				</div>
			</div>

			<!-- 본문 끝 -->
			<%
		}
		%>
		<script>
			$(document).ready(function() {
				$('.visible.example .ui.sidebar')
				.sidebar({
					context : '.visible.example .bottom.segment'
				})
				.sidebar('hide')
				;
			});
		</script>
	</body>

	<script>
		function back() {
			location.href="/adminRoomManager";
		}
		function update(id){
			document.getElementById(id).type="file";
			document.getElementById(id+"_btn").style="display:none";
			document.getElementById(id+"_submit").type="submit";
			document.getElementById(id+"_reBtn").style="display:inline";
		}
		function imageCancle(id) {
			document.getElementById(id).type="hidden";
			document.getElementById(id+"_btn").style="display:inline";
			document.getElementById(id+"_submit").type="hidden";
			document.getElementById(id+"_reBtn").style="display:none";
		}

	</script>

	</html>
