<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<jsp:include page="include/header.jsp" />

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
					글수정하기
					<div class="page_locationBox">
						<a href="http://localhost:8282/therecipe/test_171129/home.jsp">홈</a>
						<span> > </span>
						<a href="#">커뮤니티</a>
						<span> > </span>
						<a href="#">후기 게시판</a>
						<span> > </span>
						<a href="#" class="active">글수정하기</a>
					</div>
				</h3>
				<form action="" class="write_form">
					<fieldset>
						<label for="">제목</label>
						<input type="text" required="">
					</fieldset>
					<fieldset>
						<label for="">내용</label>
						<textarea name="" id="" required=""></textarea>
					</fieldset>
					<fieldset class="fileWrap">
						<label for="" id="fileName">이미지</label>
						<div class="file-select-name" id="noFile">이미지를 선택하세요</div> 
						<input type="file" id="chooseFile">
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
				</form>
			</div>
		</div>
	</div>

<jsp:include page="include/footer.jsp" />