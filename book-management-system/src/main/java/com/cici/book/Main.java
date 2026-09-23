package com.cici.book;

import com.cici.book.entity.Book;
import com.cici.book.service.BookService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookService bookService = new BookService();

        while (true) {
            System.out.println("\n====== 图书管理系统 ======");
            System.out.println("1. 查询所有图书");
            System.out.println("2. 根据ID查询图书");
            System.out.println("3. 新增图书");
            System.out.println("4. 修改图书价格");
            System.out.println("5. 删除图书");
            System.out.println("6. 退出系统");
            System.out.print("请输入你的选择 (1-6): ");

            int choice = sc.nextInt();
            sc.nextLine(); // ⚠️ 非常关键：吃掉输入数字后残留的回车符，防止后续字符串输入被跳过

            switch (choice) {
                case 1:
                    List<Book> books = bookService.getAllBooks();
                    if (books.isEmpty()) {
                        System.out.println("暂无图书。");
                    } else {
                        books.forEach(System.out::println);
                    }
                    break;
                case 2:
                    System.out.print("请输入图书ID: ");
                    int id = sc.nextInt();
                    Book book = bookService.getBookById(id);
                    System.out.println(book != null ? book : "未找到该图书。");
                    break;
                case 3:
                    System.out.print("请输入书名: ");
                    String title = sc.nextLine();
                    System.out.print("请输入作者: ");
                    String author = sc.nextLine();
                    System.out.print("请输入价格: ");
                    BigDecimal price = sc.nextBigDecimal();
                    sc.nextLine(); // 吃掉回车

                    System.out.print("请输入出版日期 (格式如 2007-06-01): ");
                    String dateStr = sc.nextLine();
                    // ⚠️ 核心：把输入的字符串转成 LocalDate 类型
                    LocalDate publishDate = LocalDate.parse(dateStr);

                    Book newBook = new Book(null, title, author, price, publishDate);
                    System.out.println(bookService.addBook(newBook) ? "新增成功！" : "新增失败！");
                    break;
                case 4:
                    System.out.print("请输入要修改的图书ID: ");
                    int updateId = sc.nextInt();
                    Book updateBook = bookService.getBookById(updateId);
                    if (updateBook != null) {
                        System.out.print("请输入新的价格: ");
                        BigDecimal newPrice = sc.nextBigDecimal();
                        sc.nextLine();
                        updateBook.setPrice(newPrice);
                        System.out.println(bookService.updateBook(updateBook) ? "修改成功！" : "修改失败！");
                    } else {
                        System.out.println("未找到该图书。");
                    }
                    System.out.print("请输入新的出版日期 (格式如 2007-06-01): ");
                    String newdateStr = sc.nextLine();
                    LocalDate newDate = LocalDate.parse(newdateStr);
                    updateBook.setPublishDate(newDate);
                    break;
                case 5:
                    System.out.print("请输入要删除的图书ID: ");
                    int deleteId = sc.nextInt();
                    System.out.println(bookService.deleteBook(deleteId) ? "删除成功！" : "删除失败！");
                    break;
                case 6:
                    System.out.println("感谢使用，再见！");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("输入有误，请重新输入。");
            }
        }
    }
}