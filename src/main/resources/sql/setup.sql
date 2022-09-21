-- Basic setup steps

conn sys/admin as sysdba;
alter session set "_oracle_script"=TRUE;

create user root identified by secret;
grant connect to root;
grant create session to root;
grant unlimited tablespace to root;
grant create role, alter any role, drop any role to root;
grant create table, select any table, delete any table, alter any table to root;

create user proxy identified by password;
grant connect to proxy;
grant create session to proxy;
alter user root grant connect through proxy;

conn root/secret
alter session set "_oracle_script"=TRUE;
create role rw_role;
grant rw_role to proxy;

--To cleanup everything

conn root/secret
alter session set "_oracle_script"=TRUE;
drop role rw_role;

conn sys/admin as sysdba;
alter session set "_oracle_script"=TRUE;

revoke all privileges from proxy;
revoke all privileges from root;
drop user proxy cascade;
drop user root cascade;
