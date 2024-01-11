import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int count = 0;
	static Integer[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new Integer[N + 1];
		dp[0] = dp[1] = 0;
		System.out.println(recur(N));
	}

	private static int recur(int n) {
		if(dp[n] == null) {
			if(n % 6 == 0) {
				dp[n] = Math.min(recur(n - 1), Math.min(recur(n / 3), recur(n / 2))) + 1;
			}
			else if(n % 3 == 0) {
				dp[n] = Math.min(recur(n / 3), recur(n - 1)) + 1;
			}
			else if(n % 2 == 0){
				dp[n] = Math.min(recur(n / 2), recur(n - 1)) + 1 ;
			}
			else {
				dp[n] = recur(n - 1) + 1;
			}
		}
		return dp[n];
	}
}
