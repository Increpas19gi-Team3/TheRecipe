<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="adminheader.jsp" />

   <div class="content-wrapper">
        <div class="container-fluid">
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <a href="index.html">주문 내역 조회</a>
                </li><!-- 
                <li class="breadcrumb-item active">Table</li> -->
            </ol>
            <div class="card mb-3">
                <!-- <div class="card-header">
                    <i class="fa fa-table"></i> Data Table Example</div> -->
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                                <tr>
                                    <th>주문코드</th>
                                    <th>아이디</th>
                                    <th>상품코드</th>
                                    <th>수취인</th>
                                    <td>배송상태</td>
                                    <td>주문날짜</td>
                                </tr>
                            </thead>
                            <tbody>
                            	<c:forEach var="order" items="${odvo}">
	                                <tr>
	                                    <td>${order.o_orderid }</td>
	                                    <td>${order.m_userid }</td>
	                                    <td>${order.f_fdcode }</td>
	                                    <td>${order.o_reciever }</td>
	                                    <td><a href="adminOrderUpdate.do?orderid=${order.o_orderid}">${order.d_status }</a></td>
	                                    <td>${order.o_orderdate }</td>
	                                </tr>
                                </c:forEach>
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