create table order1 (
id int auto_increment primary key,
custId int not null,
name varchar(30),
quantity int
);
insert into order1(custId,name,quantity) values(123,'C++',4);
select * from order1;
drop table order1;