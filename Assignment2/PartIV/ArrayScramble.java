//Aigerim Madakimova: am9634

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
public class ArrayScramble {

	public static void main(String[] args) {
		int[] intArray = new int[50];

		System.out.println("original array:");
		/* initialize the source Array */
		for (int i = 0;i < intArray.length; i++) {
			intArray[i] = (int)(Math.random()*100);
			System.out.print(intArray[i] + " ");
		}
		
		System.out.println();
		/*
		Random rand = new Random();
		// scramble here
		for(int i = 0; i < intArray .length; ++i) {
			int index = rand.nextInt(intArray.length - i);
			int tmp = intArray[intArray.length - 1 - i];
			intArray[intArray.length - 1 - i] = intArray[index];
			intArray[index] = tmp;
		      }		
*/
		Random rnd = ThreadLocalRandom.current();
	    for (int i = intArray.length - 1; i > 0; i--)
	    {
	      int index = rnd.nextInt(i + 1);
	      // Simple swap
	      int a = intArray[index];
	      intArray[index] = intArray[i];
	      intArray[i] = a;
	    }
		    
		System.out.println("new arrangement:");
		for (int i = 0;i < intArray.length; i++) {
			System.out.print(intArray[i] + " ");
		}

		System.out.println();
	}
}
