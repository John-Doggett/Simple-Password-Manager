import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Setup implements Command {
	private File file;
	private ArrayList<String> list;
	private String verificationHash;
	private String password;

	@Override
	public void exectuteCommand(CommandController control) {

		this.file = control.getFile();
		this.list = control.getList();
		this.verificationHash = control.getVerificationHash();
		this.password = control.getPassword();

		verifyFileExists(password);
		verifyPassword(password);
		copyPasswordListToArrayList(password);
	}

	private void verifyFileExists(String password) { 
		if (file.exists() == false) {
			try {
				file.createNewFile();
				FileWriter filewriter = new FileWriter(file);
				PrintWriter printwriter = new PrintWriter(filewriter);
				printwriter.print(Brains.encrypt(verificationHash, password));
				printwriter.close();
			} catch (IOException e) {
				System.out.println(
						"Attempted and failed to create Password List and write verification hash! Program detected file did not exist.");
				e.printStackTrace();
			}
		}
	}

	private void verifyPassword(String password) {
		try {
			Scanner scan;
			scan = new Scanner(file);
			if (verificationHash.equals(Brains.decrypt(scan.nextLine(), password)) == false) {
				System.out.println("Password is incorrect!");
				System.exit(0);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File access failed!");
			e.printStackTrace();
		}

	}

	private void copyPasswordListToArrayList(String password) {
		try {
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				list.add(Brains.decrypt(scan.nextLine(), password));
			}
		} catch (FileNotFoundException e) {
			System.out.println("Attemped and failed to copy Password List to ArrayList in RAM!");
			e.printStackTrace();
		}
	}

	public Setup() {
		super();
	}

}
