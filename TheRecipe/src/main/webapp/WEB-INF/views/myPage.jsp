<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp" />

<div class="container myPage board">
		<div class="row">
			<div class="left_tab">
				<h2>고객센터</h2>
				<ul>
					<li class="active"><a href="">내정보관리</a></li>
					<li><a href="myOrderList.do">주문 조회</a></li>
					<li><a href="#">내가 쓴 글</a></li>
				</ul>
				<div class="service_info">
					<h4>배민찬 고객센터</h4>
					<h3>1899-2468</h3>
					<hr>
					<p>평일 06:30 ~ 18:00</p>
					<p>주말 06:30 ~ 15:00</p>
					<p>공휴일 휴무</p>
				</div>
			</div>
			<div class="right_contnet">
				<h3>
					내정보관리
					<div class="page_locationBox">
						<a href="home.do">홈</a>
						<span> > </span>
						<a href="mypageInfo.do">마이페이지</a>
						<span> > </span>
						<a href="mypageInfo.do" class="active">내정보관리</a>
					</div>
				</h3>
				<form:form action="mypageupdate.do" method="post" commandName="memberup" >
				
					<fieldset>
						<label for="">아이디</label>
						<input type="text" placeholder="아이디" id="m_userid" name="m_userid" value="${mVo.m_userid}" required="" readonly>
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
						<input type="email" value="${mVo.m_email}" id="m_email" name="m_email" placeholder="이메일" required="">
					</fieldset>
					<fieldset>
						<label for="">이름</label>
						<input type="text" value="${mVo.m_name}" id="m_name" name="m_name" placeholder="이름" required="" readonly>
					</fieldset>
					<fieldset>
						<label for="">우편번호</label>
						<input type="text" value="${mVo.m_post}" id="m_post" name="m_post" placeholder="우편번호" required="">
					</fieldset>
					<fieldset>
						<label for="">주소</label>
						<input type="text" value="${mVo.m_addr}" id="m_addr" name="m_addr" placeholder="주소" required="" class="address_input">
					</fieldset>
					<fieldset>
						<label for="">전화번호</label>
						<input type="text" value="${mVo.m_phone}" id="m_phone" name="m_phone"  placeholder="전화번호" required="">
					</fieldset>
					<hr>
					<fieldset class="btn_submitWrap">
						<input type="submit" value="저장" class="btn_submit">
						<a href="#" onClick="history.back(); return false;" class="btn_back">취소</a>
					</fieldset>
					
				</form:form>
				<div class="bottom_box">
					<p>탈퇴를 원하시면 회원탈퇴 버튼을 눌러주세요.</p>
					<a href="delete_Id.do">회원탈퇴</a>
				</div>
			</div>
		</div>
	</div>
	
<jsp:include page="footer.jsp" />