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
			
			var selEventCode = document.getElementById('selEventCode').value;
			//alert("selEventCode="+selEventCode);
			
			
			var fc_1st = document.getElementById('fc_1st').value;
			var fc_2nd = document.getElementById('fc_2nd').value;
			var fc_3rd = document.getElementById('fc_3rd').value;
			
			//location.href='adminEventMgr.do?&selEventCode='+selEventCode;	
			
			var sortColumn = '${sortColumn}';
			var orderby = '${orderby }';
						
			var whereColumn = '${whereColumn }';
			var word = '${word }';
			
			var pageCutCount = '${pageCutCount }';
			
			
			
			location.href='adminEventMgr.do?sortColumn='+sortColumn+'&orderby='+orderby+'&whereColumn='+whereColumn+'&word='+word+
						'&selEventCode='+selEventCode+
						'&fc_1st='+fc_1st+'&fc_2nd='+fc_2nd+'&fc_3rd='+fc_3rd+
						'&pageCutCount='+pageCutCount;
			
		}
		
		function change_pageCutCount() {
			var selEventCode = document.getElementById('selEventCode').value;
			var pageCutCount = document.getElementById("pageCutCount").value;
			
			var sortColumn = '${sortColumn}';
			var orderby = '${orderby }';
						
			var whereColumn = '${whereColumn }';
			var word = '${word }';
			
			var fc_1st = '${fc_1st }';
			var fc_2nd = '${fc_2nd }';
			var fc_3rd = '${fc_3rd }';
			
			
			location.href='adminEventMgr.do?sortColumn='+sortColumn+'&orderby='+orderby+'&whereColumn='+whereColumn+'&word='+word+
					'&selEventCode='+selEventCode+
					'&fc_1st='+fc_1st+'&fc_2nd='+fc_2nd+'&fc_3rd='+fc_3rd+
					'&pageCutCount='+pageCutCount;
		}
		
		function doSearch() {
			var selEventCode = document.getElementById('selEventCode').value;
			var pageCutCount = document.getElementById("pageCutCount").value;
			
			var sortColumn = '${sortColumn}';
			var orderby = '${orderby }';
						
			var whereColumn = document.getElementById("whereColumn").value;
			var word = document.getElementById("word").value;
			
			var fc_1st = '${fc_1st }';
			var fc_2nd = '${fc_2nd }';
			var fc_3rd = '${fc_3rd }';
			
			
			location.href='adminEventMgr.do?sortColumn='+sortColumn+'&orderby='+orderby+'&whereColumn='+whereColumn+'&word='+word+
					'&selEventCode='+selEventCode+
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
	
	<c:if test="${empty selEventCode }">
		<c:set var="selEventCode" value="ALL" />
	</c:if>
	 

	<div class="content-wrapper">
        <div class="container-fluid">
        
        
        
    <%-- 디버그용 코드--%>
    <%-- \${selEventCode} : ${selEventCode} <br/>  
	\${pn } : ${pn }<br />
		
	\${sortColumn }: ${sortColumn } <br />
	\${orderby }: ${orderby } <br />
	
	\${fc_1st }: ${fc_1st } <br />
	\${fc_2nd }: ${fc_2nd } <br />
	\${fc_3rd }: ${fc_3rd } <br />
	
	\${pageCutCount }: ${pageCutCount } <br />
	
	\${whereColumn }: ${whereColumn } <br />
	\${word }: ${word } <br /> --%>
	<p /><p />    
       
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
                <form action="adminEventsetFood.do" method="post" name="listForm">
                
                
                	<table>
                		<tr>
		                	<td style="text-align: right; border: none;">
		                		<span class="glyphicon glyphicon-search"></span> 검색 설정 (음식 카테고리) &nbsp;&nbsp;
		                	</td>
		                	<td>
		                		<!-- 카테고리 설정 --> 		                		
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
						</tr>
						<tr>
		                	<td style="text-align: right; border: none;">
		                		<span class="glyphicon glyphicon-search"></span> 검색 설정 (음식 이름) &nbsp;&nbsp;
		                	</td>
							<td>
								<!-- 검색 처리 시작 -->
								<select name="whereColumn" id="whereColumn" onchange="change_whereColumn()">
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
								
								<input type="text" name="word" id="word" value="${word }">
								<input type="button" value="검색"  onclick="doSearch();">
								
								<!-- 검색 처리 끝 -->
							</td>
						</tr>          	
                	</table>
                
                	<br/>
                
                
                	<!-- 이벤트 설정여부 + 음식목록 리스트 출력 cellspacing="0" -->
	                <table id="listGubun" style="border:none; width:100%;">
						<tr style="border: none;">
							<td style="text-align: left; border: none;">
	                		
	                			<!-- alert(document.getElementById('selEventCode').value);  -->
	                			<label>이벤트 :</label>
			            		<select id="selEventCode" name="selEventCode" onchange="filter();">
			                    	<option value="ALL">전체</option>
			                    	<c:forEach var="eventAllList" items="${eventAllList }">
			                    		
			                    		<c:choose>
			                    		<c:when test="${selEventCode eq eventAllList.e_evtcode}">
			                    			<option value="${eventAllList.e_evtcode }" selected="selected">${eventAllList.e_nttilte }</option>
			                    		</c:when>
			                    		<c:otherwise><option value="${eventAllList.e_evtcode }">${eventAllList.e_nttilte }</option></c:otherwise>
			                    		</c:choose>
			                    	</c:forEach>
			                    </select>    	
		                	</td>
		                	
		                	<%--
		                	<!-- 카테고리 설정 -->
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
		                	--%>
		                	
		                	<!-- 게시글 수 설정 -->
		                	<td style="text-align: right; border: none;">
								
								[${eventSelFoodList.requestPage}/${eventSelFoodList.totalPageCount}] : ${totalBoardVOCount }
								
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
                
                    <div class="table-responsive">
        				<table class="table table-bordered table-hover table-condensed table-responsive" width="100%" cellspacing="0">
        					<tr>
	        					<th><input type="checkbox" id="chkall_fdcode" name="chkall_fdcode"/></th>  <!-- <th>음식코드</th> 출처: http://hellogk.tistory.com/5 [IT Code Storage] -->
								<!-- <th>이벤트 코드</th> 	 -->		
								<th>이벤트 이름</th>  			
								<th>시작일</th>  			
								<th>오늘날짜</th> 		
								<th>종료일</th>
								
								<!-- <th>음식 카테고리 코드</th> -->
								<th>음식 카테고리 이름</th>
								<th>카테고리 사용여부</th>
								<th>음식명</th>
								<th>가격</th>
								<th>음식 사용여부</th>
								<!-- <th>ms_code</th> -->
								<!-- <th>할인코드</th> -->
								<th>할인율</th>
	        				</tr>
        					
        					<c:forEach var="eventSelFoodList" items="${eventSelFoodList.listVO }">
        						<tr>
        						<td>
        							<input type="checkbox" name="chk_fdcode" value="${eventSelFoodList.f_fdcode }" />
        						</td>

								<%-- <td>${eventSelFoodList.e_evtcode }</td> --%> 			
								<td>
									<c:if test="${not empty eventSelFoodList.e_nttilte }">	
                                   		<c:choose>
                                   		<c:when test="${eventSelFoodList.e_startdate <= eventSelFoodList.today  and eventSelFoodList.today <= eventSelFoodList.e_enddate}">
                                   			<div>${eventSelFoodList.e_nttilte }</div>
                                   		</c:when>
                                   		<c:otherwise>
                                   			<div style="text-decoration:line-through; color: gray;">${eventSelFoodList.e_nttilte }</div>
                                   		</c:otherwise>
                                   		</c:choose>
                                   	</c:if>
								</td>  	
								
										
								<td>${eventSelFoodList.e_startdate }</td>  			
								<td>${eventSelFoodList.today }</td> 		
								<td>${eventSelFoodList.e_enddate }</td>
								 	
								<%-- <td>${eventSelFoodList.fc_1st } >
									${eventSelFoodList.fc_2nd } > 
									${eventSelFoodList.fc_3rd }
								</td> --%>
								<td>${eventSelFoodList.fcname_1st } >
									${eventSelFoodList.fcname_2nd } >
									${eventSelFoodList.fcname_3rd }  
								</td>
								<td>
									<c:choose>
										<c:when test="${eventSelFoodList.fc_isblock eq '0'}">사용</c:when>
										<c:otherwise>미사용</c:otherwise>
									</c:choose>
								</td>
								
								<td>${eventSelFoodList.f_foodname }</td>
								<td>${eventSelFoodList.f_price }</td>
								
								<td>
									<c:choose>
										<c:when test="${eventSelFoodList.f_isblock eq '0'}">사용</c:when>
										<c:otherwise>미사용</c:otherwise>
									</c:choose>
								</td>
								
								<%-- <td>${eventSelFoodList.ms_code }</td> --%>
								<%-- <td>${eventSelFoodList.e_discount }</td> --%>
								<td>
									<c:if test="${not empty eventSelFoodList.discount_value }">${eventSelFoodList.discount_value } %</c:if>
								</td>
								</tr>
        					</c:forEach>
        				</table>
                    </div>
                    
                    
                    <!-- 페이징 처리 -->
		                <div>
		                	<ul class="pagination pagination-sm">
		                		<c:if test="${beginPage > 10 }">
									<li class="previous">
										<a href='<c:url value="adminEventMgr.do?sortColumn=${sortColumn }&orderby=${orderby }&whereColumn=${whereColumn }&word=${word }&fc_1st=${fc_1st}&fc_2nd=${fc_2nd}&fc_3rd=${fc_3rd}&pageCutCount=${pageCutCount }&pn=${beginPage-1}"/>'>◀ 이전 </a>&nbsp;
									</li>
								</c:if>
								
								<c:forEach var="pno" begin="${beginPage}" end="${endPage}">								
									<c:choose>
										<c:when test="${pno == pn}">
											<%-- <div style="display: inline; color: red;" ><strong>${pno}</strong></div>&nbsp; --%>
											 <li class="active"><a href="#">${pno}</a></li>
										</c:when>
										<c:otherwise>								
											<li><a href='<c:url value="adminEventMgr.do?sortColumn=${sortColumn }&orderby=${orderby }&whereColumn=${whereColumn }&word=${word }&fc_1st=${fc_1st}&fc_2nd=${fc_2nd}&fc_3rd=${fc_3rd}&pageCutCount=${pageCutCount }&pn=${pno}" />'>${pno}</a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							 	
								
								<c:if test="${endPage < eventSelFoodList.totalPageCount}">
									<li class="next"><a href='<c:url value="adminEventMgr.do?sortColumn=${sortColumn }&orderby=${orderby }&whereColumn=${whereColumn }&word=${word }&fc_1st=${fc_1st}&fc_2nd=${fc_2nd}&fc_3rd=${fc_3rd}&pageCutCount=${pageCutCount }&pn=${endPage + 1}"/>'> 다음 ▶ </a></li>
								</c:if>
							</ul>
		                </div>
		                
		                <p />
		                
		               
		                <div>		
		                 	<label>이벤트 설정: </label>
		            		<select id="setEventCode" name="setEventCode" >
		            			<option value="CLEAR">설정 해제</option>
		                    	<c:forEach var="eventAllListToday" items="${eventAllListToday }">
		                    		<option value="${eventAllListToday.e_evtcode }">${eventAllListToday.e_nttilte }</option>
		                    	</c:forEach>
		                    </select>
		                    <input type="submit" value="설정" />
		                </div>
                    </form>
                    
                </div>
                <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
            </div>
        </div>
    </div>

	
	<script>
	$(document).ready(function(){
	    //최상단 체크박스 클릭
	    $("#chkall_fdcode").click(function(){
	        //클릭되었으면
	        if($("#chkall_fdcode").prop("checked")){
	            //input태그의 name이 chk_fdcode인 태그들을 찾아서 checked옵션을 true로 정의
	            $("input[name=chk_fdcode]").prop("checked",true);
	            //클릭이 안되있으면
	        }else{
	            //input태그의 name이 chk_fdcode인 태그들을 찾아서 checked옵션을 false로 정의
	            $("input[name=chk_fdcode]").prop("checked",false);
	        }
	    })
	})
	//출처: http://hellogk.tistory.com/5 [IT Code Storage]
	</script>
</body>
</html>