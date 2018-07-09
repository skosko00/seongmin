<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>회원가입 정보</h3>
<form action="/enroll.do" method="get">
ID : <input type="text" name="userId"><br>
PW : <input type="password" name="userPw"><br>
PW_re : <input type="password" name="userPw_re"> <br>
NAME : <input type="text" name="userName"> <br>
PHONE : <input type="text" name="userPhone"> <br>
<input type="submit" value="회원가입"/>
</form>
</body>
</html>