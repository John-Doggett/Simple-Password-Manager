import java.util.ArrayList;
import java.util.Scanner;

public class Add implements Command {
	private ArrayList<String> list;

	@Override
	public void exectuteCommand(CommandController controll) {
		this.list = controll.getList();
		Scanner scan = new Scanner(System.in);
		System.out.println("Adding a new password entry to the list. Begin by typing in the service of your account:");
		String service = "(" + scan.nextLine() + ")";
		System.out.println("Now enter your username:");
		String username = "(" + scan.nextLine() + ")";
		System.out.println("And finally enter your password:");
		String password = "(" + scan.nextLine() + ")";
		String toWrite = service + " " + username + " " + password;
		System.out.println("Added your entry to the password list. Please be sure to write out to save your work! Here is what the entry looks like:\n"+toWrite);
		list.add(toWrite);
	}

	public Add() {
		super();
	}

}
