import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] dp = new int[15][15];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i <= 14; i++) {
			dp[0][i] = i;
			dp[i][1] = 1;
		}
		
		for(int i = 0; i < T; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			System.out.println(liveHouse(k, n));
		}
	}

	private static int liveHouse(int k, int n) {
		if(dp[k][n] != 0) {
			return dp[k][n];
		}
		dp[k][n] = liveHouse(k, n - 1) + liveHouse(k - 1, n);
		return dp[k][n];
	}
}