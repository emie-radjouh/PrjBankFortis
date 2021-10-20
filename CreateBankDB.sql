CONNECT demo / AS SYSDBA
CREATE USER BANK IDENTIFIED BY "bank"
DEFAULT TABLESPACE USERS;
GRANT ALL PRIVILEGES TO bank;
CONNECT bank/bank
create table customers(
NUM varchar(10) constraint MEMBER_ID_NN not null,
NAME varchar(50),
PIN varchar(4),
EMAIL varchar(100),
constraint Customer_PK primary key(NUM));
desc customers;
column NUM format a10;
column NAME format a20;
column PIN format a4;
column EMAIL format a30;
select * from customers;

