<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>BRAND</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
	<link rel="stylesheet" href="css/style.css">
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
</head>
<body>
	<div class="header">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<a class="navbar-brand" href="#">BRAND</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							분류
						</a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="productList.html">한식</a>
							<a class="dropdown-item" href="#">중식</a>
							<a class="dropdown-item" href="#">양식</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="#">간식</a>
							<a class="dropdown-item" href="#">야식</a>
						</div>
					</li>
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							유명 TV 레시피
						</a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="#">올리브TV</a>
							<a class="dropdown-item" href="#">집밥 백선생</a>
							<a class="dropdown-item" href="#">냉장고를 부탁해</a>
							<a class="dropdown-item" href="#">최고의 요리</a>
							<a class="dropdown-item" href="#">오늘 뭐먹지</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="#">집들이요리/파티요리</a>
							<a class="dropdown-item" href="#">일요리/캠핑요리</a>
						</div>
					</li>
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							커뮤니티
						</a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="#">공지사항</a>
							<a class="dropdown-item" href="#">후기게시판</a>
							<a class="dropdown-item" href="#">추천 레시피</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="#">이벤트</a>
						</div>
					</li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="nav-item">
						<a class="nav-link" href="login.html">로그인</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="join.html">회원가입</a>
					</li>
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							마이페이지
						</a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="#">주문현황</a>
							<a class="dropdown-item" href="#">1:1 문의</a>
							<a class="dropdown-item" href="#">교환/반품</a>
							<a class="dropdown-item" href="#">등급별혜택/쿠폰함</a>
							<a class="dropdown-item" href="#">적립금내역</a>
							<a class="dropdown-item" href="#">내정보관리</a>
						</div>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#">장바구니</a>
					</li>
				</ul>
			</div>
		</nav>
	</div>
	<div class="container-fulid con1">
		<div class="container">
			<div class="title text-center">
				<p>베스트셀러</p>
				<h3>후기가 증명하는 베스트 반찬</h3>
			</div>
			<ul class="nav nav-pills nav-justified" id="pills-tab" role="tablist">
				<li class="nav-item">
					<a class="nav-link active" id="pills-1-tab" data-toggle="pill" href="#pills-1" role="tab" aria-controls="pills-1" aria-selected="true">중국 푸드트립</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" id="pills-2-tab" data-toggle="pill" href="#pills-2" role="tab" aria-controls="pills-2" aria-selected="false">풍성한 고기반찬</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" id="pills-3-tab" data-toggle="pill" href="#pills-3" role="tab" aria-controls="pills-3" aria-selected="false">바다향가득 반찬</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" id="pills-4-tab" data-toggle="pill" href="#pills-4" role="tab" aria-controls="pills-4" aria-selected="false">바다향가득 반찬</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" id="pills-5-tab" data-toggle="pill" href="#pills-5" role="tab" aria-controls="pills-5" aria-selected="false">바다향가득 반찬</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" id="pills-6-tab" data-toggle="pill" href="#pills-6" role="tab" aria-controls="pills-6" aria-selected="false">바다향가득 반찬</a>
				</li>
			</ul>
			<div class="tab-content" id="pills-tabContent">
				<div class="tab-pane fade show active" id="pills-1" role="tabpanel" aria-labelledby="pills-home-tab">
					<div class="row text-center">
						<div class="col-lg-4">
							<img  src="images/con2_1.jpg" alt="">
							<div class="textBox">
								<h5 class="text-truncate">[집밥의완성] 천하진미세트</h5>
								<p class="text-truncate">집으로 찾아오는 대륙의 진미</p>
								<p><a class="btn btn-info" href="#" role="button">상품보기</a></p>
							</div>
						</div>
						<div class="col-lg-4">
							<img  src="images/con2_2.jpg" alt="">
							<div class="textBox">
								<h5 class="text-truncate">[소중한식사] 치파오또우푸 300g</h5>
								<p class="text-truncate">부들부들 담백한 중국식 두부 요리</p>
								<p><a class="btn btn-info" href="#" role="button">상품보기</a></p>
							</div>
						</div>
						<div class="col-lg-4">
							<img  src="images/con2_3.jpg" alt="">
							<div class="textBox">
								<h5 class="text-truncate">[소중한식탁] 상하이고추잡채와 꽃빵 (2인분)</h5>
								<p class="text-truncate">볶으면 끝! 고급스런 중화요리도 간단하게</p>
								<p><a class="btn btn-info" href="#" role="button">상품보기</a></p>
							</div>
						</div>
					</div>
				</div>
				<div class="tab-pane fade" id="pills-2" role="tabpanel" aria-labelledby="pills-profile-tab">

				</div>
				<div class="tab-pane fade" id="pills-3" role="tabpanel" aria-labelledby="pills-contact-tab">

				</div>
				<div class="tab-pane fade" id="pills-4" role="tabpanel" aria-labelledby="pills-contact-tab">

				</div>
				<div class="tab-pane fade" id="pills-5" role="tabpanel" aria-labelledby="pills-contact-tab">

				</div>
				<div class="tab-pane fade" id="pills-6" role="tabpanel" aria-labelledby="pills-contact-tab">

				</div>
			</div>
		</div>
	</div>
	<div class="footer">
		footer
	</div>
</body>
</html>