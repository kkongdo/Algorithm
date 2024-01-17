import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int q = Integer.parseInt(br.readLine());
		int[] nums = new int[str.length() + 1];
		StringTokenizer st;
		
		while(q --> 0) {
			int count = 0;
			st = new StringTokenizer(br.readLine());
			char input = (st.nextToken()).charAt(0);
			for(int i = 1; i <= str.length(); i++) {
				if(str.charAt(i - 1) == input) {
					count++;
				}
				nums[i] = count;
			}
			int i = Integer.parseInt(st.nextToken()) + 1;
			int j = Integer.parseInt(st.nextToken()) + 1;
			if(i == 0) {
				System.out.println(nums[j] - nums[i]);
			}
			else {
				System.out.println(nums[j] - nums[i - 1]);
			}
		}
	}
}