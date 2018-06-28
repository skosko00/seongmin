<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보 수정하기</title>
</head>
<body>
<h1>회원 정보 수정</h1>
<form action="/updateUser" method="post">
ID : <input type="text" value="${users.userId }" readonly> <br>
<input type="hidden" value = "${users.userId }" name="userId"> <br>
PW : <input type="password" value="${users.userPw }" name="userPw"> <br> 
NICK : <input type="text" value="${users.userNick }" name="userNick"> <br>
TEL : <input type="text" value="${users.userTel }" name="userTel"> <br>
<input type="submit" value="수정하기"> <input type="reset" value="초기화">
</form> 
</body>
</html>