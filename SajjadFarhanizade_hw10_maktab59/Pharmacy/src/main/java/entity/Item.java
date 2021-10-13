package entity;

public class Item {
    private int id;
    private String name;
    private int price;
    private boolean doesExist;

    public boolean isDoesExist() {
        return doesExist;
    }

    public void setDoesExist(boolean doesExist) {
        this.doesExist = doesExist;
    }

    public Item(int id, String name, int price, boolean doesExist) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.doesExist = doesExist;
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
}
