<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>전체 회원 리스트</title>
</head>
<body>
<table border="1">
<tr><th>번호</th><th>ID</th><th>이름</th><th>지역</th><th>성별</th><th>취미</th><th>가입일</th></tr>
<c:forEach items="${list }" var="m">
<tr>
<td>${m.memberNo }</td>
<td>${m.memberId }</td>
<td>${m.memberName }</td>
<td>${m.memberAddr }</td>
<td>${m.gender }</td>
<td>${m.hobby }</td>
<td>${m.regDate }</td>
</tr>
</c:forEach>
</table>

<hr>
이름 또는 ID 또는 주소로 검색하기
<form action="/search1" method="get">
<input type="radio" name="searchRadio" value="name" checked/>이름
<input type="radio" name="searchRadio" value="id"/>ID
<input type="radio" name="searchRadio" value="addr"/>주소  
<input type="text" name="searchKeyword"/>
<input type="submit" value="검색"/>
</form>
<hr>
선택하여 출력 (번호,ID,가입일은 기본적으로 보임)
<form action="/search2" method="get">
<input type="checkbox"  name="name"/>이름
<input type="checkbox"  name="addr"/>주소
<input type="checkbox"  name="gender"/>성별
<input type="checkbox"  name="hobby"/>취미
 <input type="submit" value="검색"/>
</form>
<hr>
지역별로 출력
<form action="/search3" method="get">
<input type="checkbox" name="addr" value="서울시"/>서울
<input type="checkbox" name="addr" value="경기도"/>경기
<input type="checkbox" name="addr" value="인천시"/>인천
<input type="checkbox" name="addr" value="강원도"/>강원
<input type="checkbox" name="addr" value="전라도"/>전라
<input type="checkbox" name="addr" value="충청도"/>충청
<input type="checkbox" name="addr" value="경상도"/>경상
<input type="checkbox" name="addr" value="제주도"/>제주
<br>
<input type="submit" value="검색"/>
</form>

</body>
</html>