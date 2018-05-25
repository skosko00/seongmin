<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.model.vo.*" %>
<% Member m = (Member)request.getAttribute("userInfo"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MyPage</title>
</head>
<body>
<center>
<h1>회원 정보</h1>
<h4>
<form action="/memberUpdate" method="post">
ID : <input type="text" readonly value=<%=m.getUserId() %> name="userId"><br>
PW : <input type="password" value=<%=m.getUserPwd() %> name="userPwd"><br>
PW(re) : <input type="password"value=<%=m.getUserPwd() %> ><br>
Name : <input type="text" readonly value=<%=m.getUserName() %> name="userName"><br>
Age : <input type="text" readonly value=<%=m.getAge() %> name="age"><br>
Email : <input type="email" value=<%=m.getEmail() %> name="email"><br>
Phone : <input type="text" value=<%=m.getPhone() %> name="phone"><br>
Address : <input type="text" value=<%=m.getAddress() %> name="address"><br>
Gender : 
<input type="radio" name="gender" disabled value="M" <%if(m.getGender().equals("M")) {%>checked="checked"<%} %>>남
<input type="radio" name="gender" disabled value="F" <%if(m.getGender().equals("F")) {%>checked="checked"<%} %>>여
<br>
취미 : <input type="text" value=<%=m.getHobby() %> name="hobby"><br>
<input type="submit" value="수정하기">
<button type="button" onclick="back();">취소</button>
</form>
</h4>
</center>
<script type="text/javascript">
function back() {
	location.href="/";
}
</script>
</body>
</html>