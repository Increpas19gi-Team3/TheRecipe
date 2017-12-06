<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
    
<jsp:include page="adminheader.jsp" />

	<div class="content-wrapper boardNotice board">		
				<h3>
					공지사항
					<div class="page_locationBox">
						<a href="http://localhost:8282/therecipe/test_171129/home.jsp">홈</a>
						<span> > </span>
						<a href="join.html">커뮤니티</a>
						<span> > </span>
						<a href="join.html" class="active">공지사항</a>
					</div>
				</h3>
				
				<table>
					<thead>
						<tr>
							<th>후기코드</th>
							<th>아이디</th>
							<th>상품코드</th>
							<th>제&nbsp;&nbsp;목</th>							
						</tr>
					</thead>
					
					<tbody>					
					<tr>
						<td>${rVo.r_rvcode}</td>
						<td>${rVo.m_userid}</td>
						<td>${rVo.f_fdcode}</td>
						<td>${rVo.r_title}</td>						
					</tr>
					
					<tr>
						<th>후&nbsp;&nbsp;기</th>						
						<th>평점</th>
						<th>조회수</th>
						<th>글등록 시간</th>
					</tr>
					
					<tr>
						<td>${rVo.r_rvcontents}</td>
						<td>${rVo.r_grade}</td>
						<td>${rVo.r_rvcount}</td>
						<td>${rVo.r_rvdate}</td>
					</tr>
					
					<tr>
						<th colspan="4">이미지</th>
					</tr>
					
					<tr>
						<td colspan="4">
						${rVo.r_rvimgname}
						<img src="/images/${rVo.r_rvimgname}" width="400" height="400">
						</td>
					</tr>
					
					<c:if test="${not empty rVo.r_admincmt}">
					<tr>
						<th>관리자 댓글</th>
						<th>답변 작성시간</th>
					</tr>			
					
					<tr>
						<td>${rVo.r_admincmt}</td>
						<td>${rVo.r_admindate}</td>						
					</tr>
					</c:if>					
												
					</tbody>
				</table>
				
				<div class="pagination_wrap">
					<div class="btn_right">
						<input type="button" value="답글 달기" onclick="location.href='adminReviewRegUpdate.do?r_rvcode=${rVo.r_rvcode}'">
						<input type="button" value="답글 삭제" onclick="location.href='adminReviewDelete.do?r_rvcode=${rVo.r_rvcode}'">
					</div>
				</div>
			</div>
		


