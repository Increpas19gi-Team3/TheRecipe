<%--
/**
 * 관리자) 음식 관리 수정, 삭제
 * @author 손가연
 * 
 * 
 */
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="com.increpas.therecipe.vo.FoodMgrVO" %>

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
			

			console.log('modifyFoodMgr.do?fc_1st='+fc_1st+'&fc_2nd='+fc_2nd+'&fc_3rd='+fc_3rd+'&f_fdcode='+f_fdcode);
			
			location.href='modifyFoodMgr.do?fc_1st='+fc_1st+'&fc_2nd='+fc_2nd+'&fc_3rd='+fc_3rd+'&f_fdcode='+f_fdcode;
		}
		
		function click_2nd() {
			var fc_1st = document.getElementById('fc_1st').value;
			var fc_2nd = document.getElementById('fc_2nd').value;
			document.getElementById('fc_3rd').value = 0;
			var fc_3rd = document.getElementById('fc_3rd').value;
			

			console.log('modifyFoodMgr.do?fc_1st='+fc_1st+'&fc_2nd='+fc_2nd+'&fc_3rd='+fc_3rd+'&f_fdcode='+f_fdcode);
			
			location.href='modifyFoodMgr.do?fc_1st='+fc_1st+'&fc_2nd='+fc_2nd+'&fc_3rd='+fc_3rd+'&f_fdcode='+f_fdcode;
		}
		
		function filter() {
			var fc_1st = document.getElementById('fc_1st').value;
			var fc_2nd = document.getElementById('fc_2nd').value;
			var fc_3rd = document.getElementById('fc_3rd').value;
			var f_fdcode = '${f_fdcode }';
			
			console.log('modifyFoodMgr.do?fc_1st='+fc_1st+'&fc_2nd='+fc_2nd+'&fc_3rd='+fc_3rd+'&f_fdcode='+f_fdcode);
			
			location.href='modifyFoodMgr.do?fc_1st='+fc_1st+'&fc_2nd='+fc_2nd+'&fc_3rd='+fc_3rd+'&f_fdcode='+f_fdcode;
		}
		
	</script>

	<c:if test="${empty f_fdcode }">
		<c:set var="f_fdcode" value="${foodView.f_fdcode }" />
	</c:if>
	
	<c:if test="${empty fc_1st }">
		<c:set var="fc_1st" value="${foodView.fc_1st }" />
	</c:if>
	<c:if test="${empty fc_2nd }">
		<c:set var="fc_2nd" value="${foodView.fc_2nd }" />
	</c:if>
	<c:if test="${empty fc_3rd }">
		<c:set var="fc_3rd" value="${foodView.fc_3rd }" />
	</c:if>

	<div class="content-wrapper">
        <div class="container-fluid">
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <a href="index.html">The Recipe</a>
                </li>
                <li class="breadcrumb-item active">음식 수정</li>
            </ol>
            <div class="card card-register mx-auto mt-5">
                <div class="card-header">음식 수정</div>
                <div class="card-body">
                    
                    <div class="form-group">
                    
                    	<form:form commandName="foodModify" action="modifyFoodMgr.do" method="post" enctype="multipart/form-data">						<label for="">음식 카테고리 : ${foodView.fcname_1st } > ${foodView.fcname_2nd } > ${foodView.fcname_3rd }</label>
                    		
                    	<div>
                    		<!-- 분류 코드 시작  https://www.w3schools.com/bootstrap/bootstrap_forms_inputs.asp  -->
		                	<%-- <select id="fc_1st" name="fc_1st" onchange="click_1st(); filter();">
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
							<select id="fc_2nd" name="fc_2nd" onchange="click_2nd(); filter();">
								<option value="0">-- 중분류 --</option>
								<c:if test="${not empty foodcode2ndList }">
									<c:forEach var="foodcode2nd" items="${foodcode2ndList }">
								  		<c:choose>
								  		<c:when test="${fc_2nd eq foodcode2nd.fc_2nd }"><option class="${foodcode2nd.fc_2nd }" value="${foodcode2nd.fc_2nd }" selected="selected">${foodcode2nd.fc_ctgname }</option></c:when>
								  		<c:otherwise><option class="${foodcode2nd.fc_2nd }" value="${foodcode2nd.fc_2nd }">${foodcode2nd.fc_ctgname }</option></c:otherwise>
								  		</c:choose>
									</c:forEach>
								</c:if>
							</select>									
							<strong> > </strong>
							
							<c:set var="fc_3rd_isblock" />
							<select id="fc_3rd" name="fc_3rd" onchange="filter();">
								<option value="0">-- 소분류 --</option>
								<c:if test="${not empty foodcode3rdList }">
									<c:forEach var="foodcode3rd" items="${foodcode3rdList }">
										<c:choose>
								  		<c:when test="${fc_3rd eq foodcode3rd.fc_3rd }">
								  			<option class='${foodcode3rd.fc_3rd }' value='${foodcode3rd.fc_3rd }' selected="selected">${foodcode3rd.fc_ctgname }</option>
								  			<c:set var="fc_3rd_isblock" value="${foodcode3rd.fc_isblock }"/>
								  		</c:when>
								  		<c:otherwise><option class='${foodcode3rd.fc_3rd }' value='${foodcode3rd.fc_3rd }'>${foodcode3rd.fc_ctgname }</option></c:otherwise>
								  		</c:choose>
									</c:forEach>
								</c:if>
							</select> --%>
							<!-- 분류 코드 끝 -->
                    		
								
                    		<br/><br/>
                    		<c:if test="${not empty fc_3rd_isblock }">
	                    		<dl>
		                    		<dt><label for="">음식 카테고리 사용 여부 : 
		                    		
										
										<c:choose>
											<c:when test="${fc_3rd_isblock eq '0' }">
												사용 중
												<!-- <label class="radio-inline"><input type="radio" name="fc_isblock" checked="checked" readonly="readonly">사용</label>
												<label class="radio-inline"><input type="radio" name="fc_isblock" readonly="readonly">미사용</label> -->
											</c:when>
											<c:otherwise>
												미사용 중
												<!-- <label class="radio-inline"><input type="radio" name="fc_isblock" readonly="readonly">사용</label>
												<label class="radio-inline"><input type="radio" name="fc_isblock" checked="checked" readonly="readonly">미사용</label> -->
											</c:otherwise>
										</c:choose>
									</label></dt>
								</dl>
							</c:if>
                    	</div>
                    	
                    			            
						
	                    <br/><br/>
	                    <input type="hidden" name ="no" value="${foodView.f_fdcode }" />
	                    <input type="hidden" name ="f_fdcode" value="${foodView.f_fdcode }" />
	                    <input type="hidden" name ="e_evtcode" value="${foodView.e_evtcode }">
	                    
	                    <dl>
		                    <dt><label for="">상품 이름 : </label></dt>
                        	<dd><input type="text" class="form-control" id="f_foodname" name="f_foodname" value="${foodView.f_foodname }"></dd>
                        
                        	<dt><label for="">상품 가격 : </label></dt>
							<dd><input type="text" class="form-control" id="f_price" name="f_price" value="${foodView.f_price }"></dd>
						
                        	<dt><label for="">사용 여부 : </label></dt>
                        	<dd>
                        		<c:choose>
                        		<c:when test="${foodView.f_isblock eq '0' }">
                        			<label class="radio-inline"><input type="radio" name="f_isblock" value="0" checked="checked">사용</label>
									<label class="radio-inline"><input type="radio" name="f_isblock" value="1">미사용</label>	
                        		</c:when>
                        		<c:otherwise>
                        			<label class="radio-inline"><input type="radio" name="f_isblock" value="0">사용</label>
								<label class="radio-inline"><input type="radio" name="f_isblock" value="1" checked="checked">미사용</label>
                        		</c:otherwise>
                        		</c:choose>
                        	</dd>
                        

							<dt><label for="">상품 설명</label></dt>
                        	<dd><textarea class="form-control" rows="5" id="f_explan" name="f_explan" >${foodView.f_explan }</textarea></dd>
                        </dl>
                        	
	                        <!-- 상품 이미지 -->
	                        <div class="form-group">
		                    	<div class="col-md-12">
		                        	<label for="">상품 이미지 1</label>
		                            <input class="form-control" id="f_imgname_1" name="f_imgname_1" type="file" aria-describedby="nameHelp">
								</div>
							</div>
							
							<div class="form-group">
		                    	<div class="col-md-12">
		                        	<label for="">상품 이미지 2</label>
		                            <input class="form-control" id="f_imgname_2" name="f_imgname_2" type="file" aria-describedby="nameHelp">
								</div>
							</div>
							
							<div class="form-group">
		                    	<div class="col-md-12">
		                        	<label for="">상품 이미지 3</label>
		                            <input class="form-control" id="f_imgname_3" name="f_imgname_3" type="file" aria-describedby="nameHelp">
								</div>
							</div>
							
							<div class="form-group">
		                    	<div class="col-md-12">
		                        	<label for="">상품 이미지 4</label>
		                            <input class="form-control" id="f_imgname_4" name="f_imgname_4" type="file" aria-describedby="nameHelp">
								</div>
							</div>
							
							<div class="form-group">
		                    	<div class="col-md-12">
		                        	<label for="">상품 이미지 5</label>
		                            <input class="form-control" id="f_imgname_5" name="f_imgname_5" type="file" aria-describedby="nameHelp">
								</div>
							</div>
							
	                           
							
							
							<br/><br/><br/><br/>
							<div class="">
	                        	<button type="submit" class="btn btn-primary btn-block" onclick="">등록</button>
	                        	<button type="button" class="btn btn-primary btn-block" onclick="location.href='adminFoodMgr.do'">목록</button>
	                        </div>
                        
                        
                    </form:form>
                </div>
            </div>
        </div>
    </div>
   </div>


	<!-- 반드시 하단에 있어야 함 -->
	<!-- <script src="//code.jquery.com/jquery.min.js"></script> -->
	<!-- <script src='//rawgit.com/tuupola/jquery_chained/master/jquery.chained.min.js'></script>
	<script>
	  $("#fc_2nd").chained("#fc_1st");
      $("#fc_3rd").chained("#fc_2nd");
	</script> -->
	
</body>
</html>