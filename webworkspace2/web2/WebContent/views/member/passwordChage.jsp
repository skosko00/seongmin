<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>패스워드 변경을 권장</title>
</head>
<body>
<h1>패스워드를 변경하신지 90일이 지났습니다.<br>
보안상 해킹을 당할 우려가 있으므로 변경을 권장합니다.</h1>
<form action="/changePassword" method="post">
비밀번호 : <input type="password" name="userPwd"><br>
비밀번호 확인 : <input type="password" name="userPwd"><br>
<input type="submit" value="변경하기">
<button type="button" onclick="back()">나중에 변경하기</button>
<script type="text/javascript">
function back() {
	location.href="/";
}
</script>
</form>
</body>
</html>