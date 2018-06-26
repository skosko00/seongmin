<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page errorPage="/View/error/error.jsp"%>
<jsp:include page="/View/main/layout/preventurl.jsp"></jsp:include>
<script type="text/javascript">
	alert('로그아웃에 실패했습니다\n(이미 로그아웃 됐거나 비 정상적인 접근입니다)');
	location.href = '/index.jsp';
</script>