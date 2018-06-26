<%@page import="jsp.member.model.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="jsp.board.model.vo.*" import="java.util.*"%>
<% MemberVo m = (MemberVo)session.getAttribute("member");%>
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
	<title>공지사항</title>
</head>

<style>
</style>

<body>

	<!-- 헤더 시작  -->
	<jsp:include page="/View/main/layout/header.jsp"></jsp:include>
	<!-- 헤더 끝 -->

	<!-- 본문 시작 -->
	<div class="ui container">
		<br>
		<!-- 여기에 본문 내용 작성하면 됨 -->
		<div class="ui center aligned basic segment">
			<div class="ui icon message">
				<i class="clipboard outline icon"></i>
				<div class="content">
					<div class="header">
						<h1>
							공지사항
						</h1>
					</div>
				</div>
			</div>
			<div id="board" style="width: 100%; padding-bottom: 60px;">
				<table class="ui table" width="100%" cellpadding="0" cellspacing="0" border="0">

					<thead>
						<tr>
							<th width="70">번호</th>
							<th width="380">제목</th>
							<th width="70">작성자</th>
							<th width="90">작성일</th>
							<th width="60">조회수</th>
						</tr>
					</thead>
					
					<%
					if(request.getAttribute("Page") == null) {
					%>
					<tbody> 
						<tr>
							<td colspan="6" class="ui center aligned basic segment">등록된 게시물이 없습니다.</td>
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
							<td>
								<a href="/noticeSelect?bdNo=<%=b.getBdNo()%>" style="font-weight: 600;">[공지] <%=b.getBdName()%></a>
							</td>
							<td><%=b.getBdWriter()%></td>
							<td><%=date%></td>
							<td><%=b.getBdViewCount()%></td>
						</tr>
					</tbody>
					
					<%
				}
				%>
				<tfoot>
					<tr><th colspan="6">
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
	<br>	<br>
	<form action="/search" method="get" style="display:inline;">
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

<script>
	function blankCheck() {
		var searchVal = $('#searchVal').val();
		if (searchVal == "") {
			alert('검색 내용을 입력해주세요');
			return false;
		} else
		return true;
	}
</script>

</html>
