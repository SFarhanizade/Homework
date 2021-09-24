public class Leaf implements Turner{
    private enum colors{ GREEN, YELLOW, ORANGE, RED;
    static colors getColor(int num){
        switch (num){
            case 1:
                return YELLOW;
            case 2:
                return ORANGE;
            case 3:
                return RED;
            default:
                return GREEN;
        }
    }
    }
    private int num;

    @Override
    public void turn() {
        System.out.println(colors.getColor(num));
        if(num<4)
            num++;
        else
            num =0;
    }
}
