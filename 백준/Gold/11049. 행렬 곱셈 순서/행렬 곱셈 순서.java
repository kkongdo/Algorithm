import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp;
	static int[][] nums; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp = new int[n][n];
		nums = new int[n][2];
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			nums[i][0] = Integer.parseInt(st.nextToken());
			nums[i][1] = Integer.parseInt(st.nextToken());
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		System.out.println(multiplyCount(0, n - 1));
	}
	private static int multiplyCount(int start, int end) {
		if(start == end) {
			return 0;
		}
		if(dp[start][end] != Integer.MAX_VALUE) {
			return dp[start][end];
		}
		for(int i = start; i < end; i++) {
			int cost = multiplyCount(start, i) + multiplyCount(i + 1, end) +
					nums[start][0] * nums[i][1] * nums[end][1];
			dp[start][end] = Math.min(dp[start][end], cost);
		}
		return dp[start][end];
	}
}