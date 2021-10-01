import java.util.Random;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Character> chars1 = new TreeSet<>();
        TreeSet<Character> chars2 = new TreeSet<>();
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            chars1.add((char)(rand.nextInt(25)+97));
            chars2.add((char)(rand.nextInt(25)+97));
        }
        System.out.print("Chars1: ");
        for (char c:chars1)
            System.out.print(c+" ");
        System.out.println();
        System.out.print("Chars2: ");
        for (char c:chars2)
            System.out.print(c+" ");
        System.out.println();
        System.out.print("Union: ");
        for (char c:getUnion(chars1,chars2))
            System.out.print(c+" ");
        System.out.println();
        System.out.print("Intersection: ");
        for (char c:getIntersection(chars1,chars2))
            System.out.print(c+" ");
    }

    static TreeSet<Character> getUnion(TreeSet<Character> chars1, TreeSet<Character> chars2){
        TreeSet<Character> unionChars = new TreeSet<>();
        unionChars.addAll(chars1);
        unionChars.addAll(chars2);
        return unionChars;
    }

    static TreeSet<Character> getIntersection(TreeSet<Character> chars1, TreeSet<Character> chars2){
        TreeSet<Character> intersectionChars = new TreeSet<>();
        for (char c:chars1)
            if(chars2.contains(c))
                intersectionChars.add(c);
        return intersectionChars;
    }
}
