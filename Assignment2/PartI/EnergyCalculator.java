//Aigerim Madakimova: am9634
//Aigerim Madakimova: am9634
import java.util.Scanner;

public class EnergyCalculator {

	public static double calculateEnergyIncrease(double mass, double initialVelocity, double finalVelocity) {
		/*double mass = 50;
		double initialVelocity = 10;
		double finalVelocity = 20.0;
		double increasedEnergy = 0.0;
		*/
		double increasedEnergy = 0.0;
		increasedEnergy = 0.5 * mass * finalVelocity * finalVelocity - 0.5*mass*initialVelocity*initialVelocity;
		
		return increasedEnergy;
		
	}
	
	public static void main(String[] args) {
		double mass = 50;
		double initialVelocity = 10;
		double finalVelocity = 20.0;
		double increasedEnergy = 0.0;
		
		
		System.out.println("The object's increase in energy: "
		 		 + calculateEnergyIncrease(mass, initialVelocity,  finalVelocity) + " Joules");
		
	}
}
