import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static Integer[][] dp;
	static int[] W, V;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		dp = new Integer[N][M + 1];
		W = new int[N];
		V = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(find(N - 1, M));
	}

	private static int find(int i, int m) {
		if (i < 0) {
			return 0;
		}
		if (dp[i][m] == null) {
			if (W[i] > m) {
				dp[i][m] = find(i - 1, m);
			} else {
				dp[i][m] = Math.max(find(i - 1, m), find(i - 1, m - W[i]) + V[i]);
			}
		}
		return dp[i][m];
	}
}
