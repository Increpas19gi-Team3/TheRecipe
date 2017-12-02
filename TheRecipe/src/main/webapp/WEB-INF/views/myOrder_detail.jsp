<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<jsp:include page="header.jsp" />

	<div class="container myPage board">
		<div class="row">
			<div class="left_tab">
				<h2>고객센터</h2>
				<ul>
					<li><a href="http://localhost:8282/therecipe/test_171129/myPage.jsp">내정보관리</a></li>
					<li class="active"><a href="http://localhost:8282/therecipe/test_171129/myOrder.jsp">주문 조회</a></li>
					<li><a href="http://localhost:8282/therecipe/test_171129/myWrite.jsp">내가 쓴 글</a></li>
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
					주문상세조회
					<div class="page_locationBox">
						<a href="http://localhost:8282/therecipe/test_171129/home.jsp">홈</a>
						<span> > </span>
						<a href="http://localhost:8282/therecipe/test_171129/myPage.jsp">마이페이지</a>
						<span> > </span>
						<a href="http://localhost:8282/therecipe/test_171129/myOrder.jsp">주문조회</a>
						<span> > </span>
						<a href="http://localhost:8282/therecipe/test_171129/myOrder_detail.jsp" class="active">주문상세조회</a>
					</div>
				</h3>
				<table>
					<thead>
						<tr>
							<th>주문코드</th>
							<th>상품명</th>
							<th>구매자</th>
							<th>주문일</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								AB12
							</td>
							<td class="text_left"> 
								<a href="myorderDetail.html">
									돼지고기 김치찌개 <span>외 1개</span>
								</a>
							</td>
							<td>
								조혁래
							</td>
							<td>
								2017.10.19
							</td>
						</tr>
						<tr>
							<td>
								AB13
							</td>
							<td class="text_left"> 
								<a href="#">
									소고기 된장찌개
								</a>
							</td>
							<td>
								한범석
							</td>
							<td>
								2017.10.19
							</td>
						</tr>
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
				</div>
			</div>
		</div>
	</div>

<jsp:include page="footer.jsp" />