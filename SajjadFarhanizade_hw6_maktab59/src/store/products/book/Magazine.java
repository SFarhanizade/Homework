package store.products.book;

public class Magazine extends BookBase {
    private int number;

    public Magazine(int id, String name, int price, Subject subject, int pageNumber, String publisher) {
        super(id, name, price, subject, pageNumber, publisher);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
