import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] nums;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		nums = new int[N];
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(nums);
		
		System.out.println(upperBound(N, C));
	}

	private static int upperBound(int N, int C) {
		int min = 1;
		int max = nums[N - 1] - nums[0] + 1;
		while(max > min) {
			int mid = (min + max) / 2;
			if(canInstall(mid) < C) {
				max = mid;
			}
			else {
				min = mid + 1;
			}
		}
		return min - 1;
	}

	private static int canInstall(int mid) {
		int count = 1;
		int lastLocate = nums[0];
		for(int i = 1; i < nums.length; i++) {
			int locate = nums[i];
			if(locate - lastLocate >= mid) {
				count++;
				lastLocate = locate;
			}
		}
		return count;
	}
}