package store.products;

public class Product {
    private int id;
    private String name;
    private int price;
    private int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Product(int id, String name, int price, int amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public boolean equals(Product p) {
        if (p.getId() == this.getId())
            return true;
        return false;
    }

    public boolean equals(int id) {
        if (id == this.getId())
            return true;
        else
            return false;
    }
}
