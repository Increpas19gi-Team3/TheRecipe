<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>BRAND</title>
	<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="header">
		<div class="logo">BRAND</div>
		<div class="nav_wrap">
			<div class="nav_left">
				<ul>
					<li class="dropdown_wrap">
						<a href="" class="dropdown_select">분류</a>
						<ul class="dropdown_itemWrap">
							<li><a href="">한식</a></li>
							<li><a href="">중식</a></li>
							<li><a href="">양식</a></li>
						</ul>
					</li>
					<li class="dropdown_wrap">
						<a href="" class="dropdown_select">유명 TV 레시피</a>
						<ul class="dropdown_itemWrap">
							<li><a href="">한식</a></li>
							<li><a href="">중식</a></li>
							<li><a href="">양식</a></li>
						</ul>
					</li>
					<li class="dropdown_wrap">
						<a href="" class="dropdown_select">커뮤니티</a>
						<ul class="dropdown_itemWrap">
							<li><a href="">한식</a></li>
							<li><a href="">중식</a></li>
							<li><a href="">양식</a></li>
						</ul>
					</li>
				</ul>
			</div>
			<div class="nav_right">
				<ul>
					<li class="dropdown_wrap"><a href="login.html">로그인</a></li>
					<li><a href="">회원가입</a></li>
					<li class="dropdown_wrap">
						<a href="" class="dropdown_select">마이페이지</a>
						<ul class="dropdown_itemWrap">
							<li><a href="">주문현황</a></li>
							<li><a href="">1:1 문의</a></li>
							<li><a href="">교환/반품</a></li>
							<li><a href="">쿠폰함</a></li>
							<li><a href="">내정보관리</a></li>
						</ul>
					</li>
					<li><a href="">장바구니</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="container login">
		<div class="login_wrap">
			<h3>비밀번호 찾기</h3>
			<p>아래 정보를 입력 해 주세요.</p>
			<form:form commandName="pw_find" method="post" action="fine_Pw.do">
				<fieldset>
					<label for="">아이디</label>
					<input type="text" id="m_userid" name="m_userid" placeholder="아이디" required="">
					<form:errors path="m_userid"></form:errors>
				</fieldset>
				<fieldset>
					<input type="submit" value="비밀번호 찾기" class="btn_submit">
				</fieldset>
			</form:form>
		</div>
	</div>
</body>
</html>