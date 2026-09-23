package com.cici.dao;

import com.cici.entity.Book;
import com.cici.util.JdbcUtil;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

    // 1. 新增
    public boolean insert(Book book) {
        String sql = "INSERT INTO book (title, author, price, publish_date) VALUES (?, ?, ?, ?)";
        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setBigDecimal(3, book.getPrice());
            pstmt.setObject(4, book.getPublishDate());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 2. 删除（按 id）
    public boolean deleteById(int id) {
        String sql = "DELETE FROM book WHERE id = ?";
        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 3. 更新（按 id 修改）
    public boolean update(Book book) {
        String sql = "UPDATE book SET title = ?, author = ?, price = ?, publish_date = ? WHERE id = ?";
        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setBigDecimal(3, book.getPrice());
            pstmt.setObject(4, book.getPublishDate());
            pstmt.setInt(5, book.getId());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 4. 查询（按 id 查单个）
    public Book selectById(int id) {
        String sql = "SELECT * FROM book WHERE id = ?";
        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return mapRowToBook(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 5. 查询（查所有）
    public List<Book> selectAll() {
        String sql = "SELECT * FROM book";
        List<Book> list = new ArrayList<>();
        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                list.add(mapRowToBook(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // 辅助方法：将 ResultSet 的一行数据转换成 Book 对象
    private Book mapRowToBook(ResultSet rs) throws SQLException {
        Book book = new Book();
        book.setId(rs.getInt("id"));
        book.setTitle(rs.getString("title"));
        book.setAuthor(rs.getString("author"));
        book.setPrice(rs.getBigDecimal("price"));
        Date date = rs.getDate("publish_date");
        if (date != null) {
            book.setPublishDate(date.toLocalDate());
        }
        return book;
    }
}
