<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp" />
<div class="container login">
	<div class="login_wrap">
		<h3>아이디 찾기</h3>
		<form method="post" action="login.do">
			<fieldset>
				<table class="">
					<tr>
						<td colspan="2" align="center">고객님의 아이디는 ${vo.m_userid} 입니다.
						</td>
					</tr>
				</table>
				<input type="submit" value="로그인 화면으로" class="btn_submit" >
			</fieldset>
		</form>
	</div>
</div>
<jsp:include page="footer.jsp" />