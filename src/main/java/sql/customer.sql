create table Customers5 (
id int primary key auto_increment,
name varchar(20),
city varchar(20),
mobile bigint,
username varchar(20),
password varchar(30)
);
select * from Customers5;
insert into Customers5(name,city,mobile,username,password) values ('Devansh','Allahabad',858585855,'devdev','dgdgdg');
drop table Customers5;