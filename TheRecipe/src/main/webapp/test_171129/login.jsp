<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<jsp:include page="include/header.jsp" />

	<div class="container login">
		<div class="login_wrap">
			<h3>로그인</h3>
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
					<input type="submit" value="로그인" class="btn_submit">
				</fieldset>
			</form>
			<div class="bottom_box">
				<a href="forgetId.html">아이디 찾기</a>
				<a href="forgetPassword.html">비밀번호 찾기</a>
				<a href="join.html">회원가입</a>
			</div>
		</div>
	</div>

<jsp:include page="include/footer.jsp" />