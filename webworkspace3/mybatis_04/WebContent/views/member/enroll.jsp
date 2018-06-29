<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 가입</title>
</head>
<body>
<h1>회원 가입 정보</h1>
<form action="/enroll" method="post">
ID : <input type="text" name="memberId"><br>
PW : <input type="password" name="memberPw"><br>
PW_re : <input type="password" name="memberPw_re"><br>
이름 :  <input type="text" name="memberName"/><br>
지역 : 
<input type="radio" name="memberAddr" checked value="서울시"/>서울
<input type="radio" name="memberAddr" value="경기도"/>경기
<input type="radio" name="memberAddr" value="인천시"/>인천
<input type="radio" name="memberAddr" value="강원도"/>강원
<input type="radio" name="memberAddr" value="전라도"/>전라
<input type="radio" name="memberAddr" value="충청도"/>충청
<input type="radio" name="memberAddr" value="경상도"/>경상
<input type="radio" name="memberAddr" value="제주도"/>제주
<br>
성별 :  
<input type="radio" name="gender" checked value="남"/> 남성
<input type="radio" name="gender" value="여"/> 여성
<br>
취미 : 
<input type="checkbox" name="hobby" value="여행"/>여행
<input type="checkbox" name="hobby" value="음악감상"/>음악감상
<input type="checkbox" name="hobby" value="춤"/>춤
<input type="checkbox" name="hobby" value="공부"/>공부
<br>
<input type="submit" value="회원가입"/>

</form>
</body>
</html>