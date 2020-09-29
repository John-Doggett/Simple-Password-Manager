import java.io.File;
import java.util.ArrayList;
/**
 * Executes commands based on what is inputed from UserInterface
 * 
 * @author John Doggett
 *
 */
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
	Command clear = new Clear();

	public void execute(String command) {
		switch (command) { // Hardest Question in Programming
		case "help":
			help.exectuteCommand(this);
			break;
		case "write":
			write.exectuteCommand(this);
			break;
		case "print":
			print.exectuteCommand(this);
			break;
		case "remove":
			remove.exectuteCommand(this);
			break;
		case "add":
			add.exectuteCommand(this);
			break;
		case "clear":
			clear.exectuteCommand(this);
			break;
		default:
			System.out.println("Command not found!");
			help.exectuteCommand(this);
			break;
		}
	}

	public CommandController() {
		super();
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
