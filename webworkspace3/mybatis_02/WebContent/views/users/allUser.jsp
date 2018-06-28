<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>전체 회원 정보 출력</title>
</head>
<body>
<c:forEach items="${list }" var="s">
ID : ${s.userId }<br>
PW : ${s.userPw }<br>
NICK : ${s.userNick }<br>
TEL : ${s.userTel }<br>
REG : ${s.regDate }<br>
<hr>
</c:forEach>
</body>
</html>