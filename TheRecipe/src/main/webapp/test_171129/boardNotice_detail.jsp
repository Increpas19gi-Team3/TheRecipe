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
				<table>
					<thead>
						<tr>
							<th>이벤트 코드</th>
							<th>제목</th>
							<th>구분</th>
							<th>작성일</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								16
							</td>
							<td> 
								개인정보처리방침 개정 안내
							</td>
							<td>
								0
							</td>
							<td>
								2017.10.19
							</td>
						</tr>
						<tr>
							<td colspan="4">
								내용<br>
								내용<br>
								내용<br>
								내용<br>
								내용<br>
							</td>
						</tr>
						<tr>
							<td>
								할인율
							</td>
							<td> 
								시작날짜
							</td>
							<td>
								종료날짜
							</td>
							<td>
								마스터코드
							</td>
						</tr>
						<tr>
							<td>
								0
							</td>
							<td> 
								2017-12-04 09:52:57
							</td>
							<td>
								2017-12-04 00:00:00
							</td>
							<td>
								0
							</td>
						</tr>
					</tbody>
				</table>
				<div class="pagination_wrap">
					<div class="btn_right">
						<a href="">목록</a>
					</div>
				</div>
			</div>
		</div>
	</div>

<jsp:include page="include/footer.jsp" />