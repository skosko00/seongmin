<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page errorPage="/View/error/error.jsp"%>
<jsp:include page="/View/main/layout/preventurl.jsp"></jsp:include>
<script type="text/javascript">
	/* 사용 안하는 JSP ※ 페이징 (테스트 중) */
	alert('조회 할 정보가 없습니다');
	history.back(-1);
</script>

