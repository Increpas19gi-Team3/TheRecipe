<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<jsp:include page="header.jsp" />

	<div class="container join">
		<div class="join_wrap">
			<h3>
				회원가입
				<div class="page_locationBox">
					<a href="home.do">홈</a>
					<span> > </span>
					<a href="" class="active">회원가입</a>
				</div>
			</h3>
			<form:form action="joinReg.do " method="post" commandName="memberjoin">
				<fieldset class="idBox">
					<label for="">아이디</label>
					<input type="text" placeholder="아이디" id="m_userid" name="m_userid" required="">
					<a href="idcheck.do" target="_blank">아이디 중복 체크</a> 
					<span class="msg">${msg}</span>
				</fieldset>
				<fieldset>
					<label for="">비밀번호</label>
					<input type="password" placeholder="비밀번호" id="m_pw" name="m_pw" required="">
				</fieldset>
				<fieldset>
					<label for="">비밀번호 확인</label>
					<input type="password" placeholder="비밀번호 확인" name="m_repw" required="">
				</fieldset>
				<fieldset>
					<label for="">이메일</label>
					<input type="email" placeholder="이메일" id="m_email" name="m_email" placeholder="이메일" required="">
				</fieldset>
				<fieldset>
					<label for="">이름</label>
					<input type="text" placeholder="이름" id="m_name" name="m_name" required="">
				</fieldset>
				<fieldset>
					<label for="">우편번호</label>
					<input type="text" placeholder="우편번호"  id="m_post" name="m_post" required="">
				</fieldset>
				<fieldset>
					<label for="">주소</label>
					<input type="text" placeholder="주소" id="m_addr" name="m_addr" required="" class="address_input">
				</fieldset>
				<fieldset>
					<label for="">전화번호</label>
					<input type="text" id="m_phone" name="m_phone" placeholder="전화번호" required="">
				</fieldset>
				<hr>
				<fieldset class="btn_submitWrap">
					<input type="submit" value="회원가입" class="btn_submit">
				</fieldset>
			</form:form>
		</div>
	</div>

<jsp:include page="footer.jsp" />