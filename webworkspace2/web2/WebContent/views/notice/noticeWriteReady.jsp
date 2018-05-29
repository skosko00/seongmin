<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="notice.model.vo.*" %>
<% Notice n = (Notice)request.getAttribute("notice"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 작성</title>
</head>
<body>

<form action="/noticeWrite" style="display: inline;">
글제목 : <input type="text" name="subject" size=89><br>
<textarea rows="20" cols="100" style="resize: none;" name="contents"></textarea>
<br>

<input type="submit" value="작성하기">
<button type="button" onclick="back();">목록</button>
</form>
<script>
	function back(){
		history.go(-1);
	}
</script>
</body>
</html>