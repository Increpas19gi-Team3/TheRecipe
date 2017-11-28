<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<jsp:include page="header.jsp" />



	<div class="container home">
		<div class="con_inner">
			<div class="page_locationBox2">
				<a href="home.html">홈</a>
				<span> &gt; </span>
				<a href="#">분류</a>
				<span> &gt; </span>
				<a href="#" class="active">한식</a>
				<div class="search_box">
					<form action="localTitleList.do" method="post">
						<input type="text" name="foodname" required="">
						<button type="submit"></button>
					</form>
				</div>
			</div>
			<div class="con_tabBox">
				<a href="" class="active">전체보기</a>
				<a href="">찌개</a>
				<a href="">고기</a>
				<a href="">해물</a>
				<a href="">김치</a>
				<a href="">반찬</a>
			</div>
			<div class="con_card4 con_card_list con_card">
			<ul>
				<c:forEach var="food" items="${foodList }">
					<li>
						<a href="foodDetailView.do?fcode=${food.f_fdcode }">
							<img src="/images/${food.f_imgname}" >
							<div class="desc">
								<h3>${food.f_foodname }</h3>
								<!-- <p>맛이 없을 수 없는 조합! 국민반찬 스팸과 매콤한 김치볶음!</p> -->
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
