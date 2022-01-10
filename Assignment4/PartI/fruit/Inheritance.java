package fruit;

public class Inheritance {

	public static void main(String[] args) {
		// Here's some scratch space to experiment/debug your Fruit objects
		
		Fruit f = new Fruit("green", false);
		Fruit f2 = new Fruit("green", false);
		Apple apple  = new Apple("tasty", "text", "red", false);
		Apple apple2  = new Apple("tasty2", "text", "red", false);
		Citris citris = new Citris("soure2", "orange", true);
		//citris = new Citris();
		Orange orange = new Orange("type1", "tast1", false);
		orange = new Orange();
		Lemon lemon = new Lemon(1, "tast4", false);
		lemon = new Lemon();
		
		System.out.println(f.toString());
		System.out.println(apple.toString());
		System.out.println(citris.toString());
		System.out.println(orange.toString());
		System.out.println(lemon.toString());

		System.out.println(apple.equals(citris));
		System.out.println(f.equals(f2));
		System.out.println(apple.equals(apple2));
		System.out.println(apple.equals(f));
		

	}

}
