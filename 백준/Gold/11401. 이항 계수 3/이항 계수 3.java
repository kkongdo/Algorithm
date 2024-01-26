import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//모듈러 연산, 페르마의 소정리
public class Main {
	final static long p = 1000000007L;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long N = Integer.parseInt(st.nextToken());
		long K = Integer.parseInt(st.nextToken());
		
		long num1 = factorial(N);
		long num2 = factorial(K) * factorial(N - K) % p;
		System.out.println(num1 * pow(num2, p - 2) % p);
	}
	private static long pow(long num2, long exp) {
		if(exp == 1) {
			return num2 % p;
		}
		long tmp = pow(num2, exp / 2);
		if(exp % 2 == 1) {
			return (tmp * tmp % p) * num2 % p;
		}
		return tmp * tmp % p;
	}
	
	private static long factorial(long n) {
		long num = 1L;
		while(n > 1) {
			num = (num * n) % p;
			n--;
		}
		return num;
	}
}
