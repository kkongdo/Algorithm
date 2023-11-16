import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = null;
		while(sc.hasNext()) {
			str = sc.nextLine();
			if(str.charAt(0) == ' ') {
				break;
			}
			System.out.println(str);
		}
		
		sc.close();
	}
}