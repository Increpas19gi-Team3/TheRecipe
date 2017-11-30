/*회원 등록*/
INSERT INTO TR_MEMBER VALUES('admin','1234','관리자','admin@naver.com','12345','서울시 강동구','010-1234-5678','0','1'); /*최고관리자계정*/
INSERT INTO TR_MEMBER VALUES('han','1234','한범석','han@naver.com','12345','서울시 강남구','010-1234-1234','1','1');
INSERT INTO TR_MEMBER VALUES('son','1234','손가연','son@naver.com','12345','서울시 강동구','010-1234-5678','0','1');

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

/* 이벤트 */
INSERT INTO tr_event VALUES(tr_event_seq.nextval, '탕수육 세일', '1', sysdate, '탕수육 세일', null, '2', sysdate, '2017/12/4','3');
INSERT INTO tr_event VALUES(tr_event_seq.nextval, '짬뽕 세일', '1', sysdate, '뻥이야', null, '2', sysdate, '2017/12/4','3');
INSERT INTO tr_event VALUES(tr_event_seq.nextval, '짜장면 세일', '1', sysdate, '뻥이야', null, '4', sysdate, '2017/12/4','3');
INSERT INTO tr_event VALUES(tr_event_seq.nextval, '황제 짬뽕 세일', '1', sysdate, '뻥이야', null, '2', sysdate, '2017/12/4','3');
INSERT INTO tr_event VALUES(tr_event_seq.nextval, '볶음밥 세일', '1', sysdate, '뻥이야', null, '2', sysdate, '2017/12/4','3');
INSERT INTO tr_event VALUES(tr_event_seq.nextval, '깐쇼새우 세일', '1', sysdate, '뻥이야', null, '2', sysdate, '2017/12/4','3');
INSERT INTO tr_event VALUES(tr_event_seq.nextval, '유산슬 세일', '1', sysdate, '뻥이야', null, '2', sysdate, '2017/12/4','3');
INSERT INTO tr_event VALUES(tr_event_seq.nextval, '팔보채 세일', '1', sysdate, '뻥이야', null, '2', sysdate, '2017/12/4','3');
INSERT INTO tr_event VALUES(tr_event_seq.nextval, '양장피 세일', '1', sysdate, '뻥이야', null, '2', sysdate, '2017/12/4','3');
INSERT INTO tr_event VALUES(tr_event_seq.nextval, '고추잡채 세일', '1', sysdate, '뻥이야', null, '2', sysdate, '2017/12/4','3');
INSERT INTO tr_event VALUES(tr_event_seq.nextval, '팔보채 세일', '1', sysdate, '뻥이야', null, '2', sysdate, '2017/12/4','3');
INSERT INTO tr_event VALUES(tr_event_seq.nextval, '쟁반짜장 세일', '1', sysdate, '뻥이야', null, '2', sysdate, '2017/12/4','3');
INSERT INTO tr_event VALUES(tr_event_seq.nextval, '볶음짬뽕 세일', '1', sysdate, '뻥이야', null, '2', sysdate, '2017/12/4','3');

