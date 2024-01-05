import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			long num = Long.parseLong(br.readLine());
			BigInteger bi = new BigInteger(String.valueOf(num));
			//isProbalePrime() : parameter로는 certainly에 대한 값을 넘겨야함
			//대략 10을 넘기게 되면 해당 값이 소수인지에 대한 판별률이 99.9%에 가까워진다고 함.
			if(bi.isProbablePrime(10)) {
				System.out.println(num);
			}
			else {
				System.out.println(bi.nextProbablePrime());
			}
		}
	}
}
