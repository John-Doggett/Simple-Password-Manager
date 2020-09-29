import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
/**
 * Writes the encrypted verification hash and password list to the file
 * 
 * @author John Doggett
 *
 */
public class WriteOut implements Command {
	private File file;
	private String password;
	private ArrayList<String> list;

	public WriteOut() {
		super();
	}

	@Override
	public void exectuteCommand(CommandController control) {
		this.file = control.getFile();
		this.password = control.getPassword();
		this.list = control.getList();
		try {
			PrintWriter pw = new PrintWriter(file);
			for (int a = 0; a < list.size(); a++) {
				pw.println(Brains.encrypt(list.get(a), password));
			}
			pw.close();
			System.out.println("File saved and written to");
		} catch (IOException e) {
			System.out.println("Error when writing out!");
		}
	}

}
