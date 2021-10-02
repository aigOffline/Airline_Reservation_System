//Aigerim Madakimova: am9634


import java.util.Arrays;

public class TwoDimensionalArray {

	public static void main(String[] args) {
		
		int[][] twoDimArray = new int[2][5];
		int[] arrayOne = {5, 9, 55, 23, 89};
		int[] arrayTwo = {15, 3, 23, 19, 64};

	    for (int i = 0; i < 5; i++) {
            twoDimArray[0][i] = arrayOne[i];
            twoDimArray[1][i] = arrayTwo[i];
            //System.out.print(twoDimArray[0][i] + "-- ");
            //System.out.print(twoDimArray[1][i] + "++ ");
        }
        for (int row = 0; row < twoDimArray.length; row++) {
            for (int col = 0; col < twoDimArray[row].length; col++) {
                System.out.print(twoDimArray[row][col] + " ");
            	System.out.print(" ");
            }
            System.out.println();
        }
		System.out.println("twoDimArray is " + Arrays.deepToString(twoDimArray));
		
		/* copy arrayOne and arrayTwo into twoDimArray */
        /* print out the first list of 5 numbers in twoDimArray
         * on one line, and the second list of 5 numbers in twoDimArray
         * on the next line
         */
        /* the solution should use nested loops: one loop to loop over
         * each array in twoDimArray, and one loop to loop over each element
         * in that array
         */
	}
}
