import java.util.ArrayList;
import java.util.Scanner;

public class Add implements Command {
	private ArrayList<String> list;

	@Override
	public void exectuteCommand(CommandController controll) {
		this.list = controll.getList();
		Scanner scan = new Scanner(System.in);
		System.out.println("Type Servce Username Password");
		list.add(scan.nextLine());
	}

	public Add() {
		super();
	}

}
