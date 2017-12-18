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
		var GUBUN = document.getElementById('GUBUN').value;
		var sortColumn = '${sortColumn}';
		var orderby = '${orderby }';
		var whereColumn = '${whereColumn }';
		var word = '${word }';
		var pageCutCount = '${pageCutCount }';

		location.href = 'userEventList.do?sortColumn=' + sortColumn + '&orderby='
				+ orderby + '&whereColumn=' + whereColumn + '&word=' + word
				+ '&GUBUN=' + GUBUN + '&pageCutCount=' + pageCutCount;
	}

	function change_pageCutCount() {

		var pageCutCount = document.getElementById("pageCutCount").value;
		var sortColumn = '${sortColumn}';
		var orderby = '${orderby }';
		var whereColumn = '${whereColumn }';
		var word = '${word }';
		var GUBUN = '${GUBUN }';

		location.href = 'userEventList.do?sortColumn=' + sortColumn + '&orderby='
				+ orderby + '&whereColumn=' + whereColumn + '&word=' + word
				+ '&GUBUN=' + GUBUN + '&pageCutCount=' + pageCutCount;
	}
</script>

<jsp:include page="header.jsp" /> 

<c:if test="${empty pageCutCount }">
	<c:set var="pageCutCount" value="5" />
</c:if>
<c:if test="${empty GUBUN }">
	<c:set var="GUBUN" value="ALL" />
</c:if>

<div class="container boardNotice board">
	<div class="row">
		<div class="left_tab">
			<h2>고객센터</h2>
			<ul>
				<li>
					<a href="userNoticeList.do">공지사항</a></li>
				<li>
					<a href="userReviewList.do">후기 게시판</a></li>
				<!-- <li>
					<a href="http://localhost:8282/therecipe/test_171129/boardRecommend.jsp">추천 레시피</a></li> -->
				<li class="active">
					<a href="userEventList.do">이벤트</a>
				</li>
			</ul>
			
			<div class="service_info">
				<h4>배민찬 고객센터</h4>
				<h3>1899-2468</h3>
				<hr>
				<p>평일 06:30 ~ 18:00</p>
				<p>주말 06:30 ~ 15:00</p>
				<p>공휴일 휴무</p>
			</div>
			
		</div>
		
		<div class="right_contnet">
			<h3> 이벤트			
				<div class="page_locationBox">
					<a href="home.do">홈</a>
					<span> > </span> 
					<a href="userNoticeList.do">커뮤니티</a>
					<span> > </span> 
					<a href="userEventList.do" class="active">이벤트</a>
				</div>
			</h3>

			<form action="userNoticeList.do" method="post" name="listForm">
				<div class="j_table">
					<div class="top">
						<input type="hidden" name="sortColumn" value="${sortColumn }">
						<input type="hidden" name="orderby" value="${orderby }"> 
						<input type="hidden" name="GUBUN" value="${GUBUN }"> 
						<input type="hidden" name="pageCutCount" value="${pageCutCount }">
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
					<table>
						<thead>
							<tr>
								<th>이벤트 코드</th>
								<th>
									<c:choose>
										<c:when test="${sortColumn eq 'e_nttilte'}">
											<!-- 제목 정렬일때 -->
											<c:choose>
												<c:when test="${orderby eq 'ASC' }">
													<a href="userEventList.do?sortColumn=e_nttilte&orderby=DESC&whereColumn=${whereColumn }&word=${word }&GUBUN=${GUBUN }&pageCutCount=${pageCutCount }">제목 ▲</a>
												</c:when>
												<c:otherwise>
													<a href="userEventList.do?sortColumn=e_nttilte&orderby=ASC&whereColumn=${whereColumn }&word=${word }&GUBUN=${GUBUN }&pageCutCount=${pageCutCount }">제목 ▼</a>
												</c:otherwise>
											</c:choose>
										</c:when>
	
										<c:otherwise>
											<!-- 제목 정렬이 아닐 때 -->
											<a href="userEventList.do?sortColumn=e_nttilte&orderby=ASC&whereColumn=${whereColumn }&word=${word }&GUBUN=${GUBUN }&pageCutCount=${pageCutCount }">제목 ▼</a>
										</c:otherwise>
									</c:choose>
								</th>
								<th>								 
									<c:choose>
										<c:when test="${sortColumn eq 'e_ntdate'}">										
											<c:choose>
												<c:when test="${orderby eq 'ASC' }">
													<a href="userEventList.do?sortColumn=e_ntdate&orderby=DESC&whereColumn=${whereColumn }&word=${word }&GUBUN=${GUBUN }&pageCutCount=${pageCutCount }">작성일 ▲</a>
												</c:when>
												<c:otherwise>
													<a href="userEventList.do?sortColumn=e_ntdate&orderby=ASC&whereColumn=${whereColumn }&word=${word }&GUBUN=${GUBUN }&pageCutCount=${pageCutCount }">작성일 ▼</a>
												</c:otherwise>
											</c:choose>
										</c:when>
										
										<c:otherwise>
											<a href="userEventList.do?sortColumn=e_ntdate&orderby=ASC&whereColumn=${whereColumn }&word=${word }&GUBUN=${GUBUN }&pageCutCount=${pageCutCount }">작성일 ▼</a>
										</c:otherwise>
									</c:choose>
								</th>
								<th>할인율</th>
								<th>시작날짜</th>
								<th>종료날짜</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="list" items="${eventList.listVO }">
								<tr>
									<td>${list.e_evtcode }</td>
									<td><a href="userEventDetailView.do?e_evtcode=${list.e_evtcode}">${list.e_nttilte }</a></td>
									<td><fmt:formatDate value="${list.e_ntdate }" pattern="yyyy-MM-dd" /></td>								
									<td>${list.e_discount_value }</td>
									<td><fmt:formatDate value="${list.e_startdate }" pattern="yyyy-MM-dd" /></td>
									<td><fmt:formatDate value="${list.e_enddate }" pattern="yyyy-MM-dd" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
					<div class="pagination_wrap">
						<ul class="pagination">
							<c:if test="${beginPage > 10 }">
								<li><a href='<c:url value="userEventList.do?sortColumn=${sortColumn }&orderby=${orderby }&whereColumn=${whereColumn }&word=${word }&GUBUN=${GUBUN }&pageCutCount=${pageCutCount }&pn=${beginPage-1}"/>'><span>&laquo;</span></a>&nbsp;
							</c:if>
							<c:forEach var="pno" begin="${beginPage}" end="${endPage}">
								<c:choose>
									<c:when test="${pno == pn}">
										<li><a href="#" class="active">${pno}</a></li>
									</c:when>
									<c:otherwise>
										<li><a href='<c:url value="userEventList.do?sortColumn=${sortColumn }&orderby=${orderby }&whereColumn=${whereColumn }&word=${word }&GUBUN=${GUBUN }&pageCutCount=${pageCutCount }&pn=${pno}" />'>${pno}</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<c:if test="${endPage < listModel.totalPageCount}">
								<li><a href='<c:url value="userEventList.do?sortColumn=${sortColumn }&orderby=${orderby }&whereColumn=${whereColumn }&word=${word }&GUBUN=${GUBUN }&pageCutCount=${pageCutCount }&pn=${endPage + 1}"/>'><span>&raquo;</span></a>
							</c:if>
						</ul>
						<!-- <div class="btn_right">
							<a href="boardReviewWrite.html">글쓰기</a>
						</div> -->
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

<jsp:include page="footer.jsp" /> 

