/* 회원테이블 */
CREATE TABLE tr_member (
	m_userid VARCHAR2(20) NOT NULL, /* 아이디 */
	m_pw VARCHAR2(20) NOT NULL, /* 패스워드 */
	m_name VARCHAR2(20) NOT NULL, /* 이름 */
	m_email VARCHAR2(50) NOT NULL, /* 이메일 */
	m_post VARCHAR2(20) NOT NULL, /* 우편번호 */
	m_addr VARCHAR2(100) NOT NULL, /* 주소 */
	m_phone VARCHAR2(20) NOT NULL, /* 전화번호 */
	m_level CHAR(1) NOT NULL, /* 등급 */
	ms_code CHAR(1) NOT NULL /* 마스터코드값 */
);

COMMENT ON TABLE tr_member IS '회원테이블';

COMMENT ON COLUMN tr_member.m_userid IS '회원 아이디';

COMMENT ON COLUMN tr_member.m_pw IS '회원 비밀번호';

COMMENT ON COLUMN tr_member.m_name IS '회원 이름';

COMMENT ON COLUMN tr_member.m_email IS '이메일';

COMMENT ON COLUMN tr_member.m_post IS '우편번호';

COMMENT ON COLUMN tr_member.m_addr IS '주소';

COMMENT ON COLUMN tr_member.m_phone IS '전화번호';

COMMENT ON COLUMN tr_member.m_level IS '서브코드';

COMMENT ON COLUMN tr_member.ms_code IS '마스터코드값 1';

CREATE UNIQUE INDEX PK_tr_member
	ON tr_member (
		m_userid ASC
	);

ALTER TABLE tr_member
	ADD
		CONSTRAINT PK_tr_member
		PRIMARY KEY (
			m_userid
		);

/* 상품테이블 */
CREATE TABLE tr_food (
	f_fdcode VARCHAR2(20) NOT NULL, /* 상품코드 */
	e_evtcode VARCHAR2(20), /* 이벤트코드 */
	f_foodname VARCHAR2(100) NOT NULL, /* 상품명 */
	fc_1st NUMBER NOT NULL, /* 대분류 */
	fc_2nd NUMBER NOT NULL, /* 중분류 */
	fc_3rd NUMBER NOT NULL, /* 소분류 */
	f_price NUMBER NOT NULL, /* 가격 */
	f_explan VARCHAR2(1000), /* 상세설명 */
	f_imgname VARCHAR2(2000), /* 이미지명 */
	f_thumname VARCHAR2(2000), /* 썸네일명 */
	f_isblock CHAR(1) NOT NULL, /* 블락여부 */
	ms_code CHAR(1) NOT NULL /* 마스터코드값 */
);

COMMENT ON TABLE tr_food IS '상품테이블';

COMMENT ON COLUMN tr_food.f_fdcode IS '상품 아이디';

COMMENT ON COLUMN tr_food.e_evtcode IS '이벤트코드';

COMMENT ON COLUMN tr_food.f_foodname IS '상품명';

COMMENT ON COLUMN tr_food.fc_1st IS '지역:1/TV:2';

COMMENT ON COLUMN tr_food.fc_2nd IS '지역';

COMMENT ON COLUMN tr_food.fc_3rd IS '구성';

COMMENT ON COLUMN tr_food.f_price IS '기본금';

COMMENT ON COLUMN tr_food.f_explan IS '상세설명';

COMMENT ON COLUMN tr_food.f_imgname IS '이미지명';

COMMENT ON COLUMN tr_food.f_thumname IS '썸네일명';

COMMENT ON COLUMN tr_food.f_isblock IS '서브코드';

COMMENT ON COLUMN tr_food.ms_code IS '마스터코드값 2';

CREATE UNIQUE INDEX PK_tr_food
	ON tr_food (
		f_fdcode ASC
	);

ALTER TABLE tr_food
	ADD
		CONSTRAINT PK_tr_food
		PRIMARY KEY (
			f_fdcode
		);

/* 분류코드 */
CREATE TABLE tr_foodcode (
	fc_1st NUMBER NOT NULL, /* 대분류 */
	fc_2nd NUMBER NOT NULL, /* 중분류 */
	fc_3rd NUMBER NOT NULL, /* 소분류 */
	fc_ctgname VARCHAR2(20) NOT NULL, /* 카테고리명 */
	fc_isblock CHAR(1) NOT NULL /* 블락여부 */
);

COMMENT ON TABLE tr_foodcode IS '분류코드';

COMMENT ON COLUMN tr_foodcode.fc_1st IS '지역:1/TV:2';

COMMENT ON COLUMN tr_foodcode.fc_2nd IS '지역';

COMMENT ON COLUMN tr_foodcode.fc_3rd IS '구성';

COMMENT ON COLUMN tr_foodcode.fc_ctgname IS '카테고리명';

