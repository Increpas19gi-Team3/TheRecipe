<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>The Recipe</title>
    <link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="vendor/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="vendor/datatables/dataTables.bootstrap4.css">
    <link rel="stylesheet" href="css/sb-admin.css">
    <link rel="stylesheet" href="css/style.css">
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
    <script src="vendor/chart.js/Chart.min.js"></script>
    <script src="vendor/datatables/jquery.dataTables.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.js"></script>
    <script src="js/sb-admin.min.js"></script>
    <script src="js/sb-admin-datatables.min.js"></script>
    <script src="js/sb-admin-charts.min.js"></script>
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
        <a class="navbar-brand" href="index.html">The Recipe</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
                <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Example Pages">
                    <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseExamplePages" data-parent="#exampleAccordion">
						<i class="fa fa-fw fa-wrench"></i>
						<span class="nav-link-text">상품 관리</span>
					</a>
                    <ul class="sidenav-second-level collapse" id="collapseExamplePages">
                        <li>
                            <a href="http://localhost:8282/therecipe/test_171129/admin/table.jsp">목록</a>
                        </li>
                        <li>
                            <a href="http://localhost:8282/therecipe/test_171129/admin/write.jsp">등록</a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Example Pages">
                    <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseExamplePages2" data-parent="#exampleAccordion">
						<i class="fa fa-fw fa-wrench"></i>
						<span class="nav-link-text">유명 TV 레시피 관리</span>
					</a>
                    <ul class="sidenav-second-level collapse" id="collapseExamplePages2">
                        <li>
                            <a href="http://localhost:8282/therecipe/test_171129/admin/table.jsp">목록</a>
                        </li>
                        <li>
                            <a href="http://localhost:8282/therecipe/test_171129/admin/write.jsp">등록</a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Menu Levels">
                    <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseMulti" data-parent="#exampleAccordion">
            <i class="fa fa-fw fa-sitemap"></i>
            <span class="nav-link-text">커뮤니티 관리</span>
          </a>
                    <ul class="sidenav-second-level collapse" id="collapseMulti">
                        <li>
                            <a class="nav-link-collapse collapsed" data-toggle="collapse" href="#collapseMulti1">공지사항 관리</a>
                            <ul class="sidenav-third-level collapse" id="collapseMulti1">
                                <li>
                                    <a href="http://localhost:8282/therecipe/test_171129/admin/table.jsp">목록</a>
                                </li>
                                <li>
                                    <a href="http://localhost:8282/therecipe/test_171129/admin/write.jsp">등록</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a class="nav-link-collapse collapsed" data-toggle="collapse" href="#collapseMulti2">후기 게시판 관리</a>
                            <ul class="sidenav-third-level collapse" id="collapseMulti2">
                                <li>
                                    <a href="http://localhost:8282/therecipe/test_171129/admin/tablesp">목록</a>
                                </li>
                                <li>
                                    <a href="http://localhost:8282/therecipe/test_171129/admin/write.jsp">등록</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a class="nav-link-collapse collapsed" data-toggle="collapse" href="#collapseMulti3">추천 레시피 관리</a>
                            <ul class="sidenav-third-level collapse" id="collapseMulti3">
                               <li>
                                    <a href="http://localhost:8282/therecipe/test_171129/admin/table.jsp">목록</a>
                                </li>
                                <li>
                                    <a href="http://localhost:8282/therecipe/test_171129/admin/write.jsp">등록</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a class="nav-link-collapse collapsed" data-toggle="collapse" href="#collapseMulti4">이벤트 관리</a>
                            <ul class="sidenav-third-level collapse" id="collapseMulti4">
                                <li>
                                    <a href="http://localhost:8282/therecipe/test_171129/admin/table.jsp">목록</a>
                                </li>
                                <li>
                                    <a href="http://localhost:8282/therecipe/test_171129/admin/write.jsp">등록</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>