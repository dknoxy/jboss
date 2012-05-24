
grant all privileges on *.* to javauser@localhost identified by 'javadude' with grant option;

create database users;
use users;

create table userauth (
	username varchar(15) not null primary key,
	userpass varchar(15) not null
);

create table userroles (
	username varchar(15) not null,
	rolename varchar(15) not null,
	primary key (username, rolename)
);


