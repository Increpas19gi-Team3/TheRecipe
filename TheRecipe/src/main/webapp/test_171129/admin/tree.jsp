<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="include/header.jsp" />

    <div class="content-wrapper">
        <div class="container-fluid">
        	<div class="con_col2">
        		<div class="con_left">
	        		<ul id="compositions-list" class="pure-tree main-tree">
				        <li>
				            <input type="checkbox" id="trigger-root" checked="checked">
				            <label for="trigger-root">root</label>
				            <ul class="pure-tree">
				                <li>
				                    <input type="checkbox" id="trigger-wldur">
				                    <label for="trigger-wldur">지역 (<b>2</b>)</label>
				                    <ul class="pure-tree">
				                        <li>
				                            <input type="checkbox" id="trigger-gkstlr">
				                            <label for="trigger-gkstlr">한식 (<b>2</b>)</label>
				                            <ul class="pure-tree">
				                                <li>
								                    <input type="checkbox" id="trigger-Wlro">
								                    <label for="trigger-Wlro">찌개 (<b>2</b>)</label>
								                    <ul class="pure-tree">
								                        <li>
								                            <input type="checkbox" id="trigger-ehlswkdWlro">
								                            <label for="trigger-ehlswkdWlro">된장찌개</label>
								                            <ul class="pure-tree">
								                                <li class="pure-tree_link"></li>
								                            </ul>
								                        </li>
								                        <li>
								                            <input type="checkbox" id="trigger-rlaclWlro">
								                            <label for="trigger-rlaclWlro">김치찌개</label>
								                            <ul class="pure-tree">
								                                <li class="pure-tree_link"></li>
								                            </ul>
								                        </li>
								                    </ul>
								                </li>
								                <li>
								                    <input type="checkbox" id="trigger-goanf">
								                    <label for="trigger-goanf">해물 (<b>2</b>)</label>
								                    <ul class="pure-tree">
								                        <li>
								                            <input type="checkbox" id="trigger-todnxkd">
								                            <label for="trigger-todnxkd">새우탕</label>
								                            <ul class="pure-tree">
								                                <li class="pure-tree_link"></li>
								                            </ul>
								                        </li>
								                        <li>
								                            <input type="checkbox" id="trigger-goanffkaus">
								                            <label for="trigger-goanffkaus">해물라면</label>
								                            <ul class="pure-tree">
								                                <li class="pure-tree_link"></li>
								                            </ul>
								                        </li>
								                    </ul>
								                </li>
				                            </ul>
				                        </li>
				                        <li>
				                            <input type="checkbox" id="trigger-wndtlr">
				                            <label for="trigger-wndtlr">중식 (<b>2</b>)</label>
				                            <ul class="pure-tree">
				                                <li>
								                    <input type="checkbox" id="trigger-eksvna">
								                    <label for="trigger-eksvna">단품 (<b>2</b>)</label>
								                    <ul class="pure-tree">
								                        <li>
								                            <input type="checkbox" id="trigger-Wkwkdaus">
								                            <label for="trigger-Wkwkdaus">짜장면</label>
								                            <ul class="pure-tree">
								                                <li class="pure-tree_link"></li>
								                            </ul>
								                        </li>
								                        <li>
								                            <input type="checkbox" id="trigger-WkaQhd">
								                            <label for="trigger-WkaQhd">짬뽕</label>
								                            <ul class="pure-tree">
								                                <li class="pure-tree_link"></li>
								                            </ul>
								                        </li>
								                    </ul>
								                </li>
								                <li>
								                    <input type="checkbox" id="trigger-dyfl">
								                    <label for="trigger-dyfl">요리 (<b>2</b>)</label>
								                    <ul class="pure-tree">
								                        <li>
								                            <input type="checkbox" id="trigger-Rksvndrl">
								                            <label for="trigger-Rksvndrl">깐풍기</label>
								                            <ul class="pure-tree">
								                                <li class="pure-tree_link"></li>
								                            </ul>
								                        </li>
								                        <li>
								                            <input type="checkbox" id="trigger-WkaQhdqkq">
								                            <label for="trigger-WkaQhdqkq">짬뽕밥</label>
								                            <ul class="pure-tree">
								                                <li class="pure-tree_link"></li>
								                            </ul>
								                        </li>
								                    </ul>
								                </li>
				                            </ul>
				                        </li>
				                    </ul>
				                </li>
				                <li>
				                    <input type="checkbox" id="trigger-a2">
				                    <label for="trigger-a2">TV (<b>1</b>)</label>
				                    <ul class="pure-tree">
				                        <li>
				                            <input type="checkbox" id="trigger-header">
				                            <label for="trigger-header">냉장고를 부탁해</label>
				                            <ul class="pure-tree">
				                                <li class="pure-tree_link"></li>
				                            </ul>
				                        </li>
				                    </ul>
				                </li>
				            </ul>
				        </li>
				    </ul>
	        	</div>
			    <div class="con_right">
			    	<div class="card-body">
			    		<div class="col-md-12">
		                    <form>
		                        <div class="form-group">
	                                <label for="">카테고리 위치</label>
	                                <select class="form-control">
										<option>1</option>
										<option>2</option>
										<option>3</option>
										<option>4</option>
										<option>5</option>
									</select>
									<select class="form-control">
										<option>1</option>
										<option>2</option>
									</select>
									<select class="form-control">
										<option>1</option>
										<option>2</option>
									</select>
		                        </div>
		                        <div class="form-group">
	                                <label for="">카테고리 이름</label>
	                                <input class="form-control" id="" type="text" aria-describedby="nameHelp" placeholder="카테고리 이름">
		                        </div>
		                        <div class="form-group">
		                        	<label for="">카테고리 사용여부</label>
		                        	<p>
		                        		<label>
									      <input type="radio" name="asd"> 사용
									    </label>
									    <label>
									      <input type="radio" name="asd"> 미사용
									    </label>
		                        	</p>
								</div>
		                        <button type="submit" class="btn btn-primary btn-block" href="">등록</button>
		                    </form>
	                    </div>
	                </div>
			    </div>
        	</div>
        	
        </div>
    </div>
</body>

</html>