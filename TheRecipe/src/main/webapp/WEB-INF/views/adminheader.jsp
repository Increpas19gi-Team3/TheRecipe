<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>The Recipe</title>
    <link rel="stylesheet" href='<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css" />'>
    <link rel="stylesheet" href='<c:url value="/resources/vendor/font-awesome/css/font-awesome.min.css" />'>
    <link rel="stylesheet" href='<c:url value="/resources/vendor/datatables/dataTables.bootstrap4.css" />'>
    <link rel="stylesheet" href='<c:url value="/resources/css/sb-admin.css" />'>
    <link rel="stylesheet" href='<c:url value="/resources/css/adminstyle.css" /> '>
    <script src='<c:url value="/resources/vendor/jquery/jquery.min.js" />'></script>
    <script src='<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js" />'> </script>
    <script src='<c:url value="/resources/vendor/jquery-easing/jquery.easing.min.js" />'> </script>
    <script src='<c:url value="/resources/vendor/chart.js/Chart.min.js" />'> </script>
    <script src='<c:url value="/resources/vendor/datatables/jquery.dataTables.js" />'> </script>
    <script src='<c:url value="/resources/vendor/datatables/dataTables.bootstrap4.js" />'> </script>
    <script src='<c:url value="/resources/js/sb-admin.min.js" />'> </script>
    <script src='<c:url value="/resources/js/sb-admin-datatables.min.js" />'> </script>
    <script src='<c:url value="/resources/js/sb-admin-charts.min.js" />'> </script>
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    
    	<%-- WARN: 주소 차후에 바꿔야 할 수 있음 --%>
        <a class="navbar-brand" href="http://localhost:8282/therecipe/">The Recipe</a>
    
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
                
                <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Example Pages">
                    <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseExamplePages" data-parent="#exampleAccordion">
						<i class="fa fa-fw fa-wrench"></i>
						<span class="nav-link-text">음식 카테고리 관리</span>
					</a>
                    <ul class="sidenav-second-level collapse" id="collapseExamplePages">
                        <li>
                            <a href="regCategory.do">등록</a>
                        </li>
                        <li>
                            <a href="modifyCategory.do">수정</a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Example Pages">
                    <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseExamplePages2" data-parent="#exampleAccordion">
						<i class="fa fa-fw fa-wrench"></i>
						<span class="nav-link-text">음식 등록 관리</span>
					</a>
                    <ul class="sidenav-second-level collapse" id="collapseExamplePages2">
                        <li>
                            <a href="adminFoodMgr.do">목록</a>
                        </li>
                        <li>
                            <a href="regFoodMgr.do">등록</a>
                        </li>
                    </ul>
                </li>
                
                
                <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Example Pages">
                    <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseExamplePages3" data-parent="#exampleAccordion">
						<i class="fa fa-fw fa-wrench"></i>
						<span class="nav-link-text">이벤트 등록 관리</span>
					</a>
                    <ul class="sidenav-second-level collapse" id="collapseExamplePages3">
                        <li>
                            <a href="adminEventList.do">목록</a>
                        </li>
                        <li>
                            <a href="adminEventMgr.do">설정</a>
                        </li>
                    </ul>
                </li>
                
                
                <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Example Pages">
                    <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseExamplePages4" data-parent="#exampleAccordion">
						<i class="fa fa-fw fa-wrench"></i>
						<span class="nav-link-text">주문 관리</span>
					</a>
                    <ul class="sidenav-second-level collapse" id="collapseExamplePages4">
                        <li>
                            <a href="adminOrder.do">설정</a>
                        </li>
                    </ul>
                </li>
                
                
                <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Menu Levels">
                    <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseMulti" data-parent="#exampleAccordion">
            			<i class="fa fa-fw fa-sitemap"></i>
            			<span class="nav-link-text">커뮤니티 관리(손대성 개발 부분)</span>
         			</a>
                    <ul class="sidenav-second-level collapse" id="collapseMulti">
                        <li>
                            <a class="nav-link-collapse collapsed" data-toggle="collapse" href="#collapseMulti1">공지사항 관리</a>
                            <ul class="sidenav-third-level collapse" id="collapseMulti1">
                                <li>
                                    <a href="adminNoticeList.do">목록</a>
                                </li>
                                <!-- <li>
                                    <a href="write_1.html">등록</a>
                                </li> -->
                                <!-- <li>
                                    <a href="update_1.html">수정</a>
                                </li> -->
                            </ul>
                        </li>
                        <li>
                            <a class="nav-link-collapse collapsed" data-toggle="collapse" href="#collapseMulti2">후기 게시판 관리</a>
                            <ul class="sidenav-third-level collapse" id="collapseMulti2">
                                <li>
                                    <a href="adminReviewList.do">목록</a>
                                </li>
                                <!-- <li>
                                    <a href="write_1.html">등록</a>
                                </li>
                                <li>
                                    <a href="update_1.html">수정</a>
                                </li> -->
                            </ul>
                        </li>
                        <!-- <li>
                            <a class="nav-link-collapse collapsed" data-toggle="collapse" href="#collapseMulti3">추천 레시피 관리</a>
                            <ul class="sidenav-third-level collapse" id="collapseMulti3">
                                <li>
                                    <a href="table.html">목록</a>
                                </li>
                                <li>
                                    <a href="write_1.html">등록</a>
                                </li>
                                <li>
                                    <a href="update_1.html">수정</a>
                                </li>
                            </ul>
                        </li> -->
                        <li>
                            <a class="nav-link-collapse collapsed" data-toggle="collapse" href="#collapseMulti4">이벤트 관리</a>
                            <ul class="sidenav-third-level collapse" id="collapseMulti4">
                                <li>
                                    <a href="EventList.do">목록</a>
                                </li>
                                
                                <!-- <li>
                                    <a href="write_1.html">등록</a>
                                </li> -->
                                
                                <!-- <li>
                                    <a href="update_1.html">수정</a>
                                </li> -->
                            </ul>
                        </li>
                        
                    </ul>
                </li>
            </ul>
        </div>
    </nav>