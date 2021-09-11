package store;

import store.products.Product;
import store.products.book.Book;
import store.products.book.Magazine;
import store.products.clothes.shoes.FormalShoe;
import store.products.clothes.shoes.SportShoe;
import store.products.electrical.Radio;
import store.products.electrical.Television;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Stock {
    private static Book[] books = new Book[0];
    private static Magazine[] magazines = new Magazine[0];
    private static FormalShoe[] formalShoes = new FormalShoe[0];
    private static SportShoe[] sportShoes = new SportShoe[0];
    private static Television[] televisions = new Television[0];
    private static Radio[] radios = new Radio[0];

    public void addProduct(Product p) {
        if (equals(p)) {
            System.out.println("This product has already existed!");
            return;
        } else {
            Class s = p.getClass();
            if (s == Book.class) {
                books = Arrays.copyOf(books, books.length + 1);
                books[books.length - 1] = (Book) p;
            } else if (s == Magazine.class) {
                magazines = Arrays.copyOf(magazines, magazines.length + 1);
                magazines[magazines.length - 1] = (Magazine) p;
            } else if (s == FormalShoe.class) {
                formalShoes = Arrays.copyOf(formalShoes, formalShoes.length + 1);
                formalShoes[formalShoes.length - 1] = (FormalShoe) p;
            } else if (s == SportShoe.class) {
                sportShoes = Arrays.copyOf(sportShoes, sportShoes.length + 1);
                sportShoes[sportShoes.length - 1] = (SportShoe) p;
            }
            else if (s == Television.class) {
                televisions = Arrays.copyOf(televisions, televisions.length + 1);
                televisions[televisions.length - 1] = (Television) p;
            }else if (s == Radio.class) {
                radios = Arrays.copyOf(radios, radios.length + 1);
                radios[radios.length - 1] = (Radio) p;
            }
        }
    }

    private boolean equals(Product p){
        for (int i = 0; i < books.length; i++) {
            if(books[i].equals(p))
                return true;
        }
        for (int i = 0; i < magazines.length; i++) {
            if(magazines[i].equals(p))
                return true;
        }
        for (int i = 0; i < formalShoes.length; i++) {
            if(formalShoes[i].equals(p))
                return true;
        }
        for (int i = 0; i < sportShoes.length; i++) {
            if(sportShoes[i].equals(p))
                return true;
        }
        for (int i = 0; i < televisions.length; i++) {
            if(televisions[i].equals(p))
                return true;
        }
        for (int i = 0; i < radios.length; i++) {
            if(radios[i].equals(p))
                return true;
        }
        return false;
    }

    private boolean equals(int id){
        for (int i = 0; i < books.length; i++) {
            if(books[i].equals(id))
                return true;
        }
        for (int i = 0; i < magazines.length; i++) {
            if(magazines[i].equals(id))
                return true;
        }
        for (int i = 0; i < formalShoes.length; i++) {
            if(formalShoes[i].equals(id))
                return true;
        }
        for (int i = 0; i < sportShoes.length; i++) {
            if(sportShoes[i].equals(id))
                return true;
        }
        for (int i = 0; i < televisions.length; i++) {
            if(televisions[i].equals(id))
                return true;
        }
        for (int i = 0; i < radios.length; i++) {
            if(radios[i].equals(id))
                return true;
        }
        return false;
    }

}
