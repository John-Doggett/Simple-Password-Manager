import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
	static private File file;
	static private ArrayList<String> list = new ArrayList<String>();
	static private String verificationHash = "d1156e0a96be5a098396bb36c7652c688667b28dfe266bf4a24177091e2a2a57";
	static private String password;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		CommandController controller = new CommandController();
		boolean setup = false;
		
		while(setup == false) {
		try {
			list = new ArrayList<String>();
		System.out.println("What is the file name/location?");
		
		file = new File(scan.nextLine());
		
		System.out.println("What is the passoword?");
		password = scan.nextLine();

		controller = new CommandController(file, list, verificationHash, password);
		controller.setup();
		if(list.size() != 0 && list.get(0).equals(verificationHash)) {
			setup = true;
		}
		}
		catch(Exception e) {
			System.out.println("Error when trying to load password list, please try again.");
		}
		}
		boolean notExited = true;
		while (notExited) {
			System.out.println("Enter your command:");
			String temp = scan.nextLine();
			if(temp.equals("/exit")) {
				notExited=false;
			}
			else {
				controller.execute(temp);
			}
		}
	}

}
