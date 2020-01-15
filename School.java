
public class School {

	public static void main(String[] args) {
		Student studentOne = new Student();
		
		Student studentTwo= new Student("MEHMET", "YILMAZ", 101);
		
		Student studentThree= new Student("ALI", "ASLAN", 102, "MATHMATICS", "SCIENCE", "ART");
		
		studentOne.printStudentInfo();
		
		System.out.println();
		
		studentTwo.printStudentInfo();
		
		System.out.println();
		
		studentThree.printStudentInfo();
	

	}

}
