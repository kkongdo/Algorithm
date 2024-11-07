import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] time = new int[N + 1];
		int[] prices = new int[N + 1];
		int[] dp = new int[N + 2];
		
		StringTokenizer st;
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			prices[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i <= N; i++) {
			if(i + time[i] <= N + 1) {
				dp[i + time[i]] = Math.max(dp[i + time[i]], dp[i] + prices[i]);
			}
			dp[i + 1] = Math.max(dp[i + 1], dp[i]);
		}
		System.out.println(dp[N + 1]);
	}
}
