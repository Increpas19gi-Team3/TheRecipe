<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp" />
<div class="container login">
	<div class="login_wrap">
		<h3>아이디 찾기</h3>
		<form method="post" action="login.do">
			<p class="idpass_p">고객님의 아이디는 ${vo.m_userid} 입니다.</p>
			
			<fieldset>
				<input type="submit" value="로그인 화면으로" class="btn_submit" >
			</fieldset>
		</form>
	</div>
</div>
<jsp:include page="footer.jsp" />