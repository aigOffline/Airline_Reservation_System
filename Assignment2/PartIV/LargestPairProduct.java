//Aigerim Madakimova: am9634

public class LargestPairProduct {

	public static void main(String[] args) {
		
		int[] intArray = {17, 1, 3, 12, 39, 4, 76, 4, 31, 87};
		int product = Integer.MIN_VALUE;
		//int product = -1;
		for(int i = 0; i < intArray.length; i++) {
			for(int j = i; j < intArray.length; j++ ) {
				
				if(product < (intArray[i] * intArray[j])) {
					
					product = intArray[i] * intArray[j];
				}
			}
		}
		System.out.println("Maximum product of all pairs in the array: " +
				product);
	}
}
