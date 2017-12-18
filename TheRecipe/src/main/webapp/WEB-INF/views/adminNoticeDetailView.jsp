<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="adminheader.jsp" />

<div class="content-wrapper boardNotice board">
	<h3>
		공지사항 상세정보
		<div class="page_locationBox">
			<a href="http://localhost:8282/therecipe/test_171129/home.jsp">홈</a>
			<span> > </span> 
			<a href="adminNoticeList.do">커뮤니티</a> 
			<span> > </span> 
			<a href="adminNoticeList.do" class="active">공지사항</a>
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
					<fmt:formatDate value="${nVo.e_ntdate}"	pattern="yyyy-MM-dd HH:mm:ss" />
				</td>
				<td colspan="5">${nVo.e_ntcontens}</td>
				<td colspan="1">${nVo.ms_code_value}</td>
			</tr>

			<c:if test="${not empty nVo.e_ntimgname}">
				<tr>
					<td colspan="7">이미지</td>
				</tr>

				<tr>
					<td colspan="7">${nVo.e_ntimgname} 
						<img src="/images/${nVo.e_ntimgname}" width="400" height="400">
					</td>
				</tr>
			</c:if>
		</tbody>
	</table>

	<div class="pagination_wrap">
		<div class="btn_right">
			<input type="button" value="공지사항 목록"
				onclick="location.href='adminNoticeList.do'"> <input
				type="button" value="공지사항 수정"
				onclick="location.href='adminNoticeUpdate.do?e_evtcode=${nVo.e_evtcode}'">
			<input type="button" value="공지사항 삭제"
				onclick="location.href='adminNoticeDelete.do?e_evtcode=${nVo.e_evtcode}'">
		</div>
	</div>
</div>

