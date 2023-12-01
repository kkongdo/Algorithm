import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int[N];
		int result = 0;
		for(int i = 0; i <N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < N; i++) {
			int num = nums[i];
			int count = 0;
			for(int j = 1; j <= num; j++) {
				if(num % j == 0) {
					count++;
				}
			}
			if(count == 2) {
				result++;
			}
		}
		System.out.println(result);
	}
}