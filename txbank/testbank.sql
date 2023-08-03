-- 库
create database testbank;
use testBank;
-- 信息表
create table accounts
(
    accountid int primary key auto_increment,
    balance numeric (10,2)
);
-- 创建流水表
create table oprecord
(
    id int primary key auto_increment,
    accountid int references accounts(accountid),
    opmoney numeric (10,2),
    optime datetime,
    optype enum('deposite','withdraw','transfer') not null,
    transferid varchar(50)
);