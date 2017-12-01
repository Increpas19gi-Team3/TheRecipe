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

		location.href = 'ReviewList.do?sortColumn=' + sortColumn + '&orderby='
				+ orderby + '&whereColumn=' + whereColumn + '&word=' + word
				+ '&pageCutCount=' + pageCutCount;
	}

	function change_pageCutCount() {

		var pageCutCount = document.getElementById("pageCutCount").value;
		var sortColumn = '${sortColumn}';
		var orderby = '${orderby }';
		var whereColumn = '${whereColumn }';
		var word = '${word }';		

		location.href = 'ReviewList.do?sortColumn=' + sortColumn + '&orderby='
				+ orderby + '&whereColumn=' + whereColumn + '&word=' + word
				+ '&pageCutCount=' + pageCutCount;
	}
</script>

<jsp:include page="adminheader.jsp" />

<c:if test="${empty pageCutCount }">
	<c:set var="pageCutCount" value="5" />
</c:if>
<%-- <c:if test="${empty GUBUN }">
	<c:set var="GUBUN" value="ALL" />
</c:if> --%>

<div class="container boardNotice board">
	<div class="row">
		<div class="left_tab">
			<h2>고객센터</h2>
			<ul>
				<li><a
					href="http://localhost:8282/therecipe/test_171129/boardNotice.jsp">공지사항</a></li>
				<li class="active"><a
					href="http://localhost:8282/therecipe/test_171129/boardReview.jsp">후기
						게시판</a></li>
				<li><a
					href="http://localhost:8282/therecipe/test_171129/boardRecommend.jsp">추천
						레시피</a></li>
				<li><a
					href="http://localhost:8282/therecipe/test_171129/boardEvent.jsp">이벤트</a></li>
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
			<h3>
				후기 게시판
				<div class="page_locationBox">
					<a href="http://localhost:8282/therecipe/test_171129/home.jsp">홈</a>
					<span> > </span> 
					<a href="join.html">커뮤니티</a> 
					<span> > </span> 
					<a href="join.html" class="active">후기 게시판</a>
				</div>
			</h3>

			<form action="ReviewList.do" method="post" name="listForm">
				<input type="hidden" name="sortColumn" value="${sortColumn }">
				<input type="hidden" name="orderby" value="${orderby }"> 
				<%-- <input type="hidden" name="GUBUN" value="${GUBUN }"> --%> 
				<input type="hidden" name="pageCutCount" value="${pageCutCount }">

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
												<a href="ReviewList.do?sortColumn=r_title&orderby=DESC&whereColumn=${whereColumn }&word=${word }&pageCutCount=${pageCutCount }">제&nbsp;&nbsp;목 ▲</a>
											</c:when>
											<c:otherwise>
												<a href="ReviewList.do?sortColumn=r_title&orderby=ASC&whereColumn=${whereColumn }&word=${word }&pageCutCount=${pageCutCount }">제&nbsp;&nbsp;목 ▼</a>
											</c:otherwise>
										</c:choose>
									</c:when>

									<c:otherwise>										
										<a href="ReviewList.do?sortColumn=r_title&orderby=ASC&whereColumn=${whereColumn }&word=${word }&pageCutCount=${pageCutCount }">제&nbsp;&nbsp;목 ▼</a>
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
												<a href="ReviewList.do?sortColumn=r_rvdate&orderby=DESC&whereColumn=${whereColumn }&word=${word }&pageCutCount=${pageCutCount }">작성일 ▲</a>
											</c:when>
											<c:otherwise>
												<a href="ReviewList.do?sortColumn=r_rvdate&orderby=ASC&whereColumn=${whereColumn }&word=${word }&pageCutCount=${pageCutCount }">작성일 ▼</a>
											</c:otherwise>
										</c:choose>
									</c:when>
									<c:otherwise>										
										<a href="ReviewList.do?sortColumn=r_rvdate&orderby=ASC&whereColumn=${whereColumn }&word=${word }&pageCutCount=${pageCutCount }">작성일 ▼</a>
									</c:otherwise>
								</c:choose>
							</th>
						</tr>
					</thead>

					<tbody>
						<tr>
							<c:forEach var="list" items="${ReviewList.listVO }">
								<tr>
									<td>${list.m_userid }</td>
									<td><a href="ReviewDetailView.do?r_rvcode=${list.r_rvcode}">${list.r_title}</a>
									</td>
									<td>${list.r_grade }</td>
									<td>${list.r_rvcount }</td>									
									<td>
										<fmt:formatDate value="${list.r_rvdate}" pattern="yyyy-MM-dd HH:mm:ss" />
									</td>
									<td>
										${list.r_admincmt }
									</td>
									<td>
										<fmt:formatDate value="${list.r_admindate }" pattern="yyyy-MM-dd HH:mm:ss" />
									</td>
								</tr>
							</c:forEach>
						</tr>
					</tbody>
				</table>

				<!-- 양 끝에 글등록 링크 위치 -->
				<table style="border: none;">
					<tr style="border: none;">
						<td style="text-align: left; border: none;">
							<input type="button" value="글 쓰기" onclick="location.href='#'" />
						</td>
					</tr>
				</table>

				<p /><p /><p />

				<!-- 페이징 처리 -->
				<c:if test="${beginPage > 10 }">
					<div style="display: inline; color: black;">
						<a href='<c:url value="ReviewList.do?sortColumn=${sortColumn }&orderby=${orderby }&whereColumn=${whereColumn }&word=${word }&pageCutCount=${pageCutCount }&pn=${beginPage-1}"/>'>◀ 이전 </a>&nbsp;
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
								<a href='<c:url value="ReviewList.do?sortColumn=${sortColumn }&orderby=${orderby }&whereColumn=${whereColumn }&word=${word }&pageCutCount=${pageCutCount }&pn=${pno}" />'>${pno}</a>&nbsp;
							</div>
						</c:otherwise>
					</c:choose>
				</c:forEach>

				<c:if test="${endPage < listModel.totalPageCount}">
					<div style="display: inline; color: black;">
						&nbsp; <a href='<c:url value="ReviewList.do?sortColumn=${sortColumn }&orderby=${orderby }&whereColumn=${whereColumn }&word=${word }&pageCutCount=${pageCutCount }&pn=${endPage + 1}"/>'>다음 ▶ </a>
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

				<div class="pagination_wrap">
					<ul class="pagination">
						<li><a href="#"> <span>&laquo;</span></a></li>
						<li><a href="#" class="active">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#"> <span>&raquo;</span>
						</a></li>
					</ul>
					<div class="btn_right">
						<a href="boardReview_write.html">글쓰기</a>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
</body>