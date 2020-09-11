<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sayingSelectOne</title>
</head>
<body>
	<h3 class="page_title">명언선택</h3>
	<div>
		<ul>
			<li><a href="/webProjectMin/sayingList.do">리스트로돌아가기</a>
			<li><a href="/webProjectMin/reviewList.do">내감상리스트로</a>
			<li><a href="/webProjectMin/logout.do">로그아웃</a>
		</ul>
	</div>
	<div>
		<label for="saying">선택한 명언</label><br>
		<span>${saying.saying}</span>
	</div>
	<br><br>
	<div class="regist">
	<form name="frm" method="post" id="frm" 
		action="${pageContext.request.contextPath}/reviewInsert.do">
		 <input type="hidden" id="saying_number" name="num" value="${saying.saying_number}">
		 <input type="hidden" id="person" name="person" value="${saying.person}">
		 <input type="hidden" id="saying" name="saying" value="${saying.saying}">
		<div>
			<label for="review">나의 감상</label><br>
			<textarea name="review" id="review"></textarea>
		</div>
		<div>
			<button type="reset">초기화</button>
			<button>등록</button>
		</div>
		
	</form>
	</div>
</body>
</html>