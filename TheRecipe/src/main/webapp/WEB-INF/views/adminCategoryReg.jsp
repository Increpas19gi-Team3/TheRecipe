<%--
/**
 * 관리자) 지역음식, TV 레시피 카테고리 등록 페이지
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
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href='<c:url value="/resources/css/tree.css" />' type="text/css">
	<title> (관리자) 카테고리 관리_등록 폼 </title>
	
	
	<script type="text/javascript">
		function check() {//등록값 체크			
			  if(document.getElementById("fc_ctgname").value == "") {
			    alert("값을 입력해 주세요.");
			    document.getElementById("fc_ctgname").focus();
			    return false;
			  }
			  else return true;
		}
	</script>
</head>
<body>
	<h1> 음식 코드 등록</h1>
	
	<!-- 
	<table border="1">
		<tr>
			<th>카테고리 구분</th>
			<th>메뉴 구분</th>
			<th>구성 구분</th>
			<th>설명</th>
		</tr>
	<c:forEach var="foodcode" items="${foodcodeAllList }">
		<tr>
			<td>${foodcode.fc_1st }</td>
			<td>${foodcode.fc_2nd }</td>
			<td>${foodcode.fc_3rd }</td>
			<td>${foodcode.fc_ctgname }</td>
		</tr>		
	</c:forEach>
	</table>
	-->

	
	<%-- resources 폴더 내의 이미지 호출 : <img alt="이미지" src='<c:url value="/resources/img/notice.png" />'> <br/>
	c:images 이미지 호출: <img alt="이미지3" src="/images/notice.png"> <br/> --%>
	
	<%-- 카테고리 Tree 구조 표시 --%>
	<div id="category">
	    <div class="gExplorerCtrl">
	    	등록되어 있는 음식 카테고리 &nbsp;
	        <!-- <button class="btnFirst" > <span> 처음으로 </span></button>
	        <button class="btnUp" > <span> 위로 </span></button>
	        <button class="btnDown" > <span> 아래로 </span></button>
	        <button class="btnLast" > <span> 마지막으로 </span> </button> -->
	        <button class="expend" > <span> 전체 펼침 </span></button>
	        <button class="colspend" > <span> 전체 닫음 </span></button>
	        <!-- <button class="btnAdd" > <span> 추가 </span></button>
	        <button class="btnDel" > <span> 삭제 </span> </button> -->
	    </div>
		<div class="directory">
	        <div class="root"> Root </div>
			<!-- 트리 구조로 메뉴 리스트 출력 -->
			<ul id="sdk">
			
				<!-- 대분류 -->
				<c:forEach var="foodcode1st" items="${foodcode1stList }">
					<li>
						<!-- 대분류 메뉴 출력 (블록일때 / 블록이 아닐때) -->
						<c:choose>
						<c:when test="${foodcode1st.fc_isblock eq '1'}"><a href="#" style="text-decoration:line-through; color: gray;">${foodcode1st.fc_ctgname } (${foodcode1st.regfoodcnt })</a></c:when>
						<c:otherwise><a href="#" >${foodcode1st.fc_ctgname } (${foodcode1st.regfoodcnt })</a></c:otherwise>
						</c:choose>
					
						<!-- 중분류 -->
						<ul>
						<c:forEach var="foodcode2nd" items="${foodcode2ndList }">
										
							
							<c:if test="${foodcode1st.fc_1st eq foodcode2nd.fc_1st }">
								<li>
									<!-- 중분류 메뉴 출력 (블록일때 / 블록이 아닐때) -->
									<c:choose>
									<c:when test="${foodcode2nd.fc_isblock eq '1'}"><a href="#" style="text-decoration:line-through; color: gray;">${foodcode2nd.fc_ctgname } (${foodcode2nd.regfoodcnt }) </a></c:when>
									<c:otherwise><a href="#" >${foodcode2nd.fc_ctgname } (${foodcode2nd.regfoodcnt }) </a></c:otherwise>
									</c:choose>
										
										
										<!-- 소분류 -->
										<ul>
										<c:forEach var="foodcode3rd" items="${foodcode3rdList }">
											<c:if test="${foodcode1st.fc_1st eq foodcode3rd.fc_1st 
														and foodcode2nd.fc_2nd eq foodcode3rd.fc_2nd}">
												<li>
													<!-- 소분류 메뉴 출력 (블록일때 / 블록이 아닐때) -->
													<c:choose>
													<c:when test="${foodcode3rd.fc_isblock eq '1'}"><a href="#" style="text-decoration:line-through; color: gray;">${foodcode3rd.fc_ctgname } (${foodcode3rd.regfoodcnt }) </a></c:when>
													<c:otherwise><a href="#">${foodcode3rd.fc_ctgname } (${foodcode3rd.regfoodcnt }) </a></c:otherwise>
													</c:choose>
									
												</li>
											</c:if>
										</c:forEach>
										</ul>
									
								</li>
							</c:if>
							
							
						</c:forEach>
						</ul>
						
					</li>
				</c:forEach>		
			</ul>
		</div>	
	</div>
	
	
    <p/><p/>
    <h3>신규 카테고리</h3>
    <form action="regCategory.do" method="post" onsubmit="return check();">
    
    	<label>분류</label> : 
    	<!-- <input type="radio" name="regFoodcode" value="2nd" id="sel2nd" onclick="setTextClear();"/> <label for="sel2nd">중분류</label>
    	<input type="radio" name="regFoodcode" value="3rd" id="sel3rd" onclick="setTextClear();" /> <label for="sel3rd">소분류</label>
    	<br /> -->
    	
    	<select id="fc_1st" name="fc_1st" ><!-- onclick="setAllClear();" -->
			<c:forEach var="foodcode1st" items="${foodcode1stList }">
				<option value= "${foodcode1st.fc_1st }">${foodcode1st.fc_ctgname } 요리</option>
			</c:forEach>
		</select>
		
		<strong> > </strong>
	
		<select id="fc_2nd" name="fc_2nd" ><!-- onclick="getSel2nd();" -->
			<option value="">-- 중분류 --</option>
		  	<c:forEach var="foodcode2nd" items="${foodcode2ndList }">
				<option class="${foodcode2nd.fc_1st }" value="${foodcode2nd.fc_1st }_${foodcode2nd.fc_2nd }">${foodcode2nd.fc_ctgname }</option>
			</c:forEach>
		</select>
		
		<strong> > </strong>
		
		<select id="fc_3rd" name="fc_3rd" ><!-- onclick="getSel3rd();" -->
			<option value="0">-- 소분류 --</option>
		</select>

		<br />
		
    	<label>이름</label> : <input type="text" name="fc_ctgname" id="fc_ctgname"><br />
    	<label>사용</label> : <input type="radio" name="fc_isblock" id="fc_isblock_0" value="0" checked="checked"><label for="fc_isblock_0">사용</label> &nbsp;
    							<input type="radio" name="fc_isblock" id="fc_isblock_1" value="1"> <label for="fc_isblock_1">미사용</label>
    	
		<br />
    	
    	<input type="submit" value="등록">
    	<input type="reset" value="취소">
    </form>
        

        
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>
	<script type="text/javascript" src='<c:url value="/resources/js/jquery.yakutree.js" />'></script>
	<script type="text/javascript">
		//트리구조 jQuery
		$(function(){
		    $("#sdk").yakutree({
		        unique: false,
		        animate: true,
		        duration: 100 ,
		        aTagClick : true ,
		        btnAllExpand : '.expend',
		        btnAllColspand : '.colspend',
		        btnFirst : '.btnFirst',
		        btnLast : '.btnLast',
		        btnUp : '.btnUp',
		        btnDown : '.btnDown',
		        btnAdd : '.btnAdd',
		        btnDel : '.btnDel',
		        dragndrop : false,
		        btnCallback : function ( type, $source, $target) {
		            switch( type ) {
		                case 'moveUp':
		                    //this.moveAnimation(  $source, $target, 'revert' );
		                    break;
		            }
		        }
		    });
		});
	</script>

	<!-- 반드시 하단에 있어야 함 -->
	<!-- <script src="//code.jquery.com/jquery.min.js"></script> -->
	<script src='//rawgit.com/tuupola/jquery_chained/master/jquery.chained.min.js'></script>
	<script>
		$("#fc_2nd").chained("#fc_1st");
		//$("#fc_3rd").chained("#fc_2nd");
	</script>
</body>
</html>