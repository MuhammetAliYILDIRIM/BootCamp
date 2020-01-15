import java.util.Scanner;

public class Student {
	Student() {

	}

	Student(String name, String surname, int number) {
		this.name = name;
		this.surname = surname;
		this.number = number;
	}

	Student(String name, String surname, int number, String classOne, String classTwo, String classThree) {
		this.name = name;
		this.surname = surname;
		this.number = number;
		String[] classes = { classOne, classTwo, classThree };
		autoenrol(classes);

	}

	String name;
	String surname;
	int number;
	String[] enrolledClasses = new String[3];

	public void autoenrol(String[] classes) {
		for (int i = 0; i < classes.length; i++) {
			enrolledClasses[i] = classes[i];
		}
	}

	public void enrol() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter 3 classes");

		for (int i = 0; i < 3; i++) {
			System.out.println("Enter " + (i + 1) + " nd class");
			enrolledClasses[i] = scan.nextLine();
		}
		scan.close();
	}

	public void printStudentInfo() {
		if (name == null) {
			System.out.println("There is no information about the student");
		} else {
			System.out
					.println("Student name :" + name + "\nStudent surname ;" + surname + "\nStudent number :" + number);
			if (enrolledClasses[0] == null) {
				System.out.println("There is not any enrolled class");
			} else {
				for (String className : enrolledClasses) {
					System.out.println(className);
				}
			}

		}
	}

}
