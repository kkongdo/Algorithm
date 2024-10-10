import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int start = 0, end = 0, sum = 0, answer = Integer.MAX_VALUE;
		
		int[] nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		while(end <= N) {
			if(sum >= S) {
				answer = Math.min(answer, end - start);
				sum -= nums[start++];
			}
			else {
				if(end == N) {
					break;
				}
				sum += nums[end++];
			}
		}
		System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
	}
}
