<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<jsp:include page="header.jsp" />



	<div class="container home">
		<div class="con_inner">
			<div class="page_locationBox2">
				<a href="home.html">홈</a>
				<span> &gt; </span>
				<a href="localFoodList.do">분류</a>
				<c:if test="${level!=1 }">
					<span> &gt; </span>
					<a href="#" class="active">한식</a>
					<c:if test="${level!=2 }">
						<span> &gt; </span>
						<a href="#" class="active">한식</a>
					</c:if>
				</c:if>
				<div class="search_box">
					<form action="localTitleList.do" method="post">
						<input type="text" name="foodname" required="">
						<button type="submit"></button>
					</form>
				</div>
			</div>
			<div class="con_tabBox">
				<a href="localKindList.do?local=0" class="active">전체보기</a>
				<c:forEach var="foodcd" items="${foodcode}">
					<a href="localKindList.do?local=${foodcd.fc_2nd}">${foodcd.fc_ctgname}</a>
				</c:forEach>
			</div>
			<div class="con_card4 con_card_list con_card">
			<ul>
				<c:forEach var="food" items="${foodList }">
					<li>
						<a href="foodDetailView.do?fcode=${food.f_fdcode }">
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
		</div>
	</div>
	

	<jsp:include page="footer.jsp" />
