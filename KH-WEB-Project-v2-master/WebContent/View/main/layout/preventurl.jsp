<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page errorPage="/View/error/error.jsp"%>
<%
	try {
		String accessCheck = request.getHeader("referer");
		if (accessCheck == null) {
%>

<script language="javascript">
	alert("비 정상적인 접근입니다.\n정상적인 경로를 통해 다시 접근해주세요.");
	document.location.href = "/";
</script>

<%
	}
		return;
	} catch (Exception e) {
	}
%>

