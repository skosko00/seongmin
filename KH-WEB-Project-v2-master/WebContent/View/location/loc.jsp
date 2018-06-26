<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page errorPage="/View/error/error.jsp"%>
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
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=PyoIesHAhe6a3F1GDj9P"></script>
<title>오시는 길</title>
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
		<div class="ui icon message">
			<i class="map outline icon"></i>
			<div class="content">
				<div class="header" style="text-align: center;">
					<h1>오시는 길</h1>
				</div>
			</div>
		</div>

		<div class="ui center aligned segment">
			<div id="map" style="width: 100%; height: 500px;"></div>
		</div>


		<h4 class="ui horizontal divider header">
			<i class="address book icon"></i> 주소 및 연락처
		</h4>
		<p>
		<center>
			<br>
			<p>
				서울 영등포구 선유동2로 57 (이레빌딩)
				<br>
			</p>
			<p>
				<i class="phone icon"></i> 010-3787-5606
			</p>
			<br>
		</center>
		</p>
		<h4 class="ui horizontal divider header">
			<i class="building icon"></i> 오시는 길
		</h4>
		<table class="ui definition table">
			<tbody>
				<tr>
					<td class="two wide column center aligned">버스</td>
					<td>
						<p>
							<b>선유고등학교 / (구)강서세무서</b>
						</p>
						<p>
							<i class="bus green icon"></i> 7612
							<br>
						</p>
						<p>
							<i class="bus red icon"></i> 1000 / 1200 / 1300 / 1301 / 1302 / 1400 / 1500 / 1601 / M6628 / M6724
						</p>
						<br>
						<p>
							<b>당산역</b>
						</p>
						<p>
							<i class="bus blue icon"></i> 602 / 760 / 5620 / 5714 / 6514 / 6623 / 6631
						</p>
					</td>
				</tr>
				<tr>
					<td class="center aligned">지하철</td>
					<td>
						<i class="subway icon"></i> 지하철 2, 9호선 당산역 12번 출구 400m
					</td>
				</tr>
				<tr>
					<td class="center aligned">자가용</td>
					<td>
						<i class="car icon"></i> 양화대교 남단 300m 지점(구 강서세무서 옆)
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- 본문 끝 -->

	<!-- 푸터 시작  -->
	<jsp:include page="/View/main/layout/footer.jsp"></jsp:include>
	<!-- 푸터 끝 -->
</body>

<script>
	/* 지도 옵션 */
	var mapOptions = {
		scaleControl : false,
		logoControl : false,
		mapDataControl : false,
		zoomControl : true
	};

	/* 지도 위치 및 설정 */
	var HOME_PATH = window.HOME_PATH || '.';
	var thePension = new naver.maps.LatLng(37.5338316, 126.8969046), map = new naver.maps.Map(
			'map', {
				center : thePension,
				zoom : 12,
				mapTypeControl : true,
				zoomControl : true,
				aroundControl : true
			}), marker = new naver.maps.Marker({
		map : map,
		position : thePension
	});

	/* 마커 클릭 시 문구 */
	var contentString = [ '<div class="ui segment">', '   <h3>더 펜션</h3>',
			'   <p>서울 영등포구 선유동2로 57 (이레빌딩)<br><br>', '</div>' ].join('');

	/* 마커 클릭 시 창 */
	var infowindow = new naver.maps.InfoWindow({
		content : contentString,
		maxWidth : 200,
		backgroundColor : "#FFFFF",
		borderColor : "#FFFFF",
		borderWidth : 5,
		anchorSize : new naver.maps.Size(30, 30),
		anchorSkew : true,
		anchorColor : "#FFFFFF",
		pixelOffset : new naver.maps.Point(20, -20)
	});

	$(document).ready(function() {
		infowindow.open(map, marker);
	})
</script>
</html>
