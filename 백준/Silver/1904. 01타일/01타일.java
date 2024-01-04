import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] dp = new int[1000001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3; i < dp.length; i++) {
			dp[i] = -1;
		}
		System.out.println(dp(num));
	}
	private static int dp(int num) {
		if(dp[num] == -1) {
			dp[num] = (dp(num - 1) + dp(num - 2)) % 15746;
		}
		return dp[num];
	}
}