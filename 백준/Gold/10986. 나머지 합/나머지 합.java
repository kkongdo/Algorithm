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
		long[] nums = new long[N + 1];
		long result = 0;
		long[] count = new long[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			nums[i] = (Integer.parseInt(st.nextToken()) + nums[i - 1]) % M;
			if(nums[i] == 0) {
				result++;
			}
			count[(int)nums[i]]++;
		}
		for(int i = 0; i < M; i++) {
			if(count[i] > 1) {
				result += (count[i] * (count[i] - 1) / 2);
			}
		}
		System.out.println(result);
	}
}