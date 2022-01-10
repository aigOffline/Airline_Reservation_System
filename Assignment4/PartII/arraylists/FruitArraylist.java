package arraylists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Spliterators.AbstractDoubleSpliterator;

import fruit.*;

public class FruitArraylist {

	public static void main(String[] args) {
		
		
		
		//Object o = citris;
		//Citris c = (Citris)o;
		//o = apple;
			
		
		
		// this ArrayList MUST be parameterized
		ArrayList<Fruit> fruitArrayList = new ArrayList();
		Random rnd = new Random();
		fruitArrayList.add(new Apple("sweet", "crisp", "red", false));
		fruitArrayList.add(new Apple("tart", "soft", "green", true));
		fruitArrayList.add(new Apple("tart", "soft", "green", true));
		fruitArrayList.add(new Lemon(rnd.nextInt(100), "sour", false));
		fruitArrayList.add(new Lemon(rnd.nextInt(100), "sour", false));
		fruitArrayList.add(new Lemon(rnd.nextInt(100), "sour", false));
		fruitArrayList.add(new Orange("mandarin", "sweet", true));
		fruitArrayList.add(new Orange("mandarin", "sweet", true));

		
		System.out.println("all fruits:");
		for (int i = 0; i < fruitArrayList.size(); i++) {
			Fruit f = fruitArrayList.get(i);
			System.out.println(f.toString());
		}
		double averageSourness= 0;
		int lemonCount=0;
		for (int i = 0; i < fruitArrayList.size(); i++) {
			Fruit f = fruitArrayList.get(i);
			if(f.getClassName().equals("Lemon")) {
				Lemon lemon = (Lemon)f;
				averageSourness+=lemon.getSourness();
				lemonCount++;
			}
		}
		System.out.println("average sourness is "+averageSourness/lemonCount);
		// this is the variable you should retain to compare
		// to the other objects in the arraylist
		Apple rottenGreenApple1 = (Apple)fruitArrayList.get(1);
		
		//equal apple objects:
		System.out.println("equal apples:");
		for (int i = 0; i < fruitArrayList.size(); i++) {
			Fruit f = fruitArrayList.get(i);
			if(f.equals(rottenGreenApple1)) {
				System.out.println(f.toString());
			}
		}
		
		//the same apple object:
		System.out.println("the same:");
		for (int i = 0; i < fruitArrayList.size(); i++) {
			Fruit f = fruitArrayList.get(i);
			if(f == rottenGreenApple1) {
				System.out.println(f.toString());
			}
		}
		
		//remove dublicates
		ArrayList<Fruit> uniqueList = new ArrayList();
		for (int i = 0; i < fruitArrayList.size(); i++) {
			Fruit f = fruitArrayList.get(i);
			if(!uniqueList.contains(f)) {
				uniqueList.add(f);
			}
		}
		fruitArrayList = uniqueList;
		System.out.println("Unique fruits:");
		for (int i = 0; i < fruitArrayList.size(); i++) {
			System.out.println(fruitArrayList.get(i).toString());
		}
	}
}