COMMENT ON COLUMN tr_foodcode.fc_isblock IS '0:정상, 1:블락';

/* 주문테이블 */
CREATE TABLE tr_order (
	o_orderid VARCHAR2(20) NOT NULL, /* 주문코드 */
	d_status CHAR(1) NOT NULL, /* 배송코드 */
	m_userid VARCHAR2(20) NOT NULL, /* 아이디 */
	f_fdcode VARCHAR2(20) NOT NULL, /* 상품코드 */
	o_buyprice NUMBER NOT NULL, /* 구입가격 */
	o_amount NUMBER NOT NULL, /* 구매수량 */
	o_orderdate DATE NOT NULL, /* 주문날짜 */
	o_reciever VARCHAR2(20) NOT NULL, /* 수취인 */
	o_dvypost VARCHAR2(20) NOT NULL, /* 배송지우편번호 */
	o_dvyaddr VARCHAR2(100) NOT NULL, /* 배송지주소 */
	ms_code CHAR(1) NOT NULL /* 마스터코드값 */
);

COMMENT ON TABLE tr_order IS '주문테이블';

COMMENT ON COLUMN tr_order.o_orderid IS '주문코드';

COMMENT ON COLUMN tr_order.d_status IS '서브코드';

COMMENT ON COLUMN tr_order.m_userid IS '아이디';

COMMENT ON COLUMN tr_order.f_fdcode IS '상품코드';

COMMENT ON COLUMN tr_order.o_buyprice IS '할인적용된구입가';

COMMENT ON COLUMN tr_order.o_amount IS '구매수량';

COMMENT ON COLUMN tr_order.o_orderdate IS '주문날짜';

COMMENT ON COLUMN tr_order.o_reciever IS '수취인';

COMMENT ON COLUMN tr_order.o_dvypost IS '배송지우편번호';

COMMENT ON COLUMN tr_order.o_dvyaddr IS '배송지주소';

COMMENT ON COLUMN tr_order.ms_code IS '마스터코드값 4';

CREATE UNIQUE INDEX PK_tr_order
	ON tr_order (
		m_userid ASC,
		f_fdcode ASC
	);

ALTER TABLE tr_order
	ADD
		CONSTRAINT PK_tr_order
		PRIMARY KEY (
			m_userid,
			f_fdcode
		);

/* 장바구니 */
CREATE TABLE tr_basket (
	m_userid VARCHAR2(20) NOT NULL, /* 아이디 */
	f_fdcode VARCHAR2(20) NOT NULL, /* 상품코드 */
	b_buyprice NUMBER NOT NULL, /* 구입가격 */
	b_amount NUMBER NOT NULL /* 구매수량 */
);

COMMENT ON TABLE tr_basket IS '장바구니';

COMMENT ON COLUMN tr_basket.m_userid IS '아이디';

COMMENT ON COLUMN tr_basket.f_fdcode IS '상품코드';

COMMENT ON COLUMN tr_basket.b_buyprice IS '할인적용된구입가';

COMMENT ON COLUMN tr_basket.b_amount IS '구매수량';

/* 후기테이블 */
CREATE TABLE tr_review (
	r_rvcode VARCHAR2(20) NOT NULL, /* 후기코드 */
	m_userid VARCHAR2(20) NOT NULL, /* 아이디 */
	f_fdcode VARCHAR2(20) NOT NULL, /* 상품코드 */
	r_title VARCHAR2(50) NOT NULL, /* 제목 */
	r_rvcontents VARCHAR2(3000) NOT NULL, /* 후기 */
	r_grade NUMBER, /* 평점 */
	r_rvimgname VARCHAR2(1000), /* 이미지명 */
	r_rvcount NUMBER, /* 조회수 */
	r_rvdate DATE, /* 글등록시간 */
	r_admincmt VARCHAR2(100), /* 관리자댓글 */
	r_admindate DATE /* 관리자댓글시간 */
);

COMMENT ON TABLE tr_review IS '후기테이블';

COMMENT ON COLUMN tr_review.r_rvcode IS '후기코드';

COMMENT ON COLUMN tr_review.m_userid IS '아이디';

COMMENT ON COLUMN tr_review.f_fdcode IS '상품코드';

COMMENT ON COLUMN tr_review.r_title IS '제목';

COMMENT ON COLUMN tr_review.r_rvcontents IS '후기글';

COMMENT ON COLUMN tr_review.r_grade IS '평점';

COMMENT ON COLUMN tr_review.r_rvimgname IS '리뷰이미지명';

COMMENT ON COLUMN tr_review.r_rvcount IS '조회수';

COMMENT ON COLUMN tr_review.r_rvdate IS '글등록시간';

COMMENT ON COLUMN tr_review.r_admincmt IS '관리자댓글';

COMMENT ON COLUMN tr_review.r_admindate IS '관리자댓글시간';

