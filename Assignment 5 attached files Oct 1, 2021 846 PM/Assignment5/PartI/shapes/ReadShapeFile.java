import java.io.*;
import java.util.ArrayList;

import shapes.*;

/* your tasks:
 * create a class called ShapeException
 * createShape should throw a ShapeException
 * in main(), you should catch the ShapeException
 * 
 */
public class ReadShapeFile {

	public static GeometricObject createShape(String shapeName) {
		if(shapeName.equals("Circle")) return new Circle();
		else if(shapeName.equals("Rectangle")) return new Rectangle();
		else if(shapeName.equals("Square")) return new Square();
		else {
			throw new ShapeException();
		}
		/* if shapeName is "Circle" return Circle();
		 * if shapeName is "Square" return Square();
		 * if shapeName is "Rectangle" return Rectangle();
		 * if it is not any one of these, it should throw
		 * a ShapeException
		 */
	
	}
	
	public static void main(String[] args) {
		ArrayList<GeometricObject> shapeList = new ArrayList<GeometricObject>();
		File f = new File("shapes.txt");
		
		String inString = null;
		
		/* create a loop to read the file line-by-line */
		BufferedReader br =null;
		try {
			br = new BufferedReader(new FileReader(f));
			while((inString = br.readLine())!=null) {
				try {
					GeometricObject shape = createShape(inString);
					shapeList.add(shape);
				} catch (ShapeException e) {
					System.err.println("Cannot create shape: " + inString);
				}
			}
		}catch(Exception e) {
			
		}
		finally {
			if(br!=null) {
				try {
					br.close();
				} catch (IOException e) {
			
					e.printStackTrace();
				}
			}
		}

		System.out.println(shapeList);
		
		
	}
	
	
}
