package studentdatabaseapp;

import java.util.Scanner;

public class Student {
	private String firstName;
	private String lastName;
	private int gradeYear;
	private String studentID;
	private String courses;
	private int tuitionBalance;
	// 所有物件都共用同一個costOfCourse變數、id變數
	private static int costOfCourse = 600;
	private static int id = 1000;

	// 建構子中 提示使用者輸入學生資訊
	public Student() {
		// 如果用try包住，使用new Class建立兩個Student物件時就會出錯
		Scanner inScanner = new Scanner(System.in);
		System.out.print("輸入學生的firstName: ");
		this.firstName = inScanner.nextLine();

		System.out.print("輸入學生的lastName: ");
		this.lastName = inScanner.nextLine();

		System.out.print(" 1 - freshmen\n 2 - sophmore\n 3 - junior\n 4 - senior\n 輸入學生的class level: ");
		this.gradeYear = inScanner.nextInt();

		setStudentID();

//		System.out.println(firstName + " " + lastName + " " + gradeYear + " " + studentID);

	}

	// 建立學生ID
	private void setStudentID() {
		id = id + 1;
		this.studentID = gradeYear + "" + id;
	}

	// 註冊課程
	public void enroll() {
		// 不斷註冊
		do {
			System.out.print("Enter course to enroll (Q to quit): ");
			Scanner inScanner = new Scanner(System.in);
			String course = inScanner.nextLine();
			// 不可以用!= 會不對
			if (!course.equals("Q")) {
				courses = courses + "\n" + course;
				tuitionBalance = tuitionBalance + costOfCourse;
			} else {
//				System.out.println("BREAK!");
				break;
			}
		} while (1 != 0); // true應該也可以

		System.out.println("enrolled in: " + courses);
//		System.out.println("tuition Balance" + tuitionBalance);
	}

	public void viewBalance() {
		System.out.println("Your balance is:" + tuitionBalance);
	}

	// 付學費
	public void payTuition() {
		viewBalance();
		System.out.print("輸入你的payment: ");
		Scanner inScanner = new Scanner(System.in);
		int payment = inScanner.nextInt();
		tuitionBalance = tuitionBalance - payment;
		System.out.println("Thanks for you payment of $" + payment);
		viewBalance();
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", gradeYear=" + gradeYear
				+ ", studentID=" + studentID + ", courses=" + courses + ", tuitionBalance=" + tuitionBalance + "]";
	}
	
	

}
