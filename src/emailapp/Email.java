package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity = 500;
	private int defaultPasswordLength = 10;
	private String alternateEmail;
	private String companySuffix = "company.com";

	// 建立建構子
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
//		System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);

		// 呼叫 詢問部門method
		this.department = setDepartment();
//		System.out.println("Department: " + this.department);

		// 呼叫 隨機密碼method
		this.password = randomPassword(defaultPasswordLength);
//		System.out.println("Password: " + this.password);

		// 建立信箱
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
//		System.out.println("EMAIL: " + email);
	}

	// 詢問部門
	private String setDepartment() {
		System.out.print("選擇部門\n 1銷售\n 2研發\n 3會計\n 0無\n請輸入數字: ");
		Scanner inScanner = new Scanner(System.in);
		int depChoice = inScanner.nextInt();
		if (depChoice == 1) {
			return "sales";
		} else if (depChoice == 2) {
			return "dev";
		} else if (depChoice == 3) {
			return "acct";
		} else {
			return "";
		}

	}

	// 建立隨機密碼
	private String randomPassword(int length) {
		String passwordSet = "QAZWSXEDCRFVTGBYHNUJMIK<OLP!@#$%qazwsxedcrfvtgbyhnujmikolp";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			// charAt(1)會找到passwordSet字串的A字母
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}

	public void setMailboxCapacity(int mailboxCapacity) {
		this.mailboxCapacity = mailboxCapacity;
	}

	public void setAlternateEmail(String alternateEmail) {
		this.alternateEmail = alternateEmail;
	}

	// 更改密碼
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public int getMailboxCapacity() {
		return mailboxCapacity;
	}

	public String getAlternateEmail() {
		return alternateEmail;
	}

	@Override
	public String toString() {
		return " firstName=" + firstName + "\n lastName=" + lastName + "\n password=" + password + "\n department="
				+ department + "\n email=" + email + "\n mailboxCapacity=" + mailboxCapacity
				+ "\n defaultPasswordLength=" + defaultPasswordLength + "\n alternateEmail=" + alternateEmail
				+ "\n companySuffix=" + companySuffix;
	}

}
