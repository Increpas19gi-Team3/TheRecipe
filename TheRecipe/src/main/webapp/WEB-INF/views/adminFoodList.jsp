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
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> (관리자) 음식 등록 관리 </title>
	
	
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
</head>
<body>
	<h1>adminFoodReg</h1>
	
	
	
	
	<select id="fc_1st" name="fc_1st" size="2" onclick="setAllClear();">
		<c:forEach var="foodcode1st" items="${foodcode1stList }">
			<option value= "${foodcode1st.fc_1st }">${foodcode1st.fc_ctgname } 요리</option>
		</c:forEach>
	</select>
	
	<strong> > </strong>

	<select id="fc_2nd" name="fc_2nd" size = "10" onclick="getSel2nd();">
		<option value="">-- 중분류 --</option>
	  	<c:forEach var="foodcode2nd" items="${foodcode2ndList }">
			<option class="${foodcode2nd.fc_1st }" value="${foodcode2nd.fc_1st }_${foodcode2nd.fc_2nd }">${foodcode2nd.fc_ctgname }</option>
		</c:forEach>
	</select>
	
	<strong> > </strong>
	
	<select id="fc_3rd" name="fc_3rd" size="10" onclick="getSel3rd();">
		<option value="">-- 소분류 --</option>
		<c:forEach var="foodcode3rd" items="${foodcode3rdList }">
			<option class='${foodcode3rd.fc_1st }_${foodcode3rd.fc_2nd }' value='${foodcode3rd.fc_1st }_${foodcode3rd.fc_2nd }_${foodcode3rd.fc_3rd }'>${foodcode3rd.fc_ctgname }</option>
		</c:forEach>
	</select>
	
    
    <p/><p/>
    <form action="regCategory.do" >
    	<label> 신규 등록카테고리 구분</label> : 
    	<input type="radio" name="regFoodcode" value="2nd" id="sel2nd" onclick="setTextClear();"/> <label for="sel2nd">중분류</label>
    	<input type="radio" name="regFoodcode" value="3rd" id="sel3rd" onclick="setTextClear();" /> <label for="sel3rd">소분류</label>
    	<input type="submit" value="신규 등록">
    </form>
    <br />
    <form:form>
    	<label> 카테고리 명</label> : <input type="text" name="codeName" id="codeName">
    	<input type="button" value="수정" onclick="">
    	<input type="button" value="삭제" onclick="">
    	<input type="reset" >
    </form:form>
        
<%--        
<input type="button" value="수정" onclick="location.href='../admin/admin_Movie.do?CmdMgr=Movie_UPDATE_FORM&&MCODE=${mVO.MCODE}'">
<input type="button" value="삭제" onclick="location.href='../admin/admin_Movie.do?CmdMgr=Movie_DELETE&&MCODE=${mVO.MCODE}'">
--%>    
        
        
        
        

	<!-- 반드시 하단에 있어야 함 -->
	<script src="//code.jquery.com/jquery.min.js"></script>
	<script src='//rawgit.com/tuupola/jquery_chained/master/jquery.chained.min.js'></script>
	<script>
	  $("#fc_2nd").chained("#fc_1st");
      $("#fc_3rd").chained("#fc_2nd");
	</script>
</body>
</html>