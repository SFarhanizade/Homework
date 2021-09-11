package store.products.book;

import store.products.Product;

public class Book extends BookBase {
    private int edition;

    public Book(int id, String name, int price, int amount, Subject subject, int pageNumber, String publisher, int edition) {
        super(id, name, price, amount, subject, pageNumber, publisher);
        this.edition = edition;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }
}
