import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] nums;
	static Integer[] dp1;
	static Integer[] dp2;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		nums = new int[N];
		dp1 = new Integer[N];
		dp2 = new Integer[N];
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < N; i++) {
			LIS(i);
			LDS(i);
		}
		int max = -1;
		for(int i = 0; i < N; i++) {
			max = Math.max(dp1[i] +dp2[i], max);
		}
		System.out.println(max - 1);
	}

	private static int LDS(int n) {
		if(dp2[n] == null) {
			dp2[n] = 1;
			for(int i = n + 1; i < dp2.length; i++) {
				if(nums[n] > nums[i]) {
					dp2[n] = Math.max(dp2[n], LDS(i) + 1);
				}
			}
		}
		return dp2[n];
		
	}

	private static int LIS(int n) {
		if(dp1[n] == null) {
			dp1[n] = 1;
			for(int i = n - 1; i >= 0; i--) {
				if(nums[n] > nums[i]) {
					dp1[n] = Math.max(dp1[n], LIS(i) + 1);
				}
			}
		}
		return dp1[n];
	}
}