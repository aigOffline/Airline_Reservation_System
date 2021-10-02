//Aigerim Madakimova: am9634

public class SumToOneHundred {

	public static void main(String[] args) {
		/* first while loop */
		int sum = 0;
		int counter = 0;
		
		while(true) {
			sum += counter;
			counter++;
			if(sum > 100) break;
		}
		// there should be an error here that says "unreachable code"
		// you need a condition that causes the while loop the exit so you
		// can reach this.
		System.out.println("First sum with break: " + sum);
		/* second while loop */
		
		sum = 0;
		counter = 0;
//ask
		 while (sum < 100) {
		  	sum += counter;
		  	counter++;
		 }
		  
		 
		
		
		System.out.println("Second sum is " + sum);
		
	}
}
