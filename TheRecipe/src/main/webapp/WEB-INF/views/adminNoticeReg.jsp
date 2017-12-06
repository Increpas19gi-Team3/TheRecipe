<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
    
<jsp:include page="adminheader.jsp" />

	<div class="container boardNotice board">
		<div class="row">
			<div class="left_tab">
				<h2>고객센터</h2>
				<ul>
					<li class="active"><a href="http://localhost:8282/therecipe/test_171129/boardNotice.jsp">공지사항</a></li>
					<li><a href="http://localhost:8282/therecipe/test_171129/boardReview.jsp">후기 게시판</a></li>
					<li><a href="http://localhost:8282/therecipe/test_171129/boardRecommend.jsp">추천 레시피</a></li>
					<li><a href="http://localhost:8282/therecipe/test_171129/boardEvent.jsp">이벤트</a></li>
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
					공지사항
					<div class="page_locationBox">
						<a href="http://localhost:8282/therecipe/test_171129/home.jsp">홈</a>
						<span> > </span>
						<a href="join.html">커뮤니티</a>
						<span> > </span>
						<a href="join.html" class="active">공지사항</a>
					</div>
				</h3>
				
				<form:form commandName="noticeCom" action="adminNoticeReg.do" method="post" enctype="multipart/form-data">				
					
				<fieldset>
					<label for="">제목</label> 
					<input type="text" id="e_nttilte" name="e_nttilte" required="제목을 입력하세요">
				</fieldset>
				
				<fieldset>
					<label for="">내용</label>
					<textarea name="e_ntcontens" id="e_ntcontens" required="내용을 입력하세요"></textarea>
				</fieldset>				
				
				<fieldset>
					<label for="">시작 날짜</label>
					<input type="date" id="e_startdate" name="e_startdate">
				</fieldset>
				
				<fieldset>
					<label for="">종료 날짜</label>
					<input type="date" id="e_enddate" name="e_enddate">
				</fieldset>				
				
				<fieldset class="fileWrap">
					<label for="" id="fileName">이미지</label>
					<div class="file-select-name" id="noFile">이미지를 선택하세요</div>
					<input type="file" id="chooseFile" name="upfile">
				</fieldset>
				
				<script>
					$('#chooseFile').bind('change',
							function() {
								var filename = $("#chooseFile").val();
								
								if (/^\s*$/.test(filename)) {
									$(".file-upload").removeClass('active');
									$("#noFile").text("No file chosen...");
								} else {
									$(".file-upload").addClass('active');
									$("#noFile").text(
											filename.replace("C:\\fakepath\\",
													""));
								}
							});
				</script>
				
				<fieldset class="btn_bottom">
					<input type="submit" value="확인"> 
					<a href="#" onClick="history.back(); return false;" class="btn_back">취소</a>
					<input type="button" value="공지사항 목록" onclick="location.href='adminNoticeList.do'">
				</fieldset>				
				
				</form:form>
			</div>
		</div>
	</div>

