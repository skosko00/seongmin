<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" import="file.model.vo.*"%>
<% 
ArrayList<DataFile> list = (ArrayList<DataFile>)request.getAttribute("fileList");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>파일 리스트</title>
</head>
<body>
<center>
<h1>파일 리스트</h1>
<table border=1>
<tr>
<th>파일이름</th><th>파일사이즈</th><th>업로더</th><th>업로드시간</th><th>다운로드</th><th>삭제</th>
</tr>
<%for(DataFile df : list){ %>
<tr>
<td><%=df.getFileName() %></td>
<td><%=df.getFileSize() %></td>
<td><%=df.getFileUser() %></td>
<td><%=df.getUploadTime() %></td>
<td>
<form action="/fileDown" method="post">
<input type="hidden" value="<%=df.getFileName() %>" name="fileName">
<input type="hidden" value="<%=df.getUploadTime() %>" name="uploadTime">
<input type="submit" value="다운로드" style="width:100%">
</form>
</td>
<td>
<form action="/fileRemove" method="post">
<input type="hidden" value="<%=df.getFileName() %>" name="fileName">
<input type="hidden" value="<%=df.getUploadTime() %>" name="uploadTime">
<input type="submit" value="파일삭제" style="width:100%">
</form>
</td>
</tr>
<%} %>
</table>
<a href="/">메인페이지로 이동</a>
</center>
</body>
</html>