import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int result = 2;
		
		for(int i = 1; i <= N; i++) {
			result = (result - 1) + result;
		}
		System.out.println((int)Math.pow(result, 2));
		sc.close();
	}
}