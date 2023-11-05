import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String str = "long ";
		
		for(int i = 1; i < N/4; i++) {
			str += "long ";
		}
		System.out.println(str + "int");
		sc.close();
	}
}