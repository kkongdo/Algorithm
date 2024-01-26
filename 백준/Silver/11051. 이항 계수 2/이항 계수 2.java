import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp;
	public static final int div = 10007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		dp = new int[N + 1][M + 1];
		System.out.println(bc(N, M));
	}
	private static int bc(int n, int m) {
		if(dp[n][m] > 0) {
			return dp[n][m];
			
		}
		if(n == m || m == 0) {
			return dp[n][m] = 1;
		}
		return dp[n][m] = (bc(n - 1, m - 1) + bc(n - 1, m)) % div;
	}
}
