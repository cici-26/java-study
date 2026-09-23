package com.cici.util;

import java.sql.*;

public class JdbcUtil {
    // 数据库连接配置
    private static final String URL = "jdbc:mysql://localhost:3306/study_db?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf8";
    private static final String USER = "root";
    private static final String PASSWORD = "Root@123456"; // ⚠️ 修改这里！改成你真实密码！

    // 静态代码块：类加载时执行一次，加载驱动
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL 驱动加载失败，请检查 pom.xml 依赖", e);
        }
    }

    // 获取连接
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // 释放资源
    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        if (rs != null) { try { rs.close(); } catch (SQLException e) { e.printStackTrace(); } }
        if (stmt != null) { try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); } }
        if (conn != null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } }
    }
}