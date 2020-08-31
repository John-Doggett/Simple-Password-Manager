import java.util.ArrayList;

public class PrintEntries implements Command {
	private ArrayList<String> list;

	@Override
	public void exectuteCommand(CommandController control) {
		this.list = control.getList();
		for(int a = 1; a < list.size(); a++) {
			System.out.println(a + ": " + list.get(a));
		}
	}

	public PrintEntries() {
		super();
	}

}
