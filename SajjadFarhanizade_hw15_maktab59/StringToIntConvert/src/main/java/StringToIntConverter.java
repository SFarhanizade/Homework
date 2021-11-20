import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringToIntConverter {
    static final List<String> digits = Arrays.asList("-", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9");

    public static int convert(String s) {
        isNotEmpty(s);
        containsSpace(s);
        List<String> stringItems = convertToList(s);
        isJustNumber(stringItems);
        isValidIfNegative(stringItems);
        isInRange(s);
        return Integer.parseInt(s);
    }

    private static List<String> convertToList(String s) {
        char[] chars = s.toCharArray();
        List<String> stringItems = new ArrayList<>();
        for (char c : chars)
            stringItems.add(String.valueOf(c));
        return stringItems;
    }

    private static boolean isValidIfNegative(List<String> chars) {
        int negatives = chars.stream()
                .filter(s -> s.equals("-"))
                .collect(Collectors.toList())
                .size();
        if (negatives > 1)
            throw new IllegalArgumentException("The input shouldn't have more than one negative sign");
        return (negatives <= 1);
    }

    private static boolean isJustNumber(List<String> chars) {
        int nonNumChars = chars.stream()
                .filter(c -> !digits.contains(c))
                .collect(Collectors.toList())
                .size();
        if (nonNumChars > 0)
            throw new IllegalArgumentException("The input shouldn't have any characters except numbers");
        return true;
    }

    private static boolean isInRange(String s) {
        if (Long.parseLong(s) > 32767 || Long.parseLong(s) < -32767)
            throw new IllegalArgumentException("The number is not within the valid range");
        return true;
    }

    private static boolean isNotEmpty(String s) {
        if (s.isEmpty())
            throw new IllegalArgumentException("The input shouldn't be empty");
        return false;
    }

    private static boolean containsSpace(String s) {
        if (s.contains(" "))
            throw new IllegalArgumentException("The input shouldn't have any space");
        return false;
    }
}
