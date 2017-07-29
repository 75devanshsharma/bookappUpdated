create table book1 (
id int auto_increment primary key,
name varchar(30),
price int,
status varchar(15)
);

insert into book1(name,price,status) values ('C++',199,'Available');
insert into book1(name,price,status) values ('Java',299,'Not Available');
insert into book1(name,price,status) values ('Python',399,'Available');
select * from book1;