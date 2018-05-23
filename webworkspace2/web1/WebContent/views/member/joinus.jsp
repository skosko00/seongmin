<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.model.vo.*" import="member.model.service.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! public boolean isNumber(String str){ 
	return str.matches("^[0-9]*$");
}
%>
<%
Member m = new Member();
request.setCharacterEncoding("utf-8");
boolean check = isNumber(request.getParameter("userAge"));
if(check==true)
{
m.setMemberId(request.getParameter("userId"));
m.setMemberPwd(request.getParameter("userPw"));
m.setMemberName(request.getParameter("userName"));
m.setMemberAge(Integer.parseInt(request.getParameter("userAge")));
m.setMemberAddr(request.getParameter("userAddr"));
int result = new MemberService().memberInsert(m);
if(result>0)
{
%>	
	회원가입이 완료되었습니다.
<% }else{
	return;
}
}else{ %>
	회원가입에 실패되었습니다.
<% }
%>
<a href="/web1/views/member/memberIndex.html">로그인 페이지로 이동</a>
</body>
</html>