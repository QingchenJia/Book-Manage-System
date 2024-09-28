# Book Manage System

#### 介绍

A simple library management system web project consisting of both users and administrators.

#### 软件架构

##### 后端

`Spring-Boot` and `Maven`:Quickly simplify the configuration of the spring program and manage the dependencies of project coordinates.

`Mybatis`:Improve the efficiency of data layer development and facilitate the writing and debugging of SQL statements.

`lombok`:Simplify the development of POJO and solve the redundant coding of the repetitively written null-parameter, full-parameter construction methods, the Set, Get, and to-String methods. Normalized console log output.

`BouncyCastle`:JDK's own security cryptosystem has been extended to make its encryption methods more abundant.

`JWT`:Generate a corresponding token based on user information to authenticate access to resources.

`fastjson`:Efficient conversion of Ethan format to and from Java Object.

##### 前端

`Vue`:Accelerate front-end page development and simplify the DOM code for JavaScript.

`Element-UI`:A library of Vue 2.0-based desktop components for developers, designers, and product managers.

`axios`:A Prometheus-based web request library that can be used for browsers and node.js. It is able to efficiently handle all kinds of requests sent to the browser.

#### 基本功能

It supports ordinary users that are readers and administrators, to log in and access, and users can register accounts by themselves.

Readers will be able to browse the list of books, borrow and return them. You can also view current borrowing information and historical borrowing history. Support users to legally modify their own information.

The administrator can overview the book information, book type, borrowing history and user list, and have the function of adding, deleting and modifying the corresponding data. Password changes are allowed.

#### 使用说明

If you clone the repository file to the local computer and configure the data source, you can access `127.0.0.1:9090` to perform operations. Before starting the project, adjust the database configuration information to match it to the local configuration in `application.properties`.

#### 数据导入

To ensure that resources can access data, you need to manually import data to the local database. The SQL documents are available in the `database` directory.

```shell
cd ./databse
mysql -u root -p
source ./schema.sql
source ./data.sql
```

#### 更多背景

This project is submitted as a course design for the 2022 class of cryptology in the School of Computer Science and Technology of `Wuhan University of Science and Technology`.
