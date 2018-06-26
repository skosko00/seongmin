<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/View/main/layout/preventurl.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/View/main/layout/cssjs.jsp"></jsp:include>
	<title>관리자</title>
</head>
<body>
	<!--  a 태그들은 나중에 서블릿을 만들어야 한다. -->

	<!-- 메뉴 바 -->
	<jsp:include page="/View/admin/layout/sideMenu.jsp"></jsp:include>
	<!-- 이 부분이 본문 -->
	<div class="ui pusher">
		<!-- 헤더 부분  -->
		<div class="ui segment">
			<h3 class="ui header">객실 등록</h3>
		</div>
		<!-- 본문 내용 시작-->
		<div class="ui container">
		<div class="ui red message"><div class="ui small header">※ 객실을 등록하려면 아래 모든 항목을 입력하세요</div></div>
			<form class="ui form segment" action="/adminRoomInsert" method="post" enctype="multipart/form-data">
				<h2 class="ui dividing header">객실 정보</h2>
				<div class="field">
					<label>객실명</label>
					<div class="ui input">
						<input type="text" placeholder="객실명 입력" name="PS_Name" maxlength="16" required>
					</div>
				</div>
				<div class="fields">
					<div class="two wide field">
						<label>기준 인원</label>
						<input type="number" name="PS_Person" placeholder="0" required>
					</div>
					<div class="two wide field">
						<label>최대인원</label>
						<input type="number" name="PS_MaxPerson" placeholder="0" required>
					</div>
					
				</div>
				<!--  객실 요금  -->
				<h2 class="ui dividing header">객실 요금 정보</h2>
				<div class="fields">
					<div class="three wide field">
						<label> 주말 요금</label>
						<input type="number" placeholder="0원" name="PS_Weekend"  step="1000" required>
					</div>
					<div class="three wide field">
						<label> 주중 요금</label>
						<input type="number" placeholder="0원" name="PS_Weekday"  step="1000" required>
					</div>
					<div class="three wide field">
						<label> 추가 요금</label>
						<input type="number" placeholder="0원" name="PS_Addition_Price"  step="1000" required>
					</div>
				</div>
				<div class="field">
					<label>객실 소개</label>
					<div class="ui red message">※ 최대 1333자(한글기준)까지 입력가능합니다</div>
					<div class="ui input">
						<textarea rows="10" name="PS_Contents" maxlength="1333" required placeholder="객실 소개 글 입력"></textarea>
					</div>
				</div>
				<h4>객실 사진 정보</h4>
				<!--  메인 사진 설정 -->
				<div class="field">
					<label>메인 사진 설정</label>
					<input type="file" name="input_main" onchange="mainImgPreview(this);" accept="image/*" required />
					<img class="ui image" id="main_img">
				</div>
				<!--  그 외 사진 설정 -->
				
				<div class="field">
					<label>사진 추가</label>
					<!-- <input type="button" class="ui button" onclick="return addImg();" value="사진 추가"  /> -->
					<!-- <input type="file"  name="etc_img" onchange="etcImgPreview(this);"  multiple="multiple" accept="image/*"  maxlength="10" /> -->
					<input type="file" id="etc_img" name="etc_img"  multiple="multiple" accept="image/*"  maxlength="10" />
					<!--  사진 미리보기를 추가할 곳... -->
					<!--  이 곳은 개선이 필요하다... -->
					<div id="etc_inputs" >
					</div>
					<div class="ui tiny images" id="etc_preview" >
						
					</div>
					
				</div>
				<!--  -->
				<input  type="submit" class="ui orange button" value="등록" onclick="return Check();" >
				<input  type="reset" class="ui green button" value="초기화">
			</form>
			<button class="ui blue button" onclick="goBack();" >뒤로가기</button>
			<br><br><br><br>
		</div>
		<!-- 본문 내용 끝  -->
	</div>

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
	<script>
		$('select.dropdown').dropdown();
		$('.ui.radio.checkbox').checkbox();
		function goBack(){
			history.back();
		}
	</script>
	<script type="text/javascript">
var index = 0; // 이름을 구분하기 위해서 index 추가 ...
// 메인 사진 미리보기
function mainImgPreview(input){
	$('#main_img').attr('src',"");
	 if (input.files && input.files[0]) {           //파일존재할시 
	 	var reader = new FileReader();          
	 	reader.onload = function (e) {        
	 		$('#main_img').attr('src', e.target.result);             
		   //id = "bImgPreview" 에 img 태그 src를 해당 이미지 url로 변경한다  span안에 img 태그 있을경우!  하지만 위에는 없음..
			//​$('#bImgPreview').html('<img src="'+e.target.result+'">');  난요런식으로 응용	​
		}                    
		reader.readAsDataURL(input.files[0]);
	}

}
// 이미지를 받을 input을 추가 
function addImg(){
	var $etc_inputs = $('#etc_inputs');
	var html = "<input type=\"file\" class=\"ui tiny image\" name=\"etc_img_"+(index++)+"\" onchange=\"etcImgPreview(this);\" >";
	$etc_inputs.append(html);
	return false;
}

</script>
<script type="text/javascript">
	var $etc_img = $('#etc_img');
	
	$etc_img.on("change",function(e) {
		$('#etc_preview').html("");
	    var files = e.target.files; // FileList 객체
	    for(var i=0; i<files.length; i++){
	    	if(i===0)
	    	{
	    		$('#etc_preview').html("");
	    	}
	    	var fileReader = new FileReader();
	    	fileReader.readAsDataURL(e.target.files[i]);
	    	fileReader.onload = function(e) { 
	    		var str = "<img src='"+e.target.result+"' class='ui image'> ";
	    		$('#etc_preview').append(str);
	    	}
	    }
	});

</script>
<!-- TODO: 유효성 검사 필요  -->
<script>

</script>
</body>
</html>
