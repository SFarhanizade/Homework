public class someMethod {
    public static void main(String[] args) {
        someMethod2 someMethod2 = new someMethod2();
        try {
            someMethod2.throwException();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
