package store.products.book;

import store.products.Product;

public class Book extends Product {
    private Subject subject;
    private int pageNumber;
    private String publisher;

    public Book(int id, String name, int price, Subject subject, int pageNumber, String publisher) {
        super(id, name, price);
        this.subject = subject;
        this.pageNumber = pageNumber;
        this.publisher = publisher;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
