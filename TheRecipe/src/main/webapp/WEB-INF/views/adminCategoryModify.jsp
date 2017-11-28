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
	<title> (관리자) 카테고리 관리_수정 폼 </title>
	
	
	<script type="text/javascript">
		function setAllClear() {
			document.getElementById("fc_ctgname").value = "";
			document.getElementById("sel2nd").checked="";
			document.getElementById("sel3rd").checked="";
		}
		function setTextClear() {
			document.getElementById("fc_ctgname").value = "";
		}
		
		function getSel2nd(){
			var value = $("#fc_2nd option:selected").val();
			var text = $("#fc_2nd option:selected").text();
			//alert(value + " :: " + text);
			
			document.getElementById("fc_ctgname").value = text;
			//document.getElementById("sel2nd").checked="checked";
		}
		
		function getSel3rd() {
			var value = $("#fc_3rd option:selected").val();
			var text = $("#fc_3rd option:selected").text();
			//alert(value + " :: " + text);
			
			document.getElementById("fc_ctgname").value = text;
		}
		
		function check() {//등록값 체크
			var fc_2nd = document.getElementById("fc_2nd");
			var fc_ctgname = document.getElementById("fc_ctgname");
			
			
			if(fc_2nd.value == "" || fc_ctgname.value == "" ) {
				  					
				if(fc_2nd.value == ""){
					alert("분류를 선택해주세요.");
					fc_2nd.focus();	
				}
					
				if(fc_ctgname.value == ""){
					alert("값을 입력해 주세요.");
					fc_ctgname.focus();	
				}
				
			    return false;
			    
			  }
			else return true;
		}
		
		/* 
		// 삭제 버튼 : isblock 으로 처리함
		function goDelete() {
			alert("goDelete call!!");
			//location.href='deleteCategory.do?fc_1st=${foodcode1st.fc_1st }&fc_2nd=${foodcode2nd.fc_2nd }&fc_3rd=${foodcode3rd.fc_3rd }'
			
			var fc_1st = document.getElementById("fc_1st");
			var fc_2nd = document.getElementById("fc_2nd");
			var fc_3rd = document.getElementById("fc_3rd");
			var fc_ctgname = document.getElementById("fc_ctgname");
			
			if(fc_2nd.value == "") {
				  					
				if(fc_2nd.value == ""){
					alert("중분류를 선택해주세요.");
					fc_2nd.focus();	
				}
				
			    return false;
			    
			}else{ 
			
				location.href='deleteCategory.do?fc_1st='+fc_1st.value+'&fc_2nd='+fc_2nd.value+'&fc_3rd='+fc_3rd.value;
				return true;
			}
			
			

			/
			return true;
			출처: http:/develop88.tistory.com/entry/자바스크립트로-각종-값넘기는방법 [왕 Blog] /
			//location.href='list.do?sortColumn='+sortColumn+'&orderby='+orderby+'&whereColumn='+whereColumn+'&word='+word+'&isBlock='+isBlock+'&pageCutCount='+pageCutCount;
		} */
		
	</script>
