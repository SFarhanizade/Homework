package store.products.clothes.shoes;

import store.products.Product;
import attribute.*;

public class Shoe extends Product {
    private int size;
    private Gender gender;
    private Color color;
    private Material material;

    public Shoe(int id, String name, int price, int size, Gender gender, Color color, Material material) {
        super(id, name, price);
        this.size = size;
        this.gender = gender;
        this.color = color;
        this.material = material;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}