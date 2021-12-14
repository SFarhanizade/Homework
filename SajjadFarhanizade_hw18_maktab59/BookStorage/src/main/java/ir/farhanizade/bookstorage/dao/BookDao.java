package ir.farhanizade.bookstorage.dao;

import ir.farhanizade.bookstorage.entity.Book;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    String fileAddress = "/home/farhanizade/IdeaProjects/Homework/SajjadFarhanizade_hw18_maktab59/BookStorage/books.txt";

    public void addBook(Book book) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileAddress, true);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        try {
                oos.writeObject(book);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            oos.close();
        }
    }

    public List<Book> loadAll() throws IOException {
        FileInputStream fis = new FileInputStream(fileAddress);
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Book> books = new ArrayList<>();
        while (true) {
            try {
                Book book = (Book) ois.readObject();
                books.add(book);
            } catch (ClassNotFoundException e) {
                break;
            } catch (Exception e) {
                break;
            } finally {
                return books;
                //ois.close();
            }
        }


    }
}
