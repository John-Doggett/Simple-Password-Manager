import java.util.ArrayList;
import java.util.Scanner;

public class Remove implements Command {
	private int start;
	private int end;
	private ArrayList<String> list;

	@Override
	public void exectuteCommand(CommandController control) {
		this.list = control.getList();
		Scanner scan = new Scanner(System.in);
		start = scan.nextInt();
		scan = new Scanner(System.in);
		end = scan.nextInt();
		if (start <= 0 || end >= list.size()) {
			System.out.println("Incorrect range for removing!");
			System.exit(0);
		}
		int change = 0;
		for (int a = start; a <= end - change; change++) {
			list.remove(a);
		}
	}

	public Remove() {
		super();
		// TODO Auto-generated constructor stub
	}

}
