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

		location.href = 'EventList.do?sortColumn=' + sortColumn + '&orderby='
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

		location.href = 'EventList.do?sortColumn=' + sortColumn + '&orderby='
				+ orderby + '&whereColumn=' + whereColumn + '&word=' + word
				+ '&GUBUN=' + GUBUN + '&pageCutCount=' + pageCutCount;
	}
</script>

<jsp:include page="adminheader.jsp" />

<c:if test="${empty pageCutCount }">
	<c:set var="pageCutCount" value="5" />
</c:if>
<c:if test="${empty GUBUN }">
	<c:set var="GUBUN" value="ALL" />
</c:if>

<div class="content-wrapper">

	<form action="NoticeList.do" method="post" name="listForm">

		<input type="hidden" name="sortColumn" value="${sortColumn }">
		<input type="hidden" name="orderby" value="${orderby }"> <input
			type="hidden" name="GUBUN" value="${GUBUN }"> <input
			type="hidden" name="pageCutCount" value="${pageCutCount }">

		<div class="container-fluid">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="index.html">The Recipe</a></li>
				<li class="breadcrumb-item active">이벤트 리스트(일반인, 관리자 겸용)</li>
			</ol>
			<div class="card mb-3">
				<div class="card-header"><i class="fa fa-table"></i>이벤트 리스트</div>
				<div class="card-body">
					<div class="table-responsive">

						<!-- 페이지 갯수 제한 -->
						<table id="listGubun" style="border: none;">
							<tr style="border: none;">
								<td style="text-align: right; border: none;">
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
								</td>
							</tr>
						</table>

						<!-- 테이블명 -->
						<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
							<thead>
								<tr>
									<th>이벤트 코드</th>
									<th>
										<c:choose>
											<c:when test="${sortColumn eq 'e_nttilte'}">
												<!-- 제목 정렬일때 -->
												<c:choose>
													<c:when test="${orderby eq 'ASC' }">
														<a href="EventList.do?sortColumn=e_nttilte&orderby=DESC&whereColumn=${whereColumn }&word=${word }&GUBUN=${GUBUN }&pageCutCount=${pageCutCount }">제&nbsp;&nbsp;목 ▲</a>
													</c:when>
													<c:otherwise>
														<a href="EventList.do?sortColumn=e_nttilte&orderby=ASC&whereColumn=${whereColumn }&word=${word }&GUBUN=${GUBUN }&pageCutCount=${pageCutCount }">제&nbsp;&nbsp;목 ▼</a>
													</c:otherwise>
												</c:choose>
											</c:when>

											<c:otherwise>
												<!-- 제목 정렬이 아닐 때 -->
												<a href="EventList.do?sortColumn=e_nttilte&orderby=ASC&whereColumn=${whereColumn }&word=${word }&GUBUN=${GUBUN }&pageCutCount=${pageCutCount }">제&nbsp;&nbsp;목 ▼</a>
											</c:otherwise>
										</c:choose>
									</th>

									<!-- <th>구분</th> -->

									<th>
									<!-- 작성일 -->
										<c:choose>
											<c:when test="${sortColumn eq 'e_ntdate'}">
												<!-- 작성일 일때 -->
												<c:choose>
													<c:when test="${orderby eq 'ASC' }">
														<a href="EventList.do?sortColumn=e_ntdate&orderby=DESC&whereColumn=${whereColumn }&word=${word }&GUBUN=${GUBUN }&pageCutCount=${pageCutCount }">작성일 ▲</a>
													</c:when>
													<c:otherwise>
														<a href="EventList.do?sortColumn=e_ntdate&orderby=ASC&whereColumn=${whereColumn }&word=${word }&GUBUN=${GUBUN }&pageCutCount=${pageCutCount }">작성일 ▼</a>
													</c:otherwise>
												</c:choose>
											</c:when>
											<c:otherwise>
												<!-- 작성일 정렬이 아닐 때 -->
												<a href="EventList.do?sortColumn=e_ntdate&orderby=ASC&whereColumn=${whereColumn }&word=${word }&GUBUN=${GUBUN }&pageCutCount=${pageCutCount }">작성일 ▼</a>
											</c:otherwise>
										</c:choose>
									</th>
									<!-- <th>내&nbsp;&nbsp;용</th> -->
									<!-- <th>이미지</th> -->
									<th>할인율</th>
									<th>시작날짜</th>
									<th>종료날짜</th>
									
								</tr>
							</thead>

							<tbody>
								<c:forEach var="list" items="${eventList.listVO }">
									<tr>
										<td>${list.e_evtcode }</td>
										<td><a href="EventDetailView.do?e_evtcode=${list.e_evtcode}">${list.e_nttilte }</a></td>
										<%-- <td>${list.e_gubun }</td> --%>
										<td>
											<fmt:formatDate value="${list.e_ntdate }" pattern="yyyy-MM-dd HH:mm:ss" />
										</td>
										<%-- <td>${list.e_ntcontens }</td> --%>
										<%-- <td>${list.e_ntimgname }</td> --%>
										<td>${list.e_discount }</td>
										<td>
											<fmt:formatDate value="${list.e_startdate }" pattern="yyyy-MM-dd HH:mm:ss" />
										</td>
										<td>
											<fmt:formatDate value="${list.e_enddate }" pattern="yyyy-MM-dd HH:mm:ss" />
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

						
						
						
						
						<!-- 글등록 링크 위치 -->
						<table style="border: none;">
						<%-- <c:choose>
							<c:when test="${ sessionScope.m_level eq '1' }">
							<tr style="border: none;"> --%>
								<td style="text-align: left; border: none;">
									<input type="button" value="이벤트 등록" onclick="location.href='EventReg.do'" />
								</td>				
							</tr>
							<%-- </c:when>
							<c:otherwise>
								<tr>
									<td>넌 관리자가 아니야</td>
								</tr>
							</c:otherwise>
						</c:choose> --%>
						</table>
						
						
						
						
						
						
						<p /><p /><p />

						<!-- 페이징 처리 -->
						<c:if test="${beginPage > 10 }">
							<div style="display: inline; color: black;">
								<a href='<c:url value="EventList.do?sortColumn=${sortColumn }&orderby=${orderby }&whereColumn=${whereColumn }&word=${word }&GUBUN=${GUBUN }&pageCutCount=${pageCutCount }&pn=${beginPage-1}"/>'>◀ 이전 </a>&nbsp;
							</div>
						</c:if>

						<c:forEach var="pno" begin="${beginPage}" end="${endPage}">
							<c:choose>
								<c:when test="${pno == pn}">
									<div style="display: inline; color: red;">
										<strong>${pno}</strong>
									</div>&nbsp;
								</c:when>
								<c:otherwise>
									<div style="display: inline; color: black;">
										<a href='<c:url value="EventList.do?sortColumn=${sortColumn }&orderby=${orderby }&whereColumn=${whereColumn }&word=${word }&GUBUN=${GUBUN }&pageCutCount=${pageCutCount }&pn=${pno}" />'>${pno}</a>&nbsp;
									</div>
								</c:otherwise>
							</c:choose>
						</c:forEach>

						<c:if test="${endPage < listModel.totalPageCount}">
							<div style="display: inline; color: black;">&nbsp; 
								<a href='<c:url value="EventList.do?sortColumn=${sortColumn }&orderby=${orderby }&whereColumn=${whereColumn }&word=${word }&GUBUN=${GUBUN }&pageCutCount=${pageCutCount }&pn=${endPage + 1}"/>'>다음 ▶ </a>
							</div>
						</c:if>

						<p /><p />

						<!-- 검색 처리 -->
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
				<div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
			</div>
		</div>
	</form>
</div>
</body>

</html>