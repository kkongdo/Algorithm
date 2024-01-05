import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//유클리드 호제법 : 최소공배수와 최대공약수를 구할 때 쓰는 대표적인 알고리즘
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int result = lcm(A, B);
			System.out.println(result); 
		}
	}
	
	//최소공배수(Least Common Multiple)
	private static int lcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}
	//최대공약수(Greatest Common Divisor)
	private static int gcd(int a, int b) {
		if(b == 0) {
			return a;
		}
		else {
			return gcd(b, a % b);
		}
	}
}