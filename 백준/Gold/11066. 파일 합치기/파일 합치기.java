import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[] sum;
	public static int[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int K = Integer.parseInt(br.readLine());
			sum = new int[K + 2];
			dp = new int[K + 2][K + 2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= K; j++) {
				sum[j] = sum[j - 1] + Integer.parseInt(st.nextToken());
			}
			fileMerge(K);
			System.out.println(dp[1][K]);
		}
	}

	private static void fileMerge(int k) {
		for (int i = 2; i <= k; i++) {
			for (int j = i - 1; j > 0; j--) {
				dp[j][i] = Integer.MAX_VALUE;
				for (int l = j; l <= i; l++) {
					dp[j][i] = Math.min(dp[j][i], dp[j][l] + dp[l + 1][i]);
				}
				dp[j][i] += sum[i] - sum[j - 1];
			}
		}
	}
}