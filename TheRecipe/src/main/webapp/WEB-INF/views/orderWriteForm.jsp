<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

    
<jsp:include page="header.jsp" />

	<div class="container myOrderDetail order board">
		<div class="row">
			<div class="right_contnet">
				<h3>
					결제하기
				</h3>
				<form:form action="orderWrite.do." method="post" commandName="orderup" >
				<!-- 상품코드 -->
                			<input type="hidden" name="f_fdcode" value="${f_fdcode}">
                <!-- 제품명 -->			
                			<input type="hidden" name="title" value="${bask.f_foodname}">
				<!-- 썸네일 -->			
							<input type="hidden" name="thumname" value="${bask.f_thumname}">
	                    		
				<table>
					<thead>
						<tr>
							<th>NO</th>
							<th>상품명</th>
							<th>수량</th>
							<th>결제금액</th>
						</tr>
					</thead>
					<tbody>
							<tr>
							<td>
								1
							</td>
							<td class="text_left"> 
								<a href="#">
									<img src="/images/${thumname}" alt="">
									${title}
								</a>
							</td>
							<td>
								<input id="buy_cnt" name="o_amount" type="text" class="result_input"  value="${o_amount}" readonly>
							</td>
							<td>
								<input class="text_center" id="price" type="text" name="o_buyprice"  value="${o_buyprice}" readonly><span class="asd">원</span>
							</td>
						</tr>
							
						
                 	</tbody>
				</table>
				
				<div class="deliver_info">
					<h3>배송지 정보</h3>
					<ul>
						<li class="recipient">
							<p><span>수령인</span> <input type="text" value="" id="m_name" name="m_name" placeholder="" required="" ></p>
							<p><span>우편번호</span> <input type="text" value="" id="m_post" name="m_post" placeholder="" required=""></p>
							<p><span>주소</span> <input type="text" value="" id="m_addr" name="m_addr" placeholder="" required="" class="address_input"></p>
						</li>
					</ul>
				</div>
				<div class="btn_submit">
					<input type="submit" value="결제하기" />
					<a href="#" onClick="history.back(); return false;" class="btn_back">취소</a>
				</div>
				
				
				</form:form>
			</div>
		</div>
	</div>
	
	<style>
		.order .row .right_contnet{
			width: 100%;
		}
		.order .row .right_contnet .deliver_info ul li.recipient p:nth-child(3) input{
			width: 600px;
		}
		.order .row .right_contnet .btn_submit{
			margin-bottom: 50px;
			text-align: center;
		}
		.order .row .right_contnet .btn_submit input{
			width: 300px;
			margin-bottom: 30px;
			padding: 20px 0;
			font-size: 20px;
			color: #fff;
			border: none;
			background: #2ac1bc;
		}
		.order .row .right_contnet .btn_submit a{
			width: 300px;
			margin: 0 auto;
			padding: 20px 0;
			font-size: 20px;
			border: 1px solid #ccc;
		}
		.order .row .right_contnet table tbody tr td input{
			border: none;
			text-align: center;
		}
		.order .right_contnet .deliver_info ul li:last-child{
			float: left;
		}
		.order .right_contnet .deliver_info ul li p{
			padding: 10px 0;
		}
		.order .right_contnet .deliver_info ul li p span{
			background: none;
		}
		.order .right_contnet .deliver_info ul li p input{
			line-height: 32px;
			border: 1px solid #e1e1e1;
		}
		
		
		
	</style>
<jsp:include page="footer.jsp" />