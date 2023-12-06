import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] nums = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		int result = search(nums, N, M);
		System.out.println(result);
	}

	private static int search(int[] nums, int n, int m) {
		int result = 0;
		
		for(int i = 0; i < n - 2; i++) {
			for(int j = i + 1; j < n - 1; j++) {
				for(int k = j + 1; k < n; k++) {
					int tmp = nums[i] + nums[j] + nums[k];
					if(m == tmp) {
						return tmp;
					}
					if(result < tmp && tmp < m) {
						result = tmp;
					}
				}
			}
		}
		
		return result;
	}
}
