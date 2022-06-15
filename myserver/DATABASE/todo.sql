create table todo (
	no number primary key,
	contents varchar2(100),
	todoyn char(1) default '0'
);

insert into todo values(1, 'java', '1');
insert into todo values(2, 'html', '1');
insert into todo values(3, 'javascript', '0');
insert into todo values(4, 'spring', '0');

commit;