import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] nums;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		nums = new int[N];
		int[] LIS = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(lowerBound(LIS, N));
	}
	private static int lowerBound(int[] LIS, int N) {
		LIS[0] = nums[0];
		int lengthOfLIS = 1;
		for(int i = 1; i < N; i++) {
			int key = nums[i];
			
			if(LIS[lengthOfLIS - 1] < key) {
				lengthOfLIS++;
				LIS[lengthOfLIS - 1] = key;
			}
			else {
				int low = 0;
				int high = lengthOfLIS;
				
				while(high > low) {
					int mid = (low + high) / 2;
					
					if(LIS[mid] < key) {
						low = mid + 1;
					}
					else {
						high = mid;
					}
				}
				LIS[low] = key;
			}
		}
		return lengthOfLIS;
	}
}