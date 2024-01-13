import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static Integer[][] dp;
	static char[] ch1, ch2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ch1 = br.readLine().toCharArray();
		ch2 = br.readLine().toCharArray();
		dp = new Integer[ch1.length][ch2.length];
		System.out.println(LCS(ch1.length - 1, ch2.length - 1));
	}
	private static int LCS(int x, int y) {
		if(x == -1 || y == -1) {
			return 0;
		}
		if(dp[x][y] == null) {
			dp[x][y] = 0;
			if(ch1[x] == ch2[y]) {
				dp[x][y] = LCS(x - 1, y - 1) + 1;
			}
			else {
				dp[x][y] = Math.max(LCS(x - 1, y), LCS(x, y - 1));
			}
		}
		return dp[x][y];
	}
}