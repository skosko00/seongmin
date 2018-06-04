<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>forTokens 예제</title>
</head>
<body>

<% String data = request.getParameter("hobby"); %>
<c:forTokens var="hobby" items="<%=data%>" delims=",">
	${hobby}<br>
</c:forTokens>


<c:forTokens var="hobby" items="${param.hobby}" delims=",">
	${hobby}<br>
</c:forTokens>

</body>
</html>