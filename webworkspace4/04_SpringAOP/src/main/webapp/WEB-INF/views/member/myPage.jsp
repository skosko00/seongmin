<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>myPage</title>
</head>
<body>
<%-- 
	model 개체에 다은 것은 바로 key 값으로 사용됨
	ex) model.addAttribute("member" ,m);
	-> 사용시 ${member.name}
 --%>
<form action="/mUpdate.do" method="post">
ID : <input type="text" name="userId" value="${mem.userId }"> <br>
PW : <input type="password" name="userPw" value="00000000"> <br>
PW_re : <input type="password" name="userPw_re" value="00000000"> <br>
NAME : <input type="text" name="userName" value="${mem.userName }"> <br>
PHONE : <input type="text" name="userPhone" value="${mem.userPhone }"> <br>
<input type="submit" value="회원정보변경">
</form>
</body>
</html>