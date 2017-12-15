<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp" />

	<div class="container login">
		<div class="login_wrap">
			<h3>비밀번호 찾기</h3>
			<p>아래 정보를 입력 해 주세요.</p>
			
			<form:form commandName="pw_find" method="post" action="fine_Pw.do">
				<fieldset>
					<label for="">아이디</label>
					<input type="text" id="m_userid" name="m_userid" placeholder="아이디" required="" value="${m_userid }">
					<form:errors path="m_userid"></form:errors>
				</fieldset>	
					
					
				<fieldset>
					<label for="">전화번호</label>
					<input type="text" id="m_phone" name="m_phone" placeholder="전화번호" required="">
					<form:errors path="m_phone"></form:errors>
				</fieldset>
			
				<div style="color: red;"><p>${message }<br/><br/></p></div>
			
				<fieldset>
					<input type="submit" value="비밀번호 찾기" class="btn_submit">
				</fieldset>
			</form:form>
			
		</div>
	</div>
	
<jsp:include page="footer.jsp" />