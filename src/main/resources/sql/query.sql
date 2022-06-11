drop table employee;

create table employee
(
id int not null auto_increment primary key,
name varchar(50) default null,
department varchar(50) default null,
machine varchar(50) default null
) engine=InnoDB default charset=latin1;