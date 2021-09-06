public class Container {
	private int[] numbers = new int[0];
	private String indexesToBeDeleted;
	int IndexesLength;

	public void addNumber(int number) {
		resize();
		numbers[numbers.length - 1] = number;
	}
	
	public int[] getNumbers() {
		return numbers;
	}

	public boolean delNumberByValue(int number) {
		
		for (int i = 0,j = numbers.length - 1; i <= j; i++, j--) {
			if (numbers[i] == number) {
				if (IndexesLength == 0)
					indexesToBeDeleted = "-";
				indexesToBeDeleted += i + "-";
				IndexesLength++;
			}
			if(i==j)
				break;
			if (numbers[j] == number) {
				if (IndexesLength == 0)
					indexesToBeDeleted = "-";
				indexesToBeDeleted += j + "-";
				IndexesLength++;
			}
		}
		if(IndexesLength==0)
			return false;
		applyDelete();
		return true;
	}

	public boolean delNumberByIndex(int index) {
		if(index>=numbers.length)
			return false;
		indexesToBeDeleted = "-" + index + "-";
		IndexesLength = 1;
		applyDelete();
		return true;
	}

	private void applyDelete() {
		if(numbers.length-IndexesLength == 0) {
			numbers = new int[0];
			IndexesLength = 0;
			return;
		}
		int[] newNumbers = new int[numbers.length-IndexesLength];
		for (int i = 0, j =0; i < numbers.length && j<newNumbers.length; i++) {
			if(indexesToBeDeleted.contains("-"+i+"-")) {
				continue;
			}
			newNumbers[j] = numbers[i];
			j++;
		}
		numbers = newNumbers;
		IndexesLength = 0;
	}
	
	private void resize() {
		if(numbers.length==0) {
			numbers = new int[1];
			return;
		}
		int[] newNumbers = new int[numbers.length + 1];
		for (int i = 0; i < numbers.length; i++) {
			newNumbers[i] = numbers[i];
		}
		numbers = newNumbers;
	}

	public int getIndexOf(int number) {
		for (int i = 0; i < numbers.length; i++) {
			if(numbers[i]==number)
				return i;
		}
		return -1;
	}
	
	public int getLastIndexOf(int number) {
		for (int i = numbers.length-1; i >-1; i--) {
			if(numbers[i]==number)
				return i;
		}
		return -1;
	}
	
	public void sortAsc() {
		int temp;
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] > numbers[j]) {
					temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
	}

	public void sortDsc() {
		int temp;
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] < numbers[j]) {
					temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
	}
}
