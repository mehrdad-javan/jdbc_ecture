create database jdbc_lecture;
use jdbc_lecture;

create table student(
id int not null primary key auto_increment,
first_name varchar(255) not null,
last_name varchar(255) not null,
personal_number bigint not null unique,
address varchar(400),
reagister_date timestamp default now(),
status tinyint default false
);

insert into student (first_name,last_name,personal_number,address) value ('Elnaz','Javan',199002019090,'Vaxjo');
insert into student (first_name,last_name,personal_number) value ('Mehrdad','Javan',198505050506);
insert into student (first_name,last_name,personal_number,address,status) value ('Erik','vensson',198605050606,'Vaxjo',1);
