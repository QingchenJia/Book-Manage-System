create schema if not exists bookmanagesystem;

use bookmanagesystem;

create table admin
(
    aid    varchar(10) not null
        primary key,
    passwd varchar(50) not null
);

create table user
(
    uid         varchar(20) not null
        primary key,
    passwd      varchar(50) not null,
    name        varchar(10) not null,
    email       varchar(20) not null,
    phone       varchar(11) not null,
    borrow_num  int         not null,
    borrow_days int         not null
);

create table book_type
(
    tid       varchar(10) not null
        primary key,
    type_name varchar(10) not null,
    is_delete int         null,
    constraint book_type_pk
        unique (type_name)
);

create table book_info
(
    bid       varchar(5)  not null
        primary key,
    book_name varchar(15) not null,
    author    varchar(15) not null,
    num       int         not null,
    press     varchar(15) not null,
    tid       varchar(5)  not null,
    is_delete int         null,
    constraint book_info_book_type_tid_fk
        foreign key (tid) references book_type (tid)
);

create table borrow
(
    bid         varchar(5)  not null,
    uid         varchar(15) not null,
    borrow_date datetime    not null,
    due_date    datetime    not null,
    return_date datetime    null,
    is_return   int         not null,
    primary key (bid, uid, borrow_date),
    constraint borrow_book_info_bid_fk
        foreign key (bid) references book_info (bid),
    constraint borrow_user_uid_fk
        foreign key (uid) references user (uid)
);
