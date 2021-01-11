package studentdatabaseapp;

import java.util.Scanner;

public class StudentDatabaseApp {

	public static void main(String[] args) {

		System.out.print("輸入有幾個新學生要註冊: ");
		Scanner inScanner = new Scanner(System.in);
		int numOfStudent = inScanner.nextInt();
		Student[] students = new Student[numOfStudent];

		for (int i = 0; i < numOfStudent; i++) {
			students[i] = new Student();
			students[i].enroll();
			students[i].payTuition();
		}
		
		for (int i = 0; i < numOfStudent; i++) {
			System.out.println(students[i].toString());
		}
		
	}

}
