<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="member.model.vo.*" import="member.model.service.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보 수정</title>
</head>
<script type="text/javascript">
function back() {
	history.go(-2);
}
</script>
<body>
	<%
	Member m = new Member();
	request.setCharacterEncoding("utf-8");
	m.setMemberId(request.getParameter("userId"));
	m.setMemberPwd(request.getParameter("userPw"));
	m.setMemberAddr(request.getParameter("userAddr"));
	int result = new MemberService().updateMember(m);
	if(result>0)
	{
		m = new MemberService().selectMember(m.getMemberId(), m.getMemberPwd());
		session.setAttribute("user", m);
		%>
		회원 정보 변경에 성공했습니다.<br>
		<button onclick="back();">돌아가기</button>
	<%}else{
%>
<h1>회원 정보 변경에 실패했습니다.</h1><br>
<button onclick="back();">돌아가기</button>
<%} %>
</body>
</html>