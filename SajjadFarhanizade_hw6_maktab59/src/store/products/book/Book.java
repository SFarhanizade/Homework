package store.products.book;

import store.products.Product;

public class Book extends BookBase {
    int edition;

    public Book(int id, String name, int price, Subject subject, int pageNumber, String publisher, int edition) {
        super(id, name, price, subject, pageNumber, publisher);
        this.edition = edition;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }
}
