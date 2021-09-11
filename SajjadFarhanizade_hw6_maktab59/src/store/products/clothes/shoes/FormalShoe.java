package store.products.clothes.shoes;

import attribute.Color;
import attribute.Gender;
import attribute.Material;

public class FormalShoe extends Shoe{
    public FormalShoe(int id, String name, int price, int size, Gender gender, Color color, Material material) {
        super(id, name, price, size, gender, color, material);
    }
}
