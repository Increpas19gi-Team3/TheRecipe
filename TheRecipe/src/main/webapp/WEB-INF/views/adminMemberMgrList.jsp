<%--
/**
 * 관리자) 회원관리 페이지
 * @author 손가연
 * 
 * 차후, 업버전내역
 * select - option : bootstrap3 버전으로 변환 : https://www.w3schools.com/bootstrap/bootstrap_forms_inputs.asp 
 */
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<%
	//브라우저 캐싱 X 
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.addHeader("Cache-Control", "no-store");
	response.setDateHeader("Expires", 1L);
%>


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1">
    
<jsp:include page="adminheader.jsp" />

	 

	<div class="content-wrapper">
        <div class="container-fluid">  
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    The Recipe
                </li>
                <li class="breadcrumb-item active">회원 설정 관리</li>
            </ol>
            <div class="card mb-3">
                <div class="card-header">
                    <i class="fa fa-table"></i> 회원 목록
                    	( ${sessionScope.m_userid } / ${sessionScope.m_level } )
                </div>
                
                <div class="card-body">
                	<div class="table-responsive">
        				<!-- <table class="table table-bordered table-hover table-condensed table-responsive" width="100%" cellspacing="0"> -->
        				<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
        					<thead>
	        					<tr>
		        					<th>관리자 설정</th>
									<th>회원 구분</th>  			
									<th>아이디</th>  			
									<th>이름</th> 		
									<th>메일주소</th>
									<th>전화번호</th>
									<th>권한레벨</th>
		        				</tr>
	        				</thead>
	        				<tbody>
	        					<c:forEach var="list" items="${list }">
	        					<tr>
	        						<td>
	        							<c:if test="${sessionScope.m_level eq '1' }">
	        								<c:if test="${sessionScope.m_userid ne list.m_userid }">
	        								
	        									<c:choose>
	        										<c:when test="${list.m_level eq '2' }">
	        											<input type="button" value="해제" onclick="location.href='adminMemberSet.do?targetId=${list.m_userid }&targetCode=0'">
	        										</c:when>
	        										<c:otherwise>
	        											<input type="button" value="설정"  onclick="location.href='adminMemberSet.do?targetId=${list.m_userid }&targetCode=2'">
	        										</c:otherwise>
	        									</c:choose>
	        								</c:if>
	        							</c:if>
	        						</td>
									<td>${list.gubun } </td>
									<td>${list.m_userid }</td>  			
									<td>${list.m_name }</td> 		
									<td>${list.m_email }</td>								
									<td>${list.m_phone }</td>
									<td>${list.m_level }</td>
								</tr>
	        					</c:forEach>
	        				</tbody>
        				</table>
                    </div>
                    
                </div>
                <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
            </div>
        </div>
    </div>

</body>
</html>