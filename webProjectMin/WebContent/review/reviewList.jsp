<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>reviewList.jsp</title>
</head>
<body>
	<h3 class="page_title">reviewList</h3>
	
	<div>
		<ul>
			<li><a href="/webProjectMin/sayingList.do">리스트로돌아가기</a>
			<li><a href="/webProjectMin/logout.do">로그아웃</a>
		</ul>
	</div>
	
	<table border="1" id="sayings">
		<thead>
			<tr>
				<th>saying</th>
				<th>person</th>
				<th>review</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${rlist}" var="reviewlist">
			<tr>
				<td><a href ="sayingSelectOne.do?num=${reviewlist.saying_number}">
					${reviewlist.saying}</a></td>
				<td>${reviewlist.person}</td>
				<td>${reviewlist.review}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>