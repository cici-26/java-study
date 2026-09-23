package com.cici.book.service;

import com.cici.book.dao.BookDao;
import com.cici.book.entity.Book;
import java.util.List;

public class BookService {
    private BookDao bookDao = new BookDao();

    public boolean addBook(Book book) {
        return bookDao.insert(book);
    }

    public boolean deleteBook(int id) {
        return bookDao.deleteById(id);
    }

    public boolean updateBook(Book book) {
        return bookDao.update(book);
    }

    public Book getBookById(int id) {
        return bookDao.selectById(id);
    }

    public List<Book> getAllBooks() {
        return bookDao.selectAll();
    }
}