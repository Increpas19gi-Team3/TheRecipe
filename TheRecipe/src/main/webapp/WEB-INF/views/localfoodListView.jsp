<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="localTitleList.do" method="post">
		<br> 
		<input type="button" name="all" value="전체" onclick="location.href='localKindList.do?local=0'"> 
		<input type="button" name="korea" value="한식" onclick="location.href='localKindList.do?local=1'"> 
		<input type="button" name="china" value="중식" onclick="location.href='localKindList.do?local=2'"> 
		<input type="button" name="japan" value="일식" onclick="location.href='localKindList.do?local=3'"> 
		<input type="button" name="west" value="양식" onclick="location.href='localKindList.do?local=4'">
		 
		<input	type="text" name="foodname"> <input type="submit" value="검색">

		<br>
		<br>
		<br>

		<c:forEach var="food" items="${foodList }">
			<table border="1">
				<tr>
					<th colspan="2">
						<a href="foodDetailView.do?fcode=${food.f_fdcode }"><img src="/images/${food.f_imgname}" width="200" height="200"></a>
					</th>
				</tr>
				<tr>
					<%-- 	
				<td>${food.f_fdcode }</td>
				<td>${food.e_evtcode }</td>
				<td>${food.fc_1st }</td>
				<td>${food.fc_2nd }</td>
				<td>${food.fc_3rd }</td>
				<td>${food.f_explan }</td>
				<td>${food.f_imgname }</td>
				--%>
					<td><a href="foodDetailView.do?fcode=${food.f_fdcode }">${food.f_foodname }</a></td>
					<td><a href="foodDetailView.do?fcode=${food.f_fdcode }">${food.f_price }</a></td>
				</tr>

			</table>
		</c:forEach>
	</form>
</body>
</html>