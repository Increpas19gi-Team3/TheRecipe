<%--
/**
 * 관리자) 음식 등록 목록(대분류 > 중분류 > 소분류 선택 별로), 페이징 처리, 검색
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
    
<jsp:include page="adminheader.jsp" />

	<script type="text/javascript">
		function setAllClear() {
			document.getElementById("codeName").value = "";
			document.getElementById("sel2nd").checked="";
			document.getElementById("sel3rd").checked="";
		}
		function setTextClear() {
			document.getElementById("codeName").value = "";
		}
		
		function getSel2nd(){
			var value = $("#fc_2nd option:selected").val();
			var text = $("#fc_2nd option:selected").text();
			//alert(value + " :: " + text);
			
			document.getElementById("codeName").value = text;
			//document.getElementById("sel2nd").checked="checked";
		}
		
		function getSel3rd() {
			var value = $("#fc_3rd option:selected").val();
			var text = $("#fc_3rd option:selected").text();
			//alert(value + " :: " + text);
			
			document.getElementById("codeName").value = text;
			//document.getElementById("sel3rd").checked="checked";
		}
	</script>



	<div class="content-wrapper">
        <div class="container-fluid">
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <!-- <a href="index.html">The Recipe</a> -->
                    The Recipe
                </li>
                <li class="breadcrumb-item active">음식 등록 관리</li>
            </ol>
            <div class="card mb-3">
                <div class="card-header">
                    <i class="fa fa-table"></i> 등록 음식 목록 (이벤트도 조인 해야 될듯)</div>
                <div class="card-body">
                
                
                	<!-- 분류 코드 시작 -->
                	<select id="fc_1st" name="fc_1st" onclick="setAllClear();">
						<c:forEach var="foodcode1st" items="${foodcode1stList }">
							<option value= "${foodcode1st.fc_1st }">${foodcode1st.fc_ctgname } 요리</option>
						</c:forEach>
					</select>
					
					<strong> > </strong>
				
					<select id="fc_2nd" name="fc_2nd" onclick="getSel2nd();">
						<option value="">-- 중분류 --</option>
					  	<c:forEach var="foodcode2nd" items="${foodcode2ndList }">
							<option class="${foodcode2nd.fc_1st }" value="${foodcode2nd.fc_1st }_${foodcode2nd.fc_2nd }">${foodcode2nd.fc_ctgname }</option>
						</c:forEach>
					</select>
					
					<strong> > </strong>
					
					<select id="fc_3rd" name="fc_3rd" onclick="getSel3rd();">
						<option value="">-- 소분류 --</option>
						<c:forEach var="foodcode3rd" items="${foodcode3rdList }">
							<option class='${foodcode3rd.fc_1st }_${foodcode3rd.fc_2nd }' value='${foodcode3rd.fc_1st }_${foodcode3rd.fc_2nd }_${foodcode3rd.fc_3rd }'>${foodcode3rd.fc_ctgname }</option>
						</c:forEach>
					</select>
					
					<input type="button" value="필터적용">
                	<!-- 분류 코드 끝 -->
                
                
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                                <tr>
                                    <th>Seq.</th>
                                    <th>이벤트 코드</th>
                                    <th>대분류</th>
                                    <th>중분류</th>
                                    <th>소분류</th>
                                    
                                    <th>음식코드 이름</th>
                                    <th>음식코드 사용여부</th>
                                    
                                    <th>음식 사용여부</th>
                                    <th>음식 이름</th>
                                    <th>가격</th>
                                    <th>설명</th>
                                    <th>이미지 이름</th>
                                    <th>썸네일 이름</th>
                                    
                                </tr>
                            </thead>
                            <tbody>
                                
                                <c:forEach var="foodList" items="${foodAllList }">
                                	<tr>
                                    <td>${foodList.f_fdcode }</td>
                                    <td>${foodList.e_evtcode }</td>
                                    <td>${foodList.fc_1st }</td>
                                    <td>${foodList.fc_2nd }</td>
                                    <td>${foodList.fc_3rd }</td>
                                    
                                    <td>${foodList.fc_ctgname }</td>
                                    <td>${foodList.fc_isblock }</td>
                                    
                                    <td>${foodList.f_isblock }</td>
                                    <td>${foodList.f_foodname }</td>
                                    <td>${foodList.f_price }</td>
                                    <td>${foodList.f_explan }</td>
                                    <td>${foodList.f_imgname }</td>
                                    <td>${foodList.f_thumname }</td>
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


	        

	<!-- 반드시 하단에 있어야 함 -->
	<script src="//code.jquery.com/jquery.min.js"></script>
	<script src='//rawgit.com/tuupola/jquery_chained/master/jquery.chained.min.js'></script>
	<script>
	  $("#fc_2nd").chained("#fc_1st");
      $("#fc_3rd").chained("#fc_2nd");
	</script>
</body>
</html>