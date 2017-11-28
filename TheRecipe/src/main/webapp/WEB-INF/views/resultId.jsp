<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<h3>���̵� ã��</h3>
			<form method="post" action="login.do">
				<fieldset>
				<table class="">
				<tr>
				<td colspan ="2" align="center">������ ���̵�� ${vo.m_userid} �Դϴ�.
				</td>
				</tr>
				</table>
					<a href="loginView.do">�α��� ȭ������</a>
				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>