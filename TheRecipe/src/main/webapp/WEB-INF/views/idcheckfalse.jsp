<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp" />
<div class="container login">
	<div class="login_wrap">
		<h3>아이디 중복 false</h3>
		<form method="post" action="join.do">
			<fieldset>
				<table class="">
					<tr>
						<td colspan="2" align="center">아이디 ${m_userid}는 이미 있습니다.
						</td>
					</tr>
				</table>
				<input type="submit" value="확인" class="btn_submit" >
			</fieldset>
		</form>
	</div>
</div>
<jsp:include page="footer.jsp" />