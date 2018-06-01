<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
<%@ page import="member.model.vo.Member" %>
<% Member m = new Member();
m.setName("홍길동");
m.setAge(20);
m.setAddr("경기도");
%>

이름 : <%=m.getName() %><br>
나이 : <%=m.getAge() %><br>
주소 : <%=m.getAddr()%><br>
 --%>

<jsp:useBean id="m" class="member.model.vo.Member" scope="page"></jsp:useBean>
<jsp:setProperty name="m" property="name" value="홍길동"/>
<jsp:setProperty name="m" property="age" value="20"/>
<jsp:setProperty name="m" property="addr" value="경기도"/>
<h1>Action Tag 사용!!</h1>
<%--
이름 : <%=m.getName() %><br>
나이 : <%=m.getAge() %><br>
주소 : <%=m.getAddr()%><br>
--%>
 
이름 : <jsp:getProperty name="m" property="name" /><br>
나이 : <jsp:getProperty name="m" property="age" /><br>
주소 : <jsp:getProperty name="m" property="addr" /> <br>
</body>
</html>