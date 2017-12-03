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
		function change_whereColumn(){
			document.listForm.word.value = "";
		}
		
		function click_1st() {
			var fc_1st = document.getElementById('fc_1st').value;
			document.getElementById('fc_2nd').value = 0;
			var fc_2nd = document.getElementById('fc_2nd').value;
			document.getElementById('fc_3rd').value = 0;
			var fc_3rd = document.getElementById('fc_3rd').value;
		}
		
		function click_2nd() {
			var fc_1st = document.getElementById('fc_1st').value;
			var fc_2nd = document.getElementById('fc_2nd').value;
			document.getElementById('fc_3rd').value = 0;
			var fc_3rd = document.getElementById('fc_3rd').value;
		}
		
		function filter() {
			var fc_1st = document.getElementById('fc_1st').value;
			var fc_2nd = document.getElementById('fc_2nd').value;
			var fc_3rd = document.getElementById('fc_3rd').value;
			
			var sortColumn = '${sortColumn}';
			var orderby = '${orderby }';
						
			var whereColumn = '${whereColumn }';
			var word = '${word }';
			
			var pageCutCount = '${pageCutCount }';
			
			/* console.log('sortColumn='+sortColumn+'&orderby='+orderby+'&whereColumn='+whereColumn+'&word='+word+
				'&fc_1st='+fc_1st+'&fc_2nd='+fc_2nd+'&fc_3rd='+fc_3rd+
				'&pageCutCount='+pageCutCount); */
			
			location.href='adminFoodMgr.do?sortColumn='+sortColumn+'&orderby='+orderby+'&whereColumn='+whereColumn+'&word='+word+
						'&fc_1st='+fc_1st+'&fc_2nd='+fc_2nd+'&fc_3rd='+fc_3rd+
						'&pageCutCount='+pageCutCount;
		}
		
		function change_pageCutCount() {
			var pageCutCount = document.getElementById("pageCutCount").value;
			
			var sortColumn = '${sortColumn}';
			var orderby = '${orderby }';
						
			var whereColumn = '${whereColumn }';
			var word = '${word }';
			
			var fc_1st = '${fc_1st }';
			var fc_2nd = '${fc_2nd }';
			var fc_3rd = '${fc_3rd }';
			
			location.href='adminFoodMgr.do?sortColumn='+sortColumn+'&orderby='+orderby+'&whereColumn='+whereColumn+'&word='+word+
					'&fc_1st='+fc_1st+'&fc_2nd='+fc_2nd+'&fc_3rd='+fc_3rd+
					'&pageCutCount='+pageCutCount;
		}	
		
		
		
	</script>

	<c:if test="${empty pageCutCount }">
		<c:set var="pageCutCount" value="5" />
	</c:if>
	
		
	<c:if test="${empty fc_1st }">
		<c:set var="fc_1st" value="1" />
	</c:if>
	<c:if test="${empty fc_2nd }">
		<c:set var="fc_2nd" value="0" />
	</c:if>
	<c:if test="${empty fc_3rd }">
		<c:set var="fc_3rd" value="0" />
	</c:if>

	
	 

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
                <li class="breadcrumb-item active">음식 등록 관리</li>
            </ol>
            <div class="card mb-3">
                <div class="card-header">
                    <i class="fa fa-table"></i> 등록 음식 목록</div>
                
                <div class="card-body" style="text-align: center;">
                <form action="adminFoodMgr.do" method="post" name="listForm">
                
                	<div class="">                	
	                	<table id="listGubun" style="border: none;" width="100%" cellspacing="0">
	                	<!-- <table class="table table-bordered table-hover table-condensed table-responsive"> -->
							<tr style="border: none;">
								<td style="text-align: left; border: none;">
												
									<!-- 분류 코드 시작 -->
				                	<!-- https://www.w3schools.com/bootstrap/bootstrap_forms_inputs.asp -->
				                	<select id="fc_1st" name="fc_1st" onchange="click_1st(); filter();">
										<c:if test="${not empty foodcode1stList }">
											<c:forEach var="foodcode1st" items="${foodcode1stList }">											
												<c:choose>
												<c:when test="${fc_1st eq foodcode1st.fc_1st }"><option value= "${foodcode1st.fc_1st }" selected="selected">${foodcode1st.fc_ctgname } 요리</option></c:when>
												<c:otherwise><option value= "${foodcode1st.fc_1st }">${foodcode1st.fc_ctgname } 요리</option></c:otherwise>
												</c:choose>											
											</c:forEach>
										</c:if>
									</select>									
									<strong> > </strong>				
									<!-- onclick="getSel2nd();" -->				
									<select id="fc_2nd" name="fc_2nd" onchange="click_2nd(); filter();">
										<!-- <option value="">-- 중분류 --</option> -->
										<option value="0">-- 중분류 --</option>
										<c:if test="${not empty foodcode2ndList }">
											<c:forEach var="foodcode2nd" items="${foodcode2ndList }">
										  		\${fc_2nd eq foodcode2nd.fc_2nd } : ${fc_2nd eq foodcode2nd.fc_2nd } <Br/>
										  		\${foodcode2nd.fc_2nd } : ${foodcode2nd.fc_2nd }
										  		<c:choose>
										  		<c:when test="${fc_2nd eq foodcode2nd.fc_2nd }"><option class="${foodcode2nd.fc_1st }" value="${foodcode2nd.fc_1st }_${foodcode2nd.fc_2nd }" selected="selected">${foodcode2nd.fc_ctgname }</option></c:when>
										  		<c:otherwise><option class="${foodcode2nd.fc_1st }" value="${foodcode2nd.fc_1st }_${foodcode2nd.fc_2nd }">${foodcode2nd.fc_ctgname }</option></c:otherwise>
										  		</c:choose>
											</c:forEach>
										</c:if>
									</select>									
									<strong> > </strong>				
									<!-- onclick="getSel3rd();" -->					
									<select id="fc_3rd" name="fc_3rd" onchange="filter();">
										<option value="0">-- 소분류 --</option>
										<c:if test="${not empty foodcode3rdList }">
											<c:forEach var="foodcode3rd" items="${foodcode3rdList }">
												\${fc_3rd eq foodcode3rd.fc_3rd } : ${fc_3rd eq foodcode3rd.fc_3rd } <Br/>
										  		\${foodcode3rd.fc_3rd } : ${foodcode3rd.fc_3rd }
										  		
										  		<c:choose>
										  		<c:when test="${fc_3rd eq foodcode3rd.fc_3rd }"><option class='${foodcode3rd.fc_1st }_${foodcode3rd.fc_2nd }' value='${foodcode3rd.fc_1st }_${foodcode3rd.fc_2nd }_${foodcode3rd.fc_3rd }' selected="selected">${foodcode3rd.fc_ctgname }</option></c:when>
										  		<c:otherwise><option class='${foodcode3rd.fc_1st }_${foodcode3rd.fc_2nd }' value='${foodcode3rd.fc_1st }_${foodcode3rd.fc_2nd }_${foodcode3rd.fc_3rd }'>${foodcode3rd.fc_ctgname }</option></c:otherwise>
										  		</c:choose>
											</c:forEach>
										</c:if>
									</select>
									<!-- 분류 코드 끝 -->
									
								</td>
								<td style="text-align: right; border: none;">
								
									<%-- ${listModel.startRow}-${listModel.endRow} --%>
									[${foodList.requestPage}/${foodList.totalPageCount}]
									
									<select name = "pageCutCount" id = "pageCutCount" onchange="change_pageCutCount();">
									
										<c:choose>
											<c:when test="${pageCutCount eq '5' }"><option value="5" selected="selected">5개 보기</option></c:when>
											<c:otherwise><option value="5">5개 보기</option></c:otherwise>
										</c:choose>
										<c:choose>		
											<c:when test="${pageCutCount eq '10' }"><option value="10" selected="selected">10개 보기</option></c:when>
											<c:otherwise><option value="10">10개 보기</option></c:otherwise>
										</c:choose>
										<c:choose>		
											<c:when test="${pageCutCount eq '20' }"><option value="20" selected="selected">20개 보기</option></c:when>
											<c:otherwise><option value="20">20개 보기</option></c:otherwise>
										</c:choose>
										
									</select>				
								</td>
							</tr>
						</table>
                	</div>
                
                	
                    <div class="table-responsive">
                        <!-- <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0"> -->
                        <table class="table table-bordered table-hover table-condensed table-responsive" width="100%" cellspacing="0">
                            <thead>
                                <tr>
                                    <th>상품코드</th>
                                    <th>이벤트 이름</th>
                                    <th colspan="3">카테고리</th>
                                    <th>카테고리 사용여부</th>
                                    
                                    <th>
                                    	<c:choose>
											<c:when test="${sortColumn eq 'FOODNAME'}"><!-- 음식 이름 일때 -->
												<c:choose>
													<c:when test="${orderby eq 'ASC' }">
														<a href="adminFoodMgr.do?sortColumn=FOODNAME&orderby=DESC&whereColumn=${whereColumn }&word=${word }
															&fc_1st=${fc_1st}&fc_2nd=${fc_2nd}&fc_3rd=${fc_3rd}&pageCutCount=${pageCutCount }">음식 이름 ▲</a>		
													</c:when>
													<c:otherwise>
														<a href="adminFoodMgr.do?sortColumn=FOODNAME&orderby=ASC&whereColumn=${whereColumn }&word=${word }
															&fc_1st=${fc_1st}&fc_2nd=${fc_2nd}&fc_3rd=${fc_3rd}&pageCutCount=${pageCutCount }">음식 이름 ▼</a>
													</c:otherwise>
												</c:choose>
											</c:when>
											<c:otherwise><!-- 작성일 정렬이 아닐 때 -->
												<a href="adminFoodMgr.do?sortColumn=FOODNAME&orderby=ASC&whereColumn=${whereColumn }&word=${word }
													&fc_1st=${fc_1st}&fc_2nd=${fc_2nd}&fc_3rd=${fc_3rd}&pageCutCount=${pageCutCount }">음식 이름 ▼</a>
											</c:otherwise>
										</c:choose>
                                    </th>
                                    <th>음식 사용여부</th>
                                    <th>
                                    	<c:choose>
											<c:when test="${sortColumn eq 'PRICE'}"><!-- 가격 일때 -->
												<c:choose>
													<c:when test="${orderby eq 'ASC' }">
														<a href="adminFoodMgr.do?sortColumn=PRICE&orderby=DESC&whereColumn=${whereColumn }&word=${word }
															&fc_1st=${fc_1st}&fc_2nd=${fc_2nd}&fc_3rd=${fc_3rd}&pageCutCount=${pageCutCount }">가격 ▲</a>		
													</c:when>
													<c:otherwise>
														<a href="adminFoodMgr.do?sortColumn=PRICE&orderby=ASC&whereColumn=${whereColumn }&word=${word }
															&fc_1st=${fc_1st}&fc_2nd=${fc_2nd}&fc_3rd=${fc_3rd}&pageCutCount=${pageCutCount }">가격 ▼</a>
													</c:otherwise>
												</c:choose>
											</c:when>
											<c:otherwise><!-- 작성일 정렬이 아닐 때 -->
												<a href="adminFoodMgr.do?sortColumn=PRICE&orderby=ASC&whereColumn=${whereColumn }&word=${word }
													&fc_1st=${fc_1st}&fc_2nd=${fc_2nd}&fc_3rd=${fc_3rd}&pageCutCount=${pageCutCount }">가격 ▼</a>
											</c:otherwise>
										</c:choose>
                                    
                                    </th>
                                    
                                </tr>
                            </thead>
                            <tbody>
                                
                                <c:forEach var="foodList" items="${foodList.listVO }">
                                	<tr>
                                    <td>${foodList.f_fdcode }</td>
                                    <td>
                                    	<c:choose>
                                    	<c:when test="${not empty foodList.e_nttilte }">
                                    		
                                    		<c:choose>
                                    		<c:when test="${foodList.e_startdate <= foodList.today  and foodList.today <= foodList.e_enddate}">
                                    			<div>${foodList.e_nttilte }</div>
                                    		</c:when>
                                    		<c:otherwise>
                                    			<div style="text-decoration:line-through; color: gray;">${foodList.e_nttilte }</div>
                                    		</c:otherwise>
                                    		</c:choose>
                                    	</c:when>
                                    	<c:otherwise></c:otherwise>
                                    	</c:choose>
                                    
                                    	<!--   -->
                                    </td>
                                    <td colspan="3">${foodList.fcname_1st } > ${foodList.fcname_2nd } > ${foodList.fcname_3rd }</td>
                                    <td>
                                    	<c:choose>
                                   		<c:when test="${foodList.fc_isblock eq '0'}">사용</c:when>
                                   		<c:otherwise>미사용</c:otherwise>
                                    	</c:choose>
                                    </td>
                                    
                                    <!-- 음식명에 상세보기 링크 -->
                                    <td>                                    
                                    	<a href="adminFoodView.do?no=${foodList.f_fdcode }"> 
											${foodList.f_foodname }
										</a>
                                    </td>
                                    
                                    
                                    <td>
                                    	<c:choose>
                                   		<c:when test="${foodList.f_isblock eq '0'}">사용</c:when>
                                   		<c:otherwise>미사용</c:otherwise>
                                    	</c:choose>
                                    </td>
                                    <td>${foodList.f_price }</td>
                                </tr>
                                </c:forEach>
                                
                                
                                
                            </tbody>
                        </table>
                        
                        <!-- 양끝에 글쓰기 버튼 -->
                        <div>
                        	<!-- 양 끝에 글등록 링크 위치 -->
							<table style="border: none;" width="100%" cellspacing="0">
								<tr style="border: none;">
									<td style="text-align: left; border: none;">
										<!-- <input type="button" value="글 쓰기" onclick="location.href=''" /> -->
										<button type="button" class="btn btn-primary btn-sm" onclick="location.href='regFoodMgr.do'">음식 등록</button>
									</td>
									<td style="text-align: right; border: none;">
										<!-- <input type="button" value="글 쓰기" onclick="location.href='regFoodMgr.do'" /> -->
										<button type="button" class="btn btn-primary btn-sm" onclick="location.href='regFoodMgr.do'">음식 등록</button>	
									</td>
								</tr>
							</table>
		                </div>
		                
		                
		                
		                
		                <!-- 페이징 처리 -->
		                <div>
		                	<ul class="pagination pagination-sm">
		                		<c:if test="${beginPage > 10 }">
									<li class="previous">
										<a href='<c:url value="adminFoodMgr.do?sortColumn=${sortColumn }&orderby=${orderby }&whereColumn=${whereColumn }&word=${word }&fc_1st=${fc_1st}&fc_2nd=${fc_2nd}&fc_3rd=${fc_3rd}&pageCutCount=${pageCutCount }&pn=${beginPage-1}"/>'>◀ 이전 </a>&nbsp;
									</li>
								</c:if>
								
								<c:forEach var="pno" begin="${beginPage}" end="${endPage}">								
									<c:choose>
										<c:when test="${pno == pn}">
											<%-- <div style="display: inline; color: red;" ><strong>${pno}</strong></div>&nbsp; --%>
											 <li class="active"><a href="#">${pno}</a></li>
										</c:when>
										<c:otherwise>								
											<li><a href='<c:url value="adminFoodMgr.do?sortColumn=${sortColumn }&orderby=${orderby }&whereColumn=${whereColumn }&word=${word }&fc_1st=${fc_1st}&fc_2nd=${fc_2nd}&fc_3rd=${fc_3rd}&pageCutCount=${pageCutCount }&pn=${pno}" />'>${pno}</a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							 	
								
								<c:if test="${endPage < foodList.totalPageCount}">
									<li class="next"><a href='<c:url value="adminFoodMgr.do?sortColumn=${sortColumn }&orderby=${orderby }&whereColumn=${whereColumn }&word=${word }&fc_1st=${fc_1st}&fc_2nd=${fc_2nd}&fc_3rd=${fc_3rd}&pageCutCount=${pageCutCount }&pn=${endPage + 1}"/>'> 다음 ▶ </a></li>
								</c:if>
							</ul>
		                </div>
		                
		                <p /><p />
		                
		                
		                <!-- 검색 처리 -->
		                <div>		
							<select name="whereColumn" onchange="change_whereColumn()">
								<c:choose>
									<c:when test="${not empty whereColumn }">
										
										<c:choose>
											<c:when test="${whereColumn eq 'ALL'}">
												<option value="ALL" selected="selected">전체검색</option>
												<option value="FOODNAME" >음식이름</option>
											</c:when>
											<c:when test="${whereColumn eq 'FOODNAME'}">
												<option value="ALL">전체검색</option>
												<option value="FOODNAME" selected="selected">음식이름</option>
											</c:when>
										</c:choose>
									
									</c:when>
									<c:otherwise>
										<option value="ALL">전체검색</option>
										<option value="FOODNAME" >음식이름</option>
									</c:otherwise>
								</c:choose>
							</select>
							
							<input type="text" name="word" value="${word }">
							<input type="submit" value="검색">
		                </div>
                    </div>
                    
                    </form>
                    
                </div>
                <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
            </div>
        </div>
    </div>

	

</body>
</html>