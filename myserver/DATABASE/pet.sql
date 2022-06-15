  --drop table pet;
  --drop table adopt;
  create table pet(
    id number primary key,
    name varchar2(50),
    picture varchar2(100),
    age number,
    breed varchar2(100),
    location varchar2(100)
  );
  
  create table adopt(
  	id number primary key,
  	price number
  );

insert into pet values( 0, 'Frieda','resources/images/scottish-terrier.jpeg', 3, 'Scottish Terrier','Lisco, Alabama');
insert into pet values( 1, 'Gina','resources/images/scottish-terrier.jpeg', 3, 'Scottish Terrier','Tooleville, West Virginia');
insert into pet values( 2, 'Collins','resources/images/french-bulldog.jpeg', 2, 'French Bulldog','Freeburn, Idaho');
insert into pet values( 3, 'Melissa','resources/images/boxer.jpeg', 2, 'Boxer','Camas, Pennsylvania');
insert into pet values( 4, 'Jeanine','resources/images/french-bulldog.jpeg', 2,'French Bulldog','Gerber, South Dakota');
insert into pet values( 5, 'Elvia','resources/images/french-bulldog.jpeg',3, 'French Bulldog','Innsbrook, Illinois');
insert into pet values( 6, 'Latisha','resources/images/golden-retriever.jpeg', 3, 'Golden Retriever','Soudan, Louisiana');
insert into pet values( 7, 'Coleman','resources/images/golden-retriever.jpeg', 3, 'Golden Retriever','Jacksonwald, Palau');
insert into pet values( 8, 'Nichole','resources/images/french-bulldog.jpeg', 2, 'French Bulldog','Honolulu, Hawaii');
insert into pet values( 9, 'Fran','resources/images/boxer.jpeg', 3, '"Boxer','Matheny, Utah');
insert into pet values( 10, 'Leonor','resources/images/boxer.jpeg',2,  'Boxer','Tyhee, Indiana');
insert into pet values( 11, 'Dean','resources/images/scottish-terrier.jpeg', 3, 'Scottish Terrier','Windsor, Montana');
insert into pet values( 12, 'Stevenson','resources/images/french-bulldog.jpeg', 3,'French Bulldog','Kingstowne, Nevada');
insert into pet values( 13, 'Kristina','resources/images/golden-retriever.jpeg', 4, 'Golden Retriever','Sultana, Massachusetts');
insert into pet values( 14, 'Ethel','resources/images/golden-retriever.jpeg', 2, 'Golden Retriever','Broadlands, Oregon');
insert into pet values( 15, 'Terry','resources/images/golden-retriever.jpeg', 2, 'Golden Retriever','Dawn, Wisconsin');

insert into adopt values (1, 100);
insert into adopt values (3, 200);

commit;

select * from pet;
select * from adopt;