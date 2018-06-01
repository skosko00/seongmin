<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> EL을 이용한 리스트 처리</h1>
<h3>첫번째 학생</h3>
이름 : ${members[0].name}<br>
나이 : ${members[0].age}<br>
주소 : ${members[0].addr}<br>
<h3>두번째 학생</h3>
이름 : ${members[1].name}<br>
나이 : ${members[1].age}<br>
주소 : ${members[1].addr}<br>
<h3>세번째 학생</h3>
이름 : ${members[2].name}<br>
나이 : ${members[2].age}<br>
주소 : ${members[2].addr}<br>
</body>
</html>