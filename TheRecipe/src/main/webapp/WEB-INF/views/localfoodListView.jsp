<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<jsp:include page="header.jsp" />

<c:if test="${empty pageSize}">
	<c:set var="pageSize" value="5" />
</c:if>

<c:set var="medium" />
<c:set var="small" />
<form action="localTitleList.do" method="post">
	<div class="container home">
		<div class="con_inner">
			<div class="page_locationBox2">
				<a href="userIndex.do">홈</a>
				<span> &gt; </span>
				<a href="totalFoodList.do?level=1&large=${large }">분류</a>
				<c:if test="${level!=1 }">
					<span> &gt; </span>
						<c:forEach var="code" items="${ctgoryvo}" varStatus="status">
							<c:if test="${status.index == 0 }">
								<a href="totalFoodList.do?level=2&large=${code.fc_1st}&medium=${code.fc_2nd}" class="active">${code.fc_ctgname}</a>
								<c:set var="medium" value="${code.fc_2nd}" />
							</c:if>
						</c:forEach>
					<c:if test="${level!=2 }">
						<span> &gt; </span>
						<c:forEach var="foodcd" items="${itemvo}" varStatus="status">
							<c:if test="${status.index == 0 }">
								<input type="hidden" name="third" value="${foodcd.fc_3rd}">
								<a href="#" class="active">${foodcd.fc_ctgname}</a>
								<c:set var="small" value="${foodcd.fc_3rd}"/>
							</c:if>
						</c:forEach>
					</c:if>
				</c:if>
				<div class="search_box">
					
						<input type="text" name="foodname" required="">
						<button type="submit"></button>
					
				</div>
			</div>
			<c:choose>
				<c:when test="${level == 1}">
					<div class="con_tabBox">
						<!-- <a href="localFoodList.do" class="active">전체보기</a> -->
						<c:forEach var="foodcd" items="${foodcode}" varStatus="status">
							<c:choose>
								<c:when test="${status.count == 1 }">
									<input type="hidden" name="first" value="${foodcd.fc_1st}">
									<input type="hidden" name="second" value="0">
									<input type="hidden" name="third" value="0">
									<a href="totalFoodList.do?level=2&large=${foodcd.fc_1st}&medium=${foodcd.fc_2nd}">${foodcd.fc_ctgname}</a>
								</c:when>
								<c:otherwise>
									<a href="totalFoodList.do?level=2&large=${foodcd.fc_1st}&medium=${foodcd.fc_2nd}">${foodcd.fc_ctgname}</a>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</div>
				</c:when>
				<c:when test="${level == 2}">
					<div class="con_tabBox">
						
						<c:forEach var="foodcd" items="${foodcode}" varStatus="status">
							<c:choose>
								<c:when test="${status.index == 0 }">
									<input type="hidden" name="first" value="${foodcd.fc_1st}">
									<input type="hidden" name="second" value="${foodcd.fc_2nd}">
									<input type="hidden" name="third" value="0">
									<a href="totalFoodList.do?level=1&large=${foodcd.fc_1st}">전체보기</a>								
									<a href="totalFoodList.do?level=3&large=${foodcd.fc_1st}&medium=${foodcd.fc_2nd}&small=${foodcd.fc_3rd}">${foodcd.fc_ctgname}</a>
								</c:when>
								<c:otherwise>
									<a href="totalFoodList.do?level=3&large=${foodcd.fc_1st}&medium=${foodcd.fc_2nd}&small=${foodcd.fc_3rd}">${foodcd.fc_ctgname}</a>
								</c:otherwise>
							</c:choose>	
						</c:forEach>
					</div>
				</c:when>
				<c:when test="${level == 3}">
				<div class="con_tabBox">
					<c:forEach var="foodcd" items="${foodcode}" varStatus="status">
						<c:choose>
							<c:when test="${status.index == 0 }">
								<input type="hidden" name="first" value="${foodcd.fc_1st}">
								<input type="hidden" name="second" value="${foodcd.fc_2nd}">		
								<a href="totalFoodList.do?level=2&large=${foodcd.fc_1st}&medium=${foodcd.fc_2nd}">전체보기</a>
								<a href="totalFoodList.do?level=3&large=${foodcd.fc_1st}&medium=${foodcd.fc_2nd}&small=${foodcd.fc_3rd}">${foodcd.fc_ctgname}</a>
							</c:when>
							<c:otherwise>
								<a href="totalFoodList.do?level=3&large=${foodcd.fc_1st}&medium=${foodcd.fc_2nd}&small=${foodcd.fc_3rd}">${foodcd.fc_ctgname}</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</div>
			</c:when>
			</c:choose>
			<div class="con_card4 con_card_list con_card">
			<ul>
				<c:forEach var="food" items="${foodList }">
					<li>
						<a href="foodDetailView.do?large=${food.fc_1st }&fcode=${food.f_fdcode }">
							<c:choose>
								<c:when test="${not empty food.f_imgname}">
									<img src="/images/${food.f_imgname}" >
								</c:when>
								<c:otherwise>
									<img src="/therecipe/resources/images/noimg.JPG" >
								</c:otherwise>
							</c:choose>
							<div class="desc">
								<h3>${food.f_foodname }</h3>
								<c:choose>
									<c:when test="${not empty food.e_evtcode}">	
										<span><b>${food.f_price }</b>${food.f_price }<small>원</small></span>
									</c:when>
									<c:otherwise>
										<span>${food.f_price }<small>원</small></span>
									</c:otherwise>
								</c:choose>
							</div>
						</a>
					</li>
				</c:forEach>
			</ul>
		</div>

		<c:forEach var="page" begin="${beginPage}" end="${endPage}">
			<c:choose>
				<c:when test="${page == currPage}">
					${page}
				</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${level == 1}">
							<a href='<c:url value="totalFoodList.do?level=1&currPage=${page }&pageSize=5&large=${large }" />'>${page}</a>
						</c:when>
						<c:when test="${level == 2}">
							<a href='<c:url value="totalFoodList.do?level=2&currPage=${page }&pageSize=5&large=${large}&medium=${medium}" />'>${page}</a>
						</c:when>
						<c:when test="${level == 3}">
							<a href='<c:url value="totalFoodList.do?level=3&currPage=${page }&pageSize=5&large=${large}&medium=${medium}&small=${small}" />'>${page}</a>
						</c:when>
					</c:choose>
				</c:otherwise>
			</c:choose>
		</c:forEach>	

		</div>
	</div>
	
</form>
	<jsp:include page="footer.jsp" />
