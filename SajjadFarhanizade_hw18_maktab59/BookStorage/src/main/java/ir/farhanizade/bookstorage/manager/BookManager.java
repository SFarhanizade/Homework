package ir.farhanizade.bookstorage.manager;

import ir.farhanizade.bookstorage.dao.BookDao;
import ir.farhanizade.bookstorage.entity.Book;

import java.io.IOException;
import java.util.List;

public class BookManager {
    BookDao bookDao = new BookDao();

    public void addBook(Book book) throws IOException {
        bookDao.addBook(book);
    }

    public List<Book> loadAll() throws IOException {
        return bookDao.loadAll();
    }
}
