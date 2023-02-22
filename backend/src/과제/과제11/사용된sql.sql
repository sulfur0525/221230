create database 과제11;
use 과제11;

create table product(
	pno int auto_increment primary key,
    pname varchar(20),
    pprice int,
    pstock int
);

insert into product(pname,pprice,pstock) value(?,?,?);

select * from product;

update product set pname='0' , pprice=1 where pno=1;

update product set pstock=? where pno=?;

delete from product where pno=?;