import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int answer = Integer.MAX_VALUE;

		int[] memories = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			memories[i] = Integer.parseInt(st.nextToken());
		}

		int[] costs = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			costs[i] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[N][100001];

		for (int i = 0; i < N; i++) {
			int cost = costs[i];
			int memory = memories[i];

			for (int j = 0; j <= 10000; j++) {
				if (i == 0) {
					if (j >= cost)
						dp[i][j] = memory;
				} else {
					if (j >= cost)
						dp[i][j] = Math.max(dp[i - 1][j - cost] + memory, dp[i - 1][j]);
					else
						dp[i][j] = dp[i - 1][j];
				}
				if (dp[i][j] >= M)
					answer = Math.min(answer, j);
			}
		}
		System.out.println(answer);
	}
}
