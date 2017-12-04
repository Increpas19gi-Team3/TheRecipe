<%--
/**
 * 관리자) 음식 등록 목록(대분류 > 중분류 > 소분류 선택 별로), 페이징 처리, 검색
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

	<script type="text/javascript">
				
	</script>

	
	
	 

	<div class="content-wrapper">
        <div class="container-fluid">
        
        
        
    	<%-- 디버그용 코드
	\${pn } : ${pn }<br />
		
	\${sortColumn }: ${sortColumn } <br />
	\${orderby }: ${orderby } <br />
	
	\${fc_1st }: ${fc_1st } <br />
	\${fc_2nd }: ${fc_2nd } <br />
	\${fc_3rd }: ${fc_3rd } <br />
	
	\${pageCutCount }: ${pageCutCount } <br />
	
	\${whereColumn }: ${whereColumn } <br />
	\${word }: ${word } <br />
	<p /><p />    
     --%>	    
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <!-- <a href="index.html">The Recipe</a> -->
                    The Recipe
                </li>
                <li class="breadcrumb-item active">이벤트 설정 관리</li>
            </ol>
            <div class="card mb-3">
                <div class="card-header">
                    <i class="fa fa-table"></i> 설정 이벤트 목록</div>
                
                <div class="card-body" style="text-align: center;">
                <form action="adminFoodMgr.do" method="post" name="listForm">
                
                	<div class="">                	
	                	
                	</div>
                
                	
                    <div class="table-responsive">
        				<table class="table table-bordered table-hover table-condensed table-responsive" width="100%" cellspacing="0">
        					<tr>
	        					<th>이벤트 코드</th>
	        					<th>이벤트 이름</th>
	        					<th>시작일</th>
	        					<th>오늘날짜</th>
	        					<th>종료일</th>
	        					<th>할인 값</th>
	        				</tr>
        					
        					<c:forEach var="eventAllList" items="${eventAllList }">
        						<tr>
								<td>${eventAllList.e_evtcode }</td>  			
								<td>${eventAllList.e_nttilte }</td> 			
								<td>${eventAllList.e_startdate }</td>  			
								<td>${eventAllList.today }</td>  			
								<td>${eventAllList.e_enddate }</td>  			
								<td>${eventAllList.discount_value } %</td>
								</tr>
        					</c:forEach>
        				</table>
        				
        				                
                      
                    </div>
                    
                    </form>
                    
                </div>
                <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
            </div>
        </div>
    </div>

	

</body>
</html>