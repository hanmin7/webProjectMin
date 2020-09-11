<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sayingAll</title>
</head>
<body>
	
	<h3 class="page_title">saying 전체조회</h3>
	${sessionScope.id}님
	<div>
		<ul>
			<li><a href="/webProjectMin/reviewList.do">내감상리스트로</a>
			<li><a href="/webProjectMin/logout.do">로그아웃</a>
		</ul>
	</div>
	
	<table border="1" id="sayings">
		<thead>
			<tr>
				<th>num</th>
				<th>saying</th>
				<th>person</th>
				<th>category</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${slist}" var="saylist">
			<tr>
				<td><a href="sayingSelectOne.do?num=${saylist.getSaying_number()}">${saylist.getSaying_number()}</a></td>
				<td>${saylist.getSaying()}</td>
				<td>${saylist.getPerson()}</td>
				<td>${saylist.getCategory()}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>