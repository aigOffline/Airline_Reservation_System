import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
 
public class ListOfNumbers {
    private List<Integer> list;
    private static final int SIZE = 10;
 
    public ListOfNumbers () {
        list = new ArrayList<Integer>(SIZE);
        for (int i = 0; i < SIZE; i++)
            list.add(new Integer(i));
    }
    public static void cat(String fileName) {
      RandomAccessFile input = null;
      String line = null;
      File file = new File(fileName);
      try {
          input = new RandomAccessFile(file, "r");
          while ((line = input.readLine()) != null) {
              System.out.println(line);
          }
          return;
          
      
      }
      catch(Exception e) {
    	  e.printStackTrace();
      }
      finally {
          if (input != null) {
              try {
				input.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
          }
      }
  }
    
	public void readList(int values)   {
		FileReader fr=null;
		try {
			fr = new FileReader("numberfile.txt");
			int value;
			while((value = fr.read())!=-1 && values>0) {
				int numericValue = Character.getNumericValue(value);
				if(numericValue != -1) {
					System.out.println(numericValue);
					list.add(numericValue);
					values--;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(fr!=null) {
				try {
					fr.close();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		}
		
	}
  
	public static void main(String[] args) {
	  	ListOfNumbers listOfNumbers = new ListOfNumbers();
	  	ListOfNumbers.cat("numberfile.txt");
	  	System.out.println("read list:");
	  	listOfNumbers.readList(10);
	  	
	  	
	  	
	  }
    
    public void writeList() {
        PrintWriter out = null;
        try {
            System.out.println("Entering try statement");
            out = new PrintWriter(new FileWriter("outFile.txt"));
            for (int i = 0; i < SIZE; i++)
                out.println("Value at: " + i + " = " + list.get(i));
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Caught IndexOutOfBoundsException: " +
                                 e.getMessage());
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            } else {
                System.out.println("PrintWriter not open");
            }
        }
    }
}

 
//public class ListOfNumbers {
//	
//    private List<Integer> list;
//    private String inFile;
// 
//    public ListOfNumbers () {
//        list = new ArrayList<Integer>();
//    }
//    
//
//    public ListOfNumbers (String inFile) {
//    	this();
//    	this.inFile = inFile;	
//    }
//    
//    public void readList() {
//    	
//    }
//    
//    public void writeList() {
//        PrintWriter out = null;
//        try {
//            System.out.println("Entering try statement");
//            out = new PrintWriter(new FileWriter("outFile.txt"));
//            for (int i = 0; i < list.size(); i++)
//                out.println("Value at: " + i + " = " + list.get(i));
//        } catch (IndexOutOfBoundsException e) {
//            System.err.println("Caught IndexOutOfBoundsException: " +
//                                 e.getMessage());
//        } catch (IOException e) {
//            System.err.println("Caught IOException: " + e.getMessage());
//        } finally {
//            if (out != null) {
//                System.out.println("Closing PrintWriter");
//                out.close();
//            } else {
//                System.out.println("PrintWriter not open");
//            }
//        }
//    }
//    
//    public static void cat(String fileName) {
//        RandomAccessFile input = null;
//        String line = null;
//        File file = new File(fileName);
//        try {
//            input = new RandomAccessFile(file, "r");
//            while ((line = input.readLine()) != null) {
//                System.out.println(line);
//            }
//            return;
//        } finally {
//            if (input != null) {
//                input.close();
//            }
//        }
//    }
//    
//    public static void main(String[] args) {
//    	ListOfNumbers listOfNumbers = new ListOfNumbers("numberfile.txt");
//    	ListOfNumbers.cat("numberfile.txt");
//    	listOfNumbers.readList();
//    }
//
//}

