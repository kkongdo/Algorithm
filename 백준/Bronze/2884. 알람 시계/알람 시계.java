import java.util.Scanner;

public class Main {
	static final int TIME = 45;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int M = sc.nextInt();
		
		int chgH = H * 60;
		int result = 0;
		if(H != 0) {
			result = chgH + M - TIME;
		}
		else if( H >= 0 && M >= TIME) {
			result = chgH + M - TIME;
		}
		else {
			result = 24 * 60 + (M - TIME); 
		}
		System.out.println(result / 60 + " " + result % 60);
		
		sc.close();
	}
}