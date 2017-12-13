<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
    
<jsp:include page="header.jsp" />

	<div class="container boardNotice board">
		<div class="row">
			<div class="left_tab">
				<h2>고객센터</h2>
				<ul>
					<li><a href="userNoticeList.do">공지사항</a></li>
					<li  class="active"><a href="userReviewList.do">후기 게시판</a></li>
					<li><a href="userEventList.do">이벤트</a></li>
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
						<a href="home.do">홈</a>
						<span> > </span>
						<a href="userNoticeList.do">커뮤니티</a>
						<span> > </span>
						<a href="userReviewList.do" class="active">후기 게시판</a>
					</div>
				</h3>
				
				
				<table>
					<thead>
						<tr>
							<th>후기 코드</th>
							<th>아이디</th>
							<th>상품코드</th>
						</tr>						
					</thead>
					
					<tbody>
						<tr>
							<th>${rVo.r_rvcode}</th>
							<th>${rVo.m_userid}</th>
							<th>${rVo.f_fdcode}</th>
						</tr>			
					
						<tr>							
							<td>제&nbsp;&nbsp;목</td>
							<td>후&nbsp;&nbsp;기</td>
							<td>평&nbsp;&nbsp;점</td>							
						</tr>
						
						<tr>
							<th>${rVo.r_title}</th>
							<th>${rVo.r_rvcontents}</th>
							<th>${rVo.r_grade}</th>
						</tr>
						
						<c:if test="${not empty rVo.r_rvimgname}">
						<tr> 
							<td colspan="3">이미지명</td>
						</tr>					
						
						<tr>
							<td colspan="3"><img src="/images/${rVo.r_rvimgname}" width="400" height="400"></td>							
						</tr>
						</c:if>					
						
						<tr>
							<td colspan="2">조회수</td>
							<td colspan="2">글등록시간</td>
						</tr>
						
						<tr>
							<th colspan="2">${rVo.r_rvcount}</th>
							<th colspan="2"><fmt:formatDate value="${rVo.r_rvdate}" pattern="yyyy-MM-dd HH:mm:ss" /></th>							
						</tr>
												
						<c:if test="${not empty rVo.r_admincmt}">	
							<tr>
								<td colspan="2">관리자댓글</td>
								<td colspan="1">관리자댓글시간</td>
							</tr>				
						
							<tr>
								<td colspan="2">${rVo.r_admincmt}</td>
								<td colspan="1"><fmt:formatDate value="${rVo.r_admindate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
							</tr>
						</c:if>						
					</tbody>
				</table>
				
				<%-- <div class="pagination_wrap">
					<input type="button" value="후기 답변 등록(수정)" onclick="location.href='reviewAdminRegUpdate.do?r_rvcode=${rVo.r_rvcode}'">							
					<c:if test="${not empty rVo.r_admincmt}">
					<input type="button" value="후기 답변 삭제" onclick="location.href='reviewAdminDelete.do?r_rvcode=${rVo.r_rvcode}'">
					</c:if>	
				</div> --%>
				
			</div>
		</div>
	</div>

<jsp:include page="footer.jsp" />