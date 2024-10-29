import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int[5];
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += (int) Math.pow(Integer.parseInt(st.nextToken()), 2);
		}
		System.out.println(sum % 10);
	}
}
