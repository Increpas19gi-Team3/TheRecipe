<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<jsp:include page="include/header.jsp" />

	<div class="container join">
		<div class="join_wrap">
			<h3>
				회원가입
				<div class="page_locationBox">
					<a href="http://localhost:8282/therecipe/test_171129/home.jsp">홈</a>
					<span> > </span>
					<a href="join.html" class="active">회원가입</a>
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
					<input type="submit" value="회원가입" class="btn_submit">
				</fieldset>
			</form>
		</div>
	</div>

<jsp:include page="include/footer.jsp" />