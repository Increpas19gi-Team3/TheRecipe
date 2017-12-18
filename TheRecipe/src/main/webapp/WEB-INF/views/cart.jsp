<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="header.jsp" />

<div class="container">
	<div class="con_inner">
		<div class="cart">
			<form action="orderWriteForm.do" method="post">
				<h2>장바구니</h2>
				<table>
					<thead>
						<tr>
						<!-- 	<th><input type="checkbox" name="checkAll" id="th_checkAll"
								onclick="checkAll();" /></th> -->
							<th colspan="2">상품</th>
							<th>수량</th>
							<th>가격</th>
							<th>할인가</th>
							<th>주문금액</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${empty basket}">
								<tr>
									<td colspan="7" style="text-align: center;">장바구니가 비어있습니다.
									</td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach var="bask" items="${basket}">
									<!-- 상품코드 -->
									<input type="hidden" name="f_fdcode" value="${bask.f_fdcode}">
									<input type="hidden" name="price" value="${bask.f_price }">
									<input type="hidden" name="discount_value" value="${bask.discount_value}">
									<input type="hidden" name="title" value="${bask.f_foodname}">
									<input type="hidden" name="thumname" value="${bask.f_thumname}">

									<tr>
									<%-- 	<td><input type="checkbox" name="checkRow"
											value="${bask.f_fdcode}" /></td> --%>
										<!-- 이미지경로 -->
										<td class="img_width"><img
											src="/images/${bask.f_thumname}" alt="${bask.f_thumname} 이미지">
										</td>
										<!-- 상품명 -->
										<td class="text_left">${bask.f_foodname}</td>
										<td class="quantity_wrap">
											<div class="quantity">
												<!-- 수량 -->
												<input id="buy_cnt" name="buy_cnt" type="text"
													class="result_input" value="${bask.b_amount}" readonly>
												<span> <input id='up' name="up" type="button"
													value="+" class="up_input"> <input id='down'
													name="down" type="button" value="-" class="down_input">
												</span>
											</div>
										</td>
										<!-- 가격 -->
										<td><input class="text_center" id="price" type="text"
											name="priceReal" readonly value="${bask.f_price }"><span
											class="asd">원</span></td>
										
										<!-- 할인가 -->
										<td><input class="text_center" id="discountPrice" type="text"
											name="discountPrice" readonly value="${bask.f_price }"><span
											class="asd">원</span></td>
											
										<!-- 주문금액 -->
										<td><input class="text_center" id="totalPrice"
											type="text" name="totalPrice" value="${bask.f_price}"
											readonly><span class="asd">원</span></td>
										<!-- 삭제버튼 -->
										<td><a href="#" type="button"
											onclick="deleteProduct('${bask.f_fdcode}')">x</a></td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>

				<h3>구매 가격</h3>

				<div class="total_price">
					<p>
						총 상품금액 <span><input id="totalPriceSum" name="totalPriceSum"
							type="text" readonly>원</span>
					</p>
					<p>
						배송비<span id="deliveryPrice"><b>2,500</b>원</span>
					</p>
					<hr>
					<input name="o_buyprice" type="hidden" readonly>
					<p class="price">
						총 주문금액 <span id="o_buyprice"></span>
					</p>
				</div>
				<div class="btn_submitWrap">
					<button type="submit">주문하기</button>
				</div>
		</form>
		</div>
		</div>
</div>

<script>
	var discount_value = document.getElementsByName("discount_value");
	var Counter = document.getElementsByName("buy_cnt");
	var Increase = document.getElementsByName("up");
	var Decrease = document.getElementsByName("down");
	var Price = document.getElementsByName("price");
	var DiscountPrice = document.getElementsByName("discountPrice");
	var priceReal = document.getElementsByName("priceReal");
	var TotalPrice = document.getElementsByName("totalPrice");
	var TotalPriceSum = document.getElementById("totalPriceSum");
	var total = 0;
	var total_sum = 0;
	var delivery = "";
/* 	
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
 */
	
	$(document).ready(function() {
		
		for (var i=0; i<Counter.length; i++) {
			(function(i) {
				//inputNumberFormat(Price[i]); // 콤마찍기
				
				discountPrice[i].value = Counter[i].value * Price[i].value * (discount_value[i].value / 100);
				total = Counter[i].value * Price[i].value * (100 - discount_value[i].value)/ 100;
				TotalPrice[i].value = total;
				total_sum += total;
			})(i);
		}
		/* 총 주문금액 */
		TotalPriceSum.value = total_sum;
		if(total_sum < 40000) {
			total_sum += 2500;
			delivery = "<b>2,500</b>원";
		} else {
			delivery = "<b>0</b>원";
		}
		$("input[name=o_buyprice]").val(total_sum);
		$("#o_buyprice").html("<b>"+total_sum+"</b>원");
		$("#deliveryPrice").html(delivery);
		
		/* 총 상품금액 계산 */
		$("input[name=up], input[name=down]").click(function() {
			total_sum = 0;
            $("input[name='totalPrice']").each(function (i) {
            	var tmp_totalPrice = ($("input[name='totalPrice']").eq(i).val());
            	total_sum += Number(tmp_totalPrice);
            });
            
    		/* 총 주문금액 */
    		TotalPriceSum.value = total_sum;
    		if(total_sum < 40000) {
    			total_sum += 2500;
    			delivery = "<b>2,500</b>원";
    		} else {
    			delivery = "<b>0</b>원";
    		}
    		$("input[name=o_buyprice]").val(total_sum);
    		$("#o_buyprice").html("<b>"+total_sum+"</b>원");
    		$("#deliveryPrice").html(delivery);
		});
		

	});
	
	for (var i=0; i<Increase.length; i++) {
		(function(i) {
			Increase[i].addEventListener("click", Inc);

			function Inc() {
				Counter[i].value++;
				priceReal[i].value = Counter[i].value * Price[i].value;
				discountPrice[i].value = Counter[i].value * Price[i].value * (discount_value[i].value / 100);
				total = Counter[i].value * Price[i].value * (100 - discount_value[i].value)/ 100;
				TotalPrice[i].value = total;
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
				priceReal[i].value = Counter[i].value * Price[i].value;
				discountPrice[i].value = Counter[i].value * Price[i].value * (discount_value[i].value / 100);
				total = Counter[i].value * Price[i].value * (100 - discount_value[i].value)/ 100;
				TotalPrice[i].value = total;
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