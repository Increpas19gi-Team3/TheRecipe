<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<jsp:include page="include/header.jsp" />

	<div class="container login">
		<div class="login_wrap">
			<h3>비밀번호 찾기</h3>
			<form action="">
				<fieldset>
					<label for="">아이디</label>
					<input type="text" placeholder="아이디" required="">
				</fieldset>
				<fieldset>
					<label for="">이메일</label>
					<input type="email" placeholder="이메일" required="">
				</fieldset>
				<fieldset>
					<input type="submit" value="비밀번호 찾기" class="btn_submit">
				</fieldset>
			</form>
		</div>
	</div>

<jsp:include page="include/footer.jsp" />