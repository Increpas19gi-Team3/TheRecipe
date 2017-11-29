<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="adminheader.jsp" />

    <div class="content-wrapper">
        <div class="container-fluid">
        	
        	
        	<h1>
				관리자 화면
			</h1>
			
				손가연 개발부분:
				<ul>
					<li><a href="loginTest.do"> test 페이지 </a></li>
					<li><a href="regCategory.do"> 카테고리 관리(등록) </a></li>
					<li><a href="modifyCategory.do"> 카테고리 관리(수정,삭제) </a></li>
					<li><a href="adminFoodMgr.do"> 음식 정보 관리(전체) </a></li>
					<li>음식 정보 관리(TV) <a href=""></a></li>
					<li><a href="adminEventMgr.do"> 이벤트 설정 </a></li>
					<li><a href="testJQuery.do"> 이벤트 설정 </a></li>
				</ul>
			
				손대성 개발부분:
				<ul>
					<li><a href="NoticeList.do">공지사항 목록</a></li>
					<li><a href="EventList.do"> 이벤트 목록 </a></li>
					<li><a href=""> </a></li>
					<li><a href=""> </a></li>
					<li><a href=""> </a></li>
					<li><a href=""> </a></li>
				</ul>
        	
        	
        		디자인 적용 샘플:
				<ul>
					<li><a href="admin_SampleTable.do">테이블</a></li>
					<li><a href="admin_SampleUpdate.do"> 수정 </a></li>
					<li><a href="admin_SampleWrite.do"> 등록 </a></li>
				</ul>
        	
        </div>
    </div>
</body>
</html>
