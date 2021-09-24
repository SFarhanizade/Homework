import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            System.out.println(oddAddition(2, 4));
            System.out.println(oddAddition(1, 4));
            System.out.println(oddAddition());

        } catch (ExceptionB | NullPointerException exceptionB) {
            System.out.println(exceptionB.getMessage());
        } catch (ExceptionA exceptionA) {
            System.out.println(exceptionA.getMessage());
        }
    }

    static int oddAddition(int... numbers) throws ExceptionA, NullPointerException {
        if(numbers.length==0)
            throw new NullPointerException("Empty List");
        int number = 0;
        for (int num : numbers) {
            if (num % 2 != 0)
                throw new ExceptionA("Not Odd!");
            else
                number += num;
        }
        return number;
    }

    static int divideToFive(int number) throws ExceptionB {
        if (number % 5 == 0)
            return number / 5;
        else
            throw new ExceptionB("Can't be divided by five!");
    }
}