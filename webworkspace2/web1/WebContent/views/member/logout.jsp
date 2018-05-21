<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="member.model.vo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if (session.getAttribute("user") != null) {
			session.invalidate();
	%>
	<H1>로그아웃 되었습니다.</H1>
	<%
		} else {
	%>
	<H1>로그인 정보가 없습니다.</H1>
	<%
		}
	%>

	<a href="/web1/views/member/memberIndex.html">로그인 페이지로 이동</a>

</body>
</html>