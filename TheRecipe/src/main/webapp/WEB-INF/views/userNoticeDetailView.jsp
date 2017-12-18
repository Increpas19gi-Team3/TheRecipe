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
					<li class="active"><a href="userNoticeList.do">공지사항</a></li>
					<li><a href="userReviewList.do">후기 게시판</a></li>
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
						<a href="userNoticeList.do" class="active">공지사항</a>
					</div>
				</h3>
				<table>
					<thead>
						<tr>
							<th colspan="1">이벤트 코드</th>
							<th colspan="5">제&nbsp;&nbsp;목</th>
							<th colspan="1">구&nbsp;&nbsp;분</th>																				
						</tr>
					</thead>
					<tbody>
						<tr>
							<td colspan="1">${nVo.e_evtcode_value}</td>
							<td colspan="5">${nVo.e_nttilte}</td>
							<td colspan="1">${nVo.e_gubun_value}</td>														
						</tr>
						
						<tr>
							<th colspan="1">작성일</th>
							<th colspan="5">내&nbsp;&nbsp;용</th>
							<td colspan="1">마스터 코드</td>	
						</tr>
						
						<tr>
							<td colspan="1">
								<fmt:formatDate value="${nVo.e_ntdate}" pattern="yyyy-MM-dd HH:mm:ss" />
							</td>
							<td colspan="5">${nVo.e_ntcontens}</td>
							<td colspan="1">${nVo.ms_code_value}</td>
						</tr>
						
						<c:if test="${not empty nVo.e_ntimgname}">
						<tr>
							<td colspan="7">이미지</td>												
						</tr>						
						
						<tr>
							<td colspan="7"> ${nVo.e_ntimgname}
								<img src="/images/${nVo.e_ntimgname}" width="400" height="400">
							</td>
						</tr>
						</c:if>											
					</tbody>
				</table>
				
				<div class="pagination_wrap">
					<div class="btn_right">
						<input type="button" value="공지사항 목록" onclick="location.href='userNoticeList.do'">												
					</div>
				</div>				
			</div>
		</div>
	</div>

<jsp:include page="footer.jsp" />