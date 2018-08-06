<%@page import="kr.or.ddit.lprod.model.LprodVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>

<script src="/js/jquery-1.12.4.js"></script>
<link href="/bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="/bootstrap/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/blog.css" rel="stylesheet">
</head>

<body>
	<%@ include file="/common/top.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<%@ include file="/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">상품 EL</h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>상품 아이디</th>
									<th>상품 분류</th>
									<th>상품 이름</th>
								</tr>
								<%
// 									for (StudentVo vo1 : (List<StudentVo>) request.getAttribute("studentList")) {
// 										pageContext.setAttribute("vo", vo1);
								%>
<!-- 								<tr> -->
<%-- 									<td><%=vo.getId()%></td> --%>
<%-- 									<td><%=vo.getName()%></td> --%>
<%-- 									<td><%=vo.getcall_cnt()%></td> --%>
<!-- 								</tr> -->
									<c:forEach items="${lprodList }" var="vo">
										<tr>
											<td>${vo.lprod_id }</td>
											<td>${vo.lprod_gu }</td>
											<td>${vo.lprod_nm }</td>
										</tr>
									</c:forEach>
								

							</table>
							<br>
						<h2 class="sub-header">상품 표현식</h2>
							<table class="table table-striped">
								<tr>
									<th>상품 아이디</th>
									<th>상품 분류</th>
									<th>상품 이름</th>
								</tr>
								<%
									for (LprodVo vo1 : (List<LprodVo>) request.getAttribute("lprodList")) {
								%>
								<tr>
									<td><%=vo1.getLprod_id()%></td>
									<td><%=vo1.getLprod_gu()%></td>
									<td><%=vo1.getLprod_nm()%></td>
								</tr>
								<%} %>

							</table>
						</div>

						<a class="btn btn-default pull-right">사용자 등록</a>

						<div class="text-center">
							<ul class="pagination">
							<%=request.getAttribute("pageNavi")%>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
