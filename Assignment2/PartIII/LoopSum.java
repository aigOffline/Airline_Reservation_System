
import java.util.Scanner;

public class LoopSum {
        public static int sum100() {
        	int sum = 0;
        	for(int i = 0; i <= 100; i++) {
        		sum += i;
        	}        	
        	return sum;
        }
       
        public static int sumN(int n) {
        	int count = 0;
        	for(int i = 0; i <= n; i++) {
        		count += i;       		
        	}
                return count;
        }
        
        public static void main(String[] args) {
        	System.out.println("Sum of 100: "+sum100());
        	Scanner in = new Scanner(System.in);
        	System.out.print("Enter Number : ");
        	int number = in.nextInt();
        	System.out.println("Sum of 100: "+ sumN(number));
                       
        }        
}
