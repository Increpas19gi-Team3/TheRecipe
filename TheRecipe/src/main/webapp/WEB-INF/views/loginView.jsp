<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
							<a class="dropdown-item" href="#">한식</a>
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
						<a class="nav-link active" href="#">로그인</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#">회원가입</a>
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
	<div class="container">
		<form:form class="loginandjoin" action="login.do" commandName="member" method="post">
			<h2>로그인</h2>
			<div class="form-group">
				<label for="m_userid">아이디</label>
				<input type="text" class="form-control" id="m_userid" name="m_userid" aria-describedby="emailHelp" placeholder="아이디">
				<form:errors path="m_userid"></form:errors>
			</div>
			<div class="form-group">
				<label for="m_pw">비밀번호</label>
				<input type="password" class="form-control" id="m_pw" name="m_pw" placeholder="비밀번호">
			</div>
			<button type="submit" class="btn btn-info">로그인</button>
			<div class="form-group idpassjoinBox">
				<a href="">아이디 찾기</a>
				<a href="">비밀번호 찾기</a>
				<a href="">회원가입</a>
			</div>
		</form:form>
	</div>
	<div class="footer">
		footer
	</div>
</body>
</html>