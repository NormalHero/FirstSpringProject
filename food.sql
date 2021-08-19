select * from all_all_tables;



-- 보드 추가 
create table board(
	id int primary key,
	title varchar(50),
	writer varchar(30),
	content varchar(100),
	wdate date default sysdate,
	cnt int default 0
);

--푸드사용자 테이블
create table foodUsers(
	id varchar(20) primary key,
	password varchar(20),
	name varchar(30),
	role varchar(30)
);





SELECT * FROM menu;
SELECT * FROM board;
SELECT * FROM foodUsers;