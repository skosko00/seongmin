<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.model.vo.*" %>
<% Member m = (Member)session.getAttribute("user");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 성공</title>
<script type="text/javascript">
window.onload = function(){
	if(opener!=null)//자신이 팝업창 일 때
		{
		opener.location.reload();
		window.close();
		}
}
</script>
</head>
<body>
<h1>[<%= m.getUserName() %>]님 반갑습니다.</h1>
<a href="/">메인페이지로 돌아가기</a>
</body>
</html>