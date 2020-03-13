import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
	static private File file;
	static private ArrayList<String> list = new ArrayList<String>();
	static private String verificationHash = "d1156e0a96be5a098396bb36c7652c688667b28dfe266bf4a24177091e2a2a57";
	static private String password;

	public static void main(String[] args) {
		System.out.println("What is the file name/location?");
		Scanner scan = new Scanner(System.in);
		file = new File(scan.nextLine());
		
		System.out.println("What is the passowrd?");
		password = scan.nextLine();

		CommandController controller = new CommandController(file, list, verificationHash, password);
		controller.setup();
		while (true) {
			System.out.println("Enter your command:");
			scan = new Scanner(System.in);
			String temp = scan.nextLine();
			controller.execute(temp);
		}
	}

}
