
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Integer[] num = {3, 7, 9, 2, 5, 5, 8, 5, 6, 3, 4, 7, 3, 1};
        //Integer[] num = new Integer[0];
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.addAll(Arrays.asList(num));
        for (int n : getCorrectList(numbers))
            System.out.print(n + " ");
    }

    static ArrayList<Integer> getCorrectList(ArrayList<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (i + 1 < numbers.size()) {
                if (numbers.get(i) > numbers.get(i + 1)) {
                    numbers.remove(i + 1);
                    numbers.remove(i);
                    i--;
                }
                else
                    i++;
            }
        }
        if(numbers.size()%2!=0)
            numbers.remove(numbers.size()-1);
        return numbers;
    }
}
