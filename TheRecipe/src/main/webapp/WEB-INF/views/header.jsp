<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>BRAND</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
<link rel="stylesheet" href="/therecipe/resources/css/style.css">
</head>
<body>

<div class="header">
		<div class="logo">The Recipe</div>
		<div class="nav_wrap">
			<div class="nav_inner">
				<div class="nav_left">
					<ul>
						<li class="dropdown_wrap">
							<a href="localFoodList.do" class="dropdown_select">분류</a>
							<ul class="dropdown_itemWrap">
								<li><a href="localKindList.do?local=1">한식</a></li>
								<li><a href="localKindList.do?local=2">중식</a></li>
								<li><a href="localKindList.do?local=3">일식</a></li>
								<li><a href="localKindList.do?local=4">양식</a></li>
							</ul>
						</li>
						<li class="dropdown_wrap">
							<a href="" class="dropdown_select">유명 TV 레시피</a>
							<ul class="dropdown_itemWrap">
								<li><a href="">올리브TV</a></li>
								<li><a href="">집밥백선생</a></li>
								<li><a href="">냉장고를 부탁해</a></li>
								<li><a href="">최고의 요리</a></li>
								<li><a href="">오늘 뭐먹지</a></li>
							</ul>
						</li>
						<li class="dropdown_wrap">
							<a href="" class="dropdown_select">커뮤니티</a>
							<ul class="dropdown_itemWrap">
								<li><a href="boardNotice.html">공지사항</a></li>
								<li><a href="boardReview.html">후기 게시판</a></li>
								<li><a href="boardRecommend.html">추천 레시피</a></li>
								<li><a href="boardEvent.html">이벤트</a></li>
							</ul>
						</li>
					</ul>
				</div>
				<div class="nav_right">
					<ul>
						<c:choose>
							<c:when test="${not empty sessionScope.m_userid}">			
								<h2>${sessionScope.m_userid}</h2>
								<li class="nav-item">
									<a class="nav-link" href="logout.do">로그아웃</a>
								</li>
							</c:when>
							<c:otherwise>
								<li class="dropdown_wrap"><a href="loginView.do">로그인</a></li>
								<li><a href="join.html">회원가입</a></li>
							</c:otherwise>
						</c:choose>
						<li class="dropdown_wrap">
							<a href="" class="dropdown_select">마이페이지</a>
							<ul class="dropdown_itemWrap">
								<li><a href="">주문현황</a></li>
								<li><a href="">1:1 문의</a></li>
								<li><a href="">교환/반품</a></li>
								<li><a href="">쿠폰함</a></li>
								<li><a href="mypage.html">내정보관리</a></li>
							</ul>
						</li>
						<li><a href="">장바구니</a></li>
					</ul>
				</div>	
			</div>
		</div>
	</div>
