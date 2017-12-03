<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="header.jsp" />

<div class="right_contnet">
	<h3>아이디 삭제 확인</h3>
</div>
<!--  commandName="deleteGo" -->
<form:form action="delete_Id_Go.do" method="post">

	<fieldset>
		<label for="">비밀번호</label> <input type="password" placeholder="비밀번호"
			id="m_pw" name="m_pw" required="">
	</fieldset>
	<fieldset>
		<label for="">비밀번호 확인</label> <input type="password"
			placeholder="비밀번호 확인" name="m_repw" required="">
	</fieldset>

	<fieldset class="btn_submitWrap">
		<input type="submit" value="확인" class="btn_submit">
	</fieldset>

</form:form>
<jsp:include page="footer.jsp" />

