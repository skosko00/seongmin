<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인페이지</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>
<div style="padding:5px;">
<c:choose>
<c:when test="${sessionScope.member!=null}">
<h3>[${sessionScope.member.userName }]님 환영합니다.</h3>
<a href="/logout.do">로그아웃</a><br>
<a href="/myInfo.do">마이정보 보기</a><br>
<a href="/deleteMember.do">회원탈퇴</a><br>
<c:if test="${sessionScope.member.userId eq 'admin' }">
<a href="/allMember.do">전체회원 보기[관리자전용]</a>
</c:if>
</c:when>
<c:otherwise>
<form action="/login.do" method="post">
ID : <input type="text" name="userId" class="form-control" placeholder="아이디"><br>
PW : <input type="password" name="userPw" class="form-control"  placeholder="비밀번호"><br>
<input type="submit" value="로그인" class="btn btn-default">
<a href="/enrollView.do" class="btn btn-primary">회원가입</a><br>
</form>
</c:otherwise>

</c:choose>
</div>
</body>
</html>