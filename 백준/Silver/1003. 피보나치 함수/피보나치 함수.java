import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static Integer[][] dp = new Integer[41][2];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		dp[0][0]= dp[1][1] = 1;
		dp[0][1] = dp[1][0] = 0;
		
		while(T-->0) {
			int num = Integer.parseInt(br.readLine());
			fibonacci(num);
			System.out.println(dp[num][0] + " " + dp[num][1]);
		}
	}
	private static Integer[] fibonacci(int num) {
		if(dp[num][0] == null || dp[num][1] == null) {
			dp[num][0] = fibonacci(num - 1)[0] + fibonacci(num - 2)[0];
			dp[num][1] = fibonacci(num - 1)[1] + fibonacci(num - 2)[1];
		}
		return dp[num];
	}
}