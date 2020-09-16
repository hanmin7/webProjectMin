<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sayingAll</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<style>
#sayings {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#sayings td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#sayings tr:nth-child(even){background-color: #f2f2f2;}

#sayings tr:hover {background-color: #ddd;}

#sayings th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: center;
  background-color: #FFB6C1;
  color: white;
}
</style>
<script>
	$(document).ready(function(){
		$("#cate").on("change", function(){
			$("#catefrm").submit();
		});
	});
</script>
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
				
				<th>saying</th>
				<th>person</th>
				<th>
					<form id="catefrm" action="${pageContext.request.contextPath}/sayingList.do">
						<select id="cate" name="cate" size="1">
								<option value="all">category전체</option>
									<c:forEach items="${clist}" var="catelist">
										<option value="${catelist}" <c:if test="${catelist==param.cate}">selected="selected"</c:if>>${catelist}</option>
									</c:forEach>
						</select>
					</form>
				</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${slist}" var="saylist">
			<tr>
				
				<td><a href="sayingSelectOne.do?num=${saylist.getSaying_number()}">${saylist.getSaying()}</a></td>
				<td>${saylist.getPerson()}</td>
				<td>${saylist.getCategory()}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>