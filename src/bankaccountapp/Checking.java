package bankaccountapp;

// Checking是Account的子類別
public class Checking extends Account {

	// Checking account才會有的欄位
	private int debitCardNumber;
	private int debitCardPIN;

	// new Checking會呼叫其建構子，同時也會呼叫父類別無參數的建構子
	public Checking(String name, String sSN, double initDeposit) {
		super(name, sSN, initDeposit);// 若是父類的建構子有參數，就必須加上super

		// Checking帳號第一個數字要為2
		accountNumber = "2" + accountNumber;
		setDebitCard();
//		System.out.println("ACCOUNT NUMBER: " + accountNumber);
//		System.out.println("NEW CHECK ACCOUNT");
	}

	private void setDebitCard() {
		debitCardNumber = (int) (Math.random() * Math.pow(10, 12));
		debitCardPIN = (int) (Math.random() * Math.pow(10, 4));
	}

	public void showInfo() {
		// 呼叫父類別的showInfo()方法
		super.showInfo();
		System.out.println("Your Checking Account features" + "\n Debit Card Number: " + debitCardNumber
				+ "\n Debit Card Pin: " + debitCardPIN);
	}

	// 因為名字一樣所以要tag覆寫
	@Override
	public void setRate() {
		// rate是父類別的變數
		// 由於Account實作IRate，故可呼叫IRate的getRate()方法
		// .15跟0.15是一樣的意思
		rate = getRate() * .15;
	}

}
