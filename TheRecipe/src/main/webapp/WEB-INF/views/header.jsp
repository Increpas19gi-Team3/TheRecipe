<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>BRAND</title>
<link rel="stylesheet" href="/therecipe/resources/css/style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<div class="header">
		<div class="logo">
			<a href="userIndex.do">The Recipe</a>
		</div>
		<div class="nav_wrap">
			<div class="nav_inner">
				<div class="nav_left">
					<ul>
						<li class="dropdown_wrap">
						<a href="totalFoodList.do?level=1&large=1" class="dropdown_select">분류</a> 
							<ul class="dropdown_itemWrap">
								<li><a href="totalFoodList.do?level=2&large=1&medium=1">한식</a></li>  
								<li><a href="totalFoodList.do?level=2&large=1&medium=2">중식</a></li>  
								<li><a href="totalFoodList.do?level=2&large=1&medium=3">일식</a></li>  
								<li><a href="totalFoodList.do?level=2&large=1&medium=4">양식</a></li>  

							</ul></li>
						<li class="dropdown_wrap">
						<a href="totalFoodList.do?level=1&large=2" class="dropdown_select">유명 TV 레시피</a> 
							<ul class="dropdown_itemWrap">
								<li><a href="totalFoodList.do?level=2&large=2&medium=1">올리브TV</a></li>  
								<li><a href="totalFoodList.do?level=2&large=2&medium=2">집밥백선생</a></li>  
								<li><a href="totalFoodList.do?level=2&large=2&medium=3">냉장고를 부탁해</a></li>  
								<li><a href="totalFoodList.do?level=2&large=2&medium=4">최고의 요리</a></li>  
							<li><a href="totalFoodList.do?level=2&large=2&medium=5">오늘 뭐먹지</a></li>  

							</ul></li>
						<li class="dropdown_wrap"><a href="" class="dropdown_select">커뮤니티</a>
							<ul class="dropdown_itemWrap">
								<li><a href="userNoticeList.do">공지사항</a></li>
								<li><a href="ReviewList.do">후기 게시판</a></li>
								<li><a href="boardRecommend.html">추천 레시피</a></li>
								<li><a href="userEventList.do">이벤트</a></li>
							</ul></li>
					</ul>
				</div>
				<div class="nav_right">
					<ul>
						<c:choose>
							<c:when test="${not empty sessionScope.m_userid}">
								<li><a class="nav-link" href="mypageInfo.do">${sessionScope.m_userid}
										님</a></li>
								<li class="nav-item"><a class="nav-link" href="logout.do">로그아웃</a>
								</li>
								<li class="dropdown_wrap"><a href="mypageInfo.do"
									class="dropdown_select">마이페이지</a>
									<ul class="dropdown_itemWrap">
										<li><a href="myOrderList.do">주문현황</a></li>
										<li><a href="">1:1 문의</a></li>
										<li><a href="">교환/반품</a></li>
										<li><a href="">쿠폰함</a></li>

										<li><a href="mypageInfo.do" class="dropdown_select">내정보관리</a></li>
									</ul></li>
								<li><a href="BasketForm.do">장바구니</a></li>
						
								<c:if test="${sessionScope.m_level==0}">
									<li class="dropdown_wrap"><a href="adminIndex.do"
										class="dropdown_select" target="_blank">관리자페이지</a>
								</c:if>

							</c:when>
							<c:otherwise>
								<li class="dropdown_wrap"><a href="loginView.do">로그인</a></li>
								<li><a href="join.do">회원가입</a></li>
							</c:otherwise>
						</c:choose>

					</ul>
				</div>
			</div>
		</div>
	</div>