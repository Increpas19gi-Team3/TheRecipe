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
					<li class="dropdown_wrap"><a href="login.html">로그인</a></li>
					<li><a href="join.html">회원가입</a></li>
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
	<div class="container myPage board">
		<div class="row">
			<div class="left_tab">
				<h2>고객센터</h2>
				<ul>
					<li class="active"><a href="myPage.html">내정보관리</a></li>
					<li><a href="myorder.html">주문 조회</a></li>
					<li><a href="myWrite.html">내가 쓴 글</a></li>
				</ul>
				<div class="service_info">
					<h4>배민찬 고객센터</h4>
					<h3>1899-2468</h3>
					<hr>
					<p>평일 06:30 ~ 18:00</p>
					<p>주말 06:30 ~ 15:00</p>
					<p>공휴일 휴무</p>
				</div>
			</div>
			<div class="right_contnet">
				<h3>
					내정보관리
					<div class="page_locationBOx">
						<a href="home.html">홈</a>
						<span> > </span>
						<a href="join.html">마이페이지</a>
						<span> > </span>
						<a href="join.html" class="active">내정보관리</a>
					</div>
				</h3>
				<form:form action="" method="post">
					<fieldset>
						<label for="">아이디</label>
						<input type="text" placeholder="아이디" value="${mVo.m_userid}" required="" disabled="disabled">
					</fieldset>
					<fieldset>
						<label for="">비밀번호</label>
						<input type="password" placeholder="비밀번호" required="">
					</fieldset>
					<fieldset>
						<label for="">비밀번호 확인</label>
						<input type="password" placeholder="비밀번호 확인" required="">
					</fieldset>
					<fieldset>
						<label for="">이메일</label>
						<input type="email" value="${mVo.m_email}" placeholder="이메일" required="">
					</fieldset>
					<fieldset>
						<label for="">이름</label>
						<input type="text" value="${mVo.m_name}" placeholder="이름" required="" disabled="disabled">
					</fieldset>
					<fieldset>
						<label for="">우편번호</label>
						<input type="text" value="${mVo.m_post}"placeholder="우편번호" required="">
					</fieldset>
					<fieldset>
						<label for="">주소</label>
						<input type="text" value="${mVo.m_addr}" placeholder="주소" required="" class="address_input">
					</fieldset>
					<fieldset>
						<label for="">전화번호</label>
						<input type="text" value="${mVo.m_phone}" placeholder="전화번호" required="">
					</fieldset>
					
					<hr>
					<fieldset class="btn_submitWrap">
						<input type="submit" value="저장" class="btn_submit">
						<a href="#" onClick="history.back(); return false;" class="btn_back">취소</a>
					</fieldset>
				</form:form>
				<div class="bottom_box">
					<p>탈퇴를 원하시면 회원탈퇴 버튼을 눌러주세요.</p>
					<a href="">회원탈퇴</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>