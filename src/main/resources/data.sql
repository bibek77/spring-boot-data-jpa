insert into user_details(id, birth_date,name)
values(10001, current_date(), 'JAY');
insert into user_details(id, birth_date,name)
values(10002, current_date(), 'MIKE');
insert into user_details(id, birth_date,name)
values(10003, current_date(), 'PHIL');
insert into user_details(id, birth_date,name)
values(10004, current_date(), 'KELLY');
-----------------------------------------
--create table course (
--    id bigint not null,
--    name varchar(255) not null,
--    author varchar(255) not null,
--    primary key (id)
--);
--------------------------------------
insert into post(id, description, user_id)
values(20001, 'Software Engineer II', 10001);
insert into post(id, description, user_id)
values(20002, 'Data Engineer II', 10002);
insert into post(id, description, user_id)
values(20003, 'Product Manager I', 10004);
insert into post(id, description, user_id)
values(20004, 'Data Architect I', 10004);
