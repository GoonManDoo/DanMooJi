create table cart (
	no number primary key,
	porduct_nm varchar2(50),
	price number,
	qty number
)

insert into cart values( 1, '코드 스프링', 45000, 3);
insert into cart values( 1, '혼자 자바', 35000, 1);

commit;s