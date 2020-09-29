/**
 * Clears the screen provided the system is POSIX or Windows.
 * 
 * @author John Doggett
 *
 */
public class Clear implements Command {

	@Override
	public void exectuteCommand(CommandController control) {
		try {
			if (System.getProperty("os.name").contains("Windows"))
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // non-POSIX trash!
			else
				Runtime.getRuntime().exec("clear");
		} catch (Exception e) {
			System.out.println("Can't clear the screen, are you running non-POSIX?");
		}
	}

	public Clear() {
		super();
	}

}
