package ir.farhanizade.bookstorage.servlet;

import ir.farhanizade.bookstorage.entity.Book;
import ir.farhanizade.bookstorage.manager.BookManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "load", value = "/load")
public class LoadBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        List<Book> books = null;
        try {
            books = new BookManager().loadAll();
            for(Book book : books){
                out.println(book);
            }
        } catch (IOException e) {
            out.println("Something went wrong!");
        }
    }
}
