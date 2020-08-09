package examPlacement;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*studentList is a multidimensional String Array which stores students information .
 * 
 * studentList[i][0]=Student name
 * studentList[i][1]=science answers
 * studentList[i][2]=letter answers
 * studentList[i][3]=1.choice
 * studentList[i][4]=2.choice
 * studentList[i][5]=3.choice
 * studentList[i][6]=placed university
 * */
public class ExamPlacement {
	final static String scienceAnswersKey = "ABCDBAEDDACDBEDCABDEDACADEDBAB",
			letterAnswersKey = "BCDABCAEBBADCCAEBADCBADBCADBBE";
	final static String universityName[][] = { { "Izmir University", "IZM" }, { "Istanbul University", "IST" },
			{ "Ankara University", "ANK" } };
	final static int mathMultiple = 3, scienceMultiple = 3, turkishLanguageMultiple = 2, socialMultiple = 1;
	final static int universityVacancy[] = { 3, 5, 4 };
	static double[] sortedScores;
	static int[] sortedIndex;
	static String[][] studentsList;

	public static void main(String[] args) throws IOException {

		double[] studentScores;
		int numberOfStudent = 0;
		File newFile = new File("examPlacement/Student.txt");
		Scanner readFile;
		try {
			readFile = new Scanner(newFile);

			while (readFile.hasNextLine()) {
				readFile.nextLine();
				numberOfStudent++;
			}
			readFile.close();
			readFile = new Scanner(newFile);
			studentScores = new double[numberOfStudent];
			sortedIndex = new int[numberOfStudent];
			studentsList = new String[numberOfStudent][7];
			int count = 0;
			while (readFile.hasNextLine()) {
				String readLine[] = readFile.nextLine().split(";");
				for (int j = 0; j < studentsList[count].length - 1; j++) {
					studentsList[count][j] = readLine[j];
				}

				studentScores[count] = calculateScore(studentsList[count][1], studentsList[count][2]);
				count++;
			}
			readFile.close();
			sortScores(studentScores);
			System.out.println("------------------- Sorted Score List --------------------");
			for (int i = 0; i < numberOfStudent; i++) {
				System.out.format("%-40s%-30s", studentsList[sortedIndex[i]][0], " = " + sortedScores[i]);
				System.out.println();
			}

			placement(studentScores);
			System.out.println("--------------------------------------------------");
			System.out.println("----------------The Final Results-----------------");
			for (int i = 0; i < sortedScores.length; i++) {
				if (studentsList[sortedIndex[i]][6] == null) {
					System.out.format("%-40s%-30s", studentsList[sortedIndex[i]][0], "There isn't a placement ");
					System.out.println();
				} else {
					System.out.format("%-40s%-30s", studentsList[sortedIndex[i]][0], studentsList[sortedIndex[i]][6]);
					System.out.println();
				}
			}
		} catch (Exception e) {
			System.err.print("There is not any student information !");
		}
	}

	static void placement(double[] studentsPoints) {

		for (int i = 0; i < studentsList.length; i++) {
			for (int j = 3; j < 6; j++) {
				if (checkKontenjan(studentsList[sortedIndex[i]][j])) {
					int numberOfBolum = checkUniNumber(studentsList[sortedIndex[i]][j]);
					universityVacancy[numberOfBolum]--;
					studentsList[sortedIndex[i]][6] = universityName[numberOfBolum][0];
					break;
				}
			}
		}
	}

	static boolean checkKontenjan(String bolum) {
		int numberOfBolum = checkUniNumber(bolum);

		if (numberOfBolum == -1) {
			return false;

		} else if (universityVacancy[numberOfBolum] > 0) {
			return true;
		} else
			return false;
	}

	static int checkUniNumber(String uni) {
		int numberOfUni = 0;
		boolean isTrue = false;
		for (int i = 0; i < universityName.length; i++) {
			if (universityName[i][1].equalsIgnoreCase(uni)) {
				numberOfUni = i;
				isTrue = true;
				break;
			}
		}
		if (isTrue)
			return numberOfUni;
		else
			return -1;
	}

	static int checkEqualScore(int i) {
		int howManyEqual = 1;

		while ((i + 1) < sortedScores.length && sortedScores[i] == sortedScores[i + 1]) {
			howManyEqual++;
			i++;
		}

		return howManyEqual;
	}

	static void sortScores(double[] studentPoints) {
		sortedScores = new double[studentPoints.length];
		for (int i = 0; i < studentPoints.length; i++) {
			sortedScores[i] = studentPoints[i];
			sortedIndex[i] = i;
		}

		for (int i = 1; i < studentPoints.length; i++) {
			double key = sortedScores[i];
			int keyTwo = sortedIndex[i];
			int j = i - 1;
			while (j >= 0 && sortedScores[j] < key) {
				sortedScores[j + 1] = sortedScores[j];
				sortedIndex[j + 1] = sortedIndex[j];
				j = j - 1;

			}
			sortedScores[j + 1] = key;
			sortedIndex[j + 1] = keyTwo;
		}
		for (int i = 0; i < sortedScores.length; i++) {

			int count = checkEqualScore(i);
			if (count > 1) {
				for (int j = i; j < i + count; j++) {
					for (int k = j + 1; k < i + count; k++) {
						if (studentsList[sortedIndex[j]][0].compareToIgnoreCase(studentsList[sortedIndex[k]][0]) > 0) {
							int temp = sortedIndex[j];
							sortedIndex[j] = sortedIndex[k];
							sortedIndex[k] = temp;
						}
					}
				}
				i += (count - 1);
			}
		}
	}

	static double calculateScore(String studentScienceAnswers, String studentLetterAnswers) {
		double mathPoint, sciencePoint, turkcePoint, socialPoint;
		mathPoint = mathMultiple
				* checkAnswers(studentScienceAnswers.substring(0, 20), scienceAnswersKey.substring(0, 20));
		sciencePoint = scienceMultiple
				* checkAnswers(studentScienceAnswers.substring(20, 30), scienceAnswersKey.substring(20, 30));
		turkcePoint = turkishLanguageMultiple
				* checkAnswers(studentLetterAnswers.substring(0, 20), letterAnswersKey.substring(0, 20));
		socialPoint = socialMultiple
				* checkAnswers(studentLetterAnswers.substring(20, 30), letterAnswersKey.substring(20, 30));
		return mathPoint + sciencePoint + turkcePoint + socialPoint;
	}

	static double checkAnswers(String studentAnswers, String checkAnswers) {
		double trueAnswers = 0;
		double wrongAnswers = 0;
		for (int i = 0; i < studentAnswers.length(); i++) {
			if (studentAnswers.charAt(i) == ' ') {
				continue;
			} else if (studentAnswers.charAt(i) == checkAnswers.charAt(i)) {
				trueAnswers++;
			} else {
				wrongAnswers++;
			}
		}
		trueAnswers -= (wrongAnswers / 4);

		return trueAnswers;
	}

}