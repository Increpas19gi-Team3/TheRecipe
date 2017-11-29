<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<jsp:include page="include/header.jsp" />

	<div class="container myPage board">
		<div class="row">
			<div class="left_tab">
				<h2>고객센터</h2>
				<ul>
					<li class="active"><a href="http://localhost:8282/therecipe/test_171129/myPage.jsp">내정보관리</a></li>
					<li><a href="http://localhost:8282/therecipe/test_171129/myOrder.jsp">주문 조회</a></li>
					<li><a href="http://localhost:8282/therecipe/test_171129/myWrite.jsp">내가 쓴 글</a></li>
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
					<div class="page_locationBox">
						<a href="http://localhost:8282/therecipe/test_171129/home.jsp">홈</a>
						<span> > </span>
						<a href="http://localhost:8282/therecipe/test_171129/myPage.jsp">마이페이지</a>
						<span> > </span>
						<a href="http://localhost:8282/therecipe/test_171129/myOrder.jsp" class="active">주문조회</a>
					</div>
				</h3>
				<form action="">
					<fieldset>
						<label for="">아이디</label>
						<input type="text" placeholder="아이디" required="">
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
						<input type="email" placeholder="이메일" required="">
					</fieldset>
					<fieldset>
						<label for="">이름</label>
						<input type="text" placeholder="이름" required="">
					</fieldset>
					<fieldset>
						<label for="">우편번호</label>
						<input type="text" placeholder="우편번호" required="">
					</fieldset>
					<fieldset>
						<label for="">주소</label>
						<input type="text" placeholder="주소" required="" class="address_input">
					</fieldset>
					<fieldset>
						<label for="">전화번호</label>
						<input type="text" placeholder="전화번호" required="">
					</fieldset>
					<hr>
					<fieldset class="btn_submitWrap">
						<input type="submit" value="저장" class="btn_submit">
						<a href="#" onClick="history.back(); return false;" class="btn_back">취소</a>
					</fieldset>
				</form>
				<div class="bottom_box">
					<p>탈퇴를 원하시면 회원탈퇴 버튼을 눌러주세요.</p>
					<a href="">회원탈퇴</a>
				</div>
			</div>
		</div>
	</div>

<jsp:include page="include/footer.jsp" />