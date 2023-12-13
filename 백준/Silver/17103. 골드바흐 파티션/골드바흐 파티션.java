import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static boolean[] prime = new boolean[1000001];
	static int size = 1000000;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		getPrime();
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int ans = 0;
			for(int j = 2; j <= N/2; j++) {
				if(!prime[j] && !prime[N - j]) {
					ans++;
				}
			}
			System.out.println(ans);
		}
	}
	
	private static void getPrime() {
		prime[0] = prime[1] = true;
		for(int i = 2; i <= Math.sqrt(size); i++) {
			if(!prime[i]) {
				for(int j = i * i; j <= size; j += i) {
					prime[j] = true;
				}
			}
		}
	}
	
}