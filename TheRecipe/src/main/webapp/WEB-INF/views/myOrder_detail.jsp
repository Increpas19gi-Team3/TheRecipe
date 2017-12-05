<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<jsp:include page="header.jsp" />

	<div class="container myOrderDetail board">
		<div class="row">
			<div class="left_tab">
				<h2>고객센터</h2>
				<ul>
					<li><a href="mypageInfo.do">내정보관리</a></li>
					<li class="active"><a href="">주문 조회</a></li>
					<li><a href="#">내가 쓴 글</a></li>
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
						<a href="home.do">홈</a>
						<span> > </span>
						<a href="mypageInfo.do">마이페이지</a>
						<span> > </span>
						<a href="" class="active">주문조회</a>
					</div>
				</h3>
				<table>
					<thead>
						<tr>
							<th>주문코드</th>
							<th>상품명</th>
							<th>수량</th>
							<th>금액</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								${moVo.o_orderid}
							</td>
							<td class="text_left"> 
								<a href="#">
									<img src="/images/${moVo.f_thumname}" alt="">
									${moVo.f_foodname}
									</a>
								
							</td>
							<td>
							${moVo.o_amount}
							</td>
							<td>
								${moVo.o_buyprice}
							</td>
						</tr>
						
					</tbody>
				</table>
			
				<div class="deliver_info">
					<h3>배송지 정보</h3>
					<ul>
						<li>
							<p><span>수령인</span> ${moVo.o_reciever}</p>
							<p><span>배송지</span> <b>${moVo.o_dvypost}</b> ${moVo.o_dvyaddr}</p>
						</li>
						<li></li>
					</ul>
				</div>
			</div>
		</div>
	</div>

<jsp:include page="footer.jsp" />