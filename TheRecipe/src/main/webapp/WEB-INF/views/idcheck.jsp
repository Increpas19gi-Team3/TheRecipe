<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp" />

<div class="container login">
		<div class="login_wrap">
			<h3>아이디 중복</h3>
			<p>아래 정보를 입력 해 주세요.</p>
			<form:form commandName="checkid" method="post" action="idchecksuccess.do">
			
				<fieldset>
					<label for="">아이디</label>
					<input type="text" id="checkid" name="checkid" placeholder="아이디체크" required="">
					<form:errors path="checkid"></form:errors>
				</fieldset>
				
				<fieldset>
					<input type="submit" value="아이디 찾기" class="btn_submit">
				</fieldset>
			</form:form>
		</div>
	</div>

<jsp:include page="footer.jsp" />