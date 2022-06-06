drop table employee;

create table employee
(
id int not null auto_increment primary key,
name varchar(50) default null,
department varchar(50) default null,
machine varchar(50) default null
) engine=InnoDB default charset=latin1;

#insert into employee values (1,"James","AWM","Windows");
#insert into employee values (2,"Michael","CIB","Mac OS");
#insert into employee values (3,"Steve","CB","Linux");
#insert into employee values (4,"Emma","CCB","Windows");
#insert into employee values (5,"Sarah","CTC","Mac OS");

select * from employee;