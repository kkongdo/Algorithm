import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		System.out.println(pow(A, B));
	}
	private static long pow(long a, long b) {
		if(b == 1) {
			return a % C;
		}
		long tmp = pow(a, b / 2);
		if(b % 2 == 1) {
			return ((tmp * tmp % C) * (a % C)) % C ;
		}
		return tmp * tmp % C;
	}
}
