public class StringToIntConverter {
    public static int convert(String s) {
        if(s.equals(""))
            throw new IllegalArgumentException("The input shouldn't be empty");
        return Integer.parseInt(s);
    }
}
