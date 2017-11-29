<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="include/header.jsp" />

    <div class="content-wrapper">
        <div class="container-fluid">
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <a href="index.html">The Recipe</a>
                </li>
                <li class="breadcrumb-item active">Write</li>
            </ol>
            <div class="card card-register mx-auto mt-5">
                <div class="card-header">상품 등록</div>
                <div class="card-body">
                    <form>
                        <div class="form-group">
                            <div class="col-md-12">
                                <label for="">상품 이름</label>
                                <input class="form-control" id="" type="text" aria-describedby="nameHelp" placeholder="상품 이름">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-12">
                                <label for="">상품 가격</label>
                                <input class="form-control" id="" type="text" aria-describedby="nameHelp" placeholder="상품 가격">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-12">
                                <label for="">상품 이미지_1</label>
                                <input class="form-control" id="" type="file" aria-describedby="nameHelp">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-12">
                                <label for="">상품 이미지_2</label>
                                <input class="form-control" id="" type="file" aria-describedby="nameHelp">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-12">
                                <label for="">상품 이미지_3</label>
                                <input class="form-control" id="" type="file" aria-describedby="nameHelp">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-12">
                                <label for="">상품 이미지_4</label>
                                <input class="form-control" id="" type="file" aria-describedby="nameHelp">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-12">
                                <label for="">상품 이미지_5</label>
                                <input class="form-control" id="" type="file" aria-describedby="nameHelp">
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary btn-block" href="">수정</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>

</html>