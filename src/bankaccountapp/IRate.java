package bankaccountapp;

// 匯率跟帳戶不是is a的繼承關係，所以改成介面讓Account去實作
public interface IRate {

	// Java 8導入了Default Methods的特性，為interface的實作方法，好像是跟Lambda有關
	default double getRate() {
		return 2.5;
	}
}
