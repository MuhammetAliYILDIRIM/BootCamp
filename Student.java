
public class Student {
	String name;
	String surname;
	int number;
	String[] enrolledClasses = new String[3];

	public void enrol() {
		if (enrolledClasses[0] == null) {
			System.out.println("There is not any enrolled class");
		} else {
			for (String className : enrolledClasses) {
				System.out.println(className);
			}
		}

	}

	public void printStudentInfo() {
		if (name == null) {
			System.out.println("There is no information about the student");
		} else {
			System.out
					.println("Student name :" + name + "\nStudent surname ;" + surname + "\nStudent number :" + number);
		}
	}

	Student() {

	}

	Student(String name, String surname, int number) {
		this.name = name;
		this.surname = surname;
		this.number = number;
	}
	
	Student(String name, String surname, int number,String classOne, String classTwo,String classThree) {
		this.name = name;
		this.surname = surname;
		this.number = number;
		enrolledClasses[0]=classOne;
		enrolledClasses[1]=classTwo;
		enrolledClasses[2]=classThree;
		
	}

}
