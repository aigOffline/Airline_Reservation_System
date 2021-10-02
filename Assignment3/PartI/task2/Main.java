package task2;

public class Main {

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
