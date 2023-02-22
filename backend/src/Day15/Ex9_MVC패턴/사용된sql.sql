create database day15;
use day15;
create table member(
mno int auto_increment primary key,
mid varchar(20),
mpw varchar(20)
);

select * from member;

update memner set mpw='' where mno = 1;

delete from member where mno=1;
