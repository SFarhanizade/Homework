import java.util.*;

public class Main {

    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = getWords("ABC");/*
        for (String s : hashMap.values())
            System.out.println(s);*/
    }

    static HashMap<Integer, String> getWords(String word) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        int wordNum = getWordsNum(word);
        int[] usedChars = new int[word.length()];
        Arrays.fill(usedChars, -1);
        Random rand = new Random();
        String tempWord = "";
        int counter = 0;
        for (int i = 0; ; ) {
            int randTemp;
            while (true) {
                counter++;
                randTemp = rand.nextInt(word.length());
                if (!contains(usedChars, randTemp))
                    break;
            }
            usedChars[i] = randTemp;
            i++;
            tempWord += word.charAt(randTemp);
            if (tempWord.length() == word.length()) {
                if(hashMap.put(tempWord.hashCode(), tempWord) ==null) {
                    System.out.println(hashMap.size()+"- "+tempWord);
                }
                //input.nextLine();
                tempWord = "";
                i = 0;
                Arrays.fill(usedChars, -1);
                if (hashMap.size() == wordNum)
                    break;
            }
        }
        System.out.println("O(n) --> n = " + counter);
        return hashMap;
    }

    static int getWordsNum(String word) {
        int result = 1;
        for (int i = 1; i <= word.length(); i++) {
            result *= i;
        }
        return result;
    }

    static boolean contains(int[] numbers, int number) {
        for (int num : numbers)
            if (num == number)
                return true;
        return false;
    }
}
