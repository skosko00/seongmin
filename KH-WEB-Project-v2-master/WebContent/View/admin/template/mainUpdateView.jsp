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
<title>Main 수정</title>
</head>

<style>
</style>

<body>
	
	  <jsp:include page="/View/admin/layout/sideMenu.jsp"></jsp:include>
  <!-- 이 부분이 본문 -->
  <div class="ui pusher">
  <!-- 헤더 부분  -->
    <div class="ui segment">
      <h3 class="ui header">Main 사진 변경</h3>
    </div>
	<!-- 헤더 끝 -->

	<!-- 본문 시작 -->
	<br>
	<div class="ui container">
		<!-- 여기에 본문 내용 작성하면 됨 -->
		    <div class="ui grid">
<c:forEach begin="0" items="${requestScope.MainPicTb}" var="list" varStatus="i">
<div class="four wide column">
	 <form action="/adminMainUpdate" method="post" enctype="Multipart/form-data" style="display:inline;">
	<div id='image${i.count }'>
	<img src="${list.mainPicPath }" style="width:100%;">
	</div>
	<input type="hidden" name="image_path" value="${list.mainPicPath }" required />
	<%-- <div id="update${i.count }_div" style='display:none;'> 
	<img id="update${i.count }_preview" style='width:100px; height:100px;'> 
	</div> --%>
	<input type="hidden" name="img" id="update${i.count }" accept="image/*" required/><br>
	<br>
	<input type="hidden" id="update${i.count }_submit" value="수정" class="ui orange button">
	<button type="button" id="update${i.count }_btn" onclick="update('update${i.count }');" class="ui orange button">수정</button>
	<button type="button" id="update${i.count }_reBtn" style="display:none;" onclick="imageCancle('update${i.count }');" class="ui red button">취소</button>
	</form>
 </div>
</c:forEach>
</div>
<br><br>
<button onclick="back()" class="ui blue button">취소</button>
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
function update(id){
	document.getElementById(id).type="file";
	document.getElementById(id+"_btn").style="display:none";
	document.getElementById(id+"_submit").type="submit";
	document.getElementById(id+"_reBtn").style="display:inline";
}
function imageCancle(id) {
	document.getElementById(id).type="hidden";
	/* document.getElementById(id+'_preview').innerHTML=""; */
	document.getElementById(id+"_btn").style="display:inline";
	document.getElementById(id+"_submit").type="hidden";
	document.getElementById(id+"_reBtn").style="display:none";
}
/* function check(id){
var desfile = document.getElementById(id);
desfile.onchange = function(e) {
	  var fileReader = new FileReader();
	  fileReader.readAsDataURL(e.target.files[0]);
	  fileReader.onload = function(e) { 
		  document.getElementById(id+'_div').style = "display:inline";
		  document.getElementById(id+'_preview').src = e.target.result;
	 }
}

} */ 
</script>

</html>
