public class Main{
	public static void main(String[] args){
		FunctionalInterface func = (num1, num2) -> (num1+num2)/2;
		System.out.println(func.getAvg(12.0,13.0));
	}
}