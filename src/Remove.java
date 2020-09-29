import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Removes selected passwords from password list
 * 
 * @author John Doggett
 *
 */
public class Remove implements Command {
	private ArrayList<String> list;

	@Override
	public void exectuteCommand(CommandController control) {
		this.list = control.getList();
		
		for(int a = 1; a < list.size(); a++) {
			System.out.println(a + ": " + list.get(a));
		}

		System.out.println("\nType in which entries you want to remove with a space between each entry:");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		try {
			line = reader.readLine();
		} catch (IOException e) {
			System.out.println("Can't read from terminal! How did this happen?");
		}

		String[] temp = line.split(" ");
		
		for(int a = 0; a < temp.length; a++) {
			if(!temp[0].matches("[-+]?\\\\d*\\\\.?\\\\d+")){
				temp[0] = "-1";
			}
		}
		int num = 0;
		for (int a = 0; a < temp.length; a++) {
			if (Integer.parseInt(temp[a]) != 0 && Integer.parseInt(temp[a]) > 0
					&& Integer.parseInt(temp[a]) < list.size()) {
				num++;
			}
		}
		int[] entriesToRemove = new int[num];

		int position = 0;
		for (int a = 0; a < temp.length; a++) {
			if (Integer.parseInt(temp[a]) != 0 && Integer.parseInt(temp[a]) > 0
					&& Integer.parseInt(temp[a]) < list.size()) {
				entriesToRemove[position] = Integer.parseInt(temp[a]);
				position++;
			}
		}
		Arrays.sort(entriesToRemove);

		String[] removedEntries = new String[num];
		int change = 0;
		for (int a = 0; a < entriesToRemove.length; a++) {
			removedEntries[change] = list.get(entriesToRemove[change] - change);
			list.remove(entriesToRemove[change] - change);
			change++;
		}

		System.out.println(
				"Below are the entries you have removed, please be sure to write out to save your password list.");
		for (int a = 0; a < removedEntries.length; a++) {
			System.out.println(removedEntries[a]);
		}
	}

	public Remove() {
		super();
		// TODO Auto-generated constructor stub
	}

}
