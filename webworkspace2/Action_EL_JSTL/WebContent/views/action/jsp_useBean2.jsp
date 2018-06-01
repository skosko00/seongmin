<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>정보 출력</h1>
<jsp:useBean id="member" class="member.model.vo.Member" scope="request"></jsp:useBean>
이름 : <jsp:getProperty name="member" property="name" /><br>
나이 : <jsp:getProperty name="member" property="age" /><br>
주소 : <jsp:getProperty name="member" property="addr" /> <br>
</body>
</html>