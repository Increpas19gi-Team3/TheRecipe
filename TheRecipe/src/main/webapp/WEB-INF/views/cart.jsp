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
		                    	<th><input type="checkbox" name="checkAll" id="th_checkAll" onclick="checkAll();"/></th><!--체크박스 회의 해보자  -->
		                        <th colspan="2">상품</th>
		                        <th>수량</th>
		                        <th>가격</th>
		                        <th>주문금액</th>
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
                			<!-- 상품코드 -->
                			<input type="hidden" name="f_fdcode" value="${bask.f_fdcode}">
                			
	                    	<tr>	                    		
	                    		<td class="center"><input type="checkbox" name="checkRow" value="${bask.f_fdcode}" /></td><!--체크박스 회의 해보자  -->
	                    		<!-- 이미지경로 -->
	                    		<td class="img_width"><img src="/images/${bask.f_thumname}" alt="${bask.f_thumname} 이미지"> </td>
	                    		<!-- 상품명 -->
	                    		<td class="text_left">${bask.f_foodname}</td>
	                    		<td class="quantity_wrap">
									<div class="quantity">
										<!-- 수량 -->
										<input id="buy_cnt" name="buy_cnt" type="text" style="width:40px;" class="result_input" name="amount" value="${bask.b_amount}" readonly>
										<span>
											<input id='up' name="up" type="button" value="+" class="up_input">
											<input id='down' name="down" type="button" value="-" class="down_input">
										</span>
									</div>
	                    		</td>
	                    		
	                    		<!-- 가격 -->
	                    		<td><span><input id="price" type="text" name="price" readonly value="${bask.f_price }">원</span></td>
	                    		<!-- 주문금액 -->
	                    		<td><span><input id="totalPrice" type="text"  name="totalPrice" value="${bask.f_price}" readonly>원</span></td>
	                    		<!-- 삭제버튼 -->
								<td><span><button type="button" onclick="deleteProduct(${bask.f_fdcode})">삭제</button></span></td>
								
	                    	</tr>
	                    	
	                    	</c:forEach>
	                    	</c:otherwise>
	                    	</c:choose>
	                    </tbody>
	                    
	                </table>
	                <div class="btn_selectDelete"><!--체크박스 회의 해보자  -->
	                	<button type="button" onclick="deleteProduct(${bask.f_fdcode})">선택상품 삭제</button>
	                </div>
	               
	                <h3>구매 가격</h3>
	                <div class="total_price">
	                	<p>총 상품금액 <input id="totalPriceSum" name="totalPriceSum" type="text" readonly>원</p>
	                	<p>배송비<span id="deliveryPrice"><b>2,500</b>원</span></p>
	                	<hr>
	                	<input name="o_buyprice" type="hidden" readonly>
	                	<p class="price">총 주문금액 <span id="o_buyprice"></span></p>
	                </div>
	                <div class="btn_submitWrap">
	                	<button type="submit">주문하기</button>
	                </div>
                </form>
            </div>
        </div>
    </div>
     
    <script>

	var Counter = document.getElementsByName("buy_cnt");
	var Increase = document.getElementsByName("up");
	var Decrease = document.getElementsByName("down");
	var Price = document.getElementsByName("price");
	var TotalPrice = document.getElementsByName("totalPrice");
	var TotalPriceSum = document.getElementById("totalPriceSum");
	var total = 0;
	var total_sum = 0;
	var delivery = "";
	
	//콤마찍기
	function comma(str) {
	    str = String(str);
	    return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
	}
	//콤마풀기
	function uncomma(str) {
	    str = String(str);
	    return str.replace(/[^\d]+/g, '');
	}
	//input box에서 사용자 입력시 바로 콤마를 찍어주기 위한 함수도 추가 한다.
	function inputNumberFormat(obj) {
	    obj.value = comma(uncomma(obj.value));
	}

	
	$(document).ready(function() {
		
		for (var i=0; i<Counter.length; i++) {
			(function(i) {
				total = Counter[i].value * Price[i].value;
				TotalPrice[i].value = comma(total);
				total_sum += total;
				inputNumberFormat(Price[i]); // 콤마찍기
			})(i);
		}
		/* 총 주문금액 */
		TotalPriceSum.value = comma(total_sum);
		if(total_sum < 40000) {
			total_sum += 2500;
			delivery = "<b>2,500</b>원";
		} else {
			delivery = "<b>0</b>원";
		}
		$("input[name=o_buyprice]").val(total_sum);
		$("#o_buyprice").html("<b>"+comma(total_sum)+"</b>원");
		$("#deliveryPrice").html(delivery);
		
		/* 총 상품금액 계산 */
		$("input[name=up], input[name=down]").click(function() {
			total_sum = 0;
            $("input[name='totalPrice']").each(function (i) {
            	var tmp_totalPrice = uncomma($("input[name='totalPrice']").eq(i).val());
            	total_sum += Number(tmp_totalPrice);
            });
            
    		/* 총 주문금액 */
    		TotalPriceSum.value = comma(total_sum);
    		if(total_sum < 40000) {
    			total_sum += 2500;
    			delivery = "<b>2,500</b>원";
    		} else {
    			delivery = "<b>0</b>원";
    		}
    		$("input[name=o_buyprice]").val(total_sum);
    		$("#o_buyprice").html("<b>"+comma(total_sum)+"</b>원");
    		$("#deliveryPrice").html(delivery);
		});
		

	});
	
	for (var i=0; i<Increase.length; i++) {
		(function(i) {
			Increase[i].addEventListener("click", Inc);

			function Inc() {
				Counter[i].value++;
				total = Counter[i].value * uncomma(Price[i].value);
				TotalPrice[i].value = comma(total);
			}
		})(i);
		
	}

	for (var i=0; i<Decrease.length; i++) {
		(function(i) {
			Decrease[i].addEventListener("click", Dec);

			function Dec() {
				Counter[i].value--;
				if(Counter[i].value<1){
					alert("1보다 작을수없습니다.");
					Counter[i].value=1;
				}
				
				total = Counter[i].value * uncomma(Price[i].value);
				TotalPrice[i].value = comma(total);
			}
		})(i);
		
	}
	


	function deleteProduct(fdcode) {
		if(!confirm('삭제하시겠습니까?')){ 
			return;
		}
		location.href='DeleteBasket.do?f_fdcode='+fdcode;
	}
	
</script>
    
<jsp:include page="footer.jsp" />