import java.io.File;
import java.util.ArrayList;

public class CommandController {
	private File file;
	private ArrayList<String> list;
	private String verificationHash;
	private String password;
	Command help = new Help();;
	Command write = new WriteOut();	
	Command print = new PrintEntries();
	Command remove = new Remove();
	Command add = new Add();
	
	public void execute(String command) {
		if (command.equals("/help")) {
			help.exectuteCommand(this);
		} else if (command.equals("/write")) {
			write.exectuteCommand(this);
		} else if (command.equals("/print")) {
			print.exectuteCommand(this);
		} else if (command.equals("/remove")) {
			remove.exectuteCommand(this);
		} else if (command.equals("/add")) {
			add.exectuteCommand(this);
		} else {
			System.out.println("Command not found!");
			help.exectuteCommand(this);
		}
	}
	
	
	
	public CommandController() {
		super();
		// TODO Auto-generated constructor stub
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
