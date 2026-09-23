# 图书管理系统 (Book Management System)

一个基于原生 Java + JDBC + MySQL 开发的控制台图书管理系统。不需要任何 Web 框架，通过控制台菜单进行交互。

## 🛠️ 技术栈
- **语言**: Java 22
- **构建工具**: Maven
- **数据库**: MySQL 8.0
- **核心技术**: 原生 JDBC
- **架构模式**: Entity - DAO - Service - Main (分层架构)

## 📦 功能列表
- [x] 查询所有图书
- [x] 根据 ID 查询图书
- [x] 新增图书
- [x] 修改图书价格及出版日期
- [x] 删除图书

## 🚀 如何运行
1. 确保本地已安装 MySQL 8，并创建了 `study_db` 数据库。
2. 执行项目根目录下的 `sql/init.sql` 文件，建表和初始化数据。
3. 修改 `src/main/java/com/cici/book/util/JdbcUtil.java` 中的数据库密码为你自己的密码。
4. 在 IDEA 中运行 `src/main/java/com/cici/book/Main.java` 即可启动系统。

## 📁 项目结构
```text
src/main/java/com/cici/book/
├── dao/        # 数据访问层 (执行 SQL)
├── entity/     # 实体类 (Book)
├── service/    # 业务逻辑层
├── util/       # 工具类 (JdbcUtil 连接数据库)
└── Main.java   # 程序入口 / 控制台菜单