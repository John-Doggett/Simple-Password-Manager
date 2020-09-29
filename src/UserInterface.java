import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Contains Main Method. Starts by receiving the file location and password in a
 * loop. Once the list of passwords is successfully loaded it continues in a
 * loop accepting user commands. file is the location of the file that contains
 * the encrypted verification hash and passwords. list is used to store the
 * unencrypted verification hash and passwords. Commands that affect the
 * password list should not access the 0th position of the list, where the
 * verification hash is, only file io should access the entire list.
 * verificationHash is a random string that ensures a file is successfully
 * encrypted. It is checked for successful decryption during setup. It is stored
 * in the 0th position of list. password is the password used for encryption and
 * decryption.
 * 
 * @author John Doggett
 * 
 */
public class UserInterface {
	static private File file;
	static private ArrayList<String> list = new ArrayList<String>();
	static private String verificationHash = "d1156e0a96be5a098396bb36c7652c688667b28dfe266bf4a24177091e2a2a57";
	static private String password;

	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		CommandController controller = new CommandController();
		boolean setup = false;

		while (setup == false) {
			try {
				list = new ArrayList<String>();
				System.out.println("What is the file name/location?");

				file = new File(reader.readLine());
				System.out.println("What is the passoword?");
				password = reader.readLine();
				if (!(password.equals("") || file.getName().equals(""))) {
					controller = new CommandController(file, list, verificationHash, password);
					controller.setup();

					if (list.size() != 0 && list.get(0).equals(verificationHash)) {
						setup = true;
					}
				} else {
					System.out.println("Error when trying to load password list, please try again.");
				}

			} catch (Exception e) {
				System.out.println("Error when trying to load password list, please try again.");
			}
		}
		boolean notExited = true;
		while (notExited) {
			System.out.println("Enter your command:");
			String temp;
			try {
				temp = reader.readLine();
				if (temp.equals("exit")) {
					notExited = false;
				} else {
					controller.execute(temp);
				}
			} catch (IOException e) {
				System.out.println("Can't read from terminal! How did this happen?");
			}

		}
	}

}
