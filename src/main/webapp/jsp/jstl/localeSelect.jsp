<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="/common/jquery.jsp" %>

</head>
<body>
<form action="/localeSelect" method="get">
	<c:set var="userId" value="brown"/>
	
	<select name="locale" onchange="this.form.submit()">
		<option value="ko" ${relocale == 'ko' ? "selected" : '' }>한국</option>
		<option value="ja" ${relocale == 'ja' ? "selected" : '' }>日本語</option>
		<option value="en" ${relocale == 'en' ? "selected" : '' }>english</option>
	</select>
	<!-- $("select[name=lg]").val(); -->
	
	<fmt:setLocale value= "${param.locale }"/>
	<fmt:bundle basename="kr.or.ddit.msg.msg">
		<fmt:message key="hello"/><br>
		<fmt:message key="visitor"><br>
			<fmt:param value="${userId }"></fmt:param>
		</fmt:message>
	</fmt:bundle>
	<br>
</form>
</body>
</html>