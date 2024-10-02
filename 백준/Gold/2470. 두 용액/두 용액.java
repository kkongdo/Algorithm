import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int[N];
		
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		int start = 0, end = N - 1;
		int min = Integer.MAX_VALUE;
		int[] answer = new int[2];

		while (start < end) {
			int sum = nums[start] + nums[end];
			if (Math.abs(sum) < min) {
				min = Math.abs(sum);
				answer[0] = nums[start];
				answer[1] = nums[end];
			} else if(sum > 0) {
				end--;
			}else {
				start++;
			}
		}
		System.out.println(answer[0] + " " + answer[1]);

	}
}