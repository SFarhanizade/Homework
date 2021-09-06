import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		// System.out.println(isPrime(97));
		//container();
		
	}

	
	//1
	static boolean isPrime(int number) {
		for (int i = 2; i < number; i++) {
			if (number % i == 0)
				return false;
		}
		return number > 1;
	}

	//2
	static void container() {
		Container container = new Container();
		while (true) {
			System.out.println("\n\n1-Add Numbers");
			System.out.println("2-Sort Numbers");
			System.out.println("3-Delete Numbers");
			System.out.println("4-Search Numbers");
			System.out.println("5-Show Numbers");
			int menu = input.nextInt();
			input.nextLine();
			switch (menu) {
			case 1: {
				int number;
				System.out.println("Enter the numbers (Letter to Finish)");
				while (true) {
					try {
						number = input.nextInt();
						container.addNumber(number);
					} catch (Exception e) {
						System.out.println("Ended!");
						input.nextLine();
						break;
					}
				}
				break;
			}
			case 2: {
				System.out.println("\n1-Ascending");
				System.out.println("2-Descending");
				switch (input.nextInt()) {
				case 1: {
					container.sortAsc();
					break;
				}
				case 2: {
					container.sortDsc();
					break;
				}
				}
				break;
			}
			case 3: {
				System.out.println("\n1-By Value");
				System.out.println("2-By Index");
				switch (input.nextInt()) {
				case 1: {
					System.out.print("Enter the number to be deleted: ");
					if (container.delNumberByValue(input.nextInt()))
						System.out.println("Deleted!");
					else
						System.out.println("Number not found!");						
					break;
				}
				case 2: {
					System.out.print(
							"Enter the index to be deleted(" + 0 + "-" + (container.getNumbers().length - 1) + "): ");
					if (container.delNumberByIndex(input.nextInt()))
						System.out.println("Deleted!");
					else
						System.out.println("Index is out of Rrange");
					break;
				}
				}
				break;
			}
			case 4: {
				System.out.print("Enter the number: ");
				int number = input.nextInt();
				int index = container.getIndexOf(number);
				int lastIndex = container.getLastIndexOf(number);
				if (index == -1) {
					System.out.println("Number not found!");
					break;
				}
				if (index == lastIndex)
					System.out.println("Index: "+index);
				else
					System.out.println("Index: " + index + "\nLast Index: " + lastIndex);
				break;
			}
			case 5: {
				System.out.println(Arrays.toString(container.getNumbers()));
				break;
			}
			}
		}
	}

}
