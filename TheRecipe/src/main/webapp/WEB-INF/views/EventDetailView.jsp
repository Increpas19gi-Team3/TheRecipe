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
				<li class="active"><a href="boardNotice.html">공지사항</a></li>
				<li><a href="boardReview.html">후기 게시판</a></li>
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
					<span> > </span> <a href="#">커뮤니티</a> <span> > </span> <a href="#">후기
						게시판</a> <span> > </span> <a href="#" class="active">글쓰기</a>
				</div>
			</h3>

			<form action="" method="post">
				<section>
					<div id="#" align="center">
						<h1>이벤트 상세보기</h1>
						<br>
						
						<fieldset>
								<label for=""> 이벤트 코드 </label> 
								<input type="text" class="form-control" id="e_evtcode" name="e_evtcode" readonly="readonly" value="${eVo.e_evtcode}">
							</fieldset>
							
							<fieldset>
								<label for=""> 제&nbsp;&nbsp;목 </label> 
								<input type="text" class="form-control" id="e_nttilte" name="e_nttilte" readonly="readonly" value="${eVo.e_nttilte}">
							</fieldset>								

							<fieldset>
								<label for=""> 구&nbsp;&nbsp;분 </label> 
								<input type="text" class="form-control" id="e_gubun" name="e_gubun" readonly="readonly" value="${eVo.e_gubun}">
							</fieldset>	
							
							<fieldset>
								<label for=""> 작성날짜 </label> 
								<input type="text" class="form-control" id="e_ntdate" name="e_ntdate" readonly="readonly" 
									value="<fmt:formatDate value="${eVo.e_ntdate}" pattern="yyyy-MM-dd HH:mm:ss" />">
							</fieldset>

							<fieldset>
								<label for=""> 내&nbsp;&nbsp;용 </label> 
								<input type="text" class="form-control" id="e_ntcontens" name="e_ntcontens" readonly="readonly" value="${eVo.e_ntcontens}">
							</fieldset>							
							
							<fieldset>
								<label for=""> 이미지 </label> 
								<input type="text" class="form-control" id="e_ntimgname" name="e_ntimgname" readonly="readonly" value="${eVo.e_ntimgname}">
								<img src="/images/${eVo.e_ntimgname}" width="400" height="400">
							</fieldset>	
							
							<fieldset>
								<label for=""> 할인율 </label> 
								<input type="text" class="form-control" id="e_discount" name="e_discount" readonly="readonly" value="${eVo.discount_value}%">
							</fieldset>													
							
							<fieldset>
								<label for=""> 시작날짜 </label> 
								<input type="text" class="form-control" id="e_startdate" name="e_startdate" readonly="readonly" 
									value="<fmt:formatDate value="${eVo.e_startdate}" pattern="yyyy-MM-dd HH:mm:ss" />">
							</fieldset>							
							
							<fieldset>
								<label for=""> 종료날짜 </label> 
								<input type="text" class="form-control" id="e_discount" name="e_discount" readonly="readonly" 
									value="<fmt:formatDate value="${eVo.e_enddate}" pattern="yyyy-MM-dd HH:mm:ss" />">
							</fieldset>							
							
							<fieldset>
								<label for=""> 마스터 코드 </label> 
								<input type="text" class="form-control" id="ms_code" name="ms_code" readonly="readonly" value="${eVo.ms_code}">
							</fieldset>							
					</div>

					<div class="event_update">
						<input type="button" value="이벤트 수정"
							onclick="location.href='EventUpdate.do?e_evtcode=${eVo.e_evtcode}'">
					</div>
				</section>
				<hr>
			</form>
		</div>
	</div>
</div>
<footer></footer>