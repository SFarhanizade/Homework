import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(Arrays.asList("Amir","Hatef","Mehran",
                "Mojtaba","Mohammad","Ali","Davood","Reza","Mohsen"));
        Map<Integer, List<String>> groupedWords =words.stream()
                .collect(Collectors.groupingBy(s -> s.length(),Collectors.mapping(s ->s,Collectors.toList())));
        System.out.println(groupedWords);
    }
}
