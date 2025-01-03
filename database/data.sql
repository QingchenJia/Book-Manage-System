use bookmanagesystem;

insert into admin (aid, passwd)
values ('admin', '8J9Je8e093V8Jiu+ily0yQ==');

insert into user (uid, passwd, name, email, phone, borrow_num, borrow_days)
values ('U101', '8J9Je8e093V8Jiu+ily0yQ==', 'Alice', '101@mail.com', '12345678901', 5, 30),
       ('U102', '8J9Je8e093V8Jiu+ily0yQ==', 'Bob', '102@mail.com', '12345678902', 5, 30),
       ('U103', '8J9Je8e093V8Jiu+ily0yQ==', 'Cindy', '103@mail.com', '12345678903', 5, 30);

insert into book_type (tid, type_name, is_delete)
values ('87', '哲学', 0),
       ('89', '政治', 0),
       ('69', '文学小说', 0),
       ('70', '杂志期刊', 0),
       ('88', '科学', 0),
       ('86', '编程语言', 0),
       ('85', '计算机丛书', 0);

insert into book_info (bid, book_name, author, num, press, tid, is_delete)
values ('22', '三国演义', '罗贯中', 100, '古典文学出版社', '69', 0),
       ('24', '水浒传', '施耐庵', 50, '古典文学出版社', '69', 0),
       ('25', '操作系统', 'Oslabel', 200, '机械工业出版社', '85', 0),
       ('26', '计算机网络', '谢希仁', 300, '机械工业出版社', '85', 0),
       ('27', 'Java入门', 'Brian Goetz', 150, '人民出版社', '85', 0),
       ('28', '相对论', '爱因斯坦', 50, '北京大学出版社', '88', 0);

# 借阅信息-borrow表 数据省略
