# Book Manage System

#### 介绍
A simple library management system web project consisting of both users and administrators.

#### 软件架构

This is a web project that is created by `spring-boot` and `Maven`. 
Import `mybatis` to connect to a `MySQL` database.
Import `lombok` logs, and print the log information in the console.
Import `bouncycastle` for information security protection.
Import `jwt` as the verification method of interceptor to visit website.

#### 基本功能

It supports ordinary users, i.e., readers and administrators, to log in and access, and users can register accounts by themselves.

Readers will be able to browse the list of books, borrow and return them. You can also view current borrowing information and historical borrowing history. Support users to legally modify their own information.

The administrator can overview the book information, book type, borrowing history and user list, and have the function of adding, deleting and modifying the corresponding data. Password changes are allowed.

#### 使用说明

If you clone the repository file to the local computer and configure the data source, you can access 127.0.0.1:9090 to perform operations.

#### 更多背景

This project is submitted as a course design for the 2022 class of cryptology in the School of Computer Science and Technology of `Wuhan University of Science and Technology`.
