<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page errorPage="/View/error/error.jsp"%>

<!DOCTYPE html>

<html class="no-js">
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
	<title>더 펜션</title>
	
	<!-- 웹 폰트 적용 -->
	<link href="https://fonts.googleapis.com/css?family=Jua|Nanum+Gothic" rel="stylesheet">
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
	<!-- 헤더 시작 -->
	<jsp:include page="/View/main/layout/header.jsp"></jsp:include>
	<!-- 헤더 끝 -->

	<!-- 스와이퍼 (슬라이드 이미지)-->
	<div class="swiper-container" id="mainSwiper">
		<div class="swiper-wrapper" id="mainImage"></div>

		<div class="swiper-pagination"></div>
		<div class="swiper-button-next"></div>
		<div class="swiper-button-prev"></div>
	</div>
	<!-- 스와이퍼 끝 -->

	<!-- 본문 시작 -->
	<div class="ui container">
		<div class="ui center aligned basic segment">
			<div class="ui message" id="mainComment" style="font-family: 'Jua', sans-serif; font-size: 24px; line-height: 50px; margin-top: 20px;"></div> 
		</div>
		<!-- 본문 끝 -->
	</div>

	<!-- 푸터 시작 -->
	<jsp:include page="/View/main/layout/footer.jsp"></jsp:include>
	<!-- 푸터 끝 -->
</body>

<!-- 회원 정보 조회(테스트용) 모달 -->
<div class="ui mini modal" id="modal">
	<div class="header">회원정보(테스트용)</div>
	<div class="content">
		${sessionScope.member.mbId}
		<br>
		${sessionScope.member.mbName}
		<br>
		${sessionScope.member.mbBirth}
		<br>
		${sessionScope.member.mbGender}
		<br>
		${sessionScope.member.mbAddress}
		<br>
		${sessionScope.member.mbEntDate}
		<br>
	</div>
	<div class="actions">
		<div class="ui blue cancel button" id="termsModal">확인</div>
	</div>
</div>
<!-- 회원 정보 조회(테스트용 끝) 모달 -->

<!-- 
index db 불러오는 ajax 시작
스와이프 시작
-->
<script type="text/javascript">


	$(document).ready(function() {
		$.ajax({
			url : "/indexImage",
			type : "post",
			success : function(data) {
				for (var i = 0; i < data.length; i++) {
					var div = '<div class="swiper-slide "> <img src="' + data[i].mainPicPath + '" class="swiperImg"></div>';
					$("#mainImage").append(div);
				}
				

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
			},

			error : function() {
			}
		});
		$.ajax({
			url : "/indexContents",
			type : "post",
			success : function(data) {
				$("#mainComment").html(data);
			},
			error : function() {

			}
		});
	});
</script>

<!--
index db 불러오는 ajax 끝
스와이프 끝 
-->

<script>

	/* 회원 정보 조회(테스트용 이벤트)*/
	$('#memberInfo').click(function() {
		$('#modal').modal('show');
	})
	/* 회원 정보 조회(테스트용 이벤트 끝)*/
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
