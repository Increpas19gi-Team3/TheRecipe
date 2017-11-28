<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/therecipe/resources/css/style.css">

</head>
<body>

	<header>
		<nav>
			<jsp:include page="header.jsp" />
		</nav>
	</header>
	
	<form action="shoppingBasket.do" method="post" >
	 <input type="hidden" name="userID" value="han">
			<input type="hidden" name="fdcode" value="${foodList.f_fdcode }">
			<input type="hidden" name="buyPrice" value="${foodList.f_price }">
			<!-- <input type="hidden" name="amount" value=""> -->
	<table>
		<tr>
			<th>
				<img src="/images/${imgname[0]}" width="200" height="200">
			</th>
			<td>
				가격 : <input type="text" id="price" name="price" value="${foodList.f_price }" readonly="readonly"> <br> 
				수량 : <input type="Button" id='Button2' value="-"/>
				<input type="text" name="NumberBox" id="NumberBox" value="1" />
				<input type="Button" id='Button1' value="+"/>
   
				<hr><br>
				구매금액 : <input type="text" id="totalPrice" name="totalPrice" value="${foodList.f_price }" readonly="readonly">
				<input type="submit" value="장바구니 담기">
			</td>
			
			
		</tr>
		
		<c:forEach var="img" items="${imgname }">
		<tr>
			<th colspan="2">
				<img src="/images/${img}" width="500" height="500">
			</th>
			<%-- <td>${foodList.f_fdcode }</td>
			<td>${foodList.e_evtcode }</td>
			<td>${foodList.fc_1st }</td>
			<td>${foodList.fc_2nd }</td>
			<td>${foodList.fc_3rd }</td>
			<td>${foodList.f_explan }</td>
			<td>${foodList.f_imgname }</td>
			<td>${foodList.f_foodname }</td> --%>
			
		</tr>
		</c:forEach>

		<tr>
			<th>작성자</th>
			<th>후기</th>
			<th>이미지</th>
			<th>평점</th>
			<th>조회수</th>
			<th>작성일</th>
		</tr>
		<c:forEach var="review" items="${reviewList }">
		<tr>
			<td>${review.m_userid}</td>
			<td>${review.r_rvcontents}</td>
			<td>${review.r_rvimgname}</td>
			<td>${review.r_grade}</td>
			<td>${review.r_rvcount}</td>
			<td>${review.r_rvdate}</td>	
		</tr>
		</c:forEach>
	</table>
	
	</form>
	
	<script>
      var Counter = document.getElementById("NumberBox");
      var Increase = document.getElementById("Button1");
      var Decrease = document.getElementById("Button2");
      var Price = document.getElementById("price");
      var TotalPrice = document.getElementById("totalPrice");  
      var total=0;

      function Inc() {
         Counter.value ++;
         total = Counter.value * document.getElementById("price").value;
         TotalPrice.value = total;
      } 
      function Dec() {
    	 if(Counter.value != 1){
         	 Counter.value --;
         	total = Counter.value * document.getElementById("price").value;
            TotalPrice.value = total;
    	 }else{
    		 alert("최소 구매 수량을 확인하세요");
    	 }
      } 

      Increase.addEventListener("click", Inc);
      Decrease.addEventListener("click", Dec);
   </script>
</body>
</html>