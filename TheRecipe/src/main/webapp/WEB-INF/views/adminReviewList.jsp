<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%
	//브라우저 캐싱 X 
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.addHeader("Cache-Control", "no-store");
	response.setDateHeader("Expires", 1L);
%>

<script type="text/javascript">
	function change_whereColumn() {
		document.listForm.word.value = "";
	}

	function change_GUBUN() {

		var sortColumn = '${sortColumn}';
		var orderby = '${orderby }';
		var whereColumn = '${whereColumn }';
		var word = '${word }';
		var pageCutCount = '${pageCutCount }';

		location.href = 'adminReviewList.do?sortColumn=' + sortColumn
				+ '&orderby=' + orderby + '&whereColumn=' + whereColumn
				+ '&word=' + word + '&pageCutCount=' + pageCutCount;
	}

	function change_pageCutCount() {

		var pageCutCount = document.getElementById("pageCutCount").value;
		var sortColumn = '${sortColumn}';
		var orderby = '${orderby }';
		var whereColumn = '${whereColumn }';
		var word = '${word }';

		location.href = 'adminReviewList.do?sortColumn=' + sortColumn
				+ '&orderby=' + orderby + '&whereColumn=' + whereColumn
				+ '&word=' + word + '&pageCutCount=' + pageCutCount;
	}
</script>

<jsp:include page="adminheader.jsp" />

<c:if test="${empty pageCutCount }">
	<c:set var="pageCutCount" value="5" />
</c:if>

