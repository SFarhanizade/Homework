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

@WebServlet(name = "add", value = "/add")
public class AddBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String publisher = req.getParameter("publisher");
        String author = req.getParameter("author");
        Integer price = Integer.parseInt(req.getParameter("price"));
        Book book = new Book(title, publisher, author, price);
        PrintWriter out = resp.getWriter();
        try {
            new BookManager().addBook(book);
            out.println("The book added!");
        } catch (IOException e) {
            out.println("Something went wrong!");
            e.printStackTrace();
        }
    }
}
