package ir.farhanizade.bookstorage.dao;

import ir.farhanizade.bookstorage.entity.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    public void addBook(Book book) throws IOException {
        FileOutputStream fos = new FileOutputStream("books.txt", true);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(book);
        oos.close();
    }

    public List<Book> loadAll() throws IOException {
        FileInputStream fis = new FileInputStream("books.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Book> books = new ArrayList<>();
        Book book;
        try {
            while (true) {
                book = (Book) ois.readObject();
                books.add(book);
            }
        } catch (ClassNotFoundException e) {
            return books;
        }

    }
}
