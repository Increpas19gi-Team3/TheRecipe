<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="header.jsp" />

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
						<a href="home.do">홈</a>
						<span> > </span>
						<a href="#">커뮤니티</a>
						<span> > </span>
						<a href="ReviewList.do">후기 게시판</a>
						<span> > </span>
						<a href="#" class="active">글쓰기</a>
					</div>
				</h3>
				<form:form action="reviewWrite.do" class="write_form" commandName="reviewWr" >
					<input type="hidden" name="f_fdcode" value="${f_fdcode}">
					<fieldset>
						<label for="">제목</label>
						<input type="text" name="r_title" required="">
					</fieldset>
					<fieldset>
						<label for="">내용</label>
						<textarea name="r_rvcontents" id="" required=""></textarea>
					</fieldset>
					<fieldset>
						<label for="">평점</label>
						<select name="r_grade" id="r_grade">
						<option value="1">1점</option>
						<option value="2">2점</option>
						<option value="3">3점</option>
						<option value="4">4점</option>
						<option value="5">5점</option>
						</select>
						
					</fieldset>
					<fieldset class="fileWrap">
						<label for="" id="fileName">이미지</label>
						<div class="file-select-name" id="noFile">이미지를 선택하세요</div> 
						<input type="file" id="chooseFile" name="r_rvimgname">
					</fieldset>
					<script>
						$('#chooseFile').bind('change', function () {
							var filename = $("#chooseFile").val();
							if (/^\s*$/.test(filename)) {
								$(".file-upload").removeClass('active');
								$("#noFile").text("No file chosen..."); 
							}
							else {
								$(".file-upload").addClass('active');
								$("#noFile").text(filename.replace("C:\\fakepath\\", "")); 
							}
						});
					

					</script>
					<fieldset class="btn_bottom">
						<input type="submit" value="확인">
						<a href="#" onClick="history.back(); return false;" class="btn_back">취소</a>
					</fieldset>
				</form:form>
			</div>
		</div>
	</div>
	<script>
	function write() {
		if(!confirm('주문하시겠습니까')){ 
				
				return false;
		}else{
				location.href='orderWrite.do';
			}
			
		}
</script>

<jsp:include page="footer.jsp" />