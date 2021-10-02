
import java.util.Scanner;
public class NumberToEnglish 
{
	private static final String[] units = { //array of units
			"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
			"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

	private static final String[] tens = { // array of tens
			"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

	public static String numberToEnglish (int n) {
		if (n < 0)
		{
			return "negative " + numberToEnglish(-n);
		}
		if (n < 20)
		{
			return units[n];
		}

		if (n < 100)
		{
			
			return tens[n/10 - 2] + ((n % 10 != 0) ? " "+ units[n % 10] : "") ;
		}

		if (n < 1000)
		{
			return units[n / 100] + " hundred" + ((n % 100 != 0) ? " "+ numberToEnglish(n % 100) : "");
		}

		if (n < 100000)
		{
			return numberToEnglish(n/1000) + " thousand" + ((n%10000 != 0) ? " "+ numberToEnglish(n % 1000) : "");
		}

  
		if (n < 1000000)
		{
			return numberToEnglish(n/1000) + " thousand" + ((n%1000 != 0) ? " "+numberToEnglish(n % 1000): "");
		}
		else
		{
			return numberToEnglish(n/1000000) + " million" + ((n%1000000 != 0) ? " "+ numberToEnglish(n % 1000000) : "");
		}
	}
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	System.out.print("Enter Number : ");
	int number = in.nextInt();

	System.out.println("The number " + number + " in English is " + NumberToEnglish.numberToEnglish(number));
	
	
	}
}	
