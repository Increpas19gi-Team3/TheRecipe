/*회원 등록*/
INSERT INTO TR_MEMBER VALUES('admin','1234','관리자','admin@naver.com','12345','서울시 강동구','010-1234-5678',0); --최고관리자계정
INSERT INTO TR_MEMBER VALUES('han','1234','한범석','han@naver.com','12345','서울시 강남구','010-1234-1234',1);
INSERT INTO TR_MEMBER VALUES('son','1234','손가연','son@naver.com','12345','서울시 강동구','010-1234-5678',0);

/* 분류코드 등록*/
INSERT INTO tr_foodcode VALUES(1,0,'한식');
INSERT INTO tr_foodcode VALUES(1,1,'찌개');
INSERT INTO tr_foodcode VALUES(1,2,'해물');
INSERT INTO tr_foodcode VALUES(2,0,'중식');
INSERT INTO tr_foodcode VALUES(2,1,'단품');
INSERT INTO tr_foodcode VALUES(2,2,'요리');


/* 상품 등록 */
INSERT INTO tr_food VALUES(tr_food_seq.nextval, null, '김치찌개',1,1,5000,'김치찌개',null,null);
INSERT INTO tr_food VALUES(tr_food_seq.nextval, null, '된장찌개',1,2,5000,'된장찌개',null,null);
INSERT INTO tr_food VALUES(tr_food_seq.nextval, null, '짜장면',2,1,5000,'짜장면',null,null);
INSERT INTO tr_food VALUES(tr_food_seq.nextval, null, '탕수육',2,2,5000,'탕수육',null,null);


/* 장바구니 */
INSERT INTO tr_basket VALUES('han','1',5000,1);
INSERT INTO tr_basket VALUES('han','3',5000,1);


INSERT INTO tr_dvycode VALUES('0','입금확인');
INSERT INTO tr_dvycode VALUES('1','상품준비');
INSERT INTO tr_dvycode VALUES('2','배송준비');
INSERT INTO tr_dvycode VALUES('3','배송중');
INSERT INTO tr_dvycode VALUES('4','배송완료');


/* 주문테이블 */
INSERT INTO tr_order VALUES(sysdate_01,'0','han','3','5000','1',sysdate,'한범석','12345','서울시 강남구');

/* 이벤트 */
INSERT INTO tr_event VALUES(tr_event_seq.nextval, '탕수육 세일', '1', sysdate, '탕수육 세일', null, 10, sysdate, '2017/12/4');


INSERT INTO tr_review VALUES(tr_review_seq.nextval, 'han', '1', 'a맛있네요. 정말좋아요',3, null, 0,sysdate, null, null);