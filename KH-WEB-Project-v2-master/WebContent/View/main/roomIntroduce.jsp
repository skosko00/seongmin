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
	<title>객실안내</title>
	
	
	<!-- 웹 폰트 적용 -->
	<link href="https://fonts.googleapis.com/css?family=Nanum+Brush+Script" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Jua|Nanum+Gothic" rel="stylesheet">

</head>

<style>
/* 이미지 사이즈 */
.swiperImg {
	width: 100%;
	height: 77vh;
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

	<!-- 헤더 밑 사진 시작 -->
	<div>
		<div>
			<div style="border: 0px; padding: 0px; margin: 0px;">
				<img src="${requestScope.dTb.desImagePath }" class="swiperImg" style="opacity: 0.8;">
			</div>
			<div style="background: url('/Image/title/pattern01a.png'); border: 0px; padding: 0px; margin: 0px;">
				<div class="ui center aligned basic segment" style="letter-spacing: 5px; font-family: 'Nanum Brush Script', cursive; font-size: 35px;">
					여행의 아름다운 추억을 더 펜션에서 만들어 가세요.
				</div>
			</div>
		</div>
	</div>
	<!-- 헤더 밑 사진 끝 -->

	<!-- 본문 시작 -->
	<br>
	<div class="ui container">
		<!-- 여기에 본문 내용 작성하면 됨 -->
		<div class="ui center aligned basic segment" style="font-family: 'Jua', sans-serif; font-size: 20px;">
			${requestScope.dTb.desRoom }
		</div>


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
	
</script>
<style>
/* 브라우저 사이즈 조절 시 이미지 크기 변경 */
@media screen and (max-width: 1600px) {
	.swiperImg {
		width: 100%;
		height: 72vh;
	}
}

@media screen and (max-width: 1500px) {
	.swiperImg {
		width: 100%;
		height: 69vh;
	}
}

@media screen and (max-width: 1400px) {
	.swiperImg {
		width: 100%;
		height: 66vh;
	}
}

@media screen and (max-width: 1300px) {
	.swiperImg {
		width: 100%;
		height: 63vh;
	}
}

@media screen and (max-width: 1200px) {
	.swiperImg {
		width: 100%;
		height: 60vh;
	}
}

@media screen and (max-width: 1100px) {
	.swiperImg {
		width: 100%;
		height: 57vh;
	}
}

@media screen and (max-width: 1000px) {
	.swiperImg {
		width: 100%;
		height: 54vh;
	}
}

@media screen and (max-width: 900px) {
	.swiperImg {
		width: 100%;
		height: 51vh;
	}
}

@media screen and (max-width: 800px) {
	.swiperImg {
		width: 100%;
		height: 48vh;
	}
}

@media screen and (max-width: 700px) {
	.swiperImg {
		width: 100%;
		height: 45vh;
	}
}

@media screen and (max-width: 600px) {
	.swiperImg {
		width: 100%;
		height: 42vh;
	}
}

@media screen and (max-width: 500px) {
	.swiperImg {
		width: 100%;
		height: 39vh;
	}
}

@media screen and (max-width: 400px) {
	.swiperImg {
		width: 100%;
		height: 36vh;
	}
}

@media screen and (max-width: 300px) {
	.swiperImg {
		width: 100%;
		height: 33vh;
	}
}

@media screen and (max-width: 200px) {
	.swiperImg {
		width: 100%;
		height: 30vh;
	}
}

@media screen and (max-width: 100px) {
	.swiperImg {
		width: 100%;
		height: 27vh;
	}
}
</style>
</html>
