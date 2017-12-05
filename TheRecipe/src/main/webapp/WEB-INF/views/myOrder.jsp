<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
    
    
<jsp:include page="header.jsp" />

	<div class="container myPage board">
		<div class="row">
			<div class="left_tab">
				<h2>고객센터</h2>
				<ul>
					<li><a href="mypageInfo.do">내정보관리</a></li>
					<li class="active"><a href="myOrderList.do">주문 조회</a></li>
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
					주문조회
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
							<th>구매자</th>
							<th>주문일</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="list" items="${list}">
						<tr>
							<td>
							<a href="myOrderDetail.do?o_orderid=${list.o_orderid}">
								${list.o_orderid}
								</a>
							</td>
							<td class="text_left"> 
									${list.f_foodname}
							</td>
							<td>
								${list.o_reciever}
							</td>
							<td>
								${list.	o_orderdate}
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
				</div>
			</div>
		</div>
	</div>

<jsp:include page="footer.jsp" />