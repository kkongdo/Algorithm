import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static final int MOD = 10007;
	static long[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		dp = new long[N + 1][10];
		for(int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}
		long result = 0;
		for(int i = 0; i < 10; i++) {
			result += recur(N, i);
			result %= MOD;
		}
		System.out.println(result);
	}
	private static long recur(int n, int m) {
		if(dp[n][m] == 0) {
			for(int i = 0; i < 10; i++) {
				for(int j = 0; j <= i; j++) {
					dp[n][i] += recur(n - 1, j);
					dp[n][i] %= MOD;
				}
			}
		}
		return dp[n][m] % MOD;
	}
}