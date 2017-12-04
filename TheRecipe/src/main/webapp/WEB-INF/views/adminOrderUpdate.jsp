<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="adminheader.jsp" />

   <div class="content-wrapper">
        <div class="container-fluid">
            <ol class="breadcrumb">
                <li class="breadcrumb-item">주문 상태 변경</li>
                <!-- <li class="breadcrumb-item active">Update</li> -->
            </ol>
            <div class="card card-register mx-auto mt-5">
                <div class="card-header">상품 수정</div>
                <div class="card-body">
                    <form>
                        <div class="form-group">
                            <div class="col-md-12">
                                <label for="">아이디</label>
                                <input class="form-control" name="userid" id="" type="text" aria-describedby="nameHelp" placeholder="아이디" value="${odvo.m_userid }" readonly="readonly">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-12">
                                <label for="">주문코드</label>
                                <input class="form-control" name="orderid" id="" type="text" aria-describedby="nameHelp" placeholder="주문코드" value="${odvo.o_orderid }" readonly="readonly">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-12">
                                <label for="">주문코드</label>
                                <select name="dvystatus">
                                	<option value="0" selected="selected">입금대기</option>
                                	<option value="1">입금확인</option>
                                	<option value="2">상품준비</option>
                                	<option value="3">배송준비</option>
                                	<option value="4">배송중</option>
                                	<option value="5">배송완료</option>
                                </select>
                            </div>
                        </div>
                       
                        <button type="submit" class="btn btn-primary btn-block" href="">변경</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>

</html>