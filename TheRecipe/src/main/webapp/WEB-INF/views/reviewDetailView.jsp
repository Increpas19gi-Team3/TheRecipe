<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="container boardNotice board">
	<div class="row">
		<div class="left_tab">
			<h2>고객센터</h2>
			<ul>
				<li><a href="boardNotice.html">공지사항</a></li>
				<li class="active"><a href="boardReview.html">후기 게시판</a></li>
				<li><a href="boardRecommend.html">추천 레시피</a></li>
				<li><a href="boardEvent.html">이벤트</a></li>
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
				글쓰기
				<div class="page_locationBox">
					<a href="http://localhost:8282/therecipe/test_171129/home.jsp">홈</a>
					<span> > </span> 
					<a href="#">커뮤니티</a> 
					<span> > </span> 
					<a href="#">후기 게시판</a> 
					<span> > </span> 
					<a href="#" class="active">글쓰기</a>
				</div>
			</h3>
			
			
			<form action="#" method="post">
				<section>
					<div id="#" align="center">
						<h1>후기 상세보기</h1>
						<br>
							<fieldset>
								<label for=""> 후기 코드 </label> 
								<input type="text" class="form-control" id="r_rvcode" name="r_rvcode" readonly="readonly" value="${rVo.r_rvcode}">
							</fieldset>
							
							<fieldset>
								<label for=""> 아이디 </label> 
								<input type="text" class="form-control" id="m_userid" name="m_userid" readonly="readonly" value="${rVo.m_userid}">
							</fieldset>
							
							<fieldset>
								<label for=""> 상품코드 </label> 
								<input type="text" class="form-control" id="f_fdcode" name="f_fdcode" readonly="readonly" value="${rVo.f_fdcode}">
							</fieldset>

							<fieldset>
								<label for=""> 제&nbsp;&nbsp;목 </label> 
								<input type="text" class="form-control" id="r_title" name="r_title" readonly="readonly" value="${rVo.r_title}">
							</fieldset>
							
							<fieldset>
								<label for=""> 후&nbsp;&nbsp;기 </label> 
								<input type="text" class="form-control" id="r_rvcontents" name="r_rvcontents" readonly="readonly" value="${rVo.r_rvcontents}">
							</fieldset>						
							
							<fieldset>
								<label for=""> 평&nbsp;&nbsp;점 </label> 
								<input type="text" class="form-control" id="r_grade" name="r_grade" readonly="readonly" value="${rVo.r_grade}">
							</fieldset>
							
							<fieldset>
								<label for=""> 이미지명 </label> 
								<input type="text" class="form-control" id="r_rvimgname" name="r_rvimgname" readonly="readonly" value="${rVo.r_rvimgname}">
								<img src="/images/${rVo.r_rvimgname}" width="400" height="400">
							</fieldset>
							
							<fieldset>
								<label for=""> 조회수 </label> 
								<input type="text" class="form-control" id="r_rvcount" name="r_rvcount" readonly="readonly" value="${rVo.r_rvcount}">
							</fieldset>
							
							<fieldset>
								<label for=""> 글등록시간 </label> 
								<input type="text" class="form-control" id="r_rvdate" name="r_rvdate" readonly="readonly" 
									value="<fmt:formatDate value="${rVo.r_rvdate}" pattern="yyyy-MM-dd HH:mm:ss" />">
							</fieldset>							
							
							<c:if test="${not empty rVo.r_admincmt}">
								<fieldset> 
									<label for=""> 관리자댓글 </label> 
									<input type="text" class="form-control" id="r_admincmt" name="r_admincmt" readonly="readonly" value="${rVo.r_admincmt}">
								</fieldset>
							
								<fieldset>
									<label for=""> 관리자댓글시간 </label> 
									<input type="text" class="form-control" id="r_admindate" name="r_admindate" readonly="readonly" 
										value="<fmt:formatDate value="${rVo.r_admindate}" pattern="yyyy-MM-dd HH:mm:ss" />">
								</fieldset>													
							</c:if>
							
						<div class="review_update">											
							<input type="button" value="후기 답변 등록(수정)" onclick="location.href='reviewAdminRegUpdate.do?r_rvcode=${rVo.r_rvcode}'">							
							<c:if test="${not empty rVo.r_admincmt}">
								<input type="button" value="후기 답변 삭제" onclick="location.href='reviewAdminDelete.do?r_rvcode=${rVo.r_rvcode}'">
							</c:if>								
						</div>						
					</div>
				</section>
			</form>
			<hr>
		</div>
	</div>
</div>

<footer></footer>