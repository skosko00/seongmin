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

<!-- 
https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=mslove
 -->

<c:url var="url" value="https://search.naver.com/search.naver">
	<c:param name="where" value="nexearch"/>
	<c:param name="sm" value="top_hty"/>
	<c:param name="fbm" value="0"/>
	<c:param name="ie" value="utf8"/>
	<c:param name="query" value="mslove"/>
</c:url>

<a href="${url}">네이버 mslove 검색</a>

</body>
</html>