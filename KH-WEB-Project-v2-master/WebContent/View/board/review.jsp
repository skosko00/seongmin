<%@page import="java.util.regex.Matcher"%>
<%@page import="java.util.regex.Pattern"%>
<%@page import="jsp.member.model.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="jsp.board.model.vo.*" import="java.util.*"%>
<%
MemberVo m = (MemberVo) session.getAttribute("member");
%>
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
	<script src='https://www.google.com/recaptcha/api.js'></script>
	<jsp:include page="/View/main/layout/cssjs.jsp"></jsp:include>
	<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
	<title>고객후기</title>
</head>
<style>
</style>

<body>

	<!-- 헤더 시작  -->
	<jsp:include page="/View/main/layout/header.jsp"></jsp:include>
	<!-- 헤더 끝 -->
	<br>
	<!-- 본문 시작 -->
	<div class="ui container">
		<!-- 여기에 본문 내용 작성하면 됨 -->
		<div class="ui center aligned basic segment">
			<div class="ui icon message">
				<i class="clipboard outline icon"></i>
				<div class="content">
					<div class="header">
						<h1>후기 게시판</h1>
					</div>
				</div>
			</div>

			<div class="ui right aligned basic segment" style="margin: 0px; padding-top: 0px; padding-bottom: 8px;">
				<form action="/View/board/reviewWriteReady.jsp">
					<input type="submit" class="ui orange tiny button" id="loginPlease" value="글쓰기"> 
				</form>
			</div>
			<div id="board" style="width: 100%; padding-bottom:80px;">
				<table class="ui table" width="100%" cellpadding="0" cellspacing="0"
				border="0">

				<thead>
					<tr>
						<th width="70">번호</th>
						<th width="380">제목</th>
						<th width="70">작성자</th>
						<th width="90">작성일</th>
						<th width="60">추천수</th>
						<th width="60">조회수</th>
					</tr>
				</thead>

				<%
				if (request.getAttribute("Page") == null) {
				%>
				<tbody>
					<tr>
						<td colspan="6" class="ui center aligned basic segment">등록된
						게시물이 없습니다.</td>
					</tr>
				</tbody>
				<%
			} else {
			Page pagev = (Page) request.getAttribute("Page");
			ArrayList<BoardVo> list = pagev.getList();
				String getPageCount = pagev.getPageCount();

				for (BoardVo b : list) {

				Timestamp writeDay = b.getBdWriteDate();
				Timestamp stamp = new Timestamp(Calendar.getInstance().getTimeInMillis());
				Date date = new Date(writeDay.getTime());
				%>
				<tbody>
					<tr>
						<td><%=b.getBdNo()%></td>
						<td><a href="/reviewSelect?bdNo=<%=b.getBdNo()%>"
							style="font-weight: 600;">[후기] <%=b.getBdName()%></a></td>
							<%if(b.getBdWriter() != null) {
								Pattern p = Pattern.compile("(^[0-9]*$)");
								Matcher reg = p.matcher(b.getBdWriter());
							if(reg.find()){%>
							<td>네이버 회원</td>
							<%} else {%>
							<td><%=b.getBdWriter()%></td>
							<% } %>
							<% } else {%>
							<td>탈퇴한 회원</td>
							<%} %>
							<td><%=date%></td>
							<td><%=b.getBdRecommendCount()%></td>
							<td><%=b.getBdViewCount()%></td>
						</tr>
					</tbody>
					<%
				}
				%>
				<tfoot>
					<tr>
						<th colspan="6">
							<div class="ui right floated pagination menu">
								<%=getPageCount%>
							</div>
						</th>
					</tr>
				</tfoot>
				<%
			}
			%>

		</table>
		<form action="/reviewSearch" method="get" style="display:inline;">
			<select class="ui dropdown" name="searchOption" style="width:80px;">
				<option value="title" selected>제목</option>
				<option value="contents">내용</option>
				<option value="writer">작성자</option>
			</select> 
			<div class="ui input" style="margin-top: 15px;">
				<input type="text" name="search" placeholder="검색" style="margin-right: 5px;" id="searchVal">
				<input class="ui blue button" type="submit" value="검색" style="margin-left: 5px;" onclick="return blankCheck();">
			</div>
		</form>
		<br><br>

		<%-- 공지사항 글쓰기 관리자 페이지로 이동 --%>

		<!--  -->
	</div>
