<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="notice.model.vo.*" %>
<% Notice n = (Notice)request.getAttribute("notice"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 수정</title>
</head>
<body>
글번호 : <%=n.getNoticeNo() %><br>
글쓴이 : <%=n.getUserId() %><br>
작성일 : <%=n.getRegDate() %><br>
<form action="/noticeUpdate" style="display: inline;">
글제목 : <input type="text" name="subject" value="<%=n.getSubject() %>" size=89><br>
<textarea rows="20" cols="100" style="resize: none;" name="contents"><%=n.getContents() %></textarea>
<br>


<input type="hidden" name="noticeNo" value="<%=n.getNoticeNo()%>">
<input type="submit" value="수정하기">
</form>

</body>
</html>