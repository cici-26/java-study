CREATE DATABASE IF NOT EXISTS study_db CHARACTER SET utf8mb4;
USE study_db;

CREATE TABLE IF NOT EXISTS book (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT '图书ID',
    title VARCHAR(100) NOT NULL COMMENT '书名',
    author VARCHAR(50) COMMENT '作者',
    price DECIMAL(10,2) COMMENT '价格',
    publish_date DATE COMMENT '出版日期'
);

INSERT INTO book (title, author, price, publish_date) VALUES
('Java编程思想', 'Bruce Eckel', 108.00, '2007-06-01'),
('三体', '刘慈欣', 99.00, '2008-01-01'),
('活着', '余华', 45.00, '1993-01-01');