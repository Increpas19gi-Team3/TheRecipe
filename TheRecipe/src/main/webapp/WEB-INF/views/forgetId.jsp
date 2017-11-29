<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp" />

<div class="container login">
		<div class="login_wrap">
			<h3>아이디 찾기</h3>
			<p>아래 정보를 입력 해 주세요.</p>
			<form:form commandName="id_find" method="post" action="fine_Id.do">
			
				<fieldset>
					<label for="">이메일</label>
					<input type="email" id="m_email" name="m_email" placeholder="이메일" required="">
					<form:errors path="m_email"></form:errors>
				</fieldset>
				
				<fieldset>
					<input type="submit" value="아이디 찾기" class="btn_submit">
				</fieldset>
			</form:form>
		</div>
	</div>

<jsp:include page="footer.jsp" />