<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<jsp:include page="include/header.jsp" />

	<div class="container boardNotice board">
		<div class="row">
			<div class="left_tab">
				<h2>고객센터</h2>
				<ul>
					<li class="active"><a href="http://localhost:8282/therecipe/test_171129/boardNotice.jsp">공지사항</a></li>
					<li><a href="http://localhost:8282/therecipe/test_171129/boardReview.jsp">후기 게시판</a></li>
					<li><a href="http://localhost:8282/therecipe/test_171129/boardRecommend.jsp">추천 레시피</a></li>
					<li><a href="http://localhost:8282/therecipe/test_171129/boardEvent.jsp">이벤트</a></li>
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
					공지사항
					<div class="page_locationBox">
						<a href="http://localhost:8282/therecipe/test_171129/home.jsp">홈</a>
						<span> > </span>
						<a href="join.html">커뮤니티</a>
						<span> > </span>
						<a href="join.html" class="active">공지사항</a>
					</div>
				</h3>
				<div class="table_top">
					<div class="searchBox">
						<form action="">
							<input type="text">
							<button type="submit"></button>
						</form>
					</div>
				</div>
				<table>
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								공지
							</td>
							<td class="text_left"> 
								<a href="#">개인정보처리방침 개정 안내</a>
							</td>
							<td>
								관리자
							</td>
							<td>
								2017.10.19
							</td>
						</tr>
						<tr>
							<td>
								공지
							</td>
							<td class="text_left"> 
								<a href="#">개인정보처리방침 개정 안내</a>
							</td>
							<td>
								관리자
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
					<div class="btn_right">
						<a href="boardReviewWrite.html">글쓰기</a>
					</div>
				</div>
			</div>
		</div>
	</div>

<jsp:include page="include/footer.jsp" />