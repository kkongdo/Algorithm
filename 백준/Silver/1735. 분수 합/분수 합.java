import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a1 = Integer.parseInt(st.nextToken());
		int b1 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int a2 = Integer.parseInt(st.nextToken());
		int b2 = Integer.parseInt(st.nextToken());
		
		int num1 = a1 * b2 + a2 * b1;
		int num2 = b1 * b2;
		
		int num = gcd(num1, num2);
		num1 = num1 / num;
		num2 = num2 / num;
		System.out.println(num1 + " " + num2);
		
	}

	private static int gcd(int num1, int num2) {
		if(num2 == 0) {
			return num1;
		}
		else {
			return gcd(num2, num1 % num2);
		}
	}
}