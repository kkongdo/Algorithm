import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N + 1];
		int[] dp = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = nums[1];
		if(N > 1) {
			dp[2] = nums[1] + nums[2];
		}
		if(N > 2){
			dp[3] = Math.max(nums[1] + nums[3], nums[2] + nums[3]);
			
		}
		for(int i = 4; i <= N; i++) {
			dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 3] + nums[i - 1] + nums[i]);
		}
		System.out.println(dp[N]);
	}
}