<form action="adminReviewList.do" method="post" name="listForm">

	<div class="content-wrapper">
		<div class="j_table">
		<div class="top">
			<!-- 페이지 갯수 제한 -->
			<div class="pageLimitWrap">
				<select name="pageCutCount" id="pageCutCount" onchange="change_pageCutCount();">
					<c:choose>
						<c:when test="${pageCutCount eq '5' }">
							<option value="5" selected="selected">5개 보기</option>
						</c:when>
						<c:otherwise>
							<option value="5">5개 보기</option>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${pageCutCount eq '10' }">
							<option value="10" selected="selected">10개 보기</option>
						</c:when>
						<c:otherwise>
							<option value="10">10개 보기</option>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${pageCutCount eq '20' }">
							<option value="20" selected="selected">20개 보기</option>
						</c:when>
						<c:otherwise>
							<option value="20">20개 보기</option>
						</c:otherwise>
					</c:choose>
				</select>
			</div>

			<!-- 검색 처리 -->
			<div class="searchWrap">
				<select name="whereColumn" onchange="change_whereColumn()">
					<c:choose>
						<c:when test="${not empty whereColumn }">
							<c:choose>
								<c:when test="${whereColumn eq 'ALL'}">
									<option value="ALL" selected="selected">제목:내용</option>
									<option value="TITLE">제목</option>
								</c:when>
								<c:when test="${whereColumn eq 'TITLE'}">
									<option value="ALL">제목:내용</option>
									<option value="TITLE" selected="selected">제목</option>
								</c:when>
							</c:choose>
						</c:when>
						<c:otherwise>
							<option value="ALL">전체검색</option>
							<option value="TITLE">제목</option>
						</c:otherwise>
					</c:choose>
				</select> 
				<input type="text" name="word" value="${word }"> 
				<input type="submit" value="검색">
			</div>
		</div>

		<div class="table_defalt">
			<table>
				<thead>
					<tr>
						<th>아이디</th>
						<th>
							<c:choose>
								<c:when test="${sortColumn eq 'r_title'}">
									<!-- 제목 정렬일때 -->
									<c:choose>
										<c:when test="${orderby eq 'ASC' }">
											<a href="adminReviewList.do?sortColumn=r_title&orderby=DESC&whereColumn=${whereColumn }&word=${word }&pageCutCount=${pageCutCount }">제&nbsp;&nbsp;목 ▲</a>
										</c:when>
										<c:otherwise>
											<a href="adminReviewList.do?sortColumn=r_title&orderby=ASC&whereColumn=${whereColumn }&word=${word }&pageCutCount=${pageCutCount }">제&nbsp;&nbsp;목 ▼</a>
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:otherwise>
									<a href="adminReviewList.do?sortColumn=r_title&orderby=ASC&whereColumn=${whereColumn }&word=${word }&pageCutCount=${pageCutCount }">제&nbsp;&nbsp;목 ▼</a>
								</c:otherwise>
							</c:choose>
						</th>
						<th>평&nbsp;&nbsp;점</th>
						<th>조회수</th>
						<th>
							<c:choose>
								<c:when test="${sortColumn eq 'r_rvdate'}">
									<!-- 작성일 일때 -->
									<c:choose>
										<c:when test="${orderby eq 'ASC' }">
											<a href="adminReviewList.do?sortColumn=r_rvdate&orderby=DESC&whereColumn=${whereColumn }&word=${word }&pageCutCount=${pageCutCount }">작성일 ▲</a>
										</c:when>
										<c:otherwise>
											<a href="adminReviewList.do?sortColumn=r_rvdate&orderby=ASC&whereColumn=${whereColumn }&word=${word }&pageCutCount=${pageCutCount }">작성일 ▼</a>
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:otherwise>
									<a href="adminReviewList.do?sortColumn=r_rvdate&orderby=ASC&whereColumn=${whereColumn }&word=${word }&pageCutCount=${pageCutCount }">작성일 ▼</a>
								</c:otherwise>
							</c:choose>
						</th>
						<th>답변 내용</th>
						<th>답변 작성일</th>
					</tr>
				</thead>

				<tbody>
					<tr>
						<c:forEach var="list" items="${ReviewList.listVO }">
							<tr>
								<td>${list.m_userid }</td>
								<td>
									<a href="adminReviewDetailView.do?r_rvcode=${list.r_rvcode}">${list.r_title}</a>
								</td>
								<td>${list.r_grade }</td>
								<td>${list.r_rvcount }</td>
								<td>
									<fmt:formatDate value="${list.r_rvdate}" pattern="yyyy-MM-dd HH:mm:ss" />
								</td>
								<td>${list.r_admincmt }</td>
								<td>
									<fmt:formatDate value="${list.r_admindate }" pattern="yyyy-MM-dd HH:mm:ss" />
								</td>
							</tr>
						</c:forEach>
					</tr>
				</tbody>
			</table>

			<div class="pagination_wrap">
				<ul class="pagination">
					<c:if test="${beginPage > 10 }">
						<li><a href='<c:url value="adminReviewList.do?sortColumn=${sortColumn }&orderby=${orderby }&whereColumn=${whereColumn }&word=${word }&GUBUN=${GUBUN }&pageCutCount=${pageCutCount }&pn=${beginPage-1}"/>'><span>&laquo;</span></a>&nbsp;</li>
					</c:if>

					<c:forEach var="pno" begin="${beginPage}" end="${endPage}">
						<c:choose>
							<c:when test="${pno == pn}">
								<li><a href="#" class="active">${pno}</a></li>
							</c:when>
							<c:otherwise>
								<li><a href='<c:url value="adminReviewList.do?sortColumn=${sortColumn }&orderby=${orderby }&whereColumn=${whereColumn }&word=${word }&GUBUN=${GUBUN }&pageCutCount=${pageCutCount }&pn=${pno}" />'>${pno}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>

					<c:if test="${endPage < listModel.totalPageCount}">
						<li><a href='<c:url value="adminReviewList.do?sortColumn=${sortColumn }&orderby=${orderby }&whereColumn=${whereColumn }&word=${word }&GUBUN=${GUBUN }&pageCutCount=${pageCutCount }&pn=${endPage + 1}"/>'><span>&raquo;</span></a>
					</c:if>
				</ul>
				<!-- <div class="btn_right">
					<a href="adminReviewReg.do"> 등록</a>
				</div> -->
			</div>
		</div>	
	</div>
	</div>
</form>