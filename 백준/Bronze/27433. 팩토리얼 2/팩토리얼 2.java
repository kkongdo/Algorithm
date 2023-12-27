import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long result = factorial(N);
		System.out.println(result);
	}

	private static long factorial(int n) {
		if(n == 0) {
			return 1;
		}
		else if(n > 1) {
			return n * factorial(n - 1);
		}
		return n;
	}
}