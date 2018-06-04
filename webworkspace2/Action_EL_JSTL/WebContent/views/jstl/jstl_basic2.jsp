<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:set var="choice" value="3" />

	<c:choose>
		<c:when test="${choice==1 }">
		1을 선택하였습니다.<br>
		</c:when>
		<c:when test="${choice==2 }">
		2를 선택하였습니다.<br>
		</c:when>
		<c:otherwise>
		그외를 선택하였습니다.<br>
		</c:otherwise>
	</c:choose>
	
	<c:forEach begin="1" end="10" var="i">
	${i}<br>
</c:forEach>

</body>
</html>