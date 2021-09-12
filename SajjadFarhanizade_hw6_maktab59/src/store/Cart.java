package store;

import store.products.Product;

public class Cart {
    private Object[][] list = new Object[5][4];
    private int lastIndex;
    private Factor factor = new Factor();

    public void addToCart(Product product, int amount){
        if(lastIndex<5){
            list[lastIndex][0] = lastIndex+1;
            list[lastIndex][1] = product;
            list[lastIndex][2] = amount;
            list[lastIndex][3] = product.getPrice()*amount;
            lastIndex++;
        }
        else{
            System.out.println("The cart is full!");
            return;
        }
    }
    public void removeFromCart(int lastIndex){
        if(lastIndex<5 && lastIndex>0){
            list[lastIndex-1] = null;
            this.lastIndex--;
            resize();
        }
        else{
            System.out.println("The cart is empty!");
            return;
        }
    }

    public Factor getFactor(int id) {
        id *= lastIndex + 1;
        return factor.issueFactor(id, list);
    }

    @Override
    public String toString() {
        String strList = "";
        for (int i = 0; i < lastIndex; i++) {
            strList += list[i][0] +"- "+((Product)list[i][1]).getName() + " | BasePrice "+((Product)list[i][1]).getPrice() +
                    " | Amount " + list[i][2] + " | Price " + list[i][3]+"\n";
        }
        return strList;
    }


    private void resize(){
        Object[][] newList = new Object[5][4];
        for (int i = 0, j = 0; i < newList.length & j<list.length; j++) {
            if (list[j] != null) {
                newList[i] = list[j];
                newList[i][0] = i+1;
                i++;
            }
        }
        list = newList;
    }

}
