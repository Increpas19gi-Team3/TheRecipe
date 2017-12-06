<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="header.jsp" />

<!--  commandName="deleteGo" -->
<div class="drepw">
<h3>삭제하려면 입력하세요</h3>

<form:form name="deleteform" action="delete_Id_Go.do" method="post">

	<fieldset>
		<label for="">비밀번호</label> 
		<input type="password" placeholder="비밀번호" id="m_pw" name="m_pw" required="">
	</fieldset>
	<fieldset>
		<label for="">비밀번호 확인</label> 
		<input type="password" placeholder="비밀번호 확인" name="m_repw" required="">
	</fieldset>

	<fieldset class="btn_submitWrap">
		<input type="submit" value="확인" class="btn_submit" onclick="return checkValue()">
	</fieldset>

</form:form>

</div>
<jsp:include page="footer.jsp" />

