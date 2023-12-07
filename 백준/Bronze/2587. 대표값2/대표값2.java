import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] nums = new int[5];
		int sum = 0;
		for(int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			sum += nums[i] / 5;
		}
		Arrays.sort(nums);
		System.out.println(sum);
		System.out.println(nums[nums.length/2]);
		
	}
}
