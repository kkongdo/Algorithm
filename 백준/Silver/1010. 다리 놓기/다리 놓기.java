import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp = new int[30][30];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			sb.append(bc(M, N)).append("\n");
		}
		System.out.println(sb);
	}

	private static int bc(int n, int m) {
		if(dp[n][m] > 0) {
			return dp[n][m];
		}
		if(n == m || m == 0) {
			return dp[n][m] = 1;
		}
		return dp[n][m] = bc(n - 1, m - 1) + bc(n - 1, m);
	}
}