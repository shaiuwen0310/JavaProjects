package bankaccountapp;

// 1. 由於不會建立Account物件，故將Account抽象化，由繼承Account的class來做建立物件的動作
// 2. abstract class專門用來作為父類別，abstract使Account class不能new物件
// 3. 宣告使用並實作IRate界面
public abstract class Account implements IRate {

	protected String name;
	protected String sSN;
	protected double balance;

	// 所有物件共享index囉～ 所以數值有變動 都會取得新數值～
	protected static int index = 10000;
	protected String accountNumber;
	protected double rate;

	// 有參數ㄉ建構子 set base properties and initialize the account
	public Account(String name, String sSN, double initDeposit) {
		this.name = name;
		this.sSN = sSN;
		this.balance = initDeposit;

		// 建立ACCOUNT NUMBER 無論checking saving都要有ㄉ功能
		index++;
		this.accountNumber = setAccountNumber();

		// 這裡呼叫ㄉ是子類別那邊所建立的方法ㄛ，不同子類別作法不一樣，顯示就會不同
		setRate();

		// IRate的Default Method
//		System.out.println(getRate());
	}

	// abstract class中可以建立abstract method 相對的～繼承之子類別必須去實作這個方法
	public abstract void setRate();

	// 建立帳號，類似一般現實中的帳號一樣，由三組數字組成
	private String setAccountNumber() {
		String lastTwoOfSSN = sSN.substring(sSN.length() - 2, sSN.length());
		int uniqueID = index;
		int ramdomNumber = (int) (Math.random() * Math.pow(10, 3));
		return lastTwoOfSSN + uniqueID + ramdomNumber;
	}

	// 應計利息
	public void compound() {
		double accruedInterset = balance * (rate / 100);
		balance = balance + accruedInterset;
		System.out.println("Accrued Interset: $" + accruedInterset);
		displayBalance();
	}

	// ************ 列出一般交易方法 ************
	public void deposit(double amount) {
		balance = balance + amount;
		System.out.println("你存惹 " + amount + " 元");
		displayBalance();
	}

	public void withdraw(double amount) {
		balance = balance - amount;
		System.out.println("withdrawing $" + amount);
		displayBalance();
	}

	public void transfer(String toWhere, double amount) {
		balance = balance - amount;
		System.out.println("transfering $" + amount + " to " + toWhere);
		displayBalance();
	}
	// ************ 列出一般交易方法 ************

	public void displayBalance() {
		System.out.println("Your balance is now $" + balance);
	}

	public void showInfo() {
		System.out.println("Account [name=" + name + ", sSN=" + sSN + ", balance=" + balance + ", accountNumber=" + accountNumber
				+ ", rate=" + rate + "%" + "]");
	}

	// 大概只能被子類別呼叫ㄛ 因為Account是抽象類別不能建立物件

}
