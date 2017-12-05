<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<jsp:include page="include/header.jsp" />

	<div class="container myOrderDetail board">
		<div class="row">
			<div class="left_tab">
				<h2>고객센터</h2>
				<ul>
					<li><a href="myPage.html">내정보관리</a></li>
					<li class="active"><a href="myorder.html">주문 조회</a></li>
					<li><a href="myWrite.html">내가 쓴 글</a></li>
				</ul>
				<div class="service_info">
					<h4>배민찬 고객센터</h4>
					<h3>1899-2468</h3>
					<hr>
					<p>평일 06:30 ~ 18:00</p>
					<p>주말 06:30 ~ 15:00</p>
					<p>공휴일 휴무</p>
				</div>
			</div>
			<div class="right_contnet">
				<h3>
					주문상세정보
					<div class="page_locationBox">
						<a href="home.html">홈</a>
						<span> > </span>
						<a href="join.html">마이페이지</a>
						<span> > </span>
						<a href="join.html" class="active">주문조회</a>
					</div>
				</h3>
				<table>
					<thead>
						<tr>
							<th>NO</th>
							<th>상품명</th>
							<th>수량</th>
							<th>금액</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								1
							</td>
							<td class="text_left"> 
								<a href="#">
									<img src="images/con1_1.jpg" alt="">
									돼지고기 김치찌개
								</a>
							</td>
							<td>
								1
							</td>
							<td>
								15,800원
							</td>
						</tr>
						<tr>
							<td>
								2
							</td>
							<td class="text_left"> 
								<a href="#">
									<img src="images/con1_2.jpg" alt="">
									소고기 된장찌개
								</a>
							</td>
							<td>
								2
							</td>
							<td>
								32,200원
							</td>
						</tr>
					</tbody>
				</table>
				<div class="deliver_info">
					<h3>결제 정보</h3>
					<ul>
						<li>
							<p><span>상품금액</span> 129,500원</p>
							<p><span>배송비</span> 2,500원</p>
						</li>
						<li class="order_info">
							<p class="order_name">결제 금액</p>
							<p class="order_price">132,000원</p>
						</li>
					</ul>
				</div>
				<div class="deliver_info">
					<h3>배송지 정보</h3>
					<ul>
						<li>
							<p><span>수령인</span> 조혁래</p>
							<p><span>연락처</span> 010-7460-3737</p>
							<p><span>배송지</span> <b>(85795)</b> 서울특별시 관악구 신림동 1665-6 스마트빌 303호</p>
							<p><span>배송매모</span> 부재시 현관문앞에 놔주세요</p>
						</li>
						<li class="order_info">
							<p class="order_name">주문자 정보</p>
							<p>한범석</p>
							<p>010-7460-3838</p>
							<p>johr@gmail.com</p>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>

<jsp:include page="include/footer.jsp" />