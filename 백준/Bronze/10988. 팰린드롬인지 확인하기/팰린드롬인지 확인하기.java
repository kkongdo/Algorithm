import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) != str.charAt((str.length()-1)-i)) {
				System.out.println(0);
				System.exit(0);
			}
		}
		System.out.println(1);
		
		sc.close();
	}
}