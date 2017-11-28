<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<jsp:include page="header.jsp" />

	<div class="container">
		<nav aria-label="breadcrumb" role="navigation">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="home.jsp">홈</a></li>
				<li class="breadcrumb-item active" aria-current="page">한식</li>
			</ol>
		</nav>
		<ul class="nav bd-info">
			<li class="nav-item">
				<a class="nav-link active" href="localKindList.do?local=0">전체보기</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="localKindList.do?local=1">한식</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="localKindList.do?local=2">중식</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="localKindList.do?local=3">일식</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="localKindList.do?local=4">양식</a>
			</li>
		</ul>
		<div class="row text-center">
			<c:forEach var="food" items="${foodList }">
			<div class="col-lg-3">
				<div class="card">
					<a href="foodDetailView.do?fcode=${food.f_fdcode }">
						<img src="/images/${food.f_imgname}" ></a>
					<div class="card-body">
						<h6 class="card-title text-truncate">${food.f_foodname }</h6>
						<p class="card-text text-right">
							<s class="text-muted"><small></small></s>
							<b>${food.f_price }</b>원
						</p>
						<a class="btn btn-info" href="foodDetailView.do?fcode=${food.f_fdcode }">상품보기</a>
						<a class="btn btn-info" href="#">장바구니</a>
					</div>
				</div>
			</div>
			</c:forEach>
		</div>
		<nav aria-label="Page navigation">
			<ul class="pagination justify-content-center">
				<li class="page-item disabled">
					<span class="page-link">Previous</span>
				</li>
				<li class="page-item"><a class="page-link" href="#">1</a></li>
				<li class="page-item active">
					<span class="page-link">
						2
						<span class="sr-only">(current)</span>
					</span>
				</li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item">
					<a class="page-link" href="#">Next</a>
				</li>
			</ul>
		</nav>
	</div>

	<jsp:include page="footer.jsp" />
