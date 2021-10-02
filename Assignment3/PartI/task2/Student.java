package task2;
/*Aigerim Madakimova: am9634*/

public class Student {
	private static int nextId;
	private int id;
	private String name;
	private int age;
	private String major;
	
	public Student() {
		this(name:" ", age: 0, major:" ");
	}
	
	public Student() {
		this.name = " ";
		this.age = 0;
		this.major = " ";
		id = nextId;
		nextId++;
	}
	
	public Student(String name, int age, String major) {
		this.name = name;
		this.age = age;
		this.major = major;
		id = nextId;
		nextId++;
	}

	public static boolean hasSameMajor(Student s1, Student s2) {
		return s1.getMajor() == s2.getMajor();
	}

	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getMajor() {
		return major;
	}
	public int getId() {
		return id;
	}
	
	/*==========================================================================*/
	
	public void setName(String aName) {
		name = aName;
	}
	public void setAge(int aAge) {
		age = aAge;
	}
	public void setMajor(String aMajor) {
		major = aMajor;
	}
	
	
	public static double avgAge(Student arr[]) {
		double avg = 0; 
		for(Student s: arr)
			avg += s.getAge();
		return avg/arr.length;
	}
	
	
	public String toString() {
		return getName()+": "+getAge()+", "+getMajor();
	}
	
	public static void main(String[] args) {
		Student s1 = new Student("John", 20, "English");
		Student s2 = new Student("Robert", 22, "Physics");
		
		System.out.println(Student.hasSameMajor(s1, s2));
	
		Student arr[] = {s1,s2};
		System.out.println(Student.avgAge(arr));
		System.out.println(s1.toString());
		System.out.println(s2);
		
		System.out.println(s1.getId());
		System.out.println(s2.getId());

	}

}



