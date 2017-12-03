<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
</head>
<body>

	<form action="" method="post">

		<section>
			<div id="#" align="center">
				<h1>공지사항 상세보기</h1>
				<br>
				<table class="#">
					<tr>
						<th>이벤트 코드</th>
						<td>${nVo.e_evtcode}</td>
					</tr>

					<tr>
						<th>제&nbsp;&nbsp;목</th>
						<td>${nVo.e_nttilte}</td>
					</tr>

					<tr>
						<th>구&nbsp;&nbsp;분</th>
						<td>${nVo.e_gubun}</td>
					</tr>

					<tr>
						<th>작성날짜</th>
						<td><fmt:formatDate value="${nVo.e_ntdate}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
					</tr>

					<tr>
						<th>내&nbsp;&nbsp;용</th>
						<td>${nVo.e_ntcontens}</td>
					</tr>
					

					<tr>
						<th>이미지</th>
						<td><img src="/images/${eVo.e_ntimgname}" width="400" height="400"></td>						
					</tr>
					

					<tr>
						<th>할인율</th>
						<td>${nVo.e_discount}</td>
					</tr>

					<tr>
						<th>시작날짜</th>
						<td><fmt:formatDate value="${nVo.e_startdate}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
					</tr>

					<tr>
						<th>종료날짜</th>
						<td><fmt:formatDate value="${nVo.e_enddate}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
					</tr>

					<tr>
						<th>마스터 코드</th>
						<td>${nVo.ms_code}</td>
					</tr>
				</table>
			</div>
		</section>
		<hr>		
	</form>

	<footer></footer>