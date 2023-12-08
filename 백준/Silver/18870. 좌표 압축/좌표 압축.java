import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		int[] sorted = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			sorted[i] = nums[i] = Integer.parseInt(st.nextToken()); 
		}
		Arrays.sort(sorted);
		int rank = 0;
		
		HashMap<Integer, Integer> maps = new HashMap<Integer, Integer>();
		for(int num : sorted) {
			if(!maps.containsKey(num)) {
				maps.put(num, rank);
				rank++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int key : nums) {
			sb.append(maps.get(key)).append(" ");
		}
		System.out.println(sb);
	}
}