import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		str = str.toUpperCase();
		List<Character> list = new ArrayList<Character>();
		
		int[] count;
		for(int i = 0; i < str.length(); i++) {
			if(str.indexOf(str.charAt(i)) == i) {
				list.add(str.charAt(i));
			}
		}
		count = new int[list.size()];
		for(int i = 0; i < list.size(); i++) {
			for(int j = 0; j < str.length(); j++) {
				if(str.charAt(j) == list.get(i)) {
					count[i]++;
				}
			}
		}
		int max = 0, used = 0;
		int location = 0;
		
		for(int i = 0; i < count.length; i++) {
			if(max < count[i]) {
				max = count[i];
				location = i;
			}
		}
		
		for(int i = 0; i < count.length; i++) {
			if(count[i] == max) {
				used++;
			}
		}
		if(used > 1) {
			System.out.println("?");
		}
		else {
			System.out.println(list.get(location));
		}
		
		sc.close();
	}
}