public class Main{
	public static void main(String[] args){
		FunctionalInterface func = (s) -> s.startsWith(Character.toString(s.charAt(s.length()-1)));
		System.out.println(func.checkIfLastFirstSame("SOS"));
		String tmp = "";
	}
}