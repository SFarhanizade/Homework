public class StringToIntConverter {
    public static int convert(String s) {
        if(s.equals(""))
            throw new IllegalArgumentException("The input shouldn't be empty");
        if(s.contains(" "))
            throw new IllegalArgumentException("The input shouldn't have any space");
        return Integer.parseInt(s);
    }
}
