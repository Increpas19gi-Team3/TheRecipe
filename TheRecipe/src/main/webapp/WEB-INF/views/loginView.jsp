<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="header.jsp" />
	<div class="container login">
		<div class="login_wrap">
			<h3>로그인</h3>
			<form:form class="loginandjoin" action="login.do" commandName="member" method="post">
				<fieldset>
					<label for="m_userid">아이디</label>
					<input type="text" class="form-control" id="m_userid" name="m_userid" aria-describedby="emailHelp" placeholder="아이디">
					
				</fieldset>
				<form:errors path="m_userid"></form:errors>
				<fieldset>
					<label for="m_pw">비밀번호</label>
				<input type="password" class="form-control" id="m_pw" name="m_pw" placeholder="비밀번호">
				</fieldset>
				<fieldset>
					<input type="submit" value="로그인" class="btn_submit">
				</fieldset>
			</form:form>
			<div class="bottom_box">
				<a href="forgetId.do">아이디 찾기</a>
				<a href="forgetPw.do">비밀번호 찾기</a>
				<a href="join.html">회원가입</a>
			</div>
		</div>
	</div>

<jsp:include page="footer.jsp" />
	