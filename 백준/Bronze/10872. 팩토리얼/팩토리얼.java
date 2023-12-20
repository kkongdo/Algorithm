import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int result = factorial(N);
		System.out.println(result);
	}

	private static int factorial(int n) {
		if(n > 1) {
			return n * factorial(n-1);
		}
		else {
			return 1;
		}
	}
}