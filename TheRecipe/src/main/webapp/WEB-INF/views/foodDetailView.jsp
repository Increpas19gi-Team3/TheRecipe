<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



	<jsp:include page="header.jsp" />

	<form action="shoppingBasket.do" method="post" >
		<input type="hidden" name="userID" value="<%=session.getAttribute("m_userid")%>">
		<input type="hidden" name="fdcode" value="${foodList.f_fdcode }">
		<input type="hidden" name="buyPrice" value="${foodList.f_price }">
	
	<div class="container productDetail">
		<div class="con_inner">
			<div class="detail_top">
				<div class="detail_imageWrap">
					<div class="image_top">
						<img src="/images/${imgname[0]}" class="top_detail_image">
						<i class="brd_box"></i>
					</div>
					<div class="image_thumb">
						<c:forEach var="thum" items="${thumname }">
							<a href="#" class="top_thumb">
								<img src="/images/${thum}"><br>
								<i class="brd_box"></i>
							</a>
						</c:forEach>
						<span class="top_thumb"></span>
					</div>
					<script>
						$(function(){
							// 상품 썸네일 이벤트
							$("div.image_thumb a.top_thumb").bind("mouseenter click", function(e) {
								e.preventDefault();
								e.stopPropagation();

								var $img = $("div.detail_imageWrap div.image_top img"), oldImageUrl = $img.prop("src");
								var newImageUrl = $(this).find("img").prop("src");

								if (newImageUrl && newImageUrl != oldImageUrl) {
									$img.prop("src", newImageUrl);
								}
							});
						});
					</script>
				</div>
				<div class="detail_descWrap">
					<h2>${foodList.f_foodname }</h2>
					<p>${foodList.f_explan }</p>
					<div class="price_one">
						<b><input id="price" type="text" name="price" value="${foodList.f_price }"></b>원
					</div>
					<div class="option_calc_wrap">
						<dl class="quantity">
							<dt>수량</dt>
							<dd>
								<input id="buy_cnt" type="text" value="1" class="result_input" name="amount" >
								<div class="inputWrap">
									<input id='up' type="button" value="+" class="up_input">
									<input id='down' type="button" value="-" class="down_input">
								</div>
							</dd>
						</dl>
					</div>
					<dl>
<!-- 						<dt>적립금</dt>
						<dd>89원</dd> 
						<dt>배송정보</dt>
						<dd>
							서울 · 경기(일부 지역) 새벽배송 / 전국택배 (제주 및 도서산간 불가)
							<br>
							<b>[월 · 화 · 수 · 목 · 금 · 토]</b> 수령 가능한 상품입니다.
						</dd>-->
						<dt>배송비</dt>
						<dd>2,500원 (<b>40,000원</b> 이상 구매 시 무료)</dd>
						<!-- <dt>정기배송가능여부</dt>
						<dd>정기배송 가능</dd> -->
					</dl>
					
					<div class="price_total">
						<span>총 상품금액</span><b><input id="totalPrice" type="text" name="totalPrice" value="${foodList.f_price }"></b>원
					</div>
					<input type="submit" value="담기" class="btn_submit">
				</div>
			</div>
			<div class="detail_con">
				<h3>상세정보</h3>
				<c:forEach var="img" items="${imgname }">
					<img src="/images/${img}"><br>
				</c:forEach>
			</div>
			<div class="detail_review">
				<h3>후기</h3>
				<table>
					<thead>
						<tr>
							<th>번호</th>
							<th>평점</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="review" items="${reviewList}">
						<tr>
							<td>
								${review.r_rvcode}
							</td>
							<td class="score">
								<span>
									<c:forEach begin="1" end="${review.r_grade}" step="1">
										<img src="/therecipe/resources/images/star.gif" alt="">
									</c:forEach>
								</span>
							</td>
							<td class="text_left"> 
								<a href="#">${review.r_rvcontents}</a>
							</td>
							<td>
								${review.m_userid}
							</td>
							<td>
								${review.r_rvdate}
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="pagination_wrap">
					<ul class="pagination">
						<li>
							<a href="#">
								<span>&laquo;</span>
							</a>
						</li>
						<li><a href="#" class="active">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li>
							<a href="#">
								<span>&raquo;</span>
							</a>
						</li>
					</ul>
					<div class="btn_right">
						<a href="boardReview_write.html">후기 쓰기</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	</form>

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
		total = Counter.value * document.getElementById("price").value;
		TotalPrice.value = total;
	}

	Increase.addEventListener("click", Inc);
	Decrease.addEventListener("click", Dec);
</script>


<jsp:include page="footer.jsp" />
