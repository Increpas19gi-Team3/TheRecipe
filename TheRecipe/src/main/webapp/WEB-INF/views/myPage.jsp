<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp" />

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
					<div class="page_locationBox">
						<a href="home.html">Ȩ</a>
						<span> > </span>
						<a href="join.html">����������</a>
						<span> > </span>
						<a href="join.html" class="active">����������</a>
					</div>
				</h3>
				<form action="">
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
						<input type="text" value="${mVo.m_name}" placeholder="�̸�" required="">
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
				</form>
				<div class="bottom_box">
					<p>Ż�� ���Ͻø� ȸ��Ż�� ��ư�� �����ּ���.</p>
					<a href="">ȸ��Ż��</a>
				</div>
			</div>
		</div>
	</div>
	
<jsp:include page="footer.jsp" />