<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<jsp:include page="include/header.jsp" />

    <div class="container">
        <div class="con_inner">
            <div class="cart">
                <form action="">
                	<h2>장바구니</h2>
	                <table>
	                    <thead>
	                        <tr>
		                    	<th><input type="checkbox"></th>
		                        <th colspan="2">상품</th>
		                        <th>수량</th>
		                        <th>주문금액</th>
								<th><a href=""></a></th>
	                        </tr>
	                    </thead>
	                    <tbody>
	                    	<tr>
	                    		<td><input type="checkbox"></td>
	                    		<td class="img_width"><img src="images/con1_1.jpg" alt=""></td>
	                    		<td class="text_left">[담미] [담미] 차돌박이 꽈리고추조림 100g</td>
	                    		<td class="quantity_wrap">
									<div class="quantity">
										<input type="text" value="1">
										<span>
											<a href="#" class="up">+</a>
											<a href="#" class="down">-</a>
										</span>
									</div>
									<button type="button" class="btn_change"">변경</button>
	                    		</td>
	                    		<td>12,900원</td>
								<td><a href="">X</a></td>
	                    	</tr>
	                    	<tr>
	                    		<td><input type="checkbox"></td>
	                    		<td class="img_width"><img src="images/con1_1.jpg" alt=""></td>
	                    		<td class="text_left">[담미] [담미] 차돌박이 꽈리고추조림 100g</td>
	                    		<td class="quantity_wrap">
									<div class="quantity">
										<input type="text" value="1">
										<span>
											<a href="#" class="up">+</a>
											<a href="#" class="down">-</a>
										</span>
									</div>
									<button type="button" class="btn_change"">변경</button>
	                    		</td>
	                    		<td>12,900원</td>
								<td><a href="">X</a></td>
	                    	</tr>
	                    </tbody>
	                </table>
	                <div class="btn_selectDelete">
	                	<button type="button">선택상품 삭제</button>
	                </div>
	                <h3>구매 가격</h3>
	                <div class="total_price">
	                	<p>상품 금액 <span><b>25,700</b>원</span></p>
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
    
<jsp:include page="include/footer.jsp" />