create database people;
use people;
create table person
(
    id             int not null auto_increment primary key,
    age            int,
    salary         int,
    passport       varchar(10),
    address        varchar(200),
    dateOfBirthday date,
    dateTimeCreate datetime,
    timetoLunch    time,
    letter         text
);
insert into person
values (null, 30, 5000, 'пасспорт1', 'Адрес1',
        '2021-02-21', '2011-02-12 18:34:19', '15:21:01',
        'текст1');

insert into person
values (null, 22, 7000, 'пасспорт2', 'Адрес2',
        '2021-02-21', '2025-03-17 03:10:18', '09:51:20',
        'текст2');

insert into person
values (null, 24, 5600, 'пасспорт3', 'Адрес3',
        '2024-02-21', '1998-04-15 15:17:13', '03:40:17',
        'текст3');

insert into person
values (null, 15, 4400, 'пасспорт4', 'Адрес4',
        '2021-02-2', '1997-10-17 10:20:01', '08:15:00',
        'текст4');

insert into person
values (null, 10, 1200, 'пасспорт5', 'Адрес5',
        '2021-02-28', '2023-02-21 17:20:00', '16:10:00',
        'текст5');

select *
from person
where age > 21
order by dateTimeCreate;
