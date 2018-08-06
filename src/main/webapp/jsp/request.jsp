<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 스크립틀릿 에서는 자바 코드를 작성할 수 있다. --%>
<% 
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	//jsp 기본객체 : request, response
	request.getLocalAddr();
%>

	request.getLocalAddr() : <%=request.getLocalAddr() %><br>	<!-- 접속한 호스트 -->
	request.getLocalPort() : <%=request.getLocalPort() %><br>	<!-- 톰켓 서버포트 -->
	request.getRemoteAddr() : <%=request.getRemoteAddr()%><br>	
	request.getRemoteHost() : <%=request.getRemoteHost()%><br>
	request.getRemotePort() : <%=request.getRemotePort()%><br>
	request.getCharacterEncoding() : <%=request.getCharacterEncoding()%><br>
	request.getContentType() : <%=request.getContentType()%><br>
	request.getContextPath() : <%=request.getContextPath()%><br>
	request.getRequestURL() : <%=request.getRequestURL()%><br>
	request.getRequestURI() : <%=request.getRequestURI()%><br>
	request.getServerName() : <%=request.getServerName()%><br>
	request.getServerPort() : <%=request.getServerPort()%><br>
	request.getMethod() : <%=request.getMethod()%><br>

</body>
</html>