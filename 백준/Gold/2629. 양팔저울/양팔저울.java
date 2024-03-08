import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, question, max = 15000, arr[];
	static boolean[][] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		dp = new boolean[31][max + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		DP(0, 0);
		StringBuilder sb = new StringBuilder();
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			question = Integer.parseInt(st.nextToken());
			if(question > 15000)
				sb.append("N ");
			else
				sb.append(dp[N][question] ? "Y " : "N ");
		}
		System.out.println(sb);
	}

	private static void DP(int i, int j) {
		if(dp[i][j]) {
			return;
		}
		dp[i][j] = true;
		if(i == N)
			return;
		DP(i + 1, j + arr[i + 1]);
		DP(i + 1, j);
		DP(i + 1, Math.abs(j - arr[i + 1]));
	}
}
