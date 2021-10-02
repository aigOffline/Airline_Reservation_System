//Aigerim Madakimova: am9634
import java.util.Scanner;

public class Grades {

	public static String letterGrade(double score) {

		if (score >= 90 ) {
			return "A";
		} else if (score >= 80) {
			return "B";
		} else if (score >= 70) {
			return "C";
		} else if (score >= 60) {
			return "D";
		} else if (score <= 59 && score >= 0){
			return "F";
		} else {
			return null;
		}
	}
	
	public static void main(String[] args) {
		
		/* you probably want to use user input for the
		 * score using Scanner because you will have to convert
		 * a command line argument to a float, and we haven't
		 * gotten to string parsing yet
		 * 
		 * But you can also just set the "score" variable
		 * to whatever you want in the code, and that's fine too
		 */
		
		double score = 66.5;
		Scanner in = new Scanner(System.in);
		System.out.print("Enter score: ");
		score = in.nextDouble();
		String grade = letterGrade(score);
		
		// if the grade is not null print this out:
		if (grade != null) {
			System.out.println("The grade for a score of " + score + " is " + grade);
		} else {
			// if the grade is null, print this out:			
			System.out.println("invalid score");
		}
	}
}
