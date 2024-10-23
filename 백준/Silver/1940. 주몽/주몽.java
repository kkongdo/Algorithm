import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		
		int start = 0;
		int end = nums.length - 1;
		int count = 0;
		
		while(start < end) {
			if(nums[start] + nums[end] < M) {
				start++;
			}
			else if(nums[start] + nums[end] > M) {
				end--;
			}
			else {
				count++;
				start++;
				end--;
			}
		}
		System.out.println(count);
	}
}
