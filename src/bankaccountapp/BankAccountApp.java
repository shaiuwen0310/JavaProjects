package bankaccountapp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

	public static void main(String[] args) {

		/*
		 * Checking chkacc1 = new Checking("TOM", "321456879", 1500); Savings savacc1 =
		 * new Savings("Rich", "456657897", 2500);
		 * 
		 * chkacc1.showInfo(); System.out.println("******"); savacc1.showInfo();
		 */

		// Account就是窩們ㄉ資料結構
		List<Account> accounts = new LinkedList<Account>();

		// 以CSV檔案的資料來建立帳號
		String file = "/home/judy/eclipse-workspace/JavaProjects/NewBankAccounts.csv";
		// utilities.CSV.read() 使用package下的class中的method
		List<String[]> newAccountHolders = utilities.CSV.read(file);
		for (String[] accountHolder : newAccountHolders) {
			String name = accountHolder[0];
			String sSN = accountHolder[1];
			String accountType = accountHolder[2];
			// 字串轉double~
			double initDeposit = Double.parseDouble(accountHolder[3]);
//			System.out.println(name + " " + sSN + " " + accountType + " " + initDeposit);

			// 用accountType判斷數值要儲存到Saving還是Checking物件
			if (accountType.equals("Savings")) {
//				System.out.println("OPEN A SAVING ACCOUNT");
				accounts.add(new Savings(name, sSN, initDeposit));
			} else if (accountType.equals("Checking")) {
//				System.out.println("OPEN A CHECKING ACCOUNT");
				accounts.add(new Checking(name, sSN, initDeposit));
			} else {
				System.out.println("ERROR READING ACCOUNT");
			}
		}
		
		
//		accounts.get(5).showInfo();

		for (Account acc : accounts) {
			System.out.println("************************");
			acc.showInfo();
		}

	}

}
