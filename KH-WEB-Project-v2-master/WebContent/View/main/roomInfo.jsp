<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page errorPage="/View/error/error.jsp"%>
<%@ page import="java.util.*" import="jsp.main.model.vo.*"%>
<%
@SuppressWarnings("all")
ArrayList<PensionPicTb> list = (ArrayList<PensionPicTb>) request.getAttribute("PensionPicTb");
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
	<title>객실안내 - ${requestScope.pv.psName}</title>

	<!-- 웹 폰트 적용 -->
	<link href="https://fonts.googleapis.com/css?family=Do+Hyeon" rel="stylesheet">
</head>

<style>
/* 이미지 사이즈 */
.swiperImg {
	width: 100%;
	height: 87vh;
}

/* 투명도 설정 */
.swiper-container {
	opacity: 0.85;
}
</style>

<body>
	
	<!-- 헤더 시작  -->
	<jsp:include page="/View/main/layout/header.jsp"></jsp:include>
	<!-- 헤더 끝 -->
	
	<!-- 스와이퍼 (슬라이드 이미지)-->
	<div class="swiper-container" id="mainSwiper">
		<div class="swiper-wrapper" id="mainImage">
			<c:forEach begin="0" items="${requestScope.roomNameImage}" var="roomImage">
			<div class="swiper-slide "> <img src="${roomImage.psPicPath}" class="swiperImg"></div>
		</c:forEach>
	</div>
	<div class="swiper-pagination"></div>
	<div class="swiper-button-next"></div>
	<div class="swiper-button-prev"></div>
</div>
<!-- 스와이퍼 끝 -->

<!-- 본문 시작 -->
<br>
<div class="ui container">
	<!-- 여기에 본문 내용 작성하면 됨 -->
	<div class="fancy-title title-border title-center">
		<h1 style="font-family: 'Do Hyeon', sans-serif; font-size: 30px;"><span>${requestScope.pv.psName }</span> 객실소개</h1>
	</div><hr>
	<div class="ui two column very relaxed grid">
		<div class="column">
			<p>${requestScope.pv.psContents }</p>
		</div>
		<div class="column">
			<table class="ui celled table">
				<tbody>
					<tr>
						<td>기준/최대인원</td>
						<td>기준:${requestScope.pv.psPersonnel }/최대:${requestScope.pv.psMaxPersonnel }(명)</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<table class="ui celled table">
		<thead>
			<tr>
				<th>객실명</th>
				<th>주중요금(원)</th>
				<th>주말요금(원)</th>
				<th>추가요금(원)</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${requestScope.pv.psName }</td>
				<td>${requestScope.pv.psWeekday }</td>
				<td>${requestScope.pv.psWeekend }</td>
				<td>${requestScope.pv.psAddtionalPrice }</td>
			</tr>
		</tbody>
	</table>

	<!-- 사진 시작 -->
	<%
	int pageIndex = 0;
	int row = 0;
	int count=0;
	if (list.size() % 3 > 0) {
	pageIndex = list.size() / 3 + 1;
}
else {
pageIndex = list.size() / 3;
}
for (int i = 0; i < pageIndex; i++) {
if(list.size()-count>=3)
{
	row = 3;
}else{
row = (list.size()-count) % 3;
}
%>
<div class="ui three column grid">
	<%
	for (int j = 0; j < row; j++) {
	%>
	<div class="column">
		<div class="ui segment">
			<a href="/roomInfo?roomName=<%=list.get(count).getpsPicName()%>">
				<img src="<%=list.get(count).getPsPicPath()%>" style="width: 100%;">
				<div style="text-align: center;">
					<span><%=list.get(count).getpsPicName()%></span>
				</div>
			</a>
		</div>
	</div>
	<%
	count++;
}
%>
</div>
<%
}
%>

<!-- 사진 끝 -->
</div>
<!-- 본문 끝 -->

<!-- 푸터 시작  -->
<jsp:include page="/View/main/layout/footer.jsp"></jsp:include>
<!-- 푸터 끝 -->
</body>

<script>
	var swiper = new Swiper('.swiper-container',
	{
		spaceBetween : 30,
		centeredSlides : true,
		effect : 'cube',
		autoplay : {
			delay : 2000,
			disableOnInteraction : false,
		},
		pagination : {el : '.swiper-pagination',
		clickable : true,
	},
	navigation : {
		nextEl : '.swiper-button-next',
		prevEl : '.swiper-button-prev',
	},
});
</script>
</script>

<style>
/* 브라우저 사이즈 조절 시 이미지 크기 변경 */
@media screen and (max-width: 1600px) {
	.swiperImg {
		width: 100%;
		height: 82vh;
	}
}

@media screen and (max-width: 1500px) {
	.swiperImg {
		width: 100%;
		height: 79vh;
	}
}

@media screen and (max-width: 1400px) {
	.swiperImg {
		width: 100%;
		height: 76vh;
	}
}

@media screen and (max-width: 1300px) {
	.swiperImg {
		width: 100%;
		height: 73vh;
	}
}

@media screen and (max-width: 1200px) {
	.swiperImg {
		width: 100%;
		height: 70vh;
	}
}

@media screen and (max-width: 1100px) {
	.swiperImg {
		width: 100%;
		height: 67vh;
	}
}

@media screen and (max-width: 1000px) {
	.swiperImg {
		width: 100%;
		height: 64vh;
	}
}

@media screen and (max-width: 900px) {
	.swiperImg {
		width: 100%;
		height: 61vh;
	}
}

@media screen and (max-width: 800px) {
	.swiperImg {
		width: 100%;
		height: 58vh;
	}
}

@media screen and (max-width: 700px) {
	.swiperImg {
		width: 100%;
		height: 55vh;
	}
}

@media screen and (max-width: 600px) {
	.swiperImg {
		width: 100%;
		height: 52vh;
	}
}

@media screen and (max-width: 500px) {
	.swiperImg {
		width: 100%;
		height: 49vh;
	}
}

@media screen and (max-width: 400px) {
	.swiperImg {
		width: 100%;
		height: 46vh;
	}
}

@media screen and (max-width: 300px) {
	.swiperImg {
		width: 100%;
		height: 43vh;
	}
}

@media screen and (max-width: 200px) {
	.swiperImg {
		width: 100%;
		height: 40vh;
	}
}

@media screen and (max-width: 100px) {
	.swiperImg {
		width: 100%;
		height: 37vh;
	}
}
</style>

</html>
