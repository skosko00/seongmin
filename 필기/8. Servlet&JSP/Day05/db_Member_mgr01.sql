create table member(
userid varchar(20) primary key,
userpwd varchar(20) not null,
username varchar(20) not null,
age number ,
email varchar(30) not null,
phone varchar(13) not null,
address varchar(50),
gender varchar(1) not null,
hobby varchar(30),
enrolldate date
);

insert into member values('mslove','1234','노민수',20,'mslove@kh.org','010-1111-2222','경기도 부천시 442-1','M','운동,노래',SYSDATE);

commit;

SELECT * FROM member;


insert into member values('admin','1111','관리자',99,'admin@kh.org','111-1111-1111','서울시 강남구 역삼동 823-2','M','관리',SYSDATE);
insert into member values('hong','9999','홍길동',30,'hong@kh.org','010-9582-5885','인천광역시 계양구 임학동','M','운동',SYSDATE);
insert into member values('malddong','1233','김말똥',40,'ddong@kh.org','010-1123-5873','서울시 영등포구 당산동 237번지','F','미술',SYSDATE);

commit;


alter table member add (activation varchar2(1));

update member set ACTIVATION='y';

commit;

select * from member;

alter table member add(last_modified DATE);

update member set LAST_MODIFIED=sysdate;

update member set LAST_MODIFIED=to_date('18/01/01') where userid='mslove';

commit;

select floor(SYSDATE-last_modified)AS change_date from member where userid='mslove';

select * from NOTICE;

select * from
(select notice.*, row_number() over(order by noticeno desc)as num from notice)
where num between 1 and 10;

select count(*)AS totalCount from notice;
select * from
(select notice.*, row_number() over(order by noticeno desc)as num from notice where subject like '%공지%')
where num between 1 and 10;

select count(*)AS totalCount from notice where subject like '%공지%';