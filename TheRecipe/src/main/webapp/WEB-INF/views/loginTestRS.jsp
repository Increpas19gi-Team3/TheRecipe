<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	resources 폴더 내의 이미지 호출 : <img alt="이미지" src='<c:url value="/resources/img/notice.png" />'> <br/>
	
	c:images 이미지 호출: <img alt="이미지3" src="/images/notice.png"> <br/>
	
	
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>패스워드</th>
			<th>이름</th>
			<th>이메일</th>
			<th>우편번호</th>
			<th>주소</th>
			<th>전화번호</th>
			<th>등급</th>
		</tr>
	<c:forEach var="member" items="${memberList }">
	
		<tr>
			<td>${member.m_userid }</td>
			<td>${member.m_pw }</td>
			<td>${member.m_name }</td>
			<td>${member.m_email }</td>
			<td>${member.m_post }</td>
			<td>${member.m_addr }</td>
			<td>${member.m_phone }</td>
			<td>${member.m_level }</td>
		</tr>		
	</c:forEach>
	</table>
	
</body>
</html>