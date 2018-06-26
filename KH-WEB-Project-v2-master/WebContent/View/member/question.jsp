<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page errorPage="/View/error/error.jsp"%>

<head>
	<jsp:include page="/View/main/layout/cssjs.jsp"></jsp:include>
</head>

<!-- 로그인 안했을 때-->
<div class="ui mini modal" id="noLoginQuestion">
	<div class="header">1:1 문의</div>
	<div class="content">
		<p>1:1 문의는 마이페이지에서 하시기바랍니다</p>
	</div>
	<div class="actions">
		<div class="ui blue cancel button" id="confirm1">확인</div>
	</div>
</div>

<!-- 로그인 했을 때-->
<div class="ui mini modal" id="loginQuestion">
	<div class="header">1:1 문의</div>
	<div class="content">
		<p>1:1 문의는 로그인 후<br> 마이페이지에서 가능합니다</p>
	</div>
	<div class="actions">
		<div class="ui blue cancel button" id="confirm2">확인</div>
	</div>
</div>

<c:set value="${sessionScope.member.mbId}" var="id"></c:set>
<c:choose>
<c:when test="${not empty id}">
<script type="text/javascript">
	$('#noLoginQuestion')
	.modal('show').modal('setting', 'closable', false);
</script>
</c:when>
<c:otherwise>
<script type="text/javascript">
	$('#loginQuestion')
	.modal('show').modal('setting', 'closable', false);
</script>
</c:otherwise>
</c:choose>

<script type="text/javascript">
	$('#confirm1').click(function(){
		location.href = '/mypagelogin';
	});
	$('#confirm2').click(function(){
		location.href = '/loginpage';
	});
</script>


