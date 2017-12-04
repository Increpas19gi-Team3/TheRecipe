<%--
/**
 * 관리자) 음식 관리 상세보기, 수정, 삭제
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

   <div class="content-wrapper">
        <div class="container-fluid">
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <a href="index.html">The Recipe</a>
                </li>
                <li class="breadcrumb-item active">음식 상세보기</li><%--  ${foodView. } --%>
            </ol>
            <div class="card card-register mx-auto mt-5">
                <div class="card-header">음식 상세보기</div>
                <div class="card-body">
                    
                    <div class="form-group">
                    <form action="modifyFoodMgr.do" method="post">
                    
                    	<input type="hidden" name ="f_fdcode" value="${foodView.f_fdcode }">
                    	<input type="hidden" name ="e_evtcode" value="${foodView.e_evtcode }">
                    	<input type="hidden" name ="fc_1st" value="${foodView.fc_1st }">
                    	<input type="hidden" name ="fc_2nd" value="${foodView.fc_2nd }">
                    	<input type="hidden" name ="fc_3rd" value="${foodView.fc_3rd }">
                    	<input type="hidden" name ="f_isblock" value="${foodView.f_isblock }">
                    	
                    	<!-- f_isblock -->
                    	<!-- ms_code -->
                    	
						<label for="">상품 카테고리 : </label>
                    	<input type="text" class="form-control" id="" readonly="readonly" value="${foodView.fcname_1st } > ${foodView.fcname_2nd } > ${foodView.fcname_3rd }">
	                    
	                    <label for="">상품 이름 : </label>
                        <input type="text" class="form-control" id="" readonly="readonly" value="${foodView.f_foodname }">
                        
                        <label for="">상품 가격 : </label>
						<input type="text" class="form-control" id="" readonly="readonly" value="${foodView.f_price }">
						<!-- <input class="form-control" id="" type="text" aria-describedby="nameHelp" placeholder="상품 가격"> -->
                        
                        <label for="">사용 여부 : </label>
						<c:choose>
							<c:when test="${foodView.f_isblock eq '0' }">
								<input type="text" class="form-control" id="" readonly="readonly" value="사용">
							</c:when>
							<c:otherwise>
								<input type="text" class="form-control" id="" readonly="readonly" value="미사용">
							</c:otherwise>
						</c:choose>		            
						
                        <label for="">상품 설명</label>
                        <textarea class="form-control" rows="5" id="f_explan" name="f_explan" readonly="readonly">${foodView.f_explan }</textarea>
                        
                        <%
                        	FoodMgrVO fmVO = (FoodMgrVO)request.getAttribute("foodView");
                        	String[] imgnameArr = fmVO.getF_imgname().split("_");
                        	String[] thumnameArr = fmVO.getF_thumname().split("_");
                        	
                        	pageContext.setAttribute("imgnameArr", imgnameArr);
                        	pageContext.setAttribute("thumnameArr", thumnameArr);
                        %>
                        
                        <!-- 상품 이미지 -->
                        <c:choose>
						<c:when test="${empty foodView.f_imgname}">
							<div class="form-group">
	                            <div class="col-md-12">
	                                <label for="">상품 이미지</label>
	                                <!-- <input class="form-control" id="" type="file" aria-describedby="nameHelp"> -->
									<img src="/therecipe/resources/images/noimg.JPG" >
	                            </div>
	                        </div>
						</c:when>
						<c:otherwise>
							<c:forEach var="imgname" items="${imgnameArr }">
								<div class="form-group">
		                            <div class="col-md-12">
		                                <label for="">상품 이미지</label>
										<img src="/images/${imgname}" >		                                
		                            </div>
		                        </div>
							</c:forEach>							
						</c:otherwise>
						</c:choose>
                        
                        <!-- 썸네일 이미지 -->
						<c:choose>
						<c:when test="${empty foodView.f_thumname}">
							<div class="form-group">
	                            <div class="col-md-12">
	                                <label for="">썸네일 이미지</label>
	                                <!-- <input class="form-control" id="" type="file" aria-describedby="nameHelp"> -->
	                                <img src="/therecipe/resources/images/noimg.JPG" >
	                            </div>
	                        </div>
						</c:when>
						<c:otherwise>
							<c:forEach var="thumimgname" items="${thumnameArr }">
								<div class="form-group">
		                            <div class="col-md-12">
		                            	<label for="">썸네일 이미지</label>
										<img src="/images/${thumimgname}" >
		                            </div>
		                        </div>
							</c:forEach>							
						</c:otherwise>
						</c:choose>    
						
						
						<br/><br/><br/><br/>
						<div class="">
                        	<button type="button" class="btn btn-primary btn-block" onclick="location.href='modifyFoodMgr.do?no=${foodView.f_fdcode}'">수정</button>
                        	<button type="button" class="btn btn-primary btn-block" onclick="location.href='adminFoodMgr.do'">목록</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>