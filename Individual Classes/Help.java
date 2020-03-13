
public class Help implements Command {

	@Override
	public void exectuteCommand(CommandController controll) {
		System.out.println("Password Manager V1.0 by John Doggett");
		System.out.println("a (service username password) add to password list");
		System.out.println("h view help and commands");
		System.out.println("p view password list");
		System.out.println("r (beginning end) remove indexes from list from beginning to end index");
		System.out.println("w write out and exit");
	}

	public Help() {
		super();
	}

}
