import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] nums;
	static Integer[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		nums = new int[N];
		dp = new Integer[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < N; i++) {
			find(i);
		}
		
		int max = dp[0];
		
		for(int i = 1; i < N; i++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}
	private static int find(int num) {
		if(dp[num] == null) {
			dp[num] = 1;
			for(int i = num - 1; i >= 0; i--) {
				if(nums[i] < nums[num]) {
					dp[num] = Math.max(dp[num], find(i) + 1);
				}
			}
		}
		return dp[num];
	}
}
