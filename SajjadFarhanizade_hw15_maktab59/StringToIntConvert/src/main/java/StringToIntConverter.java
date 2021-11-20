import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringToIntConverter {
    static final List<String> digits = Arrays.asList("0","1","2","3","4","5","6","7","8","9");
    public static int convert(String s) {
        if(s.equals(""))
            throw new IllegalArgumentException("The input shouldn't be empty");
        if(s.contains(" "))
            throw new IllegalArgumentException("The input shouldn't have any space");
        char[] chars = s.toCharArray();
        List<String> stringItems = new ArrayList<>();
        for(char c:chars)
            stringItems.add(String.valueOf(c));
        int nonNumChars = stringItems.stream()
                .filter(c -> !digits.contains(c))
                .collect(Collectors.toList())
                .size();
        if(nonNumChars>0)
            throw new IllegalArgumentException("The input shouldn't have any characters except numbers");
        return Integer.parseInt(s);
    }
}
