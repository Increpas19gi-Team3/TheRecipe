<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>BRAND</title>
	<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="header">
		<div class="logo">BRAND</div>
		<div class="nav_wrap">
			<div class="nav_left">
				<ul>
					<li class="dropdown_wrap">
						<a href="" class="dropdown_select">�з�</a>
						<ul class="dropdown_itemWrap">
							<li><a href="">�ѽ�</a></li>
							<li><a href="">�߽�</a></li>
							<li><a href="">���</a></li>
						</ul>
					</li>
					<li class="dropdown_wrap">
						<a href="" class="dropdown_select">���� TV ������</a>
						<ul class="dropdown_itemWrap">
							<li><a href="">�ѽ�</a></li>
							<li><a href="">�߽�</a></li>
							<li><a href="">���</a></li>
						</ul>
					</li>
					<li class="dropdown_wrap">
						<a href="" class="dropdown_select">Ŀ�´�Ƽ</a>
						<ul class="dropdown_itemWrap">
							<li><a href="">�ѽ�</a></li>
							<li><a href="">�߽�</a></li>
							<li><a href="">���</a></li>
						</ul>
					</li>
				</ul>
			</div>
			<div class="nav_right">
				<ul>
					<li class="dropdown_wrap"><a href="login.html">�α���</a></li>
					<li><a href="">ȸ������</a></li>
					<li class="dropdown_wrap">
						<a href="" class="dropdown_select">����������</a>
						<ul class="dropdown_itemWrap">
							<li><a href="">�ֹ���Ȳ</a></li>
							<li><a href="">1:1 ����</a></li>
							<li><a href="">��ȯ/��ǰ</a></li>
							<li><a href="">������</a></li>
							<li><a href="">����������</a></li>
						</ul>
					</li>
					<li><a href="">��ٱ���</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="container login">
		<div class="login_wrap">
			<h3>��й�ȣ ã��</h3>
			<p>�Ʒ� ������ �Է� �� �ּ���.</p>
			<form:form commandName="pw_find" method="post" action="fine_Pw.do">
				<fieldset>
					<label for="">���̵�</label>
					<input type="text" id="m_userid" name="m_userid" placeholder="���̵�" required="">
					<form:errors path="m_userid"></form:errors>
				</fieldset>
				<fieldset>
					<input type="submit" value="��й�ȣ ã��" class="btn_submit">
				</fieldset>
			</form:form>
		</div>
	</div>
</body>
</html>