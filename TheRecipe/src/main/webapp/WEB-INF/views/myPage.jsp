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
							<li><a href="boardNotice.html">��������</a></li>
							<li><a href="boardReview.html">�ı� �Խ���</a></li>
							<li><a href="boardRecommend.html">��õ ������</a></li>
							<li><a href="boardEvent.html">�̺�Ʈ</a></li>
						</ul>
					</li>
				</ul>
			</div>
			<div class="nav_right">
				<ul>
					<li class="dropdown_wrap"><a href="login.html">�α���</a></li>
					<li><a href="join.html">ȸ������</a></li>
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
	<div class="container myPage board">
		<div class="row">
			<div class="left_tab">
				<h2>������</h2>
				<ul>
					<li class="active"><a href="myPage.html">����������</a></li>
					<li><a href="myorder.html">�ֹ� ��ȸ</a></li>
					<li><a href="myWrite.html">���� �� ��</a></li>
				</ul>
				<div class="service_info">
					<h4>����� ������</h4>
					<h3>1899-2468</h3>
					<hr>
					<p>���� 06:30 ~ 18:00</p>
					<p>�ָ� 06:30 ~ 15:00</p>
					<p>������ �޹�</p>
				</div>
			</div>
			<div class="right_contnet">
				<h3>
					����������
					<div class="page_locationBOx">
						<a href="home.html">Ȩ</a>
						<span> > </span>
						<a href="join.html">����������</a>
						<span> > </span>
						<a href="join.html" class="active">����������</a>
					</div>
				</h3>
				<form:form action="" method="post">
					<fieldset>
						<label for="">���̵�</label>
						<input type="text" placeholder="���̵�" value="${mVo.m_userid}" required="" disabled="disabled">
					</fieldset>
					<fieldset>
						<label for="">��й�ȣ</label>
						<input type="password" placeholder="��й�ȣ" required="">
					</fieldset>
					<fieldset>
						<label for="">��й�ȣ Ȯ��</label>
						<input type="password" placeholder="��й�ȣ Ȯ��" required="">
					</fieldset>
					<fieldset>
						<label for="">�̸���</label>
						<input type="email" value="${mVo.m_email}" placeholder="�̸���" required="">
					</fieldset>
					<fieldset>
						<label for="">�̸�</label>
						<input type="text" value="${mVo.m_name}" placeholder="�̸�" required="" disabled="disabled">
					</fieldset>
					<fieldset>
						<label for="">�����ȣ</label>
						<input type="text" value="${mVo.m_post}"placeholder="�����ȣ" required="">
					</fieldset>
					<fieldset>
						<label for="">�ּ�</label>
						<input type="text" value="${mVo.m_addr}" placeholder="�ּ�" required="" class="address_input">
					</fieldset>
					<fieldset>
						<label for="">��ȭ��ȣ</label>
						<input type="text" value="${mVo.m_phone}" placeholder="��ȭ��ȣ" required="">
					</fieldset>
					
					<hr>
					<fieldset class="btn_submitWrap">
						<input type="submit" value="����" class="btn_submit">
						<a href="#" onClick="history.back(); return false;" class="btn_back">���</a>
					</fieldset>
				</form:form>
				<div class="bottom_box">
					<p>Ż�� ���Ͻø� ȸ��Ż�� ��ư�� �����ּ���.</p>
					<a href="">ȸ��Ż��</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>