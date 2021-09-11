package store.products;

public class Product {
    private int id;
    private String name;
    private int price;

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

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public boolean equals(Product p) {
        if (p.getClass() == this.getClass())
            return true;
        else if (p.getId() == this.getId())
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