CREATE UNIQUE INDEX PK_tr_review
	ON tr_review (
		r_rvcode ASC,
		m_userid ASC,
		f_fdcode ASC
	);

ALTER TABLE tr_review
	ADD
		CONSTRAINT PK_tr_review
		PRIMARY KEY (
			r_rvcode,
			m_userid,
			f_fdcode
		);

/* 이벤트 */
CREATE TABLE tr_event (
	e_evtcode VARCHAR2(20) NOT NULL, /* 이벤트코드 */
	e_nttilte VARCHAR2(100), /* 제목 */
	e_gubun CHAR(1), /* 구분 */
	e_ntdate DATE, /* 작성날짜 */
	e_ntcontens VARCHAR2(2000), /* 내용 */
	e_ntimgname VARCHAR2(2000), /* 이미지 */
	e_discount CHAR(1), /* 할인율 */
	e_startdate DATE, /* 시작날짜 */
	e_enddate DATE, /* 종료날짜 */
	ms_code CHAR(1) NOT NULL /* 마스터코드값 */
);

COMMENT ON TABLE tr_event IS '이벤트';

COMMENT ON COLUMN tr_event.e_evtcode IS '이벤트 코드';

COMMENT ON COLUMN tr_event.e_nttilte IS '제목';

COMMENT ON COLUMN tr_event.e_gubun IS '서브코드';

COMMENT ON COLUMN tr_event.e_ntdate IS '작성날짜';

COMMENT ON COLUMN tr_event.e_ntcontens IS '내용';

COMMENT ON COLUMN tr_event.e_ntimgname IS '이미지';

COMMENT ON COLUMN tr_event.e_discount IS '서브코드';

COMMENT ON COLUMN tr_event.e_startdate IS '시작날짜';

COMMENT ON COLUMN tr_event.e_enddate IS '종료날짜';

COMMENT ON COLUMN tr_event.ms_code IS '마스터코드값 3';

CREATE UNIQUE INDEX PK_tr_event
	ON tr_event (
		e_evtcode ASC
	);

ALTER TABLE tr_event
	ADD
		CONSTRAINT PK_tr_event
		PRIMARY KEY (
			e_evtcode
		);

/* 마스터코드 */
CREATE TABLE tr_mastercode (
	ms_code CHAR(1) NOT NULL, /* 코드 */
	ms_name VARCHAR2(50) NOT NULL /* 코드명 */
);

COMMENT ON TABLE tr_mastercode IS '마스터코드';

COMMENT ON COLUMN tr_mastercode.ms_code IS '코드';

COMMENT ON COLUMN tr_mastercode.ms_name IS '코드명';

CREATE UNIQUE INDEX PK_tr_mastercode
	ON tr_mastercode (
		ms_code ASC
	);

ALTER TABLE tr_mastercode
	ADD
		CONSTRAINT PK_tr_mastercode
		PRIMARY KEY (
			ms_code
		);

/* 서브코드 */
CREATE TABLE tr_subcode (
	ms_code CHAR(1) NOT NULL, /* 코드 */
	sub_code CHAR(1) NOT NULL, /* 서브코드 */
	sub_name VARCHAR2(50) NOT NULL /* 서브코드명 */
);

COMMENT ON TABLE tr_subcode IS '서브코드';

COMMENT ON COLUMN tr_subcode.ms_code IS '마스터코드';

COMMENT ON COLUMN tr_subcode.sub_code IS '서브코드';

COMMENT ON COLUMN tr_subcode.sub_name IS '코드명';

ALTER TABLE tr_food
	ADD
		CONSTRAINT FK_tr_event_TO_tr_food
		FOREIGN KEY (
			e_evtcode
		)
		REFERENCES tr_event (
			e_evtcode
		);

ALTER TABLE tr_basket
	ADD
		CONSTRAINT FK_tr_member_TO_tr_basket
		FOREIGN KEY (
			m_userid
		)
		REFERENCES tr_member (
			m_userid
		);

ALTER TABLE tr_basket
	ADD
		CONSTRAINT FK_tr_food_TO_tr_basket
		FOREIGN KEY (
			f_fdcode
		)
		REFERENCES tr_food (
			f_fdcode
		);

ALTER TABLE tr_review
	ADD
		CONSTRAINT FK_tr_member_TO_tr_review
		FOREIGN KEY (
			m_userid
		)
		REFERENCES tr_member (
			m_userid
		);

ALTER TABLE tr_review
	ADD
		CONSTRAINT FK_tr_food_TO_tr_review
		FOREIGN KEY (
			f_fdcode
		)
		REFERENCES tr_food (
			f_fdcode
		);

ALTER TABLE tr_subcode
	ADD
		CONSTRAINT FK_tr_mastercode_TO_tr_subcode
		FOREIGN KEY (
			ms_code
		)
		REFERENCES tr_mastercode (
			ms_code
		);