<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="jsp.board.model.vo.*,jsp.admin.model.vo.*,java.util.*" %>
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
	<!-- 이 부분이 본문 -->
	<div class="ui pusher">
		<!-- 헤더 부분  -->
		<div class="ui segment">
			<h3 class="ui header">공지사항 등록</h3>
		</div>
		<!-- 본문 내용 시작-->
		<div class="ui container">
			<% 
			BoardTotalInfoVo btlv = (BoardTotalInfoVo)request.getAttribute("boardDetail");
			
			
			%>
			<!-- 테이블 시작 -->
			<h1>공지사항</h1>
			<div class="ui segment">
				
				<form class="ui form" method="post" action="/adminBoardModify" enctype="multipart/form-data">
					
					<label>제목</label>
					<input type="text" class="ableChange" readonly="readonly" value="<%= btlv.getBv().getBdName() %>">
					
					
					<label>작성자</label>
					<input type="text" class="ableChange" readonly="readonly" value="<%= btlv.getBv().getBdWriter() %>">
					
					
					<label>작성일</label>
					<input type="text" class="ableChange" readonly="readonly" value="<%= btlv.getBv().getBdWriteDate() %>">
					
					
					
					<label>내용</label>	
					<textarea style="resize:none" class="ableChange" name="bdcontents" readonly="readonly"><%= btlv.getBv().getBdContents()%> </textarea>
					<label>첨부 사진</label>
					<input type="file" class="ui button" id="imglist" name="imglist" multiple="multiple" disabled="disabled" style="display:none" />
					<label>미리보기</label>
					<div id="preview"class="ui tiny images">
						<% for(int i = 0 ; i <btlv.getList().size(); i++){ %>
						<img class="ui image" src="<%= btlv.getList().get(i).getBdFilePath()%>" >
						<% } %>
					</div>
					
					<input type="submit" class="ui button ableChange" value="수정" disabled="disabled" style="display: none">
					<input type="reset" class="ui button ableChange" value="취소" disabled="disabled" style="display: none">
					
				</form>
				
				
			</div>
			<!--  테이블 끝 -->
			
			<div class="ui button">
				<a href="/adminBoardList">목록으로</a>
			</div>
			<button class="ui button" onclick="ableModi();" >수정</button>
			<form  method="post" action="/adminBoardDelete"  style="display:inline;">
				<input type="hidden" name="bdNo" value="<%= btlv.getBv().getBdNo()%>" >
				<input type="submit" class="ui button" value="전체 삭제">
			</form>
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
	<script type="text/javascript">
		var $imgList = $('#imglist');

		$imgList.on("change",function(e) {
			
    var files = e.target.files; // FileList 객체
    for(var i=0; i<files.length; i++){
    	if(i===0)
    	{
    		$('#preview').html("");
    	}
    	var fileReader = new FileReader();
    	fileReader.readAsDataURL(e.target.files[i]);
    	fileReader.onload = function(e) { 
    		var str = "<img src='"+e.target.result+"' class='ui image'> ";
    		$('#preview').append(str);
    	}
    }
});
</script>
</body>

</html>