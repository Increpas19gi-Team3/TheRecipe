<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="include/header.jsp" />

	<div class="content-wrapper">
        <div class="container-fluid">
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <a href="index.html">The Recipe</a>
                </li>
                <li class="breadcrumb-item active">Table</li>
            </ol>
            <div class="card mb-3">
                <div class="card-header">
                    <i class="fa fa-table"></i> Data Table Example</div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                                <tr>
                                    <th>Name</th>
                                    <th>Position</th>
                                    <th>Office</th>
                                    <th>Age</th>
                                    <td></td>
                                    <td></td>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Tiger Nixon</td>
                                    <td><a href="">System Architect</a></td>
                                    <td>Edinburgh</td>
                                    <td>61</td>
                                    <td><a href="http://localhost:8282/therecipe/test_171129/admin/update.jsp">수정</a></td>
                                    <td><a href="">삭제</a></td>
                                </tr>
                                <tr>
                                    <td>Garrett Winters</td>
                                    <td><a href="">System Architect</a></td>
                                    <td>Tokyo</td>
                                    <td>63</td>
                                    <td><a href="http://localhost:8282/therecipe/test_171129/admin/update.jsp">수정</a></td>
                                    <td><a href="">삭제</a></td>
                                </tr>
                                <tr>
                                    <td>Ashton Cox</td>
                                    <td><a href="">System Architect</a></td>
                                    <td>San Francisco</td>
                                    <td>66</td>
                                    <td><a href="http://localhost:8282/therecipe/test_171129/admin/update.jsp">수정</a></td>
                                    <td><a href="">삭제</a></td>
                                </tr>
                                <tr>
                                    <td>Cedric Kelly</td>
                                    <td><a href="">System Architect</a></td>
                                    <td>Edinburgh</td>
                                    <td>22</td>
                                    <td><a href="http://localhost:8282/therecipe/test_171129/admin/update.jsp">수정</a></td>
                                    <td><a href="">삭제</a></td>
                                </tr>
                                <tr>
                                    <td>Airi Satou</td>
                                    <td><a href="">System Architect</a></td>
                                    <td>Tokyo</td>
                                    <td>33</td>
                                    <td><a href="http://localhost:8282/therecipe/test_171129/admin/update.jsp">수정</a></td>
                                    <td><a href="">삭제</a></td>
                                </tr>
                                <tr>
                                    <td>Brielle Williamson</td>
                                    <td><a href="">System Architect</a></td>
                                    <td>New York</td>
                                    <td>61</td>
                                    <td><a href="http://localhost:8282/therecipe/test_171129/admin/update.jsp">수정</a></td>
                                    <td><a href="">삭제</a></td>
                                </tr>
                                <tr>
                                    <td>Herrod Chandler</td>
                                    <td><a href="">System Architect</a></td>
                                    <td>San Francisco</td>
                                    <td>59</td>
                                    <td><a href="http://localhost:8282/therecipe/test_171129/admin/update.jsp">수정</a></td>
                                    <td><a href="">삭제</a></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
            </div>
        </div>
    </div>
</body>

</html>