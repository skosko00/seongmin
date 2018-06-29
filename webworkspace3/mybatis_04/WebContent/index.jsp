<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인 페이지</title>
</head>
<body>
<c:if test="${empty member}">
회원 로그인
<form action="/login" method="post">
ID : <input type="text" name="memberId"><br>
PW : <input type="password" name="memberPw"><br>
<input type="submit" value="로그인">
</form>
<a href="/views/member/enroll.jsp">회원가입</a>
</c:if>
<c:if test="${not empty member }">
<h1>[${member.memberName }]님 환영합니다</h1>
<a href="/logout">로그아웃</a><br>
<a href="/myInfo">마이정보 보기</a><br>
<a href="/delete">회원 탈퇴</a><br>
<c:if test="${member.memberId eq 'admin' }">
<a href="/allMember">전체회원 보기[관리자전용]</a><br>
</c:if>
</c:if>
</body>
</html>