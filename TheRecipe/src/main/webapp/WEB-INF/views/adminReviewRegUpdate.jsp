<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
    
<jsp:include page="adminheader.jsp" />

	<div class="content-wrapper write_form">
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
				
				<form action="adminReviewRegUpdate.do" method="post">				
					
					<fieldset>
						<label for=""> 관리자댓글 </label> 
						<input type="text" class="form-control" id="r_admincmt" name="r_admincmt">
					</fieldset>	
						
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
					<input type="button" value="후기 목록" onclick="location.href='adminReviewList.do'">
				</fieldset>				
			</form>
		</div>

