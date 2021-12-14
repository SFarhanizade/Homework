package ir.farhanizade.bookstorage;

import ir.farhanizade.bookstorage.entity.Book;
import ir.farhanizade.bookstorage.manager.BookManager;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BookManager bookManager = new BookManager();
        bookManager.addBook(new Book("a","a","a",1));
        List<Book> books = bookManager.loadAll();
        System.out.println(books);
    }
}
