<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp" />

	<div class="container login">
		<div class="login_wrap">
			<h3>��й�ȣ ã��</h3>
			<p>�Ʒ� ������ �Է� �� �ּ���.</p>
			<form:form commandName="pw_find" method="post" action="fine_Pw.do">
				<fieldset>
					<label for="">���̵�</label>
					<input type="text" id="m_userid" name="m_userid" placeholder="���̵�" required="">
					<form:errors path="m_userid"></form:errors>
				</fieldset>
			
				<fieldset>
					<input type="submit" value="��й�ȣ ã��" class="btn_submit">
				</fieldset>
			</form:form>
		</div>
	</div>
	
<jsp:include page="footer.jsp" />