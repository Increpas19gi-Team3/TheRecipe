<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

    
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
				<form:form action="mypageupdate.do" method="post" commandName="memberup" >
				<!-- 상품코드 -->
                			<input type="hidden" name="f_fdcode" value="${f_fdcode}">
	                    		
				<table>
					<thead>
						<tr>
						<th>이미</th>
							<th>상품명</th>
							<th>수량</th>
							<th>주문가격</th>
						</tr>
					</thead>
					<tbody>
						<tr>
						
                			
	                    		<!-- 이미지경로 -->
	                    		<td class="img_width"><img src="/images/${thumname}" alt=" 이미지"> </td>
	                    		<!-- 상품명 -->
	                    		<td class="text_left">${title}</td>
	                    		<td class="quantity_wrap">
									<div class="quantity">
										<!-- 수량 -->
										<input id="buy_cnt" name="o_amount" type="text" class="result_input"  value="${o_amount}" readonly>
									
									</div>
	                    		</td>
	                    		<!-- 주문가격 -->
	                    		<td><input class="text_center" id="price" type="text" name="o_buyprice"  value="${o_buyprice}" readonly><span class="asd">원</span></td>
	                    	</tr>
	                   		</tbody>
							</table>
				
					<fieldset>
						<label for="">이름</label>
						<input type="text" value="" id="m_name" name="m_name" placeholder="이름" required="" >
					</fieldset>
					<fieldset>
						<label for="">우편번호</label>
						<input type="text" value="" id="m_post" name="m_post" placeholder="우편번호" required="">
					</fieldset>
					<fieldset>
						<label for="">주소</label>
						<input type="text" value="" id="m_addr" name="m_addr" placeholder="주소" required="" class="address_input">
					</fieldset>
				
					<fieldset class="btn_submitWrap">
						<input type="submit" value="저장" class="btn_submit">
						<a href="#" onClick="history.back(); return false;" class="btn_back">취소</a>
					</fieldset>
					
				</form:form>
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