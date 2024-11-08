import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];

		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for (int i = 3; i <= N; i++) {
			if (i >= 3 && dp[i - 3] != Integer.MAX_VALUE) {
				dp[i] = Math.min(dp[i], dp[i - 3] + 1);
			}
			if (i >= 5 && dp[i - 5] != Integer.MAX_VALUE) {
				dp[i] = Math.min(dp[i], dp[i - 5] + 1);
			}
		}

		if (dp[N] == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.print(dp[N]);
		}
	}
}
