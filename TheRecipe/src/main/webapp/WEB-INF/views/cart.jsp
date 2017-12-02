<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
    
<jsp:include page="header.jsp" />

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
		                        <th>주문금액</th>
								<th><a href=""></a></th>
							
	                        </tr>
	                    </thead>
	                    <tbody>
	                     <c:forEach var="bask" items="${basket}">
                			<input type="hidden" name="f_fdcode" value="${bask.f_fdcode}">
                			
	                    	<tr>	                    		
	                    		<td><input type="checkbox"></td>
	                    		<td class="img_width"><img src="/images/${bask.f_thumname}" alt="${bask.f_thumname} 이미지"> </td>
	                    		<td class="text_left">${bask.f_foodname}</td>
	                    		<td class="quantity_wrap">
									<div class="quantity">
										<input type="text" name="o_amount" value="${bask.b_amount}">
										<span>
											<a href="#" class="up">+</a>
											<a href="#" class="down">-</a>
										</span>
									</div>
									<button type="button" class="btn_change">변경</button>
	                    		</td>
	                    		<td>${bask.f_price}원</td>
								<td><a href="">X</a></td>
	                    	</tr>
	                    	
	                    	</c:forEach>
	                    </tbody>
	                    
	                </table>
	                <div class="btn_selectDelete">
	                	<button type="button" onclick="">선택상품 삭제</button>
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
    
<jsp:include page="footer.jsp" />