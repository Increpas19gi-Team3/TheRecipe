<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



	<jsp:include page="header.jsp" />

	<footer>
		<nav>
			<jsp:include page="footer.jsp" />
		</nav>
	</footer>
	
	<div class="container">
		<nav aria-label="breadcrumb" role="navigation">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="home.html">홈</a></li>
				<li class="breadcrumb-item"><a href="home.html">한식</a>></li>
				<li class="breadcrumb-item active" aria-current="page">국</li>
			</ol>
		</nav>
		<div class="row">
			<div class="col-lg-4">
				<div class="imgWrap">
					<img src="/images/${imgname[0]}">
				</div>
			</div>
			<div class="col-lg-8">
				<div class="descWrap">
					<div class="detail_top_desc">
						<h1 class="desc_product_name">${foodList.f_foodname }</h1>
						<p class="desc_bt_txt">${foodList.f_explan }</p>
						<dl class="desc_info">
							<dt>배송비</dt>
							<dd>2,500원 (<strong>40,000원</strong> 이상 구매 시 무료)</dd>
							<dt class="blind">가격</dt>
							<dd class="desc_price">
								<span class="origin_price">${foodList.f_price }<span class="unit">원</span></span>
								<strong class="price">
								<input id="price" type="text" name="price" value="${foodList.f_price }">
								<span class="unit">원</span></strong>
							</dd>
						</dl>
						<div class="desc_option_calc clearfix">
	<!-- 						<form onsubmit="return false;"> -->
								<form action="shoppingBasket.do" method="post" >
								<input type="hidden" name="userID" value="<%=session.getAttribute("m_userid")%>">
									<input type="hidden" name="fdcode" value="${foodList.f_fdcode }">
									<input type="hidden" name="buyPrice" value="${foodList.f_price }">
								<fieldset>
									<div class="option_only_quantity">
										<dl class="clearfix">
											<dt>수량</dt>
											<dd>
												<div class="prd_account fRight">
													<input type="Button" id='down' value="-"/>
													<label>
														<input id="buy_cnt" type="text" name="amount" value="1">
													</label>
													<input type="Button" id='up' value="+"/>
												</div>
											</dd>
										</dl>
									</div>
									
									<p class="calculated_price">
										<span class="price_label">총 상품금액</span>
										<input id="totalPrice" type="text" name="totalPrice" value="${foodList.f_price }">
										<span class="unit">원</span>
									</p>
									<button type="submit" class="btn btn-info btn_into_basket purchageable">담기</button>
								</fieldset>
								
								<c:forEach var="img" items="${imgname }">
									<img src="/images/${img}"><br>
								</c:forEach>
								<script>
										var Counter = document.getElementById("buy_cnt");
										var Increase = document.getElementById("up");
										var Decrease = document.getElementById("down");
										var TotalPrice = document.getElementById("totalPrice");  
									    var total=0;

										function Inc() {
											Counter.value ++;
											total = Counter.value * document.getElementById("price").value;
									        TotalPrice.value = total;
										} 
										function Dec() {
											Counter.value --;
											total = Counter.value * document.getElementById("price").value;
									        TotalPrice.value = total;
										} 

										Increase.addEventListener("click", Inc);
										Decrease.addEventListener("click", Dec);
									</script>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<jsp:include page="footer.jsp" />
