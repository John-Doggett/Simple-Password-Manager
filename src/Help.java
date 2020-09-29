/**
 * Lists commands and their purpose, executed when an unknown command is entered
 * 
 * @author John Doggett
 *
 */
public class Help implements Command {

	@Override
	public void exectuteCommand(CommandController controll) {
		System.out.println("Simple Password Manager V1.2 by John Doggett");
		System.out.println("add add to password list");
		System.out.println("help view help and commands");
		System.out.println("print view password list");
		System.out.println("remove remove indexes from password list");
		System.out.println("write write out to file");
		System.out.println("exit exit manager (be sure to write first to save to file!)");
		System.out.println("clear clear screen");
	}

	public Help() {
		super();
	}

}
