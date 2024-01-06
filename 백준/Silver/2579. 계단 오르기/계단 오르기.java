import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static Integer[] dp; //메모이제이션를 하기 위한 배열
	static int nums[]; //입력한 값을 넣기 위한 배열
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new Integer[N + 1];
		nums = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		dp[0] = nums[0];
		dp[1] = nums[1];
		
		if(N >=2) {
			dp[2] = nums[1] + nums[2];
		}
		System.out.println(find(N));
	}
	private static int find(int n) {
		if(dp[n] == null) {
			dp[n] = Math.max(find(n - 2), find(n - 3) + nums[n - 1]) + nums[n];
		}
		return dp[n];
	}
}