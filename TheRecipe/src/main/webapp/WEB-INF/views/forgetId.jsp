<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp" />

<div class="container login">
		<div class="login_wrap">
			<h3>���̵� ã��</h3>
			<p>�Ʒ� ������ �Է� �� �ּ���.</p>
			<form:form commandName="id_find" method="post" action="fine_Id.do">
			
				<fieldset>
					<label for="">�̸���</label>
					<input type="email" id="m_email" name="m_email" placeholder="�̸���" required="">
					<form:errors path="m_email"></form:errors>
				</fieldset>
				
				<fieldset>
					<input type="submit" value="���̵� ã��" class="btn_submit">
				</fieldset>
			</form:form>
		</div>
	</div>

<jsp:include page="footer.jsp" />