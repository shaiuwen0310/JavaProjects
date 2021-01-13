package bankaccountapp;

// Savings是Account的子類別
public class Savings extends Account {

	// Savings account才會有的欄位
	private int safeDepositBoxID;
	private int safeDepositBoxKey;

	public Savings(String name, String sSN, double initDeposit) {
		super(name, sSN, initDeposit);

		// Savings帳號第一個數字要為1
		accountNumber = "1" + accountNumber;
		setSafeDepositBox();
//		System.out.println("ACCOUNT NUMBER: " + accountNumber);
//		System.out.println("NEW CHECK ACCOUNT");
	}

	private void setSafeDepositBox() {
		// 是double轉intㄛ～ 3次方就3位數 4次方就4位數
		safeDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
		safeDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));
//		System.out.println(safeDepositBoxID);
	}

	public void showInfo() {
		// 呼叫父類別的showInfo()方法
		super.showInfo();
		System.out.println("Your Saving Account features" + "\n Safe Deposit Box ID: " + safeDepositBoxID
				+ "\n Safe Deposit Box KEY: " + safeDepositBoxKey);
	}

	@Override
	public void setRate() {
		rate = getRate() - .15;
	}

}
