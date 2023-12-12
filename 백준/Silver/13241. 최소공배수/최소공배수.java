import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
			long A = Integer.parseInt(st.nextToken());
			long B = Integer.parseInt(st.nextToken());
			long result = lcm(A, B);
			System.out.println(result); 
	}

	private static long lcm(long a, long b) {
		return (a * b) / gcd(a, b);
	}

	private static long gcd(long a, long b) {
		if(b == 0) {
			return a;
		}
		else {
			return gcd(b, a % b);
		}
	}
}