import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] nums = new int[N];
		
		st = new StringTokenizer(br.readLine());
		int max = 0;
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			if(max < nums[i]) {
				max = nums[i];
			}
		}
		Arrays.sort(nums);
		System.out.println(uppperBound(nums, max, M));
	}

	private static int uppperBound(int[] nums, int max, int M) {
		int min = 0;
		while(min < max) {
			int mid = (min + max) /2;
			long sum = 0;
			for(int tree : nums) {
				if(tree - mid > 0) {
					sum += (tree - mid);
				}
			}
			if(sum < M) {
				max = mid;
			}
			else {
				min = mid + 1;
			}
		}
		return min - 1;
	}
}