/*회원 등록*/
INSERT INTO TR_MEMBER VALUES('admin','1234','관리자','admin@naver.com','12345','서울시 강동구','010-1234-5678','1','1'); /*최고관리자계정: 1*/
INSERT INTO TR_MEMBER VALUES('han','1234','한범석','han@naver.com','12345','서울시 강남구','010-1234-1234','0','1'); /*일반유저 : 0*/
INSERT INTO TR_MEMBER VALUES('son','1234','손가연','son@naver.com','12345','서울시 강동구','010-1234-5678','2','1'); /*일반 관리자: 2*/

/* 분류코드 등록*/
INSERT INTO tr_foodcode VALUES(1,0,0,'지역','0');
INSERT INTO tr_foodcode VALUES(2,0,0,'TV','0');



INSERT INTO tr_mastercode VALUES('1','회원');
INSERT INTO tr_mastercode VALUES('2','상품');
INSERT INTO tr_mastercode VALUES('3','이벤트');
INSERT INTO tr_mastercode VALUES('4','주문');

INSERT INTO tr_subcode VALUES('1','0','일반고객');
INSERT INTO tr_subcode VALUES('1','1','최고관리자');
INSERT INTO tr_subcode VALUES('1','2','일반관리자');
INSERT INTO tr_subcode VALUES('2','0','정상상품');
INSERT INTO tr_subcode VALUES('2','1','블락상품');
INSERT INTO tr_subcode VALUES('3','0','공지사항');
INSERT INTO tr_subcode VALUES('3','1','이벤트');
INSERT INTO tr_subcode VALUES('3','2','10');
INSERT INTO tr_subcode VALUES('3','3','20');
INSERT INTO tr_subcode VALUES('3','4','30');
INSERT INTO tr_subcode VALUES('4','0','입금대기');
INSERT INTO tr_subcode VALUES('4','1','입급확인');
INSERT INTO tr_subcode VALUES('4','2','상품준비');
INSERT INTO tr_subcode VALUES('4','3','배송준비');
INSERT INTO tr_subcode VALUES('4','4','배송중');
INSERT INTO tr_subcode VALUES('4','5','배송완료');