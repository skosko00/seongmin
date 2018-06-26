<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/View/main/layout/preventurl.jsp"></jsp:include>
<script type="text/javascript">
	alert('비밀번호를 잘못입력했습니다');
	history.back(-1);
</script>