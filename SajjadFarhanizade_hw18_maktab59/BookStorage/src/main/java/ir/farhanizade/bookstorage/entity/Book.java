package ir.farhanizade.bookstorage.entity;

public class Book {
    private String title;
    private String publisher;
    private String author;
    private Integer price;

    public Book(String title, String publisher, String author, Integer price) {
        this.title = title;
        this.publisher = publisher;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getPrice() {
        return price;
    }
}
