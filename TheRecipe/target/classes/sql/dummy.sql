/*회원 등록*/
INSERT INTO TR_MEMBER VALUES('admin','1234','관리자','admin@naver.com','12345','서울시 강동구','010-1234-5678',0); /*최고관리자계정*/
INSERT INTO TR_MEMBER VALUES('han','1234','한범석','han@naver.com','12345','서울시 강남구','010-1234-1234',1);
INSERT INTO TR_MEMBER VALUES('son','1234','손가연','son@naver.com','12345','서울시 강동구','010-1234-5678',0);

/* 분류코드 등록*/
INSERT INTO tr_foodcode VALUES(1,0,0,'지역','0');
INSERT INTO tr_foodcode VALUES(1,1,0,'한식','0');
INSERT INTO tr_foodcode VALUES(1,1,1,'찌개','0');
INSERT INTO tr_foodcode VALUES(1,1,2,'해물','0');
INSERT INTO tr_foodcode VALUES(1,2,0,'중식','0');
INSERT INTO tr_foodcode VALUES(1,2,1,'단품','0');
INSERT INTO tr_foodcode VALUES(1,2,2,'요리','0');
INSERT INTO tr_foodcode VALUES(2,0,0,'TV','0');
INSERT INTO tr_foodcode VALUES(2,1,0,'냉.부','0');
INSERT INTO tr_foodcode VALUES(2,1,1,'메인','0');


/* 상품 등록 */
INSERT INTO tr_food VALUES(tr_food_seq.nextval, null, '김치찌개',1,1,1,5000,'김치찌개',null,null,'0');
INSERT INTO tr_food VALUES(tr_food_seq.nextval, null, '된장찌개',1,1,1,5000,'된장찌개',null,null,'0');
INSERT INTO tr_food VALUES(tr_food_seq.nextval, null, '짜장면',1,2,1,5000,'짜장면',null,null,'0');
INSERT INTO tr_food VALUES(tr_food_seq.nextval, null, '탕수육',1,2,2,5000,'탕수육',null,null,'0');


/* 장바구니 */
INSERT INTO tr_basket VALUES('han','1',5000,1);
INSERT INTO tr_basket VALUES('han','3',5000,1);


INSERT INTO tr_dvycode VALUES('0','입금확인');
INSERT INTO tr_dvycode VALUES('1','상품준비');
INSERT INTO tr_dvycode VALUES('2','배송준비');
INSERT INTO tr_dvycode VALUES('3','배송중');
INSERT INTO tr_dvycode VALUES('4','배송완료');


/* 주문테이블 
	TO_CHAR(SYSTIMESTAMP, 'YYYYMMDDHH24MISSFF3') : 20171124024614598 = 2017-11-24 02:46:14.598
*/
INSERT INTO tr_order VALUES(TO_CHAR(SYSTIMESTAMP, 'YYYYMMDDHH24MISSFF3'),'0','han','3','5000','1',sysdate,'한범석','12345','서울시 강남구');


/* 이벤트 */
INSERT INTO tr_event VALUES(tr_event_seq.nextval, '탕수육 세일', '1', sysdate, '탕수육 세일', null, 10, sysdate, '2017/12/4');

/*INSERT INTO tr_event VALUES(1, '짬뽕 세일', '1', sysdate, '뻥이야', null, 20, sysdate, '2017/12/4');
INSERT INTO tr_event VALUES(3, '짜장면 세일', '1', sysdate, '뻥이야', null, 30, sysdate, '2017/12/4');
INSERT INTO tr_event VALUES(5, '황제 짬뽕 세일', '1', sysdate, '뻥이야', null, 10, sysdate, '2017/12/4');
INSERT INTO tr_event VALUES(7, '볶음밥 세일', '1', sysdate, '뻥이야', null, 20, sysdate, '2017/12/4');
INSERT INTO tr_event VALUES(9, '깐쇼새우 세일', '1', sysdate, '뻥이야', null, 30, sysdate, '2017/12/4');
INSERT INTO tr_event VALUES(11, '유산슬 세일', '1', sysdate, '뻥이야', null, 10, sysdate, '2017/12/4');
INSERT INTO tr_event VALUES(13, '팔보채 세일', '1', sysdate, '뻥이야', null, 20, sysdate, '2017/12/4');
INSERT INTO tr_event VALUES(15, '양장피 세일', '1', sysdate, '뻥이야', null, 30, sysdate, '2017/12/4');
INSERT INTO tr_event VALUES(17, '고추잡채 세일', '1', sysdate, '뻥이야', null, 10, sysdate, '2017/12/4');
INSERT INTO tr_event VALUES(19, '팔보채 세일', '1', sysdate, '뻥이야', null, 20, sysdate, '2017/12/4');
INSERT INTO tr_event VALUES(21, '쟁반짜장 세일', '1', sysdate, '뻥이야', null, 30, sysdate, '2017/12/4');
INSERT INTO tr_event VALUES(23, '볶음짬뽕 세일', '1', sysdate, '뻥이야', null, 10, sysdate, '2017/12/4');*/


/* 공지사항 */
INSERT INTO tr_event VALUES(tr_event_seq.nextval, '11/22 공지사항입니다.', '0', sysdate, '탕수육 세일', null, null, sysdate, '2017/12/4');

/*INSERT INTO tr_event VALUES(2, '11/23 공지사항입니다.', '0', sysdate, '짬뽕 세일', null, null, sysdate, '2017/12/4');
INSERT INTO tr_event VALUES(4, '11/24 공지사항입니다.', '0', sysdate, '짜장면 세일', null, null, sysdate, '2017/12/4');
INSERT INTO tr_event VALUES(6, '11/25 공지사항입니다.', '0', sysdate, '황제 짬뽕 세일', null, null, sysdate, '2017/12/4');
INSERT INTO tr_event VALUES(8, '11/26 공지사항입니다.', '0', sysdate, '볶음밥 세일', null, null, sysdate, '2017/12/4');
INSERT INTO tr_event VALUES(10, '11/27 공지사항입니다.', '0', sysdate, '깐쇼새우 세일', null, null, sysdate, '2017/12/4');
INSERT INTO tr_event VALUES(12, '11/28 공지사항입니다.', '0', sysdate, '유산슬 세일', null, null, sysdate, '2017/12/4');
INSERT INTO tr_event VALUES(14, '11/29 공지사항입니다.', '0', sysdate, '팔보채 세일', null, null, sysdate, '2017/12/4');
INSERT INTO tr_event VALUES(16, '11/30 공지사항입니다.', '0', sysdate, '양장피 세일', null, null, sysdate, '2017/12/4');
INSERT INTO tr_event VALUES(18, '12/01 공지사항입니다.', '0', sysdate, '고추잡채 세일', null, null, sysdate, '2017/12/4');
INSERT INTO tr_event VALUES(20, '12/02 공지사항입니다.', '0', sysdate, '팔보채 세일', null, null, sysdate, '2017/12/4');
INSERT INTO tr_event VALUES(22, '12/03 공지사항입니다.', '0', sysdate, '쟁반짜장 세일', null, null, sysdate, '2017/12/4');
INSERT INTO tr_event VALUES(24, '12/04 공지사항입니다.', '0', sysdate, '볶음짬뽕 세일', null, null, sysdate, '2017/12/4');*/




INSERT INTO tr_review VALUES(tr_review_seq.nextval, 'han', '1', 'a맛있네요. 정말좋아요',3, null, 0,sysdate, null, null);