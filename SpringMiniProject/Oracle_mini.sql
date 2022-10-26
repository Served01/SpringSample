--게시판정보 테이블 작성, top_menu.jsp

create table board_info_table(
    board_info_idx number 
        constraint board_info_pk primary key,
    board_info_name varchar2(100) not null
);

insert into board_info_table(board_info_idx, board_info_name) values(1,'JavaBoard');
insert into board_info_table(board_info_idx, board_info_name) values(2,'JSPBoard');
insert into board_info_table(board_info_idx, board_info_name) values(3,'SpringBoard');
insert into board_info_table(board_info_idx, board_info_name) values(4,'ProjectBoard');

select * from board_info_table;

--사용자 정보 테이블, join.jsp

create sequence user_seq
    start with 1
    increment by 1
    maxvalue 10000
    nocycle;

create table user_table(
    user_idx  number 
        constraint user_table_pk primary key,
    user_name varchar2(50) not null,
    user_id varchar2(50) not null,
    user_pw varchar2(50) not null
);

commit

--게시글 저장 테이블 작성, index.jsp
create sequence  content_seq
    start with 1
    increment by 1
    maxvalue 10000
    nocycle;
    
create table content_table(
    content_idx number
        constraint content_table_pk primary key,
    content_subject varchar2(50) not null,
    content_text long not null,
    content_file varchar2(3000),
    content_write_idx number not null
        constraint content_fk1 references user_table(user_idx),
    content_board_idx number not null
        constraint content_fk2 references board_info_table(board_info_idx),
    content_date date not null
);

drop table content_table;

commit

select user_name
	from user_table
	where user_id = 'hyun';
	
select * from USER_TABLE;

insert into user_table values(1, '홍길동', 'hong1234', '12345678');
insert into user_table values(2, '임성찬', 'lim12345', '12345678');

delete from user_table;

select * from user_table
	where user_id ='Hasoyoung' and user_pw='12345678';



