<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp" />
	<div class="container login">
		<div class="login_wrap">
			<h3>��й�ȣ ã��</h3>
			<form method="post" action="login.do">
				<fieldset>
					<table class="">
						<tr>
							<td colspan="2" align="center">${vo.m_userid}���� ��й�ȣ�� ${vo.m_pw} �Դϴ�.</td>
						</tr>
					</table>
								
					<input type="submit" value="�α��� ȭ������" class="btn_submit" >
				
					
				</fieldset>
			</form>
		</div>
	</div>
<jsp:include page="footer.jsp" />