</head>
<body>
	<h1> 음식 코드 수정 / 삭제 </h1>
	
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
						
						<c:when test="${foodcode1st.fc_isblock eq '1'}"><div style="text-decoration:line-through; color: gray; display: inline;">&nbsp;&nbsp;&nbsp;${foodcode1st.fc_ctgname } (${foodcode1st.regfoodcnt })</div></c:when>
						<c:otherwise><div style="display: inline;">&nbsp;&nbsp;&nbsp;${foodcode1st.fc_ctgname } (${foodcode1st.regfoodcnt })</div></c:otherwise>
						
						<%-- <c:when test="${foodcode1st.fc_isblock eq '1'}"><a href="#" style="text-decoration:line-through; color: gray;">${foodcode1st.fc_ctgname } (${foodcode1st.regfoodcnt })</a></c:when>
						<c:otherwise><a href="#" >${foodcode1st.fc_ctgname } (${foodcode1st.regfoodcnt })</a></c:otherwise> --%>
						</c:choose>

					
						<!-- 중분류 -->
						<ul>
						<c:forEach var="foodcode2nd" items="${foodcode2ndList }">
										
							
							<c:if test="${foodcode1st.fc_1st eq foodcode2nd.fc_1st }">
								<li>
									<!-- 중분류 메뉴 출력 (블록일때 / 블록이 아닐때) -->
									<c:choose>
									
									<c:when test="${foodcode2nd.fc_isblock eq '1'}"><div style="text-decoration:line-through; color: gray; display: inline;">&nbsp;&nbsp;&nbsp;${foodcode2nd.fc_ctgname } (${foodcode2nd.regfoodcnt }) </div></c:when>
									<c:otherwise><div style="display: inline;">&nbsp;&nbsp;&nbsp;${foodcode2nd.fc_ctgname } (${foodcode2nd.regfoodcnt }) </div></c:otherwise>
									
									<%-- <c:when test="${foodcode2nd.fc_isblock eq '1'}"><a href="#" style="text-decoration:line-through; color: gray;">${foodcode2nd.fc_ctgname } (${foodcode2nd.regfoodcnt }) </a></c:when>
									<c:otherwise><a href="#" >${foodcode2nd.fc_ctgname } (${foodcode2nd.regfoodcnt }) </a></c:otherwise> --%>
									</c:choose>
																										
										
										<!-- 소분류 -->
										<ul>
										<c:forEach var="foodcode3rd" items="${foodcode3rdList }">
											<c:if test="${foodcode1st.fc_1st eq foodcode3rd.fc_1st 
														and foodcode2nd.fc_2nd eq foodcode3rd.fc_2nd}">
												<li>
													<!-- 소분류 메뉴 출력 (블록일때 / 블록이 아닐때) -->
													<c:choose>
													
													<c:when test="${foodcode3rd.fc_isblock eq '1'}"><div style="text-decoration:line-through; color: gray; display: inline;">&nbsp;&nbsp;&nbsp;${foodcode3rd.fc_ctgname } (${foodcode3rd.regfoodcnt }) </div></c:when>
													<c:otherwise><div style="display: inline;">&nbsp;&nbsp;&nbsp;${foodcode3rd.fc_ctgname } (${foodcode3rd.regfoodcnt }) </div></c:otherwise>
													
													<%-- <c:when test="${foodcode3rd.fc_isblock eq '1'}"><a href="#" style="text-decoration:line-through; color: gray;">${foodcode3rd.fc_ctgname } (${foodcode3rd.regfoodcnt }) </a></c:when>
													<c:otherwise><a href="#">${foodcode3rd.fc_ctgname } (${foodcode3rd.regfoodcnt }) </a></c:otherwise> --%>
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
	
	
	<input type="button" value="test" onclick="check();">
	
	<p/><p/>
	<h3>수정 카테고리</h3>
	<!-- modifyCategory.do -->
	<form action="" method="post" onsubmit="return check();">
		<label>분류</label> :
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
		
    	<!-- <label> 신규 등록카테고리 구분</label> : 
    	<input type="radio" name="regFoodcode" value="2nd" id="sel2nd" onclick="setTextClear();"/> <label for="sel2nd">중분류</label>
    	<input type="radio" name="regFoodcode" value="3rd" id="sel3rd" onclick="setTextClear();" /> <label for="sel3rd">소분류</label> -->
    
    	<br />
    
    	<label>이름</label> : <input type="text" name="fc_ctgname" id="fc_ctgname"><br />
    	<label>사용</label> : <input type="radio" name="fc_isblock" id="fc_isblock_0" value="0" checked="checked"><label for="fc_isblock_0">사용</label> &nbsp;
    							<input type="radio" name="fc_isblock" id="fc_isblock_1" value="1"> <label for="fc_isblock_1">미사용</label>
    	<br />
		<input type="submit" value="수정" >
    	<%-- <input type="button" value="삭제" onclick="goDelete();"> 삭제는 isblock 으로 처리함--%>
    	<input type="reset" >
    </form>
        
<%--        
<input type="button" value="수정" onclick="location.href='../admin/admin_Movie.do?CmdMgr=Movie_UPDATE_FORM&&MCODE=${mVO.MCODE}'">
<input type="button" value="삭제" onclick="location.href='../admin/admin_Movie.do?CmdMgr=Movie_DELETE&&MCODE=${mVO.MCODE}'">
--%>    
        
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
      $("#fc_3rd").chained("#fc_2nd");
	</script>
</body>
</html>