import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Remove implements Command {
	private int start;
	private int end;
	private ArrayList<String> list;

	@Override
	public void exectuteCommand(CommandController control) {
		this.list = control.getList();
		
		System.out.println("Type in which entries you want to remove with a space between each entry:");
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		
		String[] temp = line.split(" ");
		int num = 0;
		for(int a = 0; a < temp.length; a++) {
			if(Integer.parseInt(temp[a]) != 0 && Integer.parseInt(temp[a]) > 0 && Integer.parseInt(temp[a]) < list.size()) {
				num++;
			}
		}
		int[] entriesToRemove = new int[num]; 
		
		
		int position = 0;
		for(int a = 0; a < temp.length; a++) {
			if(Integer.parseInt(temp[a]) != 0 && Integer.parseInt(temp[a]) > 0 && Integer.parseInt(temp[a]) < list.size()) {
				entriesToRemove[position] = Integer.parseInt(temp[a]);
				position++;
			}
		}
		Arrays.sort(entriesToRemove);

		String[] removedEntries = new String[num];
		int change = 0;
		for(int a = 0; a < entriesToRemove.length; a++) {
			removedEntries[change] = list.get(entriesToRemove[change] - change);
			list.remove(entriesToRemove[change]-change);
			change++;
		}
		
		System.out.println("Below are the entries you have removed, please be sure to write out to save your password list.");
		for(int a = 0; a < removedEntries.length; a++) {
			System.out.println(removedEntries[a]);
		}
	}

	public Remove() {
		super();
		// TODO Auto-generated constructor stub
	}

}
