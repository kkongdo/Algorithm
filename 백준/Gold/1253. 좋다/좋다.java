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
		int count = 0;
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		for(int i = 0; i < N; i++) {
			int start = 0, end = N - 1;
			
			while(start < end) {
				if(start == i) {
					start++;
					continue;
				}
				if(end == i) {
					end--;
					continue;
				}
				int result = nums[start] + nums[end];
				if(result == nums[i]) {
					count++;
					break;
				} else if(result < nums[i]) {
					start++;
				} else {
					end--;
				}
			}
		}
		System.out.println(count);
	}
}