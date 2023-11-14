import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine().trim();
		
		int count = 1;
		
		if(str.length() == 0 ) {
			System.out.println(0);
			System.exit(0);
		}
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ' ') {
				count++;
			}
		}
		System.out.println(count);
		
		sc.close();
	}
}