/* 공지사항 */
INSERT INTO tr_event VALUES(tr_event_seq.nextval, '11/22 공지사항입니다.', '0', sysdate, '탕수육 세일', null, null, sysdate, '2017/12/4','3');
INSERT INTO tr_event VALUES(tr_event_seq.nextval, '11/23 공지사항입니다.', '0', sysdate, '짬뽕 세일', null, null, sysdate, '2017/12/4','3');
INSERT INTO tr_event VALUES(tr_event_seq.nextval, '11/24 공지사항입니다.', '0', sysdate, '짜장면 세일', null, null, sysdate, '2017/12/4','3');
INSERT INTO tr_event VALUES(tr_event_seq.nextval, '11/25 공지사항입니다.', '0', sysdate, '황제 짬뽕 세일', null, null, sysdate, '2017/12/4','3');
INSERT INTO tr_event VALUES(tr_event_seq.nextval, '11/26 공지사항입니다.', '0', sysdate, '볶음밥 세일', null, null, sysdate, '2017/12/4','3');
INSERT INTO tr_event VALUES(tr_event_seq.nextval, '11/27 공지사항입니다.', '0', sysdate, '깐쇼새우 세일', null, null, sysdate, '2017/12/4','3');
INSERT INTO tr_event VALUES(tr_event_seq.nextval, '11/28 공지사항입니다.', '0', sysdate, '유산슬 세일', null, null, sysdate, '2017/12/4','3');
INSERT INTO tr_event VALUES(tr_event_seq.nextval, '11/29 공지사항입니다.', '0', sysdate, '팔보채 세일', null, null, sysdate, '2017/12/4','3');
INSERT INTO tr_event VALUES(tr_event_seq.nextval, '11/30 공지사항입니다.', '0', sysdate, '양장피 세일', null, null, sysdate, '2017/12/4','3');
INSERT INTO tr_event VALUES(tr_event_seq.nextval, '12/01 공지사항입니다.', '0', sysdate, '고추잡채 세일', null, null, sysdate, '2017/12/4','3');
INSERT INTO tr_event VALUES(tr_event_seq.nextval, '12/02 공지사항입니다.', '0', sysdate, '팔보채 세일', null, null, sysdate, '2017/12/4','3');
INSERT INTO tr_event VALUES(tr_event_seq.nextval, '12/03 공지사항입니다.', '0', sysdate, '쟁반짜장 세일', null, null, sysdate, '2017/12/4','3');
INSERT INTO tr_event VALUES(tr_event_seq.nextval, '12/04 공지사항입니다.', '0', sysdate, '볶음짬뽕 세일', null, null, sysdate, '2017/12/4','3');


/* 상품 등록 */
INSERT INTO tr_food VALUES(tr_food_seq.nextval, null, '김치찌개',1,1,1,5000,'김치찌개','kimci01.JPG_kimci02.JPG','kimci01.JPG_kimci02.JPG','0','2');
INSERT INTO tr_food VALUES(tr_food_seq.nextval, null, '된장찌개',1,1,1,5000,'된장찌개','doenjang01.JPG_doenjang02.JPG','doenjang01.JPG_doenjang02.JPG','0','2');
INSERT INTO tr_food VALUES(tr_food_seq.nextval, null, '짜장면',1,2,1,5000,'짜장면','jajangmyeon01.JPG_jajangmyeon02.JPG','jajangmyeon01.JPG_jajangmyeon02.JPG','0','2');
INSERT INTO tr_food VALUES(tr_food_seq.nextval, '0', '탕수육',1,2,2,5000,'탕수육','SourPork01.JPG_SourPork02.JPG','SourPork01.JPG_SourPork02.JPG','0','2');
INSERT INTO tr_food VALUES(tr_food_seq.nextval, null, '짬뽕',1,2,1,5000,'짬뽕',null,null,'0','2');


/* 장바구니 */
INSERT INTO tr_basket VALUES('han','1',5000,1);
INSERT INTO tr_basket VALUES('han','3',5000,1);

/* 주문테이블 
	TO_CHAR(SYSTIMESTAMP, 'YYYYMMDDHH24MISSFF3') : 20171124024614598 = 2017-11-24 02:46:14.598
*/
INSERT INTO tr_order VALUES(TO_CHAR(SYSTIMESTAMP, 'YYYYMMDDHH24MISSFF3'),'3','han','3','5000','1',sysdate,'한범석','12345','서울시 강남구','4');

INSERT INTO tr_review VALUES(tr_review_seq.nextval, 'han', '1', '맛잇음','a맛있네요. 정말좋아요',3, null, 0,sysdate, null, null);


INSERT INTO tr_mastercode VALUES('1','회원');
INSERT INTO tr_mastercode VALUES('2','상품');
INSERT INTO tr_mastercode VALUES('3','이벤트');
INSERT INTO tr_mastercode VALUES('4','주문');
INSERT INTO tr_subcode VALUES('1','0','관리자');
INSERT INTO tr_subcode VALUES('1','1','유저');
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