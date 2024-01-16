import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] nums = new int[N + 1];
		int[] sums = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			sums[i] = nums[i] + sums[i - 1];
		}
		int max = Integer.MIN_VALUE;
		for (int i = M; i <= N; i++) {
			max = Math.max(max, sums[i] - sums[i - M]);
		}
		System.out.println(max);
	}
}