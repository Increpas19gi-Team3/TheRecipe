<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    
<jsp:include page="include/header.jsp" />

	<div class="container productDetail">
		<div class="con_inner">
			<div class="detail_top">
				<div class="detail_imageWrap">
					<div class="image_top">
						<img src="https://cdn.bmf.kr/_data/product/H33EC/40ecbe5f1a75e07a3aaad719a6a5115b.jpg" alt="" class="top_detail_image">
						<i class="brd_box"></i>
					</div>
					<div class="image_thumb">
						<a href="#" class="top_thumb">
							<img src="https://cdn.bmf.kr/_data/product/H33EC/40ecbe5f1a75e07a3aaad719a6a5115b.jpg" alt="">
							<i class="brd_box"></i>
						</a>
						<a href="#" class="top_thumb">
							<img src="https://cdn.bmf.kr/_data/product/H33EC/20d487704f42d5431c57556002393ba4.jpg" alt="">
							<i class="brd_box"></i>
						</a>
						<a href="#" class="top_thumb">
							<img src="https://cdn.bmf.kr/_data/product/H33EC/8ff349e6c85a48d4dd628785f691a532.jpg" alt="">
							<i class="brd_box"></i>
						</a>
						<a href="#" class="top_thumb">
							<img src="https://cdn.bmf.kr/_data/product/H33EC/363f85cf0a7c933c963d8d237b97f972.jpg" alt="">
							<i class="brd_box"></i>
						</a>
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
					<h2>[자연별곡] 직화 고추장 돼지구이 240g</h2>
					<p>매콤달콤 특제 고추장소스에 재운 후 맛있게 구웠어요.</p>
					<dl>
						<dt>적립금</dt>
						<dd>89원</dd>
						<dt>배송정보</dt>
						<dd>
							서울 · 경기(일부 지역) 새벽배송 / 전국택배 (제주 및 도서산간 불가)
							<br>
							<b>[월 · 화 · 수 · 목 · 금 · 토]</b> 수령 가능한 상품입니다.
						</dd>
						<dt>배송비</dt>
						<dd>2,500원 (<b>40,000원</b> 이상 구매 시 무료)</dd>
						<dt>정기배송가능여부</dt>
						<dd>정기배송 가능</dd>
					</dl>
					<div class="price_one">
						<b>8,900</b>원
					</div>
					<div class="option_calc_wrap">
						<dl class="quantity">
							<dt>수량</dt>
							<dd>
								<input type="text" value="1" class="result_input">
								<div class="inputWrap">
									<input type="button" value="-" class="down_input">
									<input type="button" value="+"
									class="up_input">
								</div>
							</dd>
						</dl>
					</div>
					<div class="price_total">
						<span>총 상품금액</span><b>8,900</b>원
					</div>
					<input type="submit" value="담기" class="btn_submit">
				</div>
			</div>
			<div class="detail_con">
				<h3>상세정보</h3>
				<img src="images/productDetail1_1.jpg" alt="">
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
						<tr class="btn_dropdown">
							<td>
								1
							</td>
							<td class="score">
								<span>
									<img src="images/star.gif" alt="">
									<img src="images/star.gif" alt="">
									<img src="images/star.gif" alt="">
									<img src="images/star.gif" alt="">
									<img src="images/star.gif" alt="">
								</span>
							</td>
							<td class="text_left"> 
								별로였어요 (<b>1</b>)
							</td>
							<td>
								조혁래
							</td>
							<td>
								2017.10.19
							</td>
						</tr>
						<tr class="dropdown_re">
							<td></td>
							<td colspan="4" class="text_left"> 
								<p class="user_tx">
									별로네요ㅠㅠㅠ<br>
									ㅆㅆㅆㅆㅆㅆㅆㅆㅂ별롤라오ㅓㄹ오ㅓㄹㅇㄹ이ㅏ미암ㅇ<br>
									ㅁ
								</p>
								<hr>
								<p class="admin_tx">
									asdasd<br>
									asd<br>
									fgfg
								</p>
								<p class="admin_desc">관리자 | 2017-11-18</p>
							</td>
						</tr>
						<tr class="btn_dropdown">
							<td>
								1
							</td>
							<td class="score">
								<span>
									<img src="images/star.gif" alt="">
									<img src="images/star.gif" alt="">
									<img src="images/star.gif" alt="">
									<img src="images/star.gif" alt="">
									<img src="images/star.gif" alt="">
								</span>
							</td>
							<td class="text_left"> 
								별로였어요
							</td>
							<td>
								조혁래
							</td>
							<td>
								2017.10.19
							</td>
						</tr>
						<tr class="btn_dropdown">
							<td>
								1
							</td>
							<td class="score">
								<span>
									<img src="images/star.gif" alt="">
									<img src="images/star.gif" alt="">
									<img src="images/star.gif" alt="">
									<img src="images/star.gif" alt="">
									<img src="images/star.gif" alt="">
								</span>
							</td>
							<td class="text_left"> 
								별로였어요 (<b>1</b>)
							</td>
							<td>
								조혁래
							</td>
							<td>
								2017.10.19
							</td>
						</tr>
						<tr class="dropdown_re">
							<td></td>
							<td colspan="4" class="text_left">
								<img src="images/con1_1.jpg" alt="">
								<p class="user_tx">
									별로네요ㅠㅠㅠ<br>
									ㅆㅆㅆㅆㅆㅆㅆㅆㅂ별롤라오ㅓㄹ오ㅓㄹㅇㄹ이ㅏ미암ㅇ<br>
									ㅁ
								</p>
								<hr>
								<p class="admin_tx">
									dfgdfgdfgsdfgdfgdsfgsdfgdfsgdfsgdsfg<br>
									ghjtybdgdgfdgdfgdfgdfg<br>
									ghjghjtrydfgsg
								</p>
								<p class="admin_desc">관리자 | 2017-11-18</p>
							</td>
						</tr>
					</tbody>
				</table>
				<script>
					$(function(){
						$(".btn_dropdown").click(function(){
							$(this).next().toggleClass("toggle");
						});
					});
				</script>
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

<jsp:include page="include/footer.jsp" />