</div>

</div>
<!-- 본문 끝 -->

<!-- 푸터 시작  -->
<jsp:include page="/View/main/layout/footer.jsp"></jsp:include>
<!-- 푸터 끝 -->

</body>

<!-- 로그인 안했을 경우-->
<div class="ui mini modal" id="needLogin">
	<div class="header">로그인</div>
	<div class="content">
		<label style="margin-left: 4px;">아이디</label>
		<div class="ui input" style="margin-left: 10px;">
			<input type="text" id="id" placeholder="아이디" maxlength="16">
		</div>
		<br><br>
		<label>비밀번호</label>
		<div class="ui input">
			<input type="password" id="pwd" placeholder="비밀번호" maxlength="16">
		</div>
		<br><br>
		<div class="ui centered grid">
			<div id="recap" class="g-recaptcha" data-sitekey="6Lfrr18UAAAAAGd424fRQMeX4GYy6FjS7Af1V8tJ"></div>
		</div>
		<div class="ui centered grid" id="naverLoginBtn">
			<div id="naver_id_login" style="margin-top: 10px;"></div>
		</div>
	</div>
	<div class="actions">
		<div class="ui blue cancel button" id="confirm">로그인</div>
		<div class="ui orange cancel button">취소</div>
	</div>
</div>

<!-- recapcha 확인용-->
<div class="ui mini modal" id="robot">
	<div class="header">로그인 실패</div>
	<div class="content">
		<p>로봇이 아님을 인증하세요</p>
	</div>
	<div class="actions">
		<div class="ui blue cancel button">확인</div>
	</div>
</div>


<!-- 아이디 || 비밀번호 공백 일 경우 -->
<div class="ui mini modal" id="blankModal">
	<div class="header">로그인 실패</div>
	<div class="content">
		<p>아이디와 비밀번호를 모두 입력해주세요</p>
	</div>
	<div class="actions">
		<div class="ui blue cancel button" id="termsModal">확인</div>
	</div>
</div>



<script>
	function blankCheck() {
		var searchVal = $('#searchVal').val();
		if (searchVal == "") {
			alert('검색 내용을 입력해주세요');
			return false;
		} else
		return true;
	}

	function loginPlease() {
		$('#needLogin').modal('show');
	}

	$('#confirm').click(function() {

		var id = $('#id').val();
		var pwd = $('#pwd').val();

		if (id == "" || pwd == "") {
			$('#blankModal').modal('show');
			return false;
		} else {
			var auth = grecaptcha.getResponse();
			if (auth.length == 0) {
				$('#robot').modal('show');
				return false;
			} else {
				$.ajax({
					url : '/loginImmediate',
					type : 'POST',
					data : {
						id : id,
						pwd : pwd
					},
					success : function(data) {
						if (data == "1") {
							location.reload();
						} else {
							alert('아이디 또는 비밀번호를 확인해주세요');
						}
					},
					error : function() {
						alert('서버 오류 (잠시 후 다시 시도 해주세요');
					}
				});

			}
		} 
	});

/*	$('.message .close').on('click', function() {
		$(this).closest('.message').transition('fade');
	});*/

	/* 네아로 */
	var naver_id_login = new naver_id_login("PyoIesHAhe6a3F1GDj9P", "http://localhost/View/member/naverLoginCallBackNowPage.jsp");
	var state = naver_id_login.getUniqState();
	naver_id_login.setButton("green", 3, 35);
	naver_id_login.setDomain("http://localhost/View/member/naverLogin.jsp");
	naver_id_login.setState(state);
	naver_id_login.setPopup(); /* 팝업 로그인 창*/
	naver_id_login.init_naver_id_login();
</script>

<!-- 로그인 여부  -->
<c:set value="${sessionScope.member.mbId}" var="id"></c:set>
<c:if test="${empty id}">
<script type="text/javascript">
	$('#loginPlease').click(function(){
		$('#needLogin').modal('show');
		return false;
	});
</script>
</c:if>

</html>
