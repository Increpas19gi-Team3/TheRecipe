<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>The Recipe</title>
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
	<div class="container home">
		<div class="con_inner bg_eee">
			<h3>베스트셀러</h3>
			<h2><b>후기가 증명하는 베스트 반찬</b></h2>
			<div class="tab_wrap">
				<input id="tab-1" type="radio" name="tab-group" checked="checked" />
				<label for="tab-1">중국 푸드트립</label>
				<input id="tab-2" type="radio" name="tab-group" />
				<label for="tab-2">풍성한 고기반찬</label>
				<input id="tab-3" type="radio" name="tab-group" />
				<label for="tab-3">바다향가득 반찬</label>
				<input id="tab-4" type="radio" name="tab-group" />
				<label for="tab-4">간편한 덮밥요리</label>
				<input id="tab-5" type="radio" name="tab-group" />
				<label for="tab-5">할인특가 세트상품</label>
				<input id="tab-6" type="radio" name="tab-group" />
				<label for="tab-6">맛있는 간식타임</label>
				<div id="content">
					<div id="content-1">
						<div class="con_card3 con_card">
							<ul>
								<li>
									<img src="images/con2_1.jpg" alt="">
									<div class="desc">
										<h3>[집밥의완성] 스팸김치볶음 220g</h3>
										<p>맛이 없을 수 없는 조합! 국민반찬 스팸과 매콤한 김치볶음!</p>
										<span><b>3,600원</b>3,400<small>원</small></span>
									</div>
								</li>
								<li>
									<img src="images/con2_2.jpg" alt="">
									<div class="desc">
										<h3>[집밥의완성] 스팸김치볶음 220g</h3>
										<p>맛이 없을 수 없는 조합! 국민반찬 스팸과 매콤한 김치볶음!</p>
										<span><b>3,600원</b>3,400<small>원</small></span>
									</div>
								</li>
								<li>
									<img src="images/con2_3.jpg" alt="">
									<div class="desc">
										<h3>[집밥의완성] 스팸김치볶음 220g</h3>
										<p>맛이 없을 수 없는 조합! 국민반찬 스팸과 매콤한 김치볶음!</p>
										<span><b>3,600원</b>3,400<small>원</small></span>
									</div>
								</li>
							</ul>
						</div>
					</div>
					<div id="content-2">
						b
					</div>
					<div id="content-3">
						c
					</div>
					<div id="content-4">
						a
					</div>
					<div id="content-5">
						b
					</div>
					<div id="content-6">
						c
					</div>
				</div>
			</div>
		</div>
		<div class="con_inner">
			<h3>반찬세트</h3>
			<h2>고민없이 한 번에 <b>반찬세트</b></h2>
			<div class="con_card4 con_card">
				<ul>
					<li>
						<img src="images/con1_1.jpg" alt="">
						<div class="desc">
							<h3>[집밥의완성] 스팸김치볶음 220g</h3>
							<p>맛이 없을 수 없는 조합! 국민반찬 스팸과 매콤한 김치볶음!</p>
							<span><b>3,600원</b>3,400<small>원</small></span>
						</div>
					</li>
					<li>
						<img src="images/con1_2.jpg" alt="">
						<div class="desc">
							<h3>[집밥의완성] 스팸김치볶음 220g</h3>
							<p>맛이 없을 수 없는 조합! 국민반찬 스팸과 매콤한 김치볶음!</p>
							<span><b>3,600원</b>3,400<small>원</small></span>
						</div>
					</li>
					<li>
						<img src="images/con1_3.jpg" alt="">
						<div class="desc">
							<h3>[집밥의완성] 스팸김치볶음 220g</h3>
							<p>맛이 없을 수 없는 조합! 국민반찬 스팸과 매콤한 김치볶음!</p>
							<span><b>3,600원</b>3,400<small>원</small></span>
						</div>
					</li>
					<li>
						<img src="images/con1_4.jpg" alt="">
						<div class="desc">
							<h3>[집밥의완성] 스팸김치볶음 220g</h3>
							<p>맛이 없을 수 없는 조합! 국민반찬 스팸과 매콤한 김치볶음!</p>
							<span><b>3,600원</b>3,400<small>원</small></span>
						</div>
					</li>
				</ul>
			</div>
			<a href="" class="btn_all">전체 보기</a>
		</div>
	</div>
</body>
</html>