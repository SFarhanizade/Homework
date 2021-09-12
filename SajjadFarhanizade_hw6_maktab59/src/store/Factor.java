package store;

public class Factor {
    private int id;
    private int totalAmount;
    private int totalPrice;
    private boolean isPaid = false;

    public Factor issueFactor(int id, Object[][] list){
        this.id = id;
        for (int i = 0; i < list.length; i++) {
            if(list[i][1]!=null) {
                totalAmount += Integer.parseInt(list[i][2].toString());
                totalPrice += Integer.parseInt(list[i][3].toString());
            }
        }
        return this;
    }

    public int getId() {
        return id;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}
