<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
    
<jsp:include page="header.jsp" />

<head>
<style type="text/css">
tr, th, td {
	border:1pt solid black;
	padding: 10px;
}
</style>
</head>
    <div class="container">
        <div class="con_inner">
            <div class="cart">
                <form action="myorder.do" method="post">
                	<h2>장바구니</h2>
	                <table>
	                    <thead>
	                        <tr>
		                    	<th><input type="checkbox"></th>
		                        <th colspan="2">상품</th>
		                        <th>수량</th>
		                        <th>상품금액</th>
		                        <th>총 상품금액</th>
								<th>삭제</th>
							
	                        </tr>
	                    </thead>
	                    <tbody>
	                    <c:choose>
    					<c:when test="${empty basket}">
    						<tr>
	    						<td colspan="7" style="text-align:center;">
	    						장바구니가 비어있습니다.
	    						</td>
    						</tr>
    					</c:when>
    					<c:otherwise>
	                     <c:forEach var="bask" items="${basket}">
                			<input type="hidden" name="f_fdcode" value="${bask.f_fdcode}">
                			
	                    	<tr>	                    		
	                    		<td><input type="checkbox"></td>
	                    		<td class="img_width"><img src="/images/${bask.f_thumname}" alt="${bask.f_thumname} 이미지"> </td>
	                    		<td class="text_left">${bask.f_foodname}</td>
	                    		<td class="quantity_wrap">
									<div class="quantity">
										<input id="buy_cnt" type="text" style="width:40px;" class="result_input" name="amount" value="${bask.b_amount}" >
										<span>
											<input id='up' type="button" value="+" class="up_input">
											<input id='down' type="button" value="-" class="down_input">
										</span>
									</div>
	                    		</td>
	                    		
	                    		<td><span><input id="price" type="text" name="price" onfocus='blur()' value="${bask.f_price }">원</span></td>
	                    		<td><span><input id="totalPrice" type="text"  name="totalPrice" value="${bask.f_price}" onfocus='blur()'>원</span></td>
	                    		
								<td><span><button type="button" onclick="location.href='DeleteBasket.do?f_fdcode=${bask.f_fdcode}'">삭제</button></span></td>
								
	                    	</tr>
	                    	
	                    	</c:forEach>
	                    	</c:otherwise>
	                    	</c:choose>
	                    </tbody>
	                    
	                </table>
	                <div class="btn_selectDelete">
	                	<button type="button" onclick="">선택상품 삭제</button>
	                </div>
	                <h3>구매 가격</h3>
	                <div class="total_price">
	                	<p>총 상품금액 <span><b><input id="totalPrice" type="text"  name="totalPrice" value="${bask.f_price}"></b>원</span></p>
	                	<p>배송비<span><b>2,500</b>원</span></p>
	                	<hr>
	                	<p class="price">총 주문금액 <span><b>28,200</b>원</span></p>
	                </div>
	                <div class="btn_submitWrap">
	                	<button type="submit">주문하기</button>
	                </div>
                </form>
            </div>
        </div>
    </div>
     
     <script>
	var Counter = document.getElementById("buy_cnt");
	var Increase = document.getElementById("up");
	var Decrease = document.getElementById("down");
	var TotalPrice = document.getElementById("totalPrice");
	var total = 0;

	function Inc() {
		Counter.value++;
		total = Counter.value * document.getElementById("price").value;
		TotalPrice.value = total;
	}
	function Dec() {
		Counter.value--;
		if(Counter.value<1){
			alert("1보다 작을수없습니다.");
			Counter.value=1;
		}
		
		total = Counter.value * document.getElementById("price").value;
		TotalPrice.value = total;
		
		}


	Increase.addEventListener("click", Inc);
	Decrease.addEventListener("click", Dec);
</script>
    
<jsp:include page="footer.jsp" />