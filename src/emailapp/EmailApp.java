package emailapp;

public class EmailApp {

	public static void main(String[] args) {
		Email eml = new Email("John", "Smith");
		
		String alternateEmail = "alternate@gmail.com";
		eml.setAlternateEmail(alternateEmail);
//		System.out.println(eml.getAlternateEmail());
		
		System.out.println(eml.toString());
	}

}
