package store.products.book;

public class Magazine extends BookBase {
    private int number;

    public Magazine(int id, String name, int price, int amount, Subject subject, int pageNumber, String publisher, int number) {
        super(id, name, price, amount, subject, pageNumber, publisher);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
