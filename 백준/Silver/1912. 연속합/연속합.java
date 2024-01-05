import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] nums;
	static Integer[] dp;
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		nums = new int[N];
		dp = new Integer[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		dp[0] = nums[0];
		max = nums[0];
		recur(N - 1);
		System.out.println(max);
		
		
	}
	private static int recur(int n) {
		if(dp[n] == null) {
			dp[n] = Math.max(recur(n - 1) + nums[n], nums[n]);
			max = Math.max(dp[n], max);
		}
		return dp[n];
	}
}