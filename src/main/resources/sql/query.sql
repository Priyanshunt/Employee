create table employee
(
    id integer primary key,
    name varchar(50) not null,
    department varchar(50) not null,
    machine varchar(50) not null
);

grant on commit refresh on employee to rw_role;
grant select, insert, update, delete on employee to rw_role;