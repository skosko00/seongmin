<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.model.vo.*" %>
<% Member m = (Member)session.getAttribute("user"); 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#infoBtn,#deleteBtn
{
cursor: pointer;
text-decoration: underline;
color: blue;
}
</style>
</head>
<body>
<% if(m==null){ %>
<fieldset style="width:300px; height:100px;">
<legend>로그인</legend>
<form action="/login" method="post" style="display:inline;">
ID : <input type="text" placeholder="ID를 입력하세요" name="userId"><br>
PW : <input type="password" placeholder="PW를 입력하세요" name="userPwd"><br>
<input type="submit" value="로그인">
</form>
<a href="/views/member/joinus.html">회원가입</a>
<a href="">ID 찾기</a>
<a href="">PW 찾기</a>
</fieldset>
<%}else{ %>
<h1>[<%= m.getUserName() %>]님 반갑습니다.</h1>
<label onclick="myInfo();" id="infoBtn">마이페이지</label>
<form action="/myInfo" method="post" style="display: none;" id="myInfo">
<label style="color:red;">비밀번호 입력 : </label>
<input type="password" name="userPwd"/>
<input type="submit" value="확인">
</form><br>
<a href="/logout">로그아웃</a>
<label onclick="myDelete();" id="deleteBtn">회원탈퇴</label>
<form action="/memberDelete" method="post" style="display: none;" id="myDelete">
<label style="color:red;">비밀번호 입력 : </label>
<input type="password" name="userPwd"/>
<input type="submit" value="확인">
</form><br>
<% if(m.getUserId().equals("admin"))
	{
	%>
<a href="/allMember">회원전체조회</a><br>
<%}%>
<a href = "/views/file/upload.html">업로드</a><br>
<a href = "/fileList">다운로드</a><br>
<a href = "/views/file/upload2.html">업로드2</a><br>
<a href = "/fileList2">다운로드2</a><br>
<%}  %>
<br>
<a href = "/notice">공지사항</a><br>

<script type="text/javascript">
function myInfo() {
	document.getElementById("myInfo").style="display:inline";
}
function myDelete() {
	document.getElementById("myDelete").style="display:inline";
}
</script>
</body>

</html>