<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원 정보</h1>
학생 번호 : ${requestScope.student.studentNo } <br>
학생 이름 : ${requestScope.student.studentName }<br>
학생 전화번호 : ${requestScope.student.studentTel }<br>
학생 이메일 : ${requestScope.student.studentEmail }<br>
학생 주소 : ${requestScope.student.studentAddr }<br>
</body>
</html>