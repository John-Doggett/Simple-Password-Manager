import java.io.File;
import java.util.ArrayList;

public class CommandController {
	private File file;
	private ArrayList<String> list;
	private String verificationHash;
	private String password;

	public void execute(String command) {
		if (command.equals("h")) {
			Command temp = new Help();
			temp.exectuteCommand(this);
		} else if (command.equals("w")) {
			Command temp = new WriteOut();
			temp.exectuteCommand(this);
			System.exit(0);
		} else if (command.equals("p")) {
			Command temp = new PrintEntries();
			temp.exectuteCommand(this);
		} else if (command.equals("r")) {
			Command temp = new Remove();
			temp.exectuteCommand(this);
		} else if (command.equals("a")) {
			Command temp = new Add();
			temp.exectuteCommand(this);
		} else {
			System.out.println("Command not found!");
		}
	}
	
	public void setup() {
		Command temp = new Setup();
		temp.exectuteCommand(this);
	}

	public CommandController(File file, ArrayList<String> list, String verificationHash, String password) {
		super();
		this.file = file;
		this.list = list;
		this.verificationHash = verificationHash;
		this.password = password;
	}

	public File getFile() {
		return file;
	}

	public ArrayList<String> getList() {
		return list;
	}

	public String getVerificationHash() {
		return verificationHash;
	}

	public String getPassword() {
		return password;
	}

}
