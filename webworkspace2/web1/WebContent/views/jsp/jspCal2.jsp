<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
int val1 = Integer.parseInt(request.getParameter("val1"));
String yun = request.getParameter("yun");
int val2 = Integer.parseInt(request.getParameter("val2"));
%>
입력한 첫번째 값 : <%= val1 %><br>
입력한 연산자 : <%= yun %><br>
입력한 두번째 값 : <%= val2 %><br>
결과
<br>
<%
if(yun.equals("+"))
{
%><%= val1 %> <%= yun %> <%= val2 %> = <%= val1+val2 %>
<% }else if(yun.equals("-"))
{
%>
<%= val1 %> <%= yun %> <%= val2 %> = <%= val1-val2 %>
<% }else if(yun.equals("*"))
{
%>
<%= val1 %> <%= yun %> <%= val2 %> = <%= val1*val2 %>
<% } else if(yun.equals("/")) 
{
%>
<%= val1 %> <%= yun %> <%= val2 %> = <%= val1/(double)val2 %>
<% } else{%>
연산자를 확인해주세요
<%} %>
</body>
</html>