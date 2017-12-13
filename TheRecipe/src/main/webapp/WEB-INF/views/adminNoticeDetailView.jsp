<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
    
<jsp:include page="adminheader.jsp" />

	<div class="content-wrapper boardNotice board">
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
				<table>
					<thead>
						<tr>
							<th>이벤트 코드</th>
							<th>제&nbsp;&nbsp;목</th>
							<th>구&nbsp;&nbsp;분</th>
							<th>작성일</th>
							<th>내&nbsp;&nbsp;용</th>														
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								${nVo.e_evtcode}
							</td>
							<td> 
								${nVo.e_nttilte}
							</td>
							<td>
								${nVo.e_gubun}
							</td>
							<td>
								<fmt:formatDate value="${nVo.e_ntdate}" pattern="yyyy-MM-dd HH:mm:ss" />
							</td>
							<td>
								${nVo.e_ntcontens}
							</td>
						</tr>
						
						<c:if test="${not empty nVo.e_ntimgname}">
						<tr>
							<td colspan="5">이미지</td>												
						</tr>						
						
						<tr>
							<td colspan="5">
								${nVo.e_ntimgname}
								<img src="/images/${nVo.e_ntimgname}" width="400" height="400">
							</td>
						</tr>
						</c:if>
						
						<tr>
							<td colspan="2">할인율</td>
							<!-- <td>시작날짜</td>
							<td>종료날짜</td> -->
							<td colspan="2">마스터 코드</td>
						</tr>
						
						<tr>	
							<td colspan="2">
								${nVo.e_discount}
							</td>
							<%-- <td>
								<fmt:formatDate value="${nVo.e_startdate}" pattern="yyyy-MM-dd HH:mm:ss" />
							</td>
							<td>
								<fmt:formatDate value="${nVo.e_enddate}" pattern="yyyy-MM-dd HH:mm:ss" />
							</td> --%>							
							<td colspan="2">
								${nVo.ms_code}
							</td>
																					
						</tr>						
					</tbody>
				</table>
				
				<div class="pagination_wrap">
					<div class="btn_right">
						<input type="button" value="공지사항 목록" onclick="location.href='adminNoticeList.do'">
						<input type="button" value="공지사항 수정" onclick="location.href='adminNoticeUpdate.do?e_evtcode=${nVo.e_evtcode}'">
						<input type="button" value="공지사항 삭제" onclick="location.href='adminNoticeDelete.do?e_evtcode=${nVo.e_evtcode}'">						
					</div>
				</div>				
	</div>

