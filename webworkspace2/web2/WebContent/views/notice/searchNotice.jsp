<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="notice.model.vo.*" import="java.util.*" %>
<%
PageData pd = (PageData)request.getAttribute("pageData"); 
ArrayList<Notice> list = pd.getNoticeList();	// 현재 페이지 리스트
String pageNavi = pd.getPageNavi();	// navi 리스트
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h1> 공지사항 </h1>
<table border="1">
<tr><th>글번호</th><th>글제목</th><th>작성자</th><th>작성일</th></tr>
<% for(Notice n : list) { %>
<tr>
<td><%=n.getNoticeNo() %></td>
<td><%=n.getSubject() %></td>
<td><%=n.getUserId() %></td>
<td><%=n.getRegDate() %></td>
</tr>
<%} %>
</table>
<label><%=pageNavi %></label><br>
<form action="/searchNotice" method="get">
<input type="text" name="search">
<input type="submit" value="검색">
</form>
</center>
</body>
</html>