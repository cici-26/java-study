package com.cici.test;

import com.cici.dao.BookDao;
import com.cici.entity.Book;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class TestBookDao {
    public static void main(String[] args) {
        BookDao bookDao = new BookDao();

        // 1. 测试新增
        System.out.println("======= 测试新增 =======");
        Book newBook = new Book(null, "Java编程思想", "Bruce Eckel", new BigDecimal("108.00"), LocalDate.of(2007, 6, 1));
        boolean insertResult = bookDao.insert(newBook);
        System.out.println("新增结果: " + (insertResult ? "成功" : "失败"));

        // 2. 测试查询所有
        System.out.println("\n======= 测试查询所有 =======");
        List<Book> books = bookDao.selectAll();
        books.forEach(System.out::println);

        // 3. 测试更新（假设新增成功的 id 是 4，请根据输出调整 id）
        System.out.println("\n======= 测试更新 =======");
        if (!books.isEmpty()) {
            Book firstBook = books.get(0);
            firstBook.setPrice(new BigDecimal("99.00"));
            boolean updateResult = bookDao.update(firstBook);
            System.out.println("更新结果: " + (updateResult ? "成功" : "失败"));
        }

        // 4. 测试查询单个
        System.out.println("\n======= 测试按ID查询 =======");
        if (!books.isEmpty()) {
            Book b = bookDao.selectById(books.get(0).getId());
            System.out.println(b);
        }

        // 5. 测试删除（删除刚才新增的那本，根据实际新增的 id 来）
        System.out.println("\n======= 测试删除 =======");
        if (!books.isEmpty()) {
            Book lastBook = books.get(books.size() - 1);
            boolean deleteResult = bookDao.deleteById(lastBook.getId());
            System.out.println("删除结果: " + (deleteResult ? "成功" : "失败"));
        }
    }
}
