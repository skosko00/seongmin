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

insert into member values('mslove','1234','��μ�',20,'mslove@kh.org','010-1111-2222','��⵵ ��õ�� 442-1','M','�,�뷡',SYSDATE);

commit;

SELECT * FROM member;


insert into member values('admin','1111','������',99,'admin@kh.org','111-1111-1111','����� ������ ���ﵿ 823-2','M','����',SYSDATE);
insert into member values('hong','9999','ȫ�浿',30,'hong@kh.org','010-9582-5885','��õ������ ��籸 ���е�','M','�',SYSDATE);
insert into member values('malddong','1233','�踻��',40,'ddong@kh.org','010-1123-5873','����� �������� ��굿 237����','F','�̼�',SYSDATE);

commit;


alter table member add (activation varchar2(1));

update member set ACTIVATION='y';

commit;

select * from member;

