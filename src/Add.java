import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Adds a new password entry to the password list
 * 
 * @author John Doggett
 *
 */
public class Add implements Command {
	private ArrayList<String> list;

	@Override
	public void exectuteCommand(CommandController controll) {
		try {
		this.list = controll.getList();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Adding a new password entry to the list. Begin by typing in the service of your account:");
		String service = "(" + reader.readLine() + ")";
		System.out.println("Now enter your username:");
		String username = "(" + reader.readLine() + ")";
		System.out.println("And finally enter your password:");
		String password = "(" + reader.readLine() + ")";
		String toWrite = service + " " + username + " " + password;
		System.out.println("Added your entry to the password list. Please be sure to write out to save your work! Here is what the entry looks like:\n"+toWrite);
		list.add(toWrite);
		} catch(IOException e) {
			System.out.println("Can't read from terminal! How did this happen?");
		}
	}

	public Add() {
		super();
	}

}
