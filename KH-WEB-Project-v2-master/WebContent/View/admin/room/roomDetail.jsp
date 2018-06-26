<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*,jsp.admin.model.vo.*,jsp.main.model.vo.*,jsp.reservation.model.vo.*" %>
<jsp:include page="/View/main/layout/preventurl.jsp"></jsp:include>
<!-- roomInfo -->
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/View/main/layout/cssjs.jsp"></jsp:include>
	<title>관리자</title>
</head>
<body>
<!-- 
	1. 객실의 디테일한 정보 
-->
<!-- 메뉴 바 -->
<jsp:include page="/View/admin/layout/sideMenu.jsp"></jsp:include>
<!-- 이 부분이 본문 -->

<%  
RoomTotalInfoVo rtiv = (RoomTotalInfoVo)request.getAttribute("roomInfo");
if(rtiv != null){
PensionVo pv = rtiv.getPv(); 
ArrayList<PensionPicTb> list = rtiv.getList();

	%>
	<div class="ui pusher">
		<!-- 헤더 부분  -->
		<div class="ui segment">
			<h3 class="ui header">객실 관리</h3>
		</div>
		<!-- 헤더 끝  -->
		<!-- 본문 내용 시작-->
		<br>
		<div class="ui container">
			<div class="ui red message"><div class="ui small header">※ 객실 정보 및 객실 사진 정보를 수정 하려면 아래 내용을 수정하세요</div></div>
			<div class="ui segment">
				<form class="ui form " action="/adminRoomUpdate" method="post" >
					<h2 class="ui dividing header">객실 정보</h2>
					<div class="field">
						<label>객실명</label>
						<div class="ui input">
							<input type="text" name="PS_Name" maxlength="16" value="<%=pv.getPsName() %>" readonly="readonly">
						</div>
					</div>
					<div class="fields">
						<div class="two wide field">
							<label>기준 인원</label>
							<input type="number" class="ableChange"name="PS_Person" placeholder="0" value="<%=pv.getPsPersonnel() %>" readonly="readonly" >
						</div>
						<div class="two wide field">
							<label>최대인원</label>
							<input type="number" class="ableChange" name="PS_MaxPerson" placeholder="0" value="<%=pv.getPsMaxPersonnel()%>" readonly="readonly">
						</div>

					</div>
					<!--  객실 요금  -->
					<h3 class="ui dividing header">객실 요금 정보</h3>
					<div class="fields">
						<div class="three wide field">
							<label> 주말 요금</label>
							<input type="number" placeholder="0원" step="1000" name="PS_Weekend" required readonly="readonly" class="ableChange" value="<%=pv.getPsWeekend()%>">
						</div>
						<div class="three wide field">
							<label> 주중 요금</label>
							<input type="number" placeholder="0원" step="1000" name="PS_Weekday" required readonly="readonly" class="ableChange" value="<%=pv.getPsWeekday() %>">
						</div>
						<div class="three wide field">
							<label> 추가 요금</label>
							<input type="number" placeholder="0원" step="1000" name="PS_Addition_Price" required readonly="readonly" class="ableChange" value="<%=pv.getPsAddtionalPrice()%>">
						</div>
					</div>
					<div class="field">
						<label>객실 소개</label>
						<div class="ui input">
							<textarea rows="10" name="PS_Contents" maxlength="1333" required readonly="readonly" class="ableChange"><%=pv.getPsContents() %></textarea>
						</div>
					</div>
					<input type="submit" class="ui blue button" value="등록" onclick="return Check();" style="display: none; margin-bottom: 15px;" >
					<input type="reset" class="ui green button" value="초기화" style="display: none">
				</form>
				<button id="textEdit" class="ui orange button" onclick="ableChange();" >글 수정</button>
				<button id="textClose" class="ui red button" onclick="disableChange();" >수정 취소</button>
			</div>
			<!--  글 수정 부분  -->
			<!--  사진 수정 및 삭제 부분 시작 -->
			<div class="ui segment">
				<h2>객실 사진 정보</h2>
				<!--  메인 사진  -->
				<div class="field">
					<div class="ui tiny header">현재 객실 메인 사진</div>
					<img class="ui image" id="main_img" src="<%=list.get(0).getPsPicPath()%>">
				</div>
				<!--  그 외 사진 -->

				<div class="field">
					<div class="ui tiny header" style="margin-top: 15px;">사진 추가</div>
					<div id="etc_inputs" >

					</div>
					<div class="ui tiny images" id="etc_preview" >
						<% for(int i =1 ; i < list.size() ; i++) {%>
						<a href="javascript:void(0);" onclick="deleteImageAction(<%=i%>);" id="img_id_<%=i%>">
							<img src="<%=list.get(i).getPsPicPath()%>"  class='ui image' ></a>
							<% 

						} %>
					</div> 


				</div>
				<form action="/roomPicUpdateView" method="post" style="display:inline;">
					<input type="hidden" name="roonNameModi" value="<%=pv.getPsName()%>">
					<input type="submit" class="ui orange button" value="사진 수정"/>
				</form>
				<form action="/roomPicDeleteView" method="post" style="display:inline;">
					<input type="hidden" name="roonNameModi" value="<%=pv.getPsName()%>">
					<input type="submit" class="ui red button" value="사진 삭제"/>
				</form>
			</div>
			<!--  사진 수정 및 삭제 부분 끝  -->
			<button class="ui blue button" onclick="goBack();" >뒤로가기</button>
			<form action="/adminRoomDelete" style="display: inline">
				<input type="hidden" name="roomName" value="<%= pv.getPsName()%>">
				<input class="ui red button" type="submit" value="삭제"> 
			</form>
			<br><br><br><br><br>

		</div>
		<!-- 본문 내용 끝  -->
		<%} %>
	</div>
	<script>
		$(document).ready(function(){
			$('.visible.example .ui.sidebar')
			.sidebar({
				context: '.visible.example .bottom.segment'
			})
			.sidebar('hide')
			;
		})
// 수정 가능하게 바꿈..
function ableChange(){

	var $file = $('.ableChange[type=file]');
	var $noFile = $('.ableChange').not('[type=file]');
	var $submit = $('input.button').not('.ableChange');
	$noFile.each(function(){	
		$(this).attr("readonly",false);
	});
	$file.each(function(){
		$(this).attr("disable",false);
	});
	$submit.each(function(){
		$(this).css('display','');
	});
	
}
function disableChange(){
	var $file = $('.ableChange[type=file]');
	var $noFile = $('.ableChange').not('[type=file]');
	var $submit = $('input.button').not('.ableChange');
	$noFile.each(function(){	
		$(this).attr("readonly",true);
	});
	$file.each(function(){
		$(this).attr("disable",true);
	});
	$submit.each(function(){
		$(this).css('display','none');
	});
}
function mainImgPreview(input){
	 if (input.files && input.files[0]) {           //파일존재할시 
	 	var reader = new FileReader();          
	 	reader.onload = function (e) {        
	 		$('#main_img').attr('src', e.target.result);             

	 	}                    
	 	reader.readAsDataURL(input.files[0]);
	 }
	}
function goBack(){
	history.back();
}
</script>
</body>
</